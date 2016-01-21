'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:PropertyaddCtrl
 * @description
 * # PropertyaddCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('PropertyaddCtrl', ['PropertyService', 'ReplyErrorHandler', 'notifications', '$scope', 'sharedProperty', function(PropertyService, ReplyErrorHandler, notifications, $scope, sharedProperty) {
    $scope.property = sharedProperty.property;
    $scope.initProperty = function () {
        sharedProperty.clear();
    };
    $scope.initProperty();
    $scope.saveProperty = function(form) {
        PropertyService.noid.create($scope.property,function() { //data, status, headers, config
            if($scope.loadProperties) {
                $scope.loadProperties();
            }
            notifications.showSuccess('Property has been added.');
            $scope.initProperty();
            form.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.cancel = function(form) {
        $scope.initProperty();
        form.$setPristine();
    };    
}]);
