'use strict';

angular.module('myApp.revisionDinamica', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/revisionDinamica', {
    templateUrl: 'revisionDinamica/revisionDinamica.html',
    controller: 'revisionDinamicaCtrl'
  });
}])

.controller('revisionDinamicaCtrl', [ '$mdDialog','$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos',function( $mdDialog,$scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos) {
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.options = [
                            { id: 1, name: 'Cumplidos' },
                            { id: 2, name: 'No Cumplidos ' },
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
            $scope.activo=true;
         }
         $scope.opciones=function(item){
            console.log(item);

         }
}]);