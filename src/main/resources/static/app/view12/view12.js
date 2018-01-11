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
$scope.arls =[

                  { id: 1, name: "Sura"},
                  { id: 2, name: "Bolivar"},
                  { id: 3, name: "Equidad"},
                  { id: 4, name: "Aurora"},
                  { id: 5, name: "Colpatria"},
                  { id: 6, name: "Positiva"},
                  { id: 7, name: "Liberty"},
                  { id: 8, name: "Mapfre"},
                  { id: 9, name: "Colmena"},
                  { id: 10, name: "Alfa"},

              ];

$scope.departamentos =[
                    { id: 1, name: "Bogotá D.C"},
                    { id: 2, name: "La Guajira"},
                    { id: 3, name: "Magdalena"},
                    { id: 4, name: "Guaviare"},
                    { id: 5, name: "Boyaca"},
                    { id: 6, name: "Valle del Cauca"},
                    { id: 7, name: "Amazonas"},
                    { id: 8, name: "Meta"},
                    { id: 9, name: "Antioquia"},
                    { id: 10, name: "Cauca"},
                    { id: 11, name: "Caldas"},
                    { id: 12, name: "Caqueta"},
                    { id: 13, name: "Casanare"},
                    { id: 14, name: "Cesar"},
                    { id: 15, name: "Choco"},
                    { id: 16, name: "Cordoba"},
                    { id: 17, name: "Guanía"},
                    { id: 18, name: "Huila"},
                    { id: 19, name: "Nariño"},
                    { id: 20, name: "Norte de Santander"},
                    { id: 21, name: "Putumayo"},
                    { id: 22, name: "Quindio"},
                    { id: 23, name: "Risaralda"},
                    { id: 24, name: "San Andrés"},
                    { id: 25, name: "Santander"},
                    { id: 26, name: "Sucre"},
                    { id: 27, name: "Tolima"},
                    { id: 28, name: "Vaupes"},
                    { id: 29, name: "Vichada"},
                    { id: 30, name: "Bolivar"},



                    ];
$scope.loadContratos=function(){
     $scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
     },function(err){
        $scope.bandera01 = true;
        document.getElementById('id01').style.display='block';
     });
}
$scope.ocultarTodo=function(){
    $scope.flag=false;

}
 $scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
 },function(err){
    $scope.bandera01 = true;
     document.getElementById('id01').style.display='block';

 })
        $scope.seleccionados=[];
        $scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };

         $scope.add=function(ev,contrato){
                        if("undefined" !== typeof contrato){
                        $scope.listado2=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato.idContrato},function(){
                        },function(err){
                            $scope.bandera01 = true;
                            document.getElementById('id01').style.display='block';

                        });
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
                $scope.arl=$scope.arls[client.arl-1]
                $scope.departamento=$scope.departamentos[client.departamento-1];
                $rootScope.client=client
                $rootScope.arl=$scope.arl;
                $rootScope.departamento=$scope.departamento;

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
                $scope.arl=$rootScope.arl;
                $scope.departamento=$rootScope.departamento
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