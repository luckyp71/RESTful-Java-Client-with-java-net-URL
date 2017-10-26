package id.co.test.client_app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

public class NetClientGet {

    public static void main(String[] args) {

        try {
            /*
                Uncomment one of the url below to show the output of each service's method     
             */

            URL url = new URL("http://localhost:8080/JAX-RS_Restful_Web_Service/restful/service/getAllPersonJSON");
//            URL url = new URL("http://localhost:8080/JAX-RS_Restful_Web_Service/restful/service/getAllPersonXML");
//            URL url = new URL("http://localhost:8080/JAX-RS_Restful_Web_Service/restful/service/getPersonByIdXML/1");
//            URL url = new URL("http://localhost:8080/JAX-RS_Restful_Web_Service/restful/service/getPersonByIdJSON/1");
           
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
          
            //According to url you chose above, you must choose one of the request properties below
            conn.setRequestProperty("Accept", "application/json");
//            conn.setRequestProperty("Accept", "application/xml");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                System.out.println("Output from server...");
                System.out.println(output);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
