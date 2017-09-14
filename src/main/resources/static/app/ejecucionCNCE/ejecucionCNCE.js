'use strict';

angular.module('myApp.ejecucionCNCE', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ejecucionCNCE', {
    templateUrl: 'ejecucionCNCE/ejecucionCNCE.html',
    controller: 'ejecucionCNCECtrl'
  });
}])

.controller('ejecucionCNCECtrl', ['$localStorage','$sessionStorage','$http','$scope','$rootScope','$mdDialog','contratosEnEjecucion','finalesDefinitivos','psC','psNC','peC','peNC','aproba',function($localStorage,$sessionStorage,$http,$scope,$rootScope,$mdDialog,contratosEnEjecucion,finalesDefinitivos,psC,psNC,peC,peNC,aproba) {

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
           $rootScope.user=client;
           $rootScope.idClient=client.id;
           $rootScope.listadoCSP=psC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoCEP=peC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCSP=psNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoNCEP=peNC.query({idFinalista:client.idFinalista,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});

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

         function DialogController($scope, $mdDialog, $rootScope, $http) {
           $scope.listadoCSP=$rootScope.listadoCSP;
           $scope.listadoCEP=$rootScope.listadoCEP;
           $scope.listadoNCSP=$rootScope.listadoNCSP
           $scope.listadoNCEP=$rootScope.listadoNCEP

           $scope.idClient=$rootScope.idClient
           var q=function(idContratante, idContratista){
                                 var url= "http://localhost:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
                                  var a;
                               a=$http.get(url).then(function(response) {
                                               $scope.o=response.data;
                                               return response.data;
                                            })
                     return a;
                  }
           q($localStorage.contratanteLogeado.idContratante,$rootScope.user.id);
            console.log($scope.o);


           $scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
           $scope.cancel = function() {
                       $mdDialog.cancel();
                     };
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
           $scope.aprobar=function(){
                 console.log($rootScope.user);
                 aproba.save({idContratista:$rootScope.user.id,idContratante:$localStorage.contratanteLogeado.idContratante})


           }
           $scope.estadis=function(){
                 $scope.banderaPrevio=true;
                  $scope.bandera=false;
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
            $scope.agregar=function(b,c,d){

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