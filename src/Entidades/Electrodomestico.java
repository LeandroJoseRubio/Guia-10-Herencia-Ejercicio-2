/*

Guia 10 Herencia Ejercicio 2

======================== Esta clase comienza aca y llega =======================
Crear una superclase llamada Electrodomestico con los siguientes atributos:
precio, color, consumo energético (letras entre A y F) y peso.
Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.

Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra
es correcta, sino es correcta usara la letra F por defecto. Este método se debe
invocar al crear el objeto y no será visible.
• Método comprobarColor(String color): comprueba que el color es correcto, y
si no lo es, usa el color blanco por defecto. Los colores disponibles para los
electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
está en mayúsculas o en minúsculas. Este método se invocará al crear el
objeto y no será visible.
Falta hacer ---> • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el
consumo. Al precio se le da un valor base de $1000.
Falta hacer ---> • Método precioFinal(): según el consumo energético y su tamaño, aumentará
el valor del precio. Esta es la lista de precios:

  LETRA PRECIO            PESO              PRECIO
    A    $1000            Entre 1 y 19 kg     $100
    B    $800             Entre 20 y 49 kg    $500
    C    $600             Entre 50 y 79 kg    $800
    D    $500             Mayor que 80 kg    $1000
    E    $300
    F    $100
==================== Hasta aca se realiza en esta clase ========================
A continuación se debe crear una subclase llamada Lavadora, con el atributo
carga, además de los atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de atributos heredados. Recuerda que
debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
si la carga es menor o igual, no se incrementará el precio. Este método debe
llamar al método padre y añadir el código necesario. Recuerda que las
condiciones que hemos visto en la clase Electrodomestico también deben
afectar al precio.
Se debe crear también una subclase llamada Televisor con los siguientes
atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de los
atributos heredados.
Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la
clase padre, lo utilizamos para llenar los atributos heredados del padre y
después llenamos los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
aumentará $500. Recuerda que las condiciones que hemos visto en la clase
Electrodomestico también deben afectar al precio.
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
para mostrar el precio final de los dos electrodomésticos.

 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Electrodomestico {

    Scanner Leer = new Scanner(System.in);

    // Crear una superclase llamada Electrodomestico con los siguientes atributos:
    //precio, color, consumo energético (letras entre A y F) y peso.
    protected Integer precio;
    protected String color;
    protected char consumoEnergetico;  // A, B, C, D, E, F
    protected Integer peso;

    //• Un constructor vacío.
    public Electrodomestico() {
    }

    //• Un constructor con todos los atributos pasados por parámetro.
    public Electrodomestico(Integer precio, String color, char consumoEnergetico, Integer peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
    }

    //• Métodos getters y setters de todos los atributos.
    public Integer getPrecio() {
        return precio;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    //• Método comprobarConsumoEnergetico(char letra): comprueba que la letra
    //es correcta, sino es correcta usara la letra F por defecto. Este método se debe
    //invocar al crear el objeto y no será visible.
    public char comprobarConsumoEnergetico(char letra) {
        //Es llamado desde crearElectrodomestico() de esta misma clase.
        char Letra = 'F'; // OJO que los tipos de datos char van con '' y no con "" 
        char[] charSearch = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 0; i < charSearch.length; i++) {
            if (charSearch[i] == letra) {
                Letra = letra;
            }
        }
        return Letra;
    }

    //• Método comprobarColor(String color): comprueba que el color es correcto, y
    //si no lo es, usa el color blanco por defecto. Los colores disponibles para los
    //electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
    //está en mayúsculas o en minúsculas. Este método se invocará al crear el
    //objeto y no será visible.
    public void comprobarColor(String color) {
        //Es llamado desde crearElectrodomestico() de esta misma clase.
        ArrayList<String> coloresDisponibles = new ArrayList();
        coloresDisponibles.add("blanco");
        coloresDisponibles.add("negro");
        coloresDisponibles.add("rojo");
        coloresDisponibles.add("azul");
        coloresDisponibles.add("gris");
        for (String colorDisponible : coloresDisponibles) {
            if (color.equalsIgnoreCase(colorDisponible)) {
            } else {
                color = "Blanco";
            }
        }
    }

    //• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
    //electrodoméstico, también llama los métodos para comprobar el color y el
    //consumo. Al precio se le da un valor base de $1000.
    public void crearElectrodomestico() {
        //Es llamado desde crearLavadora() de clase Lavadora.
        //Y tambien desde crearTelevisor() de clase Televisor.
        System.out.println("====================================================");
        System.out.println("¿Cual es el precio base del electrodomestico?");
        precio = Leer.nextInt();
        System.out.println("Colores disponibles para los electrodomesticos:");
        System.out.println("blanco, negro, rojo, azul, o gris.");
        System.out.println("¿De que color es? ");
        color = Leer.next().toLowerCase();
        comprobarColor(color);
        System.out.println("Tabla consumo energetico: A, B, C, D, E, F");
        System.out.println("¿Cual es el consumo energetico?");
        consumoEnergetico = Leer.next().toUpperCase().charAt(0);  // El error estaba aca. Me faltaba concatenar el .toUpperCase
        consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        System.out.println("¿Cual es el peso del electrodomestico?");
        peso = Leer.nextInt();
        precioFinalElectrodomestico();
    }

    //• Método precioFinal(): según el consumo energético y su tamaño, aumentará
    //el valor del precio. Esta es la lista de precios:
    //
    //  LETRA PRECIO            PESO              PRECIO
    //    A    $1000            Entre 1 y 19 kg     $100
    //    B    $800             Entre 20 y 49 kg    $500
    //    C    $600             Entre 50 y 79 kg    $800
    //    D    $500             Mayor que 80 kg    $1000
    //    E    $300
    //    F    $100
    public void precioFinalElectrodomestico() {
        //Es llamado desde crearElectrodomestico() de esta misma clase.
        switch (consumoEnergetico) {
            case 'A':
                precio += 1000;
                break;
            case 'B':
                precio += 800;
                break;
            case 'C':
                precio += 600;
                break;
            case 'D':
                precio += 500;
                break;
            case 'E':
                precio += 300;
                break;
            case 'F':
                precio += 100;
                break;
        }
        if (peso >= 1 && peso <= 19) {
            precio += 100;
        }
        if (peso >= 20 && peso <= 49) {
            precio += 500;
        }
        if (peso >= 50 && peso <= 79) {
            precio += 800;
        }
        if (peso >= 80) {
            precio += 1000;
        }
    }
}
