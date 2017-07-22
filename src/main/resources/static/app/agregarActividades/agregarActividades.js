'use strict';

angular.module('myApp.agregarActividades', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/agregarActividades', {
    templateUrl: 'agregarActividades/agregarActividades.html',
    controller: 'agregarActividadesCtrl'
  });
}])

.controller('agregarActividadesCtrl', ['$mdDialog','$scope','$rootScope','$localStorage','$sessionStorage','estadoDinamicosPreviosSugeridos','estadoDinamicosPreviosExtras','estadoDinamicosEjecucionSugeridos','estadoDinamicosEjecucionExtras','estadoDinamicosFinalizacionSugeridos','estadoDinamicosFinalizacionExtras','addActividadPreviaSugerida','traerActividadesPreviasSug','fileUpload','traerActividadesPreviasExt','traerActividadesEjecSug','traerActividadesEjecExt','traerActividadesFinalSug','traerActividadesFinalExt','addActividadPrevioExtra','addActividadEjecucionSugerido','addActividadEjecucionExtra','addActividadFinalizacionSugerido','addActividadFinalizacionExtra',function($mdDialog,$scope,$rootScope,$localStorage,$sessionStorage,estadoDinamicosPreviosSugeridos,estadoDinamicosPreviosExtras,estadoDinamicosEjecucionSugeridos,estadoDinamicosEjecucionExtras,estadoDinamicosFinalizacionSugeridos,estadoDinamicosFinalizacionExtras,addActividadPreviaSugerida,traerActividadesPreviasSug,fileUpload,traerActividadesPreviasExt,traerActividadesEjecSug,traerActividadesEjecExt,traerActividadesFinalSug,traerActividadesFinalExt,addActividadPrevioExtra,addActividadEjecucionSugerido,addActividadEjecucionExtra,addActividadFinalizacionSugerido,addActividadFinalizacionExtra) {
$scope.banderaPrevio=false;
$scope.banderaEjecucion=false;
$scope.banderaFinalizacion=false;
  this.selectedTab = null;

  this.changeTab = function() {
    this.selectedTab=1;
  }


$scope.options = [
                    { id: 1, name: 'Previo ' },
                    { id: 2, name: 'Ejecución' },
                    { id: 3, name: 'Finalización ' }
                  ];



$scope.function1=function(){
                            console.log($scope.tipociclo)

                            switch ($scope.tipociclo) {
                                case 1:
                                    $scope.banderaPrevio=true;
                                    $scope.banderaEjecucion=false;
                                    $scope.banderaFinalizacion=false;
                                    break;
                                case 2:
                                    $scope.banderaPrevio=false;
                                    $scope.banderaEjecucion=true;
                                    $scope.banderaFinalizacion=false;
                                    break;
                                case 3:
                                   $scope.banderaPrevio=false;
                                   $scope.banderaEjecucion=false;
                                   $scope.banderaFinalizacion=true;
                                    break;

                            }
                            }

        $scope.showAlert = function(ev) {
                $rootScope.listadoSugerido=estadoDinamicosPreviosSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
                $rootScope.listadoExtra=estadoDinamicosPreviosExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
                $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController,
                     // permite la comunicacion con el html que despliega el boton requisitos
                     templateUrl: 'test/addActivity.html',
                      parent: angular.element(document.body),
                      targetEvent: ev,
                      clickOutsideToClose:true,
                      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                      })


         };
         $scope.showAlert2 = function(ev) {
            $rootScope.listadoSugerido=estadoDinamicosEjecucionSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});
            $rootScope.listadoExtra=estadoDinamicosEjecucionExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});

                         $mdDialog.show({
                               //Controlador del mensajes con operaciones definido en la parte de abajo
                               controller: DialogController,
                              // permite la comunicacion con el html que despliega el boton requisitos
                              templateUrl: 'test/addActivity.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                               fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                               })


         };
         $scope.showAlert3 = function(ev) {
              $rootScope.listadoSugerido=estadoDinamicosFinalizacionSugeridos.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});

              $rootScope.listadoExtra=estadoDinamicosFinalizacionExtras.query({idFinalista:$localStorage.userLogeado.idFinalista,idCategoria:$localStorage.userLogeado.categoria,idContratante:$localStorage.userLogeado.idContratante});



                         $mdDialog.show({
                               //Controlador del mensajes con operaciones definido en la parte de abajo
                               controller: DialogController,
                              // permite la comunicacion con el html que despliega el boton requisitos
                              templateUrl: 'test/addActivity.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                               fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                               })


                  };
               $scope.agregarEstaticosSugeridosPrevios = function(ev,item,seleccionado) {
                        switch(seleccionado.tipo){
                                       case "previoSugerido":
                                       console.log("previoSugerido")
                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item.id);
                                            console.log(seleccionado);
                                            var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/"+ seleccionado.id  + "/previoSugerido" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);

                                       break;
                                       case "ejecucionSugerido":
                                         console.log("ejecucionSugerido")
                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item);
                                            console.log(seleccionado);
                                           var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/"+ seleccionado.id    + "/ejecucionSugerido" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);

                                       break;
                                       case "finalizacionSugerido":
                                             console.log("finalizacionSugerido")
                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item);
                                            console.log(seleccionado);
                                            var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/"+ seleccionado.id  + "/finalizacionSugerido" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);

                                       break;
                                       case "previoExtra":

                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item);
                                            console.log(seleccionado);
                                            var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista+ "/"+ seleccionado.id   + "/previoExtra" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);

                                       break;
                                       case "ejecucionExtra":
                                        console.log("ejecucionExtra")
                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item);
                                            console.log(seleccionado);
                                            var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista+ "/"+ seleccionado.id   + "/ejecucionExtra" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);

                                       break;
                                       case "finalizacionExtra":
                                        console.log("finalizacionExtra")
                                        var file =$scope.myDoc;
                                             console.log(file);
                                            console.log(item);
                                            console.log(seleccionado);
                                            var uploadUrl = 'http://localhost:8080/app/sopAct/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/"+ seleccionado.id  + "/finalizacionExtra" ;

                                            fileUpload.uploadFileToUrl(file, uploadUrl);


                                       break;

                        }

                           $mdDialog.show(
                                     $mdDialog.alert()
                                     .parent(angular.element(document.querySelector('#popupContainer')))
                                     .clickOutsideToClose(true)
                                      .title('Subido !!!')
                                      .textContent('Su archivo se he subido correctamente.')
                                      .ariaLabel('Alert Dialog Demo')
                                      .ok('ok!')
                                       .targetEvent(ev)
                                                              );


                       };




        function DialogController($scope, $mdDialog, $rootScope,$http) {

                      $scope.actividad={};
                      $scope.aceptado=false;
                      $scope.banderaTable=false;
                      $scope.banderaAgregarActividad=false;
                      $scope.botones=false;
                      $scope.listadoSugerido=$rootScope.listadoSugerido;
                      $scope.listadoExtra=$rootScope.listadoExtra;
                       $scope.hide = function() {
                                     $mdDialog.hide();
                                   };
                                   //funcion para cerral el mensaje
                       $scope.cancel = function() {
                                     $mdDialog.cancel();
                                   };
                       $scope.agregarActividad=function(){
                            $scope.banderaAgregarActividad=true;
                            $scope.aceptado=false;
                            $scope.banderaTable=false;


                       }
                       $scope.aparecerBotones=function(){
                             $scope.botones=true;
                             $scope.banderaAgregarActividad=false;
                             $scope.aceptado=false;
                             $scope.banderaTable=false;
                       }
                       $scope.addActivitytoDataBase=function(item){
                            console.log(item);
                            switch(item.tipo){

                                case "previoSugerido":
                                    var estado="ssp";
                                    var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                    addActividadPreviaSugerida.save(nuevaActividad);
                                    break;
                                 case "ejecucionSugerido":
                                    var estado="ssp";
                                    var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                    addActividadEjecucionSugerido.save(nuevaActividad);
                                    break;
                                 case "finalizacionSugerido":
                                    var estado="ssp";
                                    var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                    addActividadFinalizacionSugerido.save(nuevaActividad);
                                    break;
                                 case "previoExtra":
                                      var estado="ssp";
                                      var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                      addActividadPrevioExtra.save(nuevaActividad);
                                      break;
                                 case "ejecucionExtra":
                                     var estado="ssp";
                                     var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                     addActividadEjecucionExtra.save(nuevaActividad);
                                     break;
                                  case "finalizacionExtra":
                                      var estado="ssp";
                                      var nuevaActividad={"idRequisito":item.id,"idFinalista":$localStorage.userLogeado.idFinalista,"nombre":$scope.actividad.nombreActividad,"fechaEjecucion":$scope.actividad.fechaEjecucion,"responsable":$scope.actividad.responsable,"estado":estado};
                                      addActividadFinalizacionExtra.save(nuevaActividad);
                                      break;

                            }
                            $scope.banderaAgregarActividad=false;
                            $scope.aceptado=true;

                      }
                      $scope.consultar=function(item){
                        switch(item.tipo){
                                          case "previoSugerido":
                                          $scope.defActividadSugerida=traerActividadesPreviasSug.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                              break;
                                           case "ejecucionSugerido":
                                           $scope.defActividadSugerida=traerActividadesEjecSug.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                              break;
                                           case "finalizacionSugerido":
                                           $scope.defActividadSugerida=traerActividadesFinalSug.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                              break;
                                           case "previoExtra":
                                           $scope.defActividadSugerida=traerActividadesPreviasExt.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                                break;
                                           case "ejecucionExtra":
                                           $scope.defActividadSugerida=traerActividadesEjecExt.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                               break;
                                            case "finalizacionExtra":

                                            $scope.defActividadSugerida=traerActividadesFinalExt.query({idFinalista:$localStorage.userLogeado.idFinalista,idRequisito:item.id});
                                                break;

                          }

                          $scope.banderaTable=true;

              }

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

 }]);;
