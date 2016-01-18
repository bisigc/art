'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ExectasktypeCtrl
 * @description
 * # ExectasktypeCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ExectasktypeCtrl', ['ExecTaskTypeService', 'ReplyErrorHandler', 'notifications', '$scope', function(ExecTaskTypeService, ReplyErrorHandler, notifications, $scope) {
    $scope.exectypes = [];
    this.emptyexectype = [];
    $scope.loadExecTaskTypes = function() {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            $scope.exectypes = data;
        }, ReplyErrorHandler);
    };
    $scope.loadExecTaskTypes();

    ExecTaskTypeService.empty.get({},function(data, status, headers, config) {
        $scope.emptyexectype = data;
    }, ReplyErrorHandler); 

    $scope.delete = function(task) {
        task.subTasks = [];
    };

    $scope.hasChildren = function(task) {
        return task.subTasks.length > 0;
    }


    $scope.add = function(task) {
        var post = task.subTasks.length + 1;
        var newName = task.name + '-' + post;
        task.subTasks.push(angular.copy(this.emptyexectype));
    };

    $scope.save = function() {
        ExecTaskTypeService.noid.update($scope.exectypes, function(data, status, headers, config) {
            $scope.emptyexectype = data;
            notifications.showSuccess('Exec Task Types have been saved.');
        }, ReplyErrorHandler);  
    }
}]);