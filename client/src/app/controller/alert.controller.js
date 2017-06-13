(function(){
    'use strict';
    angular.module('app')
        .controller('alertController',alertControllerFn);

    alertControllerFn.$inject =['alertService'];

    function alertControllerFn(alertService){

        var alertVm  = this;
        alertService.getAlerts()
            .then(function(alerts){
                alertVm.alerts = alerts;
                console.log(alerts);
            },function(error){
                console.log(error);
            });
    }


})();