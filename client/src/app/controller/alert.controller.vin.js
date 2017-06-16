(function(){
    'use strict';
    angular.module('app')
        .controller('alertVidController',alertVidControllerFn);

    alertVidControllerFn.$inject =['alertService','$routeParams'];

    function alertVidControllerFn(alertService,$routeParams) {

        var alertVidVm = this;
        alertVidVm.getMaps = getAllLocations;

        alertService.getById($routeParams.id)
            .then(function(alerts){
                alertVidVm.alerts = alerts;
                console.log(alerts);
            },function(error){
                console.log(error);
            });
        }

        function getAllLocations() {
            return alertVidVm.alerts;
        }


})();