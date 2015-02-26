app.controller("eeppiCtrl", function($scope, Tasks) {
	Tasks.get(function(response) {
		$scope.tasks = response;
		$scope.msg1 = "OK";
	}, function(error){
		$scope.rc = 0;
		$scope.msg1 = error;
	});
});

app.controller("adRepoElementCtrl", function($scope, Element) {
	Element.get(function(response) {
		$scope.element = response;
		$scope.msg2 = "OK";
	}, function(error){
		$scope.rc = 0;
		$scope.msg2 = error;
	});
});

app.controller("ownTaskCtrl", function($scope, OwnTasks) {
	OwnTasks.query(function(response) {
		$scope.owntasks = response;
		$scope.msg3 = "OK";
	}, function(error){
		$scope.rc = 0;
		$scope.msg3 = error;
	});
});
/*app.controller("eeppiCtrl", function($scope) {
$scope.tasks = JSON.parse('{"items":[{"id":1657,"name":"A new Task Template"},{"id":20,"name":"Define criterion values"}]}');
});*/
/*
$http.get("http://cbi:test@localhost:9990/taskTemplate")
.success(function(data, status, headers, config) {
	$scope.posts = data;})
.error(function(data, status, headers, config) {
	alert("Failed: " + status);
});
});
 */