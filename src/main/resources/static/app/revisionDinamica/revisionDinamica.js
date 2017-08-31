'use strict';

angular.module('myApp.revisionDinamica', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/revisionDinamica', {
    templateUrl: 'revisionDinamica/revisionDinamica.html',
    controller: 'revisionDinamicaCtrl'
  });
}])

.controller('revisionDinamicaCtrl', [ '$mdDialog','$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','cumpDinaPrev','noCumpDinaPrev','cumpDinaPrevMat','historialPreviosDinamicos','historialDeMatrices',function( $mdDialog,$scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,cumpDinaPrev,noCumpDinaPrev,cumpDinaPrevMat,historialPreviosDinamicos,historialDeMatrices) {
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.options = [
                            { id: 1, name: 'Cumplidos' },
                            { id: 2, name: 'No Cumplidos' },
                            {id :3,name: 'Estadistica' },

                          ];
$scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };

         $scope.add=function(){

                        $scope.listado=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato});

                        $scope.flag=true;

         }
         $scope.activated=function(item){

            $rootScope.contratistaActual=item;
            $scope.activo=true;
         }
         $scope.activated2=function(item){
            console.log(item);
            if (item.apodo=="MATRIZ DE PELIGROS "){
                console.log("entre a matriz de peligros")
                 $scope.historialmatriz=historialDeMatrices.query({idRequisito:item.idRequisito,idFinalista:item.idFinalista})
                 $mdDialog.show({
                                          //Controlador del mensajes con operaciones definido en la parte de abajo
                                          controller: revisionDinamicaCtrl,
                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                          templateUrl: 'test/historicoMatrices.html',
                                          parent: angular.element(document.body),
                                          targetEvent: ev,
                                          clickOutsideToClose:true,
                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                          })
            }
            else{

            }

         }
         $scope.opciones=function(item){

            switch(item.name){

                case "Cumplidos":
                    console.log("ccccc");
                    $scope.banderaCumplidos=true;
                    $scope.banderaNoCumplidos=false;
                    $scope.tableCumplidos=cumpDinaPrev.query({idCategoria:$rootScope.contratistaActual.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante,idFinalista:$rootScope.contratistaActual.idFinalista})
                    $scope.tableCumplidosMatriz=cumpDinaPrevMat.query({idCategoria:$rootScope.contratistaActual.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante,idFinalista:$rootScope.contratistaActual.idFinalista})
                    break;
                case "No Cumplidos":
                    $scope.banderaNoCumplidos=true;
                    $scope.banderaCumplidos=false;
                    $scope.tableNoCumplidos=noCumpDinaPrev.query({idCategoria:$rootScope.contratistaActual.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante,idFinalista:$rootScope.contratistaActual.idFinalista})
                    break;
                case "Estadistica":
                    $scope.banderaCumplidos=false;
                    break;
            }

         }
}]);