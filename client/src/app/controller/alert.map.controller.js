(function(){
    'use strict';
    angular.module('app')
        .controller('alertMapController',alertMapControllerFn);

    alertMapControllerFn.$inject = ['alertService','$routeParams','$http','NgMap','CONFIG'];


    function alertMapControllerFn(alertService,$routeParams,$http,NgMap,CONFIG) {
        console.log("ID IS:"+$routeParams.id);
        var alertMapVm = this;
         getCMap($routeParams.id);

        function getCMap(aid) {

            NgMap.getMap().then(function (map) {
                $http.get(CONFIG.API_ALERT)
                    .then(function (response) {
                        for (var i = 0; i < response.data.length; i++) {
                            console.log(response.data.length);
                            var lat = response.data[i].latitude;
                            var long = response.data[i].longitude;
                            var alertid = response.data[i].alertid;
                            var msg = response.data[i].alertmsg;
                            if (alertid == aid) {
                                console.log(lat + "\t" + long + "\t" + alertid);
                                alertMapVm.latitude = lat;
                                alertMapVm.longitude = long;
                                alertMapVm.alertmsg = msg;
                                return response.data[i];
                            }

                        }

                    }, function (error) {
                        console.log(error);
                    });

            });
        }
    }
})();