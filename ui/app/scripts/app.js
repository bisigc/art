'use strict';

/**
 * @ngdoc overview
 * @name uiApp
 * @description
 * # uiApp
 *
 * Main module of the application.
 */
angular
  .module('uiApp', [
    'ui.router',
    'ui.bootstrap',
    'angular-jqcloud',
    'ngResource',
    'ngCookies',
    'ngSanitize',
    'ui.select',
    'ngNotificationsBar',
    'textAngular',
    'ui.sortable'
]);

angular.module('uiApp').run(['$rootScope','$state','$stateParams','notifications','currentUser', 'isAllowed', 'isLoggedin', function ($rootScope, $state, $stateParams, notifications, currentUser, isAllowed, isLoggedin) {
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.currentUser = currentUser;
    $rootScope.isAllowed = isAllowed;
    $rootScope.isLoggedin = isLoggedin;
    $rootScope.$on('$stateChangeStart', function (event, toState) { // toParams
        var requireLogin = toState.data.requireLogin;
        var allowedRoles = toState.data.allowedRoles;

        if (requireLogin && currentUser.profile === null) {
            event.preventDefault();
            notifications.showWarning('Login required.');
        } else if(requireLogin && currentUser.profile !== null && allowedRoles.indexOf(currentUser.profile.role.name) === -1) {
            event.preventDefault();
            notifications.showWarning('Not enough permissions.');
        }
    });
    
    $rootScope.$on('$stateChangeSuccess', function (evt, toState) { //  toParams, fromState, fromParams
        window.document.title = 'Architectural Refactoring Tool > ' + toState.title;
    });
    
    $rootScope.$on('$stateChangeError', function() { //event
        $state.go('root.404');
    });
}]);

/**
 * notification bar custom configuration.
 **/
