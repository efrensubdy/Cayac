'use strict';

angular.module('myApp.consultarServicios', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/consultarServicios', {
    templateUrl: 'consultarServicios/consultarServicios.html',
    controller: 'consultarServiciosCtrl'
  });
}])

.controller('consultarServiciosCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$window','example','exam','serviciosAContrar',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$window,example,exam,serviciosAContrar) {


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
$scope.flag = false;
 $scope.listado=serviciosAContrar.query({idContratante:$localStorage.contratanteLogeado.idContratante});
 $scope.closeModel= function(){
             document.getElementById('id01').style.display='none';
 }
 $scope.add = function(contrato){
    $scope.contratoSelec = contrato
    $scope.flag =true;
 }
 $scope.ocultarTodo =function(){
    $scope.flag = false;

 }

}]);