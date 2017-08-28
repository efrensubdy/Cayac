'use strict';

angular.module('myApp.inicio', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/inicio', {
    templateUrl: 'inicio/inicio.html',
    controller: 'inicioCtrl'
  });
}])

.controller('inicioCtrl', ['$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$location',function($timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$location) {



}]);