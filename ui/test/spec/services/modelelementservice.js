'use strict';

describe('Service: ModelElementService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ModelElementService;
  beforeEach(inject(function (_ModelElementService_) {
    ModelElementService = _ModelElementService_;
  }));

  it('should do something', function () {
    expect(!!ModelElementService).toBe(true);
  });

});
