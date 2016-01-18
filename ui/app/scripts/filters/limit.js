'use strict';

/**
 * @ngdoc filter
 * @name uiApp.filter:limit
 * @function
 * @description
 * # limit
 * Filter in the uiApp.
 */
angular.module('uiApp')
  .filter('limit', function() {
    return function(text, limit) {

        if(text) {
            return text.length > limit ? text.substr(0, limit - 1) + '...' : text;
        }
        return '';
    };
});