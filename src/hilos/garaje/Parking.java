/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos.garaje;

/**
 *
 * @author dam2
 */
public class Parking {
    
    private Integer[] plazas;

    public Parking(int cantidadCoches) {
        plazas = new Integer[cantidadCoches];
    }

    public synchronized void salir(int numCoches, int numCoche) {
        plazas[numCoches] = null;
        System.out.println("El coche: " + numCoche + " deja la plaza: " + numCoches);
        print_plazas();
    }

    public void print_plazas() {
        System.out.print("Parking: ");
        int libres = 0;
        for (Integer plaza : plazas) {
            if (plaza == null) {
                libres++;
            }
            System.out.print("[" + plaza + "] ");
        }
        System.out.println("\nPlazas libres: " + libres);
    }

    public synchronized Integer entrar(int numCoche) {

        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) {
                plazas[i] = numCoche;
                System.out.println("El coche: " + numCoche + " entra en la plaza: " + i);
                print_plazas();
                return i;
            }
        }

        return null;
    }
}
