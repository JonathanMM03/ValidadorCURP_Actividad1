package org.utl.validador;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorController {

    @FXML
    private TextField txtCurp;
    @FXML
    private TextField txtRfc;
    @FXML
    private Text txtMensajeCurp, txtMensajeRfc;

    // Patrones CURP y RFC
    String curpPattern = "^[A-Z]{1}([AEIOU]){1}[A-Z]{2}(\\d{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]{1}\\d{1}$";
    String rfcPattern = "^([A-ZÑ&]{3,4})(\\d{2})(\\d{2})(\\d{2})[A-Z0-9]{3}$";

    @FXML
    void verificarCurp() {
        String curp = txtCurp.getText().toUpperCase().trim(); // Obtener CURP
        String rfc = txtRfc.getText().toUpperCase().trim();   // Obtener RFC

        System.out.println("CURP ingresada: " + curp);
        System.out.println("RFC ingresado: " + rfc);

        // Validar CURP y RFC
        boolean curpValida = validarCurp(curp);
        boolean rfcValido = validarRfc(rfc);

        if (curpValida && rfcValido) {
            boolean sonIguales = compararCurpRfc(curp, rfc);
            if (!sonIguales) {
                txtMensajeCurp.setText("La CURP y el RFC no coinciden.");
            } else {
                txtMensajeCurp.setText("CURP válida y coincide con el RFC.");
            }
        } else {
            // Revisar qué parte del CURP está mal
            if (!curpValida) {
                String mensajeErrorCurp = obtenerErroresCurp(curp);
                txtMensajeCurp.setText("CURP inválida: " + mensajeErrorCurp);
            }

            // Revisar qué parte del RFC está mal
            if (!rfcValido) {
                String mensajeErrorRfc = obtenerErroresRfc(rfc);
                txtMensajeRfc.setText("RFC inválido: " + mensajeErrorRfc);
            }
        }
    }

    @FXML
    void verificarRfc() {
        String curp = txtCurp.getText().toUpperCase().trim(); // Obtener CURP
        String rfc = txtRfc.getText().toUpperCase().trim();   // Obtener RFC

        System.out.println("CURP ingresada: " + curp);
        System.out.println("RFC ingresado: " + rfc);

        boolean curpValida = validarCurp(curp);
        boolean rfcValido = validarRfc(rfc);

        if (rfcValido) {
            if (!curpValida) {
                String mensajeErrorCurp = obtenerErroresCurp(curp);
                txtMensajeRfc.setText("CURP inválida, revisar: " + mensajeErrorCurp);
            } else {
                boolean sonIguales = compararCurpRfc(curp, rfc);
                if (!sonIguales) {
                    txtMensajeRfc.setText("El RFC y la CURP no coinciden.");
                } else {
                    txtMensajeRfc.setText("RFC válido y coincide con la CURP.");
                }
            }
        } else {
            String mensajeErrorRfc = obtenerErroresRfc(rfc);
            txtMensajeRfc.setText("RFC inválido: " + mensajeErrorRfc);
        }
    }

    boolean validarCurp(String curp) {
        return curp.matches(curpPattern);
    }

    boolean validarRfc(String rfc) {
        return rfc.matches(rfcPattern);
    }

    private boolean compararCurpRfc(String curp, String rfc) {
        // Comparar los primeros 4 caracteres (nombre y apellidos)
        String curpNombre = curp.substring(0, 4);
        String rfcNombre = rfc.substring(0, 4);

        // Comparar la fecha de nacimiento (6 dígitos: YYMMDD)
        String curpFecha = curp.substring(4, 10);
        String rfcFecha = rfc.substring(4, 10);

        return curpNombre.equals(rfcNombre) && curpFecha.equals(rfcFecha);
    }

    @FXML
    private void compararCampos(){
        verificarCurp();
        verificarRfc();
    }

    private String obtenerErroresCurp(String curp) {
        Pattern pattern = Pattern.compile(curpPattern);
        Matcher matcher = pattern.matcher(curp);
        if (!matcher.matches()) {
            if (curp.length() != 18) return "La longitud debe ser de 18 caracteres.";
            // Validar cada parte con grupos de captura
            String vocal = curp.substring(1, 2);
            if (!vocal.matches("[AEIOU]")) return "La segunda letra debe ser una vocal.";
            String fecha = curp.substring(4, 10);
            if (!fecha.matches("\\d{6}")) return "Fecha de nacimiento incorrecta.";
            String entidad = curp.substring(11, 13);
            if (!entidad.matches("(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"))
                return "Entidad federativa no válida.";
        }
        return "Revisar los caracteres.";
    }

    private String obtenerErroresRfc(String rfc) {
        Pattern pattern = Pattern.compile(rfcPattern);
        Matcher matcher = pattern.matcher(rfc);
        if (!matcher.matches()) {
            if (rfc.length() != 13) return "La longitud del RFC debe ser de 13 caracteres.";
            String nombre = rfc.substring(0, 4);
            if (!nombre.matches("[A-ZÑ&]{3,4}")) return "Las primeras letras deben ser de la empresa o persona.";
            String fecha = rfc.substring(4, 10);
            if (!fecha.matches("\\d{6}")) return "La fecha de nacimiento no es válida.";
        }
        return "Revisar los caracteres.";
    }
}