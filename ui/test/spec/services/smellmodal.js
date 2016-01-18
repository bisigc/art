'use strict';

describe('Service: SmellModal', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var SmellModal;
  beforeEach(inject(function (_SmellModal_) {
    SmellModal = _SmellModal_;
  }));

  it('should do something', function () {
    expect(!!SmellModal).toBe(true);
  });

});
