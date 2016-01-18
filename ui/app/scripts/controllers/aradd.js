'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:AraddCtrl
 * @description
 * # AraddCtrl
 * Controller of the uiApp
 */
angular.module('uiApp')
  .controller('AraddCtrl', ['ArService', 'ArVersionService', 'SmellService', 'TaskService', 'ModelElementService', 'StatusService', 'ReplyErrorHandler', 'notifications', '$scope', '$stateParams', '$filter', '$state', 'PropModal', 'TaskModal', 'SmellModal', function(ArService, ArVersionService, SmellService, TaskService, ModelElementService, StatusService, ReplyErrorHandler, notifications, $scope, $stateParams, $filter, $state, PropModal, TaskModal, SmellModal) {
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
    $scope.modelelementsvalues.references = [];
    
    if($stateParams.id && $stateParams.id != '') {
        ArVersionService.id.get({id: $stateParams.id}, function(data, status, headers, config) {
            $scope.arversion = data;
            $scope.ar.id = $scope.arversion.arhead.id;
            $scope.arversion.discussion = {};
            //$scope.arversion.commentary = {};
            $scope.modelelementsvalues.qas = $filter('arPropFilter')($scope.arversion.properties, 'QASElementLink');
            $scope.modelelementsvalues.context = $filter('arPropFilter')($scope.arversion.properties, 'ContextElementLink');
            $scope.modelelementsvalues.components = $filter('arPropFilter')($scope.arversion.properties, 'ComponentElementLink');
            $scope.modelelementsvalues.decisions = $filter('arPropFilter')($scope.arversion.properties, 'DecisionElementLink');
            $scope.modelelementsvalues.references = $filter('arPropFilter')($scope.arversion.properties, 'ReferenceElementLink');
            $scope.arversion.properties = [];
            $scope.arversion.id = null;
        }, ReplyErrorHandler);
    }
    
    $scope.addcreatedProp = function(typeAndnewProp) {
        $scope.loadProps(typeAndnewProp.type);
        switch(typeAndnewProp.type) {
            case 'QASElementLink':
                $scope.modelelementsvalues.qas.push(typeAndnewProp.newProp);
                break;
            case 'ContextElementLink':
                $scope.modelelementsvalues.context.push(typeAndnewProp.newProp);
                break;
            case 'ComponentElementLink':
                $scope.modelelementsvalues.components.push(typeAndnewProp.newProp);
                break;
            case 'DecisionElementLink':
                $scope.modelelementsvalues.decisions.push(typeAndnewProp.newProp);
                break;
            case 'ReferenceElementLink':
                $scope.modelelementsvalues.references.push(typeAndnewProp.newProp);
                break;
            default:
                break;
        }
    }
    
    $scope.openPropModal = function(type) {
        PropModal.open(type, $scope.addcreatedProp, function() {});
    }
    
    $scope.loadSmells = function () {
        SmellService.noid.get({},function(data, status, headers, config) {
            $scope.smells = data;
        }, ReplyErrorHandler);     
    };
    
    $scope.addcreatedSmell = function(newSmell) {
        $scope.loadSmells();
        $scope.arversion.smells.push(newSmell);
    }

    $scope.openSmellModal = function(type) {
        SmellModal.open(type, $scope.addcreatedSmell, function() {});
    }
    
    $scope.loadTasks = function () {
		TaskService.noid.get({},function(data, status, headers, config) {
		    $scope.tasks = data;
		}, ReplyErrorHandler);   
    };
    
    $scope.addcreatedTask = function(newTask) {
        $scope.loadTasks();
        $scope.arversion.tasks.push(newTask);
    }
    
    $scope.openTaskModal = function(type) {
        TaskModal.open(type, $scope.addcreatedTask, function() {});
    }

    $scope.loadValues = function () {
        StatusService.get({},function(data, status, headers, config) {
            $scope.status = data;
            $scope.arversion.status = $scope.status[0];
        }, ReplyErrorHandler);        
    	$scope.loadSmells();
    	$scope.loadTasks();
        ModelElementService.type.get({},function(data, status, headers, config) {
            $scope.modelelementtypes = data;
            $scope.loadAllProps();
        }, ReplyErrorHandler);  
    };
    $scope.loadValues();
    
    $scope.loadProps = function(type) {
        switch(type) {
            case 'QASElementLink':
                ModelElementService.qas.get({},function(data, status, headers, config) {
                    $scope.modelelements.qas = data;
                }, ReplyErrorHandler);  
                break;
            case 'ContextElementLink':
                ModelElementService.context.get({},function(data, status, headers, config) {
                    $scope.modelelements.context = data;
                }, ReplyErrorHandler); 
                break;
            case 'ComponentElementLink':
                ModelElementService.components.get({},function(data, status, headers, config) {
                    $scope.modelelements.components = data;
                }, ReplyErrorHandler);  
                break;
            case 'DecisionElementLink':
                ModelElementService.decisions.get({},function(data, status, headers, config) {
                    $scope.modelelements.decisions = data;
                }, ReplyErrorHandler);  
                break;
            case 'ReferenceElementLink':
                ModelElementService.references.get({},function(data, status, headers, config) {
                    $scope.modelelements.references = data;
                }, ReplyErrorHandler);  
                break;
            default:
                break;
        }       
    }
    
    $scope.loadAllProps = function() {
        for(var i = 0;i < $scope.modelelementtypes.length;i++) {
            $scope.loadProps($scope.modelelementtypes[i]);
        }
    }

    $scope.mergeProperties = function() {
        //angular.extend(ar.versions, arversion);
        $scope.arversion.properties = [].concat(
            $scope.modelelementsvalues.qas,
            $scope.modelelementsvalues.context,
            $scope.modelelementsvalues.components,
            $scope.modelelementsvalues.decisions,
            $scope.modelelementsvalues.references
            );
    }
    
    $scope.saveAr = function() {
        $scope.mergeProperties();
        if($stateParams.id && $stateParams.id != '') {
            ArVersionService.noid.create($scope.arversion, function(data, status, headers, config) {
                notifications.showSuccess('ArVersion has been added successfully.');
                $state.go('root.singlear', {id: data.arhead.id});
            }, ReplyErrorHandler);
        } else {
            ArService.noid.create($scope.ar, function(data, status, headers, config) {
                notifications.showSuccess('Ar has been added successfully.');
                $state.go('root.singlear', {id: data.id});
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