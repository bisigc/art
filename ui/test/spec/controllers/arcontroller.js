'use strict';

describe('Controller: ArcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ArcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ArcontrollerCtrl = $controller('ArcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ArcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
