'use strict';

/**
 * Global function to set the smell filter via
 * the SmellTagCloud in the AR-Browser.
 *
 * author: cbi
 * date: 2016-01-15
 */

var setSmell = function(smell){ 
    var input = $('#smellname');
    input.val(smell);
    input.trigger('input');
};