'use strict';

angular.module('myApp.estandaresMinimos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/estandaresMinimos', {
    templateUrl: 'estandaresMinimos/estandaresMinimos.html',
    controller: 'estandaresMinimosCtrl'
  });
}])

.controller('estandaresMinimosCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog) {
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

        break;

   }


}
$scope.add =function(ev,recursos,capacitacion,politica,objetivos,evaInicial,planAnual,documen,cuentas,normatividad,mecanismos,adquisiones,contrataciones,cambios,condiciones,registro,vigilancia,peligros,prevencion,planPrevencion,gestion,accionesPreven){

if ("undefined" !== typeof recursos && "undefined" !== typeof capacitacion && "undefined" !== typeof politica && "undefined" !== typeof objetivos && "undefined" !== typeof evaInicial && "undefined" !== typeof planAnual && "undefined" !== typeof documen && "undefined" !== typeof cuentas && "undefined" !== typeof normatividad && "undefined" !== typeof mecanismos && "undefined" !== typeof adquisiones && "undefined" !== typeof contrataciones && "undefined" !== typeof cambios && "undefined" !== typeof condiciones && "undefined" !== typeof registro && "undefined" !== typeof vigilancia && "undefined" !== typeof peligros && "undefined" !== typeof prevencion && "undefined" !== typeof planPrevencion && "undefined" !== typeof gestion && "undefined" !== typeof accionesPreven){

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

}]);