'use strict';

/**
 * @ngdoc directive
 * @name uiApp.directive:hilighter
 * @description
 * # hilighter
 */
angular.module('uiApp')
  .directive('hilighter', ['$timeout', function($timeout) {
  return {
    restrict: 'A',
    scope: {
      model: '=hilighter'
    },
    link: function(scope, element) {
      scope.$watch('model', function (nv, ov) {
        if (nv !== ov) {
          // apply class
          element.addClass('label-success');
          element.removeClass('label-default');

          // auto remove after some delay
          $timeout(function () {
            element.removeClass('label-success');
            element.addClass('label-default');
          }, 1000);
        }
      });
    }
  };
}]);