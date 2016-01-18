'use strict';

describe('Controller: ExectasktypecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var ExectasktypecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ExectasktypecontrollerCtrl = $controller('ExectasktypecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ExectasktypecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
