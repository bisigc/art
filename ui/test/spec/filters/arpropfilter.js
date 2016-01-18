'use strict';

describe('Filter: arPropFilter', function () {

  // load the filter's module
  beforeEach(module('uiApp'));

  // initialize a new instance of the filter before each test
  var arPropFilter;
  beforeEach(inject(function ($filter) {
    arPropFilter = $filter('arPropFilter');
  }));

  it('should return the input prefixed with "arPropFilter filter:"', function () {
    var text = 'angularjs';
    expect(arPropFilter(text)).toBe('arPropFilter filter: ' + text);
  });

});
