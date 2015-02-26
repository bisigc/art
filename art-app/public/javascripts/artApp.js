//var app = angular.module("artApp", [ 'ngResource', 'ngRoute' ]);
var app = angular.module("artApp", [ 'ngResource' ]);
//app.value("version","0.1");

//Factories for REST services

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
