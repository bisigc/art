'use strict';

/**
 * @ngdoc service
 * @name uiApp.sharedTask
 * @description
 * # sharedTask
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('sharedTask', [function () {
    var taskObject = {task: {}};
    taskObject.clear = function () {
        angular.copy({}, this.task);
    }
    return taskObject;
}]);