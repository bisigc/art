'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellassessCtrl
 * @description
 * # SmellassessCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellassessCtrl', ['ArVersionService', 'SmellGroupService', 'ReplyErrorHandler', 'notifications', '$scope', '$state', function(ArVersionService, SmellGroupService, ReplyErrorHandler, notifications, $scope, $state) {
    $scope.counter;
    $scope.groups = [];
    $scope.groupToggle = [];
    $scope.groupAllCheck = [];
    $scope.arlist = [];
    SmellGroupService.assess.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    $scope.selectedSmells = {"smellids": [] };
    
    $scope.groupAllshow = false;
    $scope.groupToggleAll = function() {
        $scope.groupAllshow = !$scope.groupAllshow;
        for(var i = 0;i < $scope.groupToggle.length;i++) {
            $scope.groupToggle[i] = $scope.groupAllshow;
        }
    }
    
    $scope.toggleGroupSelect = function(index) {
        $scope.groupAllCheck[index] = !$scope.groupAllCheck[index];
        for(var i=0; i<$scope.groups[index].smells.length ;i++) {
            var n=$scope.groups[index].smells[i];
            var idx = $scope.selectedSmells.smellids.indexOf(n.id);

            if($scope.groupAllCheck[index]) {
                if (idx == -1) {
                    $scope.selectedSmells.smellids.push(n.id);                	
                }
            } else {
                if (idx > -1) {
                    $scope.selectedSmells.smellids.splice(idx, 1);
                }            	
            }
        }
        $scope.getSmellCount();
    }
    
    $scope.loadArs = function () {
        ArVersionService.search.get($scope.selectedSmells,function(data, status, headers, config) {
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    
    $scope.getSmellCount = function () {
    	if($scope.selectedSmells.smellids.length != 0) {
	        ArVersionService.count($scope.selectedSmells).success(function(data,status,headers,config){
	            $scope.counter = data;
	        }).error(function(data,status,headers,config){
	            notifications.showError('Failed to get Ar count.');
	        });
            $scope.loadArs();
    	} else {
            $scope.counter = 0;
            $scope.arlist = [];
    	}
    };

    $scope.resetForm = function() {
        $scope.selectedSmells = {"smellids": [] };
        $scope.groupAllCheck = [];
        $scope.counter = 0;
    };
    
    $scope.resetForm();
    
    $scope.executeSearch = function() {
        $state.go('root.arsearch', {smellids: JSON.stringify($scope.selectedSmells)})
    }
    
    $scope.toggleSelection = function toggleSelection(smell_id) {
        var idx = $scope.selectedSmells.smellids.indexOf(smell_id);

        // is currently selected
        if (idx > -1) {
            $scope.selectedSmells.smellids.splice(idx, 1);
        }
        // is newly selected
        else {
            $scope.selectedSmells.smellids.push(smell_id);
        }
        $scope.getSmellCount();
    };
    
}]);