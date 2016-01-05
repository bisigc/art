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

app.factory('sharedSmell', [function () {
    var smellObject = {smell: {}};
    smellObject.clear = function () {
        angular.copy({}, this.smell);
    }
    return smellObject;
}]);

app.factory('sharedTask', [function () {
    var taskObject = {task: {}};
    taskObject.clear = function () {
        angular.copy({}, this.task);
    }
    return taskObject;
}]);

app.factory("LastViewed", ['$filter', '$cookieStore', function($filter, $cookieStore) {
    var maxitems = 6;
    var lastviewedList = {list: []};
    var cookielist = $cookieStore.get('art_lastviewed_items', this.list);
    if(cookielist) {
        lastviewedList.list = cookielist;
    }
    // Item has to have the format {'name': name, 'type': type, 'id': id}
    lastviewedList.add = function (item) {
        //Remove entry if the item already exists to add afterwards at the top.
        var idx = -1;
        for(i = 0; i < this.list.length && idx == -1; i++) {
            if(this.list[i].type == item.type && this.list[i].id == item.id) {
                idx = i;
            }
        }
        if(idx != -1) {
            this.list.splice(idx, 1);
        }
        //Add at the beginning.
        this.list.unshift(item);
        if(this.list.length > maxitems) {
            //Remove last item.
            this.list.splice(this.list.length - 1);
        }
        $cookieStore.put('art_lastviewed_items', this.list);
    }
    return lastviewedList;
}]);

app.factory("PasswordValidator", [function() {
    return {
        check: function(pw) {
            return {
                "valid": pw && /^(?=.*[A-Za-z])(?=.*[0-9]).{8,20}$/.test(pw),
                "constraints": 
                [
                    {"name": "A-Za-z",       "valid": (pw && /[A-Za-z]/.test(pw)) ? true : false },
                    {"name": "0-9",          "valid": (pw && /[0-9]/.test(pw)) ? true : false },
                    {"name": "Length(8-20)", "valid": (pw && /.{8,20}/.test(pw)) ? true : false }
                    /*{"name": "equals",       "valid": (pw && pw == rpw) ? true : false }
                    {"name": "A-Z",          "valid": (pw && /[A-Z]/.test(pw)) ? true : false },
                    {"name": "a-z",          "valid": (pw && /[a-z]/.test(pw)) ? true : false },
                    {"name": "!@#$&*",       "valid": (pw && /[!@#$&*]/.test(pw)) ? true : false },*/
                ]
            }
        }
    }
}]);

app.factory("PropModal", ['$uibModal', 'notifications', function($uibModal, notifications) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
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

            modalInstance.result.then(function(result) {okfunction(result)}, dissmissedfunction);
            
            /*$stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };*/

        }
        
    }
}]);

app.factory("SmellModal", ['$uibModal', 'notifications', function($uibModal, notifications) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellModalAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return modaltype;
                        }
                    }
                }
            );
            modalInstance.result.then(function(result) {okfunction(result)}, dissmissedfunction);
        }
    }
}]);

app.factory("TaskModal", ['$uibModal', 'notifications', function($uibModal, notifications) {

    return {
        open: function(type, okfunction, dissmissedfunction) {
            var modaltype = type;
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'taskdialog.html',
                    controller: 'TaskModalAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return modaltype;
                        }
                    }
                }
            );
            modalInstance.result.then(function(result) {okfunction(result)}, dissmissedfunction);
        }
    }
}]);

app.service('ConfirmModal', ['$uibModal',function ($uibModal) {

    var modalDefaults = {
        backdrop: true,
        keyboard: true,
        modalFade: true,
        templateUrl:  _contextPath + "confirmdialog.html",
    };

    var modalOptions = {
        closeButtonText: 'Cancel',
        actionButtonText: 'Yes',
        headerText: 'Proceed?',
        bodyText: 'Perform this action?'
    };

    this.showModal = function (customModalDefaults, customModalOptions) {
        if (!customModalDefaults) customModalDefaults = {};
        customModalDefaults.backdrop = 'static';
        return this.show(customModalDefaults, customModalOptions);
    };

    this.show = function (customModalDefaults, customModalOptions) {
        //Create temp objects to work with since we're in a singleton service
        var tempModalDefaults = {};
        var tempModalOptions = {};

        //Map angular-ui modal custom defaults to modal defaults defined in service
        angular.extend(tempModalDefaults, modalDefaults, customModalDefaults);

        //Map modal.html $scope custom properties to defaults defined in service
        angular.extend(tempModalOptions, modalOptions, customModalOptions);

        if (!tempModalDefaults.controller) {
            tempModalDefaults.controller = function ($scope, $modalInstance) {
                $scope.modalOptions = tempModalOptions;
                $scope.modalOptions.ok = function (result) {
                    $modalInstance.close(result);
                };
                $scope.modalOptions.close = function (result) {
                    $modalInstance.dismiss('cancel');
                };
            }
        }

        return $uibModal.open(tempModalDefaults).result;
    };

}]);

app.factory("ReplyErrorHandler", ['currentUser', 'notifications', '$log', '$state', function(currentUser, notifications, $log, $state) {
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
            $state.go('root.404');
            notifications.showError("Object not found, " + "[" + error['status'] + "], " + error['config']['url']);
        } else if(error['status'] == 409) {
            notifications.showInfo(error['data']);
        } else if(error['status'] == 422) {
            notifications.showError(error['data']);
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

app.factory("SmellGroupService", ['$resource', function($resource) {
    return {
        noid: $resource(_contextPath + 'smellgroup', {}, {
            get: {method:'GET', isArray: true},
            update: { method: 'PUT' },
            create: { method: 'POST' }
        }),
        id: $resource(_contextPath + 'smellgroup/:id', {}, {
            get: { method: 'GET' },
            delete: { method: 'DELETE', params: {id: '@id'} }
        }),
        assess: $resource(_contextPath + 'smellassessgroup', {}, {
            get: {method:'GET', isArray: true}
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