var app = angular.module('art', ['ui.router','ui.bootstrap','angular-jqcloud','ngResource','ngSanitize','ui.select','ngNotificationsBar','textAngular']);

var setSmell = function(smell){ 
    var input = $('#smellname');
    input.val(smell);
    input.trigger('input');
};

app.controller('UserController', ['UserService', 'ReplyErrorHandler', 'notifications','$scope', '$state','currentUser', function(UserService, ReplyErrorHandler, notifications, $scope, $state, currentUser){
    $scope.logindata = {"email":"cbisig@hsr.ch","password":"test"};
    $scope.user = currentUser.profile;
    $scope.login = function() {
        UserService.login.login($scope.logindata,function(data, status, headers, config) {
            currentUser.profile = data;
            notifications.showSuccess("Logged in");
            $scope.logindata = {"email":"","password":""};
            $scope.loginform.$setPristine();
            if(currentUser.profile.startpage == "stay") {
                $state.go($state.current, {}, {reload: true});
                //$state.reload();
            } else {
                $state.go(currentUser.profile.startpage);
            }
        }, ReplyErrorHandler);
    };
    $scope.logout = function() {
        UserService.logout.logout($scope.logindata,function(data, status, headers, config) {
            notifications.showSuccess("Logged out");
            $scope.logindata = {"email":"","password":""};
            currentUser.profile = null;
            $state.go('home');
        }, ReplyErrorHandler);
    };
}]);

app.controller('UserProfileController', ['UserService', 'RolesService', 'AvatarUploader', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope','currentUser', function(UserService, RolesService, AvatarUploader, ReplyErrorHandler, PasswordValidator, notifications, $scope, currentUser){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user;
    $scope.pw;
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data, status, headers, config) {
        $scope.roles = data;
    }, ReplyErrorHandler);
    
    UserService.id.get({id: currentUser.profile.id},function(data, status, headers, config) {
        $scope.user = data;
    }, ReplyErrorHandler);
    
    $scope.updateProfile = function() {
        UserService.noid.update({},$scope.user,function(data, status, headers, config) {
            notifications.showSuccess("Profile saved successful.");
        }, ReplyErrorHandler);
    }
    
    $scope.changePassword = function() {
        UserService.pw.update({},$scope.pw,function(data, status, headers, config) {
            notifications.showSuccess("Password has been changed.");
            $scope.pw = null;
            $scope.pwUpdateForm.$setPristine();
        }, ReplyErrorHandler);
    }
    
    $scope.uploadAvatar = function() {
        AvatarUploader.upload($scope.avatarimage).success(function(data,status,headers,config){
            notifications.showSuccess("Avatar image has been uploaded.");
            currentUser.profile.avatar = data;
            $scope.avatarimage = null;
        }).error(function(data,status,headers,config){
            notifications.showError("Failed to upload avatar image");
        });;
    }
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);

app.controller('UserCreateController', ['UserService', 'RolesService', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope', '$state', function(UserService, RolesService, ReplyErrorHandler, PasswordValidator, notifications, $scope, $state){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user;
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data, status, headers, config) {
        $scope.roles = data;
    }, ReplyErrorHandler);
    
    $scope.updateProfile = function() {
        UserService.noid.create({},$scope.user,function(data, status, headers, config) {
            notifications.showSuccess("User has been created.");
            $state.go('home');
        }, ReplyErrorHandler);
    };
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);

app.controller('MenuController', ['MenuService', 'ReplyErrorHandler', 'notifications', '$scope', function(MenuService, ReplyErrorHandler, notifications, $scope){
    $scope.menuItems = [];
    $scope.licenseFile = 'APACHE-LICENSE-2.0.txt';
    MenuService.get({},function(data, status, headers, config) {
        $scope.menuItems = data;
    }, ReplyErrorHandler); 
    /*$scope.menuItem = 'home.html';
    $scope.setMenu = function(selectedMenu) {
        $scope.menuItem = selectedMenu + '.html';
    };

    $scope.isMenuSet = function(isSet) {
        return isSet === $scope.menuItem;
    };*/
}]);

app.controller('StatsController', ['StatisticService', 'ReplyErrorHandler', 'notifications', '$scope', function(StatisticService, ReplyErrorHandler, notifications, $scope){
    $scope.stats = [];
    StatisticService.get({},function(data, status, headers, config) {
        $scope.stats = data;
    }, ReplyErrorHandler); 
}]);

