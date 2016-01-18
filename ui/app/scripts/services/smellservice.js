'use strict';

/**
 * @ngdoc service
 * @name uiApp.SmellService
 * @description
 * # SmellService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('SmellService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'smell', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'smell/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);