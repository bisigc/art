'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:TaskCtrl
 * @description
 * # TaskCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('TaskCtrl', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications', '$scope', '$filter', '$sce', 'sharedTask', function(TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $filter, $sce, sharedTask) {
    var orderBy = $filter('orderBy');
    $scope.tasklist = [];
    $scope.task = sharedTask.task;
    $scope.formvisible = false;

    $scope.showForm = function(visible) {
        if(visible === true) {
            $scope.formvisible = true;
        } else {
            $scope.formvisible = false;
        }
    };
    
    $scope.getType = function(propArray) {
        if(propArray) {
            for(var i = 0; i < propArray.length; i++) {
                if(propArray[i].property.name === 'Type') {
                    return propArray[i].value;
                }
            }
        }
        return '';
    };

    $scope.loadTasks = function () {
        TaskService.noid.get({},function(data) { //, status, headers, config
            $scope.tasklist = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTasks();

    $scope.deleteTask = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Task?'}).then(function () {//result
            TaskService.id.delete({id: id},function() { //data, status, headers, config
                $scope.loadTasks();
                notifications.showSuccess('Task has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };

    $scope.order = function(predicate, reverse) {
        $scope.tasklist = orderBy($scope.tasklist, predicate, reverse);
    };
    $scope.order('name', false);
}]);