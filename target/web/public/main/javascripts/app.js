var app = angular.module('art', ['ui.router','ui.bootstrap','angular-jqcloud','ngResource','ngSanitize','ui.select','ngNotificationsBar','textAngular']);

var setSmell = function(smell){ 
    var input = $('#smellname');
    input.val(smell);
    input.trigger('input');
};

app.controller('UserController', ['UserService', 'ReplyErrorHandler', 'notifications','$scope', '$state','currentUser', function(UserService, ReplyErrorHandler, notifications, $scope, $state, currentUser){
    $scope.logindata = {"email":"cbisig@hsr.ch","password":"test"};
    $scope.user = currentUser.profile;
    $scope.login = function() {
        UserService.login.login($scope.logindata,function(data, status, headers, config) {
            currentUser.profile = data;
            notifications.showSuccess("Logged in");
            $scope.logindata = {"email":"","password":""};
            //$scope.loginform.$setPristine();
            if(currentUser.profile.startpage == "stay") {
                $state.go($state.current, {}, {reload: true});
                //$state.reload();
            } else {
                $state.go(currentUser.profile.startpage);
            }
        }, ReplyErrorHandler);
    };
    $scope.logout = function() {
        UserService.logout.logout($scope.logindata,function(data, status, headers, config) {
            notifications.showSuccess("Logged out");
            $scope.logindata = {"email":"","password":""};
            currentUser.profile = null;
            $state.go('home');
        }, ReplyErrorHandler);
    };
}]);

app.controller('UserProfileController', ['UserService', 'RolesService', 'AvatarUploader', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope','currentUser', '$state', function(UserService, RolesService, AvatarUploader, ReplyErrorHandler, PasswordValidator, notifications, $scope, currentUser, $state){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user;
    $scope.pw;
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data, status, headers, config) {
        $scope.roles = data;
    }, ReplyErrorHandler);
    
    UserService.id.get({id: currentUser.profile.id},function(data, status, headers, config) {
        $scope.user = data;
    }, ReplyErrorHandler);
    
    $scope.updateProfile = function() {
        UserService.noid.update({},$scope.user,function(data, status, headers, config) {
            notifications.showSuccess("Profile saved successful.");
        }, ReplyErrorHandler);
    }
    
    $scope.changePassword = function() {
        UserService.pw.update({},$scope.pw,function(data, status, headers, config) {
            notifications.showSuccess("Password has been changed.");
            $scope.pw = null;
            $scope.pwUpdateForm.$setPristine();
        }, ReplyErrorHandler);
    }
    
    $scope.getTime = function() {
        return new Date();
    }
    
    $scope.uploadAvatar = function() {
        AvatarUploader.upload($scope.avatarimage).success(function(data,status,headers,config){
            notifications.showSuccess("Avatar image has been uploaded.");
            $scope.avatarimage = null;
            $state.go($state.current, {}, {reload: true});
        }).error(function(data,status,headers,config){
            $scope.avatarimage = null;
            notifications.showError("Failed to upload avatar image: " + data);
        });
    }
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);

app.controller('UserCreateController', ['UserService', 'RolesService', 'ReplyErrorHandler', 'PasswordValidator', 'notifications', '$scope', '$state', function(UserService, RolesService, ReplyErrorHandler, PasswordValidator, notifications, $scope, $state){
    $scope.startpages = ['home','arbrowser','smellbrowser','taskbrowser', 'stay'];
    $scope.user;
    $scope.roles = [];
    $scope.pwcheck = [];
    RolesService.get({},function(data, status, headers, config) {
        $scope.roles = data;
    }, ReplyErrorHandler);
    
    $scope.updateProfile = function() {
        UserService.noid.create({},$scope.user,function(data, status, headers, config) {
            notifications.showSuccess("User has been created.");
            $state.go('home');
        }, ReplyErrorHandler);
    };
    
    $scope.revalidate = function(pw, rpw) {
       $scope.pwcheck = PasswordValidator.check(pw, rpw);
    };
}]);

app.controller('MenuController', ['MenuService', 'ReplyErrorHandler', 'notifications', '$scope', function(MenuService, ReplyErrorHandler, notifications, $scope){
    $scope.menuItems = [];
    $scope.licenseFile = 'APACHE-LICENSE-2.0.txt';
    MenuService.get({},function(data, status, headers, config) {
        $scope.menuItems = data;
    }, ReplyErrorHandler); 
}]);

