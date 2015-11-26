app.run(['$rootScope','$state','$stateParams','notifications','currentUser', 'isAllowed', 'isLoggedin', function ($rootScope, $state, $stateParams, notifications, currentUser, isAllowed, isLoggedin) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.currentUser = currentUser;
    $rootScope.isAllowed = isAllowed;
    $rootScope.isLoggedin = isLoggedin;
    $rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
        var requireLogin = toState.data.requireLogin;
        var allowedRoles = toState.data.allowedRoles;

        if (requireLogin && currentUser.profile == null) {
            event.preventDefault();
            notifications.showWarning("Login required.");
        } else if(requireLogin && currentUser.profile != null && allowedRoles.indexOf(currentUser.profile.role.name) == -1) {
            event.preventDefault();
            notifications.showWarning("Not enough permissions.");
        }
    });
    
    $rootScope.$on('$stateChangeSuccess', function (evt, toState, toParams, fromState, fromParams) {
        window.document.title = "Architectural Refactoring Tool > " + toState.title;
    });
    
    $rootScope.$on('$stateChangeError', function(event) {
        $state.go('root.404');
    });
}]);

/**
 * notification bar custom configuration.
 **/
app.config(['notificationsConfigProvider', function (notificationsConfigProvider) {
    notificationsConfigProvider.setAutoHide(true);
    notificationsConfigProvider.setHideDelay(7000);
    notificationsConfigProvider.setAcceptHTML(true);
}]);

/**
 * Mechanism for Browser wide user profile (session) handling.
 * Here it is checked if the javascript variable activeProfile provided by
 * backend via the index page contains the userprofile info of a logged in user.
 * The userinfo would be provided as a Base64 encoded JSON String.
 **/
app.config(['$provide', function($provide) {
    var profile;
    if(window.activeProfile == '') {
        profile = null;
    } else {
        var decoded = atob(window.activeProfile);
        if(decoded == "Session timeout") {
            profile = null;
        } else {
            profile = angular.fromJson(decoded);
        }
    }
    $provide.value('currentUser', {"profile": profile});
}]);

/**
 * textAngular custom configuration
 **/
app.config(['$provide', function($provide){
    $provide.decorator('taOptions', ['taSelection', 'taRegisterTool', '$delegate', '$window', function(taSelection, taRegisterTool, taOptions, $window){
        // Own button for the textAngular toolbar which inserts a horizontal line in the textbox.
        taRegisterTool('hr', {
            buttontext: '&lt;hr&gt;',
            tooltiptext: 'Insert horizontal line',
            action: function() {
                return this.$editor().wrapSelection('inserthtml', '<hr>', true);
            },
            activeState: function(commonElement){
                if(commonElement) return commonElement[0].tagName === 'hr';
                return false;
            }
        });
        taRegisterTool('insertAbbreviation', {
            buttontext: '&lt;abbr&gt;',
            tooltiptext: 'Insert an abbreviation',
            action: function() {
                var _selection = taSelection.getSelection();
                if(_selection.collapsed){
                    $window.alert('Select abbreviation first.');
                }else if(rangy.getSelection().getRangeAt(0).canSurroundContents()){
                    var title;
                    title = $window.prompt('Full wording:', '');
                    var tagBegin = '<abbr title="' + title + '">';
                    var tagEnd = '</abbr>&nbsp;';
                    var node = angular.element(tagBegin + tagEnd)[0];
                    rangy.getSelection().getRangeAt(0).surroundContents(node);
                }
                
                /*if(rangy.getSelection().getRangeAt(0).length > 0){
                    var title;
                    title = $window.prompt('Full wording:', '');
                    var tagBegin = '<abbr title="' + title + '">';
                    var tagEnd = '</abbr>';
                    var node = angular.element(tagBegin + tagEnd)[0];
                    rangy.getSelection().getRangeAt(0).surroundContents(node);
                } else {
                    $window.alert('Select text first.');
                }*/
                
                /*var savedSelection = rangy.saveSelection();
                var abbr;
                var title;
                abbr = $window.prompt('Abbreviation:', '');
                title = $window.prompt('Full wording:', '');
                if(abbr && title && abbr !== '' && title !== ''){
                    var abbrhtml = '<abbr title="' + title + '">' + abbr + '</abbr>';
                    rangy.restoreSelection(savedSelection);
                    return this.$editor().wrapSelection('inserthtml', abbrhtml, true);
                }*/
            }
            /*action: function(){
                var abbr;
                var title;
                abbr = $window.prompt('Abbreviation:', '');
                title = $window.prompt('Full wording:', '');
                if(abbr && title && abbr !== '' && title !== ''){
                    var abbrhtml = '<abbr title="' + title + '">' + abbr + '</abbr>';
                    return this.$editor().wrapSelection('inserthtml', abbrhtml, true);
                }
            }*/
        });
        // Allowing to use the original angularjs sanitizer instead of the one from TextAngular (if set to false).
        taOptions.forceTextAngularSanitize = true;
        // Set the target for all inserted links to _blank
        taOptions.defaultTagAttributes.a.target = "_blank";
        // add the button to the default toolbar definition
        taOptions.toolbar = [
            ['h1', 'h2', 'h3', 'h4', 'p', 'pre', 'hr', 'insertAbbreviation'],
            ['bold', 'italics', 'underline', 'ul', 'ol', 'redo', 'undo', 'clear'],
            ['justifyLeft', 'justifyCenter', 'justifyRight', 'indent', 'outdent'],
            ['html', 'insertLink', 'insertImage', 'insertVideo'], ['charcount']
        ];
        return taOptions;
    }]);
}]);

