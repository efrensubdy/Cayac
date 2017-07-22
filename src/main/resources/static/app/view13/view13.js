'use strict';

angular.module('myApp.view13', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view13', {
    templateUrl: 'view13/view13.html',
    controller: 'View13Ctrl'
  });
}])

.controller('View13Ctrl', ['$localStorage','$sessionStorage','$scope','$rootScope','$http','$mdDialog','nuevoContrato',function($localStorage,$sessionStorage,$scope,$rootScope,$http,$mdDialog,nuevoContrato) {
$scope.contrato={};

$scope.options = [
                            { id: 1, name: 'Contrato' },
                            { id: 2, name: 'Orden de Servicio' },

                          ];


$scope.add=function(ev){
var contrato={"nombreContrato":$scope.contrato.nombreContrato,"fechaInicio":$scope.contrato.fechaInicio,"fechaFin":$scope.contrato.fechaFin,"idContratante":$localStorage.contratanteLogeado.idContratante,"tipoContrato":$scope.contrato.tipoContrato}
console.log(contrato);
nuevoContrato.save(contrato);
 $mdDialog.show(
            $mdDialog.alert()
             .parent(angular.element(document.querySelector('#popupContainer')))
             .clickOutsideToClose(true)
             .title('Su Contrato quedo totalmente creado')
             .textContent('agregue contratistas a su contrato.')
             .ariaLabel('Alert Dialog Demo')
             .ok('mire nuevamente!')
             .targetEvent(ev)
               );
 $scope.div1.$setPristine();
 $scope.div1.$setUntouched();
 $scope.contrato.nombreContrato='';
 $scope.contrato.fechaInicio='';
 $scope.contrato.tipoContrato='';
 $scope.contrato.fechaFin='';
}

}]);