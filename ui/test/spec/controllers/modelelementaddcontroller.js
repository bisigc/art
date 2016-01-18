'use strict';

describe('Controller: ModelelementaddcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ModelelementaddcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ModelelementaddcontrollerCtrl = $controller('ModelelementaddcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ModelelementaddcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
