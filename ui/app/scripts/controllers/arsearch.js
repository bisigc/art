'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ArsearchCtrl
 * @description
 * # ArsearchCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ArsearchCtrl', ['ArService', 'ArVersionService', 'UserSearchService', 'ReplyErrorHandler', 'ConfirmModal', 'notifications','$scope', '$stateParams', '$filter', '$state', function(ArService, ArVersionService, UserSearchService, ReplyErrorHandler, ConfirmModal, notifications, $scope, $stateParams, $filter, $state) {
    var orderBy = $filter('orderBy');
    $scope.arlist = []; //ars;
    $scope.arsearch = {};
    $scope.loadArs = function () {
        ArVersionService.search.get(JSON.parse($stateParams.smellids),function(data) { //, status, headers, config
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();

    $scope.order = function(predicate, reverse) {
        $scope.arlist = orderBy($scope.arlist, predicate, reverse);
    };
    
    $scope.order('name', false);
    
    $scope.saveSearch = function(form) {
        $scope.arsearch.search = $stateParams.smellids;
        UserSearchService.noid.create($scope.arsearch, function() { //data, status, headers, config
            notifications.showSuccess('Search has been added to your profile.');
            $scope.arsearch = {};
            form.$setPristine();
            $state.go('root.usersearches');
        }, ReplyErrorHandler);  
    };
    
    $scope.deleteAr = function(id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete the whole AR?'}).then(function () { //result
            ArService.id.delete({id: id}, function() { //data, status, headers, config
                notifications.showSuccess('Delete of AR with id ' + id + ' and his versions succsessful.');
                $scope.loadArs();
            }, ReplyErrorHandler);  
        }, function() {notifications.showInfo('Delete canceled.');});
    };
}]);