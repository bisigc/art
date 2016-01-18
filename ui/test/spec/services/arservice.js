'use strict';

describe('Service: ArService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ArService;
  beforeEach(inject(function (_ArService_) {
    ArService = _ArService_;
  }));

  it('should do something', function () {
    expect(!!ArService).toBe(true);
  });

});
