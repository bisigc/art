'use strict';

describe('Controller: UserviewcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var UserviewcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserviewcontrollerCtrl = $controller('UserviewcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UserviewcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
