'use strict';

angular.module('myApp.accidentes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/accidentes', {
    templateUrl: 'accidentes/accidentes.html',
    controller: 'accidentesCtrl'
  });
}])

.controller('accidentesCtrl', ['$location','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','acciDente','accPorContra',function($location,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,acciDente,accPorContra) {
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

$scope.bandera1=false;
$scope.bandera2=false;

$scope.opciones=[
 { id: 1, name: 'REGISTRAR ACCIDENTES'},
 { id: 2, name: 'CONSULTAR ACCIDENTES REGISTRADOS'},

];
$scope.lugar=[
 { id: 1, name: 'FUERA DE LA EMPRESA'},
 { id: 2, name: 'DENTRO DE LA EMPRESA'},

];

$scope.dias=[
 { id: 1, name: 'LU'},
 { id: 2, name: 'MA'},
  { id: 3, name: 'MI'},
  { id: 4, name: 'JU'},
   { id: 5, name: 'VI'},
   { id: 6, name: 'SA'},
   { id: 7, name: 'DO'},

];
$scope.tipoDeAccidente=[

  {id:1,name:"VIOLENCIA"},
  {id:2,name:"TRÁNSITO"},
  {id:3,name:"DEPORTIVO"},
  {id:4,name:"RECREATIVO O CULTURAL"},
  {id:5,name:"PROPIO DEL TRABAJO"},

];
$scope.horas=[
{id:0,name:'00:00'},
{id:1,name:'01:00'},
{id:2,name:'02:00'},
{id:3,name:'03:00'},
{id:4,name:'04:00'},
{id:5,name:'05:00'},
{id:6,name:'06:00'},
{id:7,name:'07:00'},
{id:8,name:'08:00'},
{id:9,name:'09:00'},
{id:10,name:'10:00'},
{id:11,name:'11:00'},
{id:12,name:'12:00'},
{id:13,name:'13:00'},
{id:14,name:'14:00'},
{id:15,name:'15:00'},
{id:16,name:'16:00'},
{id:17,name:'17:00'},
{id:18,name:'18:00'},
{id:19,name:'19:00'},
{id:20,name:'20:00'},
{id:21,name:'21:00'},
{id:22,name:'22:00'},
{id:23,name:'23:00'},
{id:24,name:'24:00'},

];
$scope.sitio =[
{id:1,name:'ALMACENES O DEPÓSITOS'},
{id:2,name:'ÁREAS DE PRODUCCIÓN'},
{id:3,name:'ÁREAS RECREATIVAS O PRODUCTIVAS'},
{id:4,name:'CORREDORES O PASILLOS'},
{id:5,name:'ESCALERAS'},
{id:6,name:'PARQUEADEROS O ÁREAS DE CIRCULACIÓN VEHICULAR'},
{id:7,name:'OFICINAS'},
{id:8,name:'OTRAS ÁREAS COMUNES'},
];
$scope.lesiones=[
{id:1,name:'FRACTURA'},
{id:2,name:'LUXACIÓN'},
{id:3,name:'TORCEDURA, ESGUINCE, DESGARRO MUSCULAR, HERNIA O LACERACIÓN DE MÚSCULO O TENDÓN SIN HERIDA'},
{id:4,name:'AMPUTACIÓN O ENUCLEACIÓN (Exclusión o pérdida del ojo)'},
{id:5,name:' HERIDA'},
{id:6,name:'TRAUMA SUPERFICIAL (Incluye rasguño, punción o pinchazo y lesión en ojo por cuerpo extraño)'},
{id:7,name:'GOLPE, CONTUSIÓN O APLASTAMIENTO'},
{id:8,name:' QUEMADURA'},
{id:9,name:'FRACTURA'},
{id:10,name:'ENVENENAMIENTO O INTOXICACIÓN AGUDA O ALERGIA'},
{id:11,name:'EFECTO DEL TIEMPO, DEL CLIMA U OTRO RELACIONADO CON EL AMBIENTE'},
{id:12,name:'ASFIXIA'},
{id:13,name:'EFECTO DE LA ELECTRICIDAD'},
{id:14,name:' EFECTO NOCIVO DE LA RADIACIÓN'},
{id:15,name:' LESIONES MÚLTIPLES'},

];
$scope.mecanismos =[
{id:1,name:'CAIDA DE PERSONAS'},
{id:2,name:'CAIDA DE OBJETOS'},
{id:3,name:'PISADAS, CHOQUES O GOLPES'},
{id:4,name:'ATRAPAMIENTOS'},
{id:5,name:'SOBREESFUERZO, ESFUERZO EXCESIVO O FALSO MOVIMIENTO'},
{id:6,name:' EXPOSICIÓN O CONTACTO CON TEMPERATURA EXTREMA'},
{id:7,name:' EXPOSICIÓN O CONTACTO CON LA ELECTRICIDAD'},
{id:8,name:'EXPOSICIÓN O CONTACTO CON SUSTANCIAS NOCIVAS, RADIACIONES O SALPICADURAS'},

];

$scope.partes =[
  {id:1,name:'CABEZA'},
  {id:2,name:'OJO'},
  {id:3,name:'CUELLO'},
  {id:4,name:'TRONCO (Incluye espalda, columna vertebral, médula espinal, pélvis)'},
  {id:5,name:'TÓRAX'},
  {id:6,name:'ABDOMEN'},
  {id:7,name:' MIEMBROS SUPERIORES'},
  {id:8,name:'MANOS'},
  {id:9,name:'MIEMBROS INFERIORES'},
  {id:10,name:'PIES'},
  {id:11,name:'UBICACIONES MÚLTIPLES'},
  {id:11,name:' LESIONES GENERALES U OTRAS'},

];
$scope.agentes =[
{id:1,name:'MÁQUINAS Y/O EQUIPOS'},
{id:2,name:'MEDIOS DE TRANSPORTE'},
{id:3,name:'APARATOS'},
{id:4,name:'HERRAMIENTAS, IMPLEMENTOS O UTENSILIOS'},
{id:5,name:'MATERIALES O SUSTANCIAS'},
{id:6,name:'RADIACIONES'},
{id:7,name:'AMBIENTE DE TRABAJO (Incluye superficies de tránsito y de trabajo, muebles, tejados, en el exterior, interior o subterráneos)'},
{id:8,name:'ANIMALES (Vivos o productos animales)'},
{id:9,name:'AGENTES NO CLASIFICADOS POR FALTA DE DATOS'},

];

$scope.jornadas=[
 { id: 1, name: 'NORMAL'},
 { id: 2, name: 'EXTRA'},

];
$scope.sinos=[
 { id: 1, name: 'SI'},
 { id: 2, name: 'NO'},

];$scope.sinos2=[
   { id: 1, name: 'SI'},
   { id: 2, name: 'NO'},

  ];


$scope.sexo=[
 { id: 1, name: 'M'},
 { id: 2, name: 'F'},

];
$scope.zona=[
 { id: 1, name: 'U'},
 { id: 2, name: 'R'},

];
$scope.tipoDeIdentificacion=[
 { id: 1, name: 'CC'},
 { id: 2, name: 'CE'},
 { id: 3, name: 'N.U'},
 { id: 4, name: 'TI'},
 { id: 4, name: 'PA'},

];
$scope.simple2 = function(item){
   switch(item.id){
        case 1:
        $scope.bandera1=true;
        $scope.bandera2=false;

        break;
        case 2:
        $scope.bandera1=false;
        $scope.bandera2=true;
        $scope.tablaAcc=accPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante});

        break;

   }
}

$scope.add=function(ev,textArea,primerApellido,segundoApellido,primerNombre,segundoNombre,identificacion,numero,nacimiento,sexo,departamento,muni,zonas,cargo,ingreso,accidente,hora,diaSe,jornada,sino,tipoA,lugari,depa,mun,zon,si2,tipoB,lesion,mecanismo,parte,agente){

if ("undefined" !== typeof textArea && "undefined" !== typeof primerApellido && "undefined" !== typeof segundoApellido && "undefined" !== typeof primerNombre && "undefined" !== typeof segundoNombre &&"undefined" !== typeof identificacion &&"undefined" !== typeof numero &&"undefined" !== typeof nacimiento && "undefined" !== typeof sexo &&  "undefined" !== typeof departamento && "undefined" !== typeof muni &&"undefined" !== typeof zonas &&"undefined" !== typeof cargo && "undefined" !== typeof ingreso &&  "undefined" !== typeof accidente && "undefined" !== typeof hora && "undefined" !== typeof diaSe && "undefined" !== typeof jornada && "undefined" !== typeof sino && "undefined" !== typeof tipoA && "undefined" !== typeof lugari && "undefined" !== typeof depa && "undefined" !== typeof mun && "undefined" !== typeof zon && "undefined" !== typeof si2 && "undefined" !== typeof tipoB && "undefined" !== typeof lesion && "undefined" !== typeof mecanismo && "undefined" !== typeof parte && "undefined" !== typeof agente ){
    var acciden={descripcion:textArea,primerApellido:primerApellido,segundoApellido:segundoApellido,primerNombre:primerApellido,segundoNombre:segundoNombre,identificacion:identificacion,numero:numero,nacimiento:nacimiento,sexo:sexo,departamento:departamento,muni:muni,zonas:zonas,cargo:cargo,ingreso:ingreso,accidente:accidente,hora:hora,diaSe:diaSe,jornada:jornada,sino:sino,tipoA:tipoA,lugari:lugari,depa:depa,mun:mun,zon:zon,si2:si2,tipoB:tipoB,lesion:lesion,mecanismo:mecanismo,parte:parte,agente:agente,idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante};
    acciDente.save(acciden);
    $mdDialog.show(
         $mdDialog.alert()
           .parent(angular.element(document.querySelector('#popupContainer')))
           .clickOutsideToClose(true)
           .title('Registro de Accidente Completo')
           .textContent('Podra revisar este accidente en la otra pestaña.')
           .ariaLabel('Alert Dialog Demo')
           .ok('ok!')
           .targetEvent(ev)
                       );
    $scope.textArea='';
    $scope.primerApellido='';
    $scope.segundoApellido='';
    $scope.primerNombre='';
    $scope.segundoNombre='';
    $scope.identificacion='';
    $scope.numero='';
    $scope.nacimiento='';
    $scope.sexo='';
    $scope.departamento='';
    $scope.muni='';
    $scope.zonas='';
    $scope.cargo='';
    $scope.ingreso='';
    $scope.accidente='';
    $scope.hora='';
    $scope.diaSe=''
    $scope.jornada='';
    $scope.sino='';
    $scope.tipoA='';
    $scope.lugari='';
    $scope.depa='';
    $scope.mun='';
    $scope.zon='';
    $scope.si2='';
    $scope.tipoB='';
    $scope.lesion='';
    $scope.mecanismo='';
    $scope.parte='';
    $scope.agente='';
}
else{

     $mdDialog.show(
             $mdDialog.alert()
               .parent(angular.element(document.querySelector('#popupContainer')))
               .clickOutsideToClose(true)
               .title('Hay algún dato erroneo')
               .textContent('llene todos los campos e intente de nuevo.')
               .ariaLabel('Alert Dialog Demo')
               .ok('ok!')
               .targetEvent(ev)
                           );
     $scope.textArea='';
         $scope.primerApellido='';
         $scope.segundoApellido='';
         $scope.primerNombre='';
         $scope.segundoNombre='';
         $scope.identificacion='';
         $scope.numero='';
         $scope.nacimiento='';
         $scope.sexo='';
         $scope.departamento='';
         $scope.muni='';
         $scope.zonas='';
         $scope.cargo='';
         $scope.ingreso='';
         $scope.accidente='';
         $scope.hora='';
         $scope.diaSe=''
         $scope.jornada='';
         $scope.sino='';
         $scope.tipoA='';
         $scope.lugari='';
         $scope.depa='';
         $scope.mun='';
         $scope.zon='';
         $scope.si2='';
         $scope.tipoB='';
         $scope.lesion='';
         $scope.mecanismo='';
         $scope.parte='';
         $scope.agente='';
}


}
$scope.showAlert=function(ev,client){
            $rootScope.client=client
            $mdDialog.show({
                  //Controlador del mensajes con operaciones definido en la parte de abajo
                  controller: DialogController2,
                   //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/detalleDeAccidente.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                     clickOutsideToClose:true,
                     fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                                })

          }
 function DialogController2($scope, $mdDialog, $rootScope){
            $scope.client= $rootScope.client;

            $scope.hide = function() {
                         $mdDialog.hide();
                       };
                       //funcion para cerral el mensaje
             $scope.cancel = function() {
                         $mdDialog.cancel();
                       };




           }


}]);