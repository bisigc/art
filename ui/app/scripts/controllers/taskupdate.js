'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:TaskupdateCtrl
 * @description
 * # TaskupdateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('TaskupdateCtrl', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', 'taskid', '$sce', function (TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams, smellid, $sce) {
    $scope.status = [];
    $scope.exectasktypes = '';
    $scope.taskproperties = [];
    $scope.propertyToAdd = {};
    $scope.task = {};
    
    var execTypeHTML = '';
    
    var recursiveExecType = function(exectype, level) {
        exectype.forEach(function(entry){
            var element = '<option value="' + entry.name + '">' + level + entry.name + '</option>';
            execTypeHTML += element;
            recursiveExecType(entry.subTasks, level + '&#8212;');
        });
    };

    $scope.loadExecTaskTypes = function () {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            execTypeHTML = '<select class="form-control" ng-model="propertyToAdd.value">';
            var subtasks = data[0].subTasks;
            recursiveExecType(subtasks, '');
            execTypeHTML += '</select>';
            $scope.exectasktypes = $sce.trustAsHtml(execTypeHTML);
        }, ReplyErrorHandler);  
    };
    $scope.loadExecTaskTypes();
    
    $scope.loadTaskProperties = function () {
        TaskPropertyService.noid.get({},function(data, status, headers, config) {
            $scope.taskproperties = data;
            $scope.propertyToAdd.property = $scope.taskproperties[0];
        }, ReplyErrorHandler);  
    };
    $scope.loadTaskProperties();

    $scope.getTask = function (taskid) {
        TaskService.id.get({id: taskid},function(data, status, headers, config) {
            $scope.task = data;
        }, ReplyErrorHandler);  
    };
    $scope.getTask($stateParams.id);
    
    $scope.initTask = function () {
        $scope.task = {};
        $scope.task.properties = [];
        $scope.propertyToAdd = {};
    }
    
    $scope.cancel = function(form) {
        $scope.initTask();
        form.$setPristine();
        $scope.propertyToAdd.property = $scope.taskproperties[0];
        $uibModalInstance.dismiss('cancel');
    }

    $scope.saveTask = function() {
        TaskService.noid.update($scope.task,function(data, status, headers, config) {
            $uibModalInstance.close();
            notifications.showSuccess('Task has been updated.');
            $scope.task = {};
        }, ReplyErrorHandler);  
    };
    
    $scope.addProperty = function () {
        $scope.task.properties.push($scope.propertyToAdd);
        $scope.propertyToAdd = {};
    };
    
    $scope.removeProperty = function (idx) {
        $scope.task.properties.splice(idx, 1);
    };
}]);