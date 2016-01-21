'use strict';

/**
 * @ngdoc service
 * @name uiApp.PropertyService
 * @description
 * # PropertyService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('PropertyService', ['$resource', function ($resource) {
    return {
        noid: $resource(_contextPath + 'property', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'property/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        categorie: $resource(_contextPath + 'property/categorie/:cat/:lang', {}, {
            get: { method: 'GET', isArray: true }
        })
    };
}]);