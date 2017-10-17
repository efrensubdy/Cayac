'use strict';

angular.module('myApp.planDeTrabajo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/planDeTrabajo', {
    templateUrl: 'planDeTrabajo/planDeTrabajo.html',
    controller: 'planDeTrabajoCtrl'
  });
}])

.controller('planDeTrabajoCtrl', ['$timeout', '$q', '$scope','$http','$log','$rootScope','$localStorage','$sessionStorage','plandeTrabajo','actividadPlan','fileUpload','$mdDialog',function($timeout, $q, $scope,$http,$log,$rootScope,$localStorage,$sessionStorage,plandeTrabajo,actividadPlan,fileUpload,$mdDialog) {
var q=function(idContratante, idContratista){
                      //var url= "http://localhost:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
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
  $scope.opciones=[
    {id:1,nombre:'REGISTRAR ACTIVIDADES'},
    {id:2,nombre:'SUBIR SOPORTES'},
    {id:3,nombre:'CONSULTAR ACTIVIDADES'},


  ];
  $scope.simple=function(){
        $scope.banderaActividad=true;

  }
  $scope.op=function(item,mes,year){
         switch(item.id){
            case 1:
               $scope.bandera1=true;
               $scope.bandera4=false;
               $scope.bandera3=false;
               break;
            case 2:
               $scope.table2=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
               $scope.bandera4=true;
               $scope.bandera1=false;
               $scope.bandera3=false;
               break;
           case 3:
               $scope.table3=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
               $scope.bandera4=false;

               $scope.bandera3=true;
               $scope.bandera1=false;
               break;

         }

  }
  $scope.add=function(ev,fechaInicio,fechaFin,nombre,mes,year){

    var plan={"nombre":nombre,"mes":mes,"fechaInicio":fechaInicio,"fechaFin":fechaFin,"idContratista":$localStorage.userLogeado.idContratista,"year":year};
    plandeTrabajo.save(plan);
    $scope.nombre='';
    $scope.mes='';
    $scope.fechaInicio='';
    $scope.fechaFin='';
    $mdDialog.show(
                                 $mdDialog.alert()
                                   .parent(angular.element(document.querySelector('#popupContainer')))
                                   .clickOutsideToClose(true)
                                   .title('Actividad del Plan de trabajo registrada')
                                   .textContent('Recuerde subir el soporte de esta actividad.')
                                   .ariaLabel('Alert Dialog Demo')
                                   .ok('ok!')
                                   .targetEvent(ev)
                               );



  }
  $scope.subirDocumento=function(item,file){
    console.log(item);
    console.log(file);
    //var uploadUrl = 'http://localhost:8080/app/planDeTrabajo/'+ item.id + "/"+ $localStorage.userLogeado.idContratista;
    var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/planDeTrabajo/'+ item.id + "/"+ $localStorage.userLogeado.idContratista;
    console.log(uploadUrl);
    fileUpload.uploadFileToUrl(file,uploadUrl);
    $mdDialog.show(
                                     $mdDialog.alert()
                                       .parent(angular.element(document.querySelector('#popupContainer')))
                                       .clickOutsideToClose(true)
                                       .title('Reporte de Actividad registrado')
                                       .textContent('Recuerde subir todos los soportes.')
                                       .ariaLabel('Alert Dialog Demo')
                                       .ok('ok!')
                                       .targetEvent(ev)
                                   );



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
