# language: es
# author: Juan Esteban
@FeatureName:AgregarAlCarro
Característica:
  Yo como usuario
  necesito poder añadir productos al carrito
  para posteriormente poder comprarlos

  @ScenarioName:AgregarVestidoCarritoDeCompras
  Esquema del escenario: Agregar vestido carrito de compras
    Dado que el usuario se encuentra en la pagina de inicio del aplicativo
    Cuando ingresa al apartado de vestidos y selecciona sus preferencias
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    Entonces debera de ver el carrito de compras con la cantidad de productos seleccionados "<quantity>"
    Ejemplos:
      | quantity | size | color |
      | 2        | M    | Pink  |

  @ScenarioName:CompletarCompra
  Esquema del escenario: Agregar vestido carrito de compras
    Dado que el usuario se encuentra en la pagina de inicio del aplicativo
    Cuando ingresa al apartado de vestidos y selecciona su articulo
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    E se registra en el aplicativo con sus credenciales y completa el proceso de checkout
    Entonces el sistema debera mostrarle el mensaje "Your order on My Store is complete."
    Ejemplos:
      | quantity | size | color |
      | 5        | L    | Beige  |
