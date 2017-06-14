(function () {
    'use strict';
    angular.module('app')
        .service('alertService',alertServiceFn);

    alertServiceFn.$inject =['$http','$q','CONFIG','NgMap'];

    function alertServiceFn($http,$q,CONFIG,NgMap) {
        var self = this;
        self.getAlerts = getAllAlerts;
        self.getById = getAlertsByVin;
        self.getAid = getAlertById;


        function getAllAlerts() {
            console.log("In service Calling Vehicles End Point !");
            console.log(CONFIG.API_ALERT);
            return $http.get(CONFIG.API_ALERT)
                .then(successFn, errorFn);
        }

        function getAlertById(aid) {
             console.log(CONFIG.API_ALERT);
             return $http.get(CONFIG.API_ALERT);

         }

        function getAlertsByVin(id) {
            console.log("Alerts for Vehicle" + CONFIG.API_ALERT + id);
            return $http.get(CONFIG.API_ALERT + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }

    }
})();