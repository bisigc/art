'use strict';

describe('Controller: PropertyaddCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var PropertyaddCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PropertyaddCtrl = $controller('PropertyaddCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PropertyaddCtrl.awesomeThings.length).toBe(3);
  });
});
