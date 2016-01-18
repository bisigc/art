'use strict';

describe('Controller: UsercreatecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var UsercreatecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UsercreatecontrollerCtrl = $controller('UsercreatecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UsercreatecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
