'use strict';

/**
 * @ngdoc filter
 * @name uiApp.filter:toSafeHtml
 * @function
 * @description
 * # toSafeHtml
 * Filter in the uiApp.
 */
angular.module('uiApp')
  .filter('toSafeHtml', ['$sce', function($sce) {
    return function(text) {
        if(text) {
            return $sce.trustAsHtml(text);
        } else {
            return '';
        }
    }
}]);