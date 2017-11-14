'use strict';

angular.module('myApp.mensajeriaContratante', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mensajeriaContratante', {
    templateUrl: 'mensajeriaContratante/mensajeriaContratante.html',
    controller: 'mensajeriaContratanteCtrl'
  });
}])

.controller('mensajeriaContratanteCtrl', ['$location','$route','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','mensajeContr','eliminarMessagesContratantes','mensajeCtante',function($location,$route,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,mensajeContr,eliminarMessagesContratantes,mensajeCtante) {
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
    $scope.trash=false;


    $scope.listadoMensajes=mensajeCtante.query({idContratante:$localStorage.contratanteLogeado.idContratante});
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
 var eliminarMessages=function(lista){
                var total=lista.length;
                 for (var i=0;i<total;i++){
                            console.log(lista[i])
                         eliminarMessagesContratantes.remove({"idMessage":lista[i].id});

                 }

             }
  $scope.messageDelete=function(ev){
          eliminarMessages($scope.deleteMessagesList);

    $mdDialog.show(
          $mdDialog.alert()
            .parent(angular.element(document.querySelector('#popupContainer')))
            .clickOutsideToClose(true)
            .title('El mensaje ha sido Eliminado')
            .textContent('Recuerde solo eliminar los mensajes luego de cumplir con el.')
            .ariaLabel('Alert Dialog Demo')
            .ok('ok!')
            .targetEvent(ev)
    );
    $route.reload();



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

$scope.showAlert=function(ev){

     $mdDialog.show({
                 //Controlador del mensajes con operaciones definido en la parte de abajo
                 controller: DialogController,
                  //permite la comunicacion con el html que despliega el boton requisitos
                  templateUrl: 'test/mensajeDeContratante.html',
                  parent: angular.element(document.body),
                  targetEvent: ev,
                  clickOutsideToClose:true,
                  fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
     })
}
function DialogController($scope, $mdDialog, $rootScope, $http) {
    $scope.mensaje=true;
    $scope.show=function(){
        $scope.mensaje=true;
    }
    $scope.hide = function() {
       $mdDialog.hide();
     };
                         //funcion para cerral el mensaje
   $scope.cancel = function() {
       $mdDialog.cancel();
     };
    $scope.envio=function(item){
        var mensaje={mensaje:item,idContratante:$localStorage.userLogeado.idContratante,idContratista:$localStorage.userLogeado.idContratista,nombreEmpresa:$localStorage.userLogeado.nombreEmpresa}
        mensajeContratante.save(mensaje);
        $scope.textArea= '';
        $scope.mensaje=false;

    }


}


}]);