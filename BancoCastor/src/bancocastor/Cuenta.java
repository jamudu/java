//

package bancocastor;

import java.io.Serializable;
import utilidades.EntrdaDatos;

/**
 *
 * @author mfontana
 */
public class Cuenta implements Serializable{
    
    private int numero;
    private String titular;
    private double saldo;
    private double comision;
    private boolean personal;

    public Cuenta(int numero, String titular, double saldo, boolean personal) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.personal = personal;
        if (personal) {
            comision = 0.05;
        } else {
            comision = 0.02;
        }
    }

    public Cuenta() {
    }
    
    public Cuenta(int numero) {
        this.numero = numero;
    }
  
    @Override
    public String toString() {
        String llistat=String.format("%1$-6s",numero);
        llistat+=String.format("%1$-31s",EntrdaDatos.mayuscules(titular,0));
        llistat+=String.format("%1$-9s",Double.toString(saldo));
        llistat+=String.format("%1$-7s",Double.toString(comision));
        llistat+="    ";
        if (personal == true) {
            llistat+="SI";
        }else{
            llistat+="NO";
        }
        return llistat;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }
    
    public boolean isPersonal() {
        return personal;
    }
    public void setPersonal(boolean personal) {
        this.personal = personal;
    }

    public double getComision() {
        return comision;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
}