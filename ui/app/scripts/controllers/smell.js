'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellCtrl
 * @description
 * # SmellCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellCtrl', ['SmellService', 'SmellGroupService', 'ReplyErrorHandler', 'StatusService', 'ConfirmModal', 'notifications','$scope','$filter', 'sharedSmell', function(SmellService, SmellGroupService, ReplyErrorHandler, StatusService, ConfirmModal, notifications, $scope, $filter, sharedSmell) {
    var orderBy = $filter('orderBy');
    $scope.smelllist = [];
    $scope.formvisible = false;
    $scope.smell = sharedSmell.smell;
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.noid.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();

    $scope.showForm = function(visible) {
        if(visible == true) {
            $scope.formvisible = true;
        } else {
            $scope.formvisible = false;
        }
    };

    $scope.loadSmells = function () {
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smelllist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadSmells();
    
    $scope.reload = function() {
        $scope.loadSmells();        
    }
    
    $scope.deleteSmell = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Smell?'}).then(function (result) {
            SmellService.id.delete({id: id},function(data, status, headers, config) {
                $scope.loadSmells();
                notifications.showSuccess('Smell has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.')});
    }

    $scope.order = function(predicate, reverse) {
        $scope.smelllist = orderBy($scope.smelllist, predicate, reverse);
    };
    $scope.order('name', false);
}]);
