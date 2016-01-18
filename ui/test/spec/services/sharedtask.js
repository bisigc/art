'use strict';

describe('Service: sharedTask', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var sharedTask;
  beforeEach(inject(function (_sharedTask_) {
    sharedTask = _sharedTask_;
  }));

  it('should do something', function () {
    expect(!!sharedTask).toBe(true);
  });

});
