'use strict';

describe('Controller: PropertiesCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var PropertiesCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PropertiesCtrl = $controller('PropertiesCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PropertiesCtrl.awesomeThings.length).toBe(3);
  });
});
