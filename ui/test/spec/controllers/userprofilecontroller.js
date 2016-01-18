'use strict';

describe('Controller: UserprofilecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var UserprofilecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    UserprofilecontrollerCtrl = $controller('UserprofilecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(UserprofilecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
