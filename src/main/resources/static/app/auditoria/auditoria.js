'use strict';

angular.module('myApp.auditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/auditoria', {
    templateUrl: 'auditoria/auditoria.html',
    controller: 'auditoriaCtrl'
  });
}])

.controller('auditoriaCtrl', ['$http','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','$route','auditoriaContratis','noConformidad','noPorContra','causa','caPorContra','fileUpload','accionContra','registroDeAccion','accionConRegistro','accionSinRegistro','cierre','noConforCerradas','noPorContraAuditoria','noConforCerradasConAuditoria','actualizarNoConformidad','actualizarCausa','actualizarAccion',function($http,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,$route,auditoriaContratis,noConformidad,noPorContra,causa,caPorContra,fileUpload,accionContra,registroDeAccion,accionConRegistro,accionSinRegistro,cierre,noConforCerradas,noPorContraAuditoria,noConforCerradasConAuditoria,actualizarNoConformidad,actualizarCausa,actualizarAccion) {
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
$scope.take=false;
$scope.take2=false;
$scope.take3=false;
$scope.bandera1=false;
$scope.bandera2=false;
$scope.bandera3=false;
$scope.bandera4=false;
$scope.bandera5=false;
$scope.bandera6=false;
$scope.bandera7=false;
$rootScope.bandera8=false;
$rootScope.bandera9=false;
$rootScope.bandera10=false;
$scope.bandera11=false;
$scope.bandera12=false;
$scope.take4=false;
$scope.bandera13=false;
$scope.bandera14=false;
$scope.c1=false;
$scope.c2=false;
$scope.indicador=false;
$scope.indiCierre=false;
$scope.auditoras=false;
$scope.banderaActualiNo=false;
$scope.banderaActualiCa=false;
$scope.causaActualizada=false;
$scope.banderaActualiAcc = false;
$scope.despliegueDeCausas = false;
$scope.despliegueDeAcciones = false;
var q=function(idNoConformidad, idContratista){
                     // var url= "http://localhost:8080/app/cierre/isClose/"+idNoConformidad+"/"+idContratista;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/cierre/isClose/"+idNoConformidad+"/"+idContratista;

                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto= response.data;

                                    return response.data;
                                 })
          return a;
       }

$scope.opciones=[
 { id: 1, name: 'REGISTRAR NO CONFORMIDADES'},
 { id: 2, name: 'REGISTRAR CAUSAS'},
 { id: 3, name: 'REGISTRAR ACCIONES'},
 {id:7,name:'REGISTRAR SOPORTE DE ACCIONES'},
 { id: 4, name: 'CONSULTAR NO CONFORMIDADES'},
 { id: 5, name: 'CONSULTAR CAUSAS'},
 { id: 6, name: 'CONSULTAR ACCIONES'},
 {id:9, name:'ACTUALIZAR NO CONFORMIDAD'},
 {id:10, name:'ACTUALIZAR CAUSAS'},
 {id:11, name:'ACTUALIZAR ACCIONES'},
 {id:8, name:'CUMPLIMIENTO DE PROGRAMA'},


];

$scope.opcionesDeCumplimiento=[
 { id: 1, name: 'INDICADOR DE CUMPLIMIENTO DE ACCIONES'},
 { id: 2, name: 'INDICADOR DE CIERRE DE NO CONFORMIDADES'},

];

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
              $scope.bandera1=true;
              $scope.bandera2=false;
              $scope.bandera3=false;
              $scope.bandera4=false;
              $scope.bandera5=false;
              $scope.bandera6=false;
              $scope.bandera7=false;
              $rootScope.bandera8=false;
              $scope.take=false;
              $scope.take2=false;
              $scope.take3=false;
              $rootScope.bandera9=false;
              $rootScope.bandera10=false;
              $scope.bandera11=false;
              $scope.bandera13=false;
              $scope.bandera14=false;
              $scope.take4=false;
              $scope.bandera12=false;
              $scope.c1=false;
              $scope.c2=false;
              $scope.takeC1 = false;
              $scope.indicador=false;
              $scope.indiCierre=false;
              $scope.auditoras=false;
              $scope.banderaActualiNo=false;
              $scope.banderaActualiCa=false;
              $scope.causaActualizada=false;
              $scope.banderaActualiAcc = false
              $scope.despliegueDeCausas = false;
              $scope.despliegueDeAcciones = false;
            break;
            case 2:
            $scope.bandera1=false;
            $scope.bandera3=false;
            $scope.bandera4=false;
            $scope.bandera5=false;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista})
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $scope.bandera13=false;
            $scope.take4=false;
            $scope.bandera12=false;
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;
           break;
            case 3:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=true;
            $scope.bandera4=false;
            $scope.bandera5=false;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.bandera12=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista})
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;
            break;
            case 4:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=false;
            $scope.bandera4=true;
            $scope.bandera5=false;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.bandera12=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;
            break;
            case 5:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=false;
            $scope.bandera4=false;
            $scope.bandera5=true;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.bandera12=false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;

            break;
            case 6:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=false;
            $scope.bandera4=false;
            $scope.bandera5=false;
            $scope.bandera6=true;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.bandera13=false;
            $scope.bandera12=false;
            $scope.take4=false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;
            break;

            case 7:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=false;
            $scope.bandera4=false;
            $scope.bandera5=false;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.bandera12=true;
            $scope.bandera13=false;
            $scope.take4=false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.bandera14=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.indiCierre=false;
            $scope.auditoras=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc = false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones = false;
            break;
            case 8:
            $scope.bandera1=false;
            $scope.bandera2=false;
            $scope.bandera3=false;
            $scope.bandera4=false;
            $scope.bandera5=false;
            $scope.bandera6=false;
            $scope.bandera7=false;
            $rootScope.bandera8=false;
            $scope.take=false;
            $scope.take2=false;
            $scope.take3=false;
            $rootScope.bandera9=false;
            $rootScope.bandera10=false;
            $scope.bandera11=false;
            $scope.bandera12=false;
            $scope.bandera13=false;
            $scope.take4=false;
             $scope.bandera14=true;
             $scope.c1=false;
             $scope.c2=false;
             $scope.takeC1 = false;
             $scope.indicador=false;
             $scope.indiCierre=false;
             $scope.auditoras=false;
             $scope.banderaActualiNo=false;
             $scope.banderaActualiCa=false;
             $scope.causaActualizada=false;
             $scope.banderaActualiAcc = false;
             $scope.despliegueDeCausas = false;
             $scope.despliegueDeAcciones = false;
            break;
            case 9:
                $scope.bandera1=false;
                $scope.bandera2=false;
                $scope.bandera3=false;
                $scope.bandera4=false;
                $scope.bandera5=false;
                $scope.bandera6=false;
                $scope.bandera7=false;
                $rootScope.bandera8=false;
                $scope.take=false;
                $scope.take2=false;
                $scope.take3=false;
                $rootScope.bandera9=false;
                $rootScope.bandera10=false;
                $scope.bandera11=false;
                $scope.bandera12=false;
                $scope.bandera13=false;
                $scope.take4=false;
                 $scope.bandera14=false;
                 $scope.c1=false;
                 $scope.c2=false;
                 $scope.takeC1 = false;
                 $scope.indicador=false;
                 $scope.indiCierre=false;
                 $scope.auditoras=false;
                 $scope.banderaActualiNo=true;
                 $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
                 $scope.banderaActualiCa=false;
                 $scope.causaActualizada=false;
                 $scope.banderaActualiAcc = false;
                 $scope.despliegueDeCausas = false;
                 $scope.despliegueDeAcciones = false;
                break;
           case 10:
                $scope.bandera1=false;
                $scope.bandera2=false;
                $scope.bandera3=false;
                $scope.bandera4=false;
                $scope.bandera5=false;
                $scope.bandera6=false;
                $scope.bandera7=false;
                $rootScope.bandera8=false;
                $scope.take=false;
                $scope.take2=false;
                $scope.take3=false;
                $rootScope.bandera9=false;
                $rootScope.bandera10=false;
                $scope.bandera11=false;
                $scope.bandera12=false;
                $scope.bandera13=false;
                $scope.take4=false;
                 $scope.bandera14=false;
                 $scope.c1=false;
                 $scope.c2=false;
                 $scope.takeC1 = false;
                 $scope.indicador=false;
                 $scope.indiCierre=false;
                 $scope.auditoras=false;
                 $scope.banderaActualiNo=false;
                 $scope.banderaActualiCa=true;
                 $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
                 $scope.causaActualizada=false;
                 $scope.banderaActualiAcc = false;
                 $scope.despliegueDeCausas = false;
                 $scope.despliegueDeAcciones = false;
                        break;
           case 11:
                           $scope.bandera1=false;
                           $scope.bandera2=false;
                           $scope.bandera3=false;
                           $scope.bandera4=false;
                           $scope.bandera5=false;
                           $scope.bandera6=false;
                           $scope.bandera7=false;
                           $rootScope.bandera8=false;
                           $scope.take=false;
                           $scope.take2=false;
                           $scope.take3=false;
                           $rootScope.bandera9=false;
                           $rootScope.bandera10=false;
                           $scope.bandera11=false;
                           $scope.bandera12=false;
                           $scope.bandera13=false;
                           $scope.take4=false;
                            $scope.bandera14=false;
                            $scope.c1=false;
                            $scope.c2=false;
                            $scope.takeC1 = false;
                            $scope.indicador=false;
                            $scope.indiCierre=false;
                            $scope.auditoras=false;
                            $scope.banderaActualiNo=false;
                            $scope.banderaActualiCa=false;
                            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
                            $scope.causaActualizada=false;
                            $scope.banderaActualiAcc = true;
                            $scope.despliegueDeCausas = false;
                            $scope.despliegueDeAcciones = false;
                                   break;
       }

 }
 $scope.simpleOpCionC = function(item){
      switch(item.id){

        case 1:
         $scope.c1=true;
         $scope.c2=false;
         $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
          $scope.takeC1 =false;
          $scope.indicador=false;
          $scope.auditoras=false;

        break;
        case 2:
        $scope.c1=false;
        $scope.c2=true;
         $scope.takeC1 = false;
         $scope.indicador=false;
         $scope.auditoras=false;
        break;


      }


 }
 $scope.cambiarOpcion =function(item){

     $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$localStorage.userLogeado.idContratista,idAuditoria:item.id});
     $scope.listadoNoConforCerradas=noConforCerradasConAuditoria.query({idContratista:$localStorage.userLogeado.idContratista,idAuditoria:item.id});
     $scope.indiCierre=true;



 }
 $scope.consultarAuditoria2=function(mes,year){
    $scope.tableContra=auditoriaContratis.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
    $scope.auditoras=true;


 }
 $scope.ocultarTodo=function(){
  $scope.indiCierre=false;
  $scope.auditoria=false

 }
 $scope.simpleC1 =function(opcionC1){
    if("undefined" !== typeof opcionC1){
        $scope.takec1 =true;
        q(opcionC1.id,$localStorage.userLogeado.idContratista);
        $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:opcionC1.id})

    }

 }
 $scope.tak =function(op10){
    if("undefined" !== typeof op10){
           $scope.accionConRegistro=accionConRegistro.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:op10.id});
           $scope.accionSinRegistro=accionSinRegistro.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:op10.id});
           $scope.indicador=true;

    }



 }
 $scope.takAcc =function(causaActaCC){
         if("undefined" !== typeof causaActaCC){
             $scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:causaActaCC.id})
             $scope.despliegueDeAcciones = true;

         }


 }
 $scope.simple2= function(item){

 if("undefined" !== typeof item){
 $rootScope.noConformidadActual=item;
 $rootScope.bandera9=true;
 }

 }
 $scope.simple3=function(item){

 if("undefined" !== typeof item){
 $rootScope.bandera10=true;
 $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
 }

 }
 $scope.simple4=function(item){
    if("undefined" !== typeof item){
    $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
    $scope.take=true;
    }
 }
 $scope.simple5=function(item){
 if("undefined" !== typeof item){
    $scope.take2=true;
    }

 }
  $scope.simple6=function(item){
    if("undefined" !== typeof item){
     $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
     $scope.take3=true;
     }

  }
  $scope.simple7=function(item){
    if("undefined" !== typeof item){
    $scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:item.id})
    $scope.bandera11=true;
    }

  }
  $scope.simple8=function(item){
      if("undefined" !== typeof item){
       $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
       $scope.take4=true;
       }

    }
    $scope.simple9=function(item){
      if("undefined" !== typeof item){
      $scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:item.id})
      $scope.bandera13=true;
      }

    }
     //$scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:item.id})
    $scope.simpleActualizarII = function(opcionActualizarII){
        if("undefined" !== typeof opcionActualizarII){
            $scope.despliegueDeCausas = true;
            $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:opcionActualizarII.id})
        }




    }
  $scope.salvarAccion = function(op,accion,ev){
  if("undefined" !== typeof accion && "undefined" !== typeof op){
    var accion ={idContratista:$localStorage.userLogeado.idContratista,idCausa:op.id,nombre:accion}
    registroDeAccion.save(accion);
    $scope.nombreAccion='';
    $mdDialog.show(
         $mdDialog.alert()
           .parent(angular.element(document.querySelector('#popupContainer')))
           .clickOutsideToClose(true)
           .title('Accion registrada')
           .textContent('Recuerde subir todas las acciones pertinentes.')
           .ariaLabel('Alert Dialog Demo')
           .ok('ok!')
           .targetEvent(ev)
    );
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
 $scope.salvarAccion2 = function(op,file,item,ev){

    if("undefined" !== typeof file && "undefined" !== typeof op && "undefined" !== typeof op ){
        //var uploadUrl = 'http://localhost:8080/app/accion/'+ $localStorage.userLogeado.idContratista + "/"+ op.id + "/"+ item.id
        var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/accion/'+ $localStorage.userLogeado.idContratista + "/"+ op.id + "/"+ item.id ;

        fileUpload.uploadFileToUrl(file,uploadUrl);
            $mdDialog.show(
                                             $mdDialog.alert()
                                               .parent(angular.element(document.querySelector('#popupContainer')))
                                               .clickOutsideToClose(true)
                                               .title('Accion registrada')
                                               .textContent('Recuerde subir todas las acciones pertinentes.')
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
                        .title('Algún dato quedo mal registrado')
                        .textContent('Recuerde llenar todos los campos.')
                        .ariaLabel('Alert Dialog Demo')
                        .ok('intente de nuevo!')
                        .targetEvent(ev)
                    );
         $route.reload();


    }



 }

$scope.cerrarNoConformidad=function(item,ev){

    var cie ={idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id};
    cierre.save(cie);
    $mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Cerrada')
                            .textContent('La no conformidad se ecuentra cerrada.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('ok!')
                            .targetEvent(ev)
                        );
    $route.reload();


}
 $scope.causa=function(ev,item){

    if("undefined" !== typeof item){
        var object ={idContratista:$localStorage.userLogeado.idContratista,causa:item,idNoConformidad:$rootScope.noConformidadActual.id}
        causa.save(object);
        $mdDialog.show(
               $mdDialog.alert()
                  .parent(angular.element(document.querySelector('#popupContainer')))
                  .clickOutsideToClose(true)
                  .title('Exito !!')
                  .textContent('Causa registrada,ahora podrá consultarla.')
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
                            .title('Algún dato quedo mal registrado')
                            .textContent('Recuerde llenar todos los campos.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('intente de nuevo!')
                            .targetEvent(ev)
                        );
        $route.reload();


    }

 }

 $scope.consultarAuditoria=function(ev,mes,year){
    if("undefined" !== typeof mes && "undefined" !== typeof year){
        $mdDialog.show(
                    $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('A continuacion econtrará las auditorias disponibles')
                    .textContent('Si no presentá para este periodo el software no le dejara registrar las no conformidades.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('ok!')
                    .targetEvent(ev)
                );
          $scope.tableContra=auditoriaContratis.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
          $scope.bandera7=true;
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

 $scope.agregarNo=function(item,mes,year){
    $rootScope.bandera8=true;
    $rootScope.item=item;
    $rootScope.mes=mes;
    $rootScope.year=year;



 }
 $scope.noConfor=function(ev,textArea){
    if("undefined" !== typeof textArea){
    var object ={idContratista:$localStorage.userLogeado.idContratista,noConformidad:textArea,mes:$rootScope.mes.name,year:$rootScope.year.name,idAuditoria:$rootScope.item.id}
    noConformidad.save(object);
    $mdDialog.show(
                   $mdDialog.alert()
                      .parent(angular.element(document.querySelector('#popupContainer')))
                      .clickOutsideToClose(true)
                      .title('Exito !!')
                      .textContent('No Coformidad registrada,ahora podrá consultarla.')
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
                    .title('Algún dato quedo mal registrado')
                    .textContent('Recuerde llenar todos los campos.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('intente de nuevo!')
                    .targetEvent(ev)
                );
         $route.reload();

      }

 }
 $scope.showAlert = function(ev,client){
            $rootScope.client = client;
               $rootScope.meses = $scope.meses;
               $rootScope.years = $scope.years;

        $mdDialog.show({
                                      //Controlador del mensajes con operaciones definido en la parte de abajo
                                      controller: DialogController2,
                                       //permite la comunicacion con el html que despliega el boton requisitos
                                       templateUrl: 'test/actualiNoConformidad.html',
                                       parent: angular.element(document.body),
                                       targetEvent: ev,
                                       clickOutsideToClose:true,
                                       fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                          })


 }
 $scope.showAlertCausas = function(ev,causa){
    $rootScope.causa = causa;
    $mdDialog.show({
                                          //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController3,
                   //permite la comunicacion con el html que despliega el boton requisitos
                   templateUrl: 'test/actualiCausas.html',
                   parent: angular.element(document.body),
                   targetEvent: ev,
                   clickOutsideToClose:true,
                   fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
      })

 }
 $scope.showAlertAcciones = function(ev,accion){
     $rootScope.accionActual = accion;
     $mdDialog.show({
                                           //Controlador del mensajes con operaciones definido en la parte de abajo
                   controller: DialogController4,
                    //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/actualiAccion.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose:true,
                    fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
       })

  }

 function DialogController($scope, $mdDialog, $rootScope, $http) {

      $scope.show=function(){
         $mdDialog.cancel();
     }
     $scope.hide = function() {
                            $mdDialog.hide();

                          };
                          //funcion para cerral el mensaje
       $scope.cancel = function() {
                            $mdDialog.cancel();
                            $rootScope.bandera8=false;
                            $rootScope.textInput = '';
                            
                          };

        $scope.cancel2 = function() {
                                   $mdDialog.cancel();
                                   $rootScope.bandera9=false;

                                 };


 }
  function DialogController4($scope, $mdDialog, $rootScope, $http, $route) {
         $scope.accion = $rootScope.accionActual
       $scope.show=function(){
          $mdDialog.cancel();
      }
      $scope.hide = function() {
                             $mdDialog.hide();

                           };
                           //funcion para cerral el mensaje
        $scope.cancel = function() {
                             $mdDialog.cancel();
                             $rootScope.bandera8=false;

                           };

        $scope.add = function(ev,nombre,accion){
            var accionActualizada = new Accion();
            accionActualizada.id = accion.id;
            if (nombre == accion.nombre || "undefined" == typeof nombre ){

                   accionActualizada.nombre =accionActualizada.nombre;
              }
              else{

                  accionActualizada.nombre=nombre;
              }

                actualizarAccion.save(accionActualizada);
             $mdDialog.show(
                   $mdDialog.alert()
                      .parent(angular.element(document.querySelector('#popupContainer')))
                      .clickOutsideToClose(true)
                      .title('Exito !!')
                      .textContent('Puede revisar nuevamente o consultar sus Acciones.')
                      .ariaLabel('Alert Dialog Demo')
                      .ok('ok!')
                      .targetEvent(ev)
              );
                         $route.reload();


        }

  }
 function DialogController2($scope, $mdDialog, $rootScope, $http,$route) {
         $scope.client=$rootScope.client;
         $scope.meses=$rootScope.meses;
         $scope.years =$rootScope.years;
       $scope.show=function(){
          $mdDialog.cancel();
      }
      $scope.hide = function() {
                             $mdDialog.hide();

                           };
                           //funcion para cerral el mensaje
        $scope.cancel = function() {
                             $mdDialog.cancel();
                             $rootScope.bandera8=false;

                           };

        $scope.add = function(ev,nombre,mes,year,client){
            var noConformidadActualizada =new NoConformidad();
            noConformidadActualizada.id =client.id;

            if (nombre == client.noConformidad || "undefined" == typeof nombre ){

                   noConformidadActualizada.noConformidad =client.noConformidad
              }
              else{

                  noConformidadActualizada.noConformidad=nombre
              }
              if (mes == client.mes || "undefined" == typeof mes ){

                     noConformidadActualizada.mes =client.mes
                }
                else{

                    noConformidadActualizada.mes= mes
                }
                if (year == client.year || "undefined" == typeof year ){

                     noConformidadActualizada.year =client.year
                }
                else{

                    noConformidadActualizada.year= year
                }

            console.log(noConformidadActualizada);
            actualizarNoConformidad.save(noConformidadActualizada)
             $mdDialog.show(
                                           $mdDialog.alert()
                                              .parent(angular.element(document.querySelector('#popupContainer')))
                                              .clickOutsideToClose(true)
                                              .title('Exito !!')
                                              .textContent('Puede revisar nuevamente o consultar sus No Conformidades.')
                                              .ariaLabel('Alert Dialog Demo')
                                              .ok('ok!')
                                              .targetEvent(ev)
                                      );
             $route.reload();
        }


  }
  function DialogController3($scope, $mdDialog, $rootScope, $http , $route) {
        $scope.causa = $rootScope.causa;
        $scope.add = function(ev,nombre,causa){
            var causaActual=new Causa();
            causaActual.id = causa.id
            causaActual.idContratista =$localStorage.userLogeado.idContratista;
            if (nombre == causaActual.causa || "undefined" == typeof nombre ){

                   causaActual.causa =causa.causa
             }
            else{

                causaActual.causa=nombre
              }
              actualizarCausa.save(causaActual)
              $mdDialog.show(
                     $mdDialog.alert()
                        .parent(angular.element(document.querySelector('#popupContainer')))
                        .clickOutsideToClose(true)
                        .title('Exito !!')
                        .textContent('Puede revisar nuevamente o consultar sus Causas.')
                        .ariaLabel('Alert Dialog Demo')
                        .ok('ok!')
                        .targetEvent(ev)
                );
                $route.reload();



        }
        $scope.show=function(){
           $mdDialog.cancel();
       }
       $scope.hide = function() {
                              $mdDialog.hide();

                            };
                            //funcion para cerral el mensaje
         $scope.cancel = function() {
                              $mdDialog.cancel();
                              $rootScope.bandera8=false;

                            };

   }


  $scope.simpleActualizar = function(opcionActualizar){
   $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:opcionActualizar.id})
   $scope.causaActualizada =true;

  }
  function NoConformidad (){


    }
    function Causa (){


    }
    function Accion (){


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