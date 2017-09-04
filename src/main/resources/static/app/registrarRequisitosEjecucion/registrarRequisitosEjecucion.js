'use strict';

angular.module('myApp.registrarRequisitosEjecucion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registrarRequisitosEjecucion', {
    templateUrl: 'registrarRequisitosEjecucion/registrarRequisitosEjecucion.html',
    controller: 'registrarRequisitosEjecucionCtrl'
  });
}])

.controller('registrarRequisitosEjecucionCtrl', ['$localStorage','$sessionStorage','$mdDialog','$rootScope', '$http', '$scope','$q','previos','previosExtras','ejecucion','ejecucionExtras','finalizacion','finalizacionExtras','insertarPrevioSugerido','insertarPrevioExtra','insertarEjecucionSugerido','insertarEjecucionExtra','insertarFinalizacionSugerido','insertarFinalizacionExtra','defPreviosSugeridos','defPreviosExtras','defEjecucionSugeridos','defEjecucionExtras','defFinalizacionSugeridos','defFinalizacionExtras','dinamicosPrevios','dinamicosPreviosExtras','dinamicosEjecucion','dinamicosEjecucionExtras','dinamicosFinalizacion','dinamicosFinalizacionExtras','iDinamicoPrevioSugerido','iDinamicoPrevioExtra','iDinamicoEjecucionSugerido','iDinamicoEjecucionExtra','iDinamicoFinalizacionSugerido','iDinamicoFinalizacionExtra' ,'eliminarPS','eliminarPE','eliminarES','eliminarEE','eliminarFS','eliminarFE',function($localStorage,$sessionStorage,$mdDialog,$rootScope, $http, $scope,$q,previos,previosExtras,ejecucion,ejecucionExtras,finalizacion,finalizacionExtras,insertarPrevioSugerido,insertarPrevioExtra,insertarEjecucionSugerido,insertarEjecucionExtra,insertarFinalizacionSugerido,insertarFinalizacionExtra,defPreviosSugeridos,defPreviosExtras,defEjecucionSugeridos,defEjecucionExtras,defFinalizacionSugeridos,defFinalizacionExtras,dinamicosPrevios,dinamicosPreviosExtras,dinamicosEjecucion,dinamicosEjecucionExtras,dinamicosFinalizacion,dinamicosFinalizacionExtras,iDinamicoPrevioSugerido,iDinamicoPrevioExtra,iDinamicoEjecucionSugerido,iDinamicoEjecucionExtra,iDinamicoFinalizacionSugerido,iDinamicoFinalizacionExtra,eliminarPS,eliminarPE,eliminarES,eliminarEE,eliminarFS,eliminarFE) {
 $scope.listPrevioSugerido=[];
 $scope.listAllPrevioSugerido=[];
 $scope.listPrevioExtra=[];
 $scope.listAllPrevioExtra=[];
 $scope.listEjecucionSugerido=[];
 $scope.listAllEjecucionSugerido=[];
 $scope.listEjecucionExtra=[];
 $scope.listAllEjecucionExtra=[];
 $scope.listFinalizacionSugerido=[];
 $scope.listAllFinalizacionSugerido=[];
 $scope.listFinalizacionExtra=[];
 $scope.listFinalizacionSugerido=[];
 $scope.listAllFinalizacionExtra=[];
 $scope.eEliminarPrevios=[];
 $scope.eEliminarPreviosExtras=[];
 $scope.eEliminarEjecucion=[];
 $scope.eEliminarEjecucionExtras=[];
 $scope.eEliminarFinalizacion=[];
 $scope.eEliminarFinalizacionExtra=[];

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
                $rootScope.lonPrevi=$rootScope.lonPrevi || $rootScope.lonPreviEx;
                $rootScope.lonEjec= $rootScope.lonEjec || $rootScope.lonEjecEx;
                  $rootScope.lonFi= $rootScope.lonFi || $rootScope.lonFiEx;


         }
         $scope.activated=function(a){
            console.log(a);
            switch(a){
                case "1":
                  console.log("entre");

                  $scope.lonPrevio= $rootScope.listadoPrevioSugerido;
                  if (!$scope.lonprevio){
                    $scope.linea1=true;

                  }
                   $scope.listadoPrevioExtra=previosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria})
                  $scope.listadoPrevioSugerido=previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                  $scope.lonEjec=false;
                  $scope.lonEjecEx=false;
                  $scope.lonFi=false;
                  $scope.lonFiEx=false
                  $scope.banderaDef=false;
                  $scope.mensajillo1=false;
                  $scope.mensajillo3=false;
                  $scope.mensajillo5=false;

                break;
                case "2":
                $scope.listadoEjecucionSugerido=ejecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.listadoEjecucionExtra=ejecucionExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.lonEjec=$rootScope.loEjec;
                if (!$scope.lonEjec){
                   $scope.linea2=true;

                                  }

                $scope.lonPrevio=false;
                $scope.lonPrevioEx=false;
                $scope.lonFi=false;
                $scope.lonFiEx=false
                $scope.banderaDef=false;
                $scope.mensajillo1=false;
                $scope.mensajillo3=false;
                $scope.mensajillo5=false;

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
                console.log($scope.lonFi)
                if (!$scope.lonFi){
                    $scope.linea3=true;

                }
                $scope.mensajillo1=false;
                $scope.mensajillo3=false;
                $scope.mensajillo5=false;


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
                $scope.mensajillo1=false;
                $scope.mensajillo3=false;
                $scope.mensajillo5=false;

                break;





            }


         }
         $scope.showAlert = function(ev) {

                 $rootScope.idCategoria=$scope.idCategoria;
                 $scope.banderaET=true;



          };
          $scope.agregarPrevioSugerido=function(previoSugerido,item){
              if(previoSugerido){
              $scope.listPrevioSugerido.push(item)
              }
              else if(!previoSugerido && containsObject(item,$scope.listPrevioSugerido)){
               var index=$scope.listPrevioSugerido.indexOf(item)
                    if (index > -1) {
                        $scope.listPrevioSugerido.splice(index, 1);

                    }


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
           $scope.allPreviosSugeridos=function(masterPrevioSugerido){
               if(!masterPrevioSugerido){
                   $scope.previoSugerido=true;
                   $scope.listAllPrevioSugerido=$rootScope.listadoPrevioSugerido;
                   $scope.previoExtras=true;
                   $scope.listAllPrevioExtra=$rootScope.listadoPrevioExtra;
               }
               else{
                   $scope.previoSugerido=false;
                   $scope.listAllPrevioSugerido=[];
                   $scope.previoExtras=false;
                   $scope.listAllPrevioExtra=[];
               }
            };

            $scope.allEjecucionSugerido=function(masterEjecucionSugerido){
               if(!masterEjecucionSugerido){
                 $scope.ejecucionSugerido=true;
                 $scope.listAllEjecucionSugerido=$rootScope.listadoEjecucionSugerido;
                 $scope.ejecucionExtra=true;
                 $scope.listAllEjecucionExtra=$rootScope.listadoEjecucionExtra;
                }
                else{
                  $scope.ejecucionSugerido=false;
                  $scope.listAllEjecucionSugerido=[];
                  $scope.ejecucionExtra=false;
                  $scope.listAllEjecucionExtra=[];
                }

            };

            $scope.allFinalizacionSugerido=function(masterFinalizacionSugerido){
               if(!masterFinalizacionSugerido){
                 $scope.finalizacionSugerido=true;
                 $scope.listAllFinalizacionSugerido=$rootScope.listadoFinalizacionSugerido;
                 $scope.finalizacionExtra=true;
                 $scope.listAllFinalizacionExtra=$rootScope.listadoFinalizacionExtra;
               }
               else{
                 $scope.finalizacionSugerido=false;
                 $scope.listAllFinalizacionSugerido=[];
                 $scope.finalizacionExtra=false;
                 $scope.listAllFinalizacionExtra=[];
                }
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



         $scope.aplicarPrevioSugerido=function(ev){
          var a=$scope.listPrevioSugerido.length;
          var b=$scope.listAllPrevioSugerido.length;
          var a2=$scope.listPrevioExtra.length;
          var b2=$scope.listAllPrevioExtra.length;
          if(a>b || a2>b2){
             console.log("entre a sugeridos")
             agregarBaseDatosPreviosSugeridos($scope.listPrevioSugerido);
            agregarBaseDatosPreviosExtras($scope.listPrevioExtra);
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

          }
          else if(a==0 && b==0 && a2==0 && b2==0 ){

          $scope.mensajillo1=true

          }
          else{
             console.log("entre a all sugeridos")
             agregarBaseDatosPreviosSugeridos($scope.listAllPrevioSugerido);
             agregarBaseDatosPreviosExtras($scope.listAllPrevioExtra);
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

          }

         };
         $scope.aplicarEjecucionSugerido=function(ev){
            var a=$scope.listEjecucionSugerido.length;
            var b=$scope.listAllEjecucionSugerido.length;
            var a2=$scope.listEjecucionExtra.length;
            var b2=$scope.listAllEjecucionExtra.length;
             if(a>b || a2 >b2){
                console.log("entre a sugeridos")
                agregarBaseDatosEjecucionSugeridos($scope.listEjecucionSugerido);
                agregarBaseDatosEjecucionExtras($scope.listEjecucionExtra);
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Sus Requisitos han  quedado asignados')
                    .textContent('Podrá seguir agregando requisitos si lo desea.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Mire sus definitivos!')
                    .targetEvent(ev)
                 );

             }
             else if(a==0 && b==0 && a2==0 && b2==0 ){

                  $scope.mensajillo3=true

             }
             else{
                console.log("entre a all sugeridos")
                agregarBaseDatosEjecucionSugeridos($scope.listAllEjecucionSugerido);
                agregarBaseDatosEjecucionExtras($scope.listAllEjecucionExtra);
                 $mdDialog.show(
                      $mdDialog.alert()
                        .parent(angular.element(document.querySelector('#popupContainer')))
                        .clickOutsideToClose(true)
                        .title('Sus Requisitos han  quedado asignados')
                        .textContent('Podrá seguir agregando requisitos si lo desea.')
                        .ariaLabel('Alert Dialog Demo')
                        .ok('Mire sus definitivos!')
                        .targetEvent(ev)
                  );

             }

          };
          $scope.aplicarFinalizacionSugerido=function(ev){
              var a=$scope.listFinalizacionSugerido.length;
              var b=$scope.listAllFinalizacionSugerido.length;
              var a2=$scope.listadoFinalizacionExtra.length;
              var b2=$scope.listAllFinalizacionExtra.length;
              if(a>b  || a2>b2){
                 console.log("entre a sugeridos")
                 agregarBaseDatosFinalizacionSugeridos($scope.listFinalizacionSugerido);
                 agregarBaseDatosFinalizacionExtras($scope.listadoFinalizacionExtra);
                  $mdDialog.show(
                       $mdDialog.alert()
                         .parent(angular.element(document.querySelector('#popupContainer')))
                         .clickOutsideToClose(true)
                         .title('Sus Requisitos han  quedado asignados')
                         .textContent('Podrá seguir agregando requisitos si lo desea.')
                         .ariaLabel('Alert Dialog Demo')
                         .ok('Mire sus definitivos!')
                         .targetEvent(ev)
                  );

              }
              else if(a==0 && b==0 && a2==0 && b2==0 ){

                 $scope.mensajillo5=true

                                   }
              else{
                 console.log("entre a all sugeridos")
                 agregarBaseDatosFinalizacionSugeridos($scope.listAllFinalizacionSugerido);
                 agregarBaseDatosFinalizacionExtras($scope.listAllFinalizacionExtra);
                  $mdDialog.show(
                       $mdDialog.alert()
                         .parent(angular.element(document.querySelector('#popupContainer')))
                         .clickOutsideToClose(true)
                         .title('Sus Requisitos han  quedado asignados')
                         .textContent('Podrá seguir agregando requisitos si lo desea.')
                         .ariaLabel('Alert Dialog Demo')
                         .ok('Mire sus definitivos!')
                         .targetEvent(ev)
                                   );

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

}]);