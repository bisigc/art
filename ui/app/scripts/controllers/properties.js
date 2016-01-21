'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:PropertiesCtrl
 * @description
 * # PropertiesCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('PropertiesCtrl', ['PropertyService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications','$scope','$filter', 'sharedProperty', function(PropertyService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $filter, sharedProperty) {
    var orderBy = $filter('orderBy');
    $scope.propertylist = [];
    $scope.property = sharedProperty.property;
    $scope.formvisible = false;

    $scope.showForm = function(visible) {
        if(visible === true) {
            $scope.formvisible = true;
        } else {
            $scope.formvisible = false;
        }
    };

    $scope.loadProperties = function () {
        PropertyService.noid.get({},function(data) { //, status, headers, config
            $scope.propertylist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadProperties();

    $scope.deleteProperty = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Property?'}).then(function () {//result
            PropertyService.id.delete({id: id},function() { //data, status, headers, config
                $scope.loadProperties();
                notifications.showSuccess('Property has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };

    $scope.order = function(predicate, reverse) {
        $scope.propertylist = orderBy($scope.propertylist, predicate, reverse);
    };
    $scope.order('attribute', false);
}]);