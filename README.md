## **org.utl.validador**

### **Descripción Detallada**

Este paquete Java, diseñado específicamente para aplicaciones JavaFX, ofrece una clase central, `ValidadorController`, que facilita la validación robusta de CURP y RFC mexicanos.

**Funcionalidades Clave:**

* **Validación Exhaustiva:**
  * **Patrones Estrictos:** Verifica que tanto el CURP como el RFC se ajusten a los patrones establecidos por el SAT.
  * **Coherencia de Datos:** Compara los primeros cuatro caracteres (nombre y apellido) y la fecha de nacimiento entre ambos identificadores para asegurar su consistencia.
* **Mensajes Informativos:**
  * **Errores Específicos:** Proporciona mensajes de error claros y concisos que indican el tipo de error encontrado (p. ej., formato inválido, fecha incorrecta, etc.).
* **Integración Sencilla:**
  * **JavaFX-Centric:** Se integra fácilmente en cualquier proyecto JavaFX a través de la vinculación de elementos FXML.

### **Uso Práctico**

1. **Incorporación al Proyecto:**
   * Añade la clase `ValidadorController` a tu estructura de proyecto JavaFX.
2. **Vinculación FXML:**
   * Conecta los campos de texto `txtCurp` y `txtRfc`, así como los elementos de texto para mostrar los resultados, a los elementos correspondientes en tu archivo FXML.
3. **Activación de la Validación:**
   * Utiliza los métodos `verificarCurp()`, `verificarRfc()` o `compararCampos()` para iniciar el proceso de validación.

### **Ejemplo Completo**

```java
// En tu controlador FXML:
@FXML
private TextField txtCurp, txtRfc;
@FXML
private Label lblResultado;

@FXML
private void validar() {
    String curp = txtCurp.getText();
    String rfc = txtRfc.getText();

    // Ejemplo de CURP y RFC válidos (ajusta según tus necesidades)
    String curpValido = "CURP123456ABCDEFGH0123";
    String rfcValido = "XAXX010101AAA0";

    // Validación y comparación
    boolean esValido = validadorController.compararCampos(curp, rfc, curpValido, rfcValido);

    if (esValido) {
        lblResultado.setText("CURP y RFC válidos y coincidentes.");
    } else {
        lblResultado.setText("Error en la validación. Verifica los datos ingresados.");
    }
}
