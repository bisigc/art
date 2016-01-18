'use strict';

describe('Filter: toSafeHtml', function () {

  // load the filter's module
  beforeEach(module('uiApp'));

  // initialize a new instance of the filter before each test
  var toSafeHtml;
  beforeEach(inject(function ($filter) {
    toSafeHtml = $filter('toSafeHtml');
  }));

  it('should return the input prefixed with "toSafeHtml filter:"', function () {
    var text = 'angularjs';
    expect(toSafeHtml(text)).toBe('toSafeHtml filter: ' + text);
  });

});
