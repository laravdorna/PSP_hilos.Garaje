/*
 * 
 */
package hilos.garaje;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lara vazquez
 */
public class Coche implements Runnable {

    Parking parking;
    int nCoche;

      public Coche(Parking parking, int numCoche) {
        super();
        this.parking = parking;
        this.nCoche = numCoche;
    }
    @Override
    public void run() {
        boolean aparcado = false;
        int plaza = -1;
        while (true) {
            if (aparcado) {
                try {
                    //Dormimos el hilo como mucho 3 segundos
                    Thread.sleep((long) (Math.random() * 3_000));
                    parking.salir(plaza, nCoche);
                    aparcado = false;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.sleep((long) (Math.random() * 3_000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
                }
                Integer resultado = parking.entrar(nCoche);
                if (resultado != null) {
                    plaza = resultado;
                    aparcado = true;
                }
            }
        }
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
