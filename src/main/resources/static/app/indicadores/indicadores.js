'use strict';

angular.module('myApp.indicadores', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/indicadores', {
    templateUrl: 'indicadores/indicadores.html',
    controller: 'indicadoresCtrl'
  });
}])

.controller('indicadoresCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','indicador',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,indicador) {
$scope.name=$localStorage.userLogeado.nombreEmpresa;
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
$scope.add = function(ev,contraName,responsable,departamento,mes,actividad,severidad,frecuencia,mortalidad,prevalencia,icidencia,ausentismo){

    if("undefined" !== typeof contraName && "undefined" !== typeof responsable && "undefined" !== typeof departamento && "undefined" !== typeof mes && "undefined" !== typeof actividad && "undefined" !== typeof severidad && "undefined" !== typeof frecuencia && "undefined" !== typeof mortalidad && "undefined" !== typeof prevalencia && "undefined" !== typeof icidencia && "undefined" !== typeof ausentismo  ){
         var indicadori ={"nombreContra":contraName,"mes":mes.name,"responsable":responsable,"departamento":departamento,"actividad":actividad,"severidad":severidad,"frecuencia":frecuencia,"mortalidad":mortalidad,"prevalencia":prevalencia,"incidencia":icidencia,"ausentismo":ausentismo,"idContratista":$localStorage.userLogeado.idContratista,"idContratante":$localStorage.userLogeado.idContratante}
         indicador.save(indicadori);
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


    }


}



}]);