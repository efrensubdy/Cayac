'use strict';

angular.module('myApp.facturacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/facturacion', {
    templateUrl: 'facturacion/facturacion.html',
    controller: 'facturacionCtrl'
  });
}])

.controller('facturacionCtrl', ['$http','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage',function($http,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage) {
$scope.banderaConsulta=false;
var q=function(idContratante, idContratista,mes){
                      var url= "http://localhost:8080/app/planDeTrabajo/aprobadoPlanDeTrabajo/"+idContratista+"/"+idContratante +"/"+mes ;
                      console.log(url);
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto=response.data;
                                    console.log(response.data);
                                    return response.data;
                                 })
          return a;
       }
$scope.consultar =function(mes){
$scope.banderaConsulta=true;
q($localStorage.userLogeado.idContratante,$localStorage.userLogeado.idContratista,mes.name);

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



}]);