app.controller('ArViewController', ['ArService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(ArService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.ar = [];
    $scope.discussion_id;
    $scope.comments;

    $scope.currentar = [];
    $scope.discussion_id;
    $scope.comments;
    $scope.setCurrentAr = function(id) {
        $scope.currentar = $scope.ar.versions[id];
        $scope.discussion_id = $scope.currentar.discussion.id;
        $scope.comments = $scope.currentar.discussion.comments;
    }

    ArService.id.get({id: $stateParams.id},function(data, status, headers, config) {
        $scope.ar = data;
        $scope.setCurrentAr($scope.ar.versions.length - 1);
    }, ReplyErrorHandler);

}]);

app.controller('DiscussionController', ['DiscussionService', 'CommentService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(DiscussionService, CommentService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.newcomment;
    $scope.init = function () {
        $scope.newcomment = {};
        $scope.newcomment.comment = '';
    };
    $scope.init();
    
    $scope.updateComment = function (discussion_id, comment) {
        CommentService.noid.update(comment, function(data, status, headers, config) {
            notifications.showSuccess("Comment has been updated.");
        }, ReplyErrorHandler); 
    };

    $scope.addComment = function (discussion_id) {
        $scope.newcomment.discussion = { 'id': discussion_id };
        CommentService.noid.create($scope.newcomment, function(data, status, headers, config) {
            $scope.$parent.comments.unshift(data);
            $scope.init();
            notifications.showSuccess("Comment has been added.");
        }, ReplyErrorHandler);
    };

    $scope.like = function(comment) {
        CommentService.like.like({id: comment.id},function(data, status, headers, config) {
            notifications.showSuccess("Comment has been liked.");
            comment.likes++;
        }, ReplyErrorHandler);
    };
    
    /*$scope.discussion = [];
    DiscussionService.id.get({id: $stateParams.discussion_id},function(data, status, headers, config) {
        $scope.discussion = data;
    }, ReplyErrorHandler);*/
}]);

