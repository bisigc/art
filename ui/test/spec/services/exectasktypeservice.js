'use strict';

describe('Service: ExecTaskTypeService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ExecTaskTypeService;
  beforeEach(inject(function (_ExecTaskTypeService_) {
    ExecTaskTypeService = _ExecTaskTypeService_;
  }));

  it('should do something', function () {
    expect(!!ExecTaskTypeService).toBe(true);
  });

});
