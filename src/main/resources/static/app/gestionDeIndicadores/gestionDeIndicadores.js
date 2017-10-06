'use strict';

angular.module('myApp.gestionDeIndicadores', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeIndicadores', {
    templateUrl: 'gestionDeIndicadores/gestionDeIndicadores.html',
    controller: 'gestionDeIndicadoresCtrl'
  });
}])

.controller('gestionDeIndicadoresCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','finalesDefinitivos','contratosEnEjecucion','indMes',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,finalesDefinitivos,contratosEnEjecucion,indMes) {
$scope.years=[
     { id: 10, name: 2009},
     { id: 11, name: 2010},
     { id: 12, name: 2011},
     { id: 13, name: 2012},
     { id: 14, name: 2013},
     { id: 15, name: 2014},
     { id: 16, name: 2015},
     { id: 17, name: 2016},
     { id: 18, name: 2017},
     { id: 19, name: 2018},
     { id: 20, name: 2019},
     { id: 21, name: 2020},
     { id: 22, name: 2021},
     { id: 23, name: 2022},
     { id: 24, name: 2023},
     { id: 25, name: 2024},
     { id: 26, name: 2026},
                ];
$scope.meses=[
 { id: 1, name: 'ENERO'},
 { id: 2, name: 'FEBRERO'},
 { id: 3, name: 'MARZO'},
 { id: 4, name: 'ABRIL'},
 { id: 5, name: 'MAYO'},
 { id: 6, name: 'JUNIO'},
 { id: 7, name: 'JULIO'},
 { id: 8, name: 'AGOSTO'},
 { id: 9, name: 'SEPTIEMBRE'},
 { id: 10, name: 'OCTUBRE'},
 { id: 11, name: 'NOVIEMBRE'},
 { id: 12, name: 'DICIEMBRE'},

            ];
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false
$scope.add=function(){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
                $scope.flag=true;
                }

$scope.showAlert=function(ev, client,mes,year){
$rootScope.client=client;
$rootScope.listadoIndicadores=indMes.query({idContratista:client.id,mes:mes.name,year:year.name});
$mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
            controller: DialogController,
             //permite la comunicacion con el html que despliega el boton requisitos
            templateUrl: 'test/cumplimientoDeIndicador.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
        })
}

function DialogController($scope, $mdDialog, $rootScope, $http) {
$scope.listadoIndicadores=$rootScope.listadoIndicadores;
 $scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
  $scope.cancel = function() {
                       $mdDialog.cancel();
                     };




}
}]);