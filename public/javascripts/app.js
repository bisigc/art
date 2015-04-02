(function(){
    var user = { "name": 'Cbi', "loggedin": true, "avatar": 'images/avatars/avatar1.png' };
    var ars = [{ "name":"AR1", "desc":"blabladesc 1", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR2", "desc":"Holderadio 2", "smells":[{"id":2,"name":"Smell2"},{"id":5,"name":"Smell5"}] }, { "name":"AR3", "desc":"Auto Velo 3", "smells":[{"id":2,"name":"Smell2"},{"id":7,"name":"Smell7"}] }, { "name":"AR4", "desc":"blabladesc 1", "smells":[{"id":2,"name":"Smell2"},{"id":6,"name":"Smell6"}] }, { "name":"AR5", "desc":"Holderadio 2", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR6", "desc":"Auto Velo 3", "smells":[{"id":3,"name":"Smell3"},{"id":5,"name":"Smell5"}] }, { "name":"AR7", "desc":"blabladesc 1", "smells":[{"id":3,"name":"Smell3"},{"id":4,"name":"Smell4"}] }, { "name":"AR8", "desc":"Holderadio 2", "smells":[{"id":4,"name":"Smell4"},{"id":7,"name":"Smell7"}] }, { "name":"AR9", "desc":"Auto Velo 3", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }];
    var app = angular.module('art', ['ui.bootstrap','angular-jqcloud','ngResource','ngSanitize','ui.select','ngNotificationsBar']);
    var menuItems = [
        {"id":1,  "name": "home",         "fullname":"home",                  "tooltip":"",                     "image":"images/art_logo_small.png", "type":"home",          "url":"home.html", "pos":"left", "order":5, "subItems":[]},
        {"id":2,  "name": "ars",          "fullname":"AR Browser",            "tooltip":"Architectural Refactoring Browser",                            "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":10, "subItems":[]},
        {"id":3,  "name": "smellbrowser",       "fullname":"Smell Browser",   "tooltip":"",                    "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":30, "subItems":[]},
        {"id":4,  "name": "taskbrowser", "fullname":"Task Browser",           "tooltip":"",           "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":25, "subItems":[]},
        {"id":5,  "name": "smellasses",   "fullname":"Smell Self-Assessment", "tooltip":"Refactoring Qualification",                               "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":20, "subItems":[]},
        {"id":6,  "name": "armeta",       "fullname":"AR Meta Info",          "tooltip":"Architectural Refactoring Meta Info",                     "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":40, "subItems":[]},
        //{"id":8,  "name": "wiki",         "fullname":"Wikipedia",           "tooltip":"",                       "image":"",                          "type":"link",          "url":"http://www.wikipedia.com", "pos":"left", "order":40, "subItems":[]},
        {"id":8,  "name": "admin",        "fullname":"Admin",                 "tooltip":"",                     "image":"",                          "type":"dropdown",      "url":"home.html", "pos":"left", "order":45, "subItems":[{"id":11, "name": "users", "fullname": "Users","tooltip":"","image":"", "type":"include", "url":"useradmin.html", "pos":"left", "order":15, "subItems":[]},{"id":13, "name": "other", "fullname": "Other","tooltip":"","image":"", "type":"include", "url":"useradmin.html", "pos":"left", "order":15, "subItems":[]}]},
        {"id":9,  "name": "about",        "fullname":"About",                 "tooltip":"",                    "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":15, "subItems":[]},
        {"id":10,  "name": "contact",        "fullname":"Contact",            "tooltip":"",                         "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":15, "subItems":[]},
        {"id":11,  "name": "profile",      "fullname":"Profile",              "tooltip":"",                      "image":"",                          "type":"include",       "url":"home.html", "pos":"right", "order":50, "subItems":[]},
        {"id":12, "name": "login",        "fullname":"Login",                 "tooltip":"",                     "image":"",                          "type":"login-logout",  "url":"home.html", "pos":"right", "order":55, "subItems":[]}
    ];

    var setSmell = function(smell){ 
        var input = $('#smellname');
        input.val(smell);
        input.trigger('input');
    };

    app.config(['notificationsConfigProvider', function (notificationsConfigProvider) {
        // auto hide
        notificationsConfigProvider.setAutoHide(true);
        // delay before hide
        notificationsConfigProvider.setHideDelay(5000);
        // support HTML
        notificationsConfigProvider.setAcceptHTML(true);
    }]);

    //var words = [{"text":"Smell1","weight":0.5,"handlers":{"click":"function(){setSmell('Smell1');}"}},{"text":"Smell2","weight":0.25,"handlers":{"click":"function(){setSmell('Smell2');}"}},{"text":"Smell3","weight":0.5,"handlers":{"click":"function(){setSmell('Smell3');}"}},{"text":"Smell4","weight":0.1,"handlers":{"click":"function(){setSmell('Smell4');}"}}];

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

    app.controller('MenuController', function(){
        this.menuItems = menuItems;
        this.menuItem = 'smellbrowser.html';
        this.setMenu = function(selectedMenu) {
            this.menuItem = selectedMenu + '.html';
        };

        this.isMenuSet = function(isSet) {
            return isSet === this.menuItem;
        };
    });

    app.controller('ARController', ['CloudSmells','$scope','$filter', function(CloudSmells, $scope, $filter) {
        var orderBy = $filter('orderBy');
        $scope.arlist = ars;
        this.formvisible = true;
        $scope.words = [];
        //$scope.words = words;
        $scope.cloudcallstatus = "not call yet";

        this.loadCloud = function () {
            CloudSmells.get({},function(data, status, headers, config) {
                $scope.words = data;
                $scope.cloudcallstatus = "OK";
            }, function(error, status, headers, config) {
                $scope.cloudcallstatus = "NOK";
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
            var modalInstance = $modal.open({templateUrl: 'smelldialog.html', controller: 'SmellUpdateController', size: 'lg', resolve: {
                smellid: function () {
                    return id;
                }
            }});
            
            modalInstance.result.then(function () {
                $scope.loadSmells();
                notifications.showSuccess("Smells loaded.");
            }, function () {
                notifications.showSuccess("Smell closed");
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

    app.controller('SmellUpdateController', ['SmellService', 'GroupService', 'notifications', '$modalInstance', '$scope', 'smellid', function (SmellService, GroupService, notifications, $modalInstance, $scope, smellid) {
        $scope.singleSmell = [];
        $scope.groups = [];
        $scope.loadGroups = function () {
            GroupService.get({cat: 'SmellGroups'},function(data, status, headers, config) {
                $scope.groups = data;
                //$scope.smellcallstatus = "OK";
            }, function(error, status, headers, config) {
                //$scope.smellcallstatus = "NOK";
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


    // ART services
    app.factory("OwnTasks", function($resource) {
        return $resource("http://localhost:9000/listAll", {});
    });

    app.factory("CloudSmells", ['$resource', function($resource) {
        return $resource('/smells/forcloud', 
                         {},
                         {get: {method:'GET', isArray: true}});
    }]);

    //{output: 'json', callback:'JSON_CALLBACK'},

    app.factory("SmellsService", ['$resource', function($resource) {
        return $resource('/smells', 
                         {},
                         {
            get: {method:'GET', isArray: true},
            create: { method: 'POST' }
        });
    }]);

    app.factory('SmellService', ['$resource', function ($resource) {
        return $resource('/smells/:id', {}, {
            get: { method: 'GET' },
            update: { method: 'PUT', params: {id: '@id'} },
            delete: { method: 'DELETE', params: {id: '@id'} }
        });
    }]);

    app.factory('GroupService', ['$resource', function ($resource) {
        return $resource('/property/categorie/:cat', {}, {
            get: { method: 'GET', isArray: true }
        });
    }]);
    

    // EEPPI services
    app.factory("Tasks", function($resource) {
        return $resource("http://localhost:9990/taskTemplate", {});
    });

    app.factory("Login", function($resource) {
        return $resource("http://localhost:9990/user/login?name=cbi&password=test", {});
    });

    // ADRepo
    app.factory("Element", function($resource) {
        return $resource("http://localhost:9940/element/19", {});
    });

})();