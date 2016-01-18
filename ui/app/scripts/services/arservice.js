'use strict';

/**
 * @ngdoc service
 * @name uiApp.ArService
 * @description
 * # ArService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ArService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'ar', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'ar/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
        /*$resource(_contextPath + 'arsearchcount', {}, {
            get: { method: 'POST' , transformResponse: [] }
        })*/
    };
}]);