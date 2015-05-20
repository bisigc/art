app.run(['$rootScope','$state','$stateParams','notifications','currentUser', 'isAllowed', 'isLoggedin', function ($rootScope, $state, $stateParams, notifications, currentUser, isAllowed, isLoggedin) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.currentUser = currentUser;
    $rootScope.isAllowed = isAllowed;
    $rootScope.isLoggedin = isLoggedin;
    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var requireLogin = toState.data.requireLogin;
        var allowedRoles = toState.data.allowedRoles;

        if (requireLogin && currentUser.profile == null) {
            event.preventDefault();
            notifications.showWarning("Login required.");
        } else if(requireLogin && currentUser.profile != null && allowedRoles.indexOf(currentUser.profile.role.name) == -1) {
            event.preventDefault();
            notifications.showWarning("Not enough permissions.");
        }
    });
    
    $rootScope.$on('$stateChangeSuccess', function (evt, toState, toParams, fromState, fromParams) {
        window.document.title = "Architectural Refactoring Tool > " + toState.title;
    });
}]);

app.config(['notificationsConfigProvider', function (notificationsConfigProvider) {
    notificationsConfigProvider.setAutoHide(true);
    notificationsConfigProvider.setHideDelay(7000);
    notificationsConfigProvider.setAcceptHTML(true);
}]);

app.config(['$provide', function($provide) {
    var profile;
    if(window.activeProfile == '') {
        profile = null;
    } else {
        var decoded = atob(window.activeProfile);
        if(decoded == "Session timeout") {
            profile = null;
        } else {
            profile = angular.fromJson(decoded);
        }
    }
    $provide.value('currentUser', {"profile": profile});
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

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to ""
    $urlRouterProvider.when('', '/');;
    $urlRouterProvider.otherwise("/");
    //
    // Now set up the states
    $stateProvider
        .state('home', {
        url: "/",
        title: "Home",
        data: { requireLogin: false },
        views: {
            '': {
                templateUrl: _contextPath + "home.html",
            },
            'statsView@home': {
                templateUrl: _contextPath + "stats.html"
            },
            'loginView@home': {
                templateUrl: _contextPath + "login.html"
            }
        }
    })
        .state('register', {
        url: "/register",
        templateUrl: _contextPath + "register.html",
        title: "Register",
        data: { requireLogin: false }
    })
        .state('smellbrowser', {
        url: "/smellbrowser",
        //templateUrl: _contextPath + "smellbrowser.html",
        title: "Smell Browser",
        data: { requireLogin: false },
        views: {
            '': {
                controller: "SmellController as smellCtrl",
                title: "Smell Browser",
                templateUrl: _contextPath + "smellbrowser.html",
            },
            'addSmellView@smellbrowser': {
                controller: "SmellAddController as smellAddCtrl",
                title: "Create Smell",
                templateUrl: _contextPath + "smelldialog.html",
                data: { 
                    requireLogin: true,
                    allowedRoles: ["Admin", "Editor"]
                }
            }
        }
    })
        .state('smellbrowser.edit', {
        url: "/edit/:id",
        templateUrl: _contextPath + "smellbrowser.html",
        title: "Smell Edit",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellUpdateController',
                    size: 'lg',
                    resolve: {
                        smellid: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
                reload();
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('arbrowser', {
        url: "/arbrowser",
        templateUrl: _contextPath + "arbrowser.html",
        controller: "ARController as arCtrl",
        title: "AR Browser",
        data: { requireLogin: false }
    })
        .state('addar', {
        url: "/addar",
        templateUrl: _contextPath + "arform.html",
        controller: "ARAddController as arAddCtrl",
        title: "Add AR",
        params: {id: null},
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('aredit', {
        url: "/aredit/:id",
        templateUrl: _contextPath + "arform.html",
        controller: 'AREditController as arEditCtrl',
        title: "Edit AR",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('addar.addmodelelement', {
        url: "/addmodelelement/:modelelementtype",
        templateUrl: _contextPath + "arbrowser.html",
        title: "Add ModelElement",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return $stateParams.modelelementtype;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('addar.addsmell', {
        url: "/addsmell",
        templateUrl: _contextPath + "arbrowser.html",
        title: "Add Smell",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellAddController',
                    size: 'lg',
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
                reload();
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('modelelement', {
        url: "/modelelement",
        templateUrl: _contextPath + "modelelement.html",
        controller: 'ModelElementController',
        title: "Model Elements",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('modelelement.edit', {
        url: "/edit/:id",
        templateUrl: _contextPath + "modelelement.html",
        title: "Edit ModelElement",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementUpdateController',
                    size: 'lg',
                    resolve: {
                        id: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('modelelement.add', {
        url: "/add/:modelelementtype",
        templateUrl: _contextPath + "modelelement.html",
        title: "Add ModelElement",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return $stateParams.modelelementtype;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('arsearch', {
        url: "/arsearch/:smellids",
        controller: "ARSearchController as arSearchCtrl",
        templateUrl: _contextPath + "arsearch.html",
        title: "AR Search",
        /*params: {
            smellids: null,
        },*/
        data: { 
            requireLogin: false
        }
    })  
        .state('usersearches', {
        url: "/usersearches",
        templateUrl: _contextPath + "usersearches.html",
        title: "User Searches",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Applier", "Editor"]
        }
    })
        .state('singlesmell', {
        url: "/smell/:id",
        title: "Smell View",
        data: { requireLogin: false },
        views: {
            '': {
                templateUrl: _contextPath + "singlesmell.html",
                controller: "SmellViewController as smellCtrl"
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + "discussion.html"
            }*/
        }
    })
        .state('singlear', {
        url: "/ar/:id",
        title: "AR View",
        data: { requireLogin: false },
        views: {
            '': {
                templateUrl: _contextPath + "singlear.html",
                controller: 'ArViewController as arViewCtrl'
            },
            'discussionView@singlear': {
                templateUrl: _contextPath + "discussion.html",
                controller: 'DiscussionController as disCtrl'
            }
        }
    })
        .state('singletask', {
        url: "/task/:id",
        title: "Task View",
        data: { requireLogin: false },
        views: {
            '': {
                templateUrl: _contextPath + "singletask.html"
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + "discussion.html"
            }*/
        }
    })
        .state('taskbrowser', {
        url: "/taskbrowser",
        templateUrl: _contextPath + "taskbrowser.html",
        title: "Task Browser",
        data: { requireLogin: false }
    })
        .state('taskbrowser.edit', {
        url: "/edit/:id",
        templateUrl: _contextPath + "taskbrowser.html",
        title: "Task Edit",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$modal', function($stateParams, $state, $modal) {
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'taskdialog.html',
                    controller: 'TaskUpdateController',
                    size: 'lg',
                    resolve: {
                        taskid: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('admin', {
        url: "/admin",
        templateUrl: _contextPath + "admin.html",
        title: "Admin",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        }
    })
        .state('users', {
        url: "/users",
        templateUrl: _contextPath + "users.html",
        title: "Users",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        }
    })
        .state('exectypes', {
        url: "/exectypes",
        templateUrl: _contextPath + "exectypes.html",
        title: "Execution Task Types",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('about', {
        url: "/about",
        templateUrl: _contextPath + "about.html",
        title: "About",
        data: { requireLogin: false }
    })
        .state('profile', {
        url: "/profile",
        templateUrl: _contextPath + "profile.html",
        title: "Profile",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Applier", "Editor"]
        }
    })
        .state('smellassess', {
        url: "/smellassess",
        templateUrl: _contextPath + "smellassess.html",
        title: "Smell Self-Assessment",
        data: { requireLogin: false }
    });
}]);