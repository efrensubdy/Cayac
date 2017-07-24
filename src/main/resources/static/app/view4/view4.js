'use strict';

angular.module('myApp.view4', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view4', {
    templateUrl: 'view4/view4.html',
    controller: 'View4Ctrl'
  });
}])


.controller('View4Ctrl', ['$location','$scope', 'contratantes','$mdDialog','activity', function ($location,$scope, contratantes,$mdDialog,activity)  {
      //la funcion add se encarga de recibir los datos del nuevo contratante y agregarlo a la fabrica de
      //contratantes y también limpia el formulario
      $scope.listini=activity.query();
      $scope.add=function(ev){
        console.log($scope.departamento);

        var contratante={"nombreEmpresa":$scope.nombreEmpresa,"telefono":$scope.telefono,"email":$scope.email,"password":$scope.password,"departamento":$scope.departamento,"direccion":$scope.direccion,"representanteLegal":$scope.representanteLegal,"codigoCIIU":$scope.codigoCIIU};
        contratantes.save(contratante);

          $scope.nombreEmpresa='';
          $scope.telefono='';
          $scope.email='';
          $scope.password='';
          $scope.departamento='';
          $scope.direccion='';
          $scope.representanteLegal='';
          $scope.codigoCIIU='';
          $mdDialog.show(
             $mdDialog.alert()
               .parent(angular.element(document.querySelector('#popupContainer')))
               .clickOutsideToClose(true)
               .title('Registro de Contratante completo')
               .textContent('Ahora eres parte de nosotros.')
               .ariaLabel('Alert Dialog Demo')
               .ok('Bienvenido!')
               .targetEvent(ev)
           );



      };
      $scope.alertCodigo=function(item,codigoCUU){
        var activity;
        for(activity in item){
           if( item[activity].codigoCUU==codigoCUU){
                $scope.codigoSeleccionado=item[activity].descripcion

           }

        }

      }
}]);