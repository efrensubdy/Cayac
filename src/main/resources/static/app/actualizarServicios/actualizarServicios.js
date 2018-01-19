'use strict';

angular.module('myApp.actualizarServicios', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/actualizarServicios', {
    templateUrl: 'actualizarServicios/actualizarServicios.html',
    controller: 'actualizarServiciosCtrl'
  });
}])

.controller('actualizarServiciosCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$route','example','exam','serviciosAContrar','actualizarServicio',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$route,example,exam,serviciosAContrar,actualizarServicio) {


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
$scope.flag = false;
 $scope.listado=serviciosAContrar.query({idContratante:$localStorage.contratanteLogeado.idContratante});
 $scope.closeModel= function(){
             document.getElementById('id01').style.display='none';
 }
 $scope.add = function(contrato){
    $scope.contratoSelec = contrato
    $scope.flag =true;
 }
 $scope.ocultarTodo =function(){
    $scope.flag = false;

 }
 $scope.showAlert=function(ev,client){
             $rootScope.client=client
             $mdDialog.show({
                   //Controlador del mensajes con operaciones definido en la parte de abajo
                   controller: DialogController2,
                    //permite la comunicacion con el html que despliega el boton requisitos
                     templateUrl: 'test/actualiServicio.html',
                     parent: angular.element(document.body),
                     targetEvent: ev,
                      clickOutsideToClose:true,
                      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                 })

 }
function Servicio (){


  }

   function DialogController2($scope, $mdDialog, $rootScope){
              $scope.client= $rootScope.client;
              $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
               $scope.cancel = function() {
                           $mdDialog.cancel();
                         };

              $scope.add =function (ev,nombre,tipo,client){

                var servicio = new Servicio();
                servicio.id =client.id;
                servicio.idContratante = client.idContratante;
                if (nombre == client.nombre || "undefined" == typeof nombre ){

                      servicio.nombre =client.nombre
                 }
                 else{

                     servicio.nombre=nombre
                 }
                 if (tipo == client.tipo || "undefined" == typeof tipo ){

                       servicio.tipo =client.tipo
                  }
                  else{

                      servicio.tipo=tipo
                  }
                  actualizarServicio.save(servicio);
                  $mdDialog.show(
                     $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Exito !!')
                    .textContent('Puede revisar nuevamente o consultar sus Servicios.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('ok!')
                    .targetEvent(ev)
                                            );

                    $route.reload();

              }


    }

}]);