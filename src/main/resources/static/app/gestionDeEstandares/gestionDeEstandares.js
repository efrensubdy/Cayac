'use strict';

angular.module('myApp.gestionDeEstandares', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeEstandares', {
    templateUrl: 'gestionDeEstandares/gestionDeEstandares.html',
    controller: 'gestionDeEstandaresCtrl'
  });
}])

.controller('gestionDeEstandaresCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','contratosEnEjecucion','finalesDefinitivos','estContr',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,contratosEnEjecucion,finalesDefinitivos,estContr) {

$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false
$scope.bandera2=false
$scope.add=function(){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
                $scope.flag=true;
                }
$scope.resul=function(){
    $scope.flag=false;
}
$scope.traerEstandares=function(item){

$scope.listadoEstandaresMinimos=estContr.query({idContratista:item.id,idContratante:$localStorage.contratanteLogeado.idContratante})
$scope.bandera2=true
}
$scope.showAlert=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleDeEstandar.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                     clickOutsideToClose:true,
                     fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })

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




  }



}]);