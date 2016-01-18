'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:MenuCtrl
 * @description
 * # MenuCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('MenuCtrl', ['MenuService', 'ReplyErrorHandler', 'LastViewed', 'notifications', '$scope', function(MenuService, ReplyErrorHandler, LastViewed, notifications, $scope){
    $scope.menuItems = [];
    $scope.lastViewedItems = LastViewed.list;
    MenuService.get({},function(data, status, headers, config) {
        $scope.menuItems = data;
    }, ReplyErrorHandler); 
}]);