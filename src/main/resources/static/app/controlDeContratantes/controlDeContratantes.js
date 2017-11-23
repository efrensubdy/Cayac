'use strict';

angular.module('myApp.controlDeContratantes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/controlDeContratantes', {
    templateUrl: 'controlDeContratantes/controlDeContratantes.html',
    controller: 'controlDeContratantesCtrl'
  });
}])

.controller('controlDeContratantesCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratantes',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratantes) {

$scope.contratantes = contratantes.query();
$scope.showAlert= function (ev,client){
    $rootScope.client=client
                $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController2,
                       //permite la comunicacion con el html que despliega el boton requisitos
                        templateUrl: 'test/detalleContratante.html',
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


}]);