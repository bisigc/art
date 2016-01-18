'use strict';

/**
 * @ngdoc service
 * @name uiApp.ArVersionService
 * @description
 * # ArVersionService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ArVersionService', ['$resource', '$http', function($resource, $http) {
    return {
        noid: $resource(_contextPath + 'arversion', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'arversion/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        search: $resource(_contextPath + 'arsearch', {}, {
            get: { method: 'POST', isArray: true }
        }),
        count: function(smellids){
            return $http.post(_contextPath + 'arsearchcount', smellids, { transformResponse: [] });
        }
    };
}]);