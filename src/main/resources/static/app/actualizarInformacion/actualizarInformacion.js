'use strict';

angular.module('myApp.actualizarInformacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/actualizarInformacion', {
    templateUrl: 'actualizarInformacion/actualizarInformacion.html',
    controller: 'actualizarInformacionCtrl'
  });
}])

.controller('actualizarInformacionCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratistasPorContratante',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratistasPorContratante) {

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
$scope.show = function(ciclo){
$scope.conf=true;
$scope.client=ciclo
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


}
$scope.listado = contratistasPorContratante.query({"idContratante":$localStorage.contratanteLogeado.idContratante})


}]);