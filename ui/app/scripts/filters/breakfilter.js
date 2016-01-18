'use strict';

/**
 * @ngdoc filter
 * @name uiApp.filter:breakFilter
 * @function
 * @description
 * # breakFilter
 * Filter in the uiApp.
 */
angular.module('uiApp')
  .filter('breakFilter', function () {
    return function (text) {
        if (typeof text !== 'undefined' && text !== null && text !== '') {
            return text.replace(/\n/g, '<br />');
        }
    };
});