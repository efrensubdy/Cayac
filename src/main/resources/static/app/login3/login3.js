'use strict';

angular.module('myApp.login3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login3', {
    templateUrl: 'login3/login3.html',
    controller: 'Login3Ctrl'
  });
}])


.controller('Login3Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope','$mdDialog','$http','rObligatorio', function ($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,$http,rObligatorio){
      $scope.banderaCandidato=$localStorage.banderaCandidato;
      $scope.banderaContratista= $localStorage.banderaContratista;
      var auntenticado=function(ev){
      var t;
      var w=function(){

            if ($localStorage.userLogeado.estado){
                        $scope.$storage = $localStorage;
                         $rootScope.bandera2 = $localStorage.userLogeado.estado;
                         $rootScope.idContratista=$localStorage.userLogeado.idContratista;
                         $rootScope.banderaEjecucion=$localStorage.userLogeado.finalista;
                         $scope.$storage = $localStorage;
                         $rootScope.email=$scope.email;
                         delete $localStorage.contratanteLogeado;
                         $location.path("/view1");



                    }
                    else{
                           $rootScope.bandera2 = false;
                             $mdDialog.show(
                                                                 $mdDialog.alert()
                                                                         .parent(angular.element(document.querySelector('#popupContainer')))
                                                                         .clickOutsideToClose(true)
                                                                         .title('Error')
                                                                         .textContent('El correo o la contraseña son erroneas o usted esta ingresando por rol que no le corresponde.')
                                                                         .ariaLabel('Alert Dialog Demo')
                                                                         .ok('Intente de Nuevo!')
                                                                         .targetEvent(ev)
                                                                     );

                           $scope.email="";
                           $scope.password="";
                           $location.path("/login3");
                    }


       }

      var url2="http://localhost:8080/app/login/contratista/categoria/" + $scope.email +"/" + $scope.password;
           $http.get(url2).then(function(response){
                                 t=response.data;
                                 console.log(t);
                                 $localStorage.userLogeado=t;
                              return response.data;
                        }).then(w);

      }
      $scope.add=function(ev){
        auntenticado(ev);


      }




}]);
