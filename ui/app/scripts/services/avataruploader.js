'use strict';

/**
 * @ngdoc service
 * @name uiApp.AvatarUploader
 * @description
 * # AvatarUploader
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('AvatarUploader', ['FileUploader', '$resource', function(FileUploader) {
    return {
        upload: function(file){
            return FileUploader.upload(file, _contextPath + 'avatar');
        }
    };
}]);