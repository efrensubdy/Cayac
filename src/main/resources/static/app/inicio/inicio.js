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
$scope.url2="img/Recurso 18.png";
$scope.url3="img/Recurso 20.png"
$scope.count=0;
$scope.count2=0;
$scope.count3=0;
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

  $scope.url= "img/Recurso 16.png";
  }
  else{

  $scope.url= "img/Recurso 17.png";
  }
  $scope.count= $scope.count + 1;
  }

$scope.mousem2=function(){

  if($scope.count2  % 2 == 0 ){


  $scope.url2= "img/Recurso 18.png";
  }
  else{

  $scope.url2= "img/Recurso 19.png";
  }

$scope.count2= $scope.count2 + 1;
}
$scope.mousem3=function(){

  if($scope.count3  % 2 == 0 ){

  $scope.url3= "img/Recurso 20.png";
  }
  else{

  $scope.url3= "img/Recurso 21.png";
  }

$scope.count3= $scope.count3 + 1;
}


}]);