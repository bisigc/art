'use strict';

describe('Controller: SmellcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellcontrollerCtrl = $controller('SmellcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
