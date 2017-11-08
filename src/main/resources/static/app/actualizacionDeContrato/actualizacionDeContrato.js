'use strict';

angular.module('myApp.actualizacionDeContrato', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/actualizacionDeContrato', {
    templateUrl: 'actualizacionDeContrato/actualizacionDeContrato.html',
    controller: 'actualizacionDeContratoCtrl'
  });
}])

.controller('actualizacionDeContratoCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','contratosEnEjecucion','fileUpload',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,contratosEnEjecucion,fileUpload) {

$scope.banderaOpciones=false;
$scope.bandera2=false;
$scope.notificaciones=[
    {id:1,nombre:'RUT'},
    {id:2,nombre:'CAMARA DE COMERCIO'},
    {id:3,nombre:'CEDULA DEL REPRESENTANTE'},

 ];

$scope.ocultarTodo=function(){
    $scope.banderaOpciones= true;
    $scope.bandera2=false;

}
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});

$scope.add=function(contrato,notificacion){

    $scope.notificacion2=notificacion;
    $scope.contrato2=contrato;
    $scope.bandera2=true;

}
$scope.refreshFile=function(ev,myFile,contrato,notificacion){
console.log(contrato);
console.log(myFile);
console.log(notificacion)
//var uploadUrl = 'http://localhost:8080/app/contratos/rut/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/rut/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
console.log(uploadUrl);
fileUpload.uploadFileToUrl(myFile, uploadUrl);
}

}])
.directive('fileModel', ['$parse', function ($parse) {
      return {
             restrict: 'A',
             link: function(scope, element, attrs) {
                 var model, modelSetter;

                 attrs.$observe('fileModel', function(fileModel){
                     model = $parse(attrs.fileModel);
                     modelSetter = model.assign;
                 });

                 element.bind('change', function(){
                     scope.$apply(function(){
                         modelSetter(scope.$parent, element[0].files[0]);
                     });
                 });
             }
         };

 }]);