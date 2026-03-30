package biblioteca;

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


}


