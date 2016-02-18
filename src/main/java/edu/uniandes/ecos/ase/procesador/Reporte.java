/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.procesador;

import edu.uniandes.ecos.ase.ArchivoDTO;
import java.util.List;

/**
 *
 * @author mariocelis
 */
public class Reporte {

    /**
     * Constructor de la clase
     */
    public Reporte() {

    }

    /**
     * <!-- Method --!> 
     * @author Mario Celis
     * @since 16/02/2016
     * @param listaArchivo
     * @description Metodo utilizado para dar el reporte de conteo de líneas y
     * métodos
     */
    public void dibujarReporteConteo(List<ArchivoDTO> listaArchivo) {
        for (ArchivoDTO archivoDTO : listaArchivo) {
            System.out.println("|Nombre: " + archivoDTO.getNombre() + " |# Líneas: " + archivoDTO.getNumeroTotalLineas() + " |# Métodos: " + archivoDTO.getNumeroTotalMetodos());
            //System.out.println("Tamaño total del sistema: "+tamanioTotalPrograma);
        }
    }

}
