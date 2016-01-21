'use strict';

describe('Controller: PropertyviewCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var PropertyviewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PropertyviewCtrl = $controller('PropertyviewCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PropertyviewCtrl.awesomeThings.length).toBe(3);
  });
});
