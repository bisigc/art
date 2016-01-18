'use strict';

/**
 * @ngdoc filter
 * @name uiApp.filter:arPropFilter
 * @function
 * @description
 * # arPropFilter
 * Filter in the uiApp.
 */
angular.module('uiApp')
  .filter('arPropFilter', function () {
    return function (props, type) {
        var arrayToReturn = []; 
        if (angular.isArray(props)) {
            for (var i=0; i<props.length; i++){
                if (props[i].type === type) {
                    arrayToReturn.push(props[i]);
                }
            }
        }
        return arrayToReturn;
    };
});