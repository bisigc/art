'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:PropertyviewCtrl
 * @description
 * # PropertyviewCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('PropertyviewCtrl', ['PropertyService', 'ConfirmModal', 'ReplyErrorHandler', 'notifications', '$stateParams', '$state', '$scope', 'LastViewed', function (PropertyService, ConfirmModal, ReplyErrorHandler, notifications, $stateParams, $state, $scope, LastViewed) {
    $scope.property = {};
    
    $scope.getProperty = function (propertyid) {
        PropertyService.id.get({id: propertyid},function(data) { //, status, headers, config
            $scope.property = data;
            var item = {'name': $scope.property.attribute, 'type': 'Property', 'id': $scope.property.id};
            LastViewed.add(item);
        }, ReplyErrorHandler);
    };
    $scope.getProperty($stateParams.id);
    
    $scope.deleteProperty = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Property?'}).then(function () {//result
            PropertyService.id.delete({id: id},function() { //data, status, headers, config
                $state.go('root.properties');
                notifications.showSuccess('Property has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };
}]);
