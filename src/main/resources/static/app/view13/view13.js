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


$scope.add=function(ev,a,b,c){




   if("undefined" !== typeof $scope.contrato.nombreContrato && "undefined" !== typeof a  && "undefined" !== typeof b  && "undefined" !== typeof c  && "undefined" !== typeof $scope.contrato.tipoContrato && "undefined" !== typeof $scope.myFile && "undefined" !== typeof $scope.myFile2 && "undefined" !== typeof $scope.myFile3 && $scope.myFile.name != $scope.myFile2.name && $scope.myFile.name != $scope.myFile3.name && $scope.myFile2.name != $scope.myFile3.name ){
            $scope.listaDocumentos=[];
            var contrato={"nombreContrato":$scope.contrato.nombreContrato,"fechaInicio":a,"fechaFin":b,"fechaInicioActividades":c,"idContratante":$localStorage.contratanteLogeado.idContratante,"tipoContrato":$scope.contrato.tipoContrato}
            var fechaInicio=contrato.fechaInicio.toString();
            var fechaFin=contrato.fechaFin.toString();
            var fechaInicioActividades=contrato.fechaInicioActividades.toString();

            //var uploadUrl = "http://localhost:8080/app/contratos/" + contrato.nombreContrato + "/" + fechaInicio + "/" + fechaFin + "/" + fechaInicioActividades + "/" +contrato.idContratante + "/" +contrato.tipoContrato;
            var uploadUrl = "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/" + contrato.nombreContrato + "/" + fechaInicio + "/" + fechaFin + "/" + fechaInicioActividades + "/" +contrato.idContratante + "/" +contrato.tipoContrato;

            var file=$scope.myFile;
            var file2=$scope.myFile2;
            var file3=$scope.myFile3;
            $scope.listaDocumentos.push($scope.myFile);
            $scope.listaDocumentos.push($scope.myFile2);
            $scope.listaDocumentos.push($scope.myFile3);
            console.log(uploadUrl)
            contratoUpload.uploadFileToUrl($scope.listaDocumentos,uploadUrl);

            $scope.contrato.nombreContrato='';
            $scope.contrato.fechaInicio='';
            $scope.contrato.tipoContrato='';
            $scope.contrato.fechaFin='';
            $scope.contrato.fechaInicioDeActividades='';

            $mdDialog.show(
                 $mdDialog.alert()
                         .parent(angular.element(document.querySelector('#popupContainer')))
                         .clickOutsideToClose(true)
                         .title('Exito')
                         .textContent('Contrato totalmente registrado')
                         .ariaLabel('Alert Dialog Demo')
                         .ok('Revise sus contratos!')
                         .targetEvent(ev)
             );
    }
    else{
       $mdDialog.show(
                        $mdDialog.alert()
                                .parent(angular.element(document.querySelector('#popupContainer')))
                                .clickOutsideToClose(true)
                                .title('ERROR')
                                .textContent('Algún dato es incorrecto, sin llenar, recuerde que los archivos no deben ser iguales')
                                .ariaLabel('Alert Dialog Demo')
                                .ok('Revise nuevamente!')
                                .targetEvent(ev)
                    );
       $scope.contrato.nombreContrato='';
                   $scope.contrato.fechaInicio='';
                   $scope.contrato.tipoContrato='';
                   $scope.contrato.fechaFin='';
                   $scope.contrato.fechaInicioDeActividades='';



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