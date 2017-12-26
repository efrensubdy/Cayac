'use strict';

angular.module('myApp.indicadores', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/indicadores', {
    templateUrl: 'indicadores/indicadores.html',
    controller: 'indicadoresCtrl'
  });
}])

.controller('indicadoresCtrl', ['$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','$route','indicador','indContr','actualizarIndicador',function($location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,$route,indicador,indContr,actualizarIndicador) {
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
 $scope.closeModel= function(){
                   document.getElementById('id01').style.display='none';
           }
$scope.bandera1=false;
$scope.bandera2=false;
$scope.name=$localStorage.userLogeado.nombreEmpresa;
$scope.opciones=[
 { id: 1, name: 'AGREGAR INDICADORES'},
 { id: 2, name: 'CONSULTAR INDICADORES'},
 { id:3,  name: 'ACTULIZAR INDICADOR'}

];
$scope.years=[
     { id: 10, name: 2009},
     { id: 11, name: 2010},
     { id: 12, name: 2011},
     { id: 13, name: 2012},
     { id: 14, name: 2013},
     { id: 15, name: 2014},
     { id: 16, name: 2015},
     { id: 17, name: 2016},
     { id: 18, name: 2017},
     { id: 19, name: 2018},
     { id: 20, name: 2019},
     { id: 21, name: 2020},
     { id: 22, name: 2021},
     { id: 23, name: 2022},
     { id: 24, name: 2023},
     { id: 25, name: 2024},
     { id: 26, name: 2026},
                ];

$scope.simple2 = function(item){
   switch(item.id){
        case 1:
        $scope.bandera1=true;
        $scope.bandera2=false;
        $scope.bandera3= false;

        break;
        case 2:
        $scope.bandera1=false;
        $scope.bandera2=true;
        $scope.bandera3=false
        $scope.table=indContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante},function(list){
            if(list.length ==0){
                $scope.bandera02 = true;
                     document.getElementById('id02').style.display='block';


            }
        },function(err){
            $scope.bandera01 = true;
             document.getElementById('id01').style.display='block'



        })
        break;
        case 3:
        $scope.bandera1=false;
        $scope.bandera2=false;
        $scope.bandera3=true;
        $scope.table1=indContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante},function(list){
        if(list.length ==0){
                $scope.bandera02 = true;
                document.getElementById('id02').style.display='block';


        }
        },function(err){
             $scope.bandera01 = true;
             document.getElementById('id01').style.display='block'



        })

   }


}
$scope.meses=[
 { id: 1, name: 'ENERO'},
 { id: 2, name: 'FEBRERO'},
 { id: 3, name: 'MARZO'},
 { id: 4, name: 'ABRIL'},
 { id: 5, name: 'MAYO'},
 { id: 6, name: 'JUNIO'},
 { id: 7, name: 'JULIO'},
 { id: 8, name: 'AGOSTO'},
 { id: 9, name: 'SEPTIEMBRE'},
 { id: 10, name: 'OCTUBRE'},
 { id: 11, name: 'NOVIEMBRE'},
 { id: 12, name: 'DICIEMBRE'},

];
$scope.add = function(ev,contraName,responsable,departamento,mes,actividad,severidad,frecuencia,mortalidad,prevalencia,icidencia,ausentismo,year){

    if("undefined" !== typeof contraName && "undefined" !== typeof responsable && "undefined" !== typeof departamento && "undefined" !== typeof mes && "undefined" !== typeof actividad && "undefined" !== typeof severidad && "undefined" !== typeof frecuencia && "undefined" !== typeof mortalidad && "undefined" !== typeof prevalencia && "undefined" !== typeof icidencia && "undefined" !== typeof ausentismo && "undefined" !== typeof year  ){
         var indicadori ={"nombreContra":contraName,"mes":mes.name,"responsable":responsable,"departamento":departamento,"actividad":actividad,"severidad":severidad,"frecuencia":frecuencia,"mortalidad":mortalidad,"prevalencia":prevalencia,"incidencia":icidencia,"ausentismo":ausentismo,"idContratista":$localStorage.userLogeado.idContratista,"idContratante":$localStorage.userLogeado.idContratante,"year":year.name}
       indicador.save(indicadori,function(){
       },function(err){
             $scope.bandera01 = true;
                          document.getElementById('id01').style.display='block';
       });
         $mdDialog.show(
                              $mdDialog.alert()
                                .parent(angular.element(document.querySelector('#popupContainer')))
                                .clickOutsideToClose(true)
                                .title('Registro de Indicador completo')
                                .textContent('Estos podrán ser vistos por el Contratante.')
                                .ariaLabel('Alert Dialog Demo')
                                .ok('ok!')
                                .targetEvent(ev)
                            );

         $scope.responsable='';
         $scope.departamento='';
         $scope.mes='';
         $scope.actividad='';
         $scope.severidad='';
         $scope.frecuencia='';
         $scope.mortalidad='';
         $scope.prevalencia='';
         $scope.icidencia='';
         $scope.ausentismo='';
         $scope.year='';
    }
    else{

        $mdDialog.show(
              $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .clickOutsideToClose(true)
                .title('Algún dato quedo mal registrado')
                .textContent('Recuerde llenar todos los campos.')
                .ariaLabel('Alert Dialog Demo')
                .ok('intente de nuevo!')
                .targetEvent(ev)
                                    );
         $scope.responsable='';
         $scope.departamento='';
         $scope.mes='';
         $scope.actividad='';
         $scope.severidad='';
         $scope.frecuencia='';
         $scope.mortalidad='';
         $scope.prevalencia='';
         $scope.icidencia='';
         $scope.ausentismo='';
         $scope.year='';


    }


}
$scope.showAlert=function(ev,client){
            $rootScope.client=client

            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleIndicador.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                     clickOutsideToClose:true,
                     fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })

          }


