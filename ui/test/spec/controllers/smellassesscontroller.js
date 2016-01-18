'use strict';

describe('Controller: SmellassesscontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellassesscontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellassesscontrollerCtrl = $controller('SmellassesscontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellassesscontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
