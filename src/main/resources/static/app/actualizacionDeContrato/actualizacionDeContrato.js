'use strict';

angular.module('myApp.actualizacionDeContrato', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/actualizacionDeContrato', {
    templateUrl: 'actualizacionDeContrato/actualizacionDeContrato.html',
    controller: 'actualizacionDeContratoCtrl'
  });
}])

.controller('actualizacionDeContratoCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','contratosEnEjecucion','fileUpload',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,contratosEnEjecucion,fileUpload) {
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
switch(notificacion.id){

 case 1:
    console.log("rut")
 //var uploadUrl = 'http://localhost:8080/app/contratos/rut/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
 var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/rut/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
 fileUpload.uploadFileToUrl(myFile, uploadUrl);
 $mdDialog.show(
      $mdDialog.alert()
      .parent(angular.element(document.querySelector('#popupContainer')))
      .clickOutsideToClose(true)
       .title('Subido !!!')
       .textContent('Su archivo se ha Actualizado correctamente.')
       .ariaLabel('Alert Dialog Demo')
       .ok('ok!')
        .targetEvent(ev)
  );
  break;
  case 2:
     console.log("CAMARA DE COMERCIO")
     //var uploadUrl = 'http://localhost:8080/app/contratos/camaraDeComercio/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
      var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/camaraDeComercio/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
      console.log(uploadUrl);
      fileUpload.uploadFileToUrl(myFile, uploadUrl);

     $mdDialog.show(
          $mdDialog.alert()
          .parent(angular.element(document.querySelector('#popupContainer')))
          .clickOutsideToClose(true)
           .title('Subido !!!')
           .textContent('Su archivo se ha Actualizado correctamente.')
           .ariaLabel('Alert Dialog Demo')
           .ok('ok!')
            .targetEvent(ev)
      );
  break;
  case 3:
    console.log("CEDULA")
         //var uploadUrl = 'http://localhost:8080/app/contratos/cedulaDelRepresentante/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
          var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/camaraDeComercio/'+ contrato.idContratante + "/"+ contrato.fechaInicio + "/"+ contrato.idContrato;
          console.log(uploadUrl);
          fileUpload.uploadFileToUrl(myFile, uploadUrl);
     $mdDialog.show(
          $mdDialog.alert()
          .parent(angular.element(document.querySelector('#popupContainer')))
          .clickOutsideToClose(true)
           .title('Subido !!!')
           .textContent('Su archivo se ha Actualizado correctamente.')
           .ariaLabel('Alert Dialog Demo')
           .ok('ok!')
            .targetEvent(ev)
      );
  break;
}
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