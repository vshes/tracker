(function () {
    angular.module("app")
        .constant('CONFIG', {
            'API_HOST' :'http://localhost:8080/tracker/api/',
            'API_VEHICLE' :'http://localhost:8080/tracker/api/vehicles',
            'API_ALERT' :'http://localhost:8080/tracker/api/alerts/',
            'API_READINGS' :'http://localhost:8080/tracker/api/readings/',
            'API_VEHICLE_ID' :'http://localhost:8080/tracker/api/vehicle/',
            'IMAGE_HOME' : './src/images',
            'GOOGLE_KEY' : 'AIzaSyAEg5-KmpXA06XscGZyZs6wdh-QvIuJbWM'
        });
})();