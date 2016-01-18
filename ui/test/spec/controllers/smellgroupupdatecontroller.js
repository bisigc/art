'use strict';

describe('Controller: SmellgroupupdatecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var SmellgroupupdatecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SmellgroupupdatecontrollerCtrl = $controller('SmellgroupupdatecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SmellgroupupdatecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
