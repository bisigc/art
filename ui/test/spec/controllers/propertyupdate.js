'use strict';

describe('Controller: PropertyupdateCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var PropertyupdateCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PropertyupdateCtrl = $controller('PropertyupdateCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PropertyupdateCtrl.awesomeThings.length).toBe(3);
  });
});
