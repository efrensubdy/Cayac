'use strict';

angular.module('myApp.view9', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view9', {
    templateUrl: 'view9/view9.html',
    controller: 'View9Ctrl'
  });
}])

.controller('View9Ctrl', ['$location','$localStorage','$sessionStorage','$http','$parse','$scope','$rootScope','$mdDialog','rObligatorio','rExtra','imagenes','fileUpload','obtainExtension','rEstadoR','rEstadoE',function($location,$localStorage,$sessionStorage,$http,$parse,$scope,$rootScope,$mdDialog,rObligatorio,rExtra,imagenes,fileUpload,obtainExtension,rEstadoR,rEstadoE) {
        if ("undefined" === typeof $localStorage.userLogeado || "undefined" !== typeof $localStorage.contratanteLogeado){
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
           var q=function(idContratante, idCategoria){
                       //var url= "http://localhost:8080/app/limites/"+idContratante+"/"+idCategoria ;
                       var url= "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/limites/"+idContratante+"/"+idCategoria ;
                       $http.get(url).then(function(response) {
                                     if(response.data.flag){
                                    $scope.objeto=response.data;
                                     if ($scope.objeto.estado==true){
                                                $scope.mostrar=true;
                                                $scope.banderaFecha=true;

                                            }
                                            else{
                                                $scope.mostrar=false;
                                                $scope.banderaFecha=false;

                                            }
                                     }
                                     return response.data;
                                  })
           }
        $scope.agregar = function(ev,item) {
            if ("undefined" !== typeof $scope.myFile){
            var file = $scope.myFile;

            //var uploadUrl = 'http://localhost:8080/app/imagenes/'+ $localStorage.userLogeado.idContratista + "/"+ item.id;
            var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/imagenes/'+ $localStorage.userLogeado.idContratista + "/"+ item.id;
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




            }


        };
        $scope.agregar2 = function(ev,item) {
                    var file = $scope.myFile;
                    if ("undefined" !== typeof $scope.myFile){
                    console.log(file);
                    console.log(item.id)
                    //var uploadUrl = 'http://localhost:8080/app/documento/'+ $localStorage.userLogeado.idContratista+ "/"+ item.id;
                    var uploadUrl = 'http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/documento/'+ $localStorage.userLogeado.idContratista+ "/"+ item.id;
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



                    }

                };





        $scope.list1=rEstadoR.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idContratista:$localStorage.userLogeado.idContratista});
        $scope.list2=rEstadoE.query({idContratante:$localStorage.userLogeado.idContratante,idCategoria:$localStorage.userLogeado.categoria,idContratista:$localStorage.userLogeado.idContratista});
        q($localStorage.userLogeado.idContratante,$localStorage.userLogeado.categoria);
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
