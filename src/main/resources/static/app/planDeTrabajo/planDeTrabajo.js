'use strict';

angular.module('myApp.planDeTrabajo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/planDeTrabajo', {
    templateUrl: 'planDeTrabajo/planDeTrabajo.html',
    controller: 'planDeTrabajoCtrl'
  });
}])

.controller('planDeTrabajoCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','plandeTrabajo',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,plandeTrabajo) {


$scope.meses=[
 { id: 1, name: 'ENERO'},
 { id: 2, name: 'FEBRERO'},
 { id: 3, name: 'MARZO'},
 { id: 4, name: 'ABRIL'},
 { id: 5, name: 'MAYO'},
 { id: 6, name: 'JUNIO'},
 { id: 7, name: 'JULIO'},
 { id: 8, name: 'AGOSTO'},
 { id: 9, name: 'SEPTIEMBRE'},
 { id: 10, name: 'OCTUBRE'},
 { id: 11, name: 'NOVIEMBRE'},
 { id: 12, name: 'DICIEMBRE'},

            ];
  $scope.opciones=[
    {id:1,nombre:'REGISTRAR ACTIVIDADES'},
    {id:2,nombre:'SUBIR SOPORTES'},
    {id:3,nombre:'CONSULTAR ACTIVIDADES'},


  ];
  $scope.simple=function(){
        $scope.banderaActividad=true;

  }
  $scope.op=function(item){

    $scope.bandera1=true;
  }
  $scope.add=function(ev,fechaInicio,fechaFin,nombre,mes){
    console.log(fechaInicio);
    console.log(fechaFin);
    console.log(nombre);
    console.log(mes);
    var plan={"nombre":nombre,"mes":mes,"fechaInicio":fechaInicio,"fechaFin":fechaFin};
    plandeTrabajo.save(plan);

  }

}]);