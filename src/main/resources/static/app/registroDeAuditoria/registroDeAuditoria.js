'use strict';

angular.module('myApp.registroDeAuditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registroDeAuditoria', {
    templateUrl: 'registroDeAuditoria/registroDeAuditoria.html',
    controller: 'registroDeAuditoriaCtrl'
  });
}])

.controller('registroDeAuditoriaCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','$mdDialog','fileUpload','audiPorContra',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,$mdDialog,fileUpload,audiPorContra) {
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
$scope.opciones=[
 { id: 1, name: 'REGISTRAR AUDITORIA '},
 { id: 2, name: 'CONSULTAR AUDITORIAS'},

];

$scope.simple= function(item){
       switch(item.id){
            case 1:
                $scope.bandera1=true;
                $scope.flag2=false;
            break;
            case 2:
              $scope.flag2=true;
              $scope.bandera1=false;
              $scope.flag=false;
              $scope.listadoAuditorias=audiPorContra.query({idContratante:$localStorage.contratanteLogeado.idContratante})

            break;
       }

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

$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false;
$scope.flag2=false;
$scope.add=function(ev,contrato,year,mes){
                $scope.flag2=false;
                if("undefined" !== typeof contrato && "undefined" !== typeof year && "undefined" !== typeof mes){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato.idContrato})
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
 $scope.add2=function(ev,contrato,year,mes){


 }
 $scope.upload=function(ev,file,year,month,client){

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