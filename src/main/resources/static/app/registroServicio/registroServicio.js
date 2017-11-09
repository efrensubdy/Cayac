'use strict';

angular.module('myApp.registroServicio', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registroServicio', {
    templateUrl: 'registroServicio/registroServicio.html',
    controller: 'registroServicioCtrl'
  });
}])

.controller('registroServicioCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','registroServ','$mdDialog',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,registroServ,$mdDialog) {
if ("undefined" === typeof $localStorage.userLogeado || "undefined" !== typeof $localStorage.contratanteLogeado){
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
$scope.add=function(ev){

    console.log($scope.nombre);
    console.log($scope.area);
    var servicio={"nombre":$scope.nombre,"tipo":$scope.area,"idContratante":$localStorage.contratanteLogeado.idContratante}
    if("undefined" !== typeof $scope.nombre && "undefined" !== typeof $scope.area ){
        registroServ.save(servicio);
        $mdDialog.show(
                                        $mdDialog.alert()
                                          .parent(angular.element(document.querySelector('#popupContainer')))
                                          .clickOutsideToClose(true)
                                          .title('Registro de Servicio completo')
                                          .textContent('Ahora podrá registrar candidatos a este servicio.')
                                          .ariaLabel('Alert Dialog Demo')
                                          .ok('Registre Candidatos!')
                                          .targetEvent(ev)
                                      );
    }
    else{
            $mdDialog.show(
                                $mdDialog.alert()
                                  .parent(angular.element(document.querySelector('#popupContainer')))
                                  .clickOutsideToClose(true)
                                  .title('Hubo un error')
                                  .textContent('alguno de los datos se ecuentra sin llenar.')
                                  .ariaLabel('Alert Dialog Demo')
                                  .ok('intente de nuevo!')
                                  .targetEvent(ev)
                              );
    }


}

}]);