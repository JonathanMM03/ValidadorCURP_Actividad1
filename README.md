## **org.utl.validador**

### **Descripción Detallada**

Este paquete Java, diseñado específicamente para aplicaciones JavaFX, ofrece una clase central, `ValidadorController`, que facilita la validación robusta de CURP y RFC mexicanos.

**Carlos Gabriel Valdivia López**
**Miguel Angel Rodriguez Padilla**
**Jonathan Moreno Muñoz**

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
