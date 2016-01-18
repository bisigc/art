'use strict';

describe('Controller: StatscontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var StatscontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StatscontrollerCtrl = $controller('StatscontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(StatscontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
