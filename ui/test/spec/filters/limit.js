'use strict';

describe('Filter: limit', function () {

  // load the filter's module
  beforeEach(module('uiApp'));

  // initialize a new instance of the filter before each test
  var limit;
  beforeEach(inject(function ($filter) {
    limit = $filter('limit');
  }));

  it('should return the input prefixed with "limit filter:"', function () {
    var text = 'angularjs';
    expect(limit(text)).toBe('limit filter: ' + text);
  });

});
