'use strict';

angular.module('myApp.login2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login2', {
    templateUrl: 'login2/login2.html',
    controller: 'Login2Ctrl'
  });
}])


.controller('Login2Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope', '$mdDialog','$http', function ($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,$http){
      $scope.progressBandera=false;
      $scope.value=0;
      var auntenticado=function(ev){
      var d;
      var e;
      var t;
      $scope.value=60;
      var p=function(){

        if ($localStorage.contratanteLogeado.estadoDatabase =="activo" && $localStorage.contratanteLogeado.rol =="Contratante"){

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

               $scope.progressBandera=false;
               $rootScope.bandera = false;

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
               $location.path("/login2");

        }
      }

      //var url2="http://localhost:8080/app/login/contratante/categoria/" + $scope.email +"/" + $scope.password;
      var url2="http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/login/contratante/categoria/" + $scope.email +"/" + $scope.password;
      $http.get(url2).then(function(response){
                                           t=response.data;
                                           console.log(response.data);

                                       $localStorage.contratanteLogeado=t;

                                    return response.data;
                              }).then(p);


      }
      var idContratante

      $scope.add=function(ev){
        $scope.progressBandera=true;
        $scope.value=20
        auntenticado(ev);


      }




}]);