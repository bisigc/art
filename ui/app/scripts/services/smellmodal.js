'use strict';

/**
 * @ngdoc service
 * @name uiApp.SmellModal
 * @description
 * # SmellModal
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('SmellModal', ['$uibModal', function($uibModal) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellmodaladdCtrl',
                    size: 'lg',
                    // Prevents the modal from closing when clicking outside of the box
                    backdrop: 'static',
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