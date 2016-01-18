'use strict';

/**
 * @ngdoc service
 * @name uiApp.DiscussionService
 * @description
 * # DiscussionService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('DiscussionService', ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'discussion', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'discussion/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);