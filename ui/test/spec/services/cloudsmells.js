'use strict';

describe('Service: CloudSmells', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var CloudSmells;
  beforeEach(inject(function (_CloudSmells_) {
    CloudSmells = _CloudSmells_;
  }));

  it('should do something', function () {
    expect(!!CloudSmells).toBe(true);
  });

});
