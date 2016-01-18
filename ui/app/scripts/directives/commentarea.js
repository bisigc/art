'use strict';

/**
 * @ngdoc directive
 * @name uiApp.directive:commentArea
 * @description
 * # commentArea
 */
angular.module('uiApp')
  .directive('commentArea', function() {
   return {
        restrict: 'EA',
        scope: {
            datasource: '=',
            add: '&',
        },
        controller: function ($scope) {
            $scope.addCustomer = function () {
                //Call external scope's function
                var name = 'New Customer Added by Directive';

                $scope.add()(name);
            };
        },
        template: '<button ng-click="addCustomer()">Change Data</button><ul>' +
                  '<li ng-repeat="cust in customers">{{ cust.name }}</li></ul>'
    };
});