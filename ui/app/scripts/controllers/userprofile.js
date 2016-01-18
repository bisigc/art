'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:UserprofileCtrl
 * @description
 * # UserprofileCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('UserprofileCtrl', ['UserService', 'RolesService', 'AvatarUploader', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope','currentUser', '$state', function(UserService, RolesService, AvatarUploader, ReplyErrorHandler, PasswordValidator, notifications, $scope, currentUser, $state){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user = null;
    $scope.pw = null;
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data) { //, status, headers, config
        $scope.roles = data;
    }, ReplyErrorHandler);
    
    UserService.id.get({id: currentUser.profile.id},function(data) { //, status, headers, config
        $scope.user = data;
    }, ReplyErrorHandler);
    
    $scope.updateProfile = function() {
        UserService.noid.update({},$scope.user,function() { //data, status, headers, config
            notifications.showSuccess('Profile saved successful.');
        }, ReplyErrorHandler);
    };
    
    $scope.changePassword = function() {
        UserService.pw.update({},$scope.pw,function() { //data, status, headers, config
            notifications.showSuccess('Password has been changed.');
            $scope.pw = null;
            $scope.pwUpdateForm.$setPristine();
        }, ReplyErrorHandler);
    };
    
    $scope.getTime = function() {
        return new Date();
    };
    
    $scope.uploadAvatar = function() {
        AvatarUploader.upload($scope.avatarimage).success(function(){ //data, status, headers, config
            notifications.showSuccess('Avatar image has been uploaded.');
            $scope.avatarimage = null;
            $state.go($state.current, {}, {reload: true});
        }).error(function(data){ //, status, headers, config
            $scope.avatarimage = null;
            notifications.showError('Failed to upload avatar image: ' + data);
        });
    };
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);