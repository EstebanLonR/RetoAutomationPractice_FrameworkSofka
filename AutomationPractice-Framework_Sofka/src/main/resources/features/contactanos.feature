# language: es
# author: Juan Esteban
@FeatureName:contactanos
Característica:
  Yo como usuario
  necesito contactarme con el servicio al cliente
  para poder realizar una pregunta sobre un producto

  @ScenarioName:EnviarPeticion
  Escenario:Enviar peticion
    Dado que el usuario se encuentra en la pagina de incio del aplicativo
    Cuando este se dirige al apartado de contac us y diligencia el formulario de customer service
      | emailAddress                         | orderReference  | message                                 |
      | correoAutomatizacionsofka@correo.com | ConsultaVestido | Quisiera saber si se puede bla bla..... |
    Entonces el sistema debera mostrarle el mensaje "Your message has been successfully sent"

  @ScenarioName:InformarFalloTecnico
  Escenario: : Informar fallo tecnico
    Dado que el usuario se encuentra en la pagina de incio del aplicativo
    Cuando se dirige al apartado de contact us y diligencia el formulario de customer service sin mensaje
      | emailAddress                         | orderReference           |
      | correoAutomatizacionsofka@correo.com | No carga pagina vestidos |
    Entonces el sistema debera mostrarle un mensaje "The message cannot be blank."