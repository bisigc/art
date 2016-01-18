'use strict';

/**
 * @ngdoc service
 * @name uiApp.CloudSmells
 * @description
 * # CloudSmells
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('CloudSmells', ['$http', function($http) {
    return {
        get: function() {
            return $http({method: 'GET', url: _contextPath + 'smell/forcloud', transformResponse: [] });
        }
    }
}]);