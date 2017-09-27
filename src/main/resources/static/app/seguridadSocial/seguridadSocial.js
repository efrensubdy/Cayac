'use strict';

angular.module('myApp.seguridadSocial', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/seguridadSocial', {
    templateUrl: 'seguridadSocial/seguridadSocial.html',
    controller: 'seguridadSocialCtrl'
  });
}])

.controller('seguridadSocialCtrl', ['$mdDialog','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratoUpload',function($mdDialog,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratoUpload) {

$scope.banderaMes=false;
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
 $scope.simple= function(){
       $scope.banderaMes= true;


 }
$scope.subirArchivo = function(ev,file,file2,mes,textArea){
    console.log(file);
    console.log(mes);
    console.log(file2);
    console.log(textArea);
     if("undefined" !== typeof file && "undefined" !== typeof file2 && "undefined" !== typeof mes && "undefined" !== typeof textArea){
    var uploadUrl = 'http://localhost:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name;
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