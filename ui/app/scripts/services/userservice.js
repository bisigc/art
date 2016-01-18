'use strict';

/**
 * @ngdoc service
 * @name uiApp.UserService
 * @description
 * # UserService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('UserService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'user', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'user/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        pw: $resource(_contextPath + 'changepw', {}, {
            update: { method: 'PUT' }
        }), 
        login: $resource(_contextPath + 'login', {}, {
            login: { method: 'PUT' }
        }),
        logout: $resource(_contextPath + 'logout', {}, {
            logout: { method: 'GET' }
        })
    };
}]);