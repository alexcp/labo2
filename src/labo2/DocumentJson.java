package labo2;
import net.sf.json.*;
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

    public void afficherMessage(){
        for(int i = 0;i<json.size();i++){
            System.out.println(obtenirObject(i).getJSONObject("commit").getString("message"));
        }
    }

}
