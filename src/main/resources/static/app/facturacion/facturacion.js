'use strict';

angular.module('myApp.facturacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/facturacion', {
    templateUrl: 'facturacion/facturacion.html',
    controller: 'facturacionCtrl'
  });
}])

.controller('facturacionCtrl', ['$http','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog',function($http,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog) {
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
$scope.banderaConsulta=false;
var q=function(idContratante, idContratista,mes,year){
                      //var url= "http://localhost:8080/app/planDeTrabajo/aprobadoPlanDeTrabajo/"+idContratista+"/"+idContratante +"/"+mes +"/"+year ;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/planDeTrabajo/aprobadoPlanDeTrabajo/"+idContratista+"/"+idContratante +"/"+mes +"/"+year ;
                      console.log(url);
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto= $scope.objeto && response.data;
                                    console.log(response.data);
                                    return response.data;
                                 })
          return a;
       }
var k=function(idContratante, idContratista,mes,year){
                      //var url= "http://localhost:8080/app/indicador/aprobadoIndicador/"+idContratista+"/"+idContratante +"/"+mes +"/"+year ;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/indicador/aprobadoIndicador/"+idContratista+"/"+idContratante +"/"+mes +"/"+year ;
                      console.log(url);
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto=response.data;
                                    console.log(response.data);
                                    return response.data;
                                 })
          return a;
       }
$scope.consultar =function(mes,year){
$scope.banderaConsulta=true;
q($localStorage.userLogeado.idContratante,$localStorage.userLogeado.idContratista,mes.name,year.name);
k($localStorage.userLogeado.idContratante,$localStorage.userLogeado.idContratista,mes.name,year.name);

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

}]);