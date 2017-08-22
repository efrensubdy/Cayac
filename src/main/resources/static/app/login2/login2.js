'use strict';

angular.module('myApp.login2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login2', {
    templateUrl: 'login2/login2.html',
    controller: 'Login2Ctrl'
  });
}])


.controller('Login2Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope', '$mdDialog','$http', function ($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,$http){
      var auntenticado=function(ev){
      var d;
      var e;
      var t;
      var p=function(){

        if ($localStorage.contratanteLogeado.estado && $localStorage.contratanteLogeado.rol =="Contratante"){

             $rootScope.bandera =$localStorage.contratanteLogeado.estado ;
             $rootScope.idContratante=$localStorage.contratanteLogeado.idContratante;
             delete $localStorage.userLogeado;
             $location.path("/view1");

        }
        else if ($localStorage.contratanteLogeado.estado && $localStorage.contratanteLogeado.rol =="administrador"){

                     console.log("entre a admin")
                     $rootScope.bandera3 =$localStorage.contratanteLogeado.estado ;


                     $location.path("/view1");

                }
        else{
               $rootScope.bandera = false;

                $mdDialog.show(
                                            $mdDialog.alert()
                                              .parent(angular.element(document.querySelector('#popupContainer')))
                                              .clickOutsideToClose(true)
                                              .title('Error')
                                              .textContent('El correo o la contraseña son erroneas.')
                                              .ariaLabel('Alert Dialog Demo')
                                              .ok('Intente de Nuevo!')
                                              .targetEvent(ev)
                                          );

               $scope.email="";
               $scope.password="";
               $location.path("/login2");

        }
      }

      var url2="http://localhost:8080/app/login/contratante/categoria/" + $scope.email +"/" + $scope.password;

      $http.get(url2).then(function(response){
                                       t=response.data;

                                       $localStorage.contratanteLogeado=t;
                                    return response.data;
                              }).then(p);

      }
      var idContratante
      $scope.add=function(ev){
        auntenticado(ev);


      }




}]);