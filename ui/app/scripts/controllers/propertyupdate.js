'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:PropertyupdateCtrl
 * @description
 * # PropertyupdateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('PropertyupdateCtrl', ['PropertyService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', function (PropertyService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams) {
    $scope.property = null;
    $scope.initProperty = function () {
        $scope.property = {};
    };
    $scope.initProperty();
    $scope.getProperty = function (propertyid) {
        PropertyService.id.get({id: propertyid},function(data) { //, status, headers, config
            $scope.property = data;
        }, ReplyErrorHandler);  
    };
    $scope.getProperty($stateParams.id);

    $scope.saveProperty = function() {
        PropertyService.noid.update($scope.property,function() { //data, status, headers, config
            $uibModalInstance.close();
            notifications.showSuccess('Property has been updated.');
            $scope.property = {};
        }, ReplyErrorHandler);
    };
    
    $scope.reload = function() {
        $scope.loadProperties();        
    };
       
    $scope.cancel = function(form) {
        $scope.initProperty();
        form.$setPristine();
        $uibModalInstance.dismiss('cancel');
    };
}]);