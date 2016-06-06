/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancocastor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaCuenta implements Serializable{
    
    private ArrayList<Cuenta> lista;

    public ListaCuenta() {
        lista=new ArrayList<>();
    }
    public void grabar(Cuenta c){
        lista.add(c);
    }
    public int cantidad(){
        return lista.size();
    }
    public boolean existe (Cuenta c){
        return lista.contains(c);
    }
    public boolean existecodi (int num){
        Cuenta c=new Cuenta(num);
        return lista.contains(c);
    }
    public Cuenta obtenerElemento (int posicio){
        return lista.get(posicio);
    }
    public Cuenta obtenEleObj(Cuenta c){
        return lista.get(lista.indexOf(c));
    }

    public ArrayList<Cuenta> getLista() {
        return lista;
    }
    public void setLista(ArrayList<Cuenta> lista) {
        this.lista = lista;
    }
}