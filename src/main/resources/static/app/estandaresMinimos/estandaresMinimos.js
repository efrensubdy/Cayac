'use strict';

angular.module('myApp.estandaresMinimos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/estandaresMinimos', {
    templateUrl: 'estandaresMinimos/estandaresMinimos.html',
    controller: 'estandaresMinimosCtrl'
  });
}])

.controller('estandaresMinimosCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','estandar','estContr',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,estandar,estContr) {
$scope.bandera1=false;
$scope.bandera2=false;
$scope.opciones=[
 { id: 1, name: 'AGREGAR ESTANDARES'},
 { id: 2, name: 'CONSULTAR ESTANDARES'},

];

$scope.simple2 = function(item){
   switch(item.id){
        case 1:
        $scope.bandera1=true;
        $scope.bandera2=false;

        break;
        case 2:
        $scope.bandera1=false;
        $scope.bandera2=true;
        $scope.listadoEstandaresMinimos=estContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante})
        break;

   }


}
$scope.add =function(ev,recursos,capacitacion,politica,objetivos,evaInicial,planAnual,documen,cuentas,normatividad,mecanismos,adquisiones,contrataciones,cambios,condiciones,registro,vigilancia,peligros,prevencion,planPrevencion,gestion,accionesPreven){

if ("undefined" !== typeof recursos && "undefined" !== typeof capacitacion && "undefined" !== typeof politica && "undefined" !== typeof objetivos && "undefined" !== typeof evaInicial && "undefined" !== typeof planAnual && "undefined" !== typeof documen && "undefined" !== typeof cuentas && "undefined" !== typeof normatividad && "undefined" !== typeof mecanismos && "undefined" !== typeof adquisiones && "undefined" !== typeof contrataciones && "undefined" !== typeof cambios && "undefined" !== typeof condiciones && "undefined" !== typeof registro && "undefined" !== typeof vigilancia && "undefined" !== typeof peligros && "undefined" !== typeof prevencion && "undefined" !== typeof planPrevencion && "undefined" !== typeof gestion && "undefined" !== typeof accionesPreven){
    if(recursos <= 4 && capacitacion <= 6 && politica <= 1 && objetivos <= 1 && evaInicial <= 1 && planAnual <= 2 && documen <= 2 && cuentas <= 1 && normatividad <= 2 && mecanismos <= 1  && adquisiones <= 1 &&  contrataciones <= 2 && cambios <= 1 && condiciones <= 9 && registro <= 5 && vigilancia <= 6 && peligros <= 15 && prevencion <= 15 && planPrevencion <= 10  && gestion <= 5 && accionesPreven <= 10 ){
        var estandarMin={"recursos":recursos,"capacitacion":capacitacion,"politica":politica,"objetivos":objetivos,"evaInicial":evaInicial,"planAnual":planAnual,"documen":documen,"cuentas":cuentas,"normatividad":normatividad,"mecanismos":mecanismos,"adquisiones":adquisiones,"contrataciones":contrataciones,"cambios":cambios,"condiciones":condiciones,"registro":registro,"vigilancia":vigilancia,"peligros":peligros,"prevencion":prevencion,"planPrevencion":planPrevencion,"gestion":gestion,"accionesPreven":accionesPreven,"idContratista":$localStorage.userLogeado.idContratista,"idContratante":$localStorage.userLogeado.idContratante}
        estandar.save(estandarMin);
        $mdDialog.show(
                $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .clickOutsideToClose(true)
                .title('Registro de Estandares mínimos Completo')
                .textContent('Podra revisar este estandar en la siguiente pestaña.')
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
       .title('Los Campos han sido Registrados con porcentajes incorrectos')
       .textContent('Repita el proceso fijandose en los porcentajes.')
       .ariaLabel('Alert Dialog Demo')
       .ok('ok!')
       .targetEvent(ev)
                           );
        }

    $scope.recursos='';
                   $scope.capacitacion='';
                   $scope.politica='';
                   $scope.objetivos='';
                   $scope.evaInicial='';
                   $scope.planAnual='';
                   $scope.documen='';
                   $scope.cuentas='';
                   $scope.normatividad='';
                   $scope.mecanismos ='';
                   $scope.adquisiones ='';
                   $scope.contrataciones='';
                   $scope.cambios='';
                   $scope.condiciones='';
                   $scope.registro='';
                   $scope.vigilancia='';
                   $scope.peligros='';
                   $scope.prevencion='';
                   $scope.planPrevencion='';
                   $scope.gestion='';
                   $scope.accionesPreven='';

    }
else{

$mdDialog.show(
             $mdDialog.alert()
               .parent(angular.element(document.querySelector('#popupContainer')))
               .clickOutsideToClose(true)
               .title('Hay algún dato erroneo')
               .textContent('llene todos los campos e intente de nuevo.')
               .ariaLabel('Alert Dialog Demo')
               .ok('ok!')
               .targetEvent(ev)
                           );
               $scope.recursos='';
               $scope.capacitacion='';
               $scope.politica='';
               $scope.objetivos='';
               $scope.evaInicial='';
               $scope.planAnual='';
               $scope.documen='';
               $scope.cuentas='';
               $scope.normatividad='';
               $scope.mecanismos ='';
               $scope.adquisiones ='';
               $scope.contrataciones='';
               $scope.cambios='';
               $scope.condiciones='';
               $scope.registro='';
               $scope.vigilancia='';
               $scope.peligros='';
               $scope.prevencion='';
               $scope.planPrevencion='';
               $scope.gestion='';
               $scope.accionesPreven='';



}

}
$scope.showAlert=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleDeEstandar.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                     clickOutsideToClose:true,
                     fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })

          }

 function DialogController2($scope, $mdDialog, $rootScope){
            $scope.client= $rootScope.client;

            $scope.hide = function() {
                         $mdDialog.hide();
                       };
                       //funcion para cerral el mensaje
             $scope.cancel = function() {
                         $mdDialog.cancel();
                       };




  }


}]);