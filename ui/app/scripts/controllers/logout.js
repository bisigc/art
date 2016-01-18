'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:LogoutCtrl
 * @description
 * # LogoutCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('LogoutCtrl', ['UserService', 'ReplyErrorHandler', 'notifications', '$scope', '$state', 'currentUser', function(UserService, ReplyErrorHandler, notifications, $scope, $state, currentUser){
    $scope.logout = function() {
        UserService.logout.logout({},function(data, status, headers, config) {
            notifications.showSuccess('Logged out');
            $scope.logindata = {'email':'','password':''};
            currentUser.profile = null;
            $state.go('root.home');
        }, ReplyErrorHandler);
    };
}]);