angular.module('uiApp').config(['notificationsConfigProvider', function (notificationsConfigProvider) {
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
angular.module('uiApp').config(['$provide', function($provide) {
    var profile;
    if(window.activeProfile === '') {
        profile = null;
    } else {
        var decoded = atob(window.activeProfile);
        if(decoded === 'Session timeout') {
            profile = null;
        } else {
            profile = angular.fromJson(decoded);
        }
    }
    $provide.value('currentUser', {'profile': profile});
}]);

/**
 * textAngular custom configuration
 **/
angular.module('uiApp').config(['$provide', function($provide){
    $provide.decorator('taOptions', ['taSelection', 'taRegisterTool', '$delegate', '$window', function(taSelection, taRegisterTool, taOptions, $window){
        // Own button for the textAngular toolbar which inserts a horizontal line in the textbox.
        taRegisterTool('hr', {
            buttontext: '&lt;hr&gt;',
            tooltiptext: 'Insert horizontal line',
            action: function() {
                return this.$editor().wrapSelection('inserthtml', '<hr>', true);
            },
            activeState: function(commonElement){
                if(commonElement) {
                    return commonElement[0].tagName === 'hr';
                }
                return false;
            }
        });
        taRegisterTool('insertAbbreviation', {
            buttontext: '&lt;abbr&gt;',
            tooltiptext: 'Insert an abbreviation',
            action: function() {
                var myselection = taSelection.getSelection();
                if(myselection.collapsed){
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
        taOptions.defaultTagAttributes.a.target = '_blank';
        // add the button to the default toolbar definition
        taOptions.toolbar = [
            ['h1', 'h2', 'h3', 'h4', 'p', 'pre', 'hr', 'insertAbbreviation'],
            ['bold', 'italics', 'underline', 'ul', 'ol', 'redo', 'undo', 'clear'],
            ['justifyLeft', 'justifyCenter', 'justifyRight', 'indent', 'outdent'],
            ['html', 'insertLink', 'insertImage', 'insertVideo'], ['wordcount', 'charcount']
        ];
        return taOptions;
    }]);
}]);

/**
 * ui-router page state configuration
 **/
angular.module('uiApp').config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to ""
    $urlRouterProvider.when('', '/');
    $urlRouterProvider.otherwise('/');
    
    // Now set up the states
    $stateProvider
        .state('root', {
        url: '',
        abtract: true,
        views: {
            'menu': {
                templateUrl: _contextPath + 'menubar.html',
                controller: 'MenuCtrl'
            },
            'login@root':{
                templateUrl: _contextPath + 'login.html',
                controller: 'LoginCtrl'
            },
            'footer': {
                templateUrl: _contextPath + 'footer.html',
                controller: 'FooterCtrl'
            }
        }
    })  
        .state('root.404', {
        url: '/404',
        title: 'Page not found',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + '404.html',
            }
        }
    })
        .state('root.home', {
        url: '/',
        title: 'Home',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'home.html',
            },
            'statsView@root.home': {
                templateUrl: _contextPath + 'stats.html',
                controller: 'StatsCtrl'
            },
            'loginView@root.home': {
                templateUrl: _contextPath + 'login.html',
                controller: 'LoginCtrl'
            }
        }
    })
        .state('root.register', {
        url: '/register',
        title: 'Register',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'register.html',
                controller: 'UsercreateCtrl'
            }
        }
    })
        .state('root.smellbrowser', {
        url: '/smellbrowser',
        title: 'Smell Browser',
        data: { requireLogin: false },
        views: {
            'container@': {
                controller: 'SmellCtrl',
                title: 'Smell Browser',
                templateUrl: _contextPath + 'smellbrowser.html',
            },
            'addSmellView@root.smellbrowser': {
                controller: 'SmelladdCtrl',
                parent: 'root.smellbrowser',
                title: 'Create Smell',
                templateUrl: _contextPath + 'smelldialog.html',
                data: { 
                    requireLogin: true,
                    allowedRoles: ['Admin', 'Editor']
                }
            }
        }
    })
        .state('root.smellbrowser.edit', {
        url: '/edit/:id',
        //templateUrl: _contextPath + 'smellbrowser.html',
        title: 'Smell Edit',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smelldialog.html',
                    controller: 'SmellupdateCtrl',
                    backdrop: 'static',
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
        url: '/arbrowser',
        title: 'AR Browser',
        data: { requireLogin: false },
        views: {
            'container@': {
                controller: 'ArCtrl',
                title: 'AR Browser',
                templateUrl: _contextPath + 'arbrowser.html',
            }
        }
    })
        .state('root.addar', {
        url: '/addar',
        title: 'Add AR',
        params: {id: null},
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        views: {
            'container@': {
                controller: 'AraddCtrl',
                title: 'Add AR',
                templateUrl: _contextPath + 'arform.html',
            }
        }
    })
/*        .state('root.addar.addsmell', {
        url: '/addsmell',
        title: 'Add Smell',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    }) */
        .state('root.aredit', {
        url: '/aredit/:id',
        title: 'Edit AR',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        views: {
            'container@': {
                controller: 'AreditCtrl',
                title: 'Edit AR',
                templateUrl: _contextPath + 'arform.html',
            }
        }
    })
        .state('root.modelelement', {
        url: '/modelelement',
        title: 'Model Elements',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'modelelement.html',
                title: 'Model Elements',
                controller: 'ModelelementCtrl'
            }
        }
    })
        .state('root.modelelement.edit', {
        url: '/edit/:id',
        title: 'Edit Model Element',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', '$scope', function($stateParams, $state, $uibModal, $scope) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    controller: 'ModelelementupdateCtrl',
                    backdrop: 'static',
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.modelelement.add', {
        url: '/add/:modelelementtype',
        title: 'Add Model Element',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', '$scope', function($stateParams, $state, $uibModal, $scope) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'modelelementdialog.html',
                    backdrop: 'static',
                    controller: 'ModelelementaddCtrl',
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.smellgroup', {
        url: '/smellgroup',
        title: 'Smell Groups',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'smellgroup.html',
                title: 'Smell Groups',
                controller: 'SmellgroupCtrl'
            }
        }
    })
        .state('root.smellgroup.edit', {
        url: '/edit/:id',
        title: 'Edit Smell Group',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', '$scope', function($stateParams, $state, $uibModal, $scope) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smellgroupdialog.html',
                    controller: 'SmellgroupupdateCtrl',
                    backdrop: 'static',
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.smellgroup.add', {
        url: '/add/:smellgroup',
        title: 'Add Smell Group',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', '$scope', function($stateParams, $state, $uibModal, $scope) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'smellgroupdialog.html',
                    controller: 'SmellgroupaddCtrl',
                    backdrop: 'static',
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.arsearch', {
        url: '/arsearch/:smellids',
        title: 'AR Search',
        data: { 
            requireLogin: false
        },
        views: {
            'container@': {
                controller: 'ArsearchCtrl',
                templateUrl: _contextPath + 'arsearch.html'
            }
        }
    })  
        .state('root.usersearches', {
        url: '/usersearches',
        templateUrl: _contextPath + 'usersearches.html',
        controller: 'UsersearchCtrl',
        title: 'User Searches',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Applier', 'Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'usersearches.html',
                controller: 'UsersearchCtrl',
            }
        }
    })
        .state('root.singlesmell', {
        url: '/smell/:id',
        title: 'Smell View',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'singlesmell.html',
                controller: 'SmellviewCtrl'
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + 'discussion.html'
            }*/
        }
    })
        .state('root.singlear', {
        url: '/ar/:id',
        title: 'AR View',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'singlear.html',
                controller: 'ArviewCtrl'
            },
            'discussionView@root.singlear': {
                templateUrl: _contextPath + 'discussion.html',
                controller: 'DiscussionCtrl'
            }
        }
    })
        .state('root.singletask', {
        url: '/task/:id',
        title: 'Task View',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'singletask.html',
                controller: 'TaskviewCtrl'
            }/*,
            'discussionView@singlesmell': {
                templateUrl: _contextPath + 'discussion.html'
            }*/
        }
    })
        .state('root.singleproperty', {
        url: '/property/:id',
        title: 'Property View',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'singleproperty.html',
                controller: 'PropertyviewCtrl'
            }
        }
    })
        .state('root.taskbrowser', {
        url: '/taskbrowser',
        title: 'Task Browser',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'taskbrowser.html',
                controller: 'TaskCtrl'
            },
            'addTaskView@root.taskbrowser': {
                templateUrl: _contextPath + 'taskdialog.html',
                controller: 'TaskaddCtrl'
            }
        }
    })
        .state('root.taskbrowser.edit', {
        url: '/edit/:id',
        title: 'Task Edit',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', '$scope', function($stateParams, $state, $uibModal, $scope) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'taskdialog.html',
                    controller: 'TaskupdateCtrl',
                    backdrop: 'static',
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
                modalInstance.close($scope.selected.item);
            };

            $stateParams.cancel = function () {
                modalInstance.dismiss('cancel');
            };
        }]
    })
        .state('root.admin', {
        url: '/admin',
        title: 'Admin',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'admin.html',
            }
        }
    })
        .state('root.users', {
        url: '/users',
        title: 'Users',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'users.html',
                controller: 'UsersCtrl'
            },
            'addUserView@root.users': {
                controller: 'Usercreatetrl',
                parent: 'root.users',
                title: 'Create User',
                templateUrl: _contextPath + 'register.html',
                data: { 
                    requireLogin: true,
                    allowedRoles: ['Admin']
                }
            }
        }
    })
         .state('root.userview', {
        url: '/userview/:id',
        title: 'User View',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'userview.html',
                controller: 'UserviewCtrl'
            }
        }
    })
        .state('root.properties', {
        url: '/properties',
        title: 'Properties',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin','Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'properties.html',
                controller: 'PropertiesCtrl'
            },
            'addPropertyView@root.properties': {
                controller: 'PropertyaddCtrl',
                parent: 'root.properties',
                title: 'Create Property',
                templateUrl: _contextPath + 'propertydialog.html',
                data: { 
                    requireLogin: true,
                    allowedRoles: ['Admin', 'Editor']
                }
            }
        }
    })
        .state('root.properties.edit', {
        url: '/edit/:id',
        title: 'Property Edit',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
            var modalInstance = $uibModal.open(
                {
                    templateUrl: _contextPath + 'propertydialog.html',
                    controller: 'PropertyupdateCtrl',
                    backdrop: 'static',
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
       .state('root.exectypes', {
        url: '/exectypes',
        title: 'Execution Task Types',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'exectypes.html',
                controller: 'ExectasktypeCtrl'
            }
        }
    })
        .state('root.about', {
        url: '/about',
        title: 'About',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'about.html',
                controller: 'AboutCtrl'
            },
            'license@root.about': {
                templateUrl: _contextPath + 'APACHE-LICENSE-2.0.txt'
            }
        }
    })
        .state('root.help', {
        url: '/help',
        title: 'Help',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'help.html'
            }
        }
    })
        .state('root.profile', {
        url: '/profile',
        title: 'Profile',
        data: { 
            requireLogin: true,
            allowedRoles: ['Admin', 'Applier', 'Editor']
        },
        views: {
            'container@': {
                templateUrl: _contextPath + 'profile.html',
                controller: 'UserprofileCtrl'
            }
        }
    })
        .state('root.smellassess', {
        url: '/smellassess',
        title: 'Smell Self-Assessment',
        data: { requireLogin: false },
        views: {
            'container@': {
                templateUrl: _contextPath + 'smellassess.html',
                controller: 'SmellassessCtrl'
            }
        }
    });
}]);