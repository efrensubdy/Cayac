'use strict';

angular.module('myApp.notificaciones', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/notificaciones', {
    templateUrl: 'notificaciones/notificaciones.html',
    controller: 'notificacionesCtrl'
  });
}])

.controller('notificacionesCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','notifacionSinSoporte','mensajeContratista','notifacionSinRegistro','sRIndi',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,notifacionSinSoporte,mensajeContratista,notifacionSinRegistro,sRIndi) {
if ("undefined" === typeof $localStorage.userLogeado && "undefined" === typeof $localStorage.contratanteLogeado){
         $mdDialog.show(
                          $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Error')
                            .textContent('Usted no ha iniciado sesión.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('ok!')
                            .targetEvent()
                    );
        $location.path("inicio");


}
 $scope.notificaciones=[
    {id:1,nombre:'CONTRATISTAS SIN ACTIVDADES REGISTRADAS'},
    {id:2,nombre:'CONTRATISTAS CON ACTIVIDADES PERO SIN SOPORTE'},
    {id:3,nombre:'CONTRATISTAS SIN INDICADORES REGISTRADOS'}

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
  $scope.years=[
     { id: 10, name: 2009},
     { id: 11, name: 2010},
     { id: 12, name: 2011},
     { id: 13, name: 2012},
     { id: 14, name: 2013},
     { id: 15, name: 2014},
     { id: 16, name: 2015},
     { id: 17, name: 2016},
     { id: 18, name: 2017},
     { id: 19, name: 2018},
     { id: 20, name: 2019},
     { id: 21, name: 2020},
     { id: 22, name: 2021},
     { id: 23, name: 2022},
     { id: 24, name: 2023},
     { id: 25, name: 2024},
     { id: 26, name: 2026},
                ];
$scope.banderaSinSoporte=false;
$scope.ocultarTodo=function(){
    $scope.banderaSinSoporte=false;

}
$scope.add = function(notificacion,mes,year){

    switch(notificacion.id){
        case 1:
        console.log("Sin actividades")
        $scope.banderaSinSoporte=true;
        $scope.noti=notifacionSinRegistro.query({idContratante:$localStorage.contratanteLogeado.idContratante,mes:mes.name,year:year.name})
        break;
        case 2:
        console.log("sin soporte")
        $scope.banderaSinSoporte=true;
        $scope.noti=notifacionSinSoporte.query({idContratante:$localStorage.contratanteLogeado.idContratante,mes:mes.name,year:year.name})
        break;
        case 3:
        $scope.banderaSinSoporte=true;
         $scope.noti=sRIndi.query({idContratante:$localStorage.contratanteLogeado.idContratante,mes:mes.name,year:year.name})


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
    $scope.envio2=function(item){

            var mensaje={mensaje:item,idContratante:$localStorage.contratanteLogeado.idContratante,idContratista:$scope.client.idContratista}
            mensajeContratista.save(mensaje);
            $scope.textArea= '';
            $scope.mensaje=false;

        }


}

}]);