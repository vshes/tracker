(function () {
    'use strict';
    angular.module('app')
        .controller('vehicleController',vehicleControllerFn);

    vehicleControllerFn.$inject =['vehicleService'];
    function vehicleControllerFn(vehicleService) {
        var vehicleVm  = this;
        console.log("Vehicle Controller Invoked");
        vehicleService.getAll()
            .then(function (vehicles) {
                    console.log("In controller The data is found")
                    vehicleVm.vehicles = vehicles;
                    console.log("vehicles"+vehicles);
            });

    }
})();