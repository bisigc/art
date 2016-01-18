'use strict';

describe('Controller: SmellupdatecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellupdatecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellupdatecontrollerCtrl = $controller('SmellupdatecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellupdatecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
