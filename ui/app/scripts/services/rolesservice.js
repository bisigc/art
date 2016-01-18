'use strict';

/**
 * @ngdoc service
 * @name uiApp.RolesService
 * @description
 * # RolesService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('RolesService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'userroles', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);