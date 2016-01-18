'use strict';

/**
 * @ngdoc service
 * @name uiApp.FileUploader
 * @description
 * # FileUploader
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('FileUploader', ['$http', function($http) {
    return {
        upload: function(file, uploadUrl){
            var fd = new FormData();
            fd.append('file', file);
            return $http.post(uploadUrl, fd, {transformRequest: angular.identity, headers: {'Content-Type': undefined} });
        }
    };
}]);