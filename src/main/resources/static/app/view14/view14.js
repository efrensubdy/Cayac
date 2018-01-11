'use strict';

angular.module('myApp.view14', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view14', {
    templateUrl: 'view14/view14.html',
    controller: 'View14Ctrl'
  });
}])

.controller('View14Ctrl', ['$location','$localStorage','$sessionStorage','$scope','$rootScope','$http','$mdDialog','contratantesContrato','pFinales','serviciosConContratista',function($location,$localStorage,$sessionStorage,$scope,$rootScope,$http,$mdDialog,contratantesContrato,pFinales,serviciosConContratista) {
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

 $scope.listado=serviciosConContratista.query({idContratante:$localStorage.contratanteLogeado.idContratante});
 $scope.flag=false;
 $scope.propertyName = 'nombreEmpresa';
          $scope.reverse = true;
          $scope.sortBy = function(propertyName) {
              $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
              $scope.propertyName = propertyName;
            };
 $scope.add=function(ev,contrato){
if("undefined" !== typeof contrato){
 $scope.listado2=pFinales.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato.id})
 $scope.flag=true;
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
 $scope.loadContratos=function(){
      $scope.listado=serviciosConContratista.query({idContratante:$localStorage.contratanteLogeado.idContratante});
 }
 $scope.ocultarTodo=function(){
     $scope.flag=false;

 }
 $scope.closeModel= function(){
             document.getElementById('id01').style.display='none';
           }

 $scope.showAlert2=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/test1.html',
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