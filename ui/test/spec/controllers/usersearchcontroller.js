'use strict';

describe('Controller: UsersearchcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var UsersearchcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UsersearchcontrollerCtrl = $controller('UsersearchcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UsersearchcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
