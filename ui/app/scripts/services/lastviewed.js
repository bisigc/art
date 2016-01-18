'use strict';

/**
 * @ngdoc service
 * @name uiApp.LastViewed
 * @description
 * # LastViewed
 * Factory in the uiApp.
 */
angular.module('uiApp')
  .factory('LastViewed', ['$filter', '$cookieStore', function($filter, $cookieStore) {
    var maxitems = 5;
    var lastviewedList = {list: []};
    var cookielist = $cookieStore.get('art_lastviewed_items', this.list);
    if(cookielist) {
        lastviewedList.list = cookielist;
    }
    // Item has to have the format {'name': name, 'type': type, 'id': id}
    lastviewedList.add = function (item) {
        //Remove entry if the item already exists to add afterwards at the top.
        var idx = -1;
        for(var i = 0; i < this.list.length && idx === -1; i++) {
            if(this.list[i].type === item.type && this.list[i].id === item.id) {
                idx = i;
            }
        }
        if(idx !== -1) {
            this.list.splice(idx, 1);
        }
        //Add at the beginning.
        this.list.unshift(item);
        if(this.list.length > maxitems) {
            //Remove last item.
            this.list.splice(this.list.length - 1);
        }
        $cookieStore.put('art_lastviewed_items', this.list);
    };
    return lastviewedList;
}]);