'use strict';

angular.module('myApp.view12', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view12', {
    templateUrl: 'view12/view12.html',
    controller: 'View12Ctrl'
  });
}])

.controller('View12Ctrl', ['$localStorage','$sessionStorage','$mdDialog','$rootScope','$scope','finalesDefinitivos','contratos',function($localStorage,$sessionStorage,$mdDialog,$rootScope,$scope,finalesDefinitivos,contratos) {

 $scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        $scope.seleccionados=[];
        $scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
         $scope.add=function(){

                        $scope.listado=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato});

                        $scope.flag=true;

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