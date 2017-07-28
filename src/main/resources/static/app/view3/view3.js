'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', ['$localStorage','$sessionStorage','requisitosEEliminar','contratantesCategoria','$rootScope','$scope','contratos', 'contratantesContrato','requisitos','extras','requisitosObligatorios','requisitosExtras','rObligatorio','rExtra','fabrica','$mdDialog','limites','requisitosOEliminar','$http',function($localStorage,$sessionStorage,requisitosEEliminar,contratantesCategoria,$rootScope,$scope,contratos,contratantesContrato,requisitos,extras,requisitosObligatorios,requisitosExtras,rObligatorio,rExtra,fabrica,$mdDialog,limites,requisitosOEliminar,$http) {

        $scope.flag=false;
        $scope.propertyName = 'nombreEmpresa';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
        };
        $scope.listado23=[];
        $scope.listado32=[];
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
            $scope.listado23=requisitos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
            $scope.listado32=extras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});

        }

         $scope.showAlert = function(ev,a,b) {
                //listado 2 sera la lista de requisitos sugeridos por el id del contratista
                //presionadoo en la ejecucion solicitado a la fabrica requisitos
                var url= "http://localhost:8080/app/limites/"+$localStorage.contratanteLogeado.idContratante+"/"+$scope.idCategoria ;
                $http.get(url).then(function(response) {
                                                   if(response.data.flag){
                                                            $scope.objeto=response.data;

                                                            }
                                                                                                 return response.data;
                )
                 $rootScope.listado2=requisitos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                 $rootScope.listado3=extras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});

                               console.log(a);
                                console.log(b);
                                if(a==0 && b!=0){
                                     $rootScope.table1=false;
                                     $rootScope.table2=true;
                                }
                               else if(b==0 && a!=0){
                                    $rootScope.table2=false;
                                    $rootScope.table1=true
                               }
                               else if(a!=0 && b!=0){
                                    $rootScope.table1=true;
                                    $rootScope.table2=true;
                               }
                               else{
                                    $rootScope.table1=false;
                                    $rootScope.table2=false;
                               }

                $rootScope.idCategoria=$scope.idCategoria;
                //listado 3 sera la lista de requisitos extras por el id del contratista
                 //presionadoo en la ejecucion  a la fabrica extras
                //$rootScope.idTemp=client.id;
                $mdDialog.show({
                      //Controlador del mensajes con operaciones definido en la parte de abajo
                      controller: DialogController,
                     // permite la comunicacion con el html que despliega el boton requisitos
                     templateUrl: 'test/test.html',
                      parent: angular.element(document.body),
                      targetEvent: ev,
                      clickOutsideToClose:true,
                      fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                      })

                $scope.listado23=requisitos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});
                $scope.listado32=extras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$scope.idCategoria});

              };


         function DialogController($scope, $mdDialog, $rootScope,$http) {
            // se obtienen ambas listas
            $scope.listadoSugerido=[];
            $scope.listadoExtra=[];
            $scope.listadoAllSugerido=[];
            $scope.listadoAllExtra=[];
            $scope.table1=$rootScope.table1;
            $scope.table2=$rootScope.table2;
           $scope.listado2= requisitos.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
           $scope.listado3= extras.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
            //funcion que esconde el dialogo

            $scope.hide = function() {
              $mdDialog.hide();
            };
            //funcion para cerral el mensaje
            $scope.cancel = function() {
              $mdDialog.cancel();
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
                        }
                        else{
                        $scope.selected=false;
                         $scope.listadoAllSugerido=[];
                        }
             };
             $scope.all2=function(master2){
                      if(!master2){
                        $scope.select=true;
                        $scope.listadoAllExtra=$rootScope.listado3;
                      }
                      else{
                        $scope.select=false;
                        $scope.listadoAllExtra=[];
                      }
             };

           //la funcion aplicar termina la accion y obliga al uduario a refrescar la vista de requisito
           $scope.aplicar=function(ev){
                var a=$scope.listadoSugerido.length;
                var b=$scope.listadoAllSugerido.length;
                if(a>b){
                console.log("entre a sugeridos")
                agregarBaseDatosSugeridos($scope.listadoSugerido);
                }
                else{
                console.log("entre a all sugeridos")
                agregarBaseDatosSugeridos($scope.listadoAllSugerido);
                }
                 $mdDialog.show({

                                   controller: DialogController3,
                                                     // permite la comunicacion con el html que despliega el boton requisitos
                                   templateUrl: 'test/mensajeDeConfirmacion.html',
                                   parent: angular.element(document.body),
                                   targetEvent: ev,
                                   clickOutsideToClose:true,
                                   fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                      })




           };
           $scope.aplicar2=function(ev){
                           var a=$scope.listadoExtra.length;
                           var b=$scope.listadoAllExtra.length
                           if(a>b){
                            console.log("entre a extras")
                           agregarBaseExtras($scope.listadoExtra);
                           }
                           else{
                           console.log("entre a ALL extras")
                           agregarBaseExtras($scope.listadoAllExtra);
                           }
             $mdDialog.show({
                                              //Controlador del mensajes con operaciones definido en la parte de abajo
                                              controller: DialogController3,
                                              // permite la comunicacion con el html que despliega el boton requisitos
                                              templateUrl: 'test/mensajeDeConfirmacion.html',
                                              parent: angular.element(document.body),
                                              targetEvent: ev,
                                              clickOutsideToClose:true,
                                              fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                                                 })


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


           $scope.consultar = function(){
                      $scope.list1=rObligatorio.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                      $scope.list2=rExtra.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});


                      };
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




      }
      function DialogController2($scope, $mdDialog, $rootScope,$http){
        $scope.list1=rObligatorio.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
        $scope.listadoSugeridoE=[];
        $scope.listadoExtraE=[];
        $scope.listadoAllSugeridoE=[];
        $scope.listadoAllExtraE=[];
        $scope.list2=rExtra.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
                        $scope.hide = function() {
                          $mdDialog.hide();
                        };
                        //funcion para cerral el mensaje
                        $scope.cancel = function() {
                          $mdDialog.cancel();
                        };

        $scope.consultar = function(){
               $scope.list1=rObligatorio.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});
               $scope.list2=rExtra.query({idContratante:$localStorage.contratanteLogeado.idContratante,idCategoria:$rootScope.idCategoria});


         };
        $scope.display3=function(selected, item) {
                if(selected){
                       console.log(item);
                       $scope.listadoSugeridoE.push(item);
                       //requisitosOEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":item.idRequisito});

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
                        //requisitosEEliminar.remove({"idContratante":$localStorage.contratanteLogeado.idContratante,"idRequisito":item.idRequisito})
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
                                  $mdDialog.show({
                                     //Controlador del mensajes con operaciones definido en la parte de abajo
                                     controller: DialogController,
                                    // permite la comunicacion con el html que despliega el boton requisitos
                                    templateUrl: 'test/test.html',
                                     parent: angular.element(document.body),
                                     targetEvent: ev,
                                     clickOutsideToClose:true,
                                     fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                   })

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



    }
    function DialogController3($scope, $mdDialog, $rootScope,$http){

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
                   controller: DialogController2,
                                     // permite la comunicacion con el html que despliega el boton requisitos
                   templateUrl: 'test/definitivosSeleccion.html',
                   parent: angular.element(document.body),
                   targetEvent: ev,
                   clickOutsideToClose:true,
                   fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                      })




    }

    }




}]);