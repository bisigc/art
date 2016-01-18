'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ModelelementCtrl
 * @description
 * # ModelelementCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ModelelementCtrl', ['ModelElementService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications', '$scope', '$stateParams', '$filter', function(ModelElementService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $stateParams, $filter) {
    var orderBy = $filter('orderBy');
    $scope.modelelementlist = [];
    $scope.modelelementtypes = [];
    $scope.selectedtype = '';
    
    $scope.loadModelElementTypes = function() {
        ModelElementService.type.get({}, function(data) { //, status, headers, config
            $scope.modelelementtypes = data;
        }, ReplyErrorHandler);
    };
    $scope.loadModelElementTypes();
    
    $scope.loadModelElements = function() {//form
        ModelElementService.noid.get({}, function(data) { //, status, headers, config
            $scope.modelelementlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadModelElements();
    
    $scope.deleteElement = function(elementid) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this element?'}).then(function () {//result
            ModelElementService.id.delete({id: elementid},function() { //data, status, headers, config
                notifications.showSuccess('Model Element Link has been deleted.');
                $scope.loadModelElements();
            }, ReplyErrorHandler);  
        }, function() {notifications.showInfo('Delete canceled.');});
    };
    
    $scope.order = function(predicate, reverse) {
        $scope.modelelementlist = orderBy($scope.modelelementlist, predicate, reverse);
    };
    $scope.order('name', false);
}]);