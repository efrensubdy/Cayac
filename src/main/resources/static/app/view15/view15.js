'use strict';

angular.module('myApp.view15', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view15', {
    templateUrl: 'view15/view15.html',
    controller: 'View15Ctrl'
  });
}])

.controller('View15Ctrl', ['$localStorage','$sessionStorage','$scope','$rootScope','contratos','fechaContrato','$mdDialog','$http',function($localStorage,$sessionStorage,$scope,$rootScope,contratos,fechaContrato,$mdDialog,$http) {


$scope.fecha={}
$scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante})
$scope.nombreClick=false;
$scope.permisoTable=false;
$scope.permisoFecha=false;
var d;
$scope.function1=function(){
    if($scope.tipoContrato=="nombre"){
        $scope.nombreClick=true;
        $scope.fechaClick=false
    }
    else if($scope.tipoContrato=="fecha") {
        $scope.nombreClick=false;
        $scope.permisoTable=false;
        $scope.fechaClick=true;
    }


}

$scope.detalle=function(item){
    detalle(item);
}
$scope.buscar=function(a,b){
$scope.listado= fechaContrato.query({fechaInicio:a,fechaFin:b,idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.permisoFecha=true;

}


 var detalle=function(item){
    console.log(item);
    var url = "http://localhost:8080/app/contratos/id/" + item;
          $http.get(url).then(function(response) {
                   d=response.data;
                   console.log(response.data)
                   return response.data;
                }).then(p);
}
var p=function(){
        console.log(d);
        $scope.e=d;
        $scope.permisoTable=true;

     }

}]);