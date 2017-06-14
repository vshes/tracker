(function(){
    'use strict';
    angular.module('app')
        .controller('vehicleAttributesController',vehicleAttributesControllerFn);

    vehicleAttributesControllerFn.$inject = ['alertService','mapService','$routeParams'];

    function vehicleAttributesControllerFn(alertService,mapService,$routeParams) {
        var vehicleAttVm = this;
        var alertHandle = alertService.getById($routeParams.id);
        var mapHandle =  mapService.getMap();

        vehicleAttVm.toggleMap = showHideMap;
        vehicleAttVm.mapFlag = true;

       mapHandle.then(function () {
           console.log("map created!");
       });

       alertHandle.then(function(alerts){
           vehicleAttVm.alerts = alerts;
           var latSum = 0;
           var longSum =0;
           var positions=[];
           for(var i =0 ;i< vehicleAttVm.alerts.length ;i++){
               positions.push([vehicleAttVm.alerts[i].latitude,vehicleAttVm.alerts[i].longitude]);
               latSum +=  vehicleAttVm.alerts[i].latitude;
               longSum +=  vehicleAttVm.alerts[i].longitude;

           }
           console.log(latSum +"\t"+ longSum);

           vehicleAttVm.locations = positions;
           vehicleAttVm.avgLatitude = latSum / vehicleAttVm.alerts.length;
           vehicleAttVm.avgLongitude = longSum / vehicleAttVm.alerts.length;
           console.log(vehicleAttVm.avgLatitude +"\t" +vehicleAttVm.avgLongitude);
       },function(error){
           console.log(error);
       });

        function showHideMap() {
            vehicleAttVm.mapFlag = ! vehicleAttVm.mapFlag;
            
        }
    }
})();