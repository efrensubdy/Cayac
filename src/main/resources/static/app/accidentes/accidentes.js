'use strict';

angular.module('myApp.accidentes', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/accidentes', {
    templateUrl: 'accidentes/accidentes.html',
    controller: 'accidentesCtrl'
  });
}])

.controller('accidentesCtrl', ['$location','$timeout', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','$mdDialog','$route','$window','acciDente','accPorContra','actualizarAccidentes',function($location,$timeout, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,$mdDialog,$route,$window,acciDente,accPorContra,actualizarAccidentes) {
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

$scope.bandera1=false;
$scope.bandera2=false;
$scope.bandera01=false;
$scope.opciones=[
 { id: 1, name: 'REGISTRAR ACCIDENTES'},
 { id: 2, name: 'CONSULTAR ACCIDENTES REGISTRADOS'},
 { id: 3, name: 'ACTUALIZAR ACCIDENTE REGISTRADOS'},

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
        $scope.bandera3=false;

        break;
        case 2:
        $scope.bandera1=false;
        $scope.bandera2=true;
        $scope.bandera3=false;
        $scope.tablaAcc=accPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante},function(list){
                 if (lista.length ==0){
                       $scope.bandera02 = true;
                       document.getElementById('id02').style.display='block'

                                                           }
        },function(err){
            $scope.bandera01 = true;
            document.getElementById('id01').style.display='block';

        }

        );

        break;
        case 3:
        $scope.bandera1=false;
        $scope.bandera2=false;
        $scope.bandera3=true;
         $scope.tablaAccidentes=accPorContra.query({idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante},function(){

         },function(err){
                $scope.bandera01 = true;
                document.getElementById('id01').style.display='block';

         });

   }
}
$scope.closeModel= function(){
        document.getElementById('id01').style.display='none';
  }

