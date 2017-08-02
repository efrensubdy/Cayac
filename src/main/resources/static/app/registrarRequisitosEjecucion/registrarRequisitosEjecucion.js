'use strict';

angular.module('myApp.registrarRequisitosEjecucion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registrarRequisitosEjecucion', {
    templateUrl: 'registrarRequisitosEjecucion/registrarRequisitosEjecucion.html',
    controller: 'registrarRequisitosEjecucionCtrl'
  });
}])

.controller('registrarRequisitosEjecucionCtrl', ['$localStorage','$sessionStorage','$mdDialog','$rootScope', '$http', '$scope','previos','previosExtras','ejecucion','ejecucionExtras','finalizacion','finalizacionExtras','insertarPrevioSugerido','insertarPrevioExtra','insertarEjecucionSugerido','insertarEjecucionExtra','insertarFinalizacionSugerido','insertarFinalizacionExtra','defPreviosSugeridos','defPreviosExtras','defEjecucionSugeridos','defEjecucionExtras','defFinalizacionSugeridos','defFinalizacionExtras','dinamicosPrevios','dinamicosPreviosExtras','dinamicosEjecucion','dinamicosEjecucionExtras','dinamicosFinalizacion','dinamicosFinalizacionExtras','iDinamicoPrevioSugerido','iDinamicoPrevioExtra','iDinamicoEjecucionSugerido','iDinamicoEjecucionExtra','iDinamicoFinalizacionSugerido','iDinamicoFinalizacionExtra','defDinamicosPreviosSugeridos','defDinamicosPreviosExtras','defDinamicosEjecucionSugeridos','defDinamicosEjecucionExtras','defDinamicosFinalizacionSugeridos','defDinamicosFinalizacionExtras' ,'eliminarPS','eliminarPE','eliminarES','eliminarEE','eliminarFS','eliminarFE' ,'eliminarDPS','eliminarDPE','eliminarDES','eliminarDEE','eliminarDFS','eliminarDFE',function($localStorage,$sessionStorage,$mdDialog,$rootScope, $http, $scope,previos,previosExtras,ejecucion,ejecucionExtras,finalizacion,finalizacionExtras,insertarPrevioSugerido,insertarPrevioExtra,insertarEjecucionSugerido,insertarEjecucionExtra,insertarFinalizacionSugerido,insertarFinalizacionExtra,defPreviosSugeridos,defPreviosExtras,defEjecucionSugeridos,defEjecucionExtras,defFinalizacionSugeridos,defFinalizacionExtras,dinamicosPrevios,dinamicosPreviosExtras,dinamicosEjecucion,dinamicosEjecucionExtras,dinamicosFinalizacion,dinamicosFinalizacionExtras,iDinamicoPrevioSugerido,iDinamicoPrevioExtra,iDinamicoEjecucionSugerido,iDinamicoEjecucionExtra,iDinamicoFinalizacionSugerido,iDinamicoFinalizacionExtra,defDinamicosPreviosSugeridos,defDinamicosPreviosExtras,defDinamicosEjecucionSugeridos,defDinamicosEjecucionExtras,defDinamicosFinalizacionSugeridos,defDinamicosFinalizacionExtras,eliminarPS,eliminarPE,eliminarES,eliminarEE,eliminarFS,eliminarFE ,eliminarDPS,eliminarDPE,eliminarDES,eliminarDEE,eliminarDFS,eliminarDFE) {

 $scope.flag=false;
         $scope.propertyName = 'nombreEmpresa';
         $scope.reverse = true;
         $scope.sortBy = function(propertyName) {
             $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
             $scope.propertyName = propertyName;
         };
         $scope.banderaCategoria1=false;
         $scope.banderaCategoria2=false;
         $scope.banderaCategoria3=false;
         $scope.banderaCategoria4=false;

         $scope.function1=function(){
             switch ($scope.idCategoria) {
                 case "1":
                     $scope.banderaCategoria1=true;
                     $scope.banderaCategoria2=false;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     break;
                 case "2":
                     $scope.banderaCategoria1=false;
                     $scope.banderaCategoria2=true;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     break;
                 case "3":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=true;
                    $scope.banderaCategoria4=false;
                    break;
                 case "4":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=false;
                    $scope.banderaCategoria4=true;
                                 break;

             }


         }

          $scope.showAlert = function(ev) {
                 $rootScope.listadoPrevioSugerido=previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                        if(result.length!=0){
                          $rootScope.lonPrevio=true;

                        }
                        else{
                           $rootScope.lonPrevio=false;
                        }

                 });

                 $rootScope.listadoPrevioExtra=previosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){


                     if(result.length!=0){
                                              $rootScope.lonPrevioEx=true;

                                            }
                                            else{
                                              $rootScope.lonPrevioEx=false;
                                            }
                 });
                 $rootScope.listadoEjecucionSugerido=ejecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                       if(result.length!=0){
                              $rootScope.lonEjec=true;

                        }
                        else{
                              $rootScope.lonEjec=false;
                                                                  }

                 });
                 $rootScope.listadoEjecucionExtra=ejecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                          if(result.length!=0){
                               $rootScope.lonEjecEx=true;

                                                 }
                            else{
                                                       $rootScope.lonEjecEx=false;
                                                                                           }

                 });
                 $rootScope.listadoFinalizacionSugerido=finalizacion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                      if(result.length!=0){
                                                   $rootScope.lonFi=true;

                                             }
                                             else{
                                                   $rootScope.lonFi=false;
                                                                                       }

                 });
                 $rootScope.listadoFinalizacionExtra=finalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                       if(result.length!=0){
                                                    $rootScope.lonFiEx=true;

                                              }
                                              else{
                                                    $rootScope.lonFiEx=false;
                                                                                        }

                 });
                 $rootScope.idCategoria=$scope.idCategoria;

                 $mdDialog.show({
                       //Controlador del mensajes con operaciones definido en la parte de abajo
                       controller: DialogController,
                      //permite la comunicacion con el html que despliega el boton requisitos
                      templateUrl: 'test/test6.html',
                      parent: angular.element(document.body),
                      targetEvent: ev,
                      clickOutsideToClose:true,
                       fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                       })


               };
         $scope.showAlert2 = function(ev) {
          $rootScope.listadoDinamicoPrevioSugerido=dinamicosPrevios.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
                      if(result.length!=0){
                                               $rootScope.lonPrevio=true;

                                             }
                                             else{
                                                $rootScope.lonPrevio=false;
                                             }

          });
          $rootScope.listadoDinamicoPrevioExtra=dinamicosPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                     if(result.length!=0){
                                              $rootScope.lonPrevioEx=true;

                                            }
                                            else{
                                              $rootScope.lonPrevioEx=false;
                                            }
          });
          $rootScope.listadoDinamicoEjecucionSugerido=dinamicosEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

           if(result.length!=0){
                                        $rootScope.lonEjec=true;

                                  }
                                  else{
                                        $rootScope.lonEjec=false;
                                                                            }

          });
          $rootScope.listadoDinamicoEjecucionExtra=dinamicosEjecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                if(result.length!=0){
                                           $rootScope.lonEjecEx=true;

                                                             }
                                        else{
                                                                   $rootScope.lonEjecEx=false;
                                                                                                       }

          });
          $rootScope.listadoDinamicoFinalizacionSugerido=dinamicosFinalizacion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
                  if(result.length!=0){
                                                                   $rootScope.lonFi=true;

                                                             }
                                                             else{
                                                                   $rootScope.lonFi=false;
                                                                                                       }
          });
          $rootScope.listadoDinamicoFinalizacionExtra=dinamicosFinalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
             if(result.length!=0){
                                                                $rootScope.lonFiEx=true;

                                                          }
                                                          else{
                                                                $rootScope.lonFiEx=false;
                                                                                                    }


          });
          $rootScope.idCategoria=$scope.idCategoria;


                          $mdDialog.show({
                                //Controlador del mensajes con operaciones definido en la parte de abajo
                                controller: DialogController2,
                               //permite la comunicacion con el html que despliega el boton requisitos
                               templateUrl: 'test/requisitosDinamicos.html',
                               parent: angular.element(document.body),
                               targetEvent: ev,
                               clickOutsideToClose:true,
                                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })


                        };


          function DialogController($scope, $mdDialog, $rootScope,$http) {
                $scope.listadoPrevioSugerido=$rootScope.listadoPrevioSugerido;
                $scope.lonPrevio= $rootScope.lonPrevio;
                $scope.lonPrevioEx=$rootScope.lonPrevioEx;
                $scope.lonEjec=$rootScope.lonEjec;
                $scope.lonEjecEx=$rootScope.lonEjecEx;
                $scope.lonFi=$rootScope.lonFi;
                console.log($scope.lonfi);
                $scope.lonFiEx=$rootScope.lonFiEx;
                $scope.listPrevioSugerido=[];
                $scope.listAllPrevioSugerido=[];
                $scope.listadoPrevioExtra=$rootScope.listadoPrevioExtra;
                $scope.listPrevioExtra=[];
                $scope.listAllPrevioExtra=[];
                $scope.listadoEjecucionSugerido=$rootScope.listadoEjecucionSugerido;
                $scope.listEjecucionSugerido=[];
                $scope.listAllEjecucionSugerido=[];
                $scope.listadoEjecucionExtra=$rootScope.listadoEjecucionExtra;
                $scope.listEjecucionExtra=[];
                $scope.listAllEjecucionExtra=[];
                $scope.listadoFinalizacionSugerido=$rootScope.listadoFinalizacionSugerido;
                $scope.listFinalizacionSugerido=[];
                $scope.listAllFinalizacionSugerido=[];
                $scope.listadoFinalizacionExtra=$rootScope.listadoFinalizacionExtra;
                $scope.listFinalizacionExtra=[];
                $scope.listAllFinalizacionExtra=[];
                 function containsObject(obj, list) {
                   var i;
                   for (i = 0; i < list.length; i++) {
                      if (list[i] === obj) {
                            return true;
                      }
                   }

                   return false;
                 }

                $scope.hide = function() {
                              $mdDialog.hide();
                 };
                            //funcion para cerral el mensaje
                $scope.cancel = function() {
                              $mdDialog.cancel();
                 };
                  $scope.hideMessage1=function(){
                                 $scope.mensajillo1=false;
                                 $scope.mensajillo2=false;
                                 $scope.mensajillo3=false;
                                 $scope.mensajillo4=false;
                                 $scope.mensajillo5=false;
                                 $scope.mensajillo6=false;

                             }

                $scope.agregarPrevioSugerido=function(previoSugerido,item){
                    if(previoSugerido){
                    $scope.listPrevioSugerido.push(item)
                    }
                    else if(!previoSugerido && containsObject(item,$scope.listPrevioSugerido)){
                                                       var index=$scope.listPrevioSugerido.indexOf(item)
                                                        if (index > -1) {
                                                            $scope.listPrevioSugerido.splice(index, 1);
                                                        }
                                                        console.log($scope.listPrevioSugerido);
                                                    }
                };
                $scope.agregarPrevioExtra=function(previoExtra,item){
                    if(previoExtra){
                    $scope.listPrevioExtra.push(item)
                    }
                    else if(!previoExtra && containsObject(item,$scope.listPrevioExtra)){
                       var index=$scope.listPrevioExtra.indexOf(item)
                         if (index > -1) {
                            $scope.listPrevioExtra.splice(index, 1);
                          }
                          console.log($scope.listPrevioExtra);
                     }
                };
                $scope.agregarEjecucionSugerido=function(ejecucionSugerido,item){
                    if(ejecucionSugerido){
                    $scope.listEjecucionSugerido.push(item)
                    }
                     else if(!ejecucionSugerido && containsObject(item,$scope.listEjecucionSugerido)){
                                           var index=$scope.listEjecucionSugerido.indexOf(item)
                                             if (index > -1) {
                                                $scope.listEjecucionSugerido.splice(index, 1);
                                              }
                                              console.log($scope.listEjecucionSugerido);
                                         }
                };
                $scope.agregarEjecucionExtra=function(ejecucionExtra,item){
                    if(ejecucionExtra){
                    $scope.listEjecucionExtra.push(item)
                    }
                    else if(!ejecucionExtra && containsObject(item,$scope.listEjecucionExtra)){
                           var index=$scope.listEjecucionExtra.indexOf(item)
                            if (index > -1) {
                                  $scope.listEjecucionExtra.splice(index, 1);
                                                                  }
                                     console.log($scope.listEjecucionExtra);
                     }
                };
                $scope.agregarFinalizacionSugerido=function(finalizacionSugerido,item){
                    if(finalizacionSugerido){
                     $scope.listFinalizacionSugerido.push(item)
                    }
                    else if(!finalizacionSugerido && containsObject(item,$scope.listFinalizacionSugerido)){
                      var index=$scope.listFinalizacionSugerido.indexOf(item)
                              if (index > -1) {
                                   $scope.listFinalizacionSugerido.splice(index, 1);
                                                                                      }
                                                         console.log($scope.listFinalizacionSugerido);
                                         }
                };
                $scope.agregarFinalizacionExtra=function(finalizacionExtra,item){
                    if(finalizacionExtra){
                      $scope.listFinalizacionExtra.push(item)
                    }
                    else if(!finalizacionExtra && containsObject(item,$scope.listFinalizacionExtra)){
                                          var index=$scope.listFinalizacionExtra.indexOf(item)
                                                  if (index > -1) {
                                                       $scope.listFinalizacionExtra.splice(index, 1);
                                                                                                          }

                                                             }
                };

                $scope.allPreviosSugeridos=function(masterPrevioSugerido){
                    if(!masterPrevioSugerido){
                        $scope.previoSugerido=true;
                        $scope.listAllPrevioSugerido=$rootScope.listadoPrevioSugerido;
                    }
                    else{
                        $scope.previoSugerido=false;
                        $scope.listAllPrevioSugerido=[];
                    }
                };
                $scope.allPreviosExtra=function(masterPrevioExtra){
                    if(!masterPrevioExtra){
                        $scope.previoExtra=true;
                        $scope.listAllPrevioExtra=$rootScope.listadoPrevioExtra;
                     }
                     else{
                        $scope.previoExtra=false;
                        $scope.listAllPrevioExtra=[];
                     }
                };
                $scope.allEjecucionSugerido=function(masterEjecucionSugerido){
                    if(!masterEjecucionSugerido){
                      $scope.ejecucionSugerido=true;
                      $scope.listAllEjecucionSugerido=$rootScope.listadoEjecucionSugerido;
                     }
                     else{
                       $scope.ejecucionSugerido=false;
                       $scope.listAllEjecucionSugerido=[];
                     }

                };
                $scope.allEjecucionExtra=function(masterEjecucionExtra){
                    if(!masterEjecucionExtra){
                       $scope.ejecucionExtra=true;
                       $scope.listAllEjecucionExtra=$rootScope.listadoEjecucionExtra;
                     }
                     else{
                        $scope.ejecucionExtra=false;
                        $scope.listAllEjecucionExtra=[];
                     }
                };
                $scope.allFinalizacionSugerido=function(masterFinalizacionSugerido){
                    if(!masterFinalizacionSugerido){
                      $scope.finalizacionSugerido=true;
                      $scope.listAllFinalizacionSugerido=$rootScope.listadoFinalizacionSugerido;
                    }
                    else{
                      $scope.finalizacionSugerido=false;
                      $scope.listAllFinalizacionSugerido=[];
                     }
                };
                $scope.allFinalizacionExtra=function(masterFinalizacionExtra){
                    if(!masterFinalizacionExtra){
                       $scope.finalizacionExtra=true;
                       $scope.listAllFinalizacionExtra=$rootScope.listadoFinalizacionExtra;
                    }
                    else{
                       $scope.finalizacionExtra=false;
                       $scope.listAllFinalizacionExtra=[];
                    }
                };

                $scope.aplicarPrevioSugerido=function(ev){
                     var a=$scope.listPrevioSugerido.length;
                     var b=$scope.listAllPrevioSugerido.length;
                     if(a>b){
                        console.log("entre a sugeridos")
                        agregarBaseDatosPreviosSugeridos($scope.listPrevioSugerido);
                         $mdDialog.show({

                                                                    controller: DialogController3,
                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                           targetEvent: ev,
                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                              })
                     }
                     else if(a==0 && b==0){

                     $scope.mensajillo1=true

                     }
                     else{
                        console.log("entre a all sugeridos")
                        agregarBaseDatosPreviosSugeridos($scope.listAllPrevioSugerido);
                         $mdDialog.show({

                                                                    controller: DialogController3,
                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                           targetEvent: ev,
                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                              })
                     }
                };
                $scope.aplicarPrevioExtra=function(ev){
                                     var a=$scope.listPrevioExtra.length;
                                     var b=$scope.listAllPrevioExtra.length;
                                     if(a>b){
                                        console.log("entre a sugeridos")
                                        agregarBaseDatosPreviosExtras($scope.listPrevioExtra);
                                         $mdDialog.show({

                                                                                    controller: DialogController3,
                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                           targetEvent: ev,
                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                              })
                                     }
                                     else if(a==0 && b==0){

                                                          $scope.mensajillo2=true

                                                          }
                                     else{
                                        console.log("entre a all sugeridos")
                                        agregarBaseDatosPreviosExtras($scope.listAllPrevioExtra);
                                         $mdDialog.show({

                                                                                    controller: DialogController3,
                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                           targetEvent: ev,
                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                              })
                                     }

                                };

                $scope.aplicarEjecucionSugerido=function(ev){
                                    var a=$scope.listEjecucionSugerido.length;
                                    var b=$scope.listAllEjecucionSugerido.length;
                                    if(a>b){
                                       console.log("entre a sugeridos")
                                       agregarBaseDatosEjecucionSugeridos($scope.listEjecucionSugerido);
                                        $mdDialog.show({

                                                                                   controller: DialogController3,
                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                          targetEvent: ev,
                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                             })
                                    }
                                    else if(a==0 && b==0){

                                                         $scope.mensajillo3=true

                                                         }
                                    else{
                                       console.log("entre a all sugeridos")
                                       agregarBaseDatosEjecucionSugeridos($scope.listAllEjecucionSugerido);
                                        $mdDialog.show({

                                                                                   controller: DialogController3,
                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                          targetEvent: ev,
                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                             })
                                    }

                               };

                $scope.aplicarEjecucionExtra=function(ev){
                                                     var a=$scope.listEjecucionExtra.length;
                                                     var b=$scope.listAllEjecucionExtra.length;
                                                     if(a>b){
                                                        console.log("entre a sugeridos")
                                                        agregarBaseDatosEjecucionExtras($scope.listEjecucionExtra);
                                                         $mdDialog.show({

                                                                                                    controller: DialogController3,
                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                              })
                                                     }
                                                     else if(a==0 && b==0){

                                                                          $scope.mensajillo4=true

                                                                          }
                                                     else{
                                                        console.log("entre a all sugeridos")
                                                        agregarBaseDatosEjecucionExtras($scope.listAllEjecucionExtra);
                                                         $mdDialog.show({

                                                                                                    controller: DialogController3,
                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                              })
                                                     }

                                                };


                $scope.aplicarFinalizacionSugerido=function(ev){
                                                    var a=$scope.listFinalizacionSugerido.length;
                                                    var b=$scope.listAllFinalizacionSugerido.length;
                                                    if(a>b){
                                                       console.log("entre a sugeridos")
                                                       agregarBaseDatosFinalizacionSugeridos($scope.listFinalizacionSugerido);
                                                        $mdDialog.show({

                                                                                                   controller: DialogController3,
                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                             })
                                                    }
                                                    else if(a==0 && b==0){

                                                                         $scope.mensajillo5=true

                                                                         }
                                                    else{
                                                       console.log("entre a all sugeridos")
                                                       agregarBaseDatosFinalizacionSugeridos($scope.listAllFinalizacionSugerido);
                                                        $mdDialog.show({

                                                                                                   controller: DialogController3,
                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                             })
                                                    }

                                               };

                  $scope.aplicarFinalizacionExtra=function(ev){
                                                                     var a=$scope.listadoFinalizacionExtra.length;
                                                                     var b=$scope.listAllFinalizacionExtra.length;
                                                                     if(a>b){
                                                                        console.log("entre a sugeridos")
                                                                        agregarBaseDatosFinalizacionExtras($scope.listadoFinalizacionExtra);
                                                                         $mdDialog.show({

                                                                                                                    controller: DialogController3,
                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                              })
                                                                     }
                                                                     else if(a==0 && b==0){

                                                                                          $scope.mensajillo6=true

                                                                                          }
                                                                     else{
                                                                        console.log("entre a all sugeridos")
                                                                        agregarBaseDatosFinalizacionExtras($scope.listAllFinalizacionExtra);
                                                                         $mdDialog.show({

                                                                                                                    controller: DialogController3,
                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionE.html',
                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                              })
                                                                     }

                                                                };



              var agregarBaseDatosPreviosSugeridos=function(lista){
                             var total=lista.length;
                             for (var i=0;i<total;i++){
                                 var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                 console.log(requisitoObligatorio);
                                 console.log(total);
                                 insertarPrevioSugerido.save(requisitoObligatorio);

                             }


              }
             var agregarBaseDatosEjecucionSugeridos=function(lista){
                                             var total=lista.length;
                                             for (var i=0;i<total;i++){
                                                 var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                                 console.log(requisitoObligatorio);
                                                 console.log(total);
                                                 insertarEjecucionSugerido.save(requisitoObligatorio);

                                             }


              }
             var agregarBaseDatosFinalizacionSugeridos=function(lista){
                                                          var total=lista.length;
                                                          for (var i=0;i<total;i++){
                                                              var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                                              console.log(requisitoObligatorio);
                                                              console.log(total);
                                                              insertarFinalizacionSugerido.save(requisitoObligatorio);

                                                          }


                           }
               var agregarBaseDatosPreviosExtras=function(lista){
                                         var total=lista.length;
                                        for (var i=0;i<total;i++){
                                          var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                           console.log(total);
                                           console.log(requisitoExtra);
                                           insertarPrevioExtra.save(requisitoExtra);

                                        }


               }
                var agregarBaseDatosEjecucionExtras=function(lista){
                                                       var total=lista.length;
                                                      for (var i=0;i<total;i++){
                                                        var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                                         console.log(total);
                                                         console.log(requisitoExtra);
                                                         insertarEjecucionExtra.save(requisitoExtra);

                                                      }


                }

            var agregarBaseDatosFinalizacionExtras=function(lista){
                                                                   var total=lista.length;
                                                                  for (var i=0;i<total;i++){
                                                                    var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                                                     console.log(total);
                                                                     console.log(requisitoExtra);
                                                                     insertarFinalizacionExtra.save(requisitoExtra);

                                                                  }


                            }



          }
          function DialogController3($scope, $mdDialog, $rootScope,$http){

            $scope.defPreviosSugeridos=defPreviosSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defPreviosExtras=defPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defEjecucionSugeridos=defEjecucionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defEjecucionExtras=defEjecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defFinalizacionSugeridos=defFinalizacionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defFinalizacionExtras=defFinalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});

            $scope.hide = function() {
               $mdDialog.hide();
            };
                                                    //funcion para cerral el mensaje
             $scope.cancel = function() {
                $mdDialog.cancel();
             };
             $scope.show=function(ev){
                     $mdDialog.show({
                                                   //Controlador del mensajes con operaciones definido en la parte de abajo
                                controller: DialogController3,
                                                  // permite la comunicacion con el html que despliega el boton requisitos
                                templateUrl: 'test/definitivosEstaticos.html',
                                parent: angular.element(document.body),
                                targetEvent: ev,
                                clickOutsideToClose:true,
                                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
            })
            }
           }
            function DialogController4($scope, $mdDialog, $rootScope,$http){

                       $scope.defPreviosSugeridos=defDinamicosPreviosSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                       $scope.defPreviosExtras=defDinamicosPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                       $scope.defEjecucionSugeridos=defDinamicosEjecucionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                       $scope.defEjecucionExtras=defDinamicosEjecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                       $scope.defFinalizacionSugeridos=defDinamicosFinalizacionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                       $scope.defFinalizacionExtras=defDinamicosFinalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});



                        $scope.hide = function() {
                           $mdDialog.hide();
                        };
                                                                //funcion para cerral el mensaje
                         $scope.cancel = function() {
                            $mdDialog.cancel();
                         };
                         $scope.show=function(ev){
                                 $mdDialog.show({
                                                               //Controlador del mensajes con operaciones definido en la parte de abajo
                                            controller: DialogController4,
                                                              // permite la comunicacion con el html que despliega el boton requisitos
                                            templateUrl: 'test/definitivosDinamicos.html',
                                            parent: angular.element(document.body),
                                            targetEvent: ev,
                                            clickOutsideToClose:true,
                                            fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                        })
                        }

          }
         function DialogController2($scope, $mdDialog, $rootScope,$http) {
            $scope.lonPrevio= $rootScope.lonPrevio;
            $scope.lonPrevioEx=$rootScope.lonPrevioEx;
            $scope.lonEjec=$rootScope.lonEjec;
            $scope.lonEjecEx=$rootScope.lonEjecEx;
            $scope.lonFi=$rootScope.lonFi;
            $scope.lonFiEx=$rootScope.lonFiEx;
            $scope.listDinamicoPrevioSugerido=[];
            $scope.listDinamicoAllPrevioSugerido=[];
            $scope.listDinamicoPrevioExtra=[];
            $scope.listDinamicoAllPrevioExtra=[];
            $scope.listDinamicoEjecucionSugerido=[];
            $scope.listDinamicoAllEjecucionSugerido=[];
            $scope.listDinamicoEjecucionExtra=[];
            $scope.listDinamicoAllEjecucionExtra=[];
            $scope.listDinamicoFinalizacionSugerido=[];
            $scope.listDinamicoAllFinalizacionSugerido=[];
            $scope.listDinamicoFinalizacionExtra=[];
            $scope.listDinamicoAllFinalizacionExtra=[];
            $scope.listadoDinamicoPrevioSugerido=$rootScope.listadoDinamicoPrevioSugerido;

            $scope.listadoDinamicoPrevioExtra=$rootScope.listadoDinamicoPrevioExtra;

            $scope.listadoDinamicoEjecucionSugerido=$rootScope.listadoDinamicoEjecucionSugerido;

            $scope.listadoDinamicoEjecucionExtra=$rootScope.listadoDinamicoEjecucionExtra;

            $scope.listadoDinamicoFinalizacionSugerido=$rootScope.listadoDinamicoFinalizacionSugerido;

            $scope.listadoDinamicoFinalizacionExtra=$rootScope.listadoDinamicoFinalizacionExtra;
            $scope.hideMessage1=function(){
                                             $scope.mensajillo1=false;
                                             $scope.mensajillo2=false;
                                             $scope.mensajillo3=false;
                                             $scope.mensajillo4=false;
                                             $scope.mensajillo5=false;
                                             $scope.mensajillo6=false;

                                         }



            $scope.hide = function() {
                 $mdDialog.hide();
                             };
                                        //funcion para cerral el mensaje
            $scope.cancel = function() {
                 $mdDialog.cancel();
                             };

            $scope.agregarDinamicoPrevioSugerido=function(dinamicoPrevioSugerido,item){
               if(dinamicoPrevioSugerido){
                                $scope.listDinamicoPrevioSugerido.push(item)
                                }
                                else if(!dinamicoPrevioSugerido && containsObject(item,$scope.listDinamicoPrevioSugerido)){
                                   var index=$scope.listDinamicoPrevioSugerido.indexOf(item)
                                    if (index > -1) {
                                        $scope.listDinamicoPrevioSugerido.splice(index, 1);
                                    }
                                    console.log($scope.listDinamicoPrevioSugerido);
                                }
                            };
                            $scope.agregarDinamicoPrevioExtra=function(dinamicoPrevioExtras,item){
                                if(dinamicoPrevioExtras){
                                $scope.listDinamicoPrevioExtra.push(item)
                                }
                                else if(!dinamicoPrevioExtras && containsObject(item,$scope.listDinamicoPrevioExtra)){
                                    var index=$scope.listDinamicoPrevioExtra.indexOf(item)
                                       if (index > -1) {
                                               $scope.listDinamicoPrevioExtra.splice(index, 1);
                                        }

                                }

                            };
                            $scope.agregarDinamicoEjecucionSugerido=function(dinamicoEjecucionSugerido,item){
                                if(dinamicoEjecucionSugerido){
                                $scope.listDinamicoEjecucionSugerido.push(item)
                                }
                                else if(!dinamicoEjecucionSugerido && containsObject(item,$scope.listDinamicoEjecucionSugerido)){
                                  var index=$scope.listDinamicoEjecucionSugerido.indexOf(item)
                                       if (index > -1) {
                                               $scope.listDinamicoEjecucionSugerido.splice(index, 1);
                                        }

                                 }
                            };
                            $scope.agregarDinamicoEjecucionExtra=function(dinamicoEjecucionExtra,item){
                                if(dinamicoEjecucionExtra){
                                $scope.listDinamicoEjecucionExtra.push(item)
                                }
                                else if(!dinamicoEjecucionExtra && containsObject(item,$scope.listDinamicoEjecucionExtra)){
                                    var index=$scope.listDinamicoEjecucionExtra.indexOf(item)
                                    if (index > -1) {
                                         $scope.listDinamicoEjecucionExtra.splice(index, 1);
                                     }

                                }
                            };
                            $scope.agregarDinamicosFinalizacionSugerido=function(dinamicosFinalizacionSugerido,item){
                                if(dinamicosFinalizacionSugerido){

                                $scope.listDinamicoFinalizacionSugerido.push(item)


                                }
                                else if(!dinamicosFinalizacionSugerido && containsObject(item, $scope.listDinamicoFinalizacionSugerido)){
                                    var index= $scope.listDinamicoFinalizacionSugerido.indexOf(item)
                                       if (index > -1) {
                                            $scope.listDinamicoFinalizacionSugerido.splice(index, 1);
                                       }

                                    }
                            };
                            $scope.agregarDinamicoFinalizacionExtra=function(dinamicoFinalizacionExtra,item){
                                if(dinamicoFinalizacionExtra){
                                  $scope.listDinamicoFinalizacionExtra.push(item)
                                }
                                else if(!dinamicoFinalizacionExtra && containsObject(item,$scope.listDinamicoFinalizacionExtra)){
                                   var index=$scope.listDinamicoFinalizacionExtra.indexOf(item)
                                      if (index > -1) {
                                            $scope.listDinamicoFinalizacionExtra.splice(index, 1);
                                              }

                                 }

                            };

                            $scope.allDinamicosPreviosSugeridos=function(masterDinamicoPrevioSugerido){
                                if(!masterDinamicoPrevioSugerido){
                                    $scope.dinamicoPrevioSugerido=true;
                                    $scope.listDinamicosAllPrevioSugerido=$rootScope.listadoDinamicoPrevioSugerido;
                                }
                                else{
                                    $scope.dinamicoPrevioSugerido=false;
                                    $scope.listAllPrevioSugerido=[];
                                }
                            };
                            $scope.allDinamicosPreviosExtra=function(masterDinamicoPrevioExtra){
                                if(!masterDinamicoPrevioExtra){
                                    $scope.dinamicoPrevioExtras=true;
                                    $scope.listDinamicoAllPrevioExtra=$rootScope.listadoDinamicoPrevioExtra;
                                 }
                                 else{
                                    $scope.dinamicoPrevioExtras=false;
                                    $scope.listDinamicoAllPrevioExtra=[];
                                 }
                            };
                            $scope.allDinamicosEjecucionSugerido=function(masterDinamicoEjecucionSugerido){
                                if(!masterDinamicoEjecucionSugerido){
                                  $scope.dinamicoEjecucionSugerido=true;
                                  $scope.listDinamicoAllEjecucionSugerido=$rootScope.listadoDinamicoEjecucionSugerido;
                                 }
                                 else{
                                   $scope.dinamicoEjecucionSugerido=false;
                                   $scope.listDinamicoAllEjecucionSugerido=[];
                                 }

                            };
                            $scope.allDinamicosEjecucionExtra=function(masterDinamicoEjecucionExtra){
                                if(!masterDinamicoEjecucionExtra){
                                   $scope.dinamicoEjecucionExtra=true;
                                   $scope.listDinamicoAllEjecucionExtra=$rootScope.listadoDinamicoEjecucionExtra;
                                 }
                                 else{
                                    $scope.dinamicoEjecucionExtra=false;
                                    $scope.listDinamicoAllEjecucionExtra=[];
                                 }
                            };
                            $scope.allDinamicosFinalizacionSugerido=function(masterDinamicoFinalizacionSugerido){
                                if(!masterDinamicoFinalizacionSugerido){
                                  $scope.dinamicosFinalizacionSugerido=true;
                                  $scope.listDinamicosAllFinalizacionSugerido=$rootScope.listadoDinamicoFinalizacionSugerido;
                                }
                                else{
                                  $scope.dinamicosFinalizacionSugerido=false;
                                  $scope.listDinamicosAllFinalizacionSugerido=[];
                                 }
                            };
                            $scope.allDinamicosFinalizacionExtra=function(masterDinamicoFinalizacionExtra){
                                if(!masterDinamicoFinalizacionExtra){
                                   $scope.dinamicoFinalizacionExtra=true;
                                   $scope.listDinamicoAllFinalizacionExtra=$rootScope.listadoDinamicoFinalizacionExtra;
                                }
                                else{
                                   $scope.dinamicoFinalizacionExtra=false;
                                   $scope.listDinamicoAllFinalizacionExtra=[];
                                }
                            };



                    function containsObject(obj, list) {
                        var i;
                        for (i = 0; i < list.length; i++) {
                            if (list[i] === obj) {
                                return true;
                            }
                        }

                        return false;
                    }

                                var agregarBaseDatosDinamicosPreviosSugeridos=function(lista){
                                                 var total=lista.length;
                                                 for (var i=0;i<total;i++){
                                                     var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                                     console.log(requisitoObligatorio);
                                                     console.log(total);
                                                     iDinamicoPrevioSugerido.save(requisitoObligatorio);

                                                 }


                                  }
                                 var agregarBaseDatosDinamicosEjecucionSugeridos=function(lista){
                                                                 var total=lista.length;
                                                                 for (var i=0;i<total;i++){
                                                                     console.log(lista[i]);
                                                                     var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                                                     console.log(requisitoObligatorio);
                                                                     console.log(total);
                                                                     iDinamicoEjecucionSugerido.save(requisitoObligatorio);

                                                                 }


                                  }
                                 var agregarBaseDatosDinamicosFinalizacionSugeridos=function(lista){
                                                                              var total=lista.length;
                                                                              for (var i=0;i<total;i++){
                                                                                  console.log(lista[i]);
                                                                                  var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                                                                  console.log(requisitoObligatorio);
                                                                                  console.log(total);
                                                                                  iDinamicoFinalizacionSugerido.save(requisitoObligatorio);

                                                                              }


                                               }
                                   var agregarBaseDatosDinamicosPreviosExtras=function(lista){
                                                             var total=lista.length;
                                                            for (var i=0;i<total;i++){
                                                              var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                                               console.log(total);
                                                               console.log(requisitoExtra);
                                                               iDinamicoPrevioExtra.save(requisitoExtra);

                                                            }


                                   }
                                    var agregarBaseDatosDinamicosEjecucionExtras=function(lista){
                                                                           var total=lista.length;
                                                                          for (var i=0;i<total;i++){
                                                                            var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                                                             console.log(total);
                                                                             console.log(requisitoExtra);
                                                                             iDinamicoEjecucionExtra.save(requisitoExtra);

                                                                          }


                                    }

                                var agregarBaseDatosDinamicosFinalizacionExtras=function(lista){
                                                                                       var total=lista.length;
                                                                                      for (var i=0;i<total;i++){
                                                                                        var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                                                                         console.log(total);
                                                                                         console.log(requisitoExtra);
                                                                                         iDinamicoFinalizacionExtra.save(requisitoExtra);

                                                                                      }


                                                }


                $scope.aplicarDinamiooPrevioSugerido=function(ev){
                     var a=$scope.listDinamicoPrevioSugerido.length;
                     var b=$scope.listDinamicoAllPrevioSugerido.length;
                     if(a>b){
                        console.log("entre a sugeridos")
                        agregarBaseDatosDinamicosPreviosSugeridos($scope.listDinamicoPrevioSugerido);
                         $mdDialog.show({

                                                                                                            controller: DialogController4,
                                                                                                                                                                                                     // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                   templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                   parent: angular.element(document.body),
                                                                                                                                                                                   targetEvent: ev,
                                                                                                                                                                                   clickOutsideToClose:true,
                                                                                                                                                                                   fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                      })
                     }
                     else if(a==b && b==0){
                        $scope.mensajillo1=true;



                     }
                     else{
                        console.log("entre a all sugeridos")
                        agregarBaseDatosDinamicosPreviosSugeridos($scope.listDinamicoAllPrevioSugerido);
                        $mdDialog.show({

                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                              })
                     }




                    };



                    $scope.aplicarDinamicoPrevioExtra=function(ev){
                                     var a=$scope.listDinamicoPrevioExtra.length;
                                     var b=$scope.listDinamicoAllPrevioExtra.length;
                                     if(a>b){
                                        console.log("entre a sugeridos")
                                        agregarBaseDatosDinamicosPreviosExtras($scope.listDinamicoPrevioExtra);
                                        $mdDialog.show({

                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                              })
                                     }
                                     else if(a==b && b==0){
                                                             $scope.mensajillo2=true;



                                                          }
                                     else{
                                        console.log("entre a all sugeridos")
                                        agregarBaseDatosDinamicosPreviosExtras($scope.listDinamicoAllPrevioExtra);
                                        $mdDialog.show({

                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                              })
                                     }

                                };

                $scope.aplicarDinamicoEjecucionSugerido=function(ev){
                                    var a=$scope.listDinamicoEjecucionSugerido.length;
                                    var b=$scope.listDinamicoAllEjecucionSugerido.length;
                                    if(a>b){
                                       console.log("entre a sugeridos")
                                       agregarBaseDatosDinamicosEjecucionSugeridos($scope.listDinamicoEjecucionSugerido);
                                       $mdDialog.show({

                                                                                                                                                   controller: DialogController4,
                                                                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                             })

                                    }
                                    else if(a==b && b==0){
                                                            $scope.mensajillo3=true;



                                                         }
                                    else{
                                       console.log("entre a all sugeridos")
                                       agregarBaseDatosDinamicosEjecucionSugeridos($scope.listDinamicoAllEjecucionSugerido);
                                       $mdDialog.show({

                                                                                                                                                   controller: DialogController4,
                                                                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                             })
                                    }

                               };

                $scope.aplicarDinamicoEjecucionExtra=function(ev){
                                                     var a=$scope.listDinamicoEjecucionExtra.length;
                                                     var b=$scope.listDinamicoAllEjecucionExtra.length;
                                                     if(a>b){
                                                        console.log("entre a sugeridos")
                                                        agregarBaseDatosDinamicosEjecucionExtras($scope.listDinamicoEjecucionExtra);
                                                        $mdDialog.show({

                                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                              })
                                                     }
                                                        else if(a==b && b==0){
                                                            $scope.mensajillo4=true;



                                                                          }
                                                     else{
                                                        console.log("entre a all sugeridos")
                                                        agregarBaseDatosDinamicosEjecucionExtras($scope.listDinamicosAllEjecucionExtra);
                                                        $mdDialog.show({

                                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                              })
                                                     }

                                                };


                $scope.aplicarDinamicoFinalizacionSugerido=function(ev){
                                                    var a= $scope.listDinamicoFinalizacionSugerido.length;
                                                    var b=$scope.listDinamicoAllFinalizacionSugerido.length;
                                                    if(a>b){
                                                       console.log("entre a sugeridos")
                                                       console.log( $scope.listDinamicoFinalizacionSugerido);
                                                       agregarBaseDatosDinamicosFinalizacionSugeridos( $scope.listDinamicoFinalizacionSugerido);
                                                       $mdDialog.show({

                                                                                                                                                                   controller: DialogController4,
                                                                                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                             })
                                                    }
                                                       else if(a==b && b==0){
                                                                            $scope.mensajillo5=true;



                                                                         }
                                                    else{
                                                       console.log("entre a all sugeridos")
                                                       agregarBaseDatosDinamicosFinalizacionSugeridos($scope.listDinamicoAllFinalizacionSugerido);
                                                       $mdDialog.show({

                                                                                                                                                                   controller: DialogController4,

                                                                                                                                                                                                                                                            // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                          templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                          parent: angular.element(document.body),
                                                                                                                                                                                                                                          targetEvent: ev,
                                                                                                                                                                                                                                          clickOutsideToClose:true,
                                                                                                                                                                                                                                          fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                             })

                                                    }

                        };
                  $scope.aplicarDinamicoFinalizacionExtra=function(ev){
                                                                     var a=$scope.listDinamicoFinalizacionExtra.length;
                                                                     var b=$scope.listDinamicoAllFinalizacionExtra.length;
                                                                     if(a>b){
                                                                        console.log("entre a sugeridos")
                                                                        agregarBaseDatosDinamicosFinalizacionExtras($scope.listadoDinamicoFinalizacionExtra);
                                                                        $mdDialog.show({

                                                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                                              })
                                                                     }
                                                                     else if(a==b && b==0){
                                                                                             $scope.mensajillo6=true;



                                                                                          }
                                                                     else{
                                                                        console.log("entre a all sugeridos")
                                                                        agregarBaseDatosDinamicosFinalizacionExtras($scope.listDinamicoAllFinalizacionExtra);
                                                                        $mdDialog.show({

                                                                                                                                                                                    controller: DialogController4,
                                                                                                                                                                                                                                                                             // permite la comunicacion con el html que despliega el boton requisitos
                                                                                                                                                                                                                                                           templateUrl: 'test/mensajeDeConfirmacionD.html',
                                                                                                                                                                                                                                                           parent: angular.element(document.body),
                                                                                                                                                                                                                                                           targetEvent: ev,
                                                                                                                                                                                                                                                           clickOutsideToClose:true,
                                                                                                                                                                                                                                                           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                                                                                                                                                                                                                              })
                                                                     }

                                                                };



           }

}]);