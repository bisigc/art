'use strict';

/**
 * @ngdoc service
 * @name uiApp.SmellGroupService
 * @description
 * # SmellGroupService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('SmellGroupService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'smellgroup', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'smellgroup/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        assess: $resource(_contextPath + 'smellassessgroup', {}, {
            get: {method:'GET', isArray: true}
        })
    };
}]);