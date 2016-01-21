'use strict';

describe('Service: sharedProperty', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var sharedProperty;
  beforeEach(inject(function (_sharedProperty_) {
    sharedProperty = _sharedProperty_;
  }));

  it('should do something', function () {
    expect(!!sharedProperty).toBe(true);
  });

});
