'use strict';

describe('Controller: ArsearchcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ArsearchcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ArsearchcontrollerCtrl = $controller('ArsearchcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ArsearchcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
