'use strict';

describe('Controller: TaskaddcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var TaskaddcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TaskaddcontrollerCtrl = $controller('TaskaddcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TaskaddcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
