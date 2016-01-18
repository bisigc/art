'use strict';

/**
 * @ngdoc directive
 * @name uiApp.directive:compile
 * @description
 * # compile
 */
angular.module('uiApp')
  .directive('compile', ['$compile', '$timeout', function($compile, $timeout){
    return {
        restrict:'A',
        link: function(scope,elem){//,attrs
            $timeout(function(){
                $compile(elem.contents())(scope);    
            },100);
        }
    };
}]);