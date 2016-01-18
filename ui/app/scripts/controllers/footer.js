'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:FooterCtrl
 * @description
 * # FooterCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('FooterCtrl', ['$scope', function($scope) {
	$scope.date = new Date();
}]);