import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RestAPITest {
    public static void main(String[] args) throws IOException, JSONException {
        // use OKHttp client to create the connection and retrieve data
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.exchangeratesapi.io/v1/latest?access_key=2f962e5ab4ad938cf9337dd4594222c9&symbols=USD,ILS")
                .build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        // parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        // get Json object
        JSONObject resultsJson = mainJsonObject.getJSONObject("rates");
        // get value
        double val = resultsJson.getDouble("ILS");
        System.out.println(val);
    }
}