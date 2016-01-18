'use strict';

/**
 * @ngdoc service
 * @name uiApp.ModelElementService
 * @description
 * # ModelElementService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ModelElementService', ['$resource', function($resource) {
    return {
        type: $resource(_contextPath + 'modelelement/type', {}, {
            get: {method:'GET', isArray: true}
        }),
        qas: $resource(_contextPath + 'modelelement/qas', {}, {
            get: {method:'GET', isArray: true}
        }),
        components: $resource(_contextPath + 'modelelement/components', {}, {
            get: {method:'GET', isArray: true}
        }),
        context: $resource(_contextPath + 'modelelement/context', {}, {
            get: {method:'GET', isArray: true}
        }),
        decisions: $resource(_contextPath + 'modelelement/decisions', {}, {
            get: {method:'GET', isArray: true}
        }),
        references: $resource(_contextPath + 'modelelement/references', {}, {
            get: {method:'GET', isArray: true}
        }),
        noid: $resource(_contextPath + 'modelelement', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'modelelement/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);