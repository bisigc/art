'use strict';

describe('Service: isAllowed', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var isAllowed;
  beforeEach(inject(function (_isAllowed_) {
    isAllowed = _isAllowed_;
  }));

  it('should do something', function () {
    expect(!!isAllowed).toBe(true);
  });

});
