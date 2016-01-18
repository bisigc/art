'use strict';

/**
 * @ngdoc service
 * @name uiApp.StatusService
 * @description
 * # StatusService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('StatusService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'status', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);