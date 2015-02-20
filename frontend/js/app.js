(function(){
    var user = { name: 'Cbi', loggedin: true, avatar: 'images/avatars/avatar1.png' };
    var ars = [];
    var app = angular.module('art', ['ui.bootstrap']);


    app.controller('UserController', function(){
        this.user = user;
    });

    app.controller('MenuController', function(){
        this.menuItem = 'ars';
        this.setMenu = function(selectedMenu) {
            this.menuItem = selectedMenu;
        };

        this.isMenuSet = function(isSet) {
            return isSet === this.menuItem;
        };
    });

    app.controller('ARController', function() {
        this.arlist = ars;
        this.formvisible = true;
        this.showForm = function(visible) {
            if(visible == true) {
                this.formvisible = true;
            } else {
                this.formvisible = false;
            }
        };

        this.ar = {};
        this.addAr = function() {
            this.ar.createdOn = Date.now();
            this.arlist.push(this.ar);
            this.ar = {};
        };


        this.progMax = 200;

        this.setProgValue = function() {

            this.progStacked = [];
            var types = ['success', 'info', 'warning', 'danger'];

            for (var i = 0, n = Math.floor((Math.random() * 4) + 1); i < n; i++) {
                var index = Math.floor((Math.random() * 4));
                this.progStacked.push({
                    value: Math.floor((Math.random() * 30) + 1),
                    type: types[index]
                });
            }
            /*       
            var value = Math.floor((Math.random() * 100) + 1);
            var type;

            if (value < 25) {
                type = 'success';
            } else if (value < 50) {
                type = 'info';
            } else if (value < 75) {
                type = 'warning';
            } else {
                type = 'danger';
            }

            this.showProgWarning = (type === 'danger' || type === 'warning');

            this.progDynamic = value;
            this.progType = type;
            */
        };
        this.setProgValue();


    });
})();