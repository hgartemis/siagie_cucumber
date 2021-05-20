@Login
Feature: Pagina inicial de Autenticacion

  Como usuario quiero validar que la pagina inicial tenga los mismos controles
  y validar los mensajes en caso:  se envie datos validos y invalidos

  Background:
    Given El usuario se encuentra en la pagina inicial

  Scenario: 01. Ingresar a Siagie y validar cada uno de los objetos

    When entonces valida cada uno de los controles
    Then finalmente se confirma la existencia de cada uno


  Scenario Outline: 02. como usuario tester quiero validar los mensajes
    obligatorios al dar click en boton iniciar y verificar
    el mensaje del usuario como campo requerido

    When escribo mi <contrasena> en textbox contrasena
    And escribo mi <captcha> en textbox captcha
    Then se deberia mostrar <mensaje> de validacion
    Examples:
      | contrasena  | captcha | mensaje                          |
      | 2021Siagie@ | abc     | El usuario es un campo requerido |


  Scenario Outline: 03. como usuario tester quiero validar los mensajes
    obligatorios al dar click en boton iniciar y verificar
    el mensaje del contraseña como campo requerido

    When escribo mi <usuario> en textbox usuario
    And escribo mi <captcha> en textbox captcha
    And ss
    Then se deberia mostrar <mensaje> de validacion
    Examples:
      | usuario  | captcha | mensaje                             |
      | 19100733 | abd     | La contraseña es un campo requerido |

  Scenario Outline: 04. como usuario tester quiero validar los mensajes
  obligatorios al dar click en boton iniciar y verificar
  el mensaje de captcha como campo requerido

    When escribo mi <usuario> en textbox usuario
    And escribo mi <contrasena> en textbox contrasena
    Then se deberia mostrar <mensaje> de validacion
    Examples:
      | usuario  | contrasena  | mensaje                                 |
      | 19100733 | 2021Siagie@ | El código captcha es un campo requerido |

  Scenario Outline: 05. como usuario tester quiero validar el mensaje
    cuando los valores son invalidos en el usuario y contraseña

    When escribo mi <usuario> en textbox usuario
    And escribo mi <contrasena> en textbox contrasena
    And escribo mi <captcha> en textbox captcha
    Then se deberia mostrar <mensaje> de validacion
    Examples:
      | usuario  | contrasena  | captcha | mensaje                                |
      | abc      | 2021Siagie@ | abc     | El usuario o password es incorrecto!!! |

  Scenario Outline: 06. como usuario tester quiero validar la
    redireccion a la aplicacion ingresando los valores validos

    When escribo mi <usuario> en textbox usuario
    And escribo mi <contrasena> en textbox contrasena
    And escribo mi <captcha> en textbox captcha
    Then se deberia poder ingresar a la aplicacion
    Examples:
      | usuario  | contrasena  | captcha |
      | 19100733 | 2021Siagie@ | abc     |

