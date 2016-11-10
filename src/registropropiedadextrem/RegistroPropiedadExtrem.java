/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registropropiedadextrem;

import java.util.ArrayList;

/**
 *
 * @author Dani-L
 */
public class RegistroPropiedadExtrem {
    public static ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
    
    //Rellenamos primero los inmuebles urbanos, y después los rústicos.
    public static void rellenarDatos(){
        for (int i=0; i < 100; i++){
            Urbano u = new Urbano();
            u.setNum_registro((i+1));
            u.setSuperficie((int) (Math.random()*500));
            u.setDireccion("Direccion "+(i+1));
            Propietario p = new Propietario();
            p.setNombre("Propietario "+(i+1));
            p.setMovil((int) (Math.random()*50000));
            p.setEmail("Email "+(i+1));
            u.setPropietario(p);
            inmuebles.add(u);
        }
        for (int i=0; i < 100; i++){
            Rustico r = new Rustico();
            r.setNum_registro((i+1));
            r.setSuperficie((int) (Math.random()*1000));
            r.setCultivo("Cultivo "+(i+1));
            Propietario p = new Propietario();
            p.setNombre("Propietario "+(i+1));
            p.setMovil((int) (Math.random()*50000));
            p.setEmail("Email "+(i+1));
            r.setPropietario(p);
            r.setPropietario(p);
            inmuebles.add(r);
        }
    }
    /*Lo podemos hacer con un solo for, y además r y u se pueden sustituir
    por una sola variable Inmueble in, luego ya hacemos in = new Rustica y
    in = new Urbana (Como Inmueble tiene esos hijos, nos deja.*/
//----------------------------------------------------------------------------------------------------    
    //Recibe una posición y borra el inmueble de esa posición.
    public static void borrarInmueblePos(int pos){
        inmuebles.remove(pos);
    }
//----------------------------------------------------------------------------------------------------    
    //Recibe un número de registro, y borra el inmueble correspondiente a ese nº de registro.
    public static void borrarInmuebleDir(int numreg){
        for (int i=0; i < inmuebles.size(); i++){
            if (inmuebles.get(i).getNum_registro()==numreg){
                inmuebles.remove(i);
            }
        }
    }
//----------------------------------------------------------------------------------------------------    
    /*Recibe el vector de inmuebles, y dos posiciones, suma las dos supercicies en 
    el primer inmueble y borra el segundo.*/
    public static void unirInmueble(ArrayList<Inmueble> vector, int pos1, int pos2){
        if (vector.get(pos1).getClass() == vector.get(pos2).getClass()){
            vector.get(pos1).setSuperficie(vector.get(pos1).getSuperficie()+vector.get(pos2).getSuperficie());
            vector.remove(pos2);
        }
        else {
            System.out.println("Inmuebles de distinto tipo");
        }
    }
//----------------------------------------------------------------------------------------------------
    //Recibe dos inmuebles, suma las superficies en el primero y borra el segundo.
    public static void unirInmueble(Inmueble inmu1, Inmueble inmu2){
        if (inmu1.getClass() == inmu2.getClass()){
            inmu1.setSuperficie(inmu1.getSuperficie()+inmu2.getSuperficie());
            inmuebles.remove(inmu2);
        }
        else {
            System.out.println("Inmuebles de distinto tipo");
        }
    }
//----------------------------------------------------------------------------------------------------
    /*Recibe un inmueble, un nuevo propietario y el porcentaje del inmueble que
    se queda el nuevo propietario. La función crea otro inmueble a nombre del
    nuevo propietario y divide las superficies de ambos inmuebles según el 
    porcentaje.*/
    public static void dividirInmueble(Inmueble inmu, int porcen, Propietario prop){
        Inmueble divinmu = new Inmueble();
        divinmu.setPropietario(prop);
        divinmu.setNum_registro((int) (Math.random()*500));
        divinmu.setSuperficie((inmu.getSuperficie())*(porcen/100));
        inmu.setSuperficie((inmu.getSuperficie())*(1-porcen/100));
        inmuebles.add(divinmu);
    }
//----------------------------------------------------------------------------------------------------
    //Muestra todos los inmuebles.
    public static void mostrarInmuebles(){
        for (int i=0; i < inmuebles.size(); i++){
            if (inmuebles.get(i) instanceof Urbano){
                System.out.println("TIPO URBANO");
                System.out.println(inmuebles.get(i).getPropietario().getNombre());
                System.out.println("Nº Registro: "+inmuebles.get(i).getNum_registro());
                System.out.println("Superficie: "+inmuebles.get(i).getSuperficie());
                System.out.println("Dirección: "+((Urbano)inmuebles.get(i)).getDireccion());
            }
            else {
                System.out.println("TIPO RÚSTICO");
                System.out.println(inmuebles.get(i).getPropietario().getNombre());
                System.out.println("NºRegistro: "+inmuebles.get(i).getNum_registro());
                System.out.println("Superficie: "+inmuebles.get(i).getSuperficie());
                System.out.println("Cultivo: "+((Rustico)inmuebles.get(i)).getCultivo());
            }
        }
    }
//----------------------------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        rellenarDatos();
        borrarInmueblePos(66);
        borrarInmuebleDir(18);
        unirInmueble(inmuebles, 20, 26);
        unirInmueble(inmuebles.get(88), inmuebles.get(92));
        
        Propietario p = new Propietario();
        p.setNombre("Propietario Nuevo");
        p.setMovil((int) (Math.random()*50000));
        p.setEmail("Email Prop. Nuevo");
        dividirInmueble(inmuebles.get(66), 55, p);
        mostrarInmuebles();
    }
    
}
