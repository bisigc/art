'use strict';

describe('Service: isLoggedin', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var isLoggedin;
  beforeEach(inject(function (_isLoggedin_) {
    isLoggedin = _isLoggedin_;
  }));

  it('should do something', function () {
    expect(!!isLoggedin).toBe(true);
  });

});
