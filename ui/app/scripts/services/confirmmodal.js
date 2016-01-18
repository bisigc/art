'use strict';

/**
 * @ngdoc service
 * @name uiApp.ConfirmModal
 * @description
 * # ConfirmModal
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ConfirmModal', ['$uibModal', function ($uibModal) {
      var modalDefaults = {
          backdrop: true,
          keyboard: true,
          modalFade: true,
          templateUrl:  _contextPath + 'confirmdialog.html',
      };
      
      var modalOptions = {
          closeButtonText: 'Cancel',
          actionButtonText: 'Yes',
          headerText: 'Proceed?',
          bodyText: 'Perform this action?'
      };
      
      return {
          showModal: function (customModalDefaults, customModalOptions) {
              if (!customModalDefaults) customModalDefaults = {};
              customModalDefaults.backdrop = 'static';
              return this.show(customModalDefaults, customModalOptions);
          },
          
          show: function (customModalDefaults, customModalOptions) {
              //Create temp objects to work with since we're in a singleton service
              var tempModalDefaults = {};
              var tempModalOptions = {};
              
              //Map angular-ui modal custom defaults to modal defaults defined in service
              angular.extend(tempModalDefaults, modalDefaults, customModalDefaults);
              //Map modal.html $scope custom properties to defaults defined in service
              angular.extend(tempModalOptions, modalOptions, customModalOptions);
              
              if (!tempModalDefaults.controller) {
                  tempModalDefaults.controller = function ($scope, $modalInstance) {
                      $scope.modalOptions = tempModalOptions;
                      $scope.modalOptions.ok = function (result) {
                          $modalInstance.close(result);
                      };
                      $scope.modalOptions.close = function (result) {
                          $modalInstance.dismiss('cancel');
                      };
                  }
              }
              return $uibModal.open(tempModalDefaults).result;
          }
      };
}]);