'use strict';

describe('Controller: AraddcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var AraddcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AraddcontrollerCtrl = $controller('AraddcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AraddcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
