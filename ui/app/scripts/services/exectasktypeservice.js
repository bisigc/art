'use strict';

/**
 * @ngdoc service
 * @name uiApp.ExecTaskTypeService
 * @description
 * # ExecTaskTypeService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ExecTaskTypeService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'exectasktype', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'exectasktype/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        empty: $resource(_contextPath + 'exectasktype/empty', {}, {
            get: { method: 'GET' }
        })
    };
}]);