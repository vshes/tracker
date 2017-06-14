(function(){
    'use strict';
    angular.module('app')
        .controller('alertMapController',alertMapControllerFn);

    alertMapControllerFn.$inject = ['mapService','alertService','$routeParams'];


    function alertMapControllerFn(mapService,alertService,$routeParams,$http,NgMap,CONFIG) {
        var alertMapVm = this;
        var alertHandle = alertService.getAid($routeParams.aid);
        var mapHandle =  mapService.getMap();

        mapHandle.then(function (map) {
            alertMapVm.map = map;
        });

        alertHandle.then(function (response) {
                for( var i =0 ;i<response.data.length;i++){
                    var lat = response.data[i].latitude;
                    var long = response.data[i].longitude;
                    var alertid = response.data[i].alertid;
                    var vin = response.data[i].vin;
                    if(alertid == aid){
                        alertMapVm.latitude =lat;
                        alertMapVm.longitude =long;
                        alertMapVm.vin =  vin;
                    }

                }
        });
    }
})();