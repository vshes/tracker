(function () {
    'use strict';
    angular.module('app')
        .service('alertService',alertServiceFn);

    alertServiceFn.$inject =['$http','$q','CONFIG','NgMap'];

    function alertServiceFn($http,$q,CONFIG,NgMap) {
        var self = this;


        self.getAlerts = getAllAlerts;
        self.getById = getAlertsByVin;
        self.getMap = getGoogleMap;
       // self.getByAid = getAlertById;



        function getAllAlerts() {
            console.log("In service Calling Vehicles End Point !");
            console.log(CONFIG.API_ALERT);
            return $http.get(CONFIG.API_ALERT)
                .then(successFn, errorFn);
        }

        // function getAlertById(aid) {
        //     console.log("In service Calling Vehicles End Point !");
        //     console.log(CONFIG.API_ALERT);
        //     $http.get(CONFIG.API_ALERT)
        //         .then(function (response) {
        //             console.log( response.data);
        //             console.log("THIS IS TESTED !");
        //             for( var i =0 ;i<response.data.length;i++){
        //                 console.log(response.data.length);
        //                 var lat = response.data[i].latitude;
        //                 var long = response.data[i].longitude;
        //                 var alertid = response.data[i].alertid;
        //                 if(alertid == aid){
        //                     console.log(lat+"\t"+long+"\t"+alertid);
        //                     self.latitude =lat;
        //                     self.longitude =long;
        //                    return [lat,long];
        //                 }
        //
        //             }
        //
        //         }, errorFn);
        // }


        function getGoogleMap(aid) {
            console.log("get Maps Function called" + aid);
            NgMap.getMap().then(function (map) {
                $http.get(CONFIG.API_ALERT)
                    .then(function (response) {
                        console.log( response.data);
                        console.log("THIS IS TESTED !");
                        for( var i =0 ;i<response.data.length;i++){
                            console.log(response.data.length);
                            var lat = response.data[i].latitude;
                            var long = response.data[i].longitude;
                            var alertid = response.data[i].alertid;
                            if(alertid == aid){
                                console.log(lat+"\t"+long+"\t"+alertid);
                                self.latitude =lat;
                                self.longitude =long;
                                return response.data[i];
                            }

                        }

                    }, errorFn);

            });
        }

        function getAlertsByVin(id) {
            console.log("**** HITTING URL ***" + CONFIG.API_ALERT + id);
            return $http.get(CONFIG.API_ALERT + id)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            console.log("serevre HIT BY ID !");

            console.log(response.data);
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }

        function successAidFn(response) {
            console.log("FUNCTION CHECK THIS !!!");
            console.log(response.data);


        }
    }
})();