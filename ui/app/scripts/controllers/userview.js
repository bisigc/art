'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:UserviewCtrl
 * @description
 * # UserviewCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('UserviewCtrl', ['UserService', 'ReplyErrorHandler', '$scope', '$stateParams', function(UserService, ReplyErrorHandler, $scope, $stateParams){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user;
    $scope.getUser = function() {
        UserService.id.get({id: $stateParams.id},function(data, status, headers, config) {
            $scope.user = data;
        }, ReplyErrorHandler);
    };
    $scope.getUser();
}]);