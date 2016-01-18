'use strict';

describe('Controller: ArviewcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ArviewcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ArviewcontrollerCtrl = $controller('ArviewcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ArviewcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