/**
 * ui-router page state configuration
 **/
app.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to ""
    $urlRouterProvider.when('', '/');
    $urlRouterProvider.otherwise("/");
    
    // Now set up the states
    $stateProvider
        .state('root', {
        url: '',
        abtract: true,
        views: {
            'menu': {
                templateUrl: _contextPath + "menubar.html",
                controller: "MenuController as menuCtrl"
            },
            'login@root':{
                templateUrl: _contextPath + "login.html",
                controller: "LoginController as loginCtrl"
            },
            'footer': {
                templateUrl: _contextPath + "footer.html",
                controller: "FooterController as footCtrl"
            }
        }
    })  
        .state('root.404', {
        url: "/404",
        title: "Page not found",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "404.html",
            }
        }
    })
        .state('root.home', {
        url: "/",
        title: "Home",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "home.html",
            },
            'statsView@root.home': {
                templateUrl: _contextPath + "stats.html",
                controller: "StatsController as statsCtrl"
            },
            'loginView@root.home': {
                templateUrl: _contextPath + "login.html",
                controller: "LoginController as loginCtrl"
            }
        }
    })
        .state('root.register', {
        url: "/register",
        title: "Register",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "register.html",
                controller: "UserCreateController as createUserCtrl"
            }
        }
    })
        .state('root.smellbrowser', {
        url: "/smellbrowser",
        title: "Smell Browser",
        data: { requireLogin: false },
        views: {
            'container@': {
                controller: "SmellController as smellCtrl",
                title: "Smell Browser",
                templateUrl: _contextPath + "smellbrowser.html",
            },
            'addSmellView@root.smellbrowser': {
                controller: "SmellAddController as smellAddCtrl",
                parent: 'root.smellbrowser',
                title: "Create Smell",
                templateUrl: _contextPath + "smelldialog.html",
                data: { 
                    requireLogin: true,
                    allowedRoles: ["Admin", "Editor"]
                }
            }
        }
    })
        .state('root.smellbrowser.edit', {
        url: "/edit/:id",
        //templateUrl: _contextPath + "smellbrowser.html",
        title: "Smell Edit",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellUpdateController',
                    size: 'lg',
                    resolve: {
                        smellid: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
                //reload();
            }, function () {
                $state.go('^');
            });
        }]
    })
        .state('root.arbrowser', {
        url: "/arbrowser",
        title: "AR Browser",
        data: { requireLogin: false },
        views: {
            'container@': {
                controller: "ARController as arCtrl",
                title: "AR Browser",
                templateUrl: _contextPath + "arbrowser.html",
            }
        }
    })
        .state('root.addar', {
        url: "/addar",
        title: "Add AR",
        params: {id: null},
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        views: {
            'container@': {
                controller: "ARAddController as arAddCtrl",
                title: "Add AR",
                templateUrl: _contextPath + "arform.html",
            }
        }
    })
