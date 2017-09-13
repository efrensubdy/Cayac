'use strict';

angular.module('myApp.planDeTrabajo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/planDeTrabajo', {
    templateUrl: 'planDeTrabajo/planDeTrabajo.html',
    controller: 'planDeTrabajoCtrl'
  });
}])

.controller('planDeTrabajoCtrl', ['$timeout', '$q', '$scope','$http','$log','$rootScope','$localStorage','$sessionStorage','plandeTrabajo','actividadPlan',function($timeout, $q, $scope,$http,$log,$rootScope,$localStorage,$sessionStorage,plandeTrabajo,actividadPlan) {


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
  $scope.opciones=[
    {id:1,nombre:'REGISTRAR ACTIVIDADES'},
    {id:2,nombre:'SUBIR SOPORTES'},
    {id:3,nombre:'CONSULTAR ACTIVIDADES'},


  ];
  $scope.simple=function(){
        $scope.banderaActividad=true;

  }
  $scope.op=function(item,mes){
        console.log(item);
        console.log(mes);
         switch(item.id){
            case 1:
               $scope.bandera1=true;
               $scope.bandera4=false;
               $scope.bandera3=false;
               break;
            case 2:
               $scope.table2=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name});
               $scope.bandera4=true;
               $scope.bandera1=false;
               $scope.bandera3=false;
               break;
           case 3:
               $scope.table3=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name});
               $scope.bandera4=false;

               $scope.bandera3=true;
               $scope.bandera1=false;
               break;

         }

  }
  $scope.add=function(ev,fechaInicio,fechaFin,nombre,mes){
    console.log(fechaInicio);
    console.log(fechaFin);
    console.log(nombre);
    console.log(mes);
    var plan={"nombre":nombre,"mes":mes,"fechaInicio":fechaInicio,"fechaFin":fechaFin,"idContratista":$localStorage.userLogeado.idContratista};
    plandeTrabajo.save(plan);

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
