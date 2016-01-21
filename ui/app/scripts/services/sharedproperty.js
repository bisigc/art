'use strict';

/**
 * @ngdoc service
 * @name uiApp.sharedProperty
 * @description
 * # sharedProperty
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('sharedProperty', [function () {
    var propertyObject = {property: {}};
    propertyObject.clear = function () {
        angular.copy({}, this.property);
    };
    return propertyObject;
}]);