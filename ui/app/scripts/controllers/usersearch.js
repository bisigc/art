'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:UsersearchCtrl
 * @description
 * # UsersearchCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('UsersearchCtrl', ['UserSearchService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications','$scope', function(UserSearchService, ReplyErrorHandler, ConfirmModal, notifications, $scope) {
    $scope.searchlist = []; //ars;
    
    $scope.loadSearches = function () {
        UserSearchService.noid.get({},function(data) { //, status, headers, config
            $scope.searchlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadSearches();
    
    $scope.deleteSearch = function(searchid) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete this search?'}).then(function () {//result
            UserSearchService.id.delete({id: searchid},function() { //data, status, headers, config
                notifications.showSuccess('User search has been deleted.');
                $scope.loadSearches();
            }, ReplyErrorHandler);
        }, function() {notifications.showInfo('Delete canceled.');});
    };
}]);