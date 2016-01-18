'use strict';

/**
 * @ngdoc service
 * @name uiApp.MenuService
 * @description
 * # MenuService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('MenuService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'menu', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);