'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:TaskviewCtrl
 * @description
 * # TaskviewCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('TaskviewCtrl', ['TaskService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications', '$scope', '$stateParams', '$state', 'LastViewed', function(TaskService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $stateParams, $state, LastViewed) {
    $scope.task = {};
    
    $scope.loadTask =function() {
        TaskService.id.get({id: $stateParams.id}, function(data) { //, status, headers, config
            $scope.task = data;
            var item = {'name': $scope.task.name, 'type': 'Task', 'id': $scope.task.id};
            LastViewed.add(item);
        }, ReplyErrorHandler);  
    };
    $scope.loadTask();
    
    $scope.deleteTask = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this Task?'}).then(function () {//result
            TaskService.id.delete({id: id},function() { //data, status, headers, config
                $state.go('root.taskbrowser');
                notifications.showSuccess('Task has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };
}]);