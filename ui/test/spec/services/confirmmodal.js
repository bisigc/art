'use strict';

describe('Service: ConfirmModal', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var ConfirmModal;
  beforeEach(inject(function (_ConfirmModal_) {
    ConfirmModal = _ConfirmModal_;
  }));

  it('should do something', function () {
    expect(!!ConfirmModal).toBe(true);
  });

});
