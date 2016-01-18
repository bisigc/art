'use strict';

/**
 * @ngdoc filter
 * @name uiApp.filter:limitHtml
 * @function
 * @description
 * # limitHtml
 * Filter in the uiApp.
 */
angular.module('uiApp')
  .filter('limitHtml', function() {
    return function(text, limit) {

        if(text) {
            var changedString = String(text).replace(/<[^>]+>/gm, '');
            var length = changedString.length;
            return changedString.length > limit ? changedString.substr(0, limit - 1) + '...' : changedString; 
        }
        return '';
    }
});