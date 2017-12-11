'use strict';

angular.module('myApp.ControlDeContratistas', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ControlDeContratistas', {
    templateUrl: 'ControlDeContratistas/ControlDeContratistas.html',
    controller: 'ControlDeContratistasCtrl'
  });
}])

.controller('ControlDeContratistasCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratantes','contratistasPorContratante',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratantes,contratistasPorContratante) {

$scope.contratantes = contratantes.query();
$scope.bandera =false;
$scope.showAlert= function (ev,client){
    console.log(client)
    $scope.arl=$scope.arls[client.arl-1]
    console.log($scope.arl)
    $scope.departamento=$scope.departamentos[client.departamento-1];
     $rootScope.client=client
     $rootScope.arl=$scope.arl;
     $rootScope.departamento=$scope.departamento;
                $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController2,
                       //permite la comunicacion con el html que despliega el boton requisitos
                        templateUrl: 'test/test1.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                         clickOutsideToClose:true,
                         fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                 })


}
$scope.showTable=function(contratante){
    $scope.bandera =true;
    console.log(contratante);
    $scope.contratistas=contratistasPorContratante.query({idContratante:contratante.id})




}
$scope.arls =[

                  { id: 1, name: "Sura"},
                  { id: 2, name: "Bolivar"},
                  { id: 3, name: "Equidad"},
                  { id: 4, name: "Aurora"},
                  { id: 5, name: "Colpatria"},
                  { id: 6, name: "Positiva"},
                  { id: 7, name: "Liberty"},
                  { id: 8, name: "Mapfre"},
                  { id: 9, name: "Colmena"},
                  { id: 10, name: "Alfa"},

              ];

$scope.departamentos =[
                    { id: 1, name: "Bogotá D.C"},
                    { id: 2, name: "La Guajira"},
                    { id: 3, name: "Magdalena"},
                    { id: 4, name: "Guaviare"},
                    { id: 5, name: "Boyaca"},
                    { id: 6, name: "Valle del Cauca"},
                    { id: 7, name: "Amazonas"},
                    { id: 8, name: "Meta"},
                    { id: 9, name: "Antioquia"},
                    { id: 10, name: "Cauca"},
                    { id: 11, name: "Caldas"},
                    { id: 12, name: "Caqueta"},
                    { id: 13, name: "Casanare"},
                    { id: 14, name: "Cesar"},
                    { id: 15, name: "Choco"},
                    { id: 16, name: "Cordoba"},
                    { id: 17, name: "Guanía"},
                    { id: 18, name: "Huila"},
                    { id: 19, name: "Nariño"},
                    { id: 20, name: "Norte de Santander"},
                    { id: 21, name: "Putumayo"},
                    { id: 22, name: "Quindio"},
                    { id: 23, name: "Risaralda"},
                    { id: 24, name: "San Andrés"},
                    { id: 25, name: "Santander"},
                    { id: 26, name: "Sucre"},
                    { id: 27, name: "Tolima"},
                    { id: 28, name: "Vaupes"},
                    { id: 29, name: "Vichada"},
                    { id: 30, name: "Bolivar"},



                    ];

function DialogController2($scope, $mdDialog, $rootScope){
            $scope.client= $rootScope.client;
            $scope.arl=$rootScope.arl;
            $scope.departamento=$rootScope.departamento;
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

            $scope.hide = function() {
                         $mdDialog.hide();
                       };
                       //funcion para cerral el mensaje
             $scope.cancel = function() {
                         $mdDialog.cancel();
                       };




 }


}]);