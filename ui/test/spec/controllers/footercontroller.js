'use strict';

describe('Controller: FootercontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var FootercontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FootercontrollerCtrl = $controller('FootercontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(FootercontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
