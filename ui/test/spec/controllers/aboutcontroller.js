'use strict';

describe('Controller: AboutcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var AboutcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AboutcontrollerCtrl = $controller('AboutcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AboutcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
