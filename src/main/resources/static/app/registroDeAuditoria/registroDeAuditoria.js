'use strict';

angular.module('myApp.registroDeAuditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registroDeAuditoria', {
    templateUrl: 'registroDeAuditoria/registroDeAuditoria.html',
    controller: 'registroDeAuditoriaCtrl'
  });
}])

.controller('registroDeAuditoriaCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','$mdDialog','fileUpload',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,$mdDialog,fileUpload) {


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

$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false
$scope.add=function(ev,contrato,year,mes){
                if("undefined" !== typeof contrato && "undefined" !== typeof year && "undefined" !== typeof mes){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato})
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
 $scope.upload=function(ev,file,year,month,client){
    console.log(file);
    console.log(year);
    console.log(month);
     if("undefined" !== typeof file && "undefined" !== typeof year && "undefined" !== typeof month ){
        //var uploadUrl = 'http://localhost:8080/app/auditoria/'+ client.id + "/"+ $localStorage.contratanteLogeado.idContratante +  "/"+ month.name +  "/"+ year.name;
        var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/auditoria/'+ client.id + "/"+ $localStorage.contratanteLogeado.idContratante +  "/"+ month.name +  "/"+ year.name
        fileUpload.uploadFileToUrl(file, uploadUrl);

        $mdDialog.show(
                    $mdDialog.alert()
                      .parent(angular.element(document.querySelector('#popupContainer')))
                      .clickOutsideToClose(true)
                      .title('Registro de Auditoria completo')
                      .textContent('Ahora su contratista podra registrar las no conformidades.')
                      .ariaLabel('Alert Dialog Demo')
                      .ok('ok!')
                      .targetEvent(ev)
                      )



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