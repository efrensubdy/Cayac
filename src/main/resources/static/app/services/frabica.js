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

         //Fabrica que trae todos los contratos pertencientes al contratante
         .factory('contratos', function($resource) {
                       return $resource('/app/contratos/:idContratante');
                   })

         .factory('contratosEjecucion', function($resource) {
                                return $resource('/app/contratos/ejecucion');
                            })
      .factory('fechaContrato', function($resource) {
                             return $resource('/app/contratos/fecha/:fechaInicio/:fechaFin');
                         })
       .factory('pFinales', function($resource) {
                       return $resource('/app/finalista/:idContratante/:idContrato');
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
      .factory('esC', function($resource) {
                                                      return $resource('/app/cumplimiento/ejecucionSugeridoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                  })

      .factory('esNC', function($resource) {
                                                            return $resource('/app/cumplimiento/ejecucionSugeridoNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                        })

       .factory('fsC', function($resource) {
                                                            return $resource('/app/cumplimiento/finalizacionSugeridoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                        })
       .factory('fsNC', function($resource) {
                                                                   return $resource('/app/cumplimiento/finalizacionSugeridoNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                               })
       .factory('peC', function($resource) {
                        return $resource('/app/cumplimiento/previoSugeridoExtraCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
        .factory('peNC', function($resource) {
                         return $resource('/app/cumplimiento/previoSugeridoExtraNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
        .factory('eeC', function($resource) {
                         return $resource('/app/cumplimiento/ejecucionSugeridoExtraCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })
        .factory('eeNC', function($resource) {
                         return $resource('/app/cumplimiento/ejecucionExtraNoCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                      })

       .factory('feC', function($resource) {
                                return $resource('/app/cumplimiento/finalizacionExtraCumplido/:idFinalista/:idCategoria/:idContratante')

                                                                             })

       .factory('feNC', function($resource) {
                                      return $resource('/app/cumplimiento/finalizacionExtraNoCumplido/:idFinalista/:idCategoria/:idContratante')

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
       .factory('defEjecucionSugeridos', function($resource) {
                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/ejecucionSugeridos');
                                })
      .factory('defEjecucionExtras', function($resource) {
                                          return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/ejecucionExtras');
                                      })
     .factory('defFinalizacionSugeridos', function($resource) {
                                               return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/finalizacionSugeridos');
                                           })
     .factory('defFinalizacionExtras', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/finalizacionExtras');
                                                })


      .factory('defDinamicosPreviosSugeridos', function($resource) {
                                   return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/previosSugeridos');
                               })
       .factory('defDinamicosPreviosExtras', function($resource) {
                                          return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/previosExtras');
                                      })
            .factory('defDinamicosEjecucionSugeridos', function($resource) {
                                         return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/ejecucionSugeridos');
                                     })
           .factory('defDinamicosEjecucionExtras', function($resource) {
                                               return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/ejecucionExtras');
                                           })
          .factory('defDinamicosFinalizacionSugeridos', function($resource) {
                                                    return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/finalizacionSugeridos');
                                                })
          .factory('defDinamicosFinalizacionExtras', function($resource) {
                                                         return $resource('/app/dinamicosDefinitivos/:idContratante/:idCategoria/finalizacionExtras');
                                                     })










     .factory('estadoPreviosSugeridos', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoPreviosSugeridos');
                                                     })
      .factory('estadoPreviosExtras', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoPreviosExtras');
                                                           })
       .factory('estadoEjecucionSugeridos', function($resource) {
                                                    return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoEjecucionSugeridos');
                                                           })
       .factory('estadoEjecucionExtras', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoEjecucionExtras');
                                                                })
        .factory('estadoFinalizacionSugeridos', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoFinalizacionSugeridos');
                                                                        })
       .factory('estadoFinalizacionExtras', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/:idContratante/:idCategoria/:idFinalista/estadoFinalizacionExtras');
                                                                               })

        .factory('estadoDinamicosPreviosSugeridos', function($resource) {
                                                           return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoPreviosSugeridos');
                                                            })
        .factory('estadoDinamicosPreviosExtras', function($resource) {
                                                           return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoPreviosExtras');
                                                                  })
        .factory('estadoDinamicosEjecucionSugeridos', function($resource) {
                                                           return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoEjecucionSugeridos');
                                                                  })
        .factory('estadoDinamicosEjecucionExtras', function($resource) {
                                                          return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoEjecucionExtras');
                                                                       })
        .factory('estadoDinamicosFinalizacionSugeridos', function($resource) {
                                                          return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoFinalizacionSugeridos');
                                                                               })
        .factory('estadoDinamicosFinalizacionExtras', function($resource) {
                                                          return $resource('/app/dinamicosDefinitivos/:idFinalista/:idCategoria/:idContratante/estadoFinalizacionExtras');
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
                            return $resource('/app/finalista/previosSugeridos/:idContratante/:idCategoria');
                        })
        .factory('previosExtras', function($resource) {
                                    return $resource('/app/finalista/previosExtras/:idContratante/:idCategoria');
                                })
       .factory('ejecucion', function($resource) {
                                   return $resource('/app/finalista/ejecucionSugeridos/:idContratante/:idCategoria');
                               })
        .factory('ejecucionExtras', function($resource) {
                                           return $resource('/app/finalista/ejecucionExtras/:idContratante/:idCategoria');
                                       })
        .factory('finalizacion', function($resource) {
                                  return $resource('/app/finalista/finalizacionSugeridos/:idContratante/:idCategoria');
                              })
         .factory('finalizacionExtras', function($resource) {
                                          return $resource('/app/finalista/finalizacionExtras/:idContratante/:idCategoria');
                                      })


        .factory('dinamicosPrevios', function($resource) {
                            return $resource('/app/dinamicos/previosSugeridos/:idContratante/:idCategoria');
                        })
        .factory('dinamicosPreviosExtras', function($resource) {
                                    return $resource('/app/dinamicos/previosExtras/:idContratante/:idCategoria');
                                })
       .factory('dinamicosEjecucion', function($resource) {
                                   return $resource('/app/dinamicos/ejecucionSugeridos/:idContratante/:idCategoria');
                               })
        .factory('dinamicosEjecucionExtras', function($resource) {
                                           return $resource('/app/dinamicos/ejecucionExtras/:idContratante/:idCategoria');
                                       })
        .factory('dinamicosFinalizacion', function($resource) {
                                  return $resource('/app/dinamicos/finalizacionSugeridos/:idContratante/:idCategoria');
                              })
         .factory('dinamicosFinalizacionExtras', function($resource) {
                                          return $resource('/app/dinamicos/finalizacionExtras/:idContratante/:idCategoria');
                                      })


        .factory('traerActividadesPreviasSug', function($resource) {
                              return $resource('/app/actividad/:idFinalista/:idRequisito/previosSugeridos');
                          })
        .factory('traerActividadesPreviasExt', function($resource) {
                                     return $resource('/app/actividad/:idFinalista/:idRequisito/previosExtras');
                                 })
       .factory('traerActividadesEjecSug', function($resource) {
                                    return $resource('/app/actividad/:idFinalista/:idRequisito/ejecucionSugeridos');
                                })
      .factory('traerActividadesEjecExt', function($resource) {
                                          return $resource('/app/actividad/:idFinalista/:idRequisito/ejecucionExtras');
                                      })
     .factory('traerActividadesFinalSug', function($resource) {
                                               return $resource('/app/actividad/:idFinalista/:idRequisito/finalizacionSugeridos');
                                           })
     .factory('traerActividadesFinalExt', function($resource) {
                                                    return $resource('/app/actividad/:idFinalista/:idRequisito/finalizacionExtras');
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

       .factory('finalistas', function($resource) {
                   return $resource('/app/finalista/:id');
               })
        .factory('registroManualFinalista', function($resource) {
                           return $resource('/app/finalista/manual/:id');
                       })
       //Esta fabrica se encarga de mandar un objeto de tipo contratista
       // para su futura agregacion
        .factory('nuevoContrato', function($resource) {
                           return $resource('/app/contratos/:id');
                       })
        .factory('insertarPrevioSugerido', function($resource) {
                                   return $resource('/app/requisitoEstaticos/previoSugerido/:id');
                               })
        .factory('insertarPrevioExtra', function($resource) {
                                           return $resource('/app/requisitoEstaticos/previoExtra/:id');
                                       })
        .factory('insertarEjecucionSugerido', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/ejecucionSugerido/:id');
                                               })
        .factory('insertarEjecucionExtra', function($resource) {
                                               return $resource('/app/requisitoEstaticos/ejecucionExtra/:id');
                                           })
        .factory('insertarFinalizacionSugerido', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/finalizacionSugerido/:id');
                                               })
        .factory('insertarFinalizacionExtra', function($resource) {
                                                   return $resource('/app/requisitoEstaticos/finalizacionExtra/:id');
                                               })


        .factory('iDinamicoPrevioSugerido', function($resource) {
                                   return $resource('/app/dinamicos/previoSugerido/:id');
                               })
        .factory('iDinamicoPrevioExtra', function($resource) {
                                           return $resource('/app/dinamicos/previoExtra/:id');
                                       })
        .factory('iDinamicoEjecucionSugerido', function($resource) {
                                                   return $resource('/app/dinamicos/ejecucionSugerido/:id');
                                               })
        .factory('iDinamicoEjecucionExtra', function($resource) {
                                               return $resource('/app/dinamicos/ejecucionExtra/:id');
                                           })
        .factory('iDinamicoFinalizacionSugerido', function($resource) {
                                                   return $resource('/app/dinamicos/finalizacionSugerido/:id');
                                               })
        .factory('iDinamicoFinalizacionExtra', function($resource) {
                                                   return $resource('/app/dinamicos/finalizacionExtra/:id');
                                               })
        .factory('addActividadPreviaSugerida', function($resource) {
                                           return $resource('/app/actividad/previoSugerido/:id');
                                       })
        .factory('addActividadPrevioExtra', function($resource) {
                                                   return $resource('/app/actividad/previoExtra/:id');
                                               })
        .factory('addActividadEjecucionSugerido', function($resource) {
                                                           return $resource('/app/actividad/ejecucionSugerido/:id');
                                                       })
         .factory('addActividadEjecucionExtra', function($resource) {
                                                       return $resource('/app/actividad/ejecucionExtra/:id');
                                                   })
         .factory('addActividadFinalizacionSugerido', function($resource) {
                                                           return $resource('/app/actividad/finalizacionSugerido/:id');
                                                       })
         .factory('addActividadFinalizacionExtra', function($resource) {
                                                           return $resource('/app/actividad/finalizacionExtra/:id');
                                                       })

        //Esta fabrica se encarga de agregar un contratistas
       .factory('contratistas', function($resource) {
            return $resource('/app/contract/:id');
        });

