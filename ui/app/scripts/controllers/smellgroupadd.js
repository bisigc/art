'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellgroupaddCtrl
 * @description
 * # SmellgroupaddCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellgroupaddCtrl', ['SmellGroupService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', 'modelelementtype', function(SmellGroupService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams, modelelementtype) {
    $scope.smellgroup = {};
    
    $scope.saveSmellGroup = function(form) {
        SmellGroupService.noid.create($scope.smellgroup, function(data, status, headers, config) {
            notifications.showSuccess('Smell Group has been added.');
            $scope.smellgroup = {};
            form.$setPristine();
            $uibModalInstance.close();
        }, ReplyErrorHandler);  
    }
    
    $scope.dismiss = function(form) {
        $uibModalInstance.dismiss('cancel');
    }
}]);