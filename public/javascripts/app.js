var user = { "name": 'Cbi', "loggedin": true, "avatar": 'images/avatars/avatar1.png' };
var ars = [{ "name":"AR1", "desc":"blabladesc 1", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR2", "desc":"Holderadio 2", "smells":[{"id":2,"name":"Smell2"},{"id":5,"name":"Smell5"}] }, { "name":"AR3", "desc":"Auto Velo 3", "smells":[{"id":2,"name":"Smell2"},{"id":7,"name":"Smell7"}] }, { "name":"AR4", "desc":"blabladesc 1", "smells":[{"id":2,"name":"Smell2"},{"id":6,"name":"Smell6"}] }, { "name":"AR5", "desc":"Holderadio 2", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR6", "desc":"Auto Velo 3", "smells":[{"id":3,"name":"Smell3"},{"id":5,"name":"Smell5"}] }, { "name":"AR7", "desc":"blabladesc 1", "smells":[{"id":3,"name":"Smell3"},{"id":4,"name":"Smell4"}] }, { "name":"AR8", "desc":"Holderadio 2", "smells":[{"id":4,"name":"Smell4"},{"id":7,"name":"Smell7"}] }, { "name":"AR9", "desc":"Auto Velo 3", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }];
var app = angular.module('art', ['ui.bootstrap','angular-jqcloud','ngResource','ngSanitize','ui.select','ngNotificationsBar','textAngular']);

var setSmell = function(smell){ 
    var input = $('#smellname');
    input.val(smell);
    input.trigger('input');
};

app.filter('limitHtml', function() {
    return function(text, limit) {

        var changedString = String(text).replace(/<[^>]+>/gm, '');
        var length = changedString.length;

        return changedString.length > limit ? changedString.substr(0, limit - 1) : changedString; 
    }
});

app.config(['notificationsConfigProvider', function (notificationsConfigProvider) {
    notificationsConfigProvider.setAutoHide(true);
    notificationsConfigProvider.setHideDelay(5000);
    notificationsConfigProvider.setAcceptHTML(true);
}]);

app.config(['$provide', function($provide){
    $provide.decorator('taOptions', ['$delegate', function(taOptions){
        taOptions.toolbar = [
            ['h1', 'h2', 'h3', 'h4', 'h5', 'h6', 'p', 'pre'],
            ['bold', 'italics', 'underline', 'ul', 'ol', 'redo', 'undo', 'clear'],
            ['html', 'insertLink']
        ];
        return taOptions;
    }]);
}]);

app.controller('UserController', ['notifications', function(notifications){
    this.user = user;
    this.login = function() {
        this.user.loggedin = true;
        notifications.showSuccess("Logged in");
    }
    this.logout = function() {
        this.user.loggedin = false;
        notifications.showSuccess("Logged out");
    }
}]);

app.controller('MenuController', ['MenuService', 'notifications', '$scope', function(MenuService, notifications, $scope){
    $scope.menuItems = [];
    $scope.licenseFile = 'APACHE-LICENSE-2.0.txt';
    MenuService.get({},function(data, status, headers, config) {
        $scope.menuItems = data;
    }, function(error, status, headers, config) {
        notifications.showError("Failed to load Menu.");
    }); 
    $scope.menuItem = 'smellasses.html';
    $scope.setMenu = function(selectedMenu) {
        $scope.menuItem = selectedMenu + '.html';
    };

    $scope.isMenuSet = function(isSet) {
        return isSet === $scope.menuItem;
    };
}]);

