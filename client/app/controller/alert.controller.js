(function(){
    'use strict';
    angular.module('app')
        .controller('alertController',alertControllerFn);

    alertControllerFn.$inject =['alertService'];

    function alertControllerFn(alertService){

        var alertVm  = this;
        alertVm.timeOptions = [1,2,3,4,5];
        alertVm.getCount = getHighAlertCount;

        alertService.getAlerts()
            .then(function(alerts){
                alertVm.alerts = alerts;
                console.log(alerts);
            },function(error){
                console.log(error);
            });

        function getHighAlertCount () {

            var endTime = (new Date()).getTime();
            var startTime = (endTime - 3600000 * alertVm.selectedItem);

            alertVm.startTime = startTime;
            alertVm.endTime  = endTime;

            var count =0;
            for (var i = 0; i < alertVm.alerts.length; i++) {
                var timestamp = alertVm.alerts[i].timestamp;
                var alertType = alertVm.alerts[i].priority;

                if((timestamp >= startTime) && (timestamp <= endTime) && (alertType == "HIGH")){
                    count += 1;
                }
            }
            alertVm.alertCount = count;
        }
    }


})();