app.controller('StatsController', ['StatisticService', 'ReplyErrorHandler', 'notifications', '$scope', function(StatisticService, ReplyErrorHandler, notifications, $scope){
    $scope.stats = [];
    StatisticService.get({},function(data, status, headers, config) {
        $scope.stats = data;
    }, ReplyErrorHandler); 
}]);

app.controller('ArViewController', ['ArService', 'ArVersionService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(ArService, ArVersionService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.ar = {};
    $scope.discussion_id;
    $scope.comments;

    $scope.currentar = [];
    $scope.discussion_id;
    $scope.comments;
    $scope.setCurrentAr = function(id) {
        $scope.currentar = $scope.ar.versions[id];
        $scope.discussion_id = $scope.currentar.discussion.id;
        $scope.comments = $scope.currentar.discussion.comments;
    }

    $scope.loadAr = function() {
        ArService.id.get({id: $stateParams.id},function(data, status, headers, config) {
            $scope.ar = data;
            $scope.setCurrentAr($scope.ar.versions.length - 1);
        }, ReplyErrorHandler);
    }
    $scope.loadAr();
    
    $scope.deleteArVersion = function(id) {
        ArVersionService.id.delete({id: id},function(data, status, headers, config) {
            notifications.showSuccess("ArVersion " + id + " has been deleted.");
            $scope.loadAr();
        }, ReplyErrorHandler);
    }

}]);

app.controller('DiscussionController', ['DiscussionService', 'CommentService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(DiscussionService, CommentService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.newcomment;
    $scope.init = function () {
        $scope.newcomment = {};
        $scope.newcomment.comment = '';
    };
    $scope.init();
    
    $scope.updateComment = function (discussion_id, comment) {
        CommentService.noid.update(comment, function(data, status, headers, config) {
            notifications.showSuccess("Comment has been updated.");
        }, ReplyErrorHandler); 
    };

    $scope.addComment = function (discussion_id) {
        $scope.newcomment.discussion = { 'id': discussion_id };
        CommentService.noid.create($scope.newcomment, function(data, status, headers, config) {
            $scope.$parent.comments.unshift(data);
            $scope.init();
            notifications.showSuccess("Comment has been added.");
        }, ReplyErrorHandler);
    };

    $scope.like = function(comment) {
        CommentService.like.like({id: comment.id},function(data, status, headers, config) {
            notifications.showSuccess("Comment has been liked.");
            comment.likes++;
        }, ReplyErrorHandler);
    };
    
    /*$scope.discussion = [];
    DiscussionService.id.get({id: $stateParams.discussion_id},function(data, status, headers, config) {
        $scope.discussion = data;
    }, ReplyErrorHandler);*/
}]);

