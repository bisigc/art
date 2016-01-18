'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:SmellviewCtrl
 * @description
 * # SmellviewCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('SmellviewCtrl', ['SmellService', 'ArVersionService', 'ConfirmModal', 'ReplyErrorHandler', 'notifications', '$stateParams', '$state', '$scope','LastViewed', function (SmellService, ArVersionService, ConfirmModal, ReplyErrorHandler, notifications, $stateParams, $state, $scope, LastViewed) {
    $scope.smell = {};
    $scope.smellids = {'smellids': [] };
    
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data) { //, status, headers, config
            $scope.smell = data;
            var item = {'name': $scope.smell.name, 'type': 'Smell', 'id': $scope.smell.id};
            LastViewed.add(item);
        }, ReplyErrorHandler);
    };
    $scope.getSmell($stateParams.id);
    
    $scope.deleteSmell = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Smell?'}).then(function () {//result
            SmellService.id.delete({id: id},function() { //data, status, headers, config
                $state.go('root.smellbrowser');
                notifications.showSuccess('Smell has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };

    $scope.loadArs = function () {
        $scope.smellids.smellids.push($stateParams.id);
        ArVersionService.search.get($scope.smellids,function(data) { //, status, headers, config
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();
}]);
