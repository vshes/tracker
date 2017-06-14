(function(){
    'use strict';
    angular.module('app')
        .service('mapService',mapServiceFn);

    mapServiceFn.$inject =['NgMap'];

    function mapServiceFn(NgMap) {
        var mapVm = this;
        mapVm.getMap = getNewMap;
        function getNewMap() {
            return NgMap.getMap();
        }
    }

})();