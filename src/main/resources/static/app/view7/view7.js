'use strict';

angular.module('myApp.view7', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view7', {
    templateUrl: 'view7/view7.html',
    controller: 'View7Ctrl'
  });
}])

.controller('View7Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope','$mdDialog','loginContratista',function($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,loginContratista) {

//la funcion add se encarga de recibir los datos que se van  a cambiar y realiza los cambios
//mandandolo a la fabrica que cambia la contraseña de los contratantes
$scope.add=function(ev){
        var user={"idContratista":$localStorage.userLogeado.idContratista,"password":$scope.password};
        loginContratista.save(user);
        $scope.contra='';
        $scope.password='';
         $mdDialog.show(
                             $mdDialog.alert()
                               .parent(angular.element(document.querySelector('#popupContainer')))
                               .clickOutsideToClose(true)
                               .title('Nueva Contraseña Registrada')
                               .textContent('Recuerde Utilizar Esta nueva Contraseña.')
                               .ariaLabel('Alert Dialog Demo')
                               .ok('ok!')
                               .targetEvent(ev)
                           );

        }
}]);