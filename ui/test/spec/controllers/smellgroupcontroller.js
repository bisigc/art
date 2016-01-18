'use strict';

describe('Controller: SmellgroupcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellgroupcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellgroupcontrollerCtrl = $controller('SmellgroupcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellgroupcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
