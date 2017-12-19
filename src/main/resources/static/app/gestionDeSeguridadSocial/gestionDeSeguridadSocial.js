'use strict';

angular.module('myApp.gestionDeSeguridadSocial', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeSeguridadSocial', {
    templateUrl: 'gestionDeSeguridadSocial/gestionDeSeguridadSocial.html',
    controller: 'gestionDeSeguridadSocialCtrl'
  });
}])

.controller('gestionDeSeguridadSocialCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','$mdDialog','seguriContratante',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,$mdDialog,seguriContratante) {
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


 $scope.closeModel= function(){
                   document.getElementById('id01').style.display='none';
  }
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
},function(err){
    $scope.bandera01 = true;
     document.getElementById('id01').style.display='block';

});
$scope.flag=false
$scope.add=function(ev,contrato,mes,year){
                if("undefined" !== typeof contrato && "undefined" !== typeof year && "undefined" !== typeof mes){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato.idContrato},function(){
                },function(err){
                    $scope.bandera01 = true;
                    document.getElementById('id01').style.display='block';

                })
                $scope.flag=true;
                }
                else{

                    $mdDialog.show(
                        $mdDialog.alert()
                          .parent(angular.element(document.querySelector('#popupContainer')))
                          .clickOutsideToClose(true)
                          .title('Hubo un error')
                          .textContent('alguno de los datos se ecuentra sin escoger.')
                          .ariaLabel('Alert Dialog Demo')
                          .ok('intente de nuevo!')
                          .targetEvent(ev)
                      );
                }
                }
$scope.resul=function(){
    $scope.flag=false;
}
$scope.showAlert=function(ev, client,mes,year){
$rootScope.client=client;
$rootScope.listadoSeguridad=seguriContratante.query({idContratista:client.id,mes:mes.name,year:year.name});
$rootScope.mes=mes;
$rootScope.year=year;
$mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
            controller: DialogController,
             //permite la comunicacion con el html que despliega el boton requisitos
            templateUrl: 'test/cumplimientoDeSeguridadSocial.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
        })
}
function DialogController($scope, $mdDialog, $rootScope, $http) {
$scope.listadoSeguridad=$rootScope.listadoSeguridad;
$scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
  $scope.cancel = function() {
                       $mdDialog.cancel();
                     };



}
}]);