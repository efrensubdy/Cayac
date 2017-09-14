'use strict';

angular.module('myApp.planDeTrabajo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/planDeTrabajo', {
    templateUrl: 'planDeTrabajo/planDeTrabajo.html',
    controller: 'planDeTrabajoCtrl'
  });
}])

.controller('planDeTrabajoCtrl', ['$timeout', '$q', '$scope','$http','$log','$rootScope','$localStorage','$sessionStorage','plandeTrabajo','actividadPlan','fileUpload',function($timeout, $q, $scope,$http,$log,$rootScope,$localStorage,$sessionStorage,plandeTrabajo,actividadPlan,fileUpload) {
var q=function(idContratante, idContratista){
                      var url= "http://localhost:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto=response.data;
                                    return response.data;
                                 })
          return a;
       }
q($localStorage.userLogeado.idContratante,$localStorage.userLogeado.idContratista);
 console.log($scope.objeto);




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

    var plan={"nombre":nombre,"mes":mes,"fechaInicio":fechaInicio,"fechaFin":fechaFin,"idContratista":$localStorage.userLogeado.idContratista};
    plandeTrabajo.save(plan);

  }
  $scope.subirDocumento=function(item,file){
    console.log(item);
    console.log(file);


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
