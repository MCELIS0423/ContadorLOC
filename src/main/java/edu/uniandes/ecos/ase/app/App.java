package edu.uniandes.ecos.ase.app;

import edu.uniandes.ecos.ase.procesador.ProcesarArchivo;
import edu.uniandes.ecos.ase.procesador.Reporte;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        long totalLineas = 0;
        ProcesarArchivo procesarArchivo = new ProcesarArchivo();
        try {
            totalLineas = procesarArchivo.seleccionarDirectorio();
            System.out.println("Tamaño del programa: "+totalLineas);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
