(function(){
    'use strict';
    angular.module('app')
        .controller('alertVidController',alertVidControllerFn);

    alertVidControllerFn.$inject =['alertService','$routeParams'];

    function alertVidControllerFn(alertService,$routeParams) {

        var alertVidVm = this;

        alertService.getById($routeParams.id)
            .then(function(alerts){
                console.log("DETAILED REPORT Of Alerts");
                alertVidVm.alerts = alerts;
                console.log(alerts);
            },function(error){
                console.log(error);
            });
        }
})();