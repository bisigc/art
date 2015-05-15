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
        controller: "SmellController as smellCtrl",
        templateUrl: _contextPath + "smellbrowser.html",
        title: "Smell Browser",
        data: { requireLogin: false }
    })
        .state('arbrowser', {
        url: "/arbrowser",
        templateUrl: _contextPath + "arbrowser.html",
        title: "AR Browser",
        data: { requireLogin: false }
    })
        .state('addar', {
        url: "/addar",
        templateUrl: _contextPath + "addar.html",
        title: "Add AR",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
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
        .state('singlesmell', {
        url: "/smell/:id",
        title: "Smell View",
        data: { requireLogin: false },
        views: {
            '': {
                templateUrl: _contextPath + "singlesmell.html"
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
                templateUrl: _contextPath + "singlear.html"
            },
            'discussionView@singlear': {
                templateUrl: _contextPath + "discussion.html"
            }
        }
    })
        .state('taskbrowser', {
        url: "/taskbrowser",
        templateUrl: _contextPath + "taskbrowser.html",
        title: "Task Browser",
        data: { requireLogin: false }
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