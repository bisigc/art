'use strict';

describe('Service: UserSearchService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var UserSearchService;
  beforeEach(inject(function (_UserSearchService_) {
    UserSearchService = _UserSearchService_;
  }));

  it('should do something', function () {
    expect(!!UserSearchService).toBe(true);
  });

});
