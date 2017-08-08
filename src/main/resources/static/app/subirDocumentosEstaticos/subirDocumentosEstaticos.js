'use strict';

angular.module('myApp.subirDocumentosEstaticos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/subirDocumentosEstaticos', {
    templateUrl: 'subirDocumentosEstaticos/subirDocumentosEstaticos.html',
    controller: 'subirDocumentosEstaticosCtrl'
  });
}])

.controller('subirDocumentosEstaticosCtrl', ['$localStorage','$sessionStorage','$http','$parse','$scope','$rootScope','$mdDialog','fileUpload','estadoPreviosSugeridos','estadoPreviosExtras','estadoEjecucionSugeridos','estadoEjecucionExtras','estadoFinalizacionSugeridos','estadoFinalizacionExtras',function($localStorage,$sessionStorage,$http,$parse,$scope,$rootScope,$mdDialog,fileUpload,estadoPreviosSugeridos,estadoPreviosExtras,estadoEjecucionSugeridos,estadoEjecucionExtras,estadoFinalizacionSugeridos,estadoFinalizacionExtras) {
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
         $scope.agregarEstaticosSugeridosEjecucion = function(ev,item) {
                            var file = $scope.myDocSugeridoEjecucion;
                            console.log(file);
                            console.log(item.id)
                            var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/ejecucionSugerido" ;
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

        $scope.agregarEstaticosExtrasEjecucion = function(ev,item) {
                           var file = $scope.myDocExtraEjecucion;
                           console.log(file);
                           console.log(item.id)
                           var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/ejecucionExtra" ;
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
         $scope.agregarEstaticosSugeridosFinalizacion = function(ev,item) {
                            var file = $scope.myDocSugeridoFinalizacion;
                            console.log(file);
                            console.log(item.id)
                            var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/finalizacionSugerido" ;
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
         $scope.agregarEstaticosExtrasFinalizacion = function(ev,item) {
                            var file = $scope.myDocExtraFinailizacion;
                            console.log(file);
                            console.log(item.id)
                            var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/finalizacionExtra" ;
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
        $scope.defEjecucionSugeridos=estadoEjecucionSugeridos.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.defEjecucionExtras=estadoEjecucionExtras.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.defFinalizacionSugeridos=estadoFinalizacionSugeridos.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.defFinalizacionExtras=estadoFinalizacionExtras.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
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
