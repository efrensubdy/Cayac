'use strict';

angular.module('myApp.subirDocumentosEstaticos', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/subirDocumentosEstaticos', {
    templateUrl: 'subirDocumentosEstaticos/subirDocumentosEstaticos.html',
    controller: 'subirDocumentosEstaticosCtrl'
  });
}])

.controller('subirDocumentosEstaticosCtrl', ['$location','$route','$localStorage','$sessionStorage','$http','$parse','$scope','$rootScope','$mdDialog','fileUpload','estadoPreviosSugeridos','estadoPreviosExtras',function($location,$route,$localStorage,$sessionStorage,$http,$parse,$scope,$rootScope,$mdDialog,fileUpload,estadoPreviosSugeridos,estadoPreviosExtras) {
       if ("undefined" === typeof $localStorage.userLogeado && "undefined" === typeof $localStorage.contratanteLogeado){
                $mdDialog.show(
                                 $mdDialog.alert()
                                   .parent(angular.element(document.querySelector('#popupContainer')))
                                   .clickOutsideToClose(true)
                                   .title('Error')
                                   .textContent('Usted no ha iniciado sesión.')
                                   .ariaLabel('Alert Dialog Demo')
                                   .ok('ok!')
                                   .targetEvent()
                           );
               $location.path("inicio");


       }

       $scope.file = "";

       $scope.agregarEstaticosSugeridosPrevios = function(ev,item) {
            if ("undefined" !== typeof $scope.myDocSugeridoPrevio){
            var file = $scope.myDocSugeridoPrevio;
            //var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoSugerido" ;
            var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoSugerido" ;

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
                        $route.reload();

            }
            else{
                 $mdDialog.show(
                           $mdDialog.alert()
                           .parent(angular.element(document.querySelector('#popupContainer')))
                           .clickOutsideToClose(true)
                           .title('No subido !!!')
                           .textContent('Su archivo no  se he subido correctamente.')
                           .ariaLabel('Alert Dialog Demo')
                           .ok('ok!')
                            .targetEvent(ev)

                 );
                  $route.reload();

            }

        };
        $scope.agregarEstaticosExtrasPrevios = function(ev,item) {

                    if ("undefined" !== typeof $scope.myDocExtraPrevio){
                    var file = $scope.myDocExtraPrevio;

                    //var uploadUrl = 'http://localhost:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoExtra" ;
                    var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/docEstaticos/'+ $localStorage.userLogeado.idFinalista + "/"+ item.id + "/"+ $localStorage.userLogeado.idContratista + "/previoExtra" ;
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
                     $route.reload();
                    }
                    else{
                          $mdDialog.show(
                                 $mdDialog.alert()
                                 .parent(angular.element(document.querySelector('#popupContainer')))
                                 .clickOutsideToClose(true)
                                 .title('No subido !!!')
                                 .textContent('Su archivo no  se he subido correctamente.')
                                 .ariaLabel('Alert Dialog Demo')
                                 .ok('ok!')
                                  .targetEvent(ev)

                          );
                           $route.reload();

                    }

                };


        $scope.defPreviosSugeridos=estadoPreviosSugeridos.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.defPreviosExtras=estadoPreviosExtras.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idFinalista:$localStorage.userLogeado.idFinalista});
        $scope.propertyName = 'descripcion';
        $scope.reverse = true;
        $scope.sortBy = function(propertyName) {
          $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
          $scope.propertyName = propertyName;
        };
        $scope.resfresh=function(){
            $route.reload();


        }


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
