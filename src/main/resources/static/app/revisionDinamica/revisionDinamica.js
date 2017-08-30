'use strict';

angular.module('myApp.revisionDinamica', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/revisionDinamica', {
    templateUrl: 'revisionDinamica/revisionDinamica.html',
    controller: 'revisionDinamicaCtrl'
  });
}])

.controller('revisionDinamicaCtrl', [ '$mdDialog','$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','cumpDinaPrev','noCumpDinaPrev',function( $mdDialog,$scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,cumpDinaPrev,noCumpDinaPrev) {
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
            console.log(item);
            $rootScope.contratistaActual=item;
            $scope.activo=true;
         }
         $scope.opciones=function(item){
            console.log(item);
            switch(item.name){

                case "Cumplidos":
                    console.log("ccccc");
                    $scope.banderaCumplidos=true;
                    $scope.banderaNoCumplidos=false;
                    $scope.tableCumplidos=cumpDinaPrev.query({idCategoria:$rootScope.contratistaActual.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante,idFinalista:$rootScope.contratistaActual.idFinalista})
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