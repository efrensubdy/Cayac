'use strict';

angular.module('myApp.notificaciones', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/notificaciones', {
    templateUrl: 'notificaciones/notificaciones.html',
    controller: 'notificacionesCtrl'
  });
}])

.controller('notificacionesCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','notifacionSinSoporte',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,notifacionSinSoporte) {

 $scope.notificaciones=[
    {id:1,nombre:'CONTRATISTAS SIN ACTIVDADES REGISTRADAS'},
    {id:2,nombre:'CONTRATISTAS CON ACTIVIDADES PERO SIN SOPORTE'},

  ];

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

$scope.add = function(notificacion,mes){
    console.log(mes);
    console.log(notificacion)

}


}]);