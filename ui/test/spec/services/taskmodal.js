'use strict';

describe('Service: TaskModal', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var TaskModal;
  beforeEach(inject(function (_TaskModal_) {
    TaskModal = _TaskModal_;
  }));

  it('should do something', function () {
    expect(!!TaskModal).toBe(true);
  });

});
