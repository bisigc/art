'use strict';

describe('Service: PropModal', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var PropModal;
  beforeEach(inject(function (_PropModal_) {
    PropModal = _PropModal_;
  }));

  it('should do something', function () {
    expect(!!PropModal).toBe(true);
  });

});
