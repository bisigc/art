'use strict';

describe('Service: FileUploader', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var FileUploader;
  beforeEach(inject(function (_FileUploader_) {
    FileUploader = _FileUploader_;
  }));

  it('should do something', function () {
    expect(!!FileUploader).toBe(true);
  });

});
