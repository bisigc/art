'use strict';

describe('Service: AvatarUploader', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var AvatarUploader;
  beforeEach(inject(function (_AvatarUploader_) {
    AvatarUploader = _AvatarUploader_;
  }));

  it('should do something', function () {
    expect(!!AvatarUploader).toBe(true);
  });

});
