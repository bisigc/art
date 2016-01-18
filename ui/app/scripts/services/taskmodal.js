'use strict';

/**
 * @ngdoc service
 * @name uiApp.TaskModal
 * @description
 * # TaskModal
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('TaskModal', ['$uibModal', function($uibModal) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'taskdialog.html',
                    controller: 'TaskmodaladdCtrl',
                    // Prevents the modal from closing when clicking outside of the box
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return modaltype;
                        }
                    }
                }
            );
            modalInstance.result.then(function(result) {okfunction(result);}, dissmissedfunction);
        }
    };
}]);