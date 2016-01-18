'use strict';

describe('Service: SmellGroupService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var SmellGroupService;
  beforeEach(inject(function (_SmellGroupService_) {
    SmellGroupService = _SmellGroupService_;
  }));

  it('should do something', function () {
    expect(!!SmellGroupService).toBe(true);
  });

});
