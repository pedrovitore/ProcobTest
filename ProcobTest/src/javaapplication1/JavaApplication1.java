package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author anderson
 */
public class JavaApplication1 {

    public static final String HOST = "https://api.procob.com";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String path = "/consultas/teste";
        
        URL obj = new URL(HOST + path);
        
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        // Usuário: sandbox@procob.com | Senha: TesteApi | Codificação: https://www.base64encode.org/ (usuario:senha)
        con.setRequestProperty("Authorization", "Basic c2FuZGJveEBwcm9jb2IuY29tOlRlc3RlQXBp");
      
//        BufferedReader in = new BufferedReader(
//		        new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuilder response = new StringBuilder();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		System.out.println(response.toString());
		
		// Create JsonReader from Json.
        JsonReader reader = Json.createReader(con.getInputStream());
        // Get the JsonObject structure from JsonReader.
        JsonObject veiculo = reader.readObject();
        reader.close();
        
        System.out.println("code: " + veiculo.getString("code"));
        System.out.println("message: " + veiculo.getString("message"));
        // read inner json element
        //JsonObject addrObj = veiculo.getJsonObject("address");
        
//        // read string data
//        System.out.println("code: " + empObj.getString("code"));
//        // read integer data
//        System.out.println("Emp Id: " + empObj.getInt("emp_id"));
//        // read inner json element
//        JsonObject addrObj = empObj.getJsonObject("address");
//        System.out.println("City: " + addrObj.getString("city"));
    }
}