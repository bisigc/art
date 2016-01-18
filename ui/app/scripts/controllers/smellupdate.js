'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellupdateCtrl
 * @description
 * # SmellupdateCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellupdateCtrl', ['SmellService','SmellGroupService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$uibModalInstance', '$scope', '$stateParams', 'smellid', function (SmellService, SmellGroupService, StatusService, ReplyErrorHandler, notifications, $uibModalInstance, $scope, $stateParams, smellid) {
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.smell;
    $scope.initSmell = function () {
        $scope.smell = {};
        $scope.smell.questions = [];
        $scope.questionToAdd = '';
    }
    $scope.initSmell();
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.noid.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data, status, headers, config) {
            $scope.smell = data;
        }, ReplyErrorHandler);  
    };
    $scope.getSmell($stateParams.id);

    $scope.saveSmell = function() {
        SmellService.noid.update($scope.smell,function(data, status, headers, config) {
            $uibModalInstance.close();
            notifications.showSuccess('Smell has been updated.');
            $scope.smell = {};
        }, ReplyErrorHandler);
    };
    
    $scope.reload = function() {
        $scope.loadSmells();        
    }
       
    $scope.cancel = function(form) {
        $scope.initSmell();
        form.$setPristine();
        $uibModalInstance.dismiss('cancel');
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