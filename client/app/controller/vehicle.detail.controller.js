(function(){
    'use strict';
    angular.module('app')
        .controller('vehicleDetailController',vehicleDetailControllerFn);

    vehicleDetailControllerFn.$inject = ['vehicleService','$routeParams']
    function vehicleDetailControllerFn(vehicleService,$routeParams) {

        var vehicleDetVM = this;
        vehicleService.getById($routeParams.id)
            .then(function(vehicle){
                console.log("DETAILED REPORT Of VEHICLE");
                vehicleDetVM.vehicle = vehicle;
            },function(error){
                console.log(error);
            });
    }
})();