'use strict';

/**
 * @ngdoc service
 * @name uiApp.PasswordValidator
 * @description
 * # PasswordValidator
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('PasswordValidator', [function() {
    return {
        check: function(pw) {
            return {
                'valid': pw && /^(?=.*[A-Za-z])(?=.*[0-9]).{8,20}$/.test(pw),
                'constraints': 
                [
                    {'name': 'A-Za-z',       'valid': (pw && /[A-Za-z]/.test(pw)) ? true : false },
                    {'name': '0-9',          'valid': (pw && /[0-9]/.test(pw)) ? true : false },
                    {'name': 'Length(8-20)', 'valid': (pw && /.{8,20}/.test(pw)) ? true : false }
                    /*{"name": "equals",       "valid": (pw && pw == rpw) ? true : false }
                    {"name": "A-Z",          "valid": (pw && /[A-Z]/.test(pw)) ? true : false },
                    {"name": "a-z",          "valid": (pw && /[a-z]/.test(pw)) ? true : false },
                    {"name": "!@#$&*",       "valid": (pw && /[!@#$&*]/.test(pw)) ? true : false },*/
                ]
            };
        }
    };
}]);