'use strict';

angular.module('myApp.ejecucionCNCE', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ejecucionCNCE', {
    templateUrl: 'ejecucionCNCE/ejecucionCNCE.html',
    controller: 'ejecucionCNCECtrl'
  });
}])

.controller('ejecucionCNCECtrl', ['$localStorage','$sessionStorage','$http','$scope','$rootScope','$mdDialog','contratosEnEjecucion','finalesDefinitivos','psC','psNC','esC','esNC','fsC','fsNC','peC','peNC','eeC','eeNC','feC','feNC','estadoPreviosSugeridos','estadoPreviosExtras','estadoEjecucionSugeridos','estadoEjecucionExtras','estadoFinalizacionSugeridos','estadoFinalizacionExtras',function($localStorage,$sessionStorage,$http,$scope,$rootScope,$mdDialog,contratosEnEjecucion,finalesDefinitivos,psC,psNC,esC,esNC,fsC,fsNC,peC,peNC,eeC,eeNC,feC,feNC,estadoPreviosSugeridos,estadoPreviosExtras,estadoEjecucionSugeridos,estadoEjecucionExtras,estadoFinalizacionstSugeridos,estadoFinalizacionExtras) {

        $scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        $scope.flag=false;
        $scope.seleccionados=[];
        $scope.propertyName = 'cumplidos';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
        $scope.add=function(){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
                $scope.flag=true;
                $rootScope.idCategoria=$scope.idCategoria
                $rootScope.idContrato=$scope.idContrato
                }


         $scope.showAlert = function(ev,client) {
           console.log(client);
           $rootScope.idClient=client.id;
           $rootScope.listadoCSP=psC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoCEP=peC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoESC=esC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoEEC=eeC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoFSC=fsC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoFEC=feC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});

           $mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
            controller: DialogController,
             //permite la comunicacion con el html que despliega el boton requisitos
             templateUrl: 'test/cumplidosEjecucion.html',
             parent: angular.element(document.body),
             targetEvent: ev,
             clickOutsideToClose:true,
                                 fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                               })


         }
         $scope.showAlert2 = function(ev,client) {
           console.log(client);
           $rootScope.idClient=client.id;
           $rootScope.listadoNCSP=psNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCEP=peNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCSE=esNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCEE=eeNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCSF=fsNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCEF=feNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});


                    $mdDialog.show({
                     //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController2,
                      //permite la comunicacion con el html que despliega el boton requisitos
                      templateUrl: 'test/noCumplidosEjecucion.html',
                      parent: angular.element(document.body),
                      targetEvent: ev,
                      clickOutsideToClose:true,
                      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                    })


                  }

          $scope.showAlert3 = function(ev,client) {
                                       $rootScope.listadoCSP=psC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoCEP=peC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoESC=esC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoEEC=eeC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoFSC=fsC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoFEC=feC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCSP=psNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCEP=peNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCSE=esNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCEE=eeNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCSF=fsNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                                       $rootScope.listadoNCEF=feNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
                            $mdDialog.show({
                              //Controlador del mensajes con operaciones definido en la parte de abajo
                               controller: DialogController3,
                               //permite la comunicacion con el html que despliega el boton requisitos
                               templateUrl: 'test/estadisticasEjecucion.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                               fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                            })


                           }

         function DialogController($scope, $mdDialog, $rootScope, $http) {
           $scope.listadoCSP=$rootScope.listadoCSP;
           $scope.listadoCEP=$rootScope.listadoCEP;
           $scope.listadoESC=$rootScope.listadoESC;
           $scope.listadoEEC=$rootScope.listadoEEC;
           $scope.listadoFSC=$rootScope.listadoFSC;
           $scope.listadoFEC=$rootScope.listadoFEC;
           $scope.idClient=$rootScope.idClient


           $scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
           $scope.cancel = function() {
                       $mdDialog.cancel();
                     };

         }
          function DialogController2($scope, $mdDialog, $rootScope) {
                        $scope.listadoNCSP=$rootScope.listadoNCSP
                        $scope.listadoNCEP=$rootScope.listadoNCEP
                        $scope.listadoNCSE=$rootScope.listadoNCSE
                        $scope.listadoNCEE=$rootScope.listadoNCEE
                        $scope.listadoNCSF=$rootScope.listadoNCSF
                        $scope.listadoNCEF=$rootScope.listadoNCEF
                        console.log($scope.listadoNCSE)


                   $scope.hide = function() {
                                $mdDialog.hide();
                              };
                              //funcion para cerral el mensaje
                    $scope.cancel = function() {
                                $mdDialog.cancel();
                              };

                  }
           function DialogController3($scope, $mdDialog, $rootScope, $http) {
                        $scope.listadoCSP=$rootScope.listadoCSP;
                        $scope.listadoCEP=$rootScope.listadoCEP;
                        $scope.listadoESC=$rootScope.listadoESC;
                        $scope.listadoEEC=$rootScope.listadoEEC;
                        $scope.listadoFSC=$rootScope.listadoFSC;
                                   $scope.listadoFEC=$rootScope.listadoFEC;
                        $scope.listadoNCSP=$rootScope.listadoNCSP
                                                $scope.listadoNCEP=$rootScope.listadoNCEP
                                                $scope.listadoNCSE=$rootScope.listadoNCSE
                                                $scope.listadoNCEE=$rootScope.listadoNCEE
                                                $scope.listadoNCSF=$rootScope.listadoNCSF
                                                $scope.listadoNCEF=$rootScope.listadoNCEF



                        $scope.options = [
                            { id: 1, name: 'Análisis Previos' },
                            { id: 2, name: 'Análisis Ejecución' },
                            { id: 3, name: 'Análisis Finalización' }
                          ];
                        $scope.banderaPrevio=false;
                        $scope.banderaEjecucion=false;
                        $scope.banderaFinalizacion=false;
                        $scope.bandera=false;
                        $scope.bandera2=false;
                        $scope.bandera3=false;

                        $scope.function1=function(){
                            console.log($scope.tipoEstadistica)
                            switch ($scope.tipoEstadistica) {
                                case 1:
                                    $scope.banderaPrevio=true;
                                    $scope.banderaEjecucion=false;
                                    $scope.banderaFinalizacion=false;
                                     $scope.bandera=false;
                                       $scope.bandera2=false;
                                      $scope.bandera3=false;
                                    break;
                                case 2:
                                    $scope.banderaPrevio=false;
                                    $scope.banderaEjecucion=true;
                                    $scope.banderaFinalizacion=false;
                                     $scope.bandera=false;
                                      $scope.bandera2=false;
                                       $scope.bandera3=false;

                                    break;
                                case 3:
                                   $scope.banderaPrevio=false;
                                   $scope.banderaEjecucion=false;
                                   $scope.banderaFinalizacion=true;
                                   $scope.bandera=false;
                                   $scope.bandera2=false;
                                   $scope.bandera3=false;

                                   break;

                            }
                            }
                            $scope.hideGrafico=function(a){
                                  switch(a){
                                    case 1:
                                        $scope.bandera=false;
                                        break;
                                    case 2:
                                        $scope.bandera2=false;
                                        break;

                                    case 3:
                                        $scope.bandera3=false;
                                        break;


                                  }


                            }

                                 $scope.hide = function() {
                                              $mdDialog.hide();
                                            };
                                            //funcion para cerral el mensaje
                                  $scope.cancel = function() {
                                              $mdDialog.cancel();
                                            };

                                   $scope.agregar=function(a,b,c,d){

                                        switch(d){
                                             case 1:
                                                $scope.bandera=true;
                                                break;
                                             case 2:
                                                $scope.bandera2=true;
                                                break;

                                             case 3:
                                                 $scope.bandera3=true;
                                                 break;

                                                                  }
                                             $scope.myChartObject = {};
                                             $scope.myChartObject.type = "ColumnChart";

                                                                                           $scope.myChartObject.data = {"cols": [
                                                                                               {id: "t", label: "Topping", type: "string"},
                                                                                               {id: "s", label: "Tipo Analisis", type: "number"}
                                                                                           ], "rows": [
                                                                                               {c: [
                                                                                                   {v: "Aplicados"},
                                                                                                   {v: a},
                                                                                               ]},
                                                                                               {c: [
                                                                                                   {v: "Cumplidos"},
                                                                                                   {v: b},
                                                                                               ]},
                                                                                               {c: [
                                                                                                   {v: "No Cumplidos"},
                                                                                                   {v: c},
                                                                                               ]}
                                                                                           ]};

                                                                                           $scope.myChartObject.options = {
                                                                                               'title': 'Estadisticas Requisitos Estaticos'
                                                                                           };



                                   }





                                }


}]);