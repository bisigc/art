'use strict';

/**
 * @ngdoc service
 * @name uiApp.UserSearchService
 * @description
 * # UserSearchService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('UserSearchService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'usersearch', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'usersearch/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);