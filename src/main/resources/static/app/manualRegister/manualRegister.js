'use strict';

angular.module('myApp.manualRegister', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/manualRegister', {
    templateUrl: 'manualRegister/manualRegister.html',
    controller: 'manualRegisterCtrl'
  });
}])

.controller('manualRegisterCtrl', ['$localStorage','$sessionStorage','$location','$scope','$rootScope','$mdDialog','finalistas','registroManualFinalista','contratosEjecucion','activity',function($localStorage,$sessionStorage,$location,$scope,$rootScope,$mdDialog,finalistas,registroManualFinalista,contratosEjecucion,activity) {

      $scope.listado=contratosEjecucion.query({idContratante:$localStorage.contratanteLogeado.idContratante})
      $scope.listini=activity.query();
      $scope.options = [
                                { id: 0, name: 'MENOS DE UN MES' },
                                { id: 1, name: 'MAS DE TRES MESES' },
                                {id:  2, name:'MAS DE 6 MESES'},
                                {id:  3,name:'MAS DE UN AÑO'}

                              ];
      $scope.add=function(ev){

      var contratista={"nombreEmpresa":$scope.nombreEmpresa,"duracionContrato":$scope.duracionContrato.id,"nit":$scope.nit,"codigoCIIU":$scope.codigoCIIU,"nombreDeGerenteGeneral":$scope.nombreDeGerenteGeneral,"email":$scope.email,"arl":$scope.arl,"direccion":$scope.direccion,"departamento":$scope.departamento,"password":$scope.password,"telefono":$scope.telefono,"contratante":$localStorage.contratanteLogeado.idContratante,"personContacto":$scope.personContacto,"cargoPersonaContacto":$scope.cargoPersonaContacto,"telefonoPersonaContacto":$scope.telefonoPersonaContacto,"emailContacto":$scope.emailContacto,"idContrato":$scope.contrato};
      registroManualFinalista.save(contratista);
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
        $scope.telefonoPersonaContacto=''
        $scope.emailContacto=''
        $scope.label =  '';
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
      $scope.alertCodigo=function(item,codigoCUU){
                    var activity;
                    for(activity in item){
                       if( item[activity].codigoCUU==codigoCUU){
                            $scope.codigoSeleccionado=item[activity].descripcion

                       }

                    }

                  }





}]);