'use strict';

angular.module('myApp.view13', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view13', {
    templateUrl: 'view13/view13.html',
    controller: 'View13Ctrl'
  });
}])

.controller('View13Ctrl', ['$localStorage','$sessionStorage','$scope','$rootScope','$http','$mdDialog','nuevoContrato','fileUpload','$q','contratoUpload',function($localStorage,$sessionStorage,$scope,$rootScope,$http,$mdDialog,nuevoContrato,fileUpload,$q,contratoUpload) {
$scope.contrato={};
$scope.options = [
                            { id: 1, name: 'Contrato' },
                            { id: 2, name: 'Orden de Servicio' },

                          ];


$scope.add=function(ev){

 $scope.listaDocumentos=[];
   var contrato={"nombreContrato":$scope.contrato.nombreContrato,"fechaInicio":$scope.contrato.fechaInicio,"fechaFin":$scope.contrato.fechaFin,"idContratante":$localStorage.contratanteLogeado.idContratante,"tipoContrato":$scope.contrato.tipoContrato}
   var uploadUrl = "http://localhost:8080/app/contratos/" +contrato.nombreContrato + "/" +contrato.fechaInicio + "/" +contrato.fechaFin + "/" +contrato.idContratante + "/" +contrato.tipoContrato;

   var file=$scope.myFile;
   var file2=$scope.myFile2;
   var file3=$scope.myFile3;
   $scope.listaDocumentos.push($scope.myFile);
   $scope.listaDocumentos.push($scope.myFile2);
   $scope.listaDocumentos.push($scope.myFile3);
   console.log(uploadUrl)
   //contratoUpload.uploadFileToUrl($scope.listaDocumentos,uploadUrl);




    $scope.div1.$setPristine();
    $scope.div1.$setUntouched();
    $scope.contrato.nombreContrato='';
    $scope.contrato.fechaInicio='';
    $scope.contrato.tipoContrato='';
    $scope.contrato.fechaFin='';

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