app.run(function ($rootScope, $state, $stateParams) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
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

app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    //
    // For any unmatched url, redirect to ""
    $urlRouterProvider.otherwise("");
    //
    // Now set up the states
    $stateProvider
        .state('home', {
        url: "",
        templateUrl: _contextPath + "home.html"
    })
        .state('smellbrowser', {
        url: "/smellbrowser",
        templateUrl: _contextPath + "smellbrowser.html"
    })
        .state('arbrowser', {
        url: "/arbrowser",
        templateUrl: _contextPath + "arbrowser.html",
    })
        .state('addar', {
        url: "/addar",
        templateUrl: _contextPath + "addar.html",
    })
        .state('smellbrowser.edit', {
        url: "/edit/:id",
        templateUrl: _contextPath + "smellbrowser.html",
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
        templateUrl: _contextPath + "singlesmell.html"
    })
        .state('taskbrowser', {
        url: "/taskbrowser",
        templateUrl: _contextPath + "taskbrowser.html",
    })
        .state('admin', {
        url: "/admin",
        templateUrl: _contextPath + "admin.html"
    })
        .state('users', {
        url: "/users",
        templateUrl: _contextPath + "users.html"
    })
        .state('exectypes', {
        url: "/exectypes",
        templateUrl: _contextPath + "exectypes.html"
    })
        .state('about', {
        url: "/about",
        templateUrl: _contextPath + "about.html"
    })
        .state('profile', {
        url: "/profile",
        templateUrl: _contextPath + "profile.html"
    })
        .state('smellassess', {
        url: "/smellassess",
        templateUrl: _contextPath + "smellassess.html"
    });
}]);