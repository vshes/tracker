(function(){
    'use strict';
    angular.module('app')
        .controller('readingsController',readingsControllerFn);

    readingsControllerFn.$inject =['readingService','$routeParams'];

    function readingsControllerFn(readingService,$routeParams) {
        console.log("Reading Controller Invoked");

        var readingVm = this;
        var readingHandle = readingService.getAll();
        //var readingVinHandle =readingService.getById($routeParams.id);

        readingHandle.then(function (readings) {
            console.log(readings);
            readingVm.readings = readings;
        });


        // readingVinHandle.then(function (response) {
        //     console.log(response.data);
        //     readingVm.readingsVin =response.data;
        // });


    }
})();