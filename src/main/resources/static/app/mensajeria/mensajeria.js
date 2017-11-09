'use strict';

angular.module('myApp.mensajeria', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mensajeria', {
    templateUrl: 'mensajeria/mensajeria.html',
    controller: 'mensajeriaCtrl'
  });
}])

.controller('mensajeriaCtrl', ['$location','$route','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','mensajeContr',function($location,$route,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,mensajeContr) {
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
    $scope.trash=false;


    $scope.listadoMensajes=mensajeContr.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante});
     $scope.deleteMessagesList=[];


    $scope.deleteMessage=function(selected,item){
        console.log(selected)
        if(selected){
        $scope.deleteMessagesList.push(item);
            if( $scope.deleteMessagesList.length >0){
                        $scope.trash=true;
                    }
                    else{
                        $scope.trash=false
                    }
        }
           else if(!selected && containsObject(item,$scope.deleteMessagesList)){
                            var index=$scope.deleteMessagesList.indexOf(item)
                            if (index > -1) {
                                  $scope.deleteMessagesList.splice(index, 1);
                            }
                              if( $scope.deleteMessagesList.length >0){
                                                     $scope.trash=true;
                                                 }
                               else{
                                                     $scope.trash=false

                                    }

        }
  }
  $scope.messageDelete=function(ev){
    $mdDialog.show(
          $mdDialog.alert()
            .parent(angular.element(document.querySelector('#popupContainer')))
            .clickOutsideToClose(true)
            .title('Sus Requisitos han sido eliminados')
            .textContent('Podrá seguir eliminando requisitos si lo desea.')
            .ariaLabel('Alert Dialog Demo')
            .ok('Aplique mas requisitos!')
            .targetEvent(ev)
    );



  }


    function containsObject(obj, list) {
                     var i;
                     for (i = 0; i < list.length; i++) {
                        if (list[i] === obj) {
                              return true;
                        }
                     }

                     return false;
                  }





}]);