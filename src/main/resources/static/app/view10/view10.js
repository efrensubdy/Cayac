'use strict';

angular.module('myApp.view10', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view10', {
    templateUrl: 'view10/view10.html',
    controller: 'View10Ctrl'
  });
}])

.controller('View10Ctrl', ['$location','$localStorage','$sessionStorage','rExtra','rObligatorio','$http','$scope','$rootScope','$mdDialog','serviciosConContratista','contratantesContrato','rCumplidos','rExtras','rNoCumplidos','rExtrasNC','pFinales','finalistas',function($location,$localStorage,$sessionStorage,rExtra,rObligatorio,$http,$scope,$rootScope,$mdDialog,serviciosConContratista,contratantesContrato,rCumplidos,rExtras,rNoCumplidos,rExtrasNC,pFinales,finalistas) {
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
        $scope.listado=serviciosConContratista.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        $scope.loadContratos=function(){
              $scope.listado=serviciosConContratista.query({idContratante:$localStorage.contratanteLogeado.idContratante})
        }
        $scope.flag=false;
        $scope.seleccionados=[];
        $scope.propertyName = 'cumplidos';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
        $scope.add=function(ev,contrato){
                if("undefined" !== typeof contrato){

                $scope.listillo=pFinales.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato.id})
               $rootScope.idContrato=$scope.contrato;
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


         $scope.showAlert = function(ev,client) {

           $rootScope.listado2=rCumplidos.query({idContratista:client.id,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listado3=rExtras.query({idContratista:client.id,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listado4=rNoCumplidos.query({idContratista:client.id,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listado5=rExtrasNC.query({idContratista:client.id,idCategoria:client.idCategoria,idContratante:$localStorage.contratanteLogeado.idContratante});
           $rootScope.listadoAS=rObligatorio.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:client.idCategoria});
           $rootScope.listadoAE=rExtra.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:client.idCategoria});
           $rootScope.cliente=client;
           $mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
             controller: DialogController,
             //permite la comunicacion con el html que despliega el boton requisitos
             templateUrl: 'test/test2.html',
             parent: angular.element(document.body),
             targetEvent: ev,
             clickOutsideToClose:true,
                                 fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                               })


         }



         function DialogController($scope, $mdDialog, $rootScope, $http) {
          $scope.listado2=$rootScope.listado2;
          $scope.listado3=$rootScope.listado3;
          $scope.listado4=$rootScope.listado4;
          $scope.listado5=$rootScope.listado5;
          $scope.listadoAS=$rootScope.listadoAS
          $scope.listadoAE=$rootScope.listadoAE
          $scope.extension=function(item){
                //q();
                console.log(item.idContratista,item.id)
          }
          var q=function(idContratista,idRequisitoSugerido){
                       //var url= "http://localhost:8080/app/imagenes/"+idContratista+"/"+idRequisitoSugerido ;
                       var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/imagenes/"+idContratista+"/"+idRequisitoSugerido ;
                       $http.get(url).then(function(response) {
                                     $scope.extension=response.data;

                                     return response.data;
                                  })
                          }
          $scope.hide = function() {
                       $mdDialog.hide();
                     };
                     //funcion para cerral el mensaje
           $scope.cancel = function() {
                       $mdDialog.cancel();
                     };
           $scope.hideGrafico=function(){
                      $scope.bandera=false;

           }
           $scope.agregarFinalista=function(ev){

                 var finalista={idContratista:$rootScope.cliente.id,idContrato:$rootScope.idContrato.id}
                 finalistas.save(finalista);
                  $mdDialog.show(
                     $mdDialog.alert()
                     .parent(angular.element(document.querySelector('#popupContainer')))
                     .clickOutsideToClose(true)
                     .title('Finalista agregado Satisfactoriamente')
                     .textContent('El Contratista estará disponible para agregarle un proyecto.')
                     .ariaLabel('Alert Dialog Demo')
                     .ok('mire sus Finalista!')
                     .targetEvent(ev)

                  );
           }



          $scope.agregar=function(b,c){

                     $scope.bandera=true;
                     $scope.myChartObject = {};


                      $scope.myChartObject.type = "PieChart";

                      $scope.myChartObject.data = {"cols": [
                          {id: "t", label: "Topping", type: "string"},
                          {id: "s", label: "Slices", type: "number"}
                      ], "rows": [

                          {c: [
                              {v: "Cumplidos"},
                              {v: b},
                          ]},
                          {c: [
                              {v: "No Cumplidos"},
                              {v: c},
                          ]}
                      ]};

                      $scope.myChartObject.options = {
                          'title': 'Estadisticas'
                      };



          }

         }


}]);