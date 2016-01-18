'use strict';

describe('Controller: ModelelementcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ModelelementcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ModelelementcontrollerCtrl = $controller('ModelelementcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ModelelementcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
