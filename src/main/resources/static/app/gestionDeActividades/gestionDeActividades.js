'use strict';

angular.module('myApp.gestionDeActividades', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeActividades', {
    templateUrl: 'gestionDeActividades/gestionDeActividades.html',
    controller: 'gestionDeActividadesCtrl'
  });
}])

.controller('gestionDeActividadesCtrl', ['$http','$mdDialog','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','actividadConSoporte','actividadSinSoporte',function($http,$mdDialog,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,actividadConSoporte,actividadSinSoporte) {

var q=function(idContratante, idContratista){
console.log("dsds")
 var url= "http://localhost:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
  var a;
    a=$http.get(url).then(function(response) {
               $rootScope.o=response.data;

               return response.data;
  })
     return a;
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
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false
$scope.add=function(){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
                $scope.flag=true;

                $rootScope.idCategoria=$scope.idCategoria
                $rootScope.idContrato=$scope.idContrato
                }




$scope.showAlert=function(ev, client,mes){
        $rootScope.client=client;
        $rootScope.lista1= actividadConSoporte.query({idContratista:client.id,mes:mes.name})
        $rootScope.lista2= actividadSinSoporte.query({idContratista:client.id,mes:mes.name})
        $mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
            controller: DialogController,
             //permite la comunicacion con el html que despliega el boton requisitos
            templateUrl: 'test/cumplidoActividad.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
        })


}


function DialogController($scope, $mdDialog, $rootScope, $http) {
 $scope.listadoActividad=$rootScope.lista1;
 $scope.listadoActividad2=$rootScope.lista2;
 console.log($scope.listadoActividad);


 $scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
  $scope.cancel = function() {
                       $mdDialog.cancel();
                     };






}



}]);