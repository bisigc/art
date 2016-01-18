'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:TaskaddCtrl
 * @description
 * # TaskaddCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('TaskaddCtrl', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'notifications','$scope','$filter', '$sce', 'sharedTask', function(TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, notifications, $scope, $filter, $sce, sharedTask) {
    $scope.exectasktypes = '';
    $scope.taskproperties = [];
    $scope.task = sharedTask.task;
    $scope.propertyToAdd = {};
    
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
    
    $scope.initTask = function () {
        sharedTask.clear();
        $scope.task.properties = [];
        $scope.propertyToAdd = {property: {} };
    }
    $scope.initTask();
    
    $scope.cancel = function(form) {
        $scope.initTask();
        form.$setPristine();
        $scope.propertyToAdd.property = $scope.taskproperties[0];
    }

    $scope.saveTask = function(form) {
        TaskService.noid.create($scope.task,function(data, status, headers, config) {
            $scope.loadTasks();
            notifications.showSuccess('Task has been added.');
            $scope.initTask();
            form.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.addProperty = function () {
        $scope.task.properties.push($scope.propertyToAdd);
        $scope.propertyToAdd = { property: {} };
    };
    
    $scope.removeProperty = function (idx) {
        $scope.task.properties.splice(idx, 1);
    };
}]);