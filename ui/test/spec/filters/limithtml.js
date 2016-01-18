'use strict';

describe('Filter: limitHtml', function () {

  // load the filter's module
  beforeEach(module('uiApp'));

  // initialize a new instance of the filter before each test
  var limitHtml;
  beforeEach(inject(function ($filter) {
    limitHtml = $filter('limitHtml');
  }));

  it('should return the input prefixed with "limitHtml filter:"', function () {
    var text = 'angularjs';
    expect(limitHtml(text)).toBe('limitHtml filter: ' + text);
  });

});
