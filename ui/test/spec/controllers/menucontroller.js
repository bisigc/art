'use strict';

describe('Controller: MenucontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var MenucontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MenucontrollerCtrl = $controller('MenucontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MenucontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
