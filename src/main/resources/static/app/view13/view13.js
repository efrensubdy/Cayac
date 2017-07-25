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
var defer= $q.defer();

$scope.add=function(ev){

    $scope.listaDocumentos=[];
    var contrato={"nombreContrato":$scope.contrato.nombreContrato,"fechaInicio":$scope.contrato.fechaInicio,"fechaFin":$scope.contrato.fechaFin,"idContratante":$localStorage.contratanteLogeado.idContratante,"tipoContrato":$scope.contrato.tipoContrato}
    $scope.listaDocumentos.push($scope.myFile);
    $scope.listaDocumentos.push($scope.myFile2);
    $scope.listaDocumentos.push($scope.myFile3);


    defer.resolve(contrato);
    $scope.div1.$setPristine();
    $scope.div1.$setUntouched();
    $scope.contrato.nombreContrato='';
    $scope.contrato.fechaInicio='';
    $scope.contrato.tipoContrato='';
    $scope.contrato.fechaFin='';

}
defer.promise.then(function(object){
            //nuevoContrato.save(object);
            console.log("hice la primera")
            return object

        })
        .then(function(object){
             console.log("hice la segunda")

             //for(contratico in lista){
               //  var uploadUrl = 'http://localhost:8080/app/contratos/documentoContrato'+ "/"+ $localStorage.contratanteLogeado.idContratante;
                 //console.log(lista[contratico]);
                // console.log(uploadFileToUrl);
                  // fileUpload.uploadFileToUrl($scope.listaDocumentos[contratico], uploadUrl);
              //}
             return object
        })
        .then(function(object){
            console.log(object)
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