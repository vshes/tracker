(function () {
    'use strict';
    angular.module('app')
        .controller('vehicleController',vehicleControllerFn);

    vehicleControllerFn.$inject =['vehicleService','$rootScope'];

    function vehicleControllerFn(vehicleService,$rootScope) {
        var vehicleVm  = this;
         $rootScope.flag = false;

        console.log("Vehicle Controller Invoked");
        console.log($rootScope.flag);
        vehicleService.getAll()
            .then(function (vehicles) {
                    console.log("In controller The data is found")
                    vehicleVm.vehicles = vehicles;
                    console.log("vehicles"+vehicles);
            });

    }
})();