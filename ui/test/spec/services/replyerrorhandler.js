'use strict';

describe('Service: ReplyErrorHandler', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ReplyErrorHandler;
  beforeEach(inject(function (_ReplyErrorHandler_) {
    ReplyErrorHandler = _ReplyErrorHandler_;
  }));

  it('should do something', function () {
    expect(!!ReplyErrorHandler).toBe(true);
  });

});
