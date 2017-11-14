'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngStorage',
  'ngMaterial',
  'googlechart',
  'myApp.view1',
  'myApp.view2',
  'myApp.view3',
  'myApp.view4',
  'myApp.view6',
  'myApp.view7',
  'myApp.view9',
  'myApp.view10',
  'myApp.view12',
  'myApp.view13',
  'myApp.view14',
  'myApp.view15',
  'myApp.registrarRequisitosEjecucion',
  'myApp.manualRegister',
  'myApp.ejecucionCNCE',
  'myApp.subirDocumentosEstaticos',
  'myApp.registroServicio',
  'myApp.inicio',
  'myApp.planDeTrabajo',
  'myApp.gestionDeActividades',
  'myApp.notificaciones',
  'myApp.mensajeria',
  'myApp.facturacion',
  'myApp.seguridadSocial',
  'myApp.indicadores',
  'myApp.gestionDeIndicadores',
  'myApp.reporteDeIndicadores',
  'myApp.gestionDeAccidentes',
  'myApp.estandaresMinimos',
  'myApp.aCFinSelec',
  'myApp.accidentes',
  'myApp.gestionDeEstandares',
  'myApp.gestionDeSeguridadSocial',
  'myApp.registroDeAuditoria',
  'myApp.auditoria',
  'myApp.gestionAuditoria',
  'myApp.login',
  'myApp.login2',
  'myApp.login3',
  'myApp.actualizacionDeContrato',
  'myApp.mensajeriaContratante',
  'myApp.diagnostico',
  'services.listFactory',
  'myApp.version'
]).
config(['$routeProvider','$httpProvider','$qProvider', function($routeProvider, $httpProvider,$qProvider) {
$routeProvider.otherwise({redirectTo: '/inicio'});
$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
$qProvider.errorOnUnhandledRejections(false);
}])

.controller('logout',['$rootScope','$scope', '$http','$location','$localStorage','$sessionStorage',function($rootScope,$scope,$http,$location,$localStorage,$sessionStorage)  {
   $scope.$storage = $localStorage;

   if ("undefined" === typeof $localStorage.userLogeado && "undefined" !== typeof $localStorage.contratanteLogeado && $localStorage.contratanteLogeado.rol=="Contratante"  ) {
       console.log("AT THIS MOMENT I'M CONTRACTOR")
       $rootScope.bandera=$localStorage.contratanteLogeado.estado;

       $rootScope.bandera2=false;
       $rootScope.bandera3=false;

   }
   else if("undefined" === typeof $localStorage.contratanteLogeado && "undefined" !== typeof $localStorage.userLogeado ){
        console.log("AT THIS MOMENT I'M BUILDER")
        $rootScope.bandera2 = $localStorage.userLogeado.estado;

        $rootScope.banderaEjecucion=$localStorage.userLogeado.finalista;
        $rootScope.bandera=false;
        $rootScope.bandera3=false;
   }
   else if("undefined" !== typeof $localStorage.contratanteLogeado && "undefined" === typeof $localStorage.userLogeado && $localStorage.contratanteLogeado.rol=="administrador"){

           console.log("AT THIS MOMENT I'M ADMIN")
           $rootScope.bandera2=false;
           $rootScope.bandera3 = $localStorage.contratanteLogeado.estado;
           $rootScope.bandera=false;
    }
   else{
       console.log("AT THIS MOMENT NOTBODY IS IN CAYAC")
       $rootScope.bandera=false;
       $rootScope.bandera2=false;

   }
   $scope.logout = function () {
                          $http.post('/logout',{}).then(successCallback, errorCallback);
                          function successCallback(){
                            $rootScope.authenticated = false;
                            $location.path("/login");
                          }
                          function errorCallback(data){
                            $rootScope.authenticated = false;
                          }

                };

    //NUEVA FUNCION DE logOut para Contratantes
    $scope.close=function(){

            $rootScope.bandera=false;
            $location.path("inicio");
            delete $localStorage.contratanteLogeado;
            delete $scope.$storage;
            console.log($localStorage.contratanteLogeado);


    };
    //NUEVA FUNCION DE logOut para Contratatistas
    $scope.close2=function(){

                $rootScope.bandera2=false;
                $rootScope.banderaEjecucion=false;
                $location.path("inicio");
                $localStorage.$reset();
                 delete $localStorage.userLogeado;
                 delete $scope.$storage;
                 console.log($localStorage.userLogeado);


        };
    //NUEVA FUNCION DE LogoUT PARA ADMIN
    $scope.close3=function(){

                    $rootScope.bandera3=false;
                    $location.path("inicio");
                    $localStorage.$reset();
                     delete $localStorage.userLogeado;
                     delete $scope.$storage;
                     console.log($localStorage.userLogeado);


            };


}]);