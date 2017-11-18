'use strict';

angular.module('myApp.gestionAuditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionAuditoria', {
    templateUrl: 'gestionAuditoria/gestionAuditoria.html',
    controller: 'gestionAuditoriaCtrl'
  });
}])

.controller('gestionAuditoriaCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','contratosEnEjecucion','finalesDefinitivos','auditoriaContratis','noPorContraAuditoria','caPorContra','accionContra','noConforCerradasConAuditoria','accionConRegistro','accionSinRegistro',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,contratosEnEjecucion,finalesDefinitivos,auditoriaContratis,noPorContraAuditoria,caPorContra,accionContra,noConforCerradasConAuditoria,accionConRegistro,accionSinRegistro) {
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
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante});
$scope.flag=false
$scope.auditorias=false;
$scope.banOpciones=false;
$scope.op1=false;
$scope.op2=false;
$scope.op3=false;
$scope.op4=false;
$scope.causas=false;
$scope.cau=true;
$scope.indicador=false;
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
  { id: 1, name: 'CONSULTAR NO CONFORMIDADES'},
  { id: 2, name: 'CONSULTAR CAUSAS'},
  { id: 3, name: 'CONSULTAR ACCIONES'},
  {id: 4, name:'CUMPLIMIENTO DE PROGRAMA'},

 ];
 $scope.opcionesDeCumplimiento=[
  { id: 1, name: 'INDICADOR DE CUMPLIMIENTO DE ACCIONES'},
  { id: 2, name: 'INDICADOR DE CIERRE DE NO CONFORMIDADES'},

 ];
 $scope.ocultarTodo=function(){
         $scope.flag=false;
        $scope.banOpciones=false;
        $scope.auditorias=false;
 }

 $scope.add=function(ev,contrato,mes,year){
     if("undefined" !== typeof contrato && "undefined" !== typeof year && "undefined" !== typeof mes){
     $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato})

     $scope.flag=true;
     $rootScope.idCategoria=$scope.idCategoria
     $rootScope.idContrato=$scope.idContrato
     }
     else{
         $mdDialog.show(
             $mdDialog.alert()
               .parent(angular.element(document.querySelector('#popupContainer')))
               .clickOutsideToClose(true)
               .title('Hubo un error')
               .textContent('alguno de los datos se ecuentra sin escoger.')
               .ariaLabel('Alert Dialog Demo')
               .ok('intente de nuevo!')
               .targetEvent(ev)
         );

     }

 }
 $scope.desplieguedeAuditora= function(item,mes,year){
    console.log(item);
    $scope.tableContra=auditoriaContratis.query({idContratista:item.id,mes:mes.name,year:year.name});
    $rootScope.item=item;
    $scope.auditorias=true;
    $scope.banOpciones=false;
 }
 $scope.cambiarOpcion=function(auditoria){
    $scope.banOpciones=true;
    $rootScope.auditoria=auditoria;
 }
 $scope.changeOp=function(opcion){
    switch(opcion.id){
        case 1:
            $scope.op1=true;
            $scope.op2=false;
            $scope.op3=false;
            $scope.op4=false;
            $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
            $scope.causas=false;
            $scope.cau=false;
            $scope.acciones=false;
            $scope.causas2 =false;
            $scope.indicador=false;
        break;
        case 2:
            $scope.op1=false;
            $scope.op2=true;
            $scope.op3=false;
            $scope.op4=false;
            $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
            $scope.causas=false;
            $scope.cau=false;
            $scope.acciones=false;
            $scope.causas2 =false;
            $scope.indicador=false;
        break;
        case 3:
            $scope.op1=false;
            $scope.op2=false;
            $scope.op3=true;
            $scope.op4=false;
            $scope.causas=false;
            $scope.cau=false;
            $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
            $scope.acciones=false;
            $scope.causas2 =false;
            $scope.indicador=false;
        break;
        case 4:
            $scope.op1=false;
            $scope.op2=false;
            $scope.op3=false;
            $scope.op4=true;
            $scope.causas=false;
            $scope.cau=false;
            $scope.acciones=false;
            $scope.causas2 =false;
            $scope.indicador=false;
        break;
    }
 }

 $scope.despliegueDeNoConformidades=function(noConformidad){
     if("undefined" !== typeof noConformidad){
     $scope.causas=true;
     $scope.tablaDeCausas=caPorContra.query({idContratista:$rootScope.item.id,idNoConformidad:noConformidad.id})
     $scope.acciones=false;
     $scope.causas2 =false;
     $scope.indicador=false;
     }

 }
 $scope.desCausa=function(noConformidad){
    if("undefined" !== typeof noConformidad){
         $scope.cau=true;
         $scope.tablaDeCausas=caPorContra.query({idContratista:$rootScope.item.id,idNoConformidad:noConformidad.id})
          $scope.acciones=false;
          $scope.causas2 =false;
          $scope.indicador=false;

         }
 }
 $scope.desplegarAcciones=function(causa){
    if("undefined" !== typeof causa){
        $scope.tableAcciones=accionContra.query({idContratista:$rootScope.item.id,idCausa:causa.id})
        $scope.acciones=true;
        $scope.causas2 =false;

     }


 }
 $scope.cambiarDeOpCionC=function(opcionC){
    switch(opcionC.id){

            case 1:
             $scope.c1=true;
             $scope.c2=false;
             $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
             $scope.causas2 =false;
             $scope.indicador=false;
             $scope.grafico=false;
             $scope.grafico2=true;
            break;
            case 2:
            $scope.c1=false;
            $scope.c2=true;
            $scope.listadoDeNoConformidades=noPorContraAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
            $scope.listadoNoConforCerradas=noConforCerradasConAuditoria.query({idContratista:$rootScope.item.id,idAuditoria:$rootScope.auditoria.id});
            $scope.causas2 =false;
            $scope.indicador=false;
            $scope.grafico=false;
            $scope.grafico2=true;
            break;


          }



 }
 $scope.desplegarCausasDeIndicadores=function(noConformidad){
    $scope.causas2 =true;
    $scope.tablaDeCausas=caPorContra.query({idContratista:$rootScope.item.id,idNoConformidad:noConformidad.id})
    $scope.indicador=false;
 }
 $scope.accionesCausales =function(op10){
     if("undefined" !== typeof op10){
            $scope.accionConRegistro=accionConRegistro.query({idContratista:$rootScope.item.id,idCausa:op10.id});
            $scope.accionSinRegistro=accionSinRegistro.query({idContratista:$rootScope.item.id,idCausa:op10.id});
            $scope.indicador=true;
            $scope.grafico=false;
            $scope.grafico2=false;

     }

}
$scope.displayMap=function(a,b){
$scope.myChartObject = {};
    $scope.myChartObject.type = "Gauge";

    $scope.myChartObject.options = {
      width: 200,
      height: 200,
      redFrom: 90,
      redTo: 100,
      yellowFrom: 75,
      yellowTo: 90,
      minorTicks: 5
    };

    $scope.myChartObject.data = [
      ['Label', 'Value '],
      ['INDICADOR%', Math.round(a)]

    ];
    if (b==1){
    $scope.grafico = true;
    $scope.grafico2=false;
    }
    else{
    $scope.grafico2=true;
    $scope.grafico=false;

    }

 }


}]);