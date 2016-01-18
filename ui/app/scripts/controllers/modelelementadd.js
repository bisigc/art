'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ModelelementaddCtrl
 * @description
 * # ModelelementaddCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ModelelementaddCtrl', ['ModelElementService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', 'modelelementtype', function(ModelElementService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams, modelelementtype) {
    $scope.modelelement = {};
    $scope.modelelement.type = modelelementtype;
    
    $scope.saveModelElement = function(form) {
        ModelElementService.noid.create($scope.modelelement, function(data) { //, status, headers, config
            notifications.showSuccess('Model Element of type ' + $scope.modelelement.type + ' has been added.');
            $scope.modelelement = {};
            form.$setPristine();
            // close method accepts only one parameter, therefore the two necessary values are packed into an array.
            var propArray = [];
            propArray.type = modelelementtype;
            propArray.newProp = data;
            $uibModalInstance.close(propArray);
        }, ReplyErrorHandler);  
    };
    
    $scope.dismiss = function() {//form
        $uibModalInstance.dismiss('cancel');
    };
}]);