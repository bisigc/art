'use strict';

describe('Service: PasswordValidator', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var PasswordValidator;
  beforeEach(inject(function (_PasswordValidator_) {
    PasswordValidator = _PasswordValidator_;
  }));

  it('should do something', function () {
    expect(!!PasswordValidator).toBe(true);
  });

});
