'use strict';

angular.module('myApp.reporteDeIndicadores', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/reporteDeIndicadores', {
    templateUrl: 'reporteDeIndicadores/reporteDeIndicadores.html',
    controller: 'reporteDeIndicadoresCtrl'
  });
}])

.controller('reporteDeIndicadoresCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','repMes','repYear',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,repMes,repYear) {
$scope.mensual=false;
 $scope.anual=false;
 $scope.bandera1=false;
  $scope.bandera2=false;
$scope.opciones=[
{id:1,name:"Reporte Mensual de Indicadores de  Contratistas"},
{id:2,name:"Reporte anual de Indicadores de Contratistas"},


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

$scope.soporteDeMes=function(mes,year){
        $scope.reporMes=repMes.query({idContratante:$localStorage.contratanteLogeado.idContratante,mes:mes.name,year:year.name})
        $scope.bandera1=true;
          $scope.bandera2=false;

}
$scope.soporteDeYear=function(year){
        $scope.reporYear=repYear.query({idContratante:$localStorage.contratanteLogeado.idContratante,year:year.name})
          $scope.bandera1=false;
                  $scope.bandera2=true;

}
$scope.simple=function(opcion){
switch(opcion.id){
    case 1:
       $scope.mensual=true;
       $scope.anual=false;
       $scope.bandera1=false;
         $scope.bandera2=false;
    break;
    case 2:
     $scope.mensual=false;
      $scope.anual=true;
      $scope.bandera1=false;
        $scope.bandera2=false;
    break;

}


}
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


}]);