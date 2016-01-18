'use strict';

describe('Service: StatusService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var StatusService;
  beforeEach(inject(function (_StatusService_) {
    StatusService = _StatusService_;
  }));

  it('should do something', function () {
    expect(!!StatusService).toBe(true);
  });

});
