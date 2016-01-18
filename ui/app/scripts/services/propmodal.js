'use strict';

/**
 * @ngdoc service
 * @name uiApp.PropModal
 * @description
 * # PropModal
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('PropModal', ['$uibModal', function($uibModal) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelelementaddCtrl',
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
            
            /*$stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };*/

        }
        
    };
}]);