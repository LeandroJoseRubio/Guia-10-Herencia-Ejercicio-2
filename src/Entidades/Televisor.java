/*

Guia 10 Herencia Ejercicio 2

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
======================== Esta clase comienza aca y llega =======================
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
==================== Hasta aca se realiza en esta clase ========================
Finalmente, en el main debemos realizar lo siguiente:
Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
para mostrar el precio final de los dos electrodomésticos.

 */
package Entidades;

import java.util.Locale;
import java.util.Scanner;

public class Televisor extends Electrodomestico {

    Scanner Leer = new Scanner(System.in);

    protected Integer resolucion;
    protected boolean sintonizadorTDT;

    //• Un constructor vacío.
    public Televisor() {
    }

    //• Un constructor con la resolución, sintonizador TDT y el resto de atributos
    //heredados. Recuerda que debes llamar al constructor de la clase padre.
    public Televisor(Integer resolucion, boolean sintonizadorTDT, Integer precio, String color, char consumoEnergetico, Integer peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //• Método get y set de los atributos resolución y sintonizador TDT.
    public Integer getResolucion() {
        return resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //• Método crearTelevisor(): este método llama a crearElectrodomestico() de la
    //clase padre, lo utilizamos para llenar los atributos heredados del padre y
    //después llenamos los atributos del televisor.
    public void crearTelevisor() {
        crearElectrodomestico();
        System.out.println("¿De cuantas pulgadas es el televisor?");
        resolucion = Leer.nextInt();
        boolean valid = false;
        do {
            System.out.println("¿Tiene sintonizador TDT? Si, No");
            String SoN = Leer.next().toLowerCase();
            if (SoN.equals("si")) {
                sintonizadorTDT = true;
                valid = true;
            }
            if (SoN.equals("no")) {
                sintonizadorTDT = false;
                valid = true;
            }
        } while (false);
        precioFinalTelevisor();
        System.out.println("====================================================");
    }

    //• Método precioFinal(): este método será heredado y se le sumará la siguiente
    //funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
    //incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
    //aumentará $500. Recuerda que las condiciones que hemos visto en la clase
    //Electrodomestico también deben afectar al precio.
    public void precioFinalTelevisor() {
        //Es llamado desde crearTelevisor() de esta misma clase.
        if (resolucion > 40) {
            precio += ((precio / 100) * 30);
        }
        if (sintonizadorTDT == true) {
            precio += 500;
        }
    }

}
