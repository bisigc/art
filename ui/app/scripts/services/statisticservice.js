'use strict';

/**
 * @ngdoc service
 * @name uiApp.StatisticService
 * @description
 * # StatisticService
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('StatisticService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'stats', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);