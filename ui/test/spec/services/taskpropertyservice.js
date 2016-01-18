'use strict';

describe('Service: TaskPropertyService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var TaskPropertyService;
  beforeEach(inject(function (_TaskPropertyService_) {
    TaskPropertyService = _TaskPropertyService_;
  }));

  it('should do something', function () {
    expect(!!TaskPropertyService).toBe(true);
  });

});
