package class12HW;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;



public class MyAPI {


        public static void main(String[] args) throws IOException, JSONException {

            System.out.println("Please enter a country name");
            Scanner userCountry = new Scanner(System.in);
            String countryName = userCountry.next();

            // use OKHttp client to create the connection and retrieve data
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://restcountries.eu/rest/v2/name/" + countryName)
                    .build();
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();

            // parse JSON
            JSONArray mainJsonArray = new JSONArray(jsonData);
            JSONObject mainObj = (JSONObject) mainJsonArray.get(0);
            String region =  mainObj.getString("region");
            JSONArray callingCodes = mainObj.getJSONArray("callingCodes");
            JSONArray borders = mainObj.getJSONArray("borders");
            JSONArray currencies = (JSONArray) mainObj.getJSONArray("currencies").get(0);
            String symbol = currencies.getString(Integer.parseInt("symbol"));


            System.out.println("region " +region);
            System.out.println("callingCodes " + callingCodes);
            System.out.println("borders " + borders);
            System.out.println("symbol" + symbol);
        }

}
