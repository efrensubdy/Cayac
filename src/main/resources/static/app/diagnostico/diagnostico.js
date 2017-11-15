'use strict';

angular.module('myApp.diagnostico', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/diagnostico', {
    templateUrl: 'diagnostico/diagnostico.html',
    controller: 'diagnosticoCtrl'
  });
}])

.controller('diagnosticoCtrl', ['$mdDialog','$location', '$q', '$scope','$log','$rootScope','$localStorage','$sessionStorage',function($mdDialog,$location, $q, $scope,$log,$rootScope,$localStorage,$sessionStorage) {

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
$scope.add=false;
$rootScope.resultado = 0;
 $scope.preguntas=[
    {id:1,nombre:'¿LA EMPRESA CUENTA CON UN PROCEDIMIENTO DOCUMENTADO QUE ADICIONAL A LA SELECCIÓN Y CONTRATACIÓN INCLUYA EL SEGUIMIENTO DEL DESEMPEÑO DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:2,nombre:'¿LA EMPRESA REALIZA EL SEGUIMIENTO DEL DESEMPEÑO DE LOS CONTRATISTA INCLUYENDO LOS ASPECTOS DE SEGURIDAD Y SALUD EN EL TRABAJO DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:3,nombre:'¿LA EMPRESA TIENE UN MECANISMO QUE FACILITE EL CUMPLIMIENTO DE LAS NORMAS DE SEGURIDAD Y SALUD EN EL TRABAJO POR PARTE DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:4,nombre:'¿LA EMPRESA ESTABLECE CANALES DE COMUNICACIÓN PARA LA GESTIÓN DE SEGURIDAD Y SALUD EN EL TRABAJO CON LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:5,nombre:'¿LA EMPRESA VERIFICA ANTES DEL INICIO DEL TRABAJO Y PERIÓDICAMENTE, EL CUMPLIMIENTO DE LA OBLIGACIÓN DE AFILIACIÓN AL SISTEMA GENERAL DE RIESGOS LABORALES, CONSIDERANDO LA ROTACIÓN DEL PERSONAL POR PARTE DE LOS CONTRATISTAS, DE CONFORMIDAD CON LA NORMATIVIDAD VIGENTE?'},
    {id:6,nombre:'¿LA EMPRESA CONOCE, PREVIO AL INICIO DEL CONTRATO, LOS PELIGROS Y RIESGOS GENERALES DE LA ZONA DE TRABAJO DE LOS CONTRATISTAS, INCLUIDAS LAS ACTIVIDADES O TAREAS DE ALTO RIESGO, RUTINARIAS Y NO RUTINARIAS?'},
    {id:7,nombre:'¿LA EMPRESA CONTRATISTA FACILITA LA INFORMACIÓN ACERCA DE LOS PRESUNTOS ACCIDENTES DE TRABAJO Y ENFERMEDADES LABORALES OCURRIDOS DURANTE EL PERIODO DE VIGENCIA DEL CONTRATO PARA QUE EL CONTRATANTE EJERZA LAS ACCIONES DE PREVENCIÓN Y CONTROL QUE ESTÉN BAJO SU RESPONSABILIDAD?'},
    {id:8,nombre:'¿LA EMPRESA VERIFICA PERIÓDICAMENTE Y DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO EN LA EMPRESA, EL CUMPLIMIENTO DE LA NORMATIVIDAD EN SEGURIDAD Y SALUD EL TRABAJO POR PARTE DE LOS CONTRATISTAS Y SUS TRABAJADORES?'},
    {id:9,nombre:'¿LA EMPRESA TIENE DEFINIDOS Y CONSTRUIDOS INDICADORES DE GESTIÓN QUE EVALÚEN LAS NO CONFORMIDADES DETECTADAS A LOS CONTRATISTAS EN EL SEGUIMIENTO AL DESEMPEÑO EN SEGURIDAD Y SALUD EN EL TRABAJO, DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:10,nombre:'¿LA EMPRESA TIENE DEFINIDOS Y CONSTRUIDOS INDICADORES DE GESTIÓN QUE EVALÚEN MEDIANTE LAS ACCIONES CORRECTIVAS, GENERADAS EN LAS AUDITORIAS REALIZADAS A LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO EN LA EMPRESA?'},
    {id:11,nombre:'¿LA EMPRESA SE ASEGURARSE DE QUE LOS PROCESOS Y SERVICIOS SUMINISTRADOS EXTERNAMENTE PERMANECEN DENTRO DEL CONTROL DEL SISTEMA DE GESTIÓN DE LA SEGURIDAD Y SALUD EN EL TRABAJO?'},
    {id:12,nombre:'¿LA EMPRESA ASEGURAR QUE LOS PROCESOS Y SERVICIOS SUMINISTRADOS EXTERNAMENTE CUMPLEN LOS REQUISITOS LEGALES Y DE OTRA ÍNDOLE?'},
    {id:13,nombre:'¿LA EMPRESA TIENE EVIDENCIA DE LA TRAZABILIDAD DE LA INFORMACIÓN ESTABLECIDA EN LA RELACIÓN EMPRESA CONTRATANTE Y CONTRATISTA DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO?'},
    {id:14,nombre:'¿LA EMPRESA VERIFICA, CONSTATA Y TIENE REGISTRADO EL CUMPLIMIENTO DE LOS ESTÁNDARES MÍNIMOS ESTABLECIDOS EN LA RESOLUCIÓN 1111 DE 2017 (SEVERIDAD, FRECUENCIA Y MORTALIDAD DE LOS ACCIDENTES DE TRABAJO; LA PREVALENCIA E INCIDENCIA RESPECTO DE LAS ENFERMEDADES LABORALES Y EL AUSENTISMO LABORAL) DE LOS DIFERENTES CONTRATISTAS Y EN GENERAL DE TODA EMPRESA QUE PRESTE SERVICIOS EN LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:15,nombre:'¿LA EMPRESA SUMA, CONTABILIZA Y CONSOLIDA LOS INDICADORES MÍNIMOS DE LA SEGURIDAD Y SALUD EN EL TRABAJO DE TODAS Y CADA UNA DE LAS EMPRESAS CONTRATISTAS Y EN GENERAL DE TODA EMPRESA QUE PRESTE SERVICIOS EN LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:16,nombre:'¿LA EMPRESA TIENE ACCESO A TODOS Y CADA UNO DE LOS REGISTROS QUE EVIDENCIEN LA EJECUCIÓN DE ACTIVIDADES DE SEGURIDAD Y SALUD EN EL TRABAJO QUE REALICE EL CONTRATISTA DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO DENTRO DE LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
    {id:17,nombre:'¿LA EMPRESA DISPONE DE INFORMACIÓN EN TIEMPO REAL CON ESTADÍSTICAS Y GRÁFICOS ILUSTRATIVOS QUE DEMUESTRAN EL GRADO DE CUMPLIMIENTO DE LOS REQUISITOS LEGALES Y DE OTRA ÍNDOLE PERTINENTES POR PARTE DE LOS CONTRATISTAS DURANTE EL DESARROLLO DE LAS ACTIVIDADES OBJETO DEL CONTRATO DENTRO DE LAS INSTALACIONES, SEDES O CENTROS DE TRABAJO DE LA EMPRESA O ENTIDAD CONTRATANTE?'},
  ];
  $scope.operation = function(select){


    switch (select){
        case "1":
               console.log(select);
            $rootScope.resultado +=  1;
        break;
        case "0":


        break;

  }
  }
  $scope.analizar = function(){
        console.log(Math.round(($rootScope.resultado *100)/17))
        $scope.global =Math.round(($rootScope.resultado *100)/17)
        $scope.add = true;
        $scope.select = '';


  }

}]);