'use strict';

describe('Controller: TaskmodaladdcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var TaskmodaladdcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TaskmodaladdcontrollerCtrl = $controller('TaskmodaladdcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TaskmodaladdcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
