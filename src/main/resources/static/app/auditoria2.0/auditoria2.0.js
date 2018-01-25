'use strict';

angular.module('myApp.auditoria2.0', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/auditoria2.0', {
    templateUrl: 'auditoria2.0/auditoria2.0.html',
    controller: 'auditoria2.0Ctrl'
  });
}])

.controller('auditoria2.0Ctrl', ['$http','$mdDialog','$location','$scope','$rootScope','$localStorage','$sessionStorage','$window','$route','example','exam','auditoriaContratis','noConformidad','noPorContra','causa','caPorContra','registroDeAccion','accionContra','actualizarNoConformidad','actualizarCausa','actualizarAccion','fileUpload','accionConRegistro','accionSinRegistro','noPorContraAuditoria','noConforCerradasConAuditoria','cierre',function($http, $mdDialog,$location,$scope,$rootScope,$localStorage,$sessionStorage,$window,$route,example,exam,auditoriaContratis,noConformidad,noPorContra,causa,caPorContra,registroDeAccion,accionContra,actualizarNoConformidad,actualizarCausa,actualizarAccion,fileUpload,accionConRegistro,accionSinRegistro,noPorContraAuditoria,noConforCerradasConAuditoria,cierre) {

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
$scope.opciones =[
    { id: 1, name: 'ACTUALIZAR'},
    { id: 2, name: 'CONSULTAR'},
    { id: 3, name: 'REGISTRAR'},


];
$scope.opcionesRegistrar =[
    { id: 1, name: 'REGISTRAR NO CONFORMIDADES'},
    { id: 2, name: 'REGISTRAR CAUSAS'},
    { id: 3, name: 'REGISTRAR ACCIONES'},
    { id: 4,name:'REGISTRAR SOPORTE DE ACCIONES'},

];
$scope.opcionesActualizar =[
    {id:1, name:'ACTUALIZAR NO CONFORMIDAD'},
    {id:2, name:'ACTUALIZAR CAUSAS'},
    {id:3, name:'ACTUALIZAR ACCIONES'}

];
$scope.opcionesConsultar =[
    { id: 1, name: 'CONSULTAR NO CONFORMIDADES'},
    { id: 2, name: 'CONSULTAR CAUSAS'},
    { id: 3, name: 'CONSULTAR ACCIONES'},
    { id: 4, name:'CUMPLIMIENTO DE PROGRAMA'},


];
$scope.opcionesDeCumplimiento=[
 { id: 1, name: 'INDICADOR DE CUMPLIMIENTO DE ACCIONES'},
 { id: 2, name: 'INDICADOR DE CIERRE DE NO CONFORMIDADES'},

];




 $scope.opcionRegistrar1=false;
 $scope.opcionRegistrar2 =false;
 $scope.opcionRegistrar3 =false;
 $scope.opcionConsultar4 = false;
 $scope.causasParaAcciones=false;
 $scope.auditoria=false;
 $scope.registroNoConformidad=false;
 $rootScope.banderaRegristroCausas=false;
 $scope.banderaActualiCa=false;
 $scope.causaActualizada=false;
 $scope.despliegueDeCausas = false;
 $scope.despliegueDeAcciones =false;
 $scope.opcionRegistrar4=false;
 $scope.take4=false;
 $scope.bandera13=false;
 $scope.c1=false;
 $scope.c2=false;
 $scope.takeC1 = false;
 $scope.indicador=false;
 $scope.auditoras=false;
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
$scope.AnalisisDeInfo = function(opcion){
    switch(opcion.id){
        case 1:
          $scope.actualizar=true;
          $scope.registrar=false;
          $scope.consultar=false;
          $scope.opcionRegistrar1=false;
          $scope.opcionRegistrar2 =false;
          $scope.opcionRegistrar3 =false;
          $scope.opcionRegistrar4=false;
          $scope.opcionConsultar1=false;
          $scope.banderaActualiNo=false;
          $scope.banderaActualiCa=false;
          $scope.banderaActualiAcc=false;
          $scope.causaActualizada=false;
          $scope.opcionConsultar2=false;
          $scope.opcionConsultar3=false;
          $scope.opcionConsultar4 = false;
          $scope.despliegueDeAcciones =false;
          $scope.auditoria=false;
          $scope.registroNoConformidad=false;
          $rootScope.banderaRegristroCausas=false;
          $scope.tablaDeCausas=false;
          $scope.causasParaAcciones=false;
          $scope.despliegueDeCausas = false;
          $scope.depliegueDeCausasOpcionConsulta=false;
          $scope.despliegueDeTablaAccionesOpcionConsulta=false;
          $scope.take4=false;
          $scope.bandera13=false;
          $scope.c1=false;
          $scope.c2=false;
          $scope.takeC1 = false;
          $scope.indicador=false;
          $scope.auditoras=false;
          $scope.opcionRegistrar=undefined;
          $scope.opcionActualizar=undefined;
          $scope.opcionConsultar=undefined;
          $scope.year=undefined;
          $scope.mes=undefined;

        break;
        case 2:
          $scope.consultar=true;
          $scope.actualizar=false;
          $scope.registrar=false;
           $scope.opcionRegistrar1=false;
           $scope.opcionRegistrar2 =false;
           $scope.opcionRegistrar3 =false;
           $scope.opcionRegistrar4=false;
           $scope.opcionConsultar1=false;
           $scope.opcionConsultar2=false;
           $scope.opcionConsultar3=false;
           $scope.opcionConsultar4 = false;
           $scope.banderaActualiNo=false;
           $scope.banderaActualiCa=false;
           $scope.banderaActualiAcc=false;
           $scope.despliegueDeAcciones =false;
           $scope.causaActualizada=false;
          $scope.auditoria=false;
          $scope.registroNoConformidad=false;
          $rootScope.banderaRegristroCausas=false;
          $scope.tablaDeCausas=false;
          $scope.despliegueDeCausas = false;
          $scope.causasParaAcciones=false;
          $scope.depliegueDeCausasOpcionConsulta=false;
          $scope.despliegueDeTablaAccionesOpcionConsulta=false;
          $scope.take4=false;
          $scope.bandera13=false;
          $scope.c1=false;
          $scope.c2=false;
          $scope.takeC1 = false;
          $scope.indicador=false;
          $scope.auditoras=false;
          $scope.opcionRegistrar=undefined;
          $scope.opcionActualizar=undefined;
          $scope.opcionConsultar=undefined;
          $scope.year=undefined;
          $scope.mes=undefined;


        break;
        case 3:
          $scope.registrar=true;
          $scope.consultar=false;
          $scope.actualizar=false;
          $scope.opcionRegistrar1=false;
          $scope.opcionRegistrar2 =false;
          $scope.opcionRegistrar3 =false;
          $scope.opcionRegistrar4=false;
          $scope.opcionConsultar1=false;
          $scope.opcionConsultar2=false;
          $scope.opcionConsultar3=false;
          $scope.opcionConsultar4 = false;
          $scope.auditoria=false;
          $scope.banderaActualiNo=false;
          $scope.banderaActualiCa=false;
          $scope.causaActualizada=false;
          $scope.despliegueDeAcciones =false;
          $scope.banderaActualiAcc=false;
          $scope.registroNoConformidad=false;
          $rootScope.banderaRegristroCausas=false;
          $scope.tablaDeCausas=false;
          $scope.causasParaAcciones=false;
          $scope.despliegueDeCausas = false;
          $scope.depliegueDeCausasOpcionConsulta=false;
          $scope.despliegueDeTablaAccionesOpcionConsulta=false;
          $scope.take4=false;
          $scope.bandera13=false;
          $scope.c1=false;
          $scope.c2=false;
          $scope.takeC1 = false;
          $scope.indicador=false;
          $scope.auditoras=false;
          $scope.opcionRegistrar=undefined;
          $scope.opcionActualizar=undefined;
          $scope.opcionConsultar=undefined;
          $scope.year=undefined;
          $scope.mes=undefined;
        break;

    }
}
$scope.AnalisisDeInfoRegistrar = function(opcionRegistrar){
    switch(opcionRegistrar.id){
            case 1:
            $scope.opcionRegistrar1=true;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.opcionConsultar1=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.banderaActualiAcc=false;
            $scope.causaActualizada=false;
            $scope.despliegueDeAcciones =false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;

            break;

            case 2:
            $scope.opcionRegistrar2=true;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.opcionConsultar1=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.causaActualizada=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;

            case 3:
            $scope.opcionRegistrar3 =true;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar4=false;
            $scope.opcionConsultar1=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.causaActualizada=false;
            $scope.auditoria=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;
            case 4:

            $scope.opcionRegistrar4=true;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionConsultar1=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.despliegueDeAcciones =false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            break;

        }



}
$scope.AnalisisDeInfoConsultar = function(opcionRegistrar){
    switch(opcionRegistrar.id){
            case 1:
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.opcionConsultar1=true;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;

            break;

            case 2:
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.opcionConsultar2=true;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.despliegueDeAcciones =false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.banderaActualiAcc=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;

            case 3:
            $scope.opcionConsultar3=true;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar4=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.despliegueDeCausas = false;
            $scope.tablaDeCausas=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;
            case 4:
            $scope.opcionConsultar4 = true;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiNo=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.despliegueDeCausas = false;
            $scope.tablaDeCausas=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            break;

        }



}
$scope.AnalisisDeInfoActualizar = function(opcionRegistrar){
    switch(opcionRegistrar.id){
            case 1:
            $scope.opcionConsultar4 = false;
            $scope.banderaActualiNo=true;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.opcionConsultar1=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;

            break;

            case 2:
            $scope.banderaActualiNo=false;
            $scope.banderaActualiCa=true;
            $scope.causaActualizada=false;
            $scope.banderaActualiAcc=false;
            $scope.despliegueDeAcciones =false;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.despliegueDeCausas = false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;

            case 3:
            $scope.banderaActualiAcc=true;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiNo=false;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar4=false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones =false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista});

            break;
            case 4:
            $scope.banderaActualiAcc=false;
            $scope.banderaActualiCa=false;
            $scope.causaActualizada=false;
            $scope.banderaActualiNo=false;
            $scope.despliegueDeCausas = false;
            $scope.despliegueDeAcciones =false;
            $scope.opcionConsultar3=false;
            $scope.opcionConsultar4 = false;
            $scope.opcionConsultar2=false;
            $scope.opcionConsultar1=false;
            $scope.opcionRegistrar1=false;
            $scope.opcionRegistrar2=false;
            $scope.opcionRegistrar3 =false;
            $scope.opcionRegistrar4=false;
            $scope.auditoria=false;
            $scope.registroNoConformidad=false;
            $rootScope.banderaRegristroCausas=false;
            $scope.causasParaAcciones=false;
            $scope.tablaDeCausas=false;
            $scope.depliegueDeCausasOpcionConsulta=false;
            $scope.despliegueDeTablaAccionesOpcionConsulta=false;
            $scope.take4=false;
            $scope.bandera13=false;
            $scope.c1=false;
            $scope.c2=false;
            $scope.takeC1 = false;
            $scope.indicador=false;
            $scope.auditoras=false;
            $scope.year=undefined;
            $scope.mes=undefined;
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
$scope.takAcc =function(causaActaCC){
         if("undefined" !== typeof causaActaCC){
             $scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:causaActaCC.id})
             $scope.despliegueDeAcciones = true;

         }


 }

$scope.simpleActualizarII = function(opcionActualizarII){
        if("undefined" !== typeof opcionActualizarII){
            $scope.despliegueDeCausas = true;
            $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:opcionActualizarII.id})
        }
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
$scope.despliegueTablaCausas=function(item){

 if("undefined" !== typeof item){
 $scope.tablaDeCausas=true;
 $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
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
$scope.causa=function(ev,item,noConformidadParaRegistroDeCausas){

    if("undefined" !== typeof item){
        var object ={idContratista:$localStorage.userLogeado.idContratista,causa:item,idNoConformidad:noConformidadParaRegistroDeCausas.id}
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
 $scope.registroDeCausas=function(item){
 if("undefined" !== typeof item){
  $rootScope.noConformidadActual=item;
  $rootScope.banderaRegristroCausas=true;

 }
}
$scope.consultarAuditoria=function(ev,mes,year){
    if("undefined" !== typeof mes && "undefined" !== typeof year){
        $mdDialog.show(
                    $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('A continuación encontrará las auditorias disponibles')
                    .textContent('Si no presentá para este periodo el software no le dejara registrar las no conformidades.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('ok!')
                    .targetEvent(ev)
                );
          $scope.tableAuditorias=auditoriaContratis.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
          $scope.auditoria=true;
           $rootScope.mes=mes;
              $rootScope.year=year;

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
    $scope.registroDeNoConformidades= function(auditoriaElegida){
        $scope.registroNoConformidad = true;

    }
     $scope.simple6=function(item){
        if("undefined" !== typeof item){
         $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
         $scope.depliegueDeCausasOpcionConsulta=true;
         }

      }
      $scope.simple7=function(item){
        if("undefined" !== typeof item){
        $scope.tableAcciones=accionContra.query({idContratista:$localStorage.userLogeado.idContratista,idCausa:item.id})
        $scope.despliegueDeTablaAccionesOpcionConsulta=true;
        }
       }
       $scope.simpleActualizar = function(opcionActualizar){
          $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:opcionActualizar.id})
          $scope.causaActualizada =true;

         }
    $scope.registrarNoConformidad = function(ev,textInput,auditoriaElegida){
        if("undefined" !== typeof textInput){
            var object ={idContratista:$localStorage.userLogeado.idContratista,noConformidad:textInput,mes:$rootScope.mes.name,year:$rootScope.year.name,idAuditoria:auditoriaElegida.id}
           noConformidad.save(object);
           $scope.textInput = "";
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


    $scope.despliegueDeCausasParaAcciones = function(item){

        if("undefined" !== typeof item){
            $scope.tablaDeCausas=caPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id})
            $scope.causasParaAcciones=true;
        }

    }
     $scope.despliegueDeInput=function(item){
         if("undefined" !== typeof item){
            $scope.inputRegistroDeAccion=true;
            }


     }
      $scope.ocultarTodo=function(){
       $scope.indiCierre=false;
       $scope.auditoria=false

      }
      $scope.consultarAuditoria2=function(mes,year){
          $scope.tableContra=auditoriaContratis.query({idContratista:$localStorage.userLogeado.idContratista,mes:mes.name,year:year.name});
          $scope.auditoras=true;


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


      $scope.salvarAccion = function(op,accion,ev){
       if("undefined" !== typeof accion && "undefined" !== typeof op){
        var accion ={idContratista:$localStorage.userLogeado.idContratista,idCausa:op.id,nombre:accion}
         registroDeAccion.save(accion);
         $route.reload();
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
              $route.reload();
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
                console.log(file) ;
                console.log(op.id);
                console.log(item.id);

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
           $scope.cambiarOpcion =function(item){

                $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$localStorage.userLogeado.idContratista,idAuditoria:item.id});
                $scope.listadoNoConforCerradas=noConforCerradasConAuditoria.query({idContratista:$localStorage.userLogeado.idContratista,idAuditoria:item.id});
                $scope.indiCierre=true;



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