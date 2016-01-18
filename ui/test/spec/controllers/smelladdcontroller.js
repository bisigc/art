'use strict';

describe('Controller: SmelladdcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmelladdcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmelladdcontrollerCtrl = $controller('SmelladdcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmelladdcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
