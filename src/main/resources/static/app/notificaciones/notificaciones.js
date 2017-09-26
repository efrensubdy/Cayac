'use strict';

angular.module('myApp.notificaciones', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/notificaciones', {
    templateUrl: 'notificaciones/notificaciones.html',
    controller: 'notificacionesCtrl'
  });
}])

.controller('notificacionesCtrl', ['$mdDialog','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','notifacionSinSoporte','mensajeContratista','notifacionSinRegistro',function($mdDialog,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,notifacionSinSoporte,mensajeContratista,notifacionSinRegistro) {

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
$scope.banderaSinSoporte=false;
$scope.add = function(notificacion,mes){

    switch(notificacion.id){
        case 1:
        console.log("Sin actividades")
        $scope.banderaSinSoporte=true;
        $scope.noti=notifacionSinRegistro.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        break;
        case 2:
        console.log("sin soporte")
        $scope.banderaSinSoporte=true;
        $scope.noti=notifacionSinSoporte.query({idContratante:$localStorage.contratanteLogeado.idContratante,mes:mes.name})
        break;


    }

}
$scope.showAlert=function(ev,client){
     $rootScope.client=client;
     $mdDialog.show({
                 //Controlador del mensajes con operaciones definido en la parte de abajo
                 controller: DialogController,
                  //permite la comunicacion con el html que despliega el boton requisitos
                  templateUrl: 'test/mensajeDeContratista.html',
                  parent: angular.element(document.body),
                  targetEvent: ev,
                  clickOutsideToClose:true,
                  fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
     })




}

function DialogController($scope, $mdDialog, $rootScope, $http) {
    $scope.client=$rootScope.client
    $scope.mensaje=true;
    $scope.show=function(){
        $scope.mensaje=true;
    }
    $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
               $scope.cancel = function() {
                           $mdDialog.cancel();
                         };
    $scope.envio=function(item){

        var mensaje={mensaje:item,idContratante:$localStorage.contratanteLogeado.idContratante,idContratista:$scope.client.id}
        mensajeContratista.save(mensaje);
        $scope.textArea= '';
        $scope.mensaje=false;

    }


}

}]);