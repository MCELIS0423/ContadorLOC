/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ase.procesador;

import edu.uniandes.ecos.ase.ArchivoDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author mariocelis
 * @since 16/02/2016
 * @description Clase para procesar directorios y archivos
 */
public class ProcesarArchivo extends JPanel {

    /**
     * Constructor de la clase
     */
    public ProcesarArchivo() {

    }

    /**
     * <!-- Method --!> 
     * @author Mario Celis
     * @since 16/02/2016
     * @throws IOException
     * @description Metodo utilizado para abrir una ventana exploradora y
     * seleccionar un directorio
     */
    public Long seleccionarDirectorio() throws IOException {
        long totalLineas = 0;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            totalLineas = explorarDirectorio(selectedFile);
        }
        return totalLineas;
    }

    /**
     * <!-- Method --!> 
     * @author Mario Celis
     * @since 16/02/2016
     * @param directorio
     * @return numero total de líneas
     * @throws IOException
     * @throws FileNotFoundException
     * @description Metodo utilizado abrir un directorio y validar si existen
     * mas subdirectorios o clases java seleccionar un directorio
     */
    public Long explorarDirectorio(File directorio) throws FileNotFoundException, IOException {
        String nombreArchivo;
        long tamanioTotalPrograma = 0;
        File[] ficheros = directorio.listFiles();
        List<ArchivoDTO> listaArchivo = new ArrayList<ArchivoDTO>();
        for (int x = 0; x < ficheros.length; x++) {
            nombreArchivo = ficheros[x].getName();
            //System.out.println(nombreArchivo);
            if (ficheros[x].isFile()) {
                if (nombreArchivo.endsWith(".java")) {
                    String rutaArchivo = directorio.getPath() + "/" + nombreArchivo;
                    ArchivoDTO archivoDTO = new ArchivoDTO();
                    archivoDTO = contarLineas(rutaArchivo, nombreArchivo);
                    listaArchivo.add(archivoDTO);
                    tamanioTotalPrograma = tamanioTotalPrograma+archivoDTO.getNumeroTotalLineas();
                }
            } else {
                explorarDirectorio(ficheros[x]);
            }
        }
        Reporte reporte = new Reporte();
        reporte.dibujarReporteConteo(listaArchivo);
        return tamanioTotalPrograma;
    }

    /**
     * <!-- Method --!> 
     * @author Mario Celis
     * @since 16/02/2016
     * @param rutaArchivo
     * @param nombreArchivo 
     * @return Clase POJO con las propiedades del archivo
     * @throws IOException
     * @throws FileNotFoundException
     * @description Metodo utilizado para contar líneas de codigo java
     */
    public ArchivoDTO contarLineas(String rutaArchivo, String nombreArchivo) throws FileNotFoundException, IOException {
        String lineaArchivo;
        long numeroLineas = 0;
        long numeroMetodos = 0;
        FileReader archivoLeer = new FileReader(rutaArchivo);
        BufferedReader bufferArchivo = new BufferedReader(archivoLeer);
        ArchivoDTO archivoDTO = new ArchivoDTO();
        archivoDTO.setNombre(nombreArchivo);
        archivoDTO.setRutaArchivo(rutaArchivo);
        while ((lineaArchivo = bufferArchivo.readLine()) != null) {
            if(lineaArchivo.contains("<!-- Method --!>")){
                numeroMetodos++;
            }
            numeroLineas++;
        }
        archivoDTO.setNumeroTotalLineas(numeroLineas);
        archivoDTO.setNumeroTotalMetodos(numeroMetodos);
        return archivoDTO;
    }

}