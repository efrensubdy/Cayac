'use strict';

angular.module('myApp.analisisDeActividades', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/analisisDeActividades', {
    templateUrl: 'analisisDeActividades/analisisDeActividades.html',
    controller: 'analisisDeActividadesCtrl'
  });
}])

.controller('analisisDeActividadesCtrl', ['$localStorage','$sessionStorage','$scope','$rootScope','$mdDialog','contratos','finalesDefinitivos','estadoDinamicosPreviosSugeridos','estadoDinamicosPreviosExtras','estadoDinamicosEjecucionSugeridos','estadoDinamicosEjecucionExtras','estadoDinamicosFinalizacionSugeridos','estadoDinamicosFinalizacionExtras','traerActividadesPreviasSug','traerActividadesPreviasExt','traerActividadesEjecSug','traerActividadesEjecExt','traerActividadesFinalSug','traerActividadesFinalExt',function($localStorage,$sessionStorage,$scope,$rootScope,$mdDialog,contratos,finalesDefinitivos,estadoDinamicosPreviosSugeridos,estadoDinamicosPreviosExtras,estadoDinamicosEjecucionSugeridos,estadoDinamicosEjecucionExtras,estadoDinamicosFinalizacionSugeridos,estadoDinamicosFinalizacionExtras,traerActividadesPreviasSug,traerActividadesPreviasExt,traerActividadesEjecSug,traerActividadesEjecExt,traerActividadesFinalSug,traerActividadesFinalExt) {

    $scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante});
        $scope.flag=false;
        $scope.seleccionados=[];
        $scope.propertyName = 'cumplidos';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
          };
        $scope.add=function(){
          $scope.listillo=finalesDefinitivos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idContrato:$scope.contrato})
          $scope.flag=true;
                }

         $scope.showAlert=function(ev,item){
         $rootScope.client=item;

         $mdDialog.show({
                                //Controlador del mensajes con operaciones definido en la parte de abajo
                                controller: DialogController,
                               //permite la comunicacion con el html que despliega el boton requisitos
                               templateUrl: 'test/resumenDeActividades.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })


         }


          function DialogController($scope, $mdDialog, $rootScope,$http) {
             $scope.option="";
             $scope.ciclo={};
             $scope.responsable={};
             $scope.banderaTable=false;
             $scope.banderaDeRequsitos=false;
             $scope.banderaFiltroResponsable=false;
             $scope.banderaFiltroEstado=false;
             $scope.banderaFiltroFecha=false;
             $scope.client=$rootScope.client;
             $scope.options = [
                                 { id: 1, name: 'Previo' },
                                 { id: 2, name: 'Ejecución' },
                                 { id: 3, name: 'Finalización' }
                               ];
             $scope.radioOptions = [
                                              { id: 1, name: 'Fecha' },
                                              { id: 2, name: 'Responsable' },
                                              { id: 3, name: 'Estado' }
                                            ];
             $scope.estadoOptions = [
                                                           { id: 1, name: 'Subido a destiempo' },
                                                           { id: 2, name: 'Subida a tiempo' },
                                                           { id: 3, name: 'Subida justo a tiempo' },
                                                           {id: 4, name:'No subida'}
                                                         ];

             $scope.hide = function() {
                           $mdDialog.hide();
                         };
                         //funcion para cerral el mensaje
              $scope.cancel = function() {
                           $mdDialog.cancel();
                         };

              $scope.tipoCiclo=function(item){
                    $scope.banderaDeRequsitos=false;
                    switch(item.name){
                     case "Previo":

                       $scope.listadoSugerido=estadoDinamicosPreviosSugeridos.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                       $scope.listadoExtra=estadoDinamicosPreviosExtras.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                       $scope.banderaDeRequsitos=true;
                       $scope.option="Previo"
                        break;
                     case "Ejecución":

                        $scope.listadoSugerido=estadoDinamicosEjecucionSugeridos.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                        $scope.listadoExtra=estadoDinamicosEjecucionExtras.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                        $scope.banderaDeRequsitos=true;


                        break;
                    case "Finalización":

                        $scope.listadoSugerido=estadoDinamicosFinalizacionSugeridos.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                        $scope.listadoExtra=estadoDinamicosFinalizacionExtras.query({idFinalista:$rootScope.client.idFinalista,idCategoria:$rootScope.client.idCategoria,idContratante:$rootScope.client.contratante});
                        $scope.banderaDeRequsitos=true;

                        break;
                    }


              }
              $scope.consultar=function(item){

                                      switch(item.tipo){
                                                        case "previoSugerido":
                                                        $scope.defActividadSugerida=traerActividadesPreviasSug.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                         $scope.banderaFiltroResponsable=false;
                                                         $scope.banderaFiltroEstado=false;
                                                         $scope.banderaFiltroFecha=false;

                                                            break;
                                                         case "ejecucionSugerido":
                                                        $scope.defActividadSugerida=traerActividadesEjecSug.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                        $scope.banderaFiltroResponsable=false;
                                                        $scope.banderaFiltroEstado=false;
                                                        $scope.banderaFiltroFecha=false;
                                                            break;
                                                         case "finalizacionSugerido":
                                                        $scope.defActividadSugerida=traerActividadesFinalSug.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                        $scope.banderaFiltroResponsable=false;
                                                        $scope.banderaFiltroEstado=false;
                                                        $scope.banderaFiltroFecha=false;
                                                            break;
                                                         case "previoExtra":
                                                         $scope.defActividadSugerida=traerActividadesPreviasExt.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                         $scope.banderaFiltroResponsable=false;
                                                         $scope.banderaFiltroEstado=false;
                                                         $scope.banderaFiltroFecha=false;
                                                              break;
                                                         case "ejecucionExtra":
                                                        $scope.defActividadSugerida=traerActividadesEjecExt.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                        $scope.banderaFiltroResponsable=false;
                                                        $scope.banderaFiltroEstado=false;
                                                        $scope.banderaFiltroFecha=false;
                                                             break;
                                                          case "finalizacionExtra":

                                                          $scope.defActividadSugerida=traerActividadesFinalExt.query({idFinalista:$rootScope.client.idFinalista,idRequisito:item.id});
                                                          $scope.banderaFiltroResponsable=false;
                                                          $scope.banderaFiltroEstado=false;
                                                          $scope.banderaFiltroFecha=false;
                                                              break;
              
                                        }
              
                                        $scope.banderaTable=true;

              
                            }

             $scope.filtroResponsable=function(item){

                switch(item.name){

                  case "Responsable":
                    $scope.banderaFiltroResponsable=true;
                    $scope.banderaFiltroEstado=false;
                    $scope.banderaFiltroFecha=false;

                    break;

                  case "Fecha":
                    $scope.banderaFiltroFecha=true;
                     $scope.banderaFiltroResponsable=false;
                     $scope.banderaFiltroEstado=false;
                    break;

                  case "Estado":
                    $scope.banderaFiltroEstado=true;
                    $scope.banderaFiltroResponsable=false;
                    $scope.banderaFiltroFecha=false;
                    break;
                }





             }
             $scope.filtrarResponsable=function(item,list){
                var list2=[];
                 var total=list.length;
                  for (var i=0;i<total;i++){
                        if(list[i].responsable == item)
                         list2.push(list[i]);
                  }

                $scope.defActividadSugerida=list2;



             }
             $scope.filtrarEstado=function(item,list){
                             var list2=[];
                             console.log(item);
                              var total=list.length;
                               for (var i=0;i<total;i++){
                                     if(list[i].comparacion == item.name)
                                      list2.push(list[i]);
                               }
                             $scope.defActividadSugerida=list2;

             }
             $scope.filtradoFecha=function(fecha1,fecha2,list){

                    console.log(list);
                    var list2=[];

                    var total=list.length;
                    for (var i=0;i<total;i++){
                            console.log(list[i].fechaEjecucion);
                            console.log(list[i].fechaEjecucion <fecha2);
                       if(list[i].fechaEjecucion <fecha2 && list[i].fechaEjecucion >= fecha1)
                             list2.push(list[i]);
                                                   }
                    $scope.defActividadSugerida=list2;
             }








          }



}]);