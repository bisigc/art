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
    $urlRouterProvider.otherwise("");
    //
    // Now set up the states
    $stateProvider
        .state('home', {
        url: "",
        templateUrl: _contextPath + "home.html",
        data: { requireLogin: false }
    })
        .state('smellbrowser', {
        url: "/smellbrowser",
        controller: "SmellController as smellCtrl",
        templateUrl: _contextPath + "smellbrowser.html",
        data: { requireLogin: false }
    })
        .state('arbrowser', {
        url: "/arbrowser",
        templateUrl: _contextPath + "arbrowser.html",
        data: { requireLogin: false }
    })
        .state('addar', {
        url: "/addar",
        templateUrl: _contextPath + "addar.html",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('smellbrowser.edit', {
        url: "/edit/:id",
        templateUrl: _contextPath + "smellbrowser.html",
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
        data: { requireLogin: false }
    })
        .state('singlear', {
        url: "/ar/:id",
        templateUrl: _contextPath + "singlear.html",
        data: { requireLogin: false }
    })
        .state('taskbrowser', {
        url: "/taskbrowser",
        templateUrl: _contextPath + "taskbrowser.html",
        data: { requireLogin: false }
    })
        .state('admin', {
        url: "/admin",
        templateUrl: _contextPath + "admin.html",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        }
    })
        .state('users', {
        url: "/users",
        templateUrl: _contextPath + "users.html",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        }
    })
        .state('exectypes', {
        url: "/exectypes",
        templateUrl: _contextPath + "exectypes.html",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        }
    })
        .state('about', {
        url: "/about",
        templateUrl: _contextPath + "about.html",
        data: { requireLogin: false }
    })
        .state('profile', {
        url: "/profile",
        templateUrl: _contextPath + "profile.html",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Applier", "Editor"]
        }
    })
        .state('smellassess', {
        url: "/smellassess",
        templateUrl: _contextPath + "smellassess.html",
        data: { requireLogin: false }
    });
}]);