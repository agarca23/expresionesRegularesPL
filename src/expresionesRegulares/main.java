package expresionesRegulares;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
    		System.out.println("Elige una opción.");
    		System.out.println("1. Validar DNI o NIE.");
    		System.out.println("2. Validar número real.");
    		System.out.println("3. Validar dominio.");
    		System.out.println("4. Validar correo electronico.");
    		System.out.println("5. Validar nombre de variable o función.");
    		System.out.println("6. Salir.");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
    			Scanner entrada=new Scanner(System.in);
                switch (opcion) {
        		case 1:
        			System.out.println("Introduce un DNI o NIE.");
        			System.out.println(validarIdentidicacion(entrada.nextLine()));
        			break;
        		case 2:
        			System.out.println("Introduce un número real.");
        			System.out.println(validarNumeroReal(entrada.nextLine()));
        			break;
        		case 3:
        			System.out.println("Introduce un dominio.");
        			System.out.println(validarDominio(entrada.nextLine()));
        			break;
        		case 4:
        			System.out.println("Introduce un correo electónico.");
        			System.out.println(validarCorreo(entrada.nextLine()));
        			break;
        		case 5:
        			System.out.println("Introduce el nombre de una variable o de una función.");
        			System.out.println(validarVarFunc(entrada.nextLine()));
        			break;
        		case 6:
        			salir=true;
        			break;
                default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

	}

	private static boolean validarVarFunc(String info) {
		// TODO Auto-generated method stub
		String patron="^[_a-zA-Z]+[a-zA-Z0-9_]*";
		
		return Pattern.matches(patron, info);
	}

	public static boolean validarIdentidicacion(String info) {

		String patron = "\\d{8}[A-HJ-NP-TV-Z]|^[XYZ]\\d{7}[TRWAGMYFPDXBNJZSQVHLCKET]";
		
		return Pattern.matches(patron, info);
	}

	public static boolean validarNumeroReal(String info) {

		String patron = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";

		return Pattern.matches(patron, info);
	}

	public static boolean validarDominio(String info) {
		String patron = "([a-z0-9-]*?\\.?)+\\.[a-z]{2,}";

		return Pattern.matches(patron, info);

	}

	public static boolean validarCorreo(String info) {

		String patron = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		return Pattern.matches(patron, info);

	}

}
