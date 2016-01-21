'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:UsersCtrl
 * @description
 * # UsersCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('UsersCtrl', ['UserService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications','$scope','$filter', function(UserService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.userlist = [];
    $scope.formvisible = false;

    $scope.showForm = function(visible) {
        if(visible === true) {
            $scope.formvisible = true;
        } else {
            $scope.formvisible = false;
        }
    };

    $scope.loadUsers = function () {
        UserService.noid.get({},function(data) { //, status, headers, config
            $scope.userlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadUsers();

    $scope.deleteProperty = function (id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this User?'}).then(function () {//result
            UserService.id.delete({id: id},function() { //data, status, headers, config
                $scope.loadUsers();
                notifications.showSuccess('User has been deleted.');
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };

    $scope.order = function(predicate, reverse) {
        $scope.userlist = orderBy($scope.userlist, predicate, reverse);
    };
    $scope.order('attribute', false);
}]);
