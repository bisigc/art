'use strict';

describe('Controller: SmellviewcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellviewcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellviewcontrollerCtrl = $controller('SmellviewcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellviewcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
