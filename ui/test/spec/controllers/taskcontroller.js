'use strict';

describe('Controller: TaskcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var TaskcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TaskcontrollerCtrl = $controller('TaskcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TaskcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
