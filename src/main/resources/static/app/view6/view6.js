'use strict';

angular.module('myApp.view6', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view6', {
    templateUrl: 'view6/view6.html',
    controller: 'View6Ctrl'
  });
}])

.controller('View6Ctrl', ['$localStorage','$sessionStorage','$location','$rootScope','$scope','$mdDialog','loginContratante',function($localStorage,$sessionStorage,$location,$rootScope,$scope,$mdDialog,loginContratante) {

//la funcion add se encarga de recibir los datos que se van  a cambiar y realiza los cambios
//mandandolo a la fabrica que cambia la contraseña de los contratantes
$scope.add=function(ev){
        var user={"idContratante":$localStorage.contratanteLogeado.idContratante,"password":$scope.password};
        loginContratante.save(user);
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