'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('LoginCtrl', ['UserService', 'ReplyErrorHandler', 'notifications', '$scope', '$state', 'currentUser', function(UserService, ReplyErrorHandler, notifications, $scope, $state, currentUser){
    $scope.logindata = {'email':'','password':'','keeploggedin':1};
    $scope.login = function(form) {
        UserService.login.login($scope.logindata,function(data) { //, status, headers, config
            currentUser.profile = data;
            notifications.showSuccess('Logged in');
            $scope.logindata = {'email':'','password':'','keeploggedin':1};
            form.$setPristine();
            //$scope.loginform.$setPristine();
            if(currentUser.profile.startpage === 'stay') {
                $state.go($state.current, {}, {reload: true});
                //$state.reload();
            } else {
                $state.go('root.' + currentUser.profile.startpage);
            }
        }, ReplyErrorHandler);
    };
}]);
