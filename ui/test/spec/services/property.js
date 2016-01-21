'use strict';

describe('Service: Property', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var Property;
  beforeEach(inject(function (_Property_) {
    Property = _Property_;
  }));

  it('should do something', function () {
    expect(!!Property).toBe(true);
  });

});
