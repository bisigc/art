'use strict';

/**
 * @ngdoc service
 * @name uiApp.ReplyErrorHandler
 * @description
 * # ReplyErrorHandler
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('ReplyErrorHandler', ['currentUser', 'notifications', '$log', '$state', function(currentUser, notifications, $log, $state) {
    return function(error) { //, msg) {
        //$log.debug("data: " + error['data'] + " Text: " + error['statusText'] + ", Status: " + error['status'] + ", config: " + error['config']['url']+ ", method: " + error['config']['method']);
        if(error.status === 401) {
            if(error.data === 'Session timeout') {
                delete currentUser.profile;
                notifications.showError('Session timeout, please relogin');
            } else {
                notifications.showError(error.data + ' [' + error.status + '] to ' + error.config.method + ' ' + error.config.url);
            }
        } else if(error.status === 400) {
            notifications.showError(error.data);
        } else if(error.status === 404) {
            $state.go('root.404');
            notifications.showError('Object not found, ' + '[' + error.status + '], ' + error.config.url);
        } else if(error.status === 409) {
            notifications.showInfo(error.data);
        } else if(error.status === 422) {
            notifications.showError(error.data);
        } else if(error.status === 500) {
            notifications.showError(error.data + ', Technical error [' + error.status + '], failed to ' + error.config.method + ' ' + error.config.url);
        } else {
            notifications.showError(error.data + ', Unknown error [' + error.status + '], failed to ' + error.config.method + ' ' + error.config.url);
        }
    };
}]);