//
package bancocastor;

import utilidades.EntrdaDatos;
import utilidades.Fichero;

/**
 *
 * @author jaume
 */
public class Menu {

    private Fichero miFichero;
    private ListaCuenta misCuentas;

    public Menu() {
        miFichero = new Fichero("cuentas.xml");
        misCuentas = (ListaCuenta) miFichero.leer();
        if (misCuentas == null) {
            misCuentas = new ListaCuenta();
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = (int) EntrdaDatos.demanarNumeroDec("Escoge una opcion: ", "", Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0);
            System.out.println();
            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    ingresarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    transferencia();
                    break;
                case 5:
                    listarCuentas();
                    break;
                case 6:
                    listarMisCuentas();
                    break;
                case 7:
                    saldoTotal();
                    break;
                case 8:
                    System.out.println("Ahorra mucho!");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 8);
    }

    //funcio saldo total banco
    private void saldoTotal() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            double total = 0;
            boolean existeix = false;
            String titular = EntrdaDatos.demanarCadena("nom titular: ", 1, 30);
            for (int i = 0; i < misCuentas.cantidad(); i++) {
                if (misCuentas.obtenerElemento(i).getTitular().equalsIgnoreCase(titular)) {;
                    existeix = true;
                    total += misCuentas.obtenerElemento(i).getSaldo();
                }
            }
            if (!existeix) {
                System.out.println("no hay ningun titular con el nombre: " + titular + "\n");
            }
            System.out.println("|------------------------------------------------|");
            System.out.printf("| el saldo total del banc es de: %9.2f euros |\n", total);
            System.out.println("|------------------------------------------------|");
        }
    }

    //funcio listar mis cuentas
    private void listarMisCuentas() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            boolean cabeceraImprimida=false;
            boolean existeix = false;
            String titular = EntrdaDatos.demanarCadena("nom titular: ", 1, 30);
            for (int i = 0; i < misCuentas.cantidad(); i++) {
                if (misCuentas.obtenerElemento(i).getTitular().equalsIgnoreCase(titular)) {;
                    existeix = true;
                    if (!cabeceraImprimida){
                        cabecera(false);
                        cabeceraImprimida=true;
                    }
                    System.out.println(misCuentas.obtenerElemento(i));
                }
            }
            if (!existeix) {
                System.out.println("\nno hay ningun titular con el nombre: " + titular);
            }
        }
    }

    //funcio transferencia
    private void transferencia() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            try {
                Cuenta aux = new Cuenta((int) EntrdaDatos.demanarNumeroDec("num de cuenta a retirar dinero: ", "", 1, 99999, 0));
                Cuenta inicial = misCuentas.obtenEleObj(aux);
                aux = new Cuenta((int) EntrdaDatos.demanarNumeroDec("num de cuenta a ingresar el dinero: ", "", 1, 99999, 0));
                Cuenta finl = misCuentas.obtenEleObj(aux);
                double cantidad = EntrdaDatos.demanarNumeroDec("cantidad a ingresar: ", "\ncantidad superior al saldo\n", 0, inicial.getSaldo(), 1);
                inicial.setSaldo(inicial.getSaldo() - cantidad);
                finl.setSaldo(finl.getSaldo() + cantidad);
                System.out.println("Dinero transferido");
                miFichero.grabar(misCuentas);
                
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("numero de cuenta incorreto");
            }
        }
    }

    //funcio retirar dinero
    private void retirarDinero() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            try {
                int num = (int) EntrdaDatos.demanarNumeroDec("retirar de la cuenta: ", "", 1, 99999, 0);
                Cuenta aux = new Cuenta(num);
                Cuenta actual = misCuentas.obtenEleObj(aux);
                double cantidad = (int) EntrdaDatos.demanarNumeroDec("cantidad a retirar: ", "\ncantidad superior al saldo\n", 0, actual.getSaldo() - actual.getComision(), 0);
                actual.setSaldo(actual.getSaldo() - cantidad);
                System.out.println("Reintegro realizado");
                miFichero.grabar(misCuentas);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Numero de cuenta incorrecto.");
            }
        }
    }

    //funcio ingresar dinero
    private void ingresarDinero() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            try {
                int num = (int) EntrdaDatos.demanarNumeroDec("hacer ingreso en la cuenta: ", "", 1, 99999, 0);
                Cuenta aux = new Cuenta(num);
                Cuenta actual = misCuentas.obtenEleObj(aux);
                double cantidad = (int) EntrdaDatos.demanarNumeroDec("Introduce la cantidad a ingresar: ", "", 0, 10000, 0);
                actual.setSaldo(actual.getSaldo() + cantidad);
                System.out.println("Dinero ingresado");
                miFichero.grabar(misCuentas);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Numero de cuenta incorrecto.");
            }
        }
    }

    //funcio llistar cuenta   
    private void listarCuentas() {
        if (misCuentas.cantidad() == 0) {
            System.out.println("no hi ha comptes en el banc");
        } else {
            cabecera(false);
            for (int i = 0; i < misCuentas.cantidad(); i++) {
                System.out.println(misCuentas.obtenerElemento(i));
            }
        }
    }

    //funcio imprimir cabecera
    public static boolean cabecera(boolean cabeceraImprimida) {
        if (!cabeceraImprimida) {
            System.out.println("\nCOD   TITULAR                        SALDO    COMI     PERSONAL");
            System.out.println("===============================================================");
        }
        return true;
    }

    //funcio crear cuenta
    private void crearCuenta() {

        int num = 0;
        boolean jaExisteix = false;
        do {
            jaExisteix = false;
            num = (int) EntrdaDatos.demanarNumeroDec("Introduce numero de cuenta: ", "", 1, 99999, 0);
            if (misCuentas.existecodi(num)) {
                System.out.println("la cuenta " + num + " ja existe\n");
                jaExisteix = true;
            }
        } while (jaExisteix);
        String titular = EntrdaDatos.mayuscules(EntrdaDatos.demanarCadena("Introduce el titular: ", 1, 30), 0);
        double saldo = EntrdaDatos.demanarNumeroDec("Introduce el saldo: ", "", 0, 100000, 1);
        String respuesta = "";
        boolean personal = false;
        do {
            respuesta = EntrdaDatos.demanarCadena("Es una cuenta personal (S/N)?: ", 1, 1);
            personal = respuesta.equalsIgnoreCase("S");
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
        Cuenta c = new Cuenta(num, titular, saldo, personal);
        misCuentas.grabar(c);
        miFichero.grabar(misCuentas);
        System.out.println("Cuenta dada de alta");
    }

    //funcio menu
    private static void mostrarMenu() {
        System.out.println("\nBIENVENIDO AL BANCO CASTOR");
        System.out.println("==========================");
        System.out.println("1. Alta cuenta");
        System.out.println("2. Ingresar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Hacer transferencia");
        System.out.println("5. Consultar datos cuentas");
        System.out.println("6. Consultar datos mis cuentas");
        System.out.println("7. Saldo total del banco");
        System.out.println("8. Salir\n");
    }
}
