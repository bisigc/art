(function(){
    var user = { name: 'Cbi', loggedin: true, avatar: 'images/avatars/avatar1.png' };
    var app = angular.module('art', []);


    app.controller('UserController', function(){
        this.user = user;
    });

    app.controller('MenuController', function(){
        this.menuItem = 'home';
        this.setMenu = function(selectedMenu) {
            this.menuItem = selectedMenu;
        };

        this.isMenuSet = function(isSet) {
            return isSet === this.menuItem;
        };
    });
})();