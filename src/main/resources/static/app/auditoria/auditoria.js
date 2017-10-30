'use strict';

angular.module('myApp.auditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/auditoria', {
    templateUrl: 'auditoria/auditoria.html',
    controller: 'auditoriaCtrl'
  });
}])

.controller('auditoriaCtrl', ['$http','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','auditoriaContratis','noConformidad','noPorContra','causa','caPorContra','fileUpload','accionContra','registroDeAccion','accionConRegistro','accionSinRegistro','cierre',function($http,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,auditoriaContratis,noConformidad,noPorContra,causa,caPorContra,fileUpload,accionContra,registroDeAccion,accionConRegistro,accionSinRegistro,cierre) {
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

var q=function(idNoConformidad, idContratista){
                      //var url= "http://localhost:8080/app/cierre/isClose/"+idNoConformidad+"/"+idContratista;
                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/cierre/isClose/"+idNoConformidad+"/"+idContratista;
                      console.log(url);
                       var a;
                    a=$http.get(url).then(function(response) {
                                    $scope.objeto= response.data;
                                    console.log(response.data);
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
            break;
            case 2:
            $scope.bandera1=false;
            $scope.bandera2=true;
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

        break;
        case 2:
        $scope.c1=false;
        $scope.c2=true;
         $scope.takeC1 = false;
         $scope.indicador=false;
        break;


      }


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
 $scope.simple2= function(item){
 console.log(item);
 if("undefined" !== typeof item){
 $rootScope.noConformidadActual=item;
 $rootScope.bandera9=true;
 }

 }
 $scope.simple3=function(item){
 console.log(item);
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
        console.log(uploadUrl);
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

$scope.cerrarNoConformidad=function(item){
    console.log(item);
    var cie ={idContratista:$localStorage.userLogeado.idContratista,idNoConformidad:item.id};
    cierre.save(cie);


}
 $scope.causa=function(ev,item){
 console.log(item);
    if("undefined" !== typeof item){
        var object ={idContratista:$localStorage.userLogeado.idContratista,causa:item,idNoConformidad:$rootScope.noConformidadActual.id}
        causa.save(object);
        $mdDialog.show({
                              //Controlador del mensajes con operaciones definido en la parte de abajo
                              controller: DialogController,
                               //permite la comunicacion con el html que despliega el boton requisitos
                               templateUrl: 'test/mensajeDeca.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                               fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                  })

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
 $rootScope.text='';



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
    $scope.textArea="mnnbnbjhgjguytuttytu";
    console.log($scope.textArea)
    if("undefined" !== typeof textArea){
    var object ={idContratista:$localStorage.userLogeado.idContratista,noConformidad:textArea,mes:$rootScope.mes.name,year:$rootScope.year.name,idAuditoria:$rootScope.item.id}
    noConformidad.save(object);

    console.log(object)
    textArea='';
     $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController,
                       //permite la comunicacion con el html que despliega el boton requisitos
                       templateUrl: 'test/mensajeDeNo.html',
                       parent: angular.element(document.body),
                       targetEvent: ev,
                       clickOutsideToClose:true,
                       fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
          })

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
                            
                          };

        $scope.cancel2 = function() {
                                   $mdDialog.cancel();
                                   $rootScope.bandera9=false;

                                 };


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