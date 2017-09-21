'use strict';

angular.module('myApp.mensajeria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mensajeria', {
    templateUrl: 'mensajeria/mensajeria.html',
    controller: 'mensajeriaCtrl'
  });
}])

.controller('mensajeriaCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','mensajeContr',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,mensajeContr) {

    $scope.listadoMensajes=mensajeContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante});


}]);