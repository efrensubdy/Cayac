'use strict';

angular.module('myApp.diagnostico', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/diagnostico', {
    templateUrl: 'diagnostico/diagnostico.html',
    controller: 'diagnosticoCtrl'
  });
}])

.controller('diagnosticoCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage','diagnostico',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage,diagnostico) {

if ("undefined" !== typeof $localStorage.userLogeado || "undefined" !== typeof $localStorage.contratanteLogeado){
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
        $location.path("view1");


}
$scope.answers={};
$scope.add=false;
$rootScope.resultado = 0;
 $scope.preguntas=[
    {id:1,number:"primeraPregunta",nombre:'¿LA EMPRESA CUENTA CON UN PROCEDIMIENTO DOCUMENTADO QUE ADICIONAL A LA SELECCIÓN Y CONTRATACIÓN INCLUYA EL SEGUIMIENTO DEL DESEMPEÑO DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:2,number:"segundaPregunta",nombre:'¿LA EMPRESA REALIZA EL SEGUIMIENTO DEL DESEMPEÑO DE LOS CONTRATISTA INCLUYENDO LOS ASPECTOS DE SEGURIDAD Y SALUD EN EL TRABAJO DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:3,number:"terceraPregunta",nombre:'¿LA EMPRESA TIENE UN MECANISMO QUE FACILITE EL CUMPLIMIENTO DE LAS NORMAS DE SEGURIDAD Y SALUD EN EL TRABAJO POR PARTE DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:4,number:"cuartaPregunta",nombre:'¿LA EMPRESA ESTABLECE CANALES DE COMUNICACIÓN PARA LA GESTIÓN DE SEGURIDAD Y SALUD EN EL TRABAJO CON LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:5,number:"quintaPregunta",nombre:'¿LA EMPRESA VERIFICA ANTES DEL INICIO DEL TRABAJO Y PERIÓDICAMENTE, EL CUMPLIMIENTO DE LA OBLIGACIÓN DE AFILIACIÓN AL SISTEMA GENERAL DE RIESGOS LABORALES, CONSIDERANDO LA ROTACIÓN DEL PERSONAL POR PARTE DE LOS CONTRATISTAS, DE CONFORMIDAD CON LA NORMATIVIDAD VIGENTE?'},
    {id:6,number:"sextaPregunta",nombre:'¿LA EMPRESA CONOCE, PREVIO AL INICIO DEL CONTRATO, LOS PELIGROS Y RIESGOS GENERALES DE LA ZONA DE TRABAJO DE LOS CONTRATISTAS, INCLUIDAS LAS ACTIVIDADES O TAREAS DE ALTO RIESGO, RUTINARIAS Y NO RUTINARIAS?'},
    {id:7,number:"septimaPregunta",nombre:'¿LA EMPRESA CONTRATISTA FACILITA LA INFORMACIÓN ACERCA DE LOS PRESUNTOS ACCIDENTES DE TRABAJO Y ENFERMEDADES LABORALES OCURRIDOS DURANTE EL PERIODO DE VIGENCIA DEL CONTRATO PARA QUE EL CONTRATANTE EJERZA LAS ACCIONES DE PREVENCIÓN Y CONTROL QUE ESTÉN BAJO SU RESPONSABILIDAD?'},
    {id:8,number:"octavaPregunta",nombre:'¿LA EMPRESA VERIFICA PERIÓDICAMENTE Y DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO EN LA EMPRESA, EL CUMPLIMIENTO DE LA NORMATIVIDAD EN SEGURIDAD Y SALUD EL TRABAJO POR PARTE DE LOS CONTRATISTAS Y SUS TRABAJADORES?'},
    {id:9,number:"novenaPregunta",nombre:'¿LA EMPRESA TIENE DEFINIDOS Y CONSTRUIDOS INDICADORES DE GESTIÓN QUE EVALÚEN LAS NO CONFORMIDADES DETECTADAS A LOS CONTRATISTAS EN EL SEGUIMIENTO AL DESEMPEÑO EN SEGURIDAD Y SALUD EN EL TRABAJO, DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:10,number:"decimaPregunta",nombre:'¿LA EMPRESA TIENE DEFINIDOS Y CONSTRUIDOS INDICADORES DE GESTIÓN QUE EVALÚEN MEDIANTE LAS ACCIONES CORRECTIVAS, GENERADAS EN LAS AUDITORIAS REALIZADAS A LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO EN LA EMPRESA?'},
    {id:11,number:"decimoPrimeraPregunta",nombre:'¿LA EMPRESA SE ASEGURARSE DE QUE LOS PROCESOS Y SERVICIOS SUMINISTRADOS EXTERNAMENTE PERMANECEN DENTRO DEL CONTROL DEL SISTEMA DE GESTIÓN DE LA SEGURIDAD Y SALUD EN EL TRABAJO?'},
    {id:12,number:"decimoSegundaPregunta",nombre:'¿LA EMPRESA ASEGURAR QUE LOS PROCESOS Y SERVICIOS SUMINISTRADOS EXTERNAMENTE CUMPLEN LOS REQUISITOS LEGALES Y DE OTRA ÍNDOLE?'},
    {id:13,number:"decimoTerceraPregunta",nombre:'¿LA EMPRESA TIENE EVIDENCIA DE LA TRAZABILIDAD DE LA INFORMACIÓN ESTABLECIDA EN LA RELACIÓN EMPRESA CONTRATANTE Y CONTRATISTA DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:14,number:"decimoCuartaPregunta",nombre:'¿LA EMPRESA VERIFICA, CONSTATA Y TIENE REGISTRADO EL CUMPLIMIENTO DE LOS ESTÁNDARES MÍNIMOS ESTABLECIDOS EN LA RESOLUCIÓN 1111 DE 2017 (SEVERIDAD, FRECUENCIA Y MORTALIDAD DE LOS ACCIDENTES DE TRABAJO; LA PREVALENCIA E INCIDENCIA RESPECTO DE LAS ENFERMEDADES LABORALES Y EL AUSENTISMO LABORAL) DE LOS DIFERENTES CONTRATISTAS Y EN GENERAL DE TODA EMPRESA QUE PRESTE SERVICIOS EN LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:15,number:"decimoQuintaPregunta",nombre:'¿LA EMPRESA SUMA, CONTABILIZA Y CONSOLIDA LOS INDICADORES MÍNIMOS DE LA SEGURIDAD Y SALUD EN EL TRABAJO DE TODAS Y CADA UNA DE LAS EMPRESAS CONTRATISTAS Y EN GENERAL DE TODA EMPRESA QUE PRESTE SERVICIOS EN LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:16,number:"decimoSextaPregunta",nombre:'¿LA EMPRESA TIENE ACCESO A TODOS Y CADA UNO DE LOS REGISTROS QUE EVIDENCIEN LA EJECUCIÓN DE ACTIVIDADES DE SEGURIDAD Y SALUD EN EL TRABAJO QUE REALICE EL CONTRATISTA DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO DENTRO DE LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:17,number:"decimoSeptimaPregunta",nombre:'¿LA EMPRESA DISPONE DE INFORMACIÓN EN TIEMPO REAL CON ESTADÍSTICAS Y GRÁFICOS ILUSTRATIVOS QUE DEMUESTRAN EL GRADO DE CUMPLIMIENTO DE LOS REQUISITOS LEGALES Y DE OTRA ÍNDOLE PERTINENTES POR PARTE DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO DENTRO DE LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
  ];
  $rootScope.preguntas = $scope.preguntas;

   $scope.closeModel= function(){
           document.getElementById('id01').style.display='none';
   }

  $scope.analizar = function(nombreEmpresa,nombreEmpleado,telefono,email){
        $scope.resultado=parseInt($scope.answers.primeraPregunta) + parseInt($scope.answers.segundaPregunta) + parseInt($scope.answers.terceraPregunta) + parseInt($scope.answers.cuartaPregunta) + parseInt($scope.answers.quintaPregunta) + parseInt($scope.answers.sextaPregunta) + parseInt($scope.answers.septimaPregunta) + parseInt($scope.answers.octavaPregunta) + parseInt($scope.answers.novenaPregunta)  + parseInt($scope.answers.decimaPregunta)  + parseInt($scope.answers.decimoPrimeraPregunta) + parseInt( $scope.answers.decimoSegundaPregunta) + parseInt($scope.answers.decimoTerceraPregunta) + parseInt($scope.answers.decimoCuartaPregunta) + parseInt($scope.answers.decimoQuintaPregunta) + parseInt($scope.answers.decimoSextaPregunta) + parseInt($scope.answers.decimoSeptimaPregunta);
        $scope.global =Math.round(($scope.resultado *100)/17)
        $scope.add = true;
        $scope.answers.nombreEmpresa=nombreEmpresa;
        $scope.answers.nombreEmpleado=nombreEmpleado;
        $scope.answers.telefono=telefono;
        $scope.answers.email=email;

        diagnostico.save($scope.answers,function(){

        },function(err){
             $scope.bandera01 = true;
             document.getElementById('id01').style.display='block';



        });
        $rootScope.answers = $scope.answers;
        $rootScope.global =$scope.global




  }
  $scope.showAlert2=function(ev){

      $mdDialog.show({
            //Controlador del mensajes con operaciones definido en la parte de abajo
           controller: DialogController2,
             //permite la comunicacion con el html que despliega el boton requisitos
           templateUrl: 'test/resumenDiagnostico.html',
           parent: angular.element(document.body),
           targetEvent: ev,
           clickOutsideToClose:true,
           fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
                          })

  }
  function DialogController2($scope, $mdDialog, $rootScope){
        $scope.answers = $rootScope.answers;
        $scope.preguntas = $rootScope.preguntas;
        $scope.preguntasSi=[];
        $scope.preguntasNo=[];
        $scope.global = $rootScope.global;
        $scope.hide = function() {
           $mdDialog.hide();
        };
                                   //funcion para cerral el mensaje
        $scope.cancel = function() {
           $mdDialog.cancel();
         }
         switch($scope.answers.primeraPregunta){
            case "1":
             $scope.preguntasSi.push($scope.preguntas[0])

             break;
            case "0":
            $scope.preguntasNo.push($scope.preguntas[0])

            break;
         }
         switch($scope.answers.segundaPregunta){
                     case "1":
                      $scope.preguntasSi.push($scope.preguntas[1])

                      break;
                     case "0":
                     $scope.preguntasNo.push($scope.preguntas[1])



                     break;
         }
         switch($scope.answers.terceraPregunta){
                  case "1":
                   $scope.preguntasSi.push($scope.preguntas[2])

                   break;
                  case "0":
                  $scope.preguntasNo.push($scope.preguntas[2])



                  break;
         }
         switch($scope.answers.cuartaPregunta){
                              case "1":
                               $scope.preguntasSi.push($scope.preguntas[3])

                               break;
                              case "0":
                              $scope.preguntasNo.push($scope.preguntas[3])



                              break;
          }
          switch($scope.answers.quintaPregunta){
                    case "1":
                     $scope.preguntasSi.push($scope.preguntas[4])

                     break;
                    case "0":
                    $scope.preguntasNo.push($scope.preguntas[4])



                    break;
          }
          switch($scope.answers.sextaPregunta){
                              case "1":
                               $scope.preguntasSi.push($scope.preguntas[5])

                               break;
                              case "0":
                              $scope.preguntasNo.push($scope.preguntas[5])



                              break;
          }
          switch($scope.answers.septimaPregunta){
                              case "1":
                               $scope.preguntasSi.push($scope.preguntas[6])

                               break;
                              case "0":
                              $scope.preguntasNo.push($scope.preguntas[6])



                              break;
          }
          switch($scope.answers.octavaPregunta){
                        case "1":
                         $scope.preguntasSi.push($scope.preguntas[7])

                         break;
                        case "0":
                        $scope.preguntasNo.push($scope.preguntas[7])



                        break;
                    }
           switch($scope.answers.novenaPregunta){
                                  case "1":
                                   $scope.preguntasSi.push($scope.preguntas[8])

                                   break;
                                  case "0":
                                  $scope.preguntasNo.push($scope.preguntas[8])



                                  break;
                              }

           switch($scope.answers.decimaPregunta){
                                             case "1":
                                              $scope.preguntasSi.push($scope.preguntas[9])

                                              break;
                                             case "0":
                                             $scope.preguntasNo.push($scope.preguntas[9])



                                             break;
                                         }
           switch($scope.answers.decimoPrimeraPregunta){
                                                        case "1":
                                                         $scope.preguntasSi.push($scope.preguntas[10])

                                                         break;
                                                        case "0":
                                                        $scope.preguntasNo.push($scope.preguntas[10])

                                                        break;
                                                    }
            switch($scope.answers.decimoSegundaPregunta){
                                             case "1":
                                              $scope.preguntasSi.push($scope.preguntas[11])

                                              break;
                                             case "0":
                                             $scope.preguntasNo.push($scope.preguntas[11])



                                             break;
                                         }


            switch($scope.answers.decimoTerceraPregunta){
                                                         case "1":
                                                          $scope.preguntasSi.push($scope.preguntas[12])

                                                          break;
                                                         case "0":
                                                         $scope.preguntasNo.push($scope.preguntas[12])



                                                         break;
                                                     }
            switch($scope.answers.decimoCuartaPregunta){
                                                         case "1":
                                                          $scope.preguntasSi.push($scope.preguntas[13])

                                                          break;
                                                         case "0":
                                                         $scope.preguntasNo.push($scope.preguntas[13])



                                                         break;
                                                       }
            switch($scope.answers.decimoQuintaPregunta){
                             case "1":
                              $scope.preguntasSi.push($scope.preguntas[14])

                              break;
                             case "0":
                             $scope.preguntasNo.push($scope.preguntas[14])



                             break;
                         }
            switch($scope.answers.decimoSextaPregunta){
                                         case "1":
                                          $scope.preguntasSi.push($scope.preguntas[15])

                                          break;
                                         case "0":
                                         $scope.preguntasNo.push($scope.preguntas[15])



                                         break;
                                     }

            switch($scope.answers.decimoSeptimaPregunta){
                                                     case "1":
                                                      $scope.preguntasSi.push($scope.preguntas[16])

                                                      break;
                                                     case "0":
                                                     $scope.preguntasNo.push($scope.preguntas[16])



                                                     break;
                                                 }


            $scope.a=Math.round(($scope.preguntasSi.length*100)/17);
            $scope.b=Math.round(($scope.preguntasNo.length*100)/17);
            $scope.myChartObject = {};
                            $scope.myChartObject.type = "ColumnChart";

                            $scope.myChartObject.data = {"cols": [
                                                                       {id: "t", label: "Topping", type: "string"},
                                                                       {id: "s", label: "Analisis", type: "number"}
                                                                   ], "rows": [
                                                                       {c: [
                                                                           {v: "Cumplidos % "},
                                                                           {v: $scope.a},
                                                                       ]},
                                                                       {c: [
                                                                           {v: "No Cumplidos %"},
                                                                           {v: $scope.b},
                                                                       ]}
                                                                   ]};

                             $scope.myChartObject.options = {
                                                       'title': 'Estadisticas Requisitos Estaticos'
                                                   };

  }

}]);