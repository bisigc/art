'use strict';

describe('Service: ArVersionService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ArVersionService;
  beforeEach(inject(function (_ArVersionService_) {
    ArVersionService = _ArVersionService_;
  }));

  it('should do something', function () {
    expect(!!ArVersionService).toBe(true);
  });

});
