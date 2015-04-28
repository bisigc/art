app.run(['$rootScope','$state','$stateParams','notifications','currentUser', 'isAllowed', function ($rootScope, $state, $stateParams, notifications, currentUser, isAllowed) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.currentUser = currentUser;
    $rootScope.isAllowed = isAllowed;
    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var verifyLogin = function() {
            var requireLogin = toState.data.requireLogin;
            var allowedRoles = toState.data.allowedRoles;

            if (requireLogin && currentUser.profile == null) {
                event.preventDefault();
                notifications.showWarning("Login required.");
            } else if(requireLogin && currentUser.profile != null && allowedRoles.indexOf(currentUser.profile.role.name) == -1) {
                event.preventDefault();
                notifications.showWarning("Not enough permissions.");
            }
        }
        verifyLogin();
    });
    
    $rootScope.$on('$stateChangeSuccess', function (evt, toState, toParams, fromState, fromParams) {
        window.document.title = "Architectural Refactoring Tool > " + toState.title;
    });
}]);

app.config(['notificationsConfigProvider', function (notificationsConfigProvider) {
    notificationsConfigProvider.setAutoHide(true);
    notificationsConfigProvider.setHideDelay(5000);
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
        templateUrl: _contextPath + "home.html",
        title: "Home",
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
        templateUrl: _contextPath + "singlesmell.html",
        title: "Smell View",
        data: { requireLogin: false }
    })
        .state('singlear', {
        url: "/ar/:id",
        templateUrl: _contextPath + "singlear.html",
        title: "AR View",
        data: { requireLogin: false }
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