'use strict';

describe('Controller: DiscussioncontrollerCtrl', function () {

  // load the controller's module
  beforeEach(module('uiApp'));

  var DiscussioncontrollerCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    DiscussioncontrollerCtrl = $controller('DiscussioncontrollerCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(DiscussioncontrollerCtrl.awesomeThings.length).toBe(3);
  });
});
