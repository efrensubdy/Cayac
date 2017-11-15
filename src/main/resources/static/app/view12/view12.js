'use strict';

angular.module('myApp.view12', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view12', {
    templateUrl: 'view12/view12.html',
    controller: 'View12Ctrl'
  });
}])

.controller('View12Ctrl', ['$location','$localStorage','$sessionStorage','$mdDialog','$rootScope','$scope','finalesDefinitivos','contratos','contratosEnEjecucion',function($location,$localStorage,$sessionStorage,$mdDialog,$rootScope,$scope,finalesDefinitivos,contratos,contratosEnEjecucion) {
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
$scope.ocultarTodo=function(){
    $scope.flag=false;
}
 $scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        $scope.seleccionados=[];
        $scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };

         $scope.add=function(ev,contrato){
                        if("undefined" !== typeof contrato){
                        $scope.listado=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato.idContrato});
                        $scope.flag=true;
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

     $scope.showAlert2=function(ev,client){
                $rootScope.client=client
                console.log(client);
                $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController2,
                       //permite la comunicacion con el html que despliega el boton requisitos
                        templateUrl: 'test/test1.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                         clickOutsideToClose:true,
                         fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                    })

              }


      function DialogController2($scope, $mdDialog, $rootScope){
                $scope.client= $rootScope.client;
                switch ($scope.client.duracionContrato){
                    case 0 :
                        $scope.duracion= 'MENOS DE UN MES';
                    break;
                    case 1 :
                         $scope.duracion= 'MAS DE TRES MESES';
                      break;
                    case 2 :
                         $scope.duracion= 'MAS DE 6 MESES';
                     break;
                    case 3 :
                         $scope.duracion= 'MAS DE UN AÑO';
                     break;



                }

                $scope.hide = function() {
                             $mdDialog.hide();
                           };
                           //funcion para cerral el mensaje
                 $scope.cancel = function() {
                             $mdDialog.cancel();
                           };




               }



}]);