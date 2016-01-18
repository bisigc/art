'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:UsercreateCtrl
 * @description
 * # UsercreateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('UsercreateCtrl', ['UserService', 'RolesService', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope', '$state', function(UserService, RolesService, ReplyErrorHandler, PasswordValidator, notifications, $scope, $state){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user = [];
    $scope.user.startpage = 'stay';
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data, status, headers, config) {
        $scope.roles = data;
        $scope.user.role = $scope.roles[2];
    }, ReplyErrorHandler);
    
    $scope.createUser = function() {
        UserService.noid.create($scope.user,function(data, status, headers, config) {
            notifications.showSuccess('User has been created.');
            $state.go('root.home');
        }, ReplyErrorHandler);
    };
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);