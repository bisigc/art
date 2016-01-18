'use strict';

describe('Service: DiscussionService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var DiscussionService;
  beforeEach(inject(function (_DiscussionService_) {
    DiscussionService = _DiscussionService_;
  }));

  it('should do something', function () {
    expect(!!DiscussionService).toBe(true);
  });

});
