'use strict';

angular.module('myApp.seguridadSocial', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/seguridadSocial', {
    templateUrl: 'seguridadSocial/seguridadSocial.html',
    controller: 'seguridadSocialCtrl'
  });
}])

.controller('seguridadSocialCtrl', ['$mdDialog','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','fileUpload',function($mdDialog,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,fileUpload) {

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
$scope.subirArchivo = function(ev,file,mes){
    console.log(file);
    console.log(mes);
    var uploadUrl = 'http://localhost:8080/app/seguridadSocial/'+ $localStorage.userLogeado.idContratista + "/"+ $localStorage.userLogeado.idContratante +  "/"+ mes.name;
    fileUpload.uploadFileToUrl(file, uploadUrl);
    $scope.banderaMes = false;


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