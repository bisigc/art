'use strict';

describe('Directive: hilighter', function () {

  // load the directive's module
  beforeEach(module('uiApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<hilighter></hilighter>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the hilighter directive');
  }));
});
