'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:ArCtrl
 * @description
 * # ArCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('ArCtrl', ['ArService', 'ArVersionService', 'CloudSmells', 'ReplyErrorHandler', 'notifications','$scope','$filter', 'ConfirmModal', function(ArService, ArVersionService, CloudSmells, ReplyErrorHandler, notifications, $scope, $filter, ConfirmModal) {
    var orderBy = $filter('orderBy');
    $scope.arlist = []; //ars;
    this.formvisible = true;
    $scope.words = [];
    //$scope.words = words;
    $scope.cloudcallstatus = '&nbsp;<i class="glyphicon glyphicon-refresh glyphicon-refresh-animate"/> Loading...';
    
    $scope.loadArs = function () {
        ArVersionService.noid.get({},function(data) { //, status, headers, config
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();

    this.loadCloud = function () {
        CloudSmells.get().success(function(data){ //,status,headers,config
            var MYEVAL = eval;
            $scope.words = MYEVAL(data);
            $scope.cloudcallstatus = '';
        }).error(function(){ //data,status,headers,config
            $scope.cloudcallstatus = 'NOK';
            notifications.showError('Failed to load SmellCloud');
        });
    };
    this.loadCloud();

    this.showForm = function(visible) {
        if(visible === true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.order = function(predicate, reverse) {
        $scope.arlist = orderBy($scope.arlist, predicate, reverse);
    };
    
    $scope.order('name', false);

    // Not used global function setSmell is used
    /*$scope.setSmellFilter = function(smell) {
        //alert('Hell0');
        $scope.search.smells.name = smell;
        $scope.order();
    };*/

    this.ar = {};
    /*this.addAr = function() {
            this.ar.createdOn = Date.now();
            this.arlist.push(this.ar);
            this.ar = {};
        };*/
    $scope.deleteAr = function(id) {
        ConfirmModal.showModal({}, {headerText: 'Confirm', bodyText: 'Are you sure you want to delete the whole AR?'}).then(function () { //result
            ArService.id.delete({id: id}, function() { //data, status, headers, config
                notifications.showSuccess('Delete of AR with id ' + id + ' and his versions succsessful.');
                $scope.loadArs();
            }, ReplyErrorHandler);  
        }, function() {notifications.showInfo('Delete canceled.');});
    };
    
    $scope.getPDF = function(id) {
        ArVersionService.id.pdf({id: id}, function() { //data, status, headers, config
        }, ReplyErrorHandler);
    };
}]);