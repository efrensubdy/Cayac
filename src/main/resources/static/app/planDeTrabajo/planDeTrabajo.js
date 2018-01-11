'use strict';

angular.module('myApp.planDeTrabajo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/planDeTrabajo', {
    templateUrl: 'planDeTrabajo/planDeTrabajo.html',
    controller: 'planDeTrabajoCtrl'
  });
}])

.controller('planDeTrabajoCtrl', ['$location', '$q', '$scope','$http','$log','$rootScope','$localStorage','$sessionStorage','$route','plandeTrabajo','actividadPlan','fileUpload','actualizarPlanDeTrabajo','$mdDialog','$route',function($location, $q, $scope,$http,$log,$rootScope,$localStorage,$sessionStorage,$route,plandeTrabajo,actividadPlan,fileUpload,actualizarPlanDeTrabajo,$mdDialog,$route) {
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
var q=function(idContratante, idContratista){
                    //  var url= "http://localhost:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/planDeTrabajo/aprobado/"+idContratista+"/"+idContratante ;
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto=response.data;
                                    return response.data;
                                 })
          return a;
       }
q($localStorage.userLogeado.idContratante,$localStorage.userLogeado.idContratista);



$scope.closeModel= function(){
   document.getElementById('id01').style.display='none';
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
  $scope.opciones=[
    {id:1,nombre:'REGISTRAR ACTIVIDADES'},
    {id:2,nombre:'SUBIR SOPORTES'},
    {id:3,nombre:'CONSULTAR ACTIVIDADES'},
    {id:4,nombre:'ACTUALIZAR ACTIVIDADES'},


  ];
  $scope.simple=function(mes,year){
        if("undefined" !== typeof mes && "undefined" !== typeof year  ){
        $scope.banderaActividad=true;
        $scope.bandera1=false;
        $scope.bandera4=false;
        $scope.bandera3=false;
        $scope.bandera5=false;
        $scope.opcion= undefined;
        }
        else{
            $scope.banderaActividad=false;
        }

  }
  $scope.op=function(item,mes,year){
         switch(item.id){
            case 1:
               $scope.bandera1=true;
               $scope.bandera4=false;
               $scope.bandera3=false;
               $scope.bandera5=false;
               break;
            case 2:
               $scope.table2=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name},function(list){
                    if (list.length==0){
                                   $scope.bandera02 = true;
                                   document.getElementById('id02').style.display='block'
                    }
               },function(err){
                    $scope.bandera01 = true;
                    document.getElementById('id01').style.display='block';

               });
               $scope.bandera4=true;
               $scope.bandera1=false;
               $scope.bandera3=false;
                 $scope.bandera5=false;
               break;
           case 3:
               $scope.table3=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name},function(list){
                        if (list.length==0){
                           $scope.bandera02 = true;
                           document.getElementById('id02').style.display='block'
                        }
               },function(err){
                    $scope.bandera01 = true;
                    document.getElementById('id01').style.display='block';

               });
               $scope.bandera4=false;

               $scope.bandera3=true;
               $scope.bandera1=false;
                 $scope.bandera5=false;
               break;
           case 4:
               $scope.bandera4=false;
               $scope.bandera3=false;
               $scope.bandera1=false;
               $scope.bandera5=true;
               $scope.tableActividades=actividadPlan.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name},function(list){
                    if (list.length==0){
                       $scope.bandera02 = true;
                       document.getElementById('id02').style.display='block'
                    }
               },function(err){
                     $scope.bandera01 = true;
                     document.getElementById('id01').style.display='block';

               });

                break;

         }

  }
  $scope.add=function(ev,fechaInicio,fechaFin,nombre,mes,year){
    if ("undefined" !== typeof nombre &&"undefined" !== typeof mes && "undefined" !== typeof fechaInicio && "undefined" !== typeof fechaFin && "undefined" !== typeof year ){
    var plan={"nombre":nombre,"mes":mes,"fechaInicio":fechaInicio,"fechaFin":fechaFin,"idContratista":$localStorage.userLogeado.idContratista,"year":year};
    plandeTrabajo.save(plan,function(){

    },function(err){
        console.log(err);
        $scope.bandera01 = true;
        document.getElementById('id01').style.display='block';


    });
    $scope.nombre='';
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
       $route.reload();

    }
    else{
        $mdDialog.show(
                 $mdDialog.alert()
                   .parent(angular.element(document.querySelector('#popupContainer')))
                   .clickOutsideToClose(true)
                   .title('Algún dato esta erroneo intente de nuevo')
                   .textContent('Recuerde llenar todos los cambios')
                   .ariaLabel('Alert Dialog Demo')
                   .ok('ok!')
                   .targetEvent(ev)
               );
         $route.reload();



    }

  }
  $scope.subirDocumento=function(ev,item,file){

    if ("undefined" !== typeof file){
    //var uploadUrl = 'http://localhost:8080/app/planDeTrabajo/'+ item.id + "/"+ $localStorage.userLogeado.idContratista;
    var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/planDeTrabajo/'+ item.id + "/"+ $localStorage.userLogeado.idContratista;

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

    $route.reload();
    }
    else{

    $mdDialog.show(
         $mdDialog.alert()
               .parent(angular.element(document.querySelector('#popupContainer')))
               .clickOutsideToClose(true)
               .title('Reporte de Actividad No  registrado')
               .textContent('Recuerde Subir un archivo valido')
               .ariaLabel('Alert Dialog Demo')
               .ok('ok!')
               .targetEvent(ev)
           );
    $route.reload();
    }

  }
  $scope.actual = function(ev,client){

   $rootScope.client = client;
   $rootScope.meses = $scope.meses;
   $rootScope.years = $scope.years;
   $mdDialog.show({
                     //Controlador del mensajes con operaciones definido en la parte de abajo
                     controller: DialogController,
                      //permite la comunicacion con el html que despliega el boton requisitos
                       templateUrl: 'test/actualiPlanDeTrabajo.html',
                       parent: angular.element(document.body),
                       targetEvent: ev,
                        clickOutsideToClose:true,
                        fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
      })






  }
  function DialogController($scope, $mdDialog, $rootScope){
              $scope.client=$rootScope.client;
              $scope.meses=$rootScope.meses;
              $scope.years =$rootScope.years;

              $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
               $scope.cancel = function() {
                           $mdDialog.cancel();
                         };

               $scope.add =function (ev,fechaInicio,fechaFin,nombre,mes,year,client){
                        var actividad = new Actividad();
                        console.log(client)
                        actividad.id =client.id;
                        actividad.idContratista = $localStorage.userLogeado.idContratista;

                        if (nombre == client.nombre || "undefined" == typeof nombre ){

                              actividad.nombre =client.nombre
                         }
                         else{

                             actividad.nombre=nombre
                         }
                         if (fechaInicio == client.fechaInicio || "undefined" == typeof fechaInicio ){

                               actividad.fechaInicio =client.fechaInicio
                          }
                          else{

                              actividad.fechaInicio=fechaInicio
                          }
                          if (fechaFin == client.fechaFin || "undefined" == typeof fechaFin ){

                                 actividad.fechaFin =client.fechaFin
                            }
                            else{

                                actividad.fechaFin=fechaFin
                            }
                           if (mes == client.mes || "undefined" == typeof mes ){

                                actividad.mes =client.mes
                           }
                           else{

                               actividad.mes=mes
                           }
                           if (year == client.year || "undefined" == typeof year ){

                               actividad.year =client.year
                          }
                          else{

                              actividad.year=year
                          }

                         console.log(actividad)
                         actualizarPlanDeTrabajo.save(actividad)
                          $mdDialog.show(
                               $mdDialog.alert()
                                  .parent(angular.element(document.querySelector('#popupContainer')))
                                  .clickOutsideToClose(true)
                                  .title('Exito !!')
                                  .textContent('Puede revisar nuevamente o consultar sus Actividades.')
                                  .ariaLabel('Alert Dialog Demo')
                                  .ok('ok!')
                                  .targetEvent(ev)
                          );
                         $route.reload();
               }


  }
  function Actividad (){


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
