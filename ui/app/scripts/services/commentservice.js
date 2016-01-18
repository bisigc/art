'use strict';

/**
 * @ngdoc service
 * @name uiApp.CommentService
 * @description
 * # CommentService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('CommentService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'comment', {}, {
            get: { method:'GET', isArray: true },
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'comment/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        like: $resource(_contextPath + 'like/:id', {}, {
            like: { method: 'PUT', params: {id: '@id'} }
        })
    };
}]);