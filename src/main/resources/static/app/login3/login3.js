'use strict';

angular.module('myApp.login3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login3', {
    templateUrl: 'login3/login3.html',
    controller: 'Login3Ctrl'
  });
}])


.controller('Login3Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope','$mdDialog','$http','rObligatorio', function ($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,$http,rObligatorio){
      var auntenticado=function(ev){
      var t;
      var w=function(){

            if ($localStorage.userLogeado.estado){
                        $scope.$storage = $localStorage;
                         $rootScope.bandera2 = $localStorage.userLogeado.estado;
                         $rootScope.idContratista=$localStorage.userLogeado.idContratista;
                         $scope.$storage = $localStorage;
                         $rootScope.email=$scope.email;
                         $location.path("/view1");



                    }
                    else{
                           $rootScope.bandera2 = false;
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
                           $location.path("/login3");
                    }


       }

      var url2="http://localhost:8080/app/login/contratista/categoria/" + $scope.email +"/" + $scope.password;
           $http.get(url2).then(function(response){
                                 t=response.data;
                                 $localStorage.userLogeado=t;
                              return response.data;
                        }).then(w);

      }
      $scope.add=function(ev){
        auntenticado(ev);


      }




}]);
