app.filter('limitHtml', function() {
    return function(text, limit) {

        var changedString = String(text).replace(/<[^>]+>/gm, '');
        var length = changedString.length;

        return changedString.length > limit ? changedString.substr(0, limit - 1) : changedString; 
    }
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