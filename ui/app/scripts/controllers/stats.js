'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:StatsCtrl
 * @description
 * # StatsCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('StatsCtrl', ['StatisticService', 'ReplyErrorHandler', 'notifications', '$scope', function(StatisticService, ReplyErrorHandler, notifications, $scope){
    $scope.stats = [];
    StatisticService.get({},function(data) { //, status, headers, config
        $scope.stats = data;
    }, ReplyErrorHandler); 
}]);