'use strict';

angular.module('myApp.seguridadSocial', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/seguridadSocial', {
    templateUrl: 'seguridadSocial/seguridadSocial.html',
    controller: 'seguridadSocialCtrl'
  });
}])

.controller('seguridadSocialCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratoUpload','sPorContra',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratoUpload,sPorContra) {
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
 { id: 1, name: 'REGISTRAR SEGURIDAD SOCIAL'},
 { id: 2, name: 'CONSULTAR SEGURIDAD SOCIAL '},

];
$scope.banderaMes=false;
$scope.bandera2=false;
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

 $scope.simple= function(item){
       switch(item.id){
            case 1:
            $scope.banderaMes= true;
            $scope.bandera2=false;
            break;
            case 2:
            $scope.banderaMes= false;
            $scope.bandera2=true;
            $scope.tablaSeguridadSocial=sPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            break;
       }

 }
$scope.subirArchivo = function(ev,file,file2,mes,textArea,year){
     if("undefined" !== typeof file && "undefined" !== typeof file2 && "undefined" !== typeof mes && "undefined" !== typeof textArea && "undefined" !== typeof year &&  file.name != file2.name ){
    //var uploadUrl = 'http://localhost:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name +  "/"+ textArea +  "/"+ year.name;
   var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name +  "/"+ textArea +  "/"+ year.name;
    $scope.list=[];
    $scope.list.push(file);
    $scope.list.push(file2);
    contratoUpload.uploadFileToUrl($scope.list, uploadUrl);
        $scope.banderaMes = false;
     $mdDialog.show(
                    $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Exito')
                    .textContent('Seguridad Social Totalmente registrada.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('intente de nuevo!')
                    .targetEvent(ev)
                );


     }
     else{
            $mdDialog.show(
                $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .clickOutsideToClose(true)
                .title('Algún dato quedo mal registrado,recuerde que los archivos no deben ser iguales')
                .textContent('Recuerde llenar todos los campos.')
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

 }]);;