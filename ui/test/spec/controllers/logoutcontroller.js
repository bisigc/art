'use strict';

describe('Controller: LogoutcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var LogoutcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LogoutcontrollerCtrl = $controller('LogoutcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(LogoutcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
