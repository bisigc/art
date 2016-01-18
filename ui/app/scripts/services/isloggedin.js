'use strict';

/**
 * @ngdoc service
 * @name uiApp.isLoggedin
 * @description
 * # isLoggedin
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('isLoggedin', ['currentUser', function(currentUser) {
    return {
        check: function() {
            return currentUser.profile !== null;
        }
    };
}]);