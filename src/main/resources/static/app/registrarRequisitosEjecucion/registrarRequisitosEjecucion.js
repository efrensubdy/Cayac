'use strict';

angular.module('myApp.registrarRequisitosEjecucion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registrarRequisitosEjecucion', {
    templateUrl: 'registrarRequisitosEjecucion/registrarRequisitosEjecucion.html',
    controller: 'registrarRequisitosEjecucionCtrl'
  });
}])

.controller('registrarRequisitosEjecucionCtrl', ['$localStorage','$sessionStorage','$mdDialog','$rootScope', '$http', '$scope','$q','previos','previosExtras','ejecucion','ejecucionExtras','finalizacion','finalizacionExtras','insertarPrevioSugerido','insertarPrevioExtra','insertarEjecucionSugerido','insertarEjecucionExtra','insertarFinalizacionSugerido','insertarFinalizacionExtra','defPreviosSugeridos','defPreviosExtras','defEjecucionSugeridos','defEjecucionExtras','defFinalizacionSugeridos','defFinalizacionExtras','dinamicosPrevios','dinamicosPreviosExtras','dinamicosEjecucion','dinamicosEjecucionExtras','dinamicosFinalizacion','dinamicosFinalizacionExtras','iDinamicoPrevioSugerido','iDinamicoPrevioExtra','iDinamicoEjecucionSugerido','iDinamicoEjecucionExtra','iDinamicoFinalizacionSugerido','iDinamicoFinalizacionExtra' ,'eliminarPS','eliminarPE','eliminarES','eliminarEE','eliminarFS','eliminarFE',function($localStorage,$sessionStorage,$mdDialog,$rootScope, $http, $scope,$q,previos,previosExtras,ejecucion,ejecucionExtras,finalizacion,finalizacionExtras,insertarPrevioSugerido,insertarPrevioExtra,insertarEjecucionSugerido,insertarEjecucionExtra,insertarFinalizacionSugerido,insertarFinalizacionExtra,defPreviosSugeridos,defPreviosExtras,defEjecucionSugeridos,defEjecucionExtras,defFinalizacionSugeridos,defFinalizacionExtras,dinamicosPrevios,dinamicosPreviosExtras,dinamicosEjecucion,dinamicosEjecucionExtras,dinamicosFinalizacion,dinamicosFinalizacionExtras,iDinamicoPrevioSugerido,iDinamicoPrevioExtra,iDinamicoEjecucionSugerido,iDinamicoEjecucionExtra,iDinamicoFinalizacionSugerido,iDinamicoFinalizacionExtra,eliminarPS,eliminarPE,eliminarES,eliminarEE,eliminarFS,eliminarFE) {

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
         var anotherDeferred = $q.defer();
         $scope.function1=function(){
             console.log($scope.idCategoria);
             switch ($scope.idCategoria) {
                 case "1":
                     $scope.banderaCategoria1=true;
                     $scope.banderaCategoria2=false;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     $scope.banderaET=false;
                     break;
                 case "2":
                     $scope.banderaCategoria1=false;
                     $scope.banderaCategoria2=true;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     $scope.banderaET=false;
                     break;
                 case "3":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=true;
                    $scope.banderaCategoria4=false;
                    $scope.banderaET=false;
                    break;
                 case "4":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=false;
                    $scope.banderaCategoria4=true;
                    $scope.banderaET=false;
                                 break;

             }
             if("undefined" !== typeof $scope.idCategoria ){
             $rootScope.listadoPrevioSugerido=previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
               console.log(result.length);
               if(result.length!=0){
               $rootScope.lonPrevi=true;

                }
               else{
                $rootScope.lonPrevi=false;
                }
              });

             $rootScope.listadoPrevioExtra=previosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
                 if(result.length!=0){
                   $rootScope.lonPreviEx=true;

                 }
                 else{
                   $rootScope.lonPreviEx=false;
                 }
              });
              $rootScope.listadoEjecucionSugerido=ejecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){
                    if(result.length!=0){
                           $rootScope.loEjec=true;

                     }
                     else{
                           $rootScope.loEjec=false;
                                                               }

              });
              $rootScope.listadoEjecucionExtra=ejecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                if(result.length!=0){
                    $rootScope.loEjecEx=true;

                                      }
                 else{
                    $rootScope.loEjecEx=false;
                                                                                        }

              });
              $rootScope.listadoFinalizacionSugerido=finalizacion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

               if(result.length!=0){
                  $rootScope.loFi=true;

               }
               else{
                  $rootScope.loFi=false;
                }

              });
              $rootScope.listadoFinalizacionExtra=finalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

                if(result.length!=0){
                      $rootScope.loFiEx=true;

                                       }
                else{
                     $rootScope.loFiEx=false;
                }

                });

                }

         }
         $scope.activated=function(a){
            console.log(a);
            switch(a){
                case "1":
                  console.log("entre");

                  $scope.lonPrevio= previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                   $scope.listadoPrevioExtra=previosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria})
                  $scope.listadoPrevioSugerido=$rootScope.listadoPrevioSugerido;

                  $scope.lonPrevioEx=$rootScope.lonPreviEx;
                  $scope.lonEjec=false;
                  $scope.lonEjecEx=false;
                  $scope.lonFi=false;
                  $scope.lonFiEx=false
                  $scope.banderaDef=false;

                break;
                case "2":
                $scope.listadoEjecucionSugerido=ejecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.listadoEjecucionExtra=ejecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.lonEjec=$rootScope.loEjec;
                $scope.lonEjecEx=$rootScope.loEjecEx;
                $scope.lonPrevio=false;
                $scope.lonPrevioEx=false;
                $scope.lonFi=false;
                $scope.lonFiEx=false
                $scope.banderaDef=false;
                break;

                case "3":
                $scope.lonEjec=false;
                $scope.lonEjecEx=false;
                $scope.lonPrevio=false;
                $scope.lonPrevioEx=false;
                $scope.banderaDef=false;

                $scope.listadoFinalizacionSugerido=finalizacion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
               $scope.listadoFinalizacionExtra=finalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.lonFi=$rootScope.loFi;
                $scope.lonFiEx=$rootScope.loFiEx;

                break;
                case "4":
                $scope.defPreviosSugeridos=defPreviosSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.defPreviosExtras=defPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.defEjecucionSugeridos=defEjecucionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.defEjecucionExtras=defEjecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.defFinalizacionSugeridos=defFinalizacionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.defFinalizacionExtras=defFinalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.lonEjec=false
                $scope.lonEjecEx=false
                $scope.lonPrevio=false;
                $scope.lonPrevioEx=false;
                $scope.lonFi=false;
                $scope.lonFiEx=false
                $scope.banderaDef=true;
                break;





            }
            //$scope.listadoPrevioSugerido=$rootScope.listadoPrevioSugerido;
            //$scope.listadoPrevioExtra=$rootScope.listadoPrevioExtra;

         }
         $scope.showAlert = function(ev) {

                 $rootScope.idCategoria=$scope.idCategoria;
                 $scope.banderaET=true;
                 //$mdDialog.show({
                                        //Controlador del mensajes con operaciones definido en la parte de abajo
                   //                     controller: DialogController,
                                       //permite la comunicacion con el html que despliega el boton requisitos
                    //                   templateUrl: 'test/test6.html',
                     //                  parent: angular.element(document.body),
                     //                  targetEvent: ev,
                     //                  clickOutsideToClose:true,
                      //                  fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                       //                 })


               };
          function DialogController($scope, $mdDialog, $rootScope,$http) {
                $scope.listadoPrevioSugerido=$rootScope.listadoPrevioSugerido;
                 $scope.listadoPrevioExtra=$rootScope.listadoPrevioExtra;
                $scope.lonEjec=$rootScope.lonEjec;
                $scope.lonEjecEx=$rootScope.lonEjecEx;
                $scope.lonFi=$rootScope.lonFi;
                $scope.lonFiEx=$rootScope.lonFiEx;
                $scope.listPrevioSugerido=[];
                $scope.listAllPrevioSugerido=[];

                $scope.listPrevioExtra=[];
                $scope.listAllPrevioExtra=[];
                $scope.listadoEjecucionSugerido=$rootScope.listadoEjecucionSugerido;
                $scope.listadoEjecucionExtra=$rootScope.listadoEjecucionExtra;
                $scope.listEjecucionSugerido=[];
                $scope.listAllEjecucionSugerido=[];

                $scope.listEjecucionExtra=[];
                $scope.listAllEjecucionExtra=[];

                $scope.listFinalizacionSugerido=[];
                $scope.listAllFinalizacionSugerido=[];

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
            $scope.eEliminarPrevios=[];
            $scope.eEliminarPreviosExtras=[];
            $scope.eEliminarEjecucion=[];
            $scope.eEliminarEjecucionExtras=[];
            $scope.eEliminarFinalizacion=[];
            $scope.eEliminarFinalizacionExtra=[];
            $scope.defPreviosSugeridos=defPreviosSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defPreviosExtras=defPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defEjecucionSugeridos=defEjecucionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defEjecucionExtras=defEjecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defFinalizacionSugeridos=defFinalizacionSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            $scope.defFinalizacionExtras=defFinalizacionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
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
            $scope.eliminar=function(ev){
              eliminarPreviosSugeridos($scope.eEliminarPrevios);
              eliminarPreviosExtras($scope.eEliminarPreviosExtras);
              eliminarEjecucionSugeridos($scope.eEliminarEjecucion);
              eliminarEjecucionExtra($scope.eEliminarEjecucionExtras);
              eliminarFinalizacion($scope.eEliminarFinalizacion);
              eliminarFinalizacionExtra($scope.eEliminarFinalizacionExtra);

              $mdDialog.show(
                                   $mdDialog.alert()
                                     .parent(angular.element(document.querySelector('#popupContainer')))
                                     .clickOutsideToClose(true)
                                     .title('Sus Requisitos han sido eliminados')
                                     .textContent('Podrá seguir agregando requisitos si lo desea.')
                                     .ariaLabel('Alert Dialog Demo')
                                     .ok('Aplique mas requisitos!')
                                     .targetEvent(ev)
                                 );


            };

            $scope.eliminar1=function(select1,item){
                        console.log(item);
                 if(select1){
                     $scope.eEliminarPrevios.push(item)
                   }
                  else if(!select1 && containsObject(item,$scope.eEliminarPrevios)){
                       var index=$scope.eEliminarPrevios.indexOf(item)
                                          if (index > -1) {
                                             $scope.eEliminarPrevios.splice(index, 1);
                                           }
                                           console.log($scope.eEliminarPrevios);
                                      }



            }
            $scope.eliminar2=function(select2,item){
                        console.log(item);
                    if(select2){
                               $scope.eEliminarPreviosExtras.push(item)
                    }
                    else if(!select2 && containsObject(item,$scope.eEliminarPreviosExtras)){
                        var index=$scope.eEliminarPreviosExtras.indexOf(item)
                        if (index > -1) {
                              $scope.eEliminarPreviosExtras.splice(index, 1);
                        }
                         console.log($scope.eEliminarPreviosExtras);
                     }



             }
            $scope.eliminar3=function(select3,item){
                       console.log(item);
               if(select3){

                   $scope.eEliminarEjecucion.push(item)
               }
               else if(!select3 && containsObject(item,$scope.eEliminarEjecucion)){
                   var index=$scope.eEliminarEjecucion.indexOf(item)
                   if (index > -1) {
                         $scope.eEliminarEjecucion.splice(index, 1);
                   }
                   console.log($scope.eEliminarEjecucion);
               }


            }
            $scope.eliminar4=function(select4,item){
                       console.log(item);
             if(select4){
                  $scope.eEliminarEjecucionExtras.push(item)
              }
              else if(!select4 && containsObject(item,$scope.eEliminarEjecucionExtras)){
                   var index=$scope.eEliminarEjecucion.indexOf(item)
                   if (index > -1) {
                         $scope.eEliminarEjecucionExtras.splice(index, 1);
                   }
                   console.log($scope.eEliminarEjecucionExtras);
              }


            }
            $scope.eliminar5=function(select5,item){
                            console.log(item);
                if(select5){
                    $scope.eEliminarFinalizacion.push(item)
                }
                else if(!select5 && containsObject(item,$scope.eEliminarFinalizacion)){
                     var index=$scope.eEliminarFinalizacion.indexOf(item)
                     if (index > -1) {
                            $scope.eEliminarFinalizacion.splice(index, 1);
                     }
                     console.log($scope.eEliminarFinalizacion);
                }

                        }
            $scope.eliminar6=function(select6,item){
                            console.log(item);
                if(select6){
                  $scope.eEliminarFinalizacionExtra.push(item)
                }
                else if(!select6 && containsObject(item,$scope.eEliminarFinalizacionExtra)){
                 var index=$scope.eEliminarFinalizacionExtra.indexOf(item)
                 if (index > -1) {
                        $scope.eEliminarFinalizacionExtra.splice(index, 1);
                 }
                 console.log($scope.eEliminarFinalizacionExtra);
                }

                }

             var eliminarPreviosSugeridos=function(lista){
                   var total=lista.length;
                    for (var i=0;i<total;i++){
                             eliminarPS.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                    }

              }
              var eliminarPreviosExtras=function(lista){
                    var total=lista.length;
                    for (var i=0;i<total;i++){
                        eliminarPE.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                     }

              }
              var eliminarEjecucionSugeridos=function(lista){
                     var total=lista.length;
                     for (var i=0;i<total;i++){
                       eliminarES.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                      }

              }
              var eliminarEjecucionExtra=function(lista){
                 var total=lista.length;
                 for (var i=0;i<total;i++){
                     eliminarES.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                 }

              }
              var eliminarFinalizacion=function(lista){
                     var total=lista.length;
                     for (var i=0;i<total;i++){
                       eliminarFS.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                     }

              }
              var eliminarFinalizacionExtra=function(lista){
                   var total=lista.length;
                   for (var i=0;i<total;i++){
                     eliminarFE.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                   }

            }

           }

}]);