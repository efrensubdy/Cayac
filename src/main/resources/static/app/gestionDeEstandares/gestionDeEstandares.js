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
$scope.ocultarTodo=function(){
    $scope.flag=false
    $scope.bandera2=false

}

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
$scope.showAlert2=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/graficoDeEstandar.html',
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
  function DialogController($scope, $mdDialog, $rootScope){
              $scope.client= $rootScope.client;
               $scope.chartWidth = 500;
               $scope.chartHeight = 320;
              console.log($scope.client);

              $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
               $scope.cancel = function() {
                           $mdDialog.cancel();
                         };

               $scope.myChartObject = {};
                               $scope.myChartObject.type = "ColumnChart";

                               $scope.myChartObject.data = {"cols": [
                                                                          {id: "t", label: "Topping", type: "string"},
                                                                          {id: "s", label: "Tipo Analisis", type: "number"}
                                                                      ], "rows": [
                                                                          {c: [
                                                                              {v: "1. RECURSOS (10%)"},
                                                                              {v: $scope.client.recursos +$scope.client.capacitacion },
                                                                          ]},
                                                                          {c: [
                                                                              {v: "2. GESTIÓN INTEGRAL DEL SISTEMA DE LA SEGURIDAD Y SALUD EN EL TRABAJO (15%)"},
                                                                              {v: $scope.client.politica + $scope.client.objetivos + $scope.client.evaInicial + $scope.client.planAnual + $scope.client.documen + $scope.client.cuentas + $scope.client.normatividad + $scope.client.mecanismos + $scope.client.adquisiones + $scope.client.contrataciones + $scope.client.cambios},
                                                                          ]}
                                                                      ]};

                                $scope.myChartObject.options = {
                                                          'title': ' ITEM I PLANEAR ANÁLISIS'
                                                      };



                $scope.myChartObject2 = {};
                           $scope.myChartObject2.type = "ColumnChart";

                           $scope.myChartObject2.data = {"cols": [
                                          {id: "t", label: "Topping", type: "string"},
                                          {id: "s", label: "Tipo Analisis", type: "number"}
                                      ], "rows": [
                                          {c: [
                                              {v: "3. GESTION DE LA SALUD (20%)"},
                                              {v: $scope.client.condiciones + $scope.client.registro + $scope.client.vigilancia},
                                          ]},
                                          {c: [
                                              {v: "4. GESTION DE PELIGROS Y RIESGOS (30%)"},
                                              {v: $scope.client.peligros + $scope.client.prevencion},
                                          ]},
                                          {c: [
                                              {v: "5. GESTION DE AMENAZAS (10%)"},
                                              {v: $scope.client.planPrevencion},
                                          ]},
                                      ]};

                            $scope.myChartObject2.options = {
                                                      'title': 'ITEM II HACER ANÁLISIS'
                                                  };


               $scope.myChartObject3 = {};
                      $scope.myChartObject3.type = "ColumnChart";

                      $scope.myChartObject3.data = {"cols": [
                                     {id: "t", label: "Topping", type: "string"},
                                     {id: "s", label: "Tipo Analisis", type: "number"}
                                 ], "rows": [
                                     {c: [
                                         {v: "6. VERIFICACIÓN DEL SISTEMA DE GESTION EN SEGURIDAD Y SALUD EN EL TRABAJO (5%)"},
                                         {v: $scope.client.gestion},
                                     ]},
                                     {c: [
                                         {v: "7. MEJORAMIENTO (10%)"},
                                         {v: $scope.client.accionesPreven},
                                     ]}

                                 ]};

                       $scope.myChartObject3.options = {
                                                 'title': 'ITEM III VERIFICAR Y IV ACTUAR  ANÁLISIS'
                                             };






                    $scope.myChartObject4 = {};
                                          $scope.myChartObject4.type = "ColumnChart";

                                          $scope.myChartObject4.data = {"cols": [
                                                         {id: "t", label: "Topping", type: "string"},
                                                         {id: "s", label: "Tipo Analisis", type: "number"}
                                                     ], "rows": [
                                                         {c: [
                                                               {v: "I. PLANEAR"},
                                                               {v: $scope.client.recursos + $scope.client.capacitacion + $scope.client.politica + $scope.client.objetivos + $scope.client.evaInicial+ $scope.client.planAnual + $scope.client.documen + $scope.client.cuentas + $scope.client.normatividad + $scope.client.mecanismos + $scope.client.adquisiones + $scope.client.contrataciones + $scope.client.cambios},
                                                           ]},
                                                         {c: [
                                                              {v: "II. HACER "},
                                                              {v: $scope.client.condiciones + $scope.client.registro + $scope.client.vigilancia + $scope.client.peligros + $scope.client.prevencion + $scope.client.planPrevencion},
                                                          ]},
                                                         {c: [
                                                             {v: "III.VERIFICAR"},
                                                             {v: $scope.client.gestion},
                                                         ]},
                                                         {c: [
                                                             {v: "IV. ACTUAR"},
                                                             {v: $scope.client.accionesPreven},
                                                         ]}

                                                     ]};

                                           $scope.myChartObject4.options = {
                                                                     'title': 'ITEM V TOTALES  ANÁLISIS'
                                                                 };


    }



}]);