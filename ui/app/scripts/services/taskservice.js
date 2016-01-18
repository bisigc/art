'use strict';

/**
 * @ngdoc service
 * @name uiApp.TaskService
 * @description
 * # TaskService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('TaskService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'task', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'task/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);