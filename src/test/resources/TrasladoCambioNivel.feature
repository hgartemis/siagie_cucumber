@CambioNivel
Feature: Gestion de Traslados por cambio de nivel

  Scenario Outline: 01. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE, y deseo validar el mensaje cuando el codigo modular no es valido o menor a 7 digitos

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And finalmente valido si el mensaje es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | mensaje                                                                                                                        |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 1581581  | El código de IE Traslado no es válido o tiene asociado mas de un anexo. Utilice el boton buscador de Instituciones Educativas. |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 158      | El codigo modular debe tener 7 digitos                                                                                         |

  Scenario Outline: 02. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE, y deseo validar el mensaje cuando el traslado es de un dni invalido.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <dni> del alumno en el textbox dni
    And finalmente valido si el mensaje es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | dni      | mensaje                                                                            |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0203729  | 2222     | El DNI del estudiante debe tener 8 digitos                                         |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0203729  | 12345678 | No se ha encontrado al estudiante con el documento nacional de identidad ingresado |

  Scenario Outline: 03. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE, y deseo validar el mensaje cuando el anio del ultimo año no es el correcto.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <dni> del alumno en el textbox dni
    And ingreso el <ultimo> anio de estudio
    And doy click en boton validar
    And finalmente valido si el mensaje es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | dni      | ultimo | mensaje                                                                     |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0203729  | 62012517 | 2019   | La información ingresada no coincide con la última matrícula del estudiante |


  Scenario Outline: 04. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE, y deseo validar el mensaje cuando el traslado es de un dni valido y no seleccion el check de declaracion jurada.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <dni> del alumno en el textbox dni
    And doy click en boton validar
    And le doy click en Grabar y proceder con el traslado
    And finalmente valido si la alerta es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | dni      | mensaje                                                                                                             |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0203729  | 62012517 | Debe declarar haber recibido la documentación del estudiante por parte del padre de familia y/o Representante Legal |


  Scenario Outline: 05. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE, y deseo validar el mensaje cuando no selecciono ningun documento de recepcion del alumno.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <dni> del alumno en el textbox dni
    And doy click en boton validar
    And en declaracion jurada le doy check de recepcion
    And le doy click en Grabar y proceder con el traslado
    And finalmente valido si la alerta es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | dni      | mensaje                                                                                                                                                   |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0203729  | 62012517 | Debe seleccionar por lo menos uno de los siguientes documentos: Copia de DNI, Ficha Única de Matrícula, Certificado de Estudios u Otro (CE, PAS, PN o DJ) |

  Scenario Outline: 06. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE por el cambio de nivel usando datos validos con dni.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <dni> del alumno en el textbox dni
    And doy click en boton validar
    And en declaracion jurada le doy check de recepcion
    And doy click en algunos de los documentos del estudiante
    And le doy click en Grabar y proceder con el traslado
    And finalmente valido si el mensaje es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | dni      | mensaje                                                                                                                      |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0207985  | 72992763 | Se ha realizado de forma satisfactoria el proceso de traslado del estudiante, el mismo que fue aprobado de manera automática |

  Scenario Outline: 07. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE por el cambio de año usando datos validos de alumno ya registrado.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <codigo> del alumno en el textbox codigo
    And doy click en boton validar
    And finalmente valido si el mensaje es: <mensaje>

    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | codigo         | mensaje                                                             |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0207985  | 12148599400240 | El estudiante cuenta con un proceso de traslado [ En el mismo año ] |

  Scenario Outline: 08. Como usuario deseo ingresar a gestion de traslado donde buscare el proceso de traslado y rechazar la constancia recepcionada del alumno

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciono <tipo traslado> en control traslado
    And selecciono <estado constancia> en control constancia
    And doy click en buscar constancia de traslado
    And busco el <codigo> del alumno en el resultado
    And doy en el click en el boton de estado
    And valido el boton en solicitud y confirmo <estado> de la constancia
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | estado constancia             | codigo         | estado  |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | Constancia recibida en origen | 12148599400240 | rechazo |


  Scenario Outline: 09. Como usuario deseo ingresar y trasladar a un alumno de diferentes IE por el cambio de nivel usando datos validos con codigo del alumno.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciona el boton agregar
    And selecciona el check de acepto las condiciciones
    And doy click en boton proceder
    And selecciono <tipo traslado>, ingreso el <IEOrigen> en textbox
    And doy click en boton Buscar
    And ingreso el <codigo> del alumno en el textbox codigo
    And doy click en boton validar
    And en declaracion jurada le doy check de recepcion
    And doy click en algunos de los documentos del estudiante
    And le doy click en Grabar y proceder con el traslado
    And finalmente valido si el mensaje es: <mensaje>
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado       | IEOrigen | codigo         | mensaje                                                                                                                      |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | 0207985  | 12148599400240 | Se ha realizado de forma satisfactoria el proceso de traslado del estudiante, el mismo que fue aprobado de manera automática |


  Scenario Outline: 10. Como usuario deseo ingresar a gestion de traslado donde buscare el proceso de traslado y confirmar matricula de la constancia recepcionada.

    Given el usuario ingresa a login siagie
    And  ingresar <usuario> en usuario en TextBox
    And  ingresar <contrasena> en contrasena en TextBox
    And ingresar <captcha> en captcha en TextBox
    And hace click en boton Iniciar
    And hacer click en boton Cambiar de IE
    When escribe el <codigoModular> en codMod
    And y selecciona el resultado de la busquedas
    And EL tester selecciona en el menu la opcion matric
    And se dirige a la opcion traslado y seguidamente ingresos
    Then en el formulario de gestion de traslado selecciona <anioDestino>
    And selecciono <tipo traslado> en control traslado
    And selecciono <estado constancia> en control constancia
    And doy click en buscar constancia de traslado
    And busco el <codigo> del alumno en el resultado
    And doy en el click en el boton de estado
    And valido el boton en solicitud y confirmo <estado> de la constancia
    Examples:
      | usuario  | contrasena  | captcha | codigoModular | anioDestino | tipo traslado     | estado constancia             | codigo         | estado    |
      | 19100733 | 2021Siagie@ | abc     | 0245647       | 2021        | Por cambio de nivel | Constancia recibida en origen | 00000071678731 | matricula |