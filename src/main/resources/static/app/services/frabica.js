'use strict';
angular.module('services.listFactory', ['ngRoute','ngResource'])


     //fabrica qie se utiliza para usar datos de prueba que no tienen persistencia
     .service('fileUpload', ['$http', function ($http) {
             this.uploadFileToUrl = function(file, uploadUrl){
                 var fd = new FormData();
                 console.log("llego");
                 fd.append('file', file);
                 $http.post(uploadUrl, fd, {
                     transformRequest: angular.identity,
                     headers: {'Content-Type': undefined}
                 })
                 .then(function(){
                     console.log("sirvio---------------------------------------------------------------");
                 });
             }
         }])
      .service('contratoUpload', ['$http', function ($http) {
                   this.uploadFileToUrl = function(list,uploadUrl){
                       var fd = new FormData();
                        for (var i in list) {
                         console.log(list[i]);
                         fd.append("file"+i,list[i]);
                        }

                       console.log("llego");
                       $http.post(uploadUrl, fd,{
                           transformRequest: angular.identity,
                           headers: {'Content-Type': undefined}
                       })
                       .then(function(){
                           console.log("sirvio---------------------------------------------------------------");
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
       .factory('contratantes', function($resource) {
                return $resource('/app/contractor/:idContratante');
            })
       .factory('serviciosAContrar', function($resource) {
                       return $resource('/app/contractor/servicioaContratar/:idContratante');
                   })
       .factory('serviciosConContratista', function($resource) {
                              return $resource('/app/contractor/servicioConContratista/:idContratante');
                          })
       .factory('registroServ', function($resource) {
                              return $resource('/app/contractor/serAContratar/:id');
                          })
         .factory('activity', function($resource) {
                        return $resource('/app/contract/activity/:id');
                    })

        //Fabrica que trar los contratistas pertenecientes al contrato mandado como parametro
        .factory('contratantesContrato', function($resource) {
                            return $resource('/app/contractor/:idContratante/:idContrato');
                        })
         //Fabrica que trae los contratistas que pertenecen al contrato y a lacategoria enviada como parametro
         .factory('contratantesCategoria', function($resource) {
                                    return $resource('/app/contractor/categoria/:idContrato/:idCategoria');
                                })
         .factory('actividadPlan', function($resource) {
                       return $resource('/app/planDeTrabajo/actpC/:idContratista/:mes/:year')

                                        })
         .factory('actividadConSoporte', function($resource) {
                                return $resource('/app/planDeTrabajo/conSopor/:idContratista/:mes/:year')

                                                 })
         .factory('actividadSinSoporte', function($resource) {
                                         return $resource('/app/planDeTrabajo/sinSopor/:idContratista/:mes/:year')

                                                          })
         .factory('notifacionSinSoporte', function($resource) {
                                                  return $resource('/app/planDeTrabajo/contratante/:idContratante/:mes/:year')

          })
          .factory('notifacionSinRegistro', function($resource) {
                                                            return $resource('/app/planDeTrabajo/sinRegistro/:idContratante/:mes/:year')

                    })
          .factory('mensajeContr', function($resource) {
              return $resource('/app/planDeTrabajo/mensajesContr/:idContratista/:idContratante')

                    })
           .factory('accPorContra', function($resource) {
                         return $resource('/app/accidente/accxContra/:idContratista/:idContratante')

                               })
          .factory('indContr', function($resource) {
                        return $resource('/app/indicador/indicadoresContra/:idContratista/:idContratante')

                              })
          .factory('estContr', function($resource) {
                                  return $resource('/app/estandares/estandaresContra/:idContratista/:idContratante')

                                        })
           .factory('indMes', function($resource) {
                                   return $resource('/app/indicador/indicadoresPorMes/:idContratista/:mes/:year')

                                         })
            .factory('seguriContratante', function($resource) {
                                               return $resource('/app/seguridadSocial/socialContratante/:idContratista/:mes/:year')

                                                     })
            .factory('repMes', function($resource) {
                                               return $resource('/app/indicador/reportesPorMes/:idContratante/:mes/:year')

                                                     })
             .factory('repYear', function($resource) {
                                                           return $resource('/app/indicador/reportesPorYear/:idContratante/:year')

                                                                 })
           .factory('sRIndi', function($resource) {
                                                          return $resource('/app/indicador/sinRegistro/:idContratante/:mes/:year')

                                                                })
           .factory('sPorContra', function($resource) {
                                                                     return $resource('/app/seguridadSocial/segContra/:idContratista')

                                                                           })
           .factory('audiPorContra', function($resource) {
                                  return $resource('/app/auditoria/audi/:idContratante');
                              })
           .factory('auditoriaContratis', function($resource) {
                                             return $resource('/app/auditoria/audi/:idContratista/:mes/:year');
                                         })
          .factory('noPorContra', function($resource) {
                                            return $resource('/app/noConformidad/porContra/:idContratista');
                                        })
          .factory('caPorContra', function($resource) {
                                                      return $resource('/app/causa/porContra/:idContratista/:idNoConformidad');
                                                  })
          .factory('accionContra', function($resource) {
                                                                return $resource('/app/accion/porContra/:idContratista/:idCausa');
                                                            })
          .factory('accionConRegistro', function($resource) {
                                                                          return $resource('/app/accion/conRegistro/:idContratista/:idCausa');
                                                                      })
            .factory('accionSinRegistro', function($resource) {
                                                                          return $resource('/app/accion/sinRegistro/:idContratista/:idCausa');
                                                                      })
        .factory('noConforCerradas', function($resource) {
                                               return $resource('/app/cierre/isCl/:idContratista');
                                                                              })
         //Fabrica que trae todos los contratos pertencientes al contratante
         .factory('contratos', function($resource) {
                       return $resource('/app/contratos/:idContratante');
                   })

         .factory('contratosEjecucion', function($resource) {
                                return $resource('/app/contratos/ejecucion/:idContratante');
                            })
         .factory('contratosEnEjecucion', function($resource) {
                                         return $resource('/app/contratos/enEjecucion/:idContratante');
                                     })
      .factory('fechaContrato', function($resource) {
                             return $resource('/app/contratos/fecha/:fechaInicio/:fechaFin/:idContratante');
                         })
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
       //Fabrica que se comunica con el controlador de contratista trallendo los requisitos sugeridos cumplidos
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
       .factory('psC', function($resource) {
                                          return $resource('/app/cumplimiento/previoSugeridoCumplido/:idFinalista/:idCategoria/:idContratante')

                                      })
      .factory('psNC', function($resource) {
                                                return $resource('/app/cumplimiento/previoSugeridoNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                            })
       .factory('peC', function($resource) {
                        return $resource('/app/cumplimiento/previoSugeridoExtraCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
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

       .factory('defPreviosSugeridos', function($resource) {
                              return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/previosSugeridos');
                          })
        .factory('defPreviosExtras', function($resource) {
                                     return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/previosExtras');
                                 })

     .factory('estadoPreviosSugeridos', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoPreviosSugeridos');
                                                     })
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

        .factory('previos', function($resource) {
                            return $resource('/app/finalista/previosSugeridos/:idContratante/:idCategoria',{},{

                                get: {
                                           method: 'GET',
                                            isArray: true
                                                     }


                            });
                        })
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

        .factory('requisitosOEliminar', function($resource) {
                                                     return $resource('/app/requisitosObligatorios/eliminar/:idRequisito/:idContratante');
                                                           })
         .factory('requisitosEEliminar', function($resource) {
                                                             return $resource('/app/requisitosExtras/eliminar/:idRequisito/:idContratante');
                                                                   })
        .factory('eliminarPS', function($resource) {
               return $resource('/app/eliminar/eliminarPS/:idRequisito/:idContratante');
                                                                            })
        .factory('eliminarPE', function($resource) {
              return $resource('/app/eliminar/eliminarPE/:idRequisito/:idContratante');
                                                                            })

        //Esta fabrica manda las imagenes, los documentos Y las fechas para luego se almacenen
       .factory('imagenes', function($resource) {
                                            return $resource('/app/imagenes/:id');
                                                             })
       .factory('documentos', function($resource) {
                                                   return $resource('/app/documento/:id');
                                               })

       .factory('limites', function($resource) {
                                                     return $resource('/app/limites/:id');
                                                                           })
       //Esta fabrica agrega a los finalistas
       .factory('fechaLimiteContratante', function($resource) {
                                                            return $resource('/app/limites/limit/:idContratante');
                                                                                  })
       .factory('insertarPrevioSugerido', function($resource) {
                                          return $resource('/app/requisitoEstaticos/previosSugerido/:id');
                                      })
        .factory('insertarPrevioExtra', function($resource) {
                                                  return $resource('/app/requisitoEstaticos/previosExtra/:id');
                                              })
       .factory('finalistas', function($resource) {
                   return $resource('/app/finalista/:id');
               })
        .factory('registroManualFinalista', function($resource) {
                           return $resource('/app/finalista/manual/:id');
                       })
        .factory('selecFin', function($resource) {
                                   return $resource('/app/finalista/selecFin/:id');
                               })
       //Esta fabrica se encarga de mandar un objeto de tipo contratista
       // para su futura agregacion
        .factory('nuevoContrato', function($resource) {
                           return $resource('/app/contratos/:id');
                       })
        .factory('plandeTrabajo', function($resource) {
                                   return $resource('/app/planDeTrabajo/:id');
                               })
        .factory('aproba', function($resource) {
                                           return $resource('/app/planDeTrabajo/aprobacion/:id');
                                       })
         .factory('noConformidad', function($resource) {
                                                   return $resource('/app/noConformidad/registro/:id');
                                               })
          .factory('causa', function($resource) {
                                                           return $resource('/app/causa/registro/:id');
                                                       })
        .factory('indicador', function($resource) {
                                                   return $resource('/app/indicador/Indicadores/:id');
                                               })
        .factory('estandar', function($resource) {
                                                           return $resource('/app/estandares/minimos/:id');
                                                       })
        .factory('acciDente', function($resource) {
                                                           return $resource('/app/accidente/acci/:id');
                                                       })
        .factory('registroDeAccion', function($resource) {
                                                                   return $resource('/app/accion/Registro/:id');
                                                               })
        .factory('aprobarIndicador', function($resource) {
                                                           return $resource('/app/indicador/aprobacionIndicadores/:id');
                                                       })
        .factory('aprobaPLanDeTrabajo', function($resource) {
                                                   return $resource('/app/planDeTrabajo/aprobacionDePlanDeTrabajo/:id');
                                               })
        .factory('mensajeContratista', function($resource) {
                                                   return $resource('/app/planDeTrabajo/mensaje/:id');
                                               })
        .factory('cierre', function($resource) {
                                                           return $resource('/app/cierre/registro/:id');
                                                       })

        //Esta fabrica se encarga de agregar un contratistas
       .factory('contratistas', function($resource) {
            return $resource('/app/contract/:id');
        });

