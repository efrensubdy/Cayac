'use strict';
angular.module('services.listFactory', ['ngRoute','ngResource'])


     //fabrica que se utiliza para subir un archivo y llevarlo de frontend a back-end
     .service('fileUpload', ['$http','$window',function ($http,$window) {
             this.uploadFileToUrl = function(file, uploadUrl){
                 var fd = new FormData();
                 fd.append('file', file);
                 $http.post(uploadUrl, fd, {
                     transformRequest: angular.identity,
                     headers: {'Content-Type': undefined}
                 })
                 .then(function(){
                     $window.alert("El archivo esta disponible para su uso");
                 });
             }
         }])
         //fabrica que se utiliza para subir los archivos de contrato y llevarlos de frontend a back-end
      .service('contratoUpload', ['$http','$window',function ($http,window) {
                   this.uploadFileToUrl = function(list,uploadUrl){
                       var fd = new FormData();
                        for (var i in list) {
                         console.log(list[i]);
                         fd.append("file"+i,list[i]);
                        }


                       $http.post(uploadUrl, fd,{
                           transformRequest: angular.identity,
                           headers: {'Content-Type': undefined}
                       })
                       .then(function(){
                           $window.alert("El archivo esta disponible para su uso");
                       });
                   }
               }])
      .service('obtainExtension',['$http',function($http){
           this.obtainExtensionFromAPI=function(urlfromGet){
                console.log(urlfromGet);
                 $http.get(urlfromGet).then(function(response){
                    // Place a debugger statement here to see if it's successful
                   console.log( response.data);
                 });


            };



      }])

    .factory('fabrica', function () {
        var data = {
            listado: []
        };
        return {
            getListado: function () {
                return data.listado;
            },
            addTodo: function (todo) {
                data.listado.push(todo);
            }};
    })
     //A partir de este punto los metodos son de tipo GET para estas Fabricas

        // Fabrica que se comunica con el controlador de Contratantes trallendo todos los contratantes
       .factory('diagnosticoGerencia', function($resource) {
                       return $resource('/app/diagnostico/diagnosticoGerencia/:id');
                   })
        //Fabrica que trae todos los contratistas y ta,bien agrega contratantes
       .factory('contratantes', function($resource) {
                return $resource('/app/contractor/:idContratante');
            })
        //Fabrica que trae los contratistas por contratante
       .factory('contratistasPorContratante', function($resource) {
                       return $resource('/app/contractor/contratistasPorContratante/:idContratante');
                   })
        //Fabrica que trae los servicios a contratar a contratante
       .factory('serviciosAContrar', function($resource) {
                       return $resource('/app/contractor/servicioaContratar/:idContratante');
                   })
         //Fabrica que trae los servicios que tienen aosicados a un contratista
       .factory('serviciosConContratista', function($resource) {
                              return $resource('/app/contractor/servicioConContratista/:idContratante');
                          })
        //Fabrica que agrega un servicio a contratar
       .factory('registroServ', function($resource) {
                              return $resource('/app/contractor/serAContratar/:id');
                          })
         //Fabrica que trae todas las actividades economicas
         .factory('activity', function($resource) {
                        return $resource('/app/contract/activity/:id');
                    })
         //Fabrica que trae todos los correos
         .factory('correos', function($resource) {
                                 return $resource('/app/contract/correos');
                             })
        //Fabrica que trar los contratistas pertenecientes al contrato mandado como parametro
        .factory('contratantesContrato', function($resource) {
                            return $resource('/app/contractor/:idContratante/:idContrato');
                        })
         //Fabrica que trae los contratistas que pertenecen al contrato y a lacategoria enviada como parametro
         .factory('contratantesCategoria', function($resource) {
                                    return $resource('/app/contractor/categoria/:idContrato/:idCategoria');
                                })
         //Fabrica que trae una actividad de plan
         .factory('actividadPlan', function($resource) {
                       return $resource('/app/planDeTrabajo/actpC/:idContratista/:mes/:year')

                                        })
          //Fabrica que trae las actividade con soporte
         .factory('actividadConSoporte', function($resource) {
                                return $resource('/app/planDeTrabajo/conSopor/:idContratista/:mes/:year')

                                                 })
          //Fabrica que trae las actividade Sin soporte
         .factory('actividadSinSoporte', function($resource) {
                                         return $resource('/app/planDeTrabajo/sinSopor/:idContratista/:mes/:year')

                                                          })
           //Fabrica que trae el reporte de los contratistas con  las actividade Sin soporte
         .factory('notifacionSinSoporte', function($resource) {
                                                  return $resource('/app/planDeTrabajo/contratante/:idContratante/:mes/:year')

          })
          //Fabrica que trae el reporte de los contratistas con  las actividade Sin registro
          .factory('notifacionSinRegistro', function($resource) {
                                                            return $resource('/app/planDeTrabajo/sinRegistro/:idContratante/:mes/:year')

                    })
           //Fabrica que trae los mensajes del contratista
          .factory('mensajeContr', function($resource) {
              return $resource('/app/planDeTrabajo/mensajesContr/:idContratista/:idContratante')

                    })
              //Fabrica que trae los mensajes del contratante
           .factory('mensajeCtante', function($resource) {
                  return $resource('/app/planDeTrabajo/mensajesContratante/:idContratante')

                        })
             //Fabrica que trae todos los accidentes por contraitista
           .factory('accPorContra', function($resource) {
                         return $resource('/app/accidente/accxContra/:idContratista/:idContratante')

                               })
           //Fabrica que trae todos los indicadores por contraitista
          .factory('indContr', function($resource) {
                        return $resource('/app/indicador/indicadoresContra/:idContratista/:idContratante')

                              })
          //Fabrica que trae todos los estandares minimos por contraitista
          .factory('estContr', function($resource) {
                                  return $resource('/app/estandares/estandaresContra/:idContratista/:idContratante')

                                        })
             //Fabrica que trae todos los estandares minimos por contraitista por reporte
            .factory('exam', function($resource) {
                                             return $resource('/app/example/estandaresContra/:idContratista/:idContratante')

                                                   })
           //Fabrica que trae todos los estandares  por contraitista por año y mes
          .factory('estByMonthYear', function($resource) {
                                            return $resource('/app/estandares/byMonthAndYear/:month/:year/:idContratante')

                                                  })
            //Fabrica que se encarga de traer los indicadores por mes
           .factory('indMes', function($resource) {
                                   return $resource('/app/indicador/indicadoresPorMes/:idContratista/:mes/:year')

                                         })

            //Fabrica que se encarga de traer las seguridades sociales para el contratante
            .factory('seguriContratante', function($resource) {
                                               return $resource('/app/seguridadSocial/socialContratante/:idContratista/:mes/:year')

                                                     })
            //Fabrica que trae el reporte de indicadores por mes
            .factory('repMes', function($resource) {
                                               return $resource('/app/indicador/reportesPorMes/:idContratante/:mes/:year')

                                                     })
            //Fabrica que trae el reporte de indicadores por año
             .factory('repYear', function($resource) {
                                                           return $resource('/app/indicador/reportesPorYear/:idContratante/:year')

                                                                 })
            //Fabrica que trae los contratistas sin indicadores registrados
           .factory('sRIndi', function($resource) {
                                                          return $resource('/app/indicador/sinRegistro/:idContratante/:mes/:year')

                                                                })
            //Fabrica que trae los contratistas sin actividades registrados
           .factory('sPorContra', function($resource) {
                                                                     return $resource('/app/seguridadSocial/segContra/:idContratista')

                                                                           })
            //Fabrica que trae las auditorias por contratistas
           .factory('audiPorContra', function($resource) {
                                  return $resource('/app/auditoria/audi/:idContratante');
                              })
            //Fabrica que trae las auditorias por contratistas
           .factory('auditoriaContratis', function($resource) {
                                             return $resource('/app/auditoria/audi/:idContratista/:mes/:year');
                                         })
          //Fabrica que trae las No Conformidades por contratistas
          .factory('noPorContra', function($resource) {
                                            return $resource('/app/noConformidad/porContra/:idContratista');
                                        })
          //Fabrica que trae las auditorias por auditoria
       .factory('noPorContraAuditoria', function($resource) {
                                                   return $resource('/app/noConformidad/porContra/:idContratista/:idAuditoria');
                                               })
         //Fabrica que trae las causas por contratistas
          .factory('caPorContra', function($resource) {
                                                      return $resource('/app/causa/porContra/:idContratista/:idNoConformidad');
                                                  })
        //Fabrica que trae las acciones por contratistas
          .factory('accionContra', function($resource) {
                                                                return $resource('/app/accion/porContra/:idContratista/:idCausa');
                                                            })
         //Fabrica que trae las acciones con registro
          .factory('accionConRegistro', function($resource) {
                                                                          return $resource('/app/accion/conRegistro/:idContratista/:idCausa');
             //Fabrica que trae las acciones con registro                                                          })
            .factory('accionSinRegistro', function($resource) {
                                                                          return $resource('/app/accion/sinRegistro/:idContratista/:idCausa');
          //Fabrica que trae las no coformidades que esten cerradas con registro                                                             })
        .factory('noConforCerradas', function($resource) {
                                               return $resource('/app/cierre/isCl/:idContratista');
                                                                              })

        .factory('noConforCerradasConAuditoria', function($resource) {
                                                       return $resource('/app/cierre/isCl/:idContratista/:idAuditoria');
                                                                                      })
         //Fabrica que trae todos los contratos pertencientes al contratante
         .factory('contratos', function($resource) {
                       return $resource('/app/contratos/:idContratante');
                   })
        // Fabrica que trae  los contratos que  esten en  ejecucion
         .factory('contratosEjecucion', function($resource) {
                                return $resource('/app/contratos/ejecucion/:idContratante');
                            })
        // Fabrica que trae  los contratos que nesten en  ejecucion
         .factory('contratosEnEjecucion', function($resource) {
                                         return $resource('/app/contratos/enEjecucion/:idContratante');
                                     })
       // Fabrica que trae fecha de contrato
      .factory('fechaContrato', function($resource) {
                             return $resource('/app/contratos/fecha/:fechaInicio/:fechaFin/:idContratante');
                         })
       //Fabrica que trae los finalistas que ya estan en ejecucion
       .factory('pFinales', function($resource) {
                       return $resource('/app/finalista/:idContratante/:idContrato');
                   })
         .factory('finalesSeleccion', function($resource) {
                               return $resource('/app/finalista/deSeleccion/:idContratante');
                           })
         .factory('finalesDefinitivos', function($resource) {
                                        return $resource('/app/finalista/definitivo/:idContratante/:idContrato');
                                    })
        //Fabrica que se comunica con el controlador de contratista trallendo los requisitos sugeridos cumplidos

       .factory('rCumplidos', function($resource) {
                        return $resource('/app/contractor/requisitoC/:idContratista/:idCategoria/:idContratante')


                   })
       //Fabrica que se comunica con el controlador de comntratista trallendo los requisitos sugeridos cumplidos
        .factory('rNoCumplidos', function($resource) {
                               return $resource('/app/contractor/requisitoNC/:idContratista/:idCategoria/:idContratante')

                           })
        //Fabrica que se comunica con el controlador de contratista trallendo los requisitos Extras cumplidos
      .factory('rExtras', function($resource) {
                             return $resource('/app/contractor/requisitoE/:idContratista/:idCategoria/:idContratante')
                         })
       //Fabrica que se comunica con el controlador de contratista trallendo los requisitos Extras NO cumplidos
      .factory('rExtrasNC', function($resource) {
                                   return $resource('/app/contractor/requisitoENC/:idContratista/:idCategoria/:idContratante')

                               })
        //Fabrica que trae los requistos cumplidos
       .factory('psC', function($resource) {
                                          return $resource('/app/cumplimiento/previoSugeridoCumplido/:idFinalista/:idCategoria/:idContratante')

                                      })
       //Fabrica que trae los requistos no  cumplidos
      .factory('psNC', function($resource) {
                                                return $resource('/app/cumplimiento/previoSugeridoNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                            })
        //Fabrica que trae los requistos extras cumplidos
       .factory('peC', function($resource) {
                        return $resource('/app/cumplimiento/previoSugeridoExtraCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
        //Fabrica que trae los requistos extras no cumplidos
        .factory('peNC', function($resource) {
                         return $resource('/app/cumplimiento/previoSugeridoExtraNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
       //Fabrica que se comunica con el controlador de contratista trallendo el estado de los  los requisitos sugeridos
       //cumplidos para subir documentos
       .factory('rEstadoR', function($resource) {
                                         return $resource('/app/contract/estadoR/:idContratante/:idCategoria/:idContratista',{},{
                                                                get: {
                                                                    method: 'GET',
                                                                    isArray: true,
                                                                    params:{
                                                                        idContratante: '@idContratante' ,
                                                                        idCategoria: '@idCategoria',
                                                                        idContratista:'@idContratista'


                                                                    }

                                                                }
                                                                                             });
                                     })
        //Fabrica que se comunica con el controlador de contratista trallendo el estado de los  los requisitos Extras
               //cumplidos para subir documentos
       .factory('rEstadoE', function($resource) {

                                                return $resource('/app/contract/estadoE/:idContratante/:idCategoria/:idContratista',{},{
                                                           get: {
                                                              method: 'GET',
                                                              isArray: true,
                                                              params:{
                                                                      idContratante: '@idContratante' ,
                                                                      idCategoria: '@idCategoria' ,
                                                                      idContratista: '@idContratista'

                                                                      }

                                                           }
                                                });
                                            })

        // Fabrica que se comunica con el controlador de Requisitos Obligatorios
        // a partir de la variable que recibe que es el id del Contratista
        // trae todos los requisitos obligatorios de ese contratista si existe
       .factory('rObligatorio', function($resource) {
                       return $resource('/app/requisitosObligatorios/:idContratante/:idCategoria/obligatorio');
                   })
        //Fabrica que trae los requisitos definitivos
       .factory('defPreviosSugeridos', function($resource) {
                              return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/previosSugeridos');
                          })
         //Fabrica que trae los requisitos extras  definitivos
        .factory('defPreviosExtras', function($resource) {
                                     return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/previosExtras');
                                 })
        //Fabrica que trae el estado de los requisitos
     .factory('estadoPreviosSugeridos', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoPreviosSugeridos');
                                                     })
        //Fabrica que trae el estado de los requisitos extras
      .factory('estadoPreviosExtras', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoPreviosExtras');
                                                           })


        // Fabrica que se comunica con el controlador de Requisitos Extras
                // a partir de la variable que recibe que es el id del Contratista
                // trae todos los requisitos Extras de ese contratista si existe
        .factory('rExtra', function($resource) {
                              return $resource('/app/requisitosExtras/:idContratante/:idCategoria/extras');
                          })
       // Fabrica que se comunica con el controlador de Requisitos Sugeridos
               // a partir de la variable que recibe que es el id del Contratista
               // trae todos los requisitos Sugeridos Obligatorios de ese contratista si existe
       .factory('requisitos', function($resource) {
                    return $resource('/app/login/contratista/:idContratante/:idCategoria/requisitos');
                })
       // Fabrica que se comunica con el controlador de Requisitos Sugeridos
                      // a partir de la variable que recibe que es el id del Contratista
                      // trae todos los requisitos Sugeridos Extras de ese contratista si existe
         .factory('extras', function($resource) {
                            return $resource('/app/login/contratista/:idContratante/:idCategoria/extras');
                        })
        //Fabrica que trae los requsitos previos
        .factory('previos', function($resource) {
                            return $resource('/app/finalista/previosSugeridos/:idContratante/:idCategoria',{},{

                                get: {
                                           method: 'GET',
                                            isArray: true
                                                     }


                            });
                        })
         //Fabrica que trae los requsitos previos   extras
        .factory('previosExtras', function($resource) {
                                    return $resource('/app/finalista/previosExtras/:idContratante/:idCategoria');
                                })
        //A partir de este punto los metodos son de tipo POST para estas Fabrica

        // Esta fabrica se encarga de mandar un objeto de tipo USER que proviene de un contratante
         //para realizar la actualizacion de contraseña
       .factory('loginContratante', function($resource) {
                            return $resource('/app/login/contratante/:id');
                        })
        // Esta fabrica se encarga de mandar un objeto de tipo USER  que proviene de un contratista
         //para realizar la actualizacion de Contraseña
       .factory('loginContratista', function($resource) {
                                   return $resource('/app/login/contratista/:id');
                               })
        // Esta fabrica se encarga de mandar un objeto de tipo Requisito Obligatorio
       //que proviene de un contratista
      //para agregar los requisitos obligatorios  que tenga el contratista

       .factory('requisitosObligatorios', function($resource) {
                                            return $resource('/app/requisitosObligatorios/:id');
                                        })
        // Esta fabrica se encarga de mandar un objeto de tipo Requisito eXTRA
              //que proviene de un contratista
             //para agregar los requisitos Extra  que tenga el contratista
       .factory('requisitosExtras', function($resource) {
                                             return $resource('/app/requisitosExtras/:id');
                                                   })
        //Fabrica que se encarga de eliminar los requisitos
        .factory('requisitosOEliminar', function($resource) {
                                                     return $resource('/app/requisitosObligatorios/eliminar/:idRequisito/:idContratante');
                                                           })
        //Fabrica que se encarga de eliminar los requisitos extras
         .factory('requisitosEEliminar', function($resource) {
                                                             return $resource('/app/requisitosExtras/eliminar/:idRequisito/:idContratante');
                                                                   })
      //Fabrica que se encarga de eliminar los requisitos de ejecucion
        .factory('eliminarPS', function($resource) {
               return $resource('/app/eliminar/eliminarPS/:idRequisito/:idContratante');
                                                                            })
        //Fabrica que se encarga de eliminar los requisitos de ejecucion
        .factory('eliminarPE', function($resource) {
                      return $resource('/app/eliminar/eliminarPE/:idRequisito/:idContratante');
                                                                                    })
       //Fabrica que se encarga de eliminar los mensajes del contratista
        .factory('eliminarMessagesContratistas', function($resource) {
              return $resource('/app/eliminarMessages/eliminarMContratista/:idMessage');
                                                                            })
         //Fabrica que se encarga de eliminar los mensajes del contratante
        .factory('eliminarMessagesContratantes', function($resource) {
                      return $resource('/app/eliminarMessages/eliminarMContratante/:idMessage');
                                                                                    })
        //Esta fabrica manda las imagenes, los documentos Y las fechas para luego se almacenen
       .factory('imagenes', function($resource) {
                                            return $resource('/app/imagenes/:id');
                                                             })
        //Esta fabrica manda las imagenes, los documentos Y las fechas para luego se almacenen
       .factory('documentos', function($resource) {
                                                   return $resource('/app/documento/:id');
                                               })
        //Esta fabrica se encargade traer los limites
       .factory('limites', function($resource) {
                                                     return $resource('/app/limites/:id');
                                                                           })
       //Esta fabrica agrega a los finalistas
       .factory('fechaLimiteContratante', function($resource) {
                                                            return $resource('/app/limites/limit/:idContratante');
                                                                                  })
        //ESta fabrica registra un requisito de ejecucion
       .factory('insertarPrevioSugerido', function($resource) {
                                          return $resource('/app/requisitoEstaticos/previosSugerido/:id');
                                      })
        //ESta fabrica registra un requisito de ejecucion
        .factory('insertarPrevioExtra', function($resource) {
                                                  return $resource('/app/requisitoEstaticos/previosExtra/:id');
                                              })
        //ESta fabrica registra un finalista
       .factory('finalistas', function($resource) {
                   return $resource('/app/finalista/:id');
               })
         //ESta fabrica registra un finalista sin pasar por seleccion
        .factory('registroManualFinalista', function($resource) {
                           return $resource('/app/finalista/manual/:id');
                       })
           //ESta fabrica registra un finalista en ejecucion desde seleccion
        .factory('selecFin', function($resource) {
                                   return $resource('/app/finalista/selecFin/:id');
                               })
       //Esta fabrica se encarga de mandar un objeto de tipo contratista
       // para su futura agregacion
        .factory('nuevoContrato', function($resource) {
                           return $resource('/app/contratos/:id');
                       })
        //Esta fabrica agreaga una actividad al plan de trabajo
        .factory('plandeTrabajo', function($resource) {
                                   return $resource('/app/planDeTrabajo/:id');
                               })
        //Esta fabrica registra la aprobacion de un plan de trabajo
        .factory('aproba', function($resource) {
                                           return $resource('/app/planDeTrabajo/aprobacion/:id');
                                       })
         //Esta fabrica registra las no conformidades
         .factory('noConformidad', function($resource) {
                                                   return $resource('/app/noConformidad/registro/:id');
                                               })
           //Esta fabrica registra las causas
          .factory('causa', function($resource) {
                                                           return $resource('/app/causa/registro/:id');
                                                       })
           //Esta fabrica actualiza la info de un contratista
          .factory('actualizarInfo', function($resource) {
                                                                     return $resource('/app/actualizacionDeInfo/Registro/:id');
                                                                 })
           //Esta fabrica actualiza la info de un indicador
          .factory('actualizarIndicador', function($resource) {
                                                                               return $resource('/app/actualizacionDeInfo/RegistroIndicador/:id');
                                                                           })
           //Esta fabrica actualiza la info de un accidente
          .factory('actualizarAccidentes', function($resource) {
                                                                                         return $resource('/app/actualizacionDeInfo/RegistroAccidente/:id');
                                                                                     })
           //Esta fabrica actualiza la info de un estandar
          .factory('actualizarEstandar', function($resource) {
                                                                                                   return $resource('/app/actualizacionDeInfo/RegistroEstandar/:id');
                                                                                               })
           //Esta fabrica actualiza la info de un actividad
          .factory('actualizarPlanDeTrabajo', function($resource) {
                                                     return $resource('/app/actualizacionDeInfo/RegistroPlanDeTrabajo/:id');
                                                 })
           //Esta fabrica actualiza la info de una no conformidad
          .factory('actualizarNoConformidad', function($resource) {
                                                               return $resource('/app/actualizacionDeInfo/RegistroNoConformidad/:id');
                                                           })
            //Esta fabrica actualiza la info de una causa
           .factory('actualizarCausa', function($resource) {
                                                                          return $resource('/app/actualizacionDeInfo/RegistroCausa/:id');
                                                                      })
            //Esta fabrica actualiza la info de una accion
            .factory('actualizarAccion', function($resource) {
                                                                                     return $resource('/app/actualizacionDeInfo/RegistroAccion/:id');
                                                                                 })

            //Esta fabrica actualiza la info de un servicio a contratar
            .factory('actualizarServicio', function($resource) {
                                                                                                 return $resource('/app/actualizacionDeInfo/RegistroServicio/:id');
                                                                                             })
        //Esta fabrica registra un indicador
        .factory('indicador', function($resource) {
                                                   return $resource('/app/indicador/Indicadores/:id');
                                               })
        //Esta fabrica registra un estandar
        .factory('estandar', function($resource) {
                                                           return $resource('/app/estandares/minimos/:id');
                                                       })
          //Esta fabrica registra un example para pruebas only
         .factory('example', function($resource) {
                                                                    return $resource('/app/example/minimos/:id');
                                                                })
         //Esta fabrica registra un accidente
        .factory('acciDente', function($resource) {
                                                           return $resource('/app/accidente/acci/:id');
                                                       })
         //Esta fabrica registra un diagnostico
         .factory('diagnostico', function($resource) {
                                                                   return $resource('/app/diagnostico/diag/:id');
                                                               })
         //Esta fabrica registra una accion
        .factory('registroDeAccion', function($resource) {
                                                                   return $resource('/app/accion/Registro/:id');
                                                               })
          //Esta fabrica registra una aprobacion de indicador
        .factory('aprobarIndicador', function($resource) {
                                                           return $resource('/app/indicador/aprobacionIndicadores/:id');
                                                       })
           //Esta fabrica registra una aprobacion de una actividad
        .factory('aprobaPLanDeTrabajo', function($resource) {
                                                   return $resource('/app/planDeTrabajo/aprobacionDePlanDeTrabajo/:id');
                                               })
          //Esta fabrica registra una mensaje en el inbox de contratista
        .factory('mensajeContratista', function($resource) {
                                                   return $resource('/app/planDeTrabajo/mensaje/:id');
                                               })
        //Esta fabrica registra una mensaje en el inbox de Contratante
        .factory('mensajeContratante', function($resource) {
                                                           return $resource('/app/planDeTrabajo/mensajeContratante/:id');
                                                       })
          //Esta fabrica registra un cierre
        .factory('cierre', function($resource) {
                                                           return $resource('/app/cierre/registro/:id');
                                                       })

        //Esta fabrica se encarga de agregar un contratistas
       .factory('contratistas', function($resource) {
            return $resource('/app/contract/:id');
        });

