package labo2;
import net.sf.json.*;
import java.io.FileWriter;
/**
 *
 * @author alex
 */
public class DocumentJson {
    private JSONArray json;

    public DocumentJson(String contenuJson){
        json = JSONArray.fromObject(contenuJson);
    }

    public String lireLaCle(int position,String cle){
        return json.getJSONObject(position).getString(cle);
    }

    private JSONObject obtenirObject(int position){
        return json.getJSONObject(position);
    }

    private String afficherMessage(int position){
       return obtenirObject(position).getJSONObject("commit").getString("message");
    }

    public JSONObject nouvelObjetJson(){
        JSONObject objetJson = new JSONObject();
        for(int i = 0;i<json.size();i++){
            objetJson.put(i, afficherMessage(i));
        }
        return objetJson;
    }

    public static void ecrireFichier(JSONObject objetJson){
        try{
            FileWriter writer = new FileWriter("fichierJSON.json");
            writer.write(objetJson.toString());
            writer.close();
        }catch(Exception e){
            System.out.println("Une erreur est survenu lors de l'écriture du fichier.");
        }
    }
}