/*        .state('root.addar.addsmell', {
        url: "/addsmell",
        title: "Add Smell",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellAddController',
                    size: 'lg',
                }
            );

            modalInstance.result.then(function () {
                $state.go('^');
                reload();
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    }) */
        .state('root.aredit', {
        url: "/aredit/:id",
        title: "Edit AR",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        views: {
            'container@': {
                controller: "AREditController as arEditCtrl",
                title: "Edit AR",
                templateUrl: _contextPath + "arform.html",
            }
        }
    })
        .state('root.modelelement', {
        url: "/modelelement",
        title: "Model Elements",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "modelelement.html",
                title: "Model Elements",
                controller: "ModelElementController"
            }
        }
    })
        .state('root.modelelement.edit', {
        url: "/edit/:id",
        title: "Edit Model Element",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementUpdateController',
                    size: 'lg',
                    resolve: {
                        id: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.modelelement.add', {
        url: "/add/:modelelementtype",
        title: "Add Model Element",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelElementAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return $stateParams.modelelementtype;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.smellgroup', {
        url: "/smellgroup",
        title: "Smell Groups",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "smellgroup.html",
                title: "Smell Groups",
                controller: "SmellGroupController"
            }
        }
    })
        .state('root.smellgroup.edit', {
        url: "/edit/:id",
        title: "Edit Smell Group",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smellgroupdialog.html',
                    controller: 'SmellGroupUpdateController',
                    size: 'lg',
                    resolve: {
                        id: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.smellgroup.add', {
        url: "/add/:smellgroup",
        title: "Add Smell Group",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smellgroupdialog.html',
                    controller: 'SmellGroupAddController',
                    size: 'lg',
                    resolve: {
                        modelelementtype: function () { 
                            return $stateParams.modelelementtype;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.arsearch', {
        url: "/arsearch/:smellids",
        title: "AR Search",
        data: { 
            requireLogin: false
        },
        views: {
            'container@': {
                controller: "ARSearchController as arSearchCtrl",
                templateUrl: _contextPath + "arsearch.html"
            }
        }
    })  
        .state('root.usersearches', {
        url: "/usersearches",
        templateUrl: _contextPath + "usersearches.html",
        controller: "UserSearchController as userSearchCtrl",
        title: "User Searches",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Applier", "Editor"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "usersearches.html",
                controller: "UserSearchController as userSearchCtrl",
            }
        }
    })
        .state('root.singlesmell', {
        url: "/smell/:id",
        title: "Smell View",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "singlesmell.html",
                controller: "SmellViewController as smellCtrl"
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + "discussion.html"
            }*/
        }
    })
        .state('root.singlear', {
        url: "/ar/:id",
        title: "AR View",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "singlear.html",
                controller: 'ArViewController as arViewCtrl'
            },
            'discussionView@root.singlear': {
                templateUrl: _contextPath + "discussion.html",
                controller: 'DiscussionController as disCtrl'
            }
        }
    })
        .state('root.singletask', {
        url: "/task/:id",
        title: "Task View",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "singletask.html"
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + "discussion.html"
            }*/
        }
    })
        .state('root.taskbrowser', {
        url: "/taskbrowser",
        title: "Task Browser",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "taskbrowser.html",
                controller: "TaskController as taskCtrl"
            },
            'addTaskView@root.taskbrowser': {
                templateUrl: _contextPath + "taskdialog.html",
                controller: "TaskAddController as taskCtrl"
            }
        }
    })
        .state('root.taskbrowser.edit', {
        url: "/edit/:id",
        title: "Task Edit",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'taskdialog.html',
                    controller: 'TaskUpdateController',
                    size: 'lg',
                    resolve: {
                        taskid: function () { 
                            return $stateParams.id;
                        }
                    }
                }
            );

            modalInstance.result.then(function () {
                $state.go('^', {}, {reload: true});
            }, function () {
                $state.go('^');
            });
            $stateParams.ok = function () {
                $modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.admin', {
        url: "/admin",
        title: "Admin",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "admin.html",
            }
        }
    })
        .state('root.users', {
        url: "/users",
        title: "Users",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "users.html",
            }
        }
    })
         .state('root.userview', {
        url: "/userview/:id",
        title: "User View",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "userview.html",
                controller: "UserViewController as userCtrl"
            }
        }
    })
       .state('root.exectypes', {
        url: "/exectypes",
        title: "Execution Task Types",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Editor"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "exectypes.html",
                controller: "ExecTaskTypeController as etypeCtrl"
            }
        }
    })
        .state('root.about', {
        url: "/about",
        title: "About",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "about.html",
                controller: "AboutController as aboutCtrl"
            },
            'license@root.about': {
                templateUrl: _contextPath + "APACHE-LICENSE-2.0.txt"
            }
        }
    })
        .state('root.profile', {
        url: "/profile",
        title: "Profile",
        data: { 
            requireLogin: true,
            allowedRoles: ["Admin", "Applier", "Editor"]
        },
        views: {
            'container@': {
                templateUrl: _contextPath + "profile.html",
                controller: "UserProfileController as userCtrl"
            }
        }
    })
        .state('root.smellassess', {
        url: "/smellassess",
        title: "Smell Self-Assessment",
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + "smellassess.html",
                controller: "SmellAssessController as smellACtrl"
            }
        }
    });
}]);