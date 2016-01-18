'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ModelelementupdateCtrl
 * @description
 * # ModelelementupdateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ModelelementupdateCtrl', ['ModelElementService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', function(ModelElementService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams) {
    $scope.modelelement = {};
    $scope.loadModelElement = function() {
        ModelElementService.id.get({id: $stateParams.id}, function(data) { //, status, headers, config
            $scope.modelelement = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadModelElement();
    
    $scope.saveModelElement = function(form) {
        ModelElementService.noid.update($scope.modelelement, function() { //data, status, headers, config
            notifications.showSuccess('Model Element of type ' + $scope.modelelement.type + ' has been updated.');
            $scope.modelelement = {};
            form.$setPristine();
            $uibModalInstance.close();
        }, ReplyErrorHandler);  
    };
    
    $scope.dismiss = function() {//form
        $uibModalInstance.dismiss('cancel');
    };
}]);