'use strict';

describe('Service: sharedSmell', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var sharedSmell;
  beforeEach(inject(function (_sharedSmell_) {
    sharedSmell = _sharedSmell_;
  }));

  it('should do something', function () {
    expect(!!sharedSmell).toBe(true);
  });

});
