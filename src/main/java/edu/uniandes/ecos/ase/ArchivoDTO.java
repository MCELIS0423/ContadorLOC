/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase;

/**
 *
 * @author mariocelis
 */
public class ArchivoDTO {
    
    private String nombre;
    private String rutaArchivo;
    private Long numeroTotalLineas;
    private Long numeroTotalMetodos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Long getNumeroTotalLineas() {
        return numeroTotalLineas;
    }

    public void setNumeroTotalLineas(Long numeroTotalLineas) {
        this.numeroTotalLineas = numeroTotalLineas;
    }

    public Long getNumeroTotalMetodos() {
        return numeroTotalMetodos;
    }

    public void setNumeroTotalMetodos(Long numeroTotalMetodos) {
        this.numeroTotalMetodos = numeroTotalMetodos;
    }
    
}