'use strict';

angular.module('myApp.estandaresMinimos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/estandaresMinimos', {
    templateUrl: 'estandaresMinimos/estandaresMinimos.html',
    controller: 'estandaresMinimosCtrl'
  });
}])

.controller('estandaresMinimosCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','$route','estandar','estContr','actualizarEstandar',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,$route,estandar,estContr,actualizarEstandar) {
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
$scope.bandera1=false;
$scope.bandera2=false;
$scope.opciones=[
 { id: 1, name: 'AGREGAR ESTANDAR'},
 { id: 2, name: 'CONSULTAR ESTANDAR'},
 { id: 3, name: 'ACTUALIZAR ESTANDAR'}

];

$scope.simple2 = function(item){
   switch(item.id){
        case 1:
        $scope.bandera1=true;
        $scope.bandera2=false;
        $scope.bandera3=false

        break;
        case 2:
        $scope.bandera1=false;
        $scope.bandera2=true;
        $scope.bandera3=false
        $scope.listadoEstandaresMinimos=estContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante})
        break;
        case 3:
        $scope.bandera1=false;
        $scope.bandera2=false;
        $scope.bandera3=true
        $scope.listadoDeActualizaciones=estContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante})

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
 $scope.showAlert2=function(ev,client){
             $rootScope.client=client
             $mdDialog.show({
                   //Controlador del mensajes con operaciones definido en la parte de abajo
                   controller: DialogController,
                    //permite la comunicacion con el html que despliega el boton requisitos
                     templateUrl: 'test/actualiEstandar.html',
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
  function DialogController($scope, $mdDialog, $rootScope){
              $scope.client= $rootScope.client;

              $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
               $scope.cancel = function() {
                           $mdDialog.cancel();
                         };

               $scope.add = function(ev,recursos,capacitacion,politica,objetivos,evaInicial,planAnual,documen,cuentas,normatividad,mecanismos,adquisiones,contrataciones,cambios,condiciones,registro,vigilancia,peligros,prevencion,planPrevencion,gestion,accionesPreven,client){
                   if ("undefined" == typeof recursos && "undefined" == typeof capacitacion && "undefined" == typeof politica && "undefined" == typeof objetivos && "undefined" == typeof evaInicial && "undefined" == typeof planAnual && "undefined" == typeof documen && "undefined" == typeof cuentas && "undefined" == typeof normatividad && "undefined" == typeof mecanismos && "undefined" == typeof adquisiones && "undefined" == typeof contrataciones && "undefined" == typeof cambios && "undefined" == typeof condiciones && "undefined" == typeof registro && "undefined" == typeof vigilancia && "undefined" == typeof peligros && "undefined" == typeof prevencion && "undefined" == typeof planPrevencion && "undefined" == typeof gestion && "undefined" == typeof accionesPreven){
                        $mdDialog.show(
                                                  $mdDialog.alert()
                                                    .parent(angular.element(document.querySelector('#popupContainer')))
                                                    .clickOutsideToClose(true)
                                                    .title('Debe modificar al menos un dato')
                                                    .textContent('Recuerde llenar los campos necesarios.')
                                                    .ariaLabel('Alert Dialog Demo')
                                                    .ok('intente de nuevo!')
                                                    .targetEvent(ev)
                                                                    );
                   }
                    else{

                    var estandar = new EstandarMinimo();
                    console.log(client);
                    estandar.id = client.id
                    estandar.idContratista= $localStorage.userLogeado.idContratista;
                    estandar.idContratante= $localStorage.userLogeado.idContratante;
                    if (recursos == client.recursos || "undefined" == typeof recursos ){

                          estandar.recursos =client.recursos
                     }
                     else{

                         estandar.recursos=recursos
                     }
                     if (capacitacion == client.capacitacion || "undefined" == typeof capacitacion ){

                           estandar.capacitacion =client.capacitacion
                      }
                      else{

                          estandar.capacitacion=capacitacion
                      }
                      if (politica == client.politica || "undefined" == typeof politica ){

                             estandar.politica =client.politica
                        }
                        else{

                            estandar.politica=politica
                        }
                     if (objetivos == client.objetivos || "undefined" == typeof objetivos ){

                          estandar.objetivos =client.objetivos
                     }
                     else{

                         estandar.objetivos=objetivos
                     }
                      if (evaInicial == client.evaInicial || "undefined" == typeof evaInicial ){

                           estandar.evaInicial =client.evaInicial
                      }
                      else{

                          estandar.evaInicial=evaInicial
                      }
                      if (planAnual == client.planAnual || "undefined" == typeof planAnual ){

                             estandar.planAnual =client.planAnual
                        }
                        else{

                            estandar.planAnual=planAnual
                        }
                     if (documen == client.documen || "undefined" == typeof documen ){

                          estandar.documen =client.documen
                     }
                     else{

                         estandar.documen=documen
                     }
                     if (cuentas == client.cuentas || "undefined" == typeof cuentas ){

                           estandar.cuentas =client.cuentas
                      }
                      else{

                          estandar.cuentas=cuentas
                      }
                     if (normatividad == client.normatividad || "undefined" == typeof normatividad ){

                            estandar.normatividad =client.normatividad
                       }
                       else{

                           estandar.normatividad=normatividad
                       }
                      if (mecanismos == client.mecanismos || "undefined" == typeof mecanismos ){

                              estandar.mecanismos =client.mecanismos
                         }
                         else{

                             estandar.mecanismos=mecanismos
                         }
                      if (adquisiones == client.adquisiones || "undefined" == typeof adquisiones ){

                            estandar.adquisiones =client.adquisiones
                       }
                       else{

                           estandar.adquisiones=adquisiones
                       }
                       if (contrataciones == client.contrataciones || "undefined" == typeof contrataciones ){

                               estandar.contrataciones =client.contrataciones
                          }
                          else{

                              estandar.contrataciones=contrataciones
                          }
                        if (cambios == client.cambios || "undefined" == typeof cambios ){

                              estandar.cambios =client.cambios
                         }
                         else{

                             estandar.cambios=cambios
                         }
                         if (condiciones == client.condiciones || "undefined" == typeof condiciones ){

                               estandar.condiciones =client.condiciones
                          }
                          else{

                              estandar.condiciones=condiciones
                          }
                          if (registro == client.registro || "undefined" == typeof registro ){

                                 estandar.registro =client.registro
                            }
                            else{

                                estandar.registro=registro
                            }
                           if (vigilancia == client.vigilancia || "undefined" == typeof vigilancia ){

                                   estandar.vigilancia =client.vigilancia
                              }
                              else{

                                  estandar.vigilancia=vigilancia
                              }
                          if (peligros == client.peligros || "undefined" == typeof peligros ){

                                 estandar.peligros =client.peligros
                            }
                            else{

                                estandar.peligros=peligros
                            }
                         if (prevencion == client.prevencion || "undefined" == typeof prevencion ){

                              estandar.prevencion =client.prevencion
                         }
                         else{

                             estandar.prevencion=prevencion
                         }
                         if (planPrevencion == client.planPrevencion || "undefined" == typeof planPrevencion ){

                               estandar.planPrevencion =client.planPrevencion
                          }
                          else{

                              estandar.planPrevencion=planPrevencion
                          }
                          if (gestion == client.gestion || "undefined" == typeof gestion ){

                                 estandar.gestion =client.gestion
                            }
                            else{

                                estandar.gestion=gestion
                            }
                          if (accionesPreven == client.accionesPreven || "undefined" == typeof accionesPreven ){

                               estandar.accionesPreven =client.accionesPreven
                          }
                          else{

                              estandar.accionesPreven=accionesPreven
                          }
                     console.log(estandar);
                     $mdDialog.show(
                                           $mdDialog.alert()
                                              .parent(angular.element(document.querySelector('#popupContainer')))
                                              .clickOutsideToClose(true)
                                              .title('Exito !!')
                                              .textContent('Puede revisar nuevamente o consultar sus Estandares.')
                                              .ariaLabel('Alert Dialog Demo')
                                              .ok('ok!')
                                              .targetEvent(ev)
                                                              );
                     actualizarEstandar.save(estandar);
                     $route.reload();



                     }



                    }





    }
    function EstandarMinimo(){



     }


}]);