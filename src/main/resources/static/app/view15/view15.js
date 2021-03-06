'use strict';

angular.module('myApp.view15', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view15', {
    templateUrl: 'view15/view15.html',
    controller: 'View15Ctrl'
  });
}])

.controller('View15Ctrl', ['$location','$localStorage','$sessionStorage','$scope','$rootScope','contratos','fechaContrato','$mdDialog','$http',function($location,$localStorage,$sessionStorage,$scope,$rootScope,contratos,fechaContrato,$mdDialog,$http) {
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

$scope.fecha={}
$scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
},function(err){
    $scope.bandera01 = true;
     document.getElementById('id01').style.display='block';

})
$scope.nombreClick=false;
$scope.permisoTable=false;
$scope.permisoFecha=false;
var d;
$scope.function1=function(){
    if($scope.tipoContrato=="nombre"){
        $scope.nombreClick=true;
        $scope.fechaClick=false
    }
    else if($scope.tipoContrato=="fecha") {
        $scope.nombreClick=false;
        $scope.permisoTable=false;
        $scope.fechaClick=true;
        $scope.contrato=undefined;
    }


}
$scope.loadContratos=function(){
     $scope.listado=contratos.query({idContratante:$localStorage.contratanteLogeado.idContratante},function(){
     },function(err){
         $scope.bandera01 = true;
         document.getElementById('id01').style.display='block';
     })
}

$scope.detalle=function(ev,item){
    detalle(ev,item);
}
$scope.closeModel= function(){
     document.getElementById('id01').style.display='none';
 }
$scope.buscar=function(ev,a,b){
if("undefined" !== typeof a && "undefined" !== typeof b ){
$scope.listado= fechaContrato.query({fechaInicio:a,fechaFin:b,idContratante:$localStorage.contratanteLogeado.idContratante},function(){
},function(err){
    $scope.bandera01 = true;
    document.getElementById('id01').style.display='block';
});
$scope.permisoFecha=true;
}
else{
     $mdDialog.show(
                                $mdDialog.alert()
                                  .parent(angular.element(document.querySelector('#popupContainer')))
                                  .clickOutsideToClose(true)
                                  .title('Hubo un error')
                                  .textContent('alguno de los datos se ecuentra sin escoger.')
                                  .ariaLabel('Alert Dialog Demo')
                                  .ok('intente de nuevo!')
                                  .targetEvent(ev)
                          );


}

}


 var detalle=function(ev,item){

    if("undefined" !== typeof item){
    //var url = "http://localhost:8080/app/contratos/id/" + item.idContrato;
   var url = "http://ec2-35-163-21-208.us-west-2.compute.amazonaws.com:8080/app/contratos/id/" + item.idContrato;
          $http.get(url).then(function(response) {
                   d=response.data;

                   return response.data;
                }).then(p);

    }
    else{
        $mdDialog.show(
                $mdDialog.alert()
                  .parent(angular.element(document.querySelector('#popupContainer')))
                  .clickOutsideToClose(true)
                  .title('Hubo un error')
                  .textContent('alguno de los datos se ecuentra sin escoger.')
                  .ariaLabel('Alert Dialog Demo')
                  .ok('intente de nuevo!')
                  .targetEvent(ev)
          );


    }
}
var p=function(){

        $scope.e=d;
        $scope.permisoTable=true;

     }

}]);