'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellgroupupdateCtrl
 * @description
 * # SmellgroupupdateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellgroupupdateCtrl', ['SmellGroupService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', function(SmellGroupService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams) {
    $scope.smellgroup = {};
    $scope.loadSmellGroup = function() {
        SmellGroupService.id.get({id: $stateParams.id}, function(data, status, headers, config) {
            $scope.smellgroup = data;
        }, ReplyErrorHandler);  
    }
    $scope.loadSmellGroup();
    
    $scope.saveSmellGroup = function(form) {
        SmellGroupService.noid.update($scope.smellgroup, function(data, status, headers, config) {
            notifications.showSuccess('Smell Group has been updated.');
            $scope.smellgroup = {};
            form.$setPristine();
            $uibModalInstance.close();
        }, ReplyErrorHandler);  
    }
    
    $scope.dismiss = function(form) {
        $uibModalInstance.dismiss('cancel');
    }    
}]);