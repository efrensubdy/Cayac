'use strict';

angular.module('myApp.gestionDeAccidentes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/gestionDeAccidentes', {
    templateUrl: 'gestionDeAccidentes/gestionDeAccidentes.html',
    controller: 'gestionDeAccidentesCtrl'
  });
}])

.controller('gestionDeAccidentesCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','finalesDefinitivos','contratosEnEjecucion','accPorContra','$mdDialog',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,finalesDefinitivos,contratosEnEjecucion,accPorContra,$mdDialog) {
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
$scope.flag=false
$scope.bandera3=false
$scope.ocultarTodo=function(){
    $scope.flag=false;
    $scope.bandera3=false;
}
 $scope.closeModel= function(){
                   document.getElementById('id01').style.display='none';
           }
$scope.listado=contratosEnEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
},function(err){

$scope.bandera01 = true;
 document.getElementById('id01').style.display='block';

});
$scope.add=function(ev,contrato){
                if("undefined" !== typeof contrato){
                $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:contrato},function(list){

                },function(err){
                    $scope.bandera01 = true;
                    document.getElementById('id01').style.display='block';


                });
                $scope.flag=true;
                $scope.bandera3=false;
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

$scope.traerAccidentes=function(client){
$rootScope.client=client;
$scope.accidentes=accPorContra.query({idContratista:client.id,idContratante:$localStorage.contratanteLogeado.idContratante},function(list){
    if (list.length==0){
     $scope.bandera02 = true;
     document.getElementById('id02').style.display='block'
     }
},function(err){

    $scope.bandera01 = true;
    document.getElementById('id01').style.display='block'

});
$scope.bandera3=true;



}
$scope.showAlert=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleDeAccidente.html',
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