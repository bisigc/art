'use strict';

describe('Controller: AreditcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var AreditcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AreditcontrollerCtrl = $controller('AreditcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AreditcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
