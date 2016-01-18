'use strict';

describe('Controller: DummyCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var DummyCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DummyCtrl = $controller('DummyCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(DummyCtrl.awesomeThings.length).toBe(3);
  });
});
