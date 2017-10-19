'use strict';

angular.module('myApp.seguridadSocial', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/seguridadSocial', {
    templateUrl: 'seguridadSocial/seguridadSocial.html',
    controller: 'seguridadSocialCtrl'
  });
}])

.controller('seguridadSocialCtrl', ['$mdDialog','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratoUpload',function($mdDialog,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratoUpload) {
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
 $scope.simple= function(item){
       switch(item.id){
            case 1:
            $scope.banderaMes= true;
            $scope.bandera2=false;
            break;
            case 2:
            $scope.banderaMes= false;
            $scope.bandera2=true;
            break;
       }

 }
$scope.subirArchivo = function(ev,file,file2,mes,textArea){
    console.log(file);
    console.log(mes);
    console.log(file2);
    console.log(textArea);
     if("undefined" !== typeof file && "undefined" !== typeof file2 && "undefined" !== typeof mes && "undefined" !== typeof textArea){
    //var uploadUrl = 'http://localhost:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name +  "/"+ textArea;
    var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name +  "/"+ textArea;
    $scope.list=[];
    $scope.list.push(file);
    $scope.list.push(file2);
    contratoUpload.uploadFileToUrl($scope.list, uploadUrl);
        $scope.banderaMes = false;
     }
     else{
            $mdDialog.show(
                $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .clickOutsideToClose(true)
                .title('Algún dato quedo mal registrado')
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