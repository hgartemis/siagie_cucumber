@Gestion
Feature: Seleccionar Institucion Educativa Destino

  Como usuario ingreso a la funcionadad de Gestion de traslados y
  valido controles si me encuentro en el formulario correcto

  Background:
    Given el tester selecciona el boton de seleccion de IE

  Scenario Outline: 01. Ingreso al formulario principal donde ubico una IE
  para la funcionalidad de traslados

    And ingresa su <usuario> en textbox usuario
    And ingresa su <contrasena> en textbox contrasena
    And ingresa su <captcha> en textbox captcha
    And da click en boton iniciar
    When se posiciona en cambio de IE y escribe el <codigoModular> en textbox codMod
    And y selecciona el resultado de la busqueda
    Then finalmente se valida en formulario principal el <codigoModular> seleccionado
    Examples:
      | usuario  | contrasena  | captcha | codigoModular |
      | 19100733 | 2021Siagie@ | abc     | 0245647       |

  Scenario Outline: 02. Selecciono en el menu la opcion matricula e
  identifico la gestion de traslado para ir directamente a la opcion ingreso

    And ingresa su <usuario> en textbox usuario
    And ingresa su <contrasena> en textbox contrasena
    And ingresa su <captcha> en textbox captcha
    And da click en boton iniciar
    When se posiciona en cambio de IE y escribe el <codigoModular> en textbox codMod
    And y selecciona el resultado de la busqueda
    And EL tester selecciona en el menu la opcion matricula
    And se dirige a la opcion traslado y seguidamente ingreso
    Then finalmente valido si se encuentra en el formulario de traslados
    Examples:
      | usuario  | contrasena  | captcha | codigoModular |
      | 19100733 | 2021Siagie@ | abc     | 0245647       |

