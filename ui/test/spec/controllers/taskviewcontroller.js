'use strict';

describe('Controller: TaskviewcontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var TaskviewcontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TaskviewcontrollerCtrl = $controller('TaskviewcontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(TaskviewcontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
