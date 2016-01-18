'use strict';

/**
 * @ngdoc service
 * @name uiApp.TaskPropertyService
 * @description
 * # TaskPropertyService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('TaskPropertyService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'taskproperty', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'taskproperty/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);