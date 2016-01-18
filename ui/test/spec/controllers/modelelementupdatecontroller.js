'use strict';

describe('Controller: ModelelementupdatecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ModelelementupdatecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ModelelementupdatecontrollerCtrl = $controller('ModelelementupdatecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ModelelementupdatecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
