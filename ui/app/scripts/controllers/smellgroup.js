'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellgroupCtrl
 * @description
 * # SmellgroupCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellgroupCtrl', ['SmellGroupService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications', '$scope', '$stateParams', '$filter', function(SmellGroupService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $stateParams, $filter) {
    var orderBy = $filter('orderBy');
    $scope.smellgrouplist = [];
    
    $scope.loadSmellGroups = function() {
        SmellGroupService.noid.get({}, function(data, status, headers, config) {
            $scope.smellgrouplist = data;
        }, ReplyErrorHandler);  
    }
    $scope.loadSmellGroups();
    
    $scope.deleteSmellGroup = function(id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Smell Group?'}).then(function (result) {
            SmellGroupService.id.delete({id: id},function(data, status, headers, config) {
                notifications.showSuccess('Smell Group has been deleted.');
                $scope.loadSmellGroups();
            }, ReplyErrorHandler);  
        }, function() {notifications.showInfo('Delete canceled.')});
    }
    
    $scope.order = function(predicate, reverse) {
        $scope.smellgrouplist = orderBy($scope.smellgrouplist, predicate, reverse);
    };
    $scope.order('name', false);
}]);