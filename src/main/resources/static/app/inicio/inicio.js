'use strict';

angular.module('myApp.inicio', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/inicio', {
    templateUrl: 'inicio/inicio.html',
    controller: 'inicioCtrl'
  });
}])

.controller('inicioCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$location',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$location) {

$scope.url="img/Recurso 16.png";
$scope.count=0;
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
$scope.mousem=function(){

  if($scope.count  % 2 == 0 ){

  console.log("Soy par");
  $scope.url= "img/Recurso 16.png";
  }
  else{
  console.log("no soy par");
  $scope.url= "img/Recurso 17.png";
  }


$scope.count= $scope.count + 1;
}

}]);