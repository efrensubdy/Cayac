'use strict';

angular.module('myApp.view13', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view13', {
    templateUrl: 'view13/view13.html',
    controller: 'View13Ctrl'
  });
}])

.controller('View13Ctrl', ['$localStorage','$sessionStorage','$scope','$rootScope','$http','$mdDialog','nuevoContrato','fileUpload','$q',function($localStorage,$sessionStorage,$scope,$rootScope,$http,$mdDialog,nuevoContrato,fileUpload,$q) {
$scope.contrato={};

$scope.options = [
                            { id: 1, name: 'Contrato' },
                            { id: 2, name: 'Orden de Servicio' },

                          ];

var deferred=$q.defer();
$scope.add=function(ev){

    $scope.listaDocumentos=[];
    var contrato={"nombreContrato":$scope.contrato.nombreContrato,"fechaInicio":$scope.contrato.fechaInicio,"fechaFin":$scope.contrato.fechaFin,"idContratante":$localStorage.contratanteLogeado.idContratante,"tipoContrato":$scope.contrato.tipoContrato}
    $scope.listaDocumentos.push($scope.myFile);
    $scope.listaDocumentos.push($scope.myFile2);
    $scope.listaDocumentos.push($scope.myFile3);


    deferred.resolve(contrato);
    $scope.div1.$setPristine();
    $scope.div1.$setUntouched();
    $scope.contrato.nombreContrato='';
    $scope.contrato.fechaInicio='';
    $scope.contrato.tipoContrato='';
    $scope.contrato.fechaFin='';

}
deferred.promise.then(function(object){
            nuevoContrato.save(object).$promise.then(function(){
                  $mdDialog.show(
                                        $mdDialog.alert()
                                         .parent(angular.element(document.querySelector('#popupContainer')))
                                         .clickOutsideToClose(true)
                                         .title('Su Contrato quedo totalmente creado')
                                         .textContent('agregue contratistas a su contrato.')
                                         .ariaLabel('Alert Dialog Demo')
                                         .ok('mire nuevamente!')
                                         .targetEvent(ev)
                                           );


            });

            console.log(object)
            console.log("hice la primera")
            return object

        })
        .then(function(object){
            console.log(object)
            for (var i=0;i<10;i++){
                console.log(i);
            }
            console.log("hice la segunda")


             return object
        })
        .then(function(object){
             console.log("hice la tercera")
            console.log(object)



        });


}])
.directive('fileModel', ['$parse', function ($parse) {
      return {
             restrict: 'A',
             link: function(scope, element, attrs) {
                 var model, modelSetter;

                 attrs.$observe('fileModel', function(fileModel){
                     model = $parse(attrs.fileModel);
                     modelSetter = model.assign;
                 });

                 element.bind('change', function(){
                     scope.$apply(function(){
                         modelSetter(scope.$parent, element[0].files[0]);
                     });
                 });
             }
         };

 }]);