app.controller('ARController', ['CloudSmells','notifications','$scope','$filter', function(CloudSmells, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.arlist = ars;
    this.formvisible = true;
    $scope.words = [];
    //$scope.words = words;
    $scope.cloudcallstatus = '&nbsp;<i class="glyphicon glyphicon-refresh glyphicon-refresh-animate"/> Loading...';

    this.loadCloud = function () {
        CloudSmells.get().success(function(data,status,headers,config){
            $scope.words = eval(data);
            $scope.cloudcallstatus = "OK";
        }).error(function(data,status,headers,config){
            $scope.cloudcallstatus = "NOK";
            notifications.showError("Failed to load SmellCloud")
        });
    }
    this.loadCloud();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.order = function(predicate, reverse) {
        $scope.arlist = orderBy($scope.arlist, predicate, reverse);
    };
    $scope.order('name', false);

    $scope.setSmellFilter = function(smell) {
        //alert('Hell0');
        $scope.search.smells.name = smell;
        $scope.order();
    }

    this.ar = {};
    /*this.addAr = function() {
            this.ar.createdOn = Date.now();
            this.arlist.push(this.ar);
            this.ar = {};
        };*/

    $scope.totalItems = 64;
    $scope.currentPage = 4;

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
        $log.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.maxSize = 5;
    $scope.bigTotalItems = 175;
    $scope.bigCurrentPage = 1;


    this.progMax = 200;

    this.setProgValue = function() {

        this.progStacked = [];
        var types = ['success', 'info', 'warning', 'danger'];

        for (var i = 0, n = Math.floor((Math.random() * 4) + 1); i < n; i++) {
            var index = Math.floor((Math.random() * 4));
            this.progStacked.push({
                value: Math.floor((Math.random() * 30) + 1),
                type: types[index]
            });
        }
        /*       
            var value = Math.floor((Math.random() * 100) + 1);
            var type;

            if (value < 25) {
                type = 'success';
            } else if (value < 50) {
                type = 'info';
            } else if (value < 75) {
                type = 'warning';
            } else {
                type = 'danger';
            }

            this.showProgWarning = (type === 'danger' || type === 'warning');

            this.progDynamic = value;
            this.progType = type;
            */
    };
    this.setProgValue();


}]);

app.controller('SmellController', ['SmellsService','SmellService', 'GroupService','notifications','$scope','$filter','$modal', function(SmellsService, SmellService, GroupService, notifications, $scope, $filter, $modal) {
    var orderBy = $filter('orderBy');
    $scope.smelllist = [];
    this.formvisible = true;
    $scope.groups = [];
    $scope.loadGroups = function () {
        GroupService.get({cat: "SmellGroups"},function(data, status, headers, config) {
            $scope.groups = data;
            //$scope.smellcallstatus = "OK";
        }, function(error, status, headers, config) {
            //$scope.smellcallstatus = "NOK";
            notifications.showError("Failed to load SmellsGroups.");
        });  
    };
    $scope.loadGroups();

    $scope.smellcallstatus = "not yet called";

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.loadSmells = function () {
        SmellsService.get({},function(data, status, headers, config) {
            $scope.smelllist = data;
            //$scope.smellcallstatus = "OK";
        }, function(error, status, headers, config) {
            //$scope.smellcallstatus = "NOK";
            notifications.showError("Failed to load Smells.");
        });  
    };
    $scope.loadSmells();

    $scope.deleteSmell = function (id) {
        SmellService.delete({id: id},function(data, status, headers, config) {
            //$scope.smelllist = data;
            $scope.smellcallstatus = "OK";
            $scope.loadSmells();
            notifications.showSuccess("Smell has been deleted.");
        }, function(error, status, headers, config) {
            $scope.smellcallstatus = "NOK";
            notifications.showSuccess("Failed to delete Smell.");
        });
    };

    $scope.order = function(predicate, reverse) {
        $scope.smelllist = orderBy($scope.smelllist, predicate, reverse);
    };
    $scope.order('name', false);

    $scope.smell = {};
    $scope.saveSmell = function() {
        SmellsService.create($scope.smell,function(data, status, headers, config) {
            //$scope.smelllist = data;
            //$scope.smellcallstatus = "OK";
            $scope.loadSmells();
            notifications.showSuccess("Smell has been added.");
        }, function(error, status, headers, config) {
            //$scope.smellcallstatus = "NOK";
            notifications.showError("Failed to add Smell.");
        });  
        $scope.smell = {};
    };

    $scope.openSmell = function(id) {
        var modalInstance = $modal.open({templateUrl: _contextPath + 'smelldialog.html', controller: 'SmellUpdateController', size: 'lg', resolve: {
            smellid: function () {
                return id;
            }
        }});

        modalInstance.result.then(function () {
            $scope.loadSmells();
        }, function () {
            //notifications.showSuccess("Smell closed");
        });
    };

    $scope.totalItems = 64;
    $scope.currentPage = 4;

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.pageChanged = function() {
        $log.log('Page changed to: ' + $scope.currentPage);
    };

    $scope.maxSize = 5;
    $scope.bigTotalItems = 175;
    $scope.bigCurrentPage = 1;
}]);

