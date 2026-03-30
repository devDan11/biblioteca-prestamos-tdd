package biblioteca;

import java.time.LocalDate;

public class PrestamoService {

    public String validarCodigoPrestamo(String codigo) {
        // Validación: 6 caracteres, 2 letras mayúsculas + 4 números
        if (codigo == null || codigo.length() != 6) {
            return "Ingrese un código de préstamo válido";
        }

        String letras = codigo.substring(0, 2);
        String numeros = codigo.substring(2);

        if (!letras.matches("[A-Z]{2}") || !numeros.matches("\\d{4}")) {
            return "Ingrese un código de préstamo válido";
        }

        return "OK";
    }



    public String validarCodigoLibro(String codigo) {
        if (codigo == null || codigo.length() != 5 || !codigo.matches("[A-Za-z0-9]{5}")) {
            return "Ingrese un código de libro válido";
        }
        return "OK";
    }


    public String validarNombreUsuario(String nombre) {
        if (nombre == null || nombre.length() < 4 || !nombre.matches("[a-zA-Z]+")) {
            return "El nombre del usuario debe tener al menos cuatro caracteres alfabéticos";
        }
        return "OK";
    }




    public String validarFechaPrestamo(LocalDate fecha) {
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            return "Ingrese una fecha de préstamo válida";
        }
        return "OK";
    }





}


