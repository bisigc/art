(function(){
    var user = { "name": 'Cbi', "loggedin": true, "avatar": 'images/avatars/avatar1.png' };
    var ars = [{ "name":"AR1", "desc":"blabladesc 1", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR2", "desc":"Holderadio 2", "smells":[{"id":2,"name":"Smell2"},{"id":5,"name":"Smell5"}] }, { "name":"AR3", "desc":"Auto Velo 3", "smells":[{"id":2,"name":"Smell2"},{"id":7,"name":"Smell7"}] }, { "name":"AR4", "desc":"blabladesc 1", "smells":[{"id":2,"name":"Smell2"},{"id":6,"name":"Smell6"}] }, { "name":"AR5", "desc":"Holderadio 2", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }, { "name":"AR6", "desc":"Auto Velo 3", "smells":[{"id":3,"name":"Smell3"},{"id":5,"name":"Smell5"}] }, { "name":"AR7", "desc":"blabladesc 1", "smells":[{"id":3,"name":"Smell3"},{"id":4,"name":"Smell4"}] }, { "name":"AR8", "desc":"Holderadio 2", "smells":[{"id":4,"name":"Smell4"},{"id":7,"name":"Smell7"}] }, { "name":"AR9", "desc":"Auto Velo 3", "smells":[{"id":1,"name":"Smell1"},{"id":5,"name":"Smell5"}] }];
    var app = angular.module('art', ['ui.bootstrap','angular-jqcloud']);
    var menuItems = [
        {"id":1,  "name": "home",         "fullname":"home",                                       "image":"images/art_logo_small.png", "type":"home",          "url":"home.html", "pos":"left", "order":5, "subItems":[]},
        {"id":2,  "name": "ars",          "fullname":"ARs",                                        "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":10, "subItems":[]},
        {"id":3,  "name": "addar",        "fullname":"Add AR",                                     "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":15, "subItems":[]},
        {"id":4,  "name": "exectasks",    "fullname":"Exec. Tasks",                                "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":20, "subItems":[]},
        {"id":5,  "name": "add-exectask", "fullname":"Add Exec. Task Templ.",                      "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":25, "subItems":[]},
        {"id":6,  "name": "smells",       "fullname":"Architectural Smells",                       "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":30, "subItems":[]},
        {"id":7,  "name": "armeta",       "fullname":"AR Meta Info",                               "image":"",                          "type":"include",       "url":"home.html", "pos":"left", "order":40, "subItems":[]},
        //{"id":8,  "name": "wiki",         "fullname":"Wikipedia",                                  "image":"",                          "type":"link",          "url":"http://www.wikipedia.com", "pos":"left", "order":40, "subItems":[]},
        {"id":8,  "name": "admin",        "fullname":"Admin",                                      "image":"",                          "type":"dropdown",      "url":"home.html", "pos":"left", "order":45, "subItems":[{"id":11, "name": "users", "fullname": "Users","image":"", "type":"include", "url":"useradmin.html", "pos":"left", "order":15, "subItems":[]}]},
        {"id":9,  "name": "profile",      "fullname":"Profile",                                    "image":"",                          "type":"include",       "url":"home.html", "pos":"right", "order":50, "subItems":[]},
        {"id":10, "name": "login",        "fullname":"Login",                                      "image":"",                          "type":"login-logout",  "url":"home.html", "pos":"right", "order":55, "subItems":[]}
    ];

    var words = [
        {text: "Smell1", weight: 13, handlers: {
            click: function() {
                //ARController.setSmellFilter('Smell1');
                artCtrl.search.smells.name = 'Smell1';
            }
        }},
        {text: "Smell4", weight: 10.5},
        {text: "Smell2", weight: 9.4}
    ];

    app.controller('UserController', function(){
        this.user = user;
        this.login = function() {
            this.user.loggedin = true;
        }
        this.logout = function() {
            this.user.loggedin = false;
        }
    });

    app.controller('MenuController', function(){
        this.menuItems = menuItems;
        this.menuItem = 'ars';
        this.setMenu = function(selectedMenu) {
            this.menuItem = selectedMenu;
        };

        this.isMenuSet = function(isSet) {
            return isSet === this.menuItem;
        };
    });

    app.controller('ARController', ['$scope','$filter', function($scope, $filter) {
        var orderBy = $filter('orderBy');
        this.arlist = ars;
        this.formvisible = true;
        this.words = words;
        this.showForm = function(visible) {
            if(visible == true) {
                this.formvisible = true;
            } else {
                this.formvisible = false;
            }
        };

        this.setSmellFilter = function(smell) {
            $scope.search.smells.name = smell;
        }

        this.order = function(predicate, reverse) {
            this.arlist = orderBy(this.arlist, predicate, reverse);
        };
        this.order('name', false);

        this.ar = {};
        /*this.addAr = function() {
            this.ar.createdOn = Date.now();
            this.arlist.push(this.ar);
            this.ar = {};
        };*/
        
         $scope.totalItems = 64;
  $scope.currentPage = 4;

  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.pageChanged = function() {
    $log.log('Page changed to: ' + $scope.currentPage);
  };

  $scope.maxSize = 5;
  $scope.bigTotalItems = 175;
  $scope.bigCurrentPage = 1;


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


    }]);



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