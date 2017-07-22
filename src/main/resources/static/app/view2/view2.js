'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])


.controller('View2Ctrl', ['$localStorage','$sessionStorage','$mdDialog','$location','$rootScope','$scope', 'contratistas','contratos','activity', function ($localStorage,$sessionStorage,$mdDialog,$location,$rootScope,$scope, contratistas,contratos,activity)  {
      $scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante})
      $scope.listini=activity.query();
      $scope.add=function(ev){
        console.log($scope.contrato)
        var contratista={"nombreEmpresa":$scope.nombreEmpresa,"duracionContrato":$scope.duracionContrato,"nit":$scope.nit,"codigoCIIU":$scope.codigoCIIU,"nombreDeGerenteGeneral":$scope.nombreDeGerenteGeneral,"email":$scope.email,"arl":$scope.arl,"direccion":$scope.direccion,"departamento":$scope.departamento,"password":$scope.password,"telefono":$scope.telefono,"contratante":$rootScope.idContratante,"personContacto":$scope.personContacto,"cargoPersonaContacto":$scope.cargoPersonaContacto,"telefonoPersonaContacto":$scope.telefonoPersonaContacto,"emailContacto":$scope.emailContacto,"idContrato":$scope.contrato};
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
        $scope.telefonoPersonaContacto=''
        $scope.emailContacto=''
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


}]);