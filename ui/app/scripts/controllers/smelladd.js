'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmelladdCtrl
 * @description
 * # SmelladdCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmelladdCtrl', ['SmellService', 'SmellGroupService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$scope', 'sharedSmell', function(SmellService, SmellGroupService, StatusService, ReplyErrorHandler, notifications, $scope, sharedSmell) {
    $scope.smell = sharedSmell.smell;
    $scope.questionToAdd;
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
            $scope.smell.status = $scope.status[0];
        }, ReplyErrorHandler);
    };
    $scope.loadStatus();
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.noid.get({},function(data, status, headers, config) {
            $scope.groups = data;
            $scope.smell.group = $scope.groups[0];
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();
    $scope.initSmell = function () {
        sharedSmell.clear();
        $scope.smell.questions = [];
        $scope.smell.tecdebtidx = 'mm';
        $scope.questionToAdd = '';
    }
    $scope.initSmell();
    $scope.saveSmell = function(form) {
        SmellService.noid.create($scope.smell,function(data, status, headers, config) {
            if($scope.loadSmells) {
                $scope.loadSmells();
            }
            notifications.showSuccess('Smell has been added.');
            $scope.initSmell();
            form.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.cancel = function(form) {
        $scope.initSmell();
        $scope.smell.status = $scope.status[0];
        $scope.smell.group = $scope.groups[0];
        form.$setPristine();
    }
    
    $scope.addQuestion = function () {
        $scope.smell.questions.push({
            question: $scope.questionToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeQuestion = function (idx) {
        $scope.smell.questions.splice(idx, 1);
    };

}]);
