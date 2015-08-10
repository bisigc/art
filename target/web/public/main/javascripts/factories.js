// ART services
app.factory("isAllowed", ['currentUser', function(currentUser) {
    return {
        check: function(roleArray) {
            return currentUser.profile != null && !(roleArray.indexOf(currentUser.profile.role.name) == -1);
        }
    }
}]);

app.factory("isLoggedin", ['currentUser', function(currentUser) {
    return {
        check: function() {
            return !(currentUser.profile == null);
        }
    }
}]);

app.factory('sharedSmell', ['notifications', function (notifications) {
    var smellObject = {smell: {}};
    smellObject.clear = function () {
        notifications.showInfo("clear smell");
        angular.copy({}, this.smell);
    }
    return smellObject;
}]);

app.factory("PasswordValidator", [function() {
    return {
        check: function(pw, rpw) {
            return {
                "valid": pw && /^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,20}$/.test(pw) && pw == rpw,
                "constraints": 
                [
                    {"name": "A-Z",          "valid": (pw && /[A-Z]/.test(pw)) ? true : false },
                    {"name": "a-z",          "valid": (pw && /[a-z]/.test(pw)) ? true : false },
                    {"name": "!@#$&*",       "valid": (pw && /[!@#$&*]/.test(pw)) ? true : false },
                    {"name": "0-9",          "valid": (pw && /[0-9]/.test(pw)) ? true : false },
                    {"name": "Length(8-20)", "valid": (pw && /.{8,20}/.test(pw)) ? true : false },
                    {"name": "equals",       "valid": (pw && pw == rpw) ? true : false }
                ]
            }
        }
    }
}]);

app.factory("PropModal", ['$modal', 'notifications', function($modal, notifications) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $modal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return modaltype;
                        }
                    }
                }
            );

            modalInstance.result.then(okfunction, dissmissedfunction);
            
            /*$stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };*/

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
        } else if(error['status'] == 400) {
            notifications.showError(error['data']);
        } else if(error['status'] == 404) {
            notifications.showError("Object not found, " + "[" + error['status'] + "], " + error['config']['url']);
        } else if(error['status'] == 409) {
            notifications.showInfo(error['data']);
        } else if(error['status'] == 500) {
            notifications.showError(error['data'] + ", Technical error [" + error['status'] + "], failed to " + error['config']['method'] + " " + error['config']['url']);
        } else {
            notifications.showError(error['data'] + ", Unknown error [" + error['status'] + "], failed to " + error['config']['method'] + " " + error['config']['url']);
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
        /*$resource(_contextPath + 'arsearchcount', {}, {
            get: { method: 'POST' , transformResponse: [] }
        })*/
    };
}]);

app.factory("ArVersionService", ['$resource', '$http', function($resource, $http) {
    return {
        noid: $resource(_contextPath + 'arversion', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'arversion/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        search: $resource(_contextPath + 'arsearch', {}, {
            get: { method: 'POST', isArray: true }
        }),
        count: function(smellids){
            return $http.post(_contextPath + 'arsearchcount', smellids, { transformResponse: [] });
        }
    };
}]);

app.factory("ModelElementService", ['$resource', function($resource) {
    return {
        type: $resource(_contextPath + 'modelelement/type', {}, {
            get: {method:'GET', isArray: true}
        }),
        qas: $resource(_contextPath + 'modelelement/qas', {}, {
            get: {method:'GET', isArray: true}
        }),
        components: $resource(_contextPath + 'modelelement/components', {}, {
            get: {method:'GET', isArray: true}
        }),
        context: $resource(_contextPath + 'modelelement/context', {}, {
            get: {method:'GET', isArray: true}
        }),
        decisions: $resource(_contextPath + 'modelelement/decisions', {}, {
            get: {method:'GET', isArray: true}
        }),
        design: $resource(_contextPath + 'modelelement/design', {}, {
            get: {method:'GET', isArray: true}
        }),
        references: $resource(_contextPath + 'modelelement/references', {}, {
            get: {method:'GET', isArray: true}
        }),
        noid: $resource(_contextPath + 'modelelement', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'modelelement/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);

app.factory("UserSearchService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'usersearch', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'usersearch/:id', {}, {
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

app.factory("FileUploader", ['$http', function($http) {
    return {
        upload: function(file, uploadUrl){
            var fd = new FormData();
            fd.append('file', file);
            return $http.post(uploadUrl, fd, {transformRequest: angular.identity, headers: {'Content-Type': undefined} });
        }
    }
}]);

app.factory("AvatarUploader", ['FileUploader', '$resource', function(FileUploader, $resource) {
    return {
        upload: function(file){
            return FileUploader.upload(file, _contextPath + 'avatar');
        }
    };
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

app.factory("DiscussionService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'discussion', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'discussion/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);

app.factory("CommentService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'comment', {}, {
            get: { method:'GET', isArray: true },
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'comment/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        like: $resource(_contextPath + 'like/:id', {}, {
            like: { method: 'PUT', params: {id: '@id'} }
        })
    };
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

app.factory('StatisticService', ['$resource', function ($resource) {
    return $resource(_contextPath + 'stats', {}, {
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

app.factory("TaskService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'task', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'task/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })
    };
}]);

app.factory("TaskPropertyService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'taskproperty', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'taskproperty/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        })    };
}]);