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
    return $resource(_contextPath + 'property/categorie/:cat', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);