$scope.add=function(ev,textArea,primerApellido,segundoApellido,primerNombre,segundoNombre,identificacion,numero,nacimiento,sexo,departamento,muni,zonas,cargo,ingreso,accidente,hora,diaSe,jornada,sino,tipoA,lugari,depa,mun,zon,si2,tipoB,lesion,mecanismo,parte,agente){

if ("undefined" !== typeof textArea && "undefined" !== typeof primerApellido && "undefined" !== typeof segundoApellido && "undefined" !== typeof primerNombre && "undefined" !== typeof segundoNombre &&"undefined" !== typeof identificacion &&"undefined" !== typeof numero &&"undefined" !== typeof nacimiento && "undefined" !== typeof sexo &&  "undefined" !== typeof departamento && "undefined" !== typeof muni &&"undefined" !== typeof zonas &&"undefined" !== typeof cargo && "undefined" !== typeof ingreso &&  "undefined" !== typeof accidente && "undefined" !== typeof hora && "undefined" !== typeof diaSe && "undefined" !== typeof jornada && "undefined" !== typeof sino && "undefined" !== typeof tipoA && "undefined" !== typeof lugari && "undefined" !== typeof depa && "undefined" !== typeof mun && "undefined" !== typeof zon && "undefined" !== typeof si2 && "undefined" !== typeof tipoB && "undefined" !== typeof lesion && "undefined" !== typeof mecanismo && "undefined" !== typeof parte && "undefined" !== typeof agente ){
    var acciden={descripcion:textArea,primerApellido:primerApellido,segundoApellido:segundoApellido,primerNombre:primerApellido,segundoNombre:segundoNombre,identificacion:identificacion,numero:numero,nacimiento:nacimiento,sexo:sexo,departamento:departamento,muni:muni,zonas:zonas,cargo:cargo,ingreso:ingreso,accidente:accidente,hora:hora,diaSe:diaSe,jornada:jornada,sino:sino,tipoA:tipoA,lugari:lugari,depa:depa,mun:mun,zon:zon,si2:si2,tipoB:tipoB,lesion:lesion,mecanismo:mecanismo,parte:parte,agente:agente,idContratista:$localStorage.userLogeado.idContratista,idContratante:$localStorage.userLogeado.idContratante};
    acciDente.save(acciden,function(){


    },function(err){
         $scope.bandera01 = true;
         document.getElementById('id01').style.display='block';


     }
    );
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
$scope.showAlert2=function(ev,client){
            $rootScope.client=client;
            $rootScope.lugar=$scope.lugar;
            $rootScope.dias=$scope.dias;
            $rootScope.tipoDeAccidente=$scope.tipoDeAccidente;
            $rootScope.horas=$scope.horas;
            $rootScope.sitio=$scope.sitio;
            $rootScope.lesiones=$scope.lesiones;
            $rootScope.mecanismos=$scope.mecanismos;
            $rootScope.partes=$scope.partes;
            $rootScope.agentes=$scope.agentes;
            $rootScope.jornadas=$scope.jornadas;
            $rootScope.sinos=$scope.sinos;
            $rootScope.sinos2=$scope.sinos2;
            $rootScope.sexo=$scope.sexo;
            $rootScope.zona=$scope.zona;
            $rootScope.tipoDeIdentificacion=$scope.tipoDeIdentificacion;
            $mdDialog.show({
                              //Controlador del mensajes con operaciones definido en la parte de abajo
              controller: DialogController,
               //permite la comunicacion con el html que despliega el boton requisitos
                    templateUrl: 'test/actualizarAcci.html',
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
function DialogController($scope, $mdDialog, $rootScope,$window){
            $scope.client= $rootScope.client;
            $scope.lugar=$rootScope.lugar;
            $scope.dias= $rootScope.dias;
            $scope.tipoDeAccidente=$rootScope.tipoDeAccidente;
            $scope.horas= $rootScope.horas;
            $scope.sitio=$rootScope.sitio;
            $scope.lesiones=$rootScope.lesiones;
            $scope.mecanismos=$rootScope.mecanismos;
            $scope.partes=$rootScope.partes;
            $scope.agentes=$rootScope.agentes;
            $scope.jornadas=$rootScope.jornadas;
            $scope.sinos=$rootScope.sinos;
            $scope.sinos2=$rootScope.sinos2;
            $scope.sexo=$rootScope.sexo;
            $scope.zona=$rootScope.zona;
            $scope.tipoDeIdentificacion=$rootScope.tipoDeIdentificacion;


            $scope.hide = function() {
                         $mdDialog.hide();
                       };
                       //funcion para cerral el mensaje
             $scope.cancel = function() {
                         $mdDialog.cancel();
                       };
             $scope.closeModel= function(){
                     document.getElementById('id01').style.display='none';
               }


  $scope.add = function(ev,textArea,primerApellido,segundoApellido,primerNombre,segundoNombre,identificacion,numero,nacimiento,sexo,departamento,muni,zonas,cargo,ingreso,acci,hora,diaSe,jornada,sino,tipoA,lugari,depa,mun,zon,si2,tipoB,lesion,mecanismo,parte,agente,client){

                if ("undefined" == typeof textArea && "undefined" == typeof primerApellido && "undefined" == typeof segundoApellido && "undefined" == typeof primerNombre && "undefined" == typeof segundoNombre &&"undefined" == typeof identificacion &&"undefined" == typeof numero &&"undefined" == typeof nacimiento && "undefined" == typeof sexo &&  "undefined" == typeof departamento && "undefined" == typeof muni &&"undefined" == typeof zonas &&"undefined" == typeof cargo && "undefined" == typeof ingreso &&  "undefined" == typeof accidente && "undefined" == typeof hora && "undefined" == typeof diaSe && "undefined" == typeof jornada && "undefined" == typeof sino && "undefined" == typeof tipoA && "undefined" == typeof lugari && "undefined" == typeof depa && "undefined" == typeof mun && "undefined" == typeof zon && "undefined" == typeof si2 && "undefined" == typeof tipoB && "undefined" == typeof lesion && "undefined" == typeof mecanismo && "undefined" == typeof parte && "undefined" == typeof agente ){
                     $mdDialog.show(
                              $mdDialog.alert()
                                .parent(angular.element(document.querySelector('#popupContainer')))
                                .clickOutsideToClose(true)
                                .title('Debe registrar al menos un dato')
                                .textContent('Recuerde llenar todos los campos')
                                .ariaLabel('Alert Dialog Demo')
                                .ok('intente de nuevo!')
                                .targetEvent(ev)
                      );


                }
                else{
                    var acciden =new Accidente();
                    acciden.id=client.id;
                    acciden.idContratista=$localStorage.userLogeado.idContratista;
                    acciden.idContratante=$localStorage.userLogeado.idContratante;
                    if (textArea == client.descripcion || "undefined" == typeof textArea ){

                          acciden.descripcion =client.descripcion;
                     }
                     else{

                         acciden.descripcion=textArea
                     }
                     if (primerApellido == client.primerApellido || "undefined" == typeof primerApellido ){

                           acciden.primerApellido =client.primerApellido;
                      }

                      else{

                          acciden.primerApellido=primerApellido
                      }

                       if (segundoApellido == client.segundoApellido || "undefined" == typeof segundoApellido ){

                             acciden.segundoApellido =client.segundoApellido;
                        }

                        else{

                            acciden.segundoApellido=segundoApellido
                        }

                   if (primerNombre == client.primerNombre || "undefined" == typeof primerNombre ){

                        acciden.primerNombre =client.primerNombre;
                   }

                   else{

                       acciden.primerNombre=primerNombre
                   }
                   if (segundoNombre == client.segundoNombre || "undefined" == typeof segundoNombre ){

                           acciden.segundoNombre =client.segundoNombre;
                      }

                      else{

                          acciden.segundoNombre=segundoNombre
                      }

                   if (identificacion == client.identificacion || "undefined" == typeof identificacion ){

                          acciden.identificacion =client.identificacion;
                     }

                     else{

                         acciden.identificacion=identificacion
                     }
                     if (numero == client.numero || "undefined" == typeof numero ){

                           acciden.numero =client.numero;
                      }

                      else{

                          acciden.numero=numero
                      }
                      if (nacimiento == client.nacimiento || "undefined" == typeof nacimiento ){

                             acciden.nacimiento =client.nacimiento;
                        }

                        else{

                            acciden.nacimiento=nacimiento
                        }
                        if (sexo == client.sexo || "undefined" == typeof sexo ){

                             acciden.sexo =client.sexo;
                        }

                        else{

                            acciden.sexo=sexo
                        }
                        if (sexo == client.departamento || "undefined" == typeof departamento ){

                             acciden.departamento =client.departamento;
                        }

                        else{

                            acciden.departamento=departamento
                        }
                        if (muni == client.muni || "undefined" == typeof muni ){

                             acciden.muni =client.muni;
                        }

                        else{

                            acciden.muni=muni
                        }
                        if (zonas == client.zonas || "undefined" == typeof zonas ){

                             acciden.zonas =client.zonas;
                        }

                        else{

                            acciden.zonas=zonas
                        }
                        if (cargo == client.cargo || "undefined" == typeof cargo ){

                             acciden.cargo =client.cargo;
                        }

                        else{

                            acciden.cargo=cargo
                        }
                         if (ingreso == client.ingreso || "undefined" == typeof ingreso ){

                                 acciden.ingreso =client.ingreso;
                            }

                            else{

                                acciden.ingreso=ingreso
                            }


                         if (acci == client.accidente || "undefined" == typeof acci ){

                                 acciden.accidente =client.accidente;
                            }

                            else{

                                acciden.accidente=acci
                            }

                         if (hora == client.hora || "undefined" == typeof hora ){

                              acciden.hora =client.hora;
                         }

                         else{

                             acciden.hora=hora
                         }
                         if (diaSe == client.diaSe || "undefined" == typeof diaSe ){

                               acciden.diaSe =client.diaSe;
                          }

                          else{

                              acciden.diaSe=diaSe
                          }
                         if (jornada == client.jornada || "undefined" == typeof jornada ){

                                acciden.jornada =client.jornada;
                           }

                           else{

                               acciden.jornada=jornada
                           }
                           if (sino == client.sino || "undefined" == typeof sino ){

                                   acciden.sino =client.sino;
                              }

                              else{

                                  acciden.sino=sino
                              }
                            if (tipoA == client.tipoA || "undefined" == typeof tipoA ){

                                  acciden.tipoA =client.tipoA;
                             }

                             else{

                                 acciden.tipoA=tipoA
                             }
                             if (lugari == client.lugari || "undefined" == typeof lugari ){

                                   acciden.lugari =client.lugari;
                              }

                              else{

                                  acciden.lugari=lugari
                              }
                              if (depa == client.depa || "undefined" == typeof depa ){

                                     acciden.depa =client.depa;
                                }

                                else{

                                    acciden.depa=depa
                                }
                                if (mun == client.mun || "undefined" == typeof mun ){

                                     acciden.mun =client.mun;
                                }

                                else{

                                    acciden.mun=mun
                                }
                                if (zon == client.zon || "undefined" == typeof zon ){

                                         acciden.zon =client.zon;
                                    }

                                    else{

                                        acciden.zon=zon
                                    }
                               if (si2 == client.si2 || "undefined" == typeof si2 ){

                                    acciden.si2 =client.si2;
                               }

                               else{

                                   acciden.si2=si2
                               }
                               if (tipoB == client.tipoB || "undefined" == typeof tipoB ){

                                       acciden.tipoB =client.tipoB;
                                  }

                                  else{

                                      acciden.tipoB=tipoB
                                  }
                               if (lesion == client.lesion || "undefined" == typeof lesion ){

                                      acciden.lesion =client.lesion;
                                 }

                                 else{

                                     acciden.lesion=lesion
                                 }
                                 if (mecanismo == client.mecanismo || "undefined" == typeof mecanismo ){

                                       acciden.mecanismo =client.mecanismo;
                                  }

                                  else{

                                      acciden.mecanismo=mecanismo
                                  }
                                  if (parte == client.parte || "undefined" == typeof parte ){

                                         acciden.parte =client.parte;
                                    }

                                    else{

                                        acciden.parte=parte
                                    }
                                  if (agente == client.agente || "undefined" == typeof agente ){

                                       acciden.agente =client.agente;
                                  }

                                  else{

                                      acciden.agente=agente
                                  }

                     console.log(acciden);
                     actualizarAccidentes.save(acciden,function(){


                        },function(err){
                            $window.alert("No se pudo actualizar, Comuniquese con SEQ ");

                            }
                        );
                     $mdDialog.show(
                           $mdDialog.alert()
                              .parent(angular.element(document.querySelector('#popupContainer')))
                              .clickOutsideToClose(true)
                              .title('Exito !!')
                              .textContent('Puede revisar nuevamente o consultar sus indicadores.')
                              .ariaLabel('Alert Dialog Demo')
                              .ok('ok!')
                              .targetEvent(ev)
                                              );
                      $route.reload();




                }



           }

           }

           function Accidente(){



           }


}]);