app.controller('SmellUpdateController', ['SmellService', 'GroupService', 'StatusService', 'notifications', '$modalInstance', '$scope', 'smellid', function (SmellService, GroupService, StatusService, notifications, $modalInstance, $scope, smellid) {
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, function(error, status, headers, config) {
            notifications.showError("Failed to load Status.");
        });  
    };
    $scope.loadStatus();
    $scope.singleSmell = [];
    $scope.groups = [];
    $scope.loadGroups = function () {
        GroupService.get({cat: 'SmellGroups'},function(data, status, headers, config) {
            $scope.groups = data;
        }, function(error, status, headers, config) {
            notifications.showError("Failed to load SmellsGroups.");
        });  
    };
    $scope.loadGroups();
    $scope.getSmell = function (smellid) {
        SmellService.get({id: smellid},function(data, status, headers, config) {
            $scope.singleSmell = data;
        }, function(error, status, headers, config) {
            notifications.showError("Failed to load Smell.");
        });  
    };
    $scope.getSmell(smellid);

    $scope.updateSmell = function() {
        SmellService.update({id: $scope.singleSmell.id}, $scope.singleSmell,function(data, status, headers, config) {
            $modalInstance.close();
            notifications.showSuccess("Smell has been updated.");
        }, function(error, status, headers, config) {
            notifications.showError("Failed to update Smell.");
        });  
        $scope.smell = {};
    };

    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        modalInstance.dismiss('cancel');
    };
}]);

app.controller("ExecTaskTypeController", ['ExecTaskTypesService', 'ExecTaskTypeService', 'EmptyExecTaskTypeService', 'notifications', '$scope', function(ExecTaskTypesService, ExecTaskTypeService, EmptyExecTaskTypeService, notifications, $scope) {
    $scope.exectypes = [];
    this.emptyexectype = [];
    $scope.loadExecTaskTypes = function() {
        ExecTaskTypesService.get({},function(data, status, headers, config) {
            $scope.exectypes = data;
        }, function(error, status, headers, config) {
            notifications.showError("Failed to load ExecutionTaskTypes.");
        });
    };
    $scope.loadExecTaskTypes();

    EmptyExecTaskTypeService.get({},function(data, status, headers, config) {
        $scope.emptyexectype = data;
    }, function(error, status, headers, config) {
        notifications.showError("Failed to load EmptyExecutionTaskTypes.");
    }); 

    $scope.delete = function(task) {
        task.subTasks = [];
    };

    /*$scope.deleteCurrent = function(subTasks, task) {
        var index = subTasks.indexOf(task);
        subTasks.splice(index,1);
    };*/

    $scope.hasChildren = function(task) {
        return task.subTasks.length > 0;
    }


    $scope.add = function(task) {
        var post = task.subTasks.length + 1;
        var newName = task.name + '-' + post;
        task.subTasks.push(angular.copy(this.emptyexectype));
    };

    $scope.save = function() {
        ExecTaskTypeService.update({id: $scope.exectypes[0].id}, $scope.exectypes, function(data, status, headers, config) {
            $scope.emptyexectype = data;
            notifications.showSuccess("Exec Task Types have been saved.");
        }, function(error, status, headers, config) {
            notifications.showError("Failed to update Exec Task Types.");
        });  
    }
}]);