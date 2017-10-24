'use strict';

angular.module('myApp.auditoria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/auditoria', {
    templateUrl: 'auditoria/auditoria.html',
    controller: 'auditoriaCtrl'
  });
}])

.controller('auditoriaCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','auditoriaContratis','noConformidad','noPorContra',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,auditoriaContratis,noConformidad,noPorContra) {

$scope.bandera1=false;
$scope.bandera2=false;
$scope.bandera3=false;
$scope.bandera4=false;
$scope.bandera5=false;
$scope.bandera6=false;
$scope.bandera7=false;
$rootScope.bandera8=false;

$scope.opciones=[
 { id: 1, name: 'REGISTRAR NO CONFORMIDADES'},
 { id: 2, name: 'REGISTRAR CAUSAS'},
 { id: 3, name: 'REGISTRAR ACCIONES'},
 { id: 4, name: 'CONSULTAR NO CONFORMIDADES'},
 { id: 5, name: 'CONSULTAR CAUSAS'},
 { id: 6, name: 'CONSULTAR ACCIONES'},

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
            $scope.listadoDeNoConformidades=noPorContra.query({idContratista:$localStorage.userLogeado.idContratista})

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
            break;
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



 }


}]);