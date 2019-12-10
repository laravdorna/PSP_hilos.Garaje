/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.garaje;

/**
 *
 * @author lara vaquez dorna
 */
public class HilosGaraje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           int nro_plazas = 5;
        int nro_coches = 10;
        Parking parking = new Parking(nro_plazas);
        for (int i = 0; i < nro_coches; i++) {
            Thread t = new Thread(new Coche(parking, i));
            t.start();
        }
    }
    
}
