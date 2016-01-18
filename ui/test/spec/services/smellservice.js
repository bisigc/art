'use strict';

describe('Service: SmellService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var SmellService;
  beforeEach(inject(function (_SmellService_) {
    SmellService = _SmellService_;
  }));

  it('should do something', function () {
    expect(!!SmellService).toBe(true);
  });

});
