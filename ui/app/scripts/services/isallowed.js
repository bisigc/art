'use strict';

/**
 * @ngdoc service
 * @name uiApp.isAllowed
 * @description
 * # isAllowed
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('isAllowed', ['currentUser', function(currentUser) {
    return {
        check: function(roleArray) {
            return currentUser.profile != null && !(roleArray.indexOf(currentUser.profile.role.name) == -1);
        }
    }
}]);