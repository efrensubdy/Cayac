'use strict';

angular.module('myApp.actualizarInformacion', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/actualizarInformacion', {
    templateUrl: 'actualizarInformacion/actualizarInformacion.html',
    controller: 'actualizarInformacionCtrl'
  });
}])

.controller('actualizarInformacionCtrl', ['$route','$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$window','contratistasPorContratante','actualizarInfo',function($route,$mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$window,contratistasPorContratante,actualizarInfo) {
$scope.bandera1 = false;
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

$scope.arls =[

                  { id: 1, name: "Sura"},
                  { id: 2, name: "Bolivar"},
                  { id: 3, name: "Equidad"},
                  { id: 4, name: "Aurora"},
                  { id: 5, name: "Colpatria"},
                  { id: 6, name: "Positiva"},
                  { id: 7, name: "Liberty"},
                  { id: 8, name: "Mapfre"},
                  { id: 9, name: "Colmena"},
                  { id: 10, name: "Alfa"},

              ];

$scope.departamentos =[
                    { id: 1, name: "Bogotá D.C"},
                    { id: 2, name: "La Guajira"},
                    { id: 3, name: "Magdalena"},
                    { id: 4, name: "Guaviare"},
                    { id: 5, name: "Boyaca"},
                    { id: 6, name: "Valle del Cauca"},
                    { id: 7, name: "Amazonas"},
                    { id: 8, name: "Meta"},
                    { id: 9, name: "Antioquia"},
                    { id: 10, name: "Cauca"},
                    { id: 11, name: "Caldas"},
                    { id: 12, name: "Caqueta"},
                    { id: 13, name: "Casanare"},
                    { id: 14, name: "Cesar"},
                    { id: 15, name: "Choco"},
                    { id: 16, name: "Cordoba"},
                    { id: 17, name: "Guanía"},
                    { id: 18, name: "Huila"},
                    { id: 19, name: "Nariño"},
                    { id: 20, name: "Norte de Santander"},
                    { id: 21, name: "Putumayo"},
                    { id: 22, name: "Quindio"},
                    { id: 23, name: "Risaralda"},
                    { id: 24, name: "San Andrés"},
                    { id: 25, name: "Santander"},
                    { id: 26, name: "Sucre"},
                    { id: 27, name: "Tolima"},
                    { id: 28, name: "Vaupes"},
                    { id: 29, name: "Vichada"},
                    { id: 30, name: "Bolivar"},



                    ];

$scope.show = function(ciclo){
$scope.conf=true;
$scope.client=ciclo
switch ($scope.client.duracionContrato){
                    case 0 :
                        $scope.duracion= 'MENOS DE UN MES';
                    break;
                    case 1 :
                         $scope.duracion= 'MAS DE TRES MESES';
                      break;
                    case 2 :
                         $scope.duracion= 'MAS DE 6 MESES';
                     break;
                    case 3 :
                         $scope.duracion= 'MAS DE UN AÑO';
                     break;



                }
$scope.arl=$scope.arls[$scope.client.arl-1]
$scope.departamento=$scope.departamentos[$scope.client.departamento-1];

}
$scope.listado = contratistasPorContratante.query({"idContratante":$localStorage.contratanteLogeado.idContratante})

$scope.closeModel= function(){

        document.getElementById('id01').style.display='none';
  }
var openModel = function(){
      $scope.bandera1= true;
      document.getElementById('id01').style.display='block';

}

$scope.add =function(ev,nombreEmpresa,nit,nombreDeGerenteGeneral,ar,direccion,dpto,telefono,personContacto,cargoPersonaContacto,telefonoPersonaContacto,emailContacto,ciclo){
if("undefined" == typeof nombreEmpresa && "undefined" == typeof nit &&  "undefined" == typeof nombreDeGerenteGeneral &&  "undefined" == typeof ar && "undefined" == typeof direccion && "undefined" == typeof dpto &&  "undefined" == typeof telefono &&  "undefined" == typeof personContacto && "undefined" == typeof cargoPersonaContacto && "undefined" == typeof telefonoPersonaContacto && "undefined" == typeof emailContacto){

$mdDialog.show(
                          $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Debe registrar al menos un dato')
                            .textContent('Recuerde llenar todos los campos y poner correos validos.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('intente de nuevo!')
                            .targetEvent(ev)
                                            );


}
else{
        var contratista = new Contratista();
        if (nombreEmpresa == ciclo.nombreEmpresa || "undefined" == typeof nombreEmpresa ){

            contratista.nombreEmpresa =ciclo.nombreEmpresa
        }
        else{

            contratista.nombreEmpresa=nombreEmpresa
        }
         if (nit == ciclo.nit || "undefined" == typeof nit){

            contratista.nit=ciclo.nit
         }
         else{

            contratista.nit=nit
         }
         if (nombreDeGerenteGeneral == ciclo.nombreDeGerenteGeneral || "undefined" == typeof nombreDeGerenteGeneral ){

                     contratista.nombreDeGerenteGeneral=ciclo.nombreDeGerenteGeneral
                  }
          else{

                     contratista.nombreDeGerenteGeneral=nombreDeGerenteGeneral
                  }
          if (ar == ciclo.arl || "undefined" == typeof ar){

               contratista.arl=$scope.arls[ciclo.arl-1].name;

            }
           else{

            contratista.arl=ar
                        }

        if (direccion == ciclo.direccion || "undefined" == typeof direccion){

           contratista.direccion=ciclo.direccion
        }
          else{

               contratista.direccion=direccion
            }
         if (dpto == $scope.departamento || "undefined" == typeof dpto){

           contratista.departamento=$scope.departamentos[ciclo.departamento-1].name;


        }
      else{

           contratista.departamento=dpto
        }
     if (telefono == $scope.telefono || "undefined" == typeof telefono){

                contratista.telefono=ciclo.telefono
             }
       else{
            console.log("hubo cambio")
            contratista.telefono=telefono
         }
          if (personContacto == $scope.personContacto || "undefined" == typeof personContacto){

             contratista.personContacto=ciclo.personContacto
          }
        else{

            contratista.personContacto=personContacto
              }
         if (cargoPersonaContacto == $scope.cargoPersonaContacto || "undefined" == typeof cargoPersonaContacto){

              contratista.cargoPersonaContacto=ciclo.cargoPersonaContacto
           }
         else{

              contratista.cargoPersonaContacto=cargoPersonaContacto
           }
        if (telefonoPersonaContacto == $scope.telefonoPersonaContacto || "undefined" == typeof telefonoPersonaContacto ){

                  contratista.telefonoPersonaContacto=ciclo.telefonoPersonaContacto
               }
         else{

                  contratista.cargoPersonaContacto=telefonoPersonaContacto
               }
        if (emailContacto == $scope.emailContacto || "undefined" == typeof emailContacto){

              contratista.emailContacto=ciclo.emailContacto
           }
        else{

                                  contratista.emailContacto=emailContacto
                               }
    contratista.id = ciclo.id
    console.log(contratista);
   actualizarInfo.save(contratista,function(){


    },function(err){
        console.log("llegue rapidito")
        openModel()
        $window.alert("No se pudo actualizar, Comuniquese con SEQ ");



   }
   )

   $mdDialog.show(
       $mdDialog.alert()
        .parent(angular.element(document.querySelector('#popupContainer')))
        .clickOutsideToClose(true)
        .title('Exito !!')
        .textContent('Puede revisar nuevamente o consultar a sus contratistas.')
        .ariaLabel('Alert Dialog Demo')
        .ok('ok!')
        .targetEvent(ev)
                      );


}
 $route.reload();

}

function Contratista(){



}

}]);