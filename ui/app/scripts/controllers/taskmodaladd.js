'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:TaskmodaladdCtrl
 * @description
 * # TaskmodaladdCtrl extends TaskaddCtrl and overwrites the methods saveTask and cancel.
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('TaskmodaladdCtrl', ['$controller', '$scope', '$uibModalInstance', 'TaskService', 'ReplyErrorHandler', 'notifications', function($controller, $scope, $uibModalInstance, TaskService, ReplyErrorHandler, notifications) {
	$controller('TaskaddCtrl', {$scope: $scope});
    $scope.saveTask = function(form) {
        TaskService.noid.create($scope.task,function(data) { //, status, headers, config
            notifications.showSuccess('Task has been added.');
            $scope.initTask();
            form.$setPristine();
            $uibModalInstance.close(data);
        }, ReplyErrorHandler);  
    };
    $scope.cancel = function(form) {
        $scope.initTask();
        form.$setPristine();
        $scope.propertyToAdd.property = $scope.taskproperties[0];
    	$uibModalInstance.dismiss('cancel');
    };
}]);