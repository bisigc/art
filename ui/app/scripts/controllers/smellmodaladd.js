'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellmodaladdCtrl
 * @description
 * # SmellmodaladdCtrl extends SmellAddController and overwrites the methods saveSmell and cancel.
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellmodaladdCtrl', ['$controller', '$scope', '$uibModalInstance', 'SmellService', 'ReplyErrorHandler', 'notifications', function($controller, $scope, $uibModalInstance, SmellService, ReplyErrorHandler, notifications) {
	$controller('SmelladdCtrl', {$scope: $scope});
    $scope.saveSmell = function(form) {
        SmellService.noid.create($scope.smell,function(data, status, headers, config) {
            if($scope.loadSmells) {
                $scope.loadSmells();
            }
            notifications.showSuccess('Smell has been added.');
            $scope.initSmell();
            form.$setPristine();
            if($uibModalInstance) {
            	$uibModalInstance.close(data);
            }
        }, ReplyErrorHandler);  
    };
    
    $scope.cancel = function(form) {
        $scope.initSmell();
        $scope.smell.status = $scope.status[0];
        $scope.smell.group = $scope.groups[0];
        form.$setPristine();
        if($uibModalInstance) {
        	$uibModalInstance.dismiss('cancel');
        }
    }
}]);