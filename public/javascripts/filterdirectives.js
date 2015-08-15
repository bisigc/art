app.filter('limitHtml', function() {
    return function(text, limit) {

        if(text) {
            var changedString = String(text).replace(/<[^>]+>/gm, '');
            var length = changedString.length;
            return changedString.length > limit ? changedString.substr(0, limit - 1) + "..." : changedString; 
        }
        return "";
    }
});

app.filter('limit', function() {
    return function(text, limit) {

        if(text) {
            var length = text.length;
            return text.length > limit ? text.substr(0, limit - 1) + "..." : text; 
        }
        return "";
    }
});

app.filter('breakFilter', function () {
    return function (text) {
        if (typeof text !== 'undefined' && text != null && text !== '') return text.replace(/\n/g, '<br />');
    };
});

app.filter('arPropFilter', function () {
    return function (props, type) {
        var arrayToReturn = []; 
        if (angular.isArray(props)) {
            for (var i=0; i<props.length; i++){
                if (props[i].type == type) {
                    arrayToReturn.push(props[i]);
                }
            }
        }
        
        return arrayToReturn;
    };
});

/*
 * propsFilter used for mulitple ui-select.
 */
app.filter('propsFilter', function() {
  return function(items, props) {
    var out = [];

    if (angular.isArray(items)) {
      items.forEach(function(item) {
        var itemMatches = false;

        var keys = Object.keys(props);
        for (var i = 0; i < keys.length; i++) {
          var prop = keys[i];
          var text = props[prop].toLowerCase();
          if (item[prop] && item[prop].toString().toLowerCase().indexOf(text) !== -1) {
            itemMatches = true;
            break;
          }
        }

        if (itemMatches) {
          out.push(item);
        }
      });
    } else {
      // Let the output be the input untouched
      out = items;
    }

    return out;
  };
});

app.directive('compile',function($compile, $timeout){
    return {
        restrict:'A',
        link: function(scope,elem,attrs){
            $timeout(function(){
                $compile(elem.contents())(scope);    
            },100);
        }
    };
});

app.directive('hilighter', ['$timeout', function($timeout) {
  return {
    restrict: 'A',
    scope: {
      model: '=hilighter'
    },
    link: function(scope, element) {
      scope.$watch('model', function (nv, ov) {
        if (nv !== ov) {
          // apply class
          element.addClass('label-success');
          element.removeClass('label-default');

          // auto remove after some delay
          $timeout(function () {
            element.removeClass('label-success');
            element.addClass('label-default');
          }, 1000);
        }
      });
    }
  };
}]);

app.directive('commentArea', function() {
   return {
        restrict: 'EA',
        scope: {
            datasource: '=',
            add: '&',
        },
        controller: function ($scope) {
            $scope.addCustomer = function () {
                //Call external scope's function
                var name = 'New Customer Added by Directive';

                $scope.add()(name);
            };
        },
        template: '<button ng-click="addCustomer()">Change Data</button><ul>' +
                  '<li ng-repeat="cust in customers">{{ cust.name }}</li></ul>'
    };
});

app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);