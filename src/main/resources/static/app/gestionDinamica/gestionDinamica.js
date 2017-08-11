'use strict';

angular.module('myApp.gestionDinamica', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDinamica', {
    templateUrl: 'gestionDinamica/gestionDinamica.html',
    controller: 'gestionDinamicaCtrl'
  });
}])

.controller('gestionDinamicaCtrl', ['$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog', 'estadoDinamicosPreviosSugeridos','estadoDinamicosPreviosExtras', 'estadoDinamicosEjecucionSugeridos', 'estadoDinamicosEjecucionExtras', 'estadoDinamicosFinalizacionSugeridos', 'estadoDinamicosFinalizacionExtras',function($scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog, estadoDinamicosPreviosSugeridos,estadoDinamicosPreviosExtras, estadoDinamicosEjecucionSugeridos, estadoDinamicosEjecucionExtras, estadoDinamicosFinalizacionSugeridos, estadoDinamicosFinalizacionExtras) {

 $scope.options = [
            { id: 1, name: 'SOPORTES PREVIOS AL INICIO DEL CONTRATO' },
            { id: 2, name: 'SOPORTES DURANTE LA EJECUCIÓN DEL CONTRATO' },
            { id: 3, name: 'SOPORTES FINALIZACIÓN DEL CONTRATO' }
           ];
$scope.banderaPrevio=false;
$scope.banderaEjecucion=false;
$scope.banderaFinalizacion=false;
$scope.function1=function(){

                   switch ($scope.tipoCiclo) {
                       case 1:
                           $scope.banderaPrevio=true;
                           $scope.banderaEjecucion=false;
                           $scope.banderaFinalizacion=false;

                           $scope.previosSugeridos=estadoDinamicosPreviosSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
                           $scope.previosExtras=estadoDinamicosPreviosExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});

                           break;
                       case 2:
                           $scope.banderaPrevio=false;
                           $scope.banderaEjecucion=true;
                           $scope.banderaFinalizacion=false;
                           $scope.ejecucionSugeridos=estadoDinamicosEjecucionSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
                           $scope.ejecucionExtras=estadoDinamicosEjecucionExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});

                           break;
                       case 3:
                          $scope.banderaPrevio=false;
                          $scope.banderaEjecucion=false;
                          $scope.banderaFinalizacion=true;
                          $scope.finalizacionSugeridos=estadoDinamicosFinalizacionSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
                          $scope.finalizacionExtras=estadoDinamicosFinalizacionExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});



                          break;

                   }
           }
   $scope.gestionar=function(item,ev){

        console.log(item);


   }
}]);