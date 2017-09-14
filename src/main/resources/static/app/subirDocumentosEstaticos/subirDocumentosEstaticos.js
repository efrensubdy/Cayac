'use strict';

angular.module('myApp.subirDocumentosEstaticos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/subirDocumentosEstaticos', {
    templateUrl: 'subirDocumentosEstaticos/subirDocumentosEstaticos.html',
    controller: 'subirDocumentosEstaticosCtrl'
  });
}])

.controller('subirDocumentosEstaticosCtrl', ['$localStorage','$sessionStorage','$http','$parse','$scope','$rootScope','$mdDialog','fileUpload','estadoPreviosSugeridos','estadoPreviosExtras',function($localStorage,$sessionStorage,$http,$parse,$scope,$rootScope,$mdDialog,fileUpload,estadoPreviosSugeridos,estadoPreviosExtras) {
       $scope.file = "";

       $scope.agregarEstaticosSugeridosPrevios = function(ev,item) {
            var file = $scope.myDocSugeridoPrevio;
            var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoSugerido" ;

            fileUpload.uploadFileToUrl(file, uploadUrl);
            $mdDialog.show(
                      $mdDialog.alert()
                      .parent(angular.element(document.querySelector('#popupContainer')))
                      .clickOutsideToClose(true)
                       .title('Subido !!!')
                       .textContent('Su archivo se he subido correctamente.')
                       .ariaLabel('Alert Dialog Demo')
                       .ok('ok!')
                        .targetEvent(ev)
                                               );


        };
        $scope.agregarEstaticosExtrasPrevios = function(ev,item) {
                    var file = $scope.myDocExtraPrevio;
                    console.log(file);
                    console.log(item.id)
                    var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoExtra" ;
                    console.log(uploadUrl)
                    fileUpload.uploadFileToUrl(file, uploadUrl);
                    $mdDialog.show(
                              $mdDialog.alert()
                              .parent(angular.element(document.querySelector('#popupContainer')))
                              .clickOutsideToClose(true)
                               .title('Subido !!!')
                               .textContent('Su archivo se he subido correctamente.')
                               .ariaLabel('Alert Dialog Demo')
                               .ok('ok!')
                                .targetEvent(ev)
                                                       );


                };


        $scope.defPreviosSugeridos=estadoPreviosSugeridos.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.defPreviosExtras=estadoPreviosExtras.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.propertyName = 'descripcion';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
          $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
          $scope.propertyName = propertyName;
        };


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

 }]);;
