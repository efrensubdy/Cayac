'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$location','$localStorage','$sessionStorage','requisitosEEliminar','contratantesCategoria','$rootScope','$scope','contratos', 'contratantesContrato','requisitos','extras','requisitosObligatorios','requisitosExtras','rObligatorio','rExtra','fabrica','$mdDialog','limites','requisitosOEliminar','$http','fechaLimiteContratante',function($location,$localStorage,$sessionStorage,requisitosEEliminar,contratantesCategoria,$rootScope,$scope,contratos,contratantesContrato,requisitos,extras,requisitosObligatorios,requisitosExtras,rObligatorio,rExtra,fabrica,$mdDialog,limites,requisitosOEliminar,$http,fechaLimiteContratante) {
        $scope.idCategoria = undefined;
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
        $scope.band45=false;
        $scope.flag=false;
        $scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
        };
        $scope.listadoSugerido=[];
        $scope.listadoExtra=[];
        $scope.listadoAllSugerido=[];
        $scope.listadoAllExtra=[];
        $scope.listadoSugeridoE=[];
        $scope.listadoExtraE=[];
        $scope.listadoAllSugeridoE=[];
        $scope.listadoAllExtraE=[]
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
                    $scope.ciclo=undefined;
                    $scope.table1=false;
                    $scope.table2=false;
                    $scope.banderaFecha=false;
                    $scope.band45=false;

                    break;
                case "2":
                    $scope.banderaCategoria1=false;
                    $scope.banderaCategoria2=true;
                    $scope.banderaCategoria3=false;
                    $scope.banderaCategoria4=false;

                    $scope.ciclo=undefined;
                    $scope.table1=false;
                       $scope.table2=false;
                       $scope.banderaFecha=false;
                    $scope.band45=false;


                    break;
                case "3":
                   $scope.banderaCategoria1=false;
                   $scope.banderaCategoria2=false;
                   $scope.banderaCategoria3=true;
                   $scope.banderaCategoria4=false;
                   $scope.table1=false;
                   $scope.ciclo=undefined;
                   $scope.table1=false;
                    $scope.table2=false;
                    $scope.banderaFecha=false;
                    $scope.band45=false;

                   break;
                case "4":
                   $scope.banderaCategoria1=false;
                   $scope.banderaCategoria2=false;
                   $scope.banderaCategoria3=false;
                   $scope.banderaCategoria4=true;
                   $scope.table1=false;
                   $scope.table2=false;
                   $scope.banderaFecha=false;
                   $scope.ciclo=undefined;
                    $scope.band45=false;

                                break;



            }



        }
        $scope.activated=function(a){
            switch (a) {
                case "1":
                $scope.table1=false;
                $scope.table2=false;
                $scope.banderaFecha=true;
                q($localStorage.contratanteLogeado.idContratante,$scope.idCategoria);

                break;
                case "2":
                $scope.table2=false;
                $scope.listado2=requisitos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria})
                $scope.listado3=extras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria})
                $scope.table1=true;
                 $scope.banderaFecha=false;
                break;
                case "3":
                $scope.table1=false;
                $scope.list4=rObligatorio.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.list5=rExtra.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                $scope.table2=true;
                 $scope.banderaFecha=false;

                break;



            }



        }


         $scope.showAlert = function(ev) {

                $rootScope.idCategoria=$scope.idCategoria;
                $scope.banderaLista=true;
                $scope.band45=true;


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
                          //funcion display toma el elemento seleccionado y lo agrega a la fabrica de
                          // requisitos obligatorios sugeridos
              $scope.display = function(selected, item) {

                             if(selected){
                                  console.log(item);
                                   $scope.listadoSugerido.push(item);
                             }
                             else if(!selected && containsObject(item, $scope.listadoSugerido)){
                                                    var index= $scope.listadoSugerido.indexOf(item)
                                                      if (index > -1) {
                                                          $scope.listadoSugerido.splice(index, 1);
                                                       }
                                                       console.log( $scope.listadoSugerido);
                                                  }

                             }
                          //funcion display toma el elemento seleccionado y lo agrega a la fabrica de
                           // requisitos obligatorios Extras
              $scope.display2=function(select, item) {

                              if(select){
                                     console.log(item);
                                     $scope.listadoExtra.push(item);

                              }
                              else if(!select && containsObject(item, $scope.listadoExtra)){
                                   var index= $scope.listadoExtra.indexOf(item)
                                       if (index > -1) {
                                               $scope.listadoExtra.splice(index, 1);
                                                                       }
                                                  console.log( $scope.listadoExtra);
                                   }




                         };

                           $scope.all=function(master){
                                      console.log(master);
                                      if(!master){
                                      $scope.selected=true;
                                      $scope.listadoAllSugerido=$rootScope.listado2;
                                      $scope.select=true;
                                      $scope.listadoAllExtra=$rootScope.listado3;
                                      }
                                      else{
                                       $scope.selected=false;
                                       $scope.listadoAllSugerido=[];
                                       $scope.select=false;
                                       $scope.listadoAllExtra=[];
                                      }
                           };


                         //la funcion aplicar termina la accion y obliga al uduario a refrescar la vista de requisito
                         $scope.aplicar=function(ev){
                              var a=$scope.listadoSugerido.length;
                              var b=$scope.listadoAllSugerido.length;
                              var a2=$scope.listadoExtra.length;
                               var b2=$scope.listadoAllExtra.length
                              if(a>b || a2>b2){
                              console.log("entre a sugeridos")
                              agregarBaseDatosSugeridos($scope.listadoSugerido);
                              agregarBaseExtras($scope.listadoExtra);
                              $scope.mensajillo=false;
                              $mdDialog.show(
                                          $mdDialog.alert()
                                          .parent(angular.element(document.querySelector('#popupContainer')))
                                          .clickOutsideToClose(true)
                                          .title('Sus Requisitos han quedado establecidos')
                                          .textContent('el contratista deberá cumplir esto.')
                                          .ariaLabel('Alert Dialog Demo')
                                           .ok('Mire Definitivos!')
                                           .targetEvent(ev)
                                      );
                               $scope.table1 = false;
                               $scope.table2 = false;
                               $scope.ciclo = undefined;
                                $scope.mensajillo=false;
                              }
                              else if(a==0 && b==0 && a2==0 && b2==0){
                               $scope.mensajillo=true;
                              }
                              else{
                              console.log("entre a all sugeridos")
                              agregarBaseDatosSugeridos($scope.listadoAllSugerido);
                              agregarBaseExtras($scope.listadoAllExtra);
                               $mdDialog.show(
                                    $mdDialog.alert()
                                    .parent(angular.element(document.querySelector('#popupContainer')))
                                    .clickOutsideToClose(true)
                                    .title('Sus Requisitos han quedado establecidos')
                                    .textContent('el contratista deberá cumplir esto.')
                                    .ariaLabel('Alert Dialog Demo')
                                     .ok('Mire Definitivos!')
                                     .targetEvent(ev)
                                );
                                 $scope.table1 = false;
                                 $scope.table2 = false;
                                 $scope.ciclo = undefined;
                                 $scope.mensajillo=false;
                              }




                         };

                         var agregarBaseDatosSugeridos=function(lista){
                               var total=lista.length;
                              for (var i=0;i<total;i++){
                                  var requisitoObligatorio={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].numero};
                                  console.log(requisitoObligatorio);
                                  console.log(total);
                                  requisitosObligatorios.save(requisitoObligatorio);

                              }






                         }
                          var agregarBaseExtras=function(lista){
                                          var total=lista.length;
                                         for (var i=0;i<total;i++){
                                           var requisitoExtra={"idContratante":$localStorage.contratanteLogeado.idContratante,"idCategoria":$rootScope.idCategoria,"idRequisito":lista[i].id};
                                            console.log(total);
                                            console.log(requisitoExtra);
                                            requisitosExtras.save(requisitoExtra);

                                         }


                          }

                          $scope.fun=function(ev){
                                  e(ev);

                                 }
                           var e=function(ev){
                                              $scope.date2=$scope.fecha;
                                              var fechaLimite={fechaFin:$scope.fecha,idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria}
                                              limites.save(fechaLimite);
                                               $mdDialog.show(
                                                      $mdDialog.alert()
                                                      .parent(angular.element(document.querySelector('#popupContainer')))
                                                      .clickOutsideToClose(true)
                                                      .title('Su Días han quedado establecidos')
                                                      .textContent('el contratista deberá cumplir esto.')
                                                      .ariaLabel('Alert Dialog Demo')
                                                       .ok('mire nuevamente!')
                                                       .targetEvent(ev)
                                                                                 );

                                            }
              $scope.display3=function(selected, item) {
                              if(selected){
                                     console.log(item);
                                     $scope.listadoSugeridoE.push(item);
                                     requisitosOEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":item.idRequisito});

                              }
                              else if(!selected && containsObject(item, $scope.listadoSugerido)){
                                    var index= $scope.listadoSugerido.indexOf(item)
                                     if (index > -1) {
                                           $scope.listadoSugeridoE.splice(index, 1);
                                      }

                               }

                                   };

                       $scope.display4=function(select, item) {
                                   if(select){
                                      console.log(item)
                                      $scope.listadoExtraE.push(item);
                                      requisitosEEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":item.idRequisito})
                                   }
                                   else if(!selected && containsObject(item, $scope.listadoSugerido)){
                                     var index= $scope.listadoSugerido.indexOf(item)
                                      if (index > -1) {
                                             $scope.listadoSugeridoE.splice(index, 1);
                                      }

                                   }


                                     };

                        $scope.eliminar=function(ev){
                                                eliminarSugeridos($scope.listadoSugeridoE);
                                                eliminarExtras($scope.listadoExtraE);


                        };

                        var eliminarSugeridos=function(lista){
                                     var total=lista.length;
                                     for (var i=0;i<total;i++){
                                        requisitosOEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});

                                     }

                                  }
                                 var eliminarExtras=function(lista){
                                   var total=lista.length;
                                   for (var i=0;i<total;i++){
                                      requisitosEEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":lista[i].idRequisito});


                                   }

                                 }


                          var q=function(idContratante, idCategoria){
                                     //var url= "http://localhost:8080/app/limites/"+idContratante+"/"+idCategoria ;
                                      var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/limites/"+idContratante+"/"+idCategoria ;
                                     $http.get(url).then(function(response) {
                                                   if(response.data.flag){
                                                  $scope.objeto=response.data;
                                                   }
                                                   return response.data;
                                                })
                                        }








}]);