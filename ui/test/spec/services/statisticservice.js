'use strict';

describe('Service: StatisticService', function () {

  // load the service's module
  beforeEach(module('uiApp'));

  // instantiate service
  var StatisticService;
  beforeEach(inject(function (_StatisticService_) {
    StatisticService = _StatisticService_;
  }));

  it('should do something', function () {
    expect(!!StatisticService).toBe(true);
  });

});
