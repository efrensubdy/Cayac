'use strict';

angular.module('myApp.indicadores', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/indicadores', {
    templateUrl: 'indicadores/indicadores.html',
    controller: 'indicadoresCtrl'
  });
}])

.controller('indicadoresCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage) {
$scope.name=$localStorage.userLogeado.nombreEmpresa;
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
$scope.add = function(contraName,responsable,departamento,mes,actividad,severidad,frecuencia,mortalidad,prevalencia,icidencia,ausentismo){
    console.log("Se pudo");


}



}]);