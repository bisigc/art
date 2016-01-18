'use strict';

describe('Service: LastViewed', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var LastViewed;
  beforeEach(inject(function (_LastViewed_) {
    LastViewed = _LastViewed_;
  }));

  it('should do something', function () {
    expect(!!LastViewed).toBe(true);
  });

});
