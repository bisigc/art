'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ArviewCtrl
 * @description
 * # ArviewCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ArviewCtrl', ['ArService', 'ReplyErrorHandler', '$stateParams', '$state', 'notifications', '$scope', '$filter', 'ConfirmModal','LastViewed', function(ArService, ReplyErrorHandler, $stateParams, $state, notifications, $scope, $filter, ConfirmModal, LastViewed) {
    var orderBy = $filter('orderBy');
    $scope.ar = {};
    $scope.discussion_id;

    $scope.currentar = [];
    $scope.discussion_id = null;
    //$scope.comments;
    $scope.setCurrentAr = function(id) {
        $scope.currentar = $scope.ar.versions[id];
        $scope.discussion_id = $scope.currentar.discussion.id;
        //$scope.comments = $scope.currentar.discussion.comments;
    }
    
    
    // Get Task Exeuction Type
    $scope.getType = function(propArray) {
        if(propArray) {
            for(var i = 0; i < propArray.length; i++) {
                if(propArray[i].property.name == 'Type') {
                    return propArray[i].value;
                }
            }
        }
        return "";
    }

    $scope.loadAr = function() {
        ArService.id.get({id: $stateParams.id},function(data, status, headers, config) {
            $scope.ar = data;
            $scope.ar.versions = orderBy($scope.ar.versions, 'created', true);
            $scope.setCurrentAr(0);
            var item = {'name': $scope.ar.versions[0].name, 'type': 'AR', 'id': $scope.ar.id};
            LastViewed.add(item);
        }, ReplyErrorHandler);
    }
    $scope.loadAr();
    
    $scope.deleteAr = function(id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete the whole AR?'}).then(function (result) {
            ArService.id.delete({id: id},function(data, status, headers, config) {
                notifications.showSuccess('Ar ' + id + ' has been deleted.');
                $state.go('root.arbrowser');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.')});
    }
    
    $scope.deleteArVersion = function(id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this ArVersion?'}).then(function (result) {
            for(var i = 0, max = $scope.ar.versions.length; i < max; i++) {
                var a = $scope.ar.versions[i];

                if(a.id === id) {
                    $scope.ar.versions.splice(i, 1);
                    break;
                }
            }

            ArService.noid.update($scope.ar,function(data, status, headers, config) {
                notifications.showSuccess('ArVersion ' + id + ' has been removed.');
                $scope.loadAr();
            }, ReplyErrorHandler);
            /*ArVersionService.id.delete({id: id},function(data, status, headers, config) {
                notifications.showSuccess("ArVersion " + id + " has been deleted.");
                $scope.loadAr();
            }, ReplyErrorHandler);*/
        }, function() {notifications.showInfo('Delete canceled.')});
    }

}]);