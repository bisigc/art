'use strict';

describe('Controller: TaskupdatecontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var TaskupdatecontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TaskupdatecontrollerCtrl = $controller('TaskupdatecontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TaskupdatecontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
