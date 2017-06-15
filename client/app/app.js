(function(){
    angular.module('app',['ngRoute','ngMap','ui.bootstrap']);
    console.log("Starting App !")

    angular.module('app')
        .config(autoTrackerConfig);

    autoTrackerConfig.$inject =['$routeProvider'];

    function autoTrackerConfig($routeProvider) {

        $routeProvider
            .when('/vehicles', {
                templateUrl:'./app/views/vehicle.list.tmpl.html',
                controller:'vehicleController',
                controllerAs:'vehicleVm'
            })
            .when('/vehicle/:id',{
                templateUrl:'./app/views/vehicle.detail.tmpl.html',
                controller:'vehicleDetailController',
                controllerAs:'vehicleDetVm'
            })
            .when('/vehicle/alert/:id',{
                templateUrl:'./app/views/vehicle.attributes.tmpl.html',
                controller:'vehicleAttributesController',
                controllerAs:'vehicleAttVm'
            })
            .when('/vehicle/reading/:id',{
                templateUrl:'./app/views/vehicle.attributes.tmpl.html',
                controller:'vehicleAttributesController',
                controllerAs:'vehicleAttVm'
            })
            .when('/alerts',{
                templateUrl:'./app/views/alert.all.tmpl.html',
                controller:'alertController',
                controllerAs:'alertVm'
            })
            .when('/alerts/map/:id',{
                templateUrl:'./app/views/alert.map.tmpl.html',
                controller:'alertMapController',
                controllerAs:'alertMapVm'
            })
            .when('/alerts/:id',{
                templateUrl:'./app/views/alert.vid.tmpl.html',
                controller:'alertVidController',
                controllerAs:'alertVidVm'
            })
            .when('/readings',{
                templateUrl:'./app/views/readings.list.tmpl.html',
                controller:'readingsController',
                controllerAs:'readingVm'
            })
            .when('/readings/:id',{
                templateUrl:'./app/views/readings.vin.tmpl.html',
                controller:'readingsVinController',
                controllerAs:'readingVinVm'
            })
            .when('/add-vehicle/',{

            })
            .when('/home/',{
                templateUrl:'./app/views/home.tmpl.html',
                controller:'homeController',
                controllerAs:'homeVm',
            })
            .otherwise({
                    redirectTo:'/home'

            });

    }
})();