app.controller('ARController', ['ArVersionService', 'CloudSmells', 'ReplyErrorHandler', 'notifications','$scope','$filter', function(ArVersionService, CloudSmells, ReplyErrorHandler, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.arlist = []; //ars;
    this.formvisible = true;
    $scope.words = [];
    //$scope.words = words;
    $scope.cloudcallstatus = '&nbsp;<i class="glyphicon glyphicon-refresh glyphicon-refresh-animate"/> Loading...';
    
    $scope.loadArs = function () {
        ArVersionService.noid.get({},function(data, status, headers, config) {
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();

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
    };

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

app.controller('SmellAssessController', ['SmellGroupService', 'ReplyErrorHandler', 'notifications','$scope', function(SmellGroupService, ReplyErrorHandler, notifications, $scope) {
    $scope.counter = 0;
    $scope.groups = [];
    SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    $scope.selectedSmells = [];
    $scope.getSmellCount = function () {
        $scope.counter = Math.floor((Math.random() * 100) + 1);;
    }
    $scope.toggleSelection = function toggleSelection(smell_id) {
        var idx = $scope.selectedSmells.indexOf(smell_id);

        // is currently selected
        if (idx > -1) {
            $scope.selectedSmells.splice(idx, 1);
        }
        // is newly selected
        else {
            $scope.selectedSmells.push(smell_id);
        }
        $scope.getSmellCount();
    };
}]);

app.controller('SmellController', ['SmellService', 'SmellGroupService', 'ReplyErrorHandler', 'notifications','$scope','$filter', function(SmellService, SmellGroupService, ReplyErrorHandler, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.smelllist = [];
    this.formvisible = false;
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.loadSmells = function () {
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smelllist = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadSmells();

    $scope.deleteSmell = function (id) {
        SmellService.id.delete({id: id},function(data, status, headers, config) {
            $scope.loadSmells();
            notifications.showSuccess("Smell has been deleted.");
        }, ReplyErrorHandler);
    };

    $scope.order = function(predicate, reverse) {
        $scope.smelllist = orderBy($scope.smelllist, predicate, reverse);
    };
    $scope.order('name', false);

    $scope.initSmell = function () {
        $scope.smell = {};
        $scope.smell.questions = [];
        $scope.questionToAdd = '';
    }
    $scope.initSmell();
    $scope.saveSmell = function() {
        SmellService.noid.create($scope.smell,function(data, status, headers, config) {
            $scope.loadSmells();
            notifications.showSuccess("Smell has been added.");
            $scope.initSmell();
            $scope.smellForm.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.addQuestion = function () {
        $scope.smell.questions.push({
            question: $scope.questionToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeQuestion = function (idx) {
        $scope.smell.questions.splice(idx, 1);
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

app.controller('SmellViewController', ['SmellService', 'ReplyErrorHandler', 'notifications', '$stateParams', '$scope', function (SmellService, ReplyErrorHandler, notifications, $stateParams, $scope) {
    $scope.smell = [];
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data, status, headers, config) {
            $scope.smell = data;
        }, ReplyErrorHandler);
    };
    $scope.getSmell($stateParams.id);
}]);

app.controller('SmellUpdateController', ['SmellService','SmellGroupService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$modalInstance', '$scope', '$stateParams', 'smellid', '$log', function (SmellService, SmellGroupService, StatusService, ReplyErrorHandler, notifications, $modalInstance, $scope, $stateParams, smellid, $log) {
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.singleSmell = [];
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data, status, headers, config) {
            $scope.singleSmell = data;
        }, ReplyErrorHandler);  
    };
    $scope.getSmell($stateParams.id);

    $scope.updateSmell = function() {
        SmellService.noid.update($scope.singleSmell,function(data, status, headers, config) {
            $modalInstance.close();
            notifications.showSuccess("Smell has been updated.");
            $scope.singleSmell = {};
        }, ReplyErrorHandler);//, "Failed to update Smell"));
                             
                             /*function(error) {
            
            notifications.showError("Failed to update Smell.");
        });*/  
    };
    
    $scope.addQuestion = function () {
        $scope.singleSmell.questions.push({
            question: $scope.questionToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeQuestion = function (idx) {
        $scope.singleSmell.questions.splice(idx, 1);
    };
}]);

app.controller('TaskController', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'notifications','$scope','$filter', function(TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.tasklist = [];
    this.formvisible = false;
    $scope.exectasktypes = [];
    $scope.taskproperties = [];
    $scope.loadExecTaskTypes = function () {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            $scope.exectasktypes = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadExecTaskTypes();
    
    $scope.loadTaskProperties = function () {
        TaskPropertyService.noid.get({},function(data, status, headers, config) {
            $scope.taskproperties = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTaskProperties();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.loadTasks = function () {
        TaskService.noid.get({},function(data, status, headers, config) {
            $scope.tasklist = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTasks();

    $scope.deleteTask = function (id) {
        TaskService.id.delete({id: id},function(data, status, headers, config) {
            $scope.loadTasks();
            notifications.showSuccess("Task has been deleted.");
        }, ReplyErrorHandler);
    };

    $scope.order = function(predicate, reverse) {
        $scope.tasklist = orderBy($scope.tasklist, predicate, reverse);
    };
    $scope.order('name', false);

    $scope.initTask = function () {
        $scope.task = {};
        $scope.task.properties = [];
        $scope.propertyToAdd = '';
    }
    $scope.initTask();
    $scope.saveTask = function() {
        TaskService.noid.create($scope.smell,function(data, status, headers, config) {
            $scope.loadTasks();
            notifications.showSuccess("Task has been added.");
            $scope.initTask();
            $scope.taskForm.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.addProperty = function () {
        $scope.task.questions.push({
            property: $scope.propertyToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeProperty = function (idx) {
        $scope.task.property.splice(idx, 1);
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

/*app.controller('DiscussionController', ['DiscussionService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(DiscussionService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.discussion = [];
    DiscussionService.id.get({id: $stateParams.id},function(data, status, headers, config) {
        $scope.discussion = data;
    }, ReplyErrorHandler);
    
}]);*/

app.controller("ExecTaskTypeController", ['ExecTaskTypeService', 'ReplyErrorHandler', 'notifications', '$scope', function(ExecTaskTypeService, ReplyErrorHandler, notifications, $scope) {
    $scope.exectypes = [];
    this.emptyexectype = [];
    $scope.loadExecTaskTypes = function() {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            $scope.exectypes = data;
        }, ReplyErrorHandler);
    };
    $scope.loadExecTaskTypes();

    ExecTaskTypeService.empty.get({},function(data, status, headers, config) {
        $scope.emptyexectype = data;
    }, ReplyErrorHandler); 

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
        ExecTaskTypeService.noid.update($scope.exectypes, function(data, status, headers, config) {
            $scope.emptyexectype = data;
            notifications.showSuccess("Exec Task Types have been saved.");
        }, ReplyErrorHandler);  
    }
}]);