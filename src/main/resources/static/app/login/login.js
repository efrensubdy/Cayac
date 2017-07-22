'use strict';

angular.module('myApp.login', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'loginCtrl'
  });
}])

.controller('loginCtrl',['$rootScope','$scope', '$http','$location', function($rootScope,$scope,$http,$location)  {

var authenticate = function (credentials, callback) {

                var headers = credentials ? {authorization: "Basic "
                            + btoa(credentials.username + ":" + credentials.password)
                } : {};

                $http.get('user', {headers: headers}).then(successCallback, errorCallback);

                function successCallback(data){
                    if (data.data.name) {
                         $rootScope.authenticated = true;
                        } else {
                         $rootScope.authenticated = false;
                        }
                    callback && callback();
                 }
                 function errorCallback(error){
                     $rootScope.authenticated = false;
                        callback && callback();
                 }



            };

            authenticate();
            $scope.credentials = {};
            $scope.login = function () {
                authenticate($scope.credentials, function () {
                    if ($rootScope.authenticated) {
                        $location.path("/view1");
                        $scope.error = false;
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                    }
                });
            };



}]);