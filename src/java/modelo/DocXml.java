/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luify
 */
import java.io.File;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


public class DocXml {
    /**
     * @param args
     */
    public DocXml(String numeroOrden, String status) {
             
        //objeto a parsear a XML
          
        //Creo una factoria a la que pedir objetos builder
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document dom = db.newDocument();
       
        Element elemento_raiz = dom.createElement("Orden");
        dom.appendChild(elemento_raiz);
       
        
        Element identificacion_elemento = dom.createElement("Numero_Identificacion");//creo el nodo de elemento
        Text id_contenido = dom.createTextNode(numeroOrden); //creo el nodo de texto 
        identificacion_elemento.appendChild(id_contenido);//meto el nodo de texto dentro del nodo elemento
        elemento_raiz.appendChild(identificacion_elemento); //lo meto en el bloque principal
       
        Element fecha_elemento = dom.createElement("fecha_lectura");
        java.util.Date date = new java.util.Date();        
        Text fecha_contenido = dom.createTextNode(date.toString()); 
        fecha_elemento.appendChild(fecha_contenido);
        elemento_raiz.appendChild(fecha_elemento); 

  
        Element status_elemento = dom.createElement("status_orden");
        Text status_contenido = dom.createTextNode(status); 
        status_elemento.appendChild(status_contenido);
        elemento_raiz.appendChild(status_elemento); 
               
        //Exportar
        File archivo_orden_xml = new File("C:/Users/vit/Desktop/Desarrollo/preordenActualizada.xml");
       
        //Especifico formato
        OutputFormat format = new OutputFormat(dom);
        format.setIndenting(true);
       
        //Escribo en el archivo
        XMLSerializer serializer = new XMLSerializer(new FileOutputStream(archivo_orden_xml), format);

        serializer.serialize(dom);
       
       
        }catch(Exception e) {
            //dump it
            System.out.println("Ocurrio un error " + e.getMessage());
            System.exit(1);
        }
       
    }

}


