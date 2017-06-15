(function () {
    'use strict';
    angular.module('app')
        .service('readingService',readingServiceFn);

    readingServiceFn.$inject =['$http','$q','CONFIG'];

    function readingServiceFn($http,$q,CONFIG) {
        var self = this;
        self.getAll = getAllReadings;
        self.getById = getReadingsByVin;


        function getAllReadings() {
            console.log("In service Calling Vehicles End Point !");
            console.log(CONFIG.API_READINGS);
            return $http.get(CONFIG.API_READINGS)
                .then(successFn, errorFn);
        }


        function getReadingsByVin(id) {
            console.log("Readings for Vehicle" + CONFIG.API_ALERT + id);
            return $http.get(CONFIG.API_READINGS + id)
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