'use strict';

/**
 * @ngdoc service
 * @name uiApp.sharedSmell
 * @description
 * # sharedSmell
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('sharedSmell', [function () {
    var smellObject = {smell: {}};
    smellObject.clear = function () {
        angular.copy({}, this.smell);
    }
    return smellObject;
}]);