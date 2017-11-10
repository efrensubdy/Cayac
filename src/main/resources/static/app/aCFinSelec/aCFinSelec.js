'use strict';

angular.module('myApp.aCFinSelec', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/aCFinSelec', {
    templateUrl: 'aCFinSelec/aCFinSelec.html',
    controller: 'aCFinSelecCtrl'
  });
}])

.controller('aCFinSelecCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEjecucion','finalesSeleccion','$mdDialog','selecFin',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEjecucion,finalesSeleccion,$mdDialog,selecFin) {
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
 $scope.listado=contratosEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante})
 $scope.listado2=finalesSeleccion.query({idContratante:$localStorage.contratanteLogeado.idContratante});

$scope.asignar= function(ev,contrato,selc){

if("undefined" !== typeof contrato && "undefined" !== typeof selc){
var finalista={idFinalista:selc,idContrato:contrato};
console.log(finalista);
selecFin.save(finalista)
$mdDialog.show(
                              $mdDialog.alert()
                                .parent(angular.element(document.querySelector('#popupContainer')))
                                .clickOutsideToClose(true)
                                .title('Asignación de Contrato completo')
                                .textContent('Estos podrá verlos en la sección consultar Contratistas.')
                                .ariaLabel('Alert Dialog Demo')
                                .ok('ok!')
                                .targetEvent(ev)
                            );

}
else{
        $mdDialog.show(
                      $mdDialog.alert()
                        .parent(angular.element(document.querySelector('#popupContainer')))
                        .clickOutsideToClose(true)
                        .title('Algún dato quedo mal registrado')
                        .textContent('Recuerde llenar todos los campos.')
                        .ariaLabel('Alert Dialog Demo')
                        .ok('intente de nuevo!')
                        .targetEvent(ev)
                                            );


}

}


}]);