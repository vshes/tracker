(function(){
    'use strict';
    angular.module('app')
        .controller('readingsVinController',readingsVinControllerFn);

    readingsVinControllerFn.$inject =['readingService','$routeParams'];

    function readingsVinControllerFn(readingService,$routeParams) {
        console.log("Reading Controller Invoked");

        var readingVinVm = this;
        var readingVinHandle =readingService.getById($routeParams.id);

        readingVinHandle.then(function (readings) {
            console.log(readings);
            readingVinVm.readingsVin = readings;
        });


    }
})();