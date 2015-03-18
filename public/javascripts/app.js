(function(){
    var user = { name: 'Cbi', loggedin: true, avatar: 'images/avatars/avatar1.png' };
    var ars = [];
    var app = angular.module('art', ['ui.bootstrap']);


    app.controller('UserController', function(){
        this.user = user;
    });

    app.controller('MenuController', function(){
        this.menuItems = [
            {"id":1,  "name": "home",         "fullname":"home",                                       "image":"images/art_logo_small.png", "type":"home",          "url":"home.html", "pos":"left", "order":5, "subItems":[]},
            {"id":2,  "name": "ars",          "fullname":"Architectural Refactorings",                 "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":10, "subItems":[]},
            {"id":3,  "name": "addar",        "fullname":"Add Architectural Refactoring",              "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":15, "subItems":[]},
            {"id":4,  "name": "exectasks",    "fullname":"Execution Task",                             "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":20, "subItems":[]},
            {"id":5,  "name": "add-exectask", "fullname":"Add Execution Task Template",                "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":25, "subItems":[]},
            {"id":6,  "name": "smells",       "fullname":"Architectural Smells",                       "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":30, "subItems":[]},
            {"id":7,  "name": "armeta",       "fullname":"Architectural Refactoring Meta Information", "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":40, "subItems":[]},
            {"id":8,  "name": "wiki",         "fullname":"Wikipedia",                                  "image":"",                          "type":"link",          "url":"http://www.wikipedia.com", "pos":"left", "order":40, "subItems":[]},
            {"id":8,  "name": "admin",        "fullname":"Administration",                             "image":"",                          "type":"dropdown",      "url":"home.html", "pos":"right", "order":45, "subItems":[{"id":11, "name": "Users", "image":"", "type":"include", "url":"useradmin.html", "pos":"left", "order":15, "subItems":[]}]},
            {"id":9,  "name": "profile",      "fullname":"Profile",                                    "image":"",                          "type":"include",       "url":"home.html", "pos":"right", "order":50, "subItems":[]},
            {"id":10, "name": "login",        "fullname":"Login",                                      "image":"",                          "type":"login-logout",  "url":"home.html", "pos":"right", "order":55, "subItems":[]}
        ];
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
    
    

 // ART services
 app.factory("OwnTasks", function($resource) {
 	return $resource("http://localhost:9000/listAll", {});
 });

 // EEPPI services
 app.factory("Tasks", function($resource) {
 	return $resource("http://localhost:9990/taskTemplate", {});
 });

 app.factory("Login", function($resource) {
 	return $resource("http://localhost:9990/user/login?name=cbi&password=test", {});
 });

 // ADRepo
 app.factory("Element", function($resource) {
 	return $resource("http://localhost:9940/element/19", {});
 });

})();