'use strict';

angular.module('myApp.gestionDeAccidentes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeAccidentes', {
    templateUrl: 'gestionDeAccidentes/gestionDeAccidentes.html',
    controller: 'gestionDeAccidentesCtrl'
  });
}])

.controller('gestionDeAccidentesCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','finalesDefinitivos','contratosEnEjecucion','accPorContra','$mdDialog',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,finalesDefinitivos,contratosEnEjecucion,accPorContra,$mdDialog) {
$scope.flag=false
$scope.bandera3=false
$scope.ocultarTodo=function(){
    $scope.flag=false;
    $scope.bandera3=false;
}
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.add=function(ev,contrato){
                if("undefined" !== typeof contrato){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
                $scope.flag=true;
                $scope.bandera3=false;
                }
                else{
                    $mdDialog.show(
                                            $mdDialog.alert()
                                              .parent(angular.element(document.querySelector('#popupContainer')))
                                              .clickOutsideToClose(true)
                                              .title('Hubo un error')
                                              .textContent('alguno de los datos se ecuentra sin escoger.')
                                              .ariaLabel('Alert Dialog Demo')
                                              .ok('intente de nuevo!')
                                              .targetEvent(ev)
                                        );

                }
                }

$scope.traerAccidentes=function(client){
$rootScope.client=client;
$scope.accidentes=accPorContra.query({idContratista:client.id,idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.bandera3=true;



}
$scope.showAlert=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleDeAccidente.html',
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