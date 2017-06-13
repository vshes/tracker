(function(){
    'use strict';
    angular.module('app')
        .controller('readingsController',readingsControllerFn);

    function readingsControllerFn() {
        console.log("Reading Controller Invoked");

    }
})();