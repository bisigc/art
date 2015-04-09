// ART services
app.factory("OwnTasks", function($resource) {
    return $resource("http://localhost:9000/listAll", {});
});

/*app.factory("CloudSmells", ['$resource', function($resource) {
    return $resource(_contextPath + 'smells/forcloud', 
                     {},
                     {get: {method:'GET', isArray: true}});
}]);*/

app.factory("CloudSmells", ['$http', function($http) {
    return {
        get: function() {
            return $http({method: "GET", url: _contextPath + 'smells/forcloud', transformResponse: [] });
            //return $http.get(_contextPath + 'smells/forcloud');
        }
    }
}]);

//{output: 'json', callback:'JSON_CALLBACK'},

app.factory("SmellsService", ['$resource', function($resource) {
    return $resource(_contextPath + 'smells', 
                     {},
                     {
        get: {method:'GET', isArray: true},
        create: { method: 'POST' }
    });
}]);

app.factory('SmellService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'smells/:id', {}, {
        get: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    });
}]);

app.factory('GroupService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'property/categorie/:cat', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory('MenuService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'menu', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory('StatusService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'status', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory("ExecTaskTypesService", ['$resource', function($resource) {
    return $resource(_contextPath + 'exectasktype', 
                     {},
                     {
        get: {method:'GET', isArray: true},
        create: { method: 'POST' }
    });
}]);

app.factory('ExecTaskTypeService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'exectasktype/:id', {}, {
        get: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    });
}]);

app.factory('EmptyExecTaskTypeService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'exectasktype/empty', {}, {
        get: { method: 'GET' }
    });
}]);


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