app.controller('ARController', ['ArService', 'ArVersionService', 'CloudSmells', 'ReplyErrorHandler', 'notifications','$scope','$filter', function(ArService, ArVersionService, CloudSmells, ReplyErrorHandler, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.arlist = []; //ars;
    this.formvisible = true;
    $scope.words = [];
    //$scope.words = words;
    $scope.cloudcallstatus = '&nbsp;<i class="glyphicon glyphicon-refresh glyphicon-refresh-animate"/> Loading...';
    
    $scope.loadArs = function () {
        ArVersionService.noid.get({},function(data, status, headers, config) {
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();

    this.loadCloud = function () {
        CloudSmells.get().success(function(data,status,headers,config){
            $scope.words = eval(data);
            $scope.cloudcallstatus = "OK";
        }).error(function(data,status,headers,config){
            $scope.cloudcallstatus = "NOK";
            notifications.showError("Failed to load SmellCloud")
        });
    }
    this.loadCloud();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.order = function(predicate, reverse) {
        $scope.arlist = orderBy($scope.arlist, predicate, reverse);
    };
    
    $scope.order('name', false);

    $scope.setSmellFilter = function(smell) {
        //alert('Hell0');
        $scope.search.smells.name = smell;
        $scope.order();
    };

    this.ar = {};
    /*this.addAr = function() {
            this.ar.createdOn = Date.now();
            this.arlist.push(this.ar);
            this.ar = {};
        };*/
    
    $scope.deleteAr = function(id) {
        ArService.id.delete({id: id}, function(data, status, headers, config) {
            notifications.showSuccess("Delete of AR with id " + id + " and his versions succsessful.");
            $scope.loadArs();
        }, ReplyErrorHandler);  
    }

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
}]);

app.controller('AREditController', ['ArService', 'ArVersionService', 'SmellService', 'StatusService', 'ModelElementService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$scope', '$stateParams', '$filter', 'PropModal', function(ArService, ArVersionService, SmellService, StatusService, ModelElementService, StatusService, ReplyErrorHandler, notifications, $scope, $stateParams, $filter, PropModal) {
    $scope.ar = {'versions': []}; //ars;
    //$scope.ar.versions = [];
    $scope.arversion = {};
    $scope.arversion.properties = [];
    $scope.arversion.smells = [];
    $scope.arversion.tasks = [];
    $scope.smells = [];
    $scope.tasks = [];
    $scope.ar.versions.push($scope.arversion);
    $scope.modelelements = [];
    $scope.modelelementtypes = [];
    $scope.status = [];
    
    $scope.modelelementsvalues = [];
    
    $scope.modelelementsvalues.qas = [];
    $scope.modelelementsvalues.context = [];
    $scope.modelelementsvalues.components = [];
    $scope.modelelementsvalues.decisions = [];
    $scope.modelelementsvalues.design = [];
    $scope.modelelementsvalues.references = [];
    
    $scope.loadArVersion = function() {
        ArVersionService.id.get({id: $stateParams.id}, function(data, status, headers, config) {
            $scope.arversion = data;
            $scope.modelelementsvalues.qas = $filter('arPropFilter')($scope.arversion.properties, 'QASElementLink');
            $scope.modelelementsvalues.context = $filter('arPropFilter')($scope.arversion.properties, 'ContextElementLink');
            $scope.modelelementsvalues.components = $filter('arPropFilter')($scope.arversion.properties, 'DecisionElementLink');
            $scope.modelelementsvalues.decisions = $filter('arPropFilter')($scope.arversion.properties, 'DesignElementLink');
            $scope.modelelementsvalues.design = $filter('arPropFilter')($scope.arversion.properties, 'ComponentElementLink');
            $scope.modelelementsvalues.references = $filter('arPropFilter')($scope.arversion.properties, 'ReferenceElementLink');
            $scope.arversion.properties = [];
        }, ReplyErrorHandler);
    }
    $scope.loadArVersion();
    
    /*$scope.loadAr = function () {
        ArVersionService.id.get({id: $stateParams.id},function(data, status, headers, config) {
            $scope.ar = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadAr();*/
    $scope.openPropModal = function(type) {
        PropModal.open(type, function() {$scope.loadValues()}, function() {});
    }
    
    $scope.loadValues = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);        
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smells = data;
        }, ReplyErrorHandler);        
        ModelElementService.type.get({},function(data, status, headers, config) {
            $scope.modelelementtypes = data;
        }, ReplyErrorHandler);  
        ModelElementService.qas.get({},function(data, status, headers, config) {
            $scope.modelelements.qas = data;
        }, ReplyErrorHandler);  
        ModelElementService.context.get({},function(data, status, headers, config) {
            $scope.modelelements.context = data;
        }, ReplyErrorHandler);  
        ModelElementService.components.get({},function(data, status, headers, config) {
            $scope.modelelements.components = data;
        }, ReplyErrorHandler);  
        ModelElementService.decisions.get({},function(data, status, headers, config) {
            $scope.modelelements.decisions = data;
        }, ReplyErrorHandler);  
        ModelElementService.design.get({},function(data, status, headers, config) {
            $scope.modelelements.design = data;
        }, ReplyErrorHandler);  
        ModelElementService.references.get({},function(data, status, headers, config) {
            $scope.modelelements.references = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadValues();

    $scope.mergeProperties = function() {
        //angular.extend(ar.versions, arversion);
        $scope.arversion.properties = [].concat(
            $scope.modelelementsvalues.qas,
            $scope.modelelementsvalues.context,
            $scope.modelelementsvalues.components,
            $scope.modelelementsvalues.decisions,
            $scope.modelelementsvalues.design,
            $scope.modelelementsvalues.references
            );
    }
    
    $scope.saveAr = function() {
        $scope.mergeProperties();
        ArVersionService.noid.update($scope.arversion, function(data, status, headers, config) {
            notifications.showSuccess("ArVersion has been added successfully.");
        }, ReplyErrorHandler);
    }

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

app.controller('ARAddController', ['ArService', 'ArVersionService', 'SmellService', 'ModelElementService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$scope', '$stateParams', '$filter', '$state', 'PropModal', function(ArService, ArVersionService, SmellService, ModelElementService, StatusService, ReplyErrorHandler, notifications, $scope, $stateParams, $filter, $state, PropModal) {
    $scope.ar = {'versions': []}; //ars;
    //$scope.ar.versions = [];
    $scope.arversion = {};
    $scope.arversion.properties = [];
    $scope.arversion.smells = [];
    $scope.arversion.tasks = [];
    $scope.smells = [];
    $scope.tasks = [];
    $scope.ar.versions.push($scope.arversion);
    $scope.modelelements = [];
    $scope.modelelementtypes = [];
    $scope.status = [];

    $scope.modelelementsvalues = [];
    
    $scope.modelelementsvalues.qas = [];
    $scope.modelelementsvalues.context = [];
    $scope.modelelementsvalues.components = [];
    $scope.modelelementsvalues.decisions = [];
    $scope.modelelementsvalues.design = [];
    $scope.modelelementsvalues.references = [];
    
    if($stateParams.id && $stateParams.id != '') {
        ArVersionService.id.get({id: $stateParams.id}, function(data, status, headers, config) {
            $scope.arversion = data;
            $scope.ar.id = $scope.arversion.arhead;
            $scope.arversion.discussion = {};
            $scope.arversion.commentary = {};
            $scope.modelelementsvalues.qas = $filter('arPropFilter')($scope.arversion.properties, 'QASElementLink');
            $scope.modelelementsvalues.context = $filter('arPropFilter')($scope.arversion.properties, 'ContextElementLink');
            $scope.modelelementsvalues.components = $filter('arPropFilter')($scope.arversion.properties, 'DecisionElementLink');
            $scope.modelelementsvalues.decisions = $filter('arPropFilter')($scope.arversion.properties, 'DesignElementLink');
            $scope.modelelementsvalues.design = $filter('arPropFilter')($scope.arversion.properties, 'ComponentElementLink');
            $scope.modelelementsvalues.references = $filter('arPropFilter')($scope.arversion.properties, 'ReferenceElementLink');
            $scope.arversion.properties = [];
            $scope.arversion.id = null;
        }, ReplyErrorHandler);
    }
    
    /*$scope.loadAr = function () {
        ArVersionService.id.get({id: $stateParams.id},function(data, status, headers, config) {
            $scope.ar = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadAr();*/
    
    $scope.openPropModal = function(type) {
        PropModal.open(type, function() {$scope.loadValues()}, function() {});
    }
    
    $scope.loadValues = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);        
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smells = data;
        }, ReplyErrorHandler);        
        ModelElementService.type.get({},function(data, status, headers, config) {
            $scope.modelelementtypes = data;
        }, ReplyErrorHandler);  
        ModelElementService.qas.get({},function(data, status, headers, config) {
            $scope.modelelements.qas = data;
        }, ReplyErrorHandler);  
        ModelElementService.context.get({},function(data, status, headers, config) {
            $scope.modelelements.context = data;
        }, ReplyErrorHandler);  
        ModelElementService.components.get({},function(data, status, headers, config) {
            $scope.modelelements.components = data;
        }, ReplyErrorHandler);  
        ModelElementService.decisions.get({},function(data, status, headers, config) {
            $scope.modelelements.decisions = data;
        }, ReplyErrorHandler);  
        ModelElementService.design.get({},function(data, status, headers, config) {
            $scope.modelelements.design = data;
        }, ReplyErrorHandler);  
        ModelElementService.references.get({},function(data, status, headers, config) {
            $scope.modelelements.references = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadValues();

    $scope.mergeProperties = function() {
        //angular.extend(ar.versions, arversion);
        $scope.arversion.properties = [].concat(
            $scope.modelelementsvalues.qas,
            $scope.modelelementsvalues.context,
            $scope.modelelementsvalues.components,
            $scope.modelelementsvalues.decisions,
            $scope.modelelementsvalues.design,
            $scope.modelelementsvalues.references
            );
    }
    
    $scope.saveAr = function() {
        $scope.mergeProperties();
        if($stateParams.id && $stateParams.id != '') {
            ArVersionService.noid.create($scope.arversion, function(data, status, headers, config) {
                notifications.showSuccess("ArVersion has been added successfully.");
                $state.go('singlear', {id: data.arhead});
            }, ReplyErrorHandler);
        } else {
            ArService.noid.create($scope.ar, function(data, status, headers, config) {
                notifications.showSuccess("Ar has been added successfully.");
                $state.go('singlear', {id: data.id});
            }, ReplyErrorHandler);
        }
    }

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

app.controller('ModelElementController', ['ModelElementService', 'ReplyErrorHandler', 'notifications', '$scope', '$stateParams', function(ModelElementService, ReplyErrorHandler, notifications, $scope, $stateParams) {
    $scope.modelelementlist = [];
    $scope.modelelementtypes = [];
    $scope.selectedtype = '';
    
    $scope.loadModelElementTypes = function() {
        ModelElementService.type.get({}, function(data, status, headers, config) {
            $scope.modelelementtypes = data;
        }, ReplyErrorHandler);
    }
    $scope.loadModelElementTypes();
    
    $scope.loadModelElements = function(form) {
        ModelElementService.noid.get({}, function(data, status, headers, config) {
            $scope.modelelementlist = data;
        }, ReplyErrorHandler);  
    }
    $scope.loadModelElements();
    
    $scope.deleteElement = function(elementid) {
        ModelElementService.id.delete({id: elementid},function(data, status, headers, config) {
            notifications.showSuccess("Model Element Link has been deleted.");
            $scope.loadModelElements();
        }, ReplyErrorHandler);     
    }
}]);

app.controller('ModelElementAddController', ['ModelElementService', 'ReplyErrorHandler', 'notifications', '$modalInstance', '$scope', '$stateParams', 'modelelementtype', function(ModelElementService, ReplyErrorHandler, notifications, $modalInstance, $scope, $stateParams, modelelementtype) {
    $scope.modelelement = {};
    $scope.modelelement.type = modelelementtype;
    
    $scope.saveModelElement = function(form) {
        ModelElementService.noid.create($scope.modelelement, function(data, status, headers, config) {
            notifications.showSuccess("Model Element of type " + $scope.modelelement.type + " has been added.");
            $scope.modelelement = {};
            form.$setPristine();
            $modalInstance.close();
        }, ReplyErrorHandler);  
    }
    
    $scope.dismiss = function(form) {
        $modalInstance.dismiss('cancel');
    }

    
}]);

app.controller('ModelElementUpdateController', ['ModelElementService', 'ReplyErrorHandler', 'notifications', '$modalInstance', '$scope', '$stateParams', function(ModelElementService, ReplyErrorHandler, notifications, $modalInstance, $scope, $stateParams) {
    $scope.modelelement = {};
    $scope.loadModelElement = function() {
        ModelElementService.id.get({id: $stateParams.id}, function(data, status, headers, config) {
            $scope.modelelement = data;
        }, ReplyErrorHandler);  
    }
    $scope.loadModelElement();
    
    $scope.saveModelElement = function(form) {
        ModelElementService.noid.update($scope.modelelement, function(data, status, headers, config) {
            notifications.showSuccess("Model Element of type " + $scope.modelelement.type + " has been updated.");
            $scope.modelelement = {};
            form.$setPristine();
            $modalInstance.close();
        }, ReplyErrorHandler);  
    }
    
}]);

app.controller('ARSearchController', ['ArVersionService', 'UserSearchService', 'ReplyErrorHandler', 'notifications','$scope', '$stateParams', '$filter', function(ArVersionService, UserSearchService, ReplyErrorHandler, notifications, $scope, $stateParams, $filter) {
    var orderBy = $filter('orderBy');
    $scope.arlist = []; //ars;
    $scope.arsearch = {};
    $scope.loadArs = function () {
        ArVersionService.search.get(JSON.parse($stateParams.smellids),function(data, status, headers, config) {
            $scope.arlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadArs();

    $scope.order = function(predicate, reverse) {
        $scope.arlist = orderBy($scope.arlist, predicate, reverse);
    };
    
    $scope.order('name', false);
    
    $scope.saveSearch = function(form) {
        $scope.arsearch.search = $stateParams.smellids;
        UserSearchService.noid.create($scope.arsearch, function(data, status, headers, config) {
            notifications.showSuccess("Search has been added to your profile.");
            $scope.arsearch = {};
            form.$setPristine();
        }, ReplyErrorHandler);  
    }
}]);

app.controller('UserSearchController', ['UserSearchService', 'ReplyErrorHandler', 'notifications','$scope', function(UserSearchService, ReplyErrorHandler, notifications, $scope, $stateParams) {
    $scope.searchlist = []; //ars;
    
    $scope.loadSearches = function () {
        UserSearchService.noid.get({},function(data, status, headers, config) {
            $scope.searchlist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadSearches();
    
    $scope.deleteSearch = function(searchid) {
        UserSearchService.id.delete({id: searchid},function(data, status, headers, config) {
            notifications.showSuccess("User search has been deleted.");
            $scope.loadSearches();
        }, ReplyErrorHandler);     
    }
}]);

app.controller('SmellAssessController', ['ArVersionService', 'SmellGroupService', 'ReplyErrorHandler', 'notifications', '$scope', '$state', function(ArVersionService, SmellGroupService, ReplyErrorHandler, notifications, $scope, $state) {
    $scope.counter;
    $scope.groups = [];
    SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    $scope.selectedSmells;
    
    $scope.getSmellCount = function () {
        ArVersionService.count($scope.selectedSmells).success(function(data,status,headers,config){
            $scope.counter = data;
        }).error(function(data,status,headers,config){
            notifications.showError("Failed to get Ar count.");
        });
    };

    $scope.resetForm = function() {
        $scope.selectedSmells = {"smellids": [] };
        $scope.counter = 0;
    };
    
    $scope.resetForm();
    
    $scope.executeSearch = function() {
        $state.go('arsearch', {smellids: JSON.stringify($scope.selectedSmells)})
    }
    
    $scope.toggleSelection = function toggleSelection(smell_id) {
        var idx = $scope.selectedSmells.smellids.indexOf(smell_id);

        // is currently selected
        if (idx > -1) {
            $scope.selectedSmells.smellids.splice(idx, 1);
        }
        // is newly selected
        else {
            $scope.selectedSmells.smellids.push(smell_id);
        }
        $scope.getSmellCount();
    };
    
}]);

app.controller('SmellAddController', ['SmellService', 'SmellGroupService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$scope', function(SmellService, SmellGroupService, StatusService, ReplyErrorHandler, notifications, $scope) {
    $scope.smell;
    $scope.questionToAdd;
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();
    $scope.initSmell = function () {
        $scope.smell = {};
        $scope.smell.questions = [];
        $scope.questionToAdd = '';
    }
    $scope.initSmell();
    $scope.saveSmell = function(form) {
        SmellService.noid.create($scope.smell,function(data, status, headers, config) {
            if($scope.loadSmells) {
                $scope.loadSmells();
            }
            $modalInstance.close();
            notifications.showSuccess("Smell has been added.");
            $scope.initSmell();
            form.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.addQuestion = function () {
        $scope.smell.questions.push({
            question: $scope.questionToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeQuestion = function (idx) {
        $scope.smell.questions.splice(idx, 1);
    };

}]);

app.controller('SmellController', ['SmellService', 'SmellGroupService', 'ReplyErrorHandler', 'StatusService', 'notifications','$scope','$filter', function(SmellService, SmellGroupService, ReplyErrorHandler, StatusService, notifications, $scope, $filter) {
    var orderBy = $filter('orderBy');
    $scope.smelllist = [];
    this.formvisible = false;
    $scope.smell = {};
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.loadSmells = function () {
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smelllist = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadSmells();
    
    $scope.reload = function() {
        $scope.loadSmells();        
    }

    $scope.deleteSmell = function (id) {
        SmellService.id.delete({id: id},function(data, status, headers, config) {
            $scope.loadSmells();
            notifications.showSuccess("Smell has been deleted.");
        }, ReplyErrorHandler);
    };

    $scope.order = function(predicate, reverse) {
        $scope.smelllist = orderBy($scope.smelllist, predicate, reverse);
    };
    $scope.order('name', false);
}]);

app.controller('SmellViewController', ['SmellService', 'ReplyErrorHandler', 'notifications', '$stateParams', '$scope', function (SmellService, ReplyErrorHandler, notifications, $stateParams, $scope) {
    $scope.smell = [];
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data, status, headers, config) {
            $scope.smell = data;
        }, ReplyErrorHandler);
    };
    $scope.getSmell($stateParams.id);
}]);

app.controller('SmellUpdateController', ['SmellService','SmellGroupService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$modalInstance', '$scope', '$stateParams', 'smellid', function (SmellService, SmellGroupService, StatusService, ReplyErrorHandler, notifications, $modalInstance, $scope, $stateParams, smellid) {
    $scope.status = [];
    $scope.loadStatus = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadStatus();
    $scope.smell = [];
    $scope.groups = [];
    $scope.loadGroups = function () {
        SmellGroupService.get({},function(data, status, headers, config) {
            $scope.groups = data;
        }, ReplyErrorHandler);  
    };
    $scope.loadGroups();
    $scope.getSmell = function (smellid) {
        SmellService.id.get({id: smellid},function(data, status, headers, config) {
            $scope.smell = data;
        }, ReplyErrorHandler);  
    };
    $scope.getSmell($stateParams.id);

    $scope.saveSmell = function() {
        SmellService.noid.update($scope.smell,function(data, status, headers, config) {
            $modalInstance.close();
            notifications.showSuccess("Smell has been updated.");
            $scope.smell = {};
        }, ReplyErrorHandler);
    };
    
    $scope.addQuestion = function () {
        $scope.smell.questions.push({
            question: $scope.questionToAdd
        });
        $scope.questionToAdd = '';
    };
    
    $scope.removeQuestion = function (idx) {
        $scope.smell.questions.splice(idx, 1);
    };
}]);

app.controller('TaskController', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'notifications','$scope','$filter', '$sce', function(TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, notifications, $scope, $filter, $sce) {
    var orderBy = $filter('orderBy');
    $scope.tasklist = [];
    this.formvisible = true;
    $scope.exectasktypes = '';
    $scope.taskproperties = [];
    
    var execTypeHTML = '';
    
    var recursiveExecType = function(exectype, level) {
        exectype.forEach(function(entry){
            var element = "<option value='" + entry.id + "'>" + level + entry.name + "</option>";
            execTypeHTML += element;
            recursiveExecType(entry.subTasks, level + '&#8212;');
        });
    };
                         
    $scope.loadExecTaskTypes = function () {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            execTypeHTML = "<select class='form-control'>";
            var subtasks = data[0].subTasks;
            recursiveExecType(subtasks, '');
            execTypeHTML += "</select>";
            $scope.exectasktypes = $sce.trustAsHtml(execTypeHTML);
        }, ReplyErrorHandler);  
    };
    $scope.loadExecTaskTypes();
    
    $scope.loadTaskProperties = function () {
        TaskPropertyService.noid.get({},function(data, status, headers, config) {
            $scope.taskproperties = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTaskProperties();

    this.showForm = function(visible) {
        if(visible == true) {
            this.formvisible = true;
        } else {
            this.formvisible = false;
        }
    };

    $scope.loadTasks = function () {
        TaskService.noid.get({},function(data, status, headers, config) {
            $scope.tasklist = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTasks();

    $scope.deleteTask = function (id) {
        TaskService.id.delete({id: id},function(data, status, headers, config) {
            $scope.loadTasks();
            notifications.showSuccess("Task has been deleted.");
        }, ReplyErrorHandler);
    };

    $scope.order = function(predicate, reverse) {
        $scope.tasklist = orderBy($scope.tasklist, predicate, reverse);
    };
    $scope.order('name', false);

    $scope.initTask = function () {
        $scope.task = {};
        $scope.task.properties = [];
        $scope.propertyToAdd = {};
    }
    $scope.initTask();
    $scope.saveTask = function(form) {
        TaskService.noid.create($scope.task,function(data, status, headers, config) {
            $scope.loadTasks();
            notifications.showSuccess("Task has been added.");
            $scope.initTask();
            form.$setPristine();
        }, ReplyErrorHandler);  
    };
    
    $scope.addProperty = function () {
        $scope.task.properties.push($scope.propertyToAdd);
        $scope.propertyToAdd = {};
    };
    
    $scope.removeProperty = function (idx) {
        $scope.task.properties.splice(idx, 1);
    };

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
}]);

app.controller('TaskUpdateController', ['TaskService', 'ExecTaskTypeService', 'TaskPropertyService', 'ReplyErrorHandler', 'notifications', '$modalInstance', '$scope', '$stateParams', 'taskid', '$sce', function (TaskService, ExecTaskTypeService, TaskPropertyService, ReplyErrorHandler, notifications, $modalInstance, $scope, $stateParams, smellid, $sce) {
    $scope.status = [];
    $scope.exectasktypes = '';
    $scope.taskproperties = [];
    $scope.propertyToAdd = {};
    
    var execTypeHTML = '';
    
    var recursiveExecType = function(exectype, level) {
        exectype.forEach(function(entry){
            var element = "<option value='" + entry.id + "'>" + level + entry.name + "</option>";
            execTypeHTML += element;
            recursiveExecType(entry.subTasks, level + '&#8212;');
        });
    };
                         
    $scope.loadExecTaskTypes = function () {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            execTypeHTML = "<select class='form-control'>";
            var subtasks = data[0].subTasks;
            recursiveExecType(subtasks, '');
            execTypeHTML += "</select>";
            $scope.exectasktypes = $sce.trustAsHtml(execTypeHTML);
        }, ReplyErrorHandler);  
    };
    $scope.loadExecTaskTypes();
    
    $scope.loadTaskProperties = function () {
        TaskPropertyService.noid.get({},function(data, status, headers, config) {
            $scope.taskproperties = data;
            //$scope.smellcallstatus = "OK";
        }, ReplyErrorHandler);  
    };
    $scope.loadTaskProperties();

    $scope.getTask = function (taskid) {
        TaskService.id.get({id: taskid},function(data, status, headers, config) {
            $scope.singleTask = data;
        }, ReplyErrorHandler);  
    };
    $scope.getTask($stateParams.id);

    $scope.updateTask = function() {
        TaskService.noid.update($scope.singleTask,function(data, status, headers, config) {
            $modalInstance.close();
            notifications.showSuccess("Task has been updated.");
            $scope.singleTask = {};
        }, ReplyErrorHandler);  
    };
    
    $scope.addProperty = function () {
        $scope.singleTask.properties.push($scope.propertyToAdd);
        $scope.propertyToAdd = {};
    };
    
    $scope.removeProperty = function (idx) {
        $scope.singleTask.properties.splice(idx, 1);
    };
}]);

/*app.controller('DiscussionController', ['DiscussionService', 'ReplyErrorHandler', '$stateParams', 'notifications','$scope', function(DiscussionService, ReplyErrorHandler, $stateParams, notifications, $scope) {
    $scope.discussion = [];
    DiscussionService.id.get({id: $stateParams.id},function(data, status, headers, config) {
        $scope.discussion = data;
    }, ReplyErrorHandler);
    
}]);*/

app.controller("ExecTaskTypeController", ['ExecTaskTypeService', 'ReplyErrorHandler', 'notifications', '$scope', function(ExecTaskTypeService, ReplyErrorHandler, notifications, $scope) {
    $scope.exectypes = [];
    this.emptyexectype = [];
    $scope.loadExecTaskTypes = function() {
        ExecTaskTypeService.noid.get({},function(data, status, headers, config) {
            $scope.exectypes = data;
        }, ReplyErrorHandler);
    };
    $scope.loadExecTaskTypes();

    ExecTaskTypeService.empty.get({},function(data, status, headers, config) {
        $scope.emptyexectype = data;
    }, ReplyErrorHandler); 

    $scope.delete = function(task) {
        task.subTasks = [];
    };

    /*$scope.deleteCurrent = function(subTasks, task) {
        var index = subTasks.indexOf(task);
        subTasks.splice(index,1);
    };*/

    $scope.hasChildren = function(task) {
        return task.subTasks.length > 0;
    }


    $scope.add = function(task) {
        var post = task.subTasks.length + 1;
        var newName = task.name + '-' + post;
        task.subTasks.push(angular.copy(this.emptyexectype));
    };

    $scope.save = function() {
        ExecTaskTypeService.noid.update($scope.exectypes, function(data, status, headers, config) {
            $scope.emptyexectype = data;
            notifications.showSuccess("Exec Task Types have been saved.");
        }, ReplyErrorHandler);  
    }
}]);