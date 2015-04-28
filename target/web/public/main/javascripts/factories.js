// ART services
app.factory("OwnTasks", function($resource) {
    return $resource("http://localhost:9000/listAll", {});
});

app.factory("isAllowed", ['currentUser', function(currentUser) {
    return {
        check: function(roleArray) {
            return currentUser.profile != null && !(roleArray.indexOf(currentUser.profile.role.name) == -1);
        }
    }
}]);

app.factory("ReplyErrorHandler", ['currentUser', 'notifications', '$log', function(currentUser, notifications, $log) {
    return function(error) { //, msg) {
        //$log.debug("data: " + error['data'] + " Text: " + error['statusText'] + ", Status: " + error['status'] + ", config: " + error['config']['url']+ ", method: " + error['config']['method']);
        if(error['status'] == 401) {
            if(error['data'] === "Session timeout") {
                delete currentUser.profile;
                notifications.showError("Session timeout, please relogin");
            } else {
                notifications.showError(error['data'] + " [" + error['status'] + "] to " + error['config']['method'] + " " + error['config']['url']);
            }
        } else if(error['status'] == 501) {
            notifications.showError(error['data'] + ", Technical error [" + error['status'] + "], failed to " + error['config']['method'] + " " + error['config']['url']);
        } else {
            notifications.showError(error['data'] + ", Technical error [" + error['status'] + "], failed to " + error['config']['method'] + " " + error['config']['url']);
        }
    }
}]);

app.factory("ArService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'ar', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'ar/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);

app.factory("CloudSmells", ['$http', function($http) {
    return {
        get: function() {
            return $http({method: "GET", url: _contextPath + 'smell/forcloud', transformResponse: [] });
        }
    }
}]);

app.factory("SmellService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'smell', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'smell/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);

app.factory("SmellGroupService", ['$resource', function($resource) {
    return $resource(_contextPath + 'smellgroup', {}, {
        get: {method:'GET', isArray: true}
    });
}]);

app.factory('PropertyService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'property/categorie/:cat', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory('MenuService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'menu', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory("UserService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'user', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'user/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        pw: $resource(_contextPath + 'changepw', {}, {
            update: { method: 'PUT' }
        }), 
        login: $resource(_contextPath + 'login', {}, {
            login: { method: 'PUT' }
        }),
        logout: $resource(_contextPath + 'logout', {}, {
            logout: { method: 'GET' }
        })
    };
}]);

app.factory('RolesService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'userroles', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory('StatusService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'status', {}, {
        get: { method: 'GET', isArray: true }
    });
}]);

app.factory("ExecTaskTypeService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'exectasktype', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'exectasktype/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        empty: $resource(_contextPath + 'exectasktype/empty', {}, {
            get: { method: 'GET' }
        })
    };
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
