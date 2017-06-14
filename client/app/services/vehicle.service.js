(function () {
    'use strict';
    angular.module('app')
        .service('vehicleService',vehicleServiceFn);

    vehicleServiceFn.$inject = ['$http','$q','CONFIG'];
    function vehicleServiceFn($http,$q,CONFIG) {
        var self = this;
        self.getAll = getAllVehicles;
        self.getById = getVehicleById;

        function getAllVehicles() {
            console.log(CONFIG.API_VEHICLE);
            return $http.get(CONFIG.API_VEHICLE)
                .then(successFn,errorFn);
        }

        function getVehicleById(id) {
            return $http.get(CONFIG.API_VEHICLE_ID +id)
                .then(successFn,errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
           return  $q.reject(error);
        }
    }
})();