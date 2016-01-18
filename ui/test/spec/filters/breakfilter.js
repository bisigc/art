'use strict';

describe('Filter: breakFilter', function () {

  // load the filter's module
  beforeEach(module('uiApp'));

  // initialize a new instance of the filter before each test
  var breakFilter;
  beforeEach(inject(function ($filter) {
    breakFilter = $filter('breakFilter');
  }));

  it('should return the input prefixed with "breakFilter filter:"', function () {
    var text = 'angularjs';
    expect(breakFilter(text)).toBe('breakFilter filter: ' + text);
  });

});