$scope.showAlert2=function(ev,client){
            $rootScope.client=client
            $rootScope.meses =$scope.meses;
            $rootScope.years=$scope.years
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/actualiIndicador.html',
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

 function DialogController($scope, $mdDialog, $rootScope,$route){
            $scope.client= $rootScope.client;

            $scope.meses =$rootScope.meses
          $scope.years = $rootScope.years

            $scope.hide = function() {
                         $mdDialog.hide();
                       };
                       //funcion para cerral el mensaje
             $scope.cancel = function() {
                         $mdDialog.cancel();
                       };


             $scope.add =function(ev,responsable,departamento,mes,actividad,severidad,frecuencia,mortalidad,prevalencia,incidencia,ausentismo,year,client){
                 if("undefined" == typeof responsable && "undefined" == typeof departamento && "undefined" == typeof mes && "undefined" == typeof actividad && "undefined" == typeof severidad && "undefined" == typeof frecuencia && "undefined" == typeof mortalidad && "undefined" == typeof prevalencia && "undefined" == typeof icidencia && "undefined" == typeof ausentismo && "undefined" == typeof year  ){

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
                 var indicador = new Indicador();
                 console.log(client)
                 if (responsable == client.responsable || "undefined" == typeof responsable ){

                      indicador.responsable =client.responsable
                 }
                 else{

                     indicador.responsable=responsable
                 }
                 if (departamento == client.departamento || "undefined" == typeof departamento ){

                      indicador.departamento =client.departamento
                  }
                  else{

                      indicador.departamento=departamento
                  }
                  if (mes == client.mes || "undefined" == typeof mes ){

                        indicador.mes =client.mes
                    }
                    else{

                        indicador.mes=mes
                    }
                  if (actividad == client.actividad || "undefined" == typeof actividad ){

                      indicador.actividad =client.actividad
                  }
                  else{

                      indicador.actividad=actividad
                  }
                  if (severidad == client.severidad || "undefined" == typeof severidad ){

                        indicador.severidad =client.severidad
                    }
                    else{

                        indicador.severidad=severidad
                    }
                    if (frecuencia == client.frecuencia || "undefined" == typeof frecuencia ){

                        indicador.frecuencia =client.frecuencia
                    }
                    else{

                        indicador.frecuencia=frecuencia
                    }
                    if (mortalidad == client.mortalidad || "undefined" == typeof mortalidad ){

                        indicador.mortalidad =client.mortalidad
                    }
                    else{

                        indicador.mortalidad=mortalidad
                    }
                    if (prevalencia == client.prevalencia || "undefined" == typeof prevalencia ){

                        indicador.prevalencia =client.prevalencia
                    }
                    else{

                        indicador.prevalencia=prevalencia
                    }

                     if (incidencia == client.incidencia || "undefined" == typeof incidencia ){

                        indicador.incidencia =client.incidencia
                    }
                    else{

                        indicador.icidencia=icidencia
                    }
                     if (ausentismo == client.ausentismo || "undefined" == typeof ausentismo ){

                    indicador.ausentismo =client.ausentismo
                                     }
                     else{

                         indicador.ausentismo=ausentismo
                     }
                      if (year == client.year || "undefined" == typeof year ){

                     indicador.year =client.year
                                      }
                      else{

                          indicador.year=year
                      }


                  indicador.idContratista=$localStorage.userLogeado.idContratista;
                  indicador.id = client.id;
                  console.log(indicador);
                 actualizarIndicador.save(indicador);
                 $mdDialog.show(
                      $mdDialog.alert()
                         .parent(angular.element(document.querySelector('#popupContainer')))
                         .clickOutsideToClose(true)
                         .title('Exito !!')
                         .textContent('Puede revisar nuevamente o consultar sus indicadores.')
                         .ariaLabel('Alert Dialog Demo')
                         .ok('ok!')
                         .targetEvent(ev)
                                         );






                }
                 $route.reload();


             }




           }



           function Indicador(){



           }



}]);