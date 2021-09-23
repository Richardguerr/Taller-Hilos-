package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivo {

    public boolean crearArchivoTextoSobreescribir(String nombreArchivo, String textoInterno, String extension){

        String ruta = "src/main/resources/persistencia/"+nombreArchivo+"."+extension;

        //Rutas Completas
        //"C:\Windows"
        //C:\Users\CamiloBD\eclipse-workspace\PrimerArchivo\Recursos

        File archivo = new File(ruta);
        boolean existe = false;
        BufferedWriter bw;


        try {
            if (archivo.exists()) {

                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(textoInterno+";Existente");
                existe=true;
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(textoInterno+";Nuevo");
                existe=false;

            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return existe;


    }

    public void agregarTextoArchivos(String nombreArchivo, String texto) {
        String ruta = "src/main/resources/persistencia"+nombreArchivo;
        File archivo = new File(ruta);


        try {
            FileWriter fstream = new FileWriter(archivo, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(texto+";\n");
            out.close();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public ArrayList<String> mostrarContenido(String nombre) {
        String ruta = "src/main/resources/persistencia/"+nombre;
        //String archivoTotal = "";
        ArrayList<String> restuladoArreglo= new ArrayList<String>();
        //String [] resultado = null;

        File archivo = new File(ruta);

        try {
            String cadena;

            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);

            while((cadena = b.readLine())!=null) {
                restuladoArreglo.add(cadena);
                //archivoTotal= archivoTotal+cadena;

            }

            //resultado= archivoTotal.split(";");



            b.close();



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return restuladoArreglo;


    }


}