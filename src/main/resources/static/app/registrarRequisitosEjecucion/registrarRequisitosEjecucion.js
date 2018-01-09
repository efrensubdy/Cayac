'use strict';

angular.module('myApp.registrarRequisitosEjecucion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registrarRequisitosEjecucion', {
    templateUrl: 'registrarRequisitosEjecucion/registrarRequisitosEjecucion.html',
    controller: 'registrarRequisitosEjecucionCtrl'
  });
}])

.controller('registrarRequisitosEjecucionCtrl', ['$location','$localStorage','$sessionStorage','$mdDialog','$rootScope', '$http', '$scope','$q','previos','previosExtras','insertarPrevioSugerido','insertarPrevioExtra','defPreviosSugeridos','defPreviosExtras','eliminarPS','eliminarPE',function($location,$localStorage,$sessionStorage,$mdDialog,$rootScope, $http, $scope,$q,previos,previosExtras,insertarPrevioSugerido,insertarPrevioExtra,defPreviosSugeridos,defPreviosExtras,eliminarPS,eliminarPE) {
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
 $scope.idCategoria=undefined;
 $scope.listPrevioSugerido=[];
 $scope.listAllPrevioSugerido=[];
 $scope.listPrevioExtra=[];
 $scope.listAllPrevioExtra=[];
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

             switch ($scope.idCategoria) {
                 case "1":
                     $scope.banderaCategoria1=true;
                     $scope.banderaCategoria2=false;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     $scope.banderaET=false;
                     $scope.ciclo=undefined;
                     $scope.lonPrevio=false;
                     $scope.banderaDef = false;
                     $scope.lonPrevioEx=false;
                     break;
                 case "2":
                     $scope.banderaCategoria1=false;
                     $scope.banderaCategoria2=true;
                     $scope.banderaCategoria3=false;
                     $scope.banderaCategoria4=false;
                     $scope.banderaET=false;
                     $scope.ciclo=undefined;
                     $scope.lonPrevio=false;
                     $scope.lonPrevioEx=false;
                     $scope.banderaDef = false;
                     break;
                 case "3":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=true;
                    $scope.banderaCategoria4=false;
                    $scope.banderaET=false;
                    $scope.ciclo=undefined;
                    $scope.lonPrevio=false;
                    $scope.banderaDef = false;
                    $scope.lonPrevioEx=false;
                    break;
                 case "4":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=false;
                    $scope.banderaCategoria3=false;
                    $scope.banderaCategoria4=true;
                    $scope.banderaET=false;
                    $scope.ciclo=undefined;
                    $scope.lonPrevio=false;
                    $scope.banderaDef = false;
                    $scope.lonPrevioEx=false;
                                 break;

             }
             if("undefined" !== typeof $scope.idCategoria ){
             $rootScope.listadoPrevioSugerido=previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria},function(result){

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

                $rootScope.lonPrevi=$rootScope.lonPrevi || $rootScope.lonPreviEx;

         }
         }
         $scope.activated=function(a){

            switch(a){
                case "1":


                  $scope.lonPrevio= $rootScope.listadoPrevioSugerido;
                  if (!$scope.lonprevio){
                    $scope.linea1=true;

                  }
                   $scope.listadoPrevioExtra=previosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria})
                  $scope.listadoPrevioSugerido=previos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});


                  $scope.mensajillo1=false;
                  $scope.mensajillo3=false;
                  $scope.mensajillo5=false;
                  $scope.banderaDef=false;

                break;
                case "2":
                $scope.defPreviosSugeridos=defPreviosSugeridos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria},function(){
                },function(err){
                    $scope.bandera01 = true;
                     document.getElementById('id01').style.display='block';
                });
                $scope.defPreviosExtras=defPreviosExtras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria},function(){
                },function(err){
                     $scope.bandera01 = true;
                     document.getElementById('id01').style.display='block';
                });


                $scope.lonPrevio=false;
                $scope.lonPrevioEx=false;

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
           $scope.eliminar=function(ev){
             eliminarPreviosSugeridos($scope.eEliminarPrevios);
             eliminarPreviosExtras($scope.eEliminarPreviosExtras);


                 $mdDialog.show(
                                      $mdDialog.alert()
                                        .parent(angular.element(document.querySelector('#popupContainer')))
                                        .clickOutsideToClose(true)
                                        .title('Sus Requisitos han sido eliminados')
                                        .textContent('Podrá seguir eliminando requisitos si lo desea.')
                                        .ariaLabel('Alert Dialog Demo')
                                        .ok('Aplique mas requisitos!')
                                        .targetEvent(ev)
                                    );
                 $scope.banderaET=false;
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


            $scope.eliminar1=function(select1,item){

             if(select1){
                 $scope.eEliminarPrevios.push(item)
               }
              else if(!select1 && containsObject(item,$scope.eEliminarPrevios)){
                   var index=$scope.eEliminarPrevios.indexOf(item)
                    if (index > -1) {
                    $scope.eEliminarPrevios.splice(index, 1);
                    }

               }
            }
            $scope.eliminar2=function(select2,item){

                if(select2){
                           $scope.eEliminarPreviosExtras.push(item)
                }
                else if(!select2 && containsObject(item,$scope.eEliminarPreviosExtras)){
                    var index=$scope.eEliminarPreviosExtras.indexOf(item)
                    if (index > -1) {
                          $scope.eEliminarPreviosExtras.splice(index, 1);
                    }

                 }
             }

         $scope.aplicarPrevioSugerido=function(ev){
          var a=$scope.listPrevioSugerido.length;
          var b=$scope.listAllPrevioSugerido.length;
          var a2=$scope.listPrevioExtra.length;
          var b2=$scope.listAllPrevioExtra.length;
          if(a>b || a2>b2){

             agregarBaseDatosPreviosSugeridos($scope.listPrevioSugerido);
            agregarBaseDatosPreviosExtras($scope.listPrevioExtra);
             $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Sus Requisitos han sido registrados')
                    .textContent('Podrá seguir agregando requisitos si lo desea.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Aplique mas requisitos!')
                    .targetEvent(ev)
                );
                $scope.banderaET=false;
                $scope.ciclo = undefined;
                $scope.lonPrevio = false;
                $scope.banderaDef = false;
                $scope.mensajillo1=false;

          }
          else if(a==0 && b==0 && a2==0 && b2==0 ){

          $scope.mensajillo1=true

          }
          else{

             agregarBaseDatosPreviosSugeridos($scope.listAllPrevioSugerido);
             agregarBaseDatosPreviosExtras($scope.listAllPrevioExtra);
             $mdDialog.show(
                               $mdDialog.alert()
                                 .parent(angular.element(document.querySelector('#popupContainer')))
                                 .clickOutsideToClose(true)
                                 .title('Sus Requisitos han sido registrados')
                                 .textContent('Podrá seguir agregando requisitos si lo desea.')
                                 .ariaLabel('Alert Dialog Demo')
                                 .ok('Aplique mas requisitos!')
                                 .targetEvent(ev)
                             );
             $scope.banderaET=false;
             $scope.ciclo= undefined;
             $scope.lonPrevio = false;
             $scope.banderaDef = false;

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

               insertarPrevioSugerido.save(requisitoObligatorio);

           }
          }

          var agregarBaseDatosPreviosExtras=function(lista){
           var total=lista.length;
              for (var i=0;i<total;i++){
                var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};

                 insertarPrevioExtra.save(requisitoExtra);

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


}]);