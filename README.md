# org.utl.validador

**Descripción:**

Este paquete Java proporciona una clase, `ValidadorController`, diseñada para validar CURP y RFC mexicanos en aplicaciones JavaFX. Incluye funcionalidades para:

* **Validación de patrones:** Verifica que el formato de la CURP y el RFC cumpla con las especificaciones oficiales.
* **Comparación de CURP y RFC:** Compara los primeros cuatro caracteres (nombre y apellidos) y la fecha de nacimiento para determinar si coinciden.
* **Mensajes de error detallados:** Proporciona mensajes informativos sobre los errores encontrados en la validación.

**Uso:**

1. **Incluir la clase:** Agrega la clase `ValidadorController` a tu proyecto JavaFX.
2. **Asignar elementos FXML:** Vincula los campos de texto `txtCurp` y `txtRfc`, así como los elementos de texto para mostrar los mensajes, a los elementos correspondientes en tu archivo FXML.
3. **Llamar a los métodos de validación:** Utiliza los métodos `verificarCurp()` y `verificarRfc()` para iniciar la validación. El método `compararCampos()` puede ser útil para validar ambos campos simultáneamente.

**Ejemplo:**

```java
// En tu controlador FXML:
@FXML
private void validar() {
    validadorController.verificarCurp();
    validadorController.verificarRfc();
}
