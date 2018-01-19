'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])


.controller('View2Ctrl', ['$localStorage','$sessionStorage','$mdDialog','$location','$rootScope','$scope', 'contratistas','contratosEjecucion','activity','serviciosAContrar','correos', function ($localStorage,$sessionStorage,$mdDialog,$location,$rootScope,$scope, contratistas,contratosEjecucion,activity,serviciosAContrar,correos)  {
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
      $scope.listado=serviciosAContrar.query({idContratante:$localStorage.contratanteLogeado.idContratante})
      $scope.listini=activity.query();
      $scope.correos =correos.query();
      $scope.buscarCorreos =function(email,lista){
                  var a = false;

                  if("undefined" !== typeof email){

                  for(var i=0;i<lista.length;i++){

                      if(lista[i].email == email){

                            a= true;
                      }
                  }

                   if(a){
                   $scope.message="Ya se ecuentra registrado";
                   }

                   else if(email.length==0 && !a){
                      $scope.message="";

                   }
                   else{
                   $scope.message="Es valido";
                   }
                  }
                  else{
                       $scope.message = "";
                  }

            }
      $scope.options = [
                          { id: 0, name: 'MENOS DE UN MES' },
                          { id: 1, name: 'MAS DE TRES MESES' },
                          {id:  2, name:'MAS DE 6 MESES'},
                          {id:  3,name:'MAS DE UN AÑO'}

                        ];

      $scope.add=function(ev){

        if("undefined" !== typeof $scope.nombreEmpresa && "undefined" !== typeof $scope.duracionContrato.id && "undefined" !== typeof $scope.nit && "undefined" !== typeof $scope.codigoCIIU && "undefined" !== typeof $scope.nombreDeGerenteGeneral && "undefined" !== typeof $scope.email && "undefined" !== typeof $scope.arl && "undefined" !== typeof $scope.direccion && "undefined" !== typeof $scope.departamento && "undefined" !== typeof $scope.password && "undefined" !== typeof $scope.telefono && "undefined" !== typeof $localStorage.contratanteLogeado.idContratante && "undefined" !== typeof $scope.personContacto && "undefined" !== typeof $scope.cargoPersonaContacto && "undefined" !== typeof $scope.telefonoPersonaContacto && "undefined" !== typeof $scope.emailContacto && "undefined" !== typeof $scope.contrato ){

       var contratista={"nombreEmpresa":$scope.nombreEmpresa,"duracionContrato":$scope.duracionContrato.id,"nit":$scope.nit,"codigoCIIU":$scope.codigoCIIU,"nombreDeGerenteGeneral":$scope.nombreDeGerenteGeneral,"email":$scope.email,"arl":$scope.arl,"direccion":$scope.direccion,"departamento":$scope.departamento,"password":$scope.password,"telefono":$scope.telefono,"contratante":$localStorage.contratanteLogeado.idContratante,"personContacto":$scope.personContacto,"cargoPersonaContacto":$scope.cargoPersonaContacto,"telefonoPersonaContacto":$scope.telefonoPersonaContacto,"emailContacto":$scope.emailContacto,"idContrato":$scope.contrato.id};
        console.log(contratista);
        contratistas.save(contratista);
        $scope.nombreEmpresa='';
        $scope.duracionContrato='';
        $scope.nit='';
        $scope.codigoCIIU='';
        $scope.nombreDeGerenteGeneral='';
        $scope.email='';
        $scope.arl='';
        $scope.direccion='';
        $scope.departamento='';
        $scope.password='';
        $scope.telefono='';
        $scope.personContacto='';
        $scope.cargoPersonaContacto='';
        $scope.telefonoPersonaContacto='';
        $scope.emailContacto=''
        $scope.contrato='';
        $scope.label='';
        $mdDialog.show(
                     $mdDialog.alert()
                       .parent(angular.element(document.querySelector('#popupContainer')))
                       .clickOutsideToClose(true)
                       .title('Registro de Candidato completo')
                       .textContent('Ahora podra tener control sobre este candidato.')
                       .ariaLabel('Alert Dialog Demo')
                       .ok('mire a sus candidatos!')
                       .targetEvent(ev)
                   );

        }
        else{
         $mdDialog.show(
                              $mdDialog.alert()
                                .parent(angular.element(document.querySelector('#popupContainer')))
                                .clickOutsideToClose(true)
                                .title('Algún dato quedo mal registrado')
                                .textContent('Recuerde llenar todos los campos y poner correos validos.')
                                .ariaLabel('Alert Dialog Demo')
                                .ok('intente de nuevo!')
                                .targetEvent(ev)
                            );



        }
      }
      $scope.alertCodigo=function(item,codigoCUU){
              var activity;
              for(activity in item){
                 if( item[activity].codigoCUU==codigoCUU){
                      $scope.codigoSeleccionado=item[activity].descripcion

                 }

              }

            }


}]);