'use strict';

angular.module('myApp.inicio', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/inicio', {
    templateUrl: 'inicio/inicio.html',
    controller: 'inicioCtrl'
  });
}])

.controller('inicioCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$location',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$location) {

$scope.a=function(){

    $localStorage.banderaCandidato=true;
    $localStorage.banderaContratista=false;
    $location.path("/login3");

}
$scope.b=function(){

    $localStorage.banderaContratista=true;
    $localStorage.banderaCandidato=false;
    $location.path("/login3");
}

}]);