package labo2;

import java.net.URL;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
/**
 *
 * @author alex
 */
public class Labo2 {

    public static String lireUrl(String url){
       String resultat = "";
           try{
               InputStream stream = new URL(url).openStream();
               resultat = IOUtils.toString(stream,"UTF-8");
           }catch(Exception e){
               System.out.println("Une erreur est survenu, url invalide.");
           }
           return resultat;
    }

    public static void main(String[] args) {
        String url = "https://api.github.com/repos/alexcp/inf2015/commits";
        DocumentJson json = new DocumentJson(lireUrl(url));
        json.afficherMessage();
    }
}
