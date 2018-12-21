package my.app.shroudyism.pvst;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.NumberFormat;

public class DownloadTask extends AsyncTask {

    String subt="";
    String subp="";

    @Override
    protected Object doInBackground(Object[] objects) {


        URL url= null;
        try {
            url = new URL("https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UC-lHJZR3Gqxm24_Vd_AJ5Yw&key=AIzaSyDSv_csliI1_LDdlUYR3RKGOVQwFXAx3mE");

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            InputStream inputStream=connection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            connection.setRequestMethod("GET");
            connection.connect();

            String data="";

            String line="";

            while(line != null){
                line=br.readLine();
                data+=line;

            }

            JSONObject JO1=new JSONObject(data);
            JSONArray JA= (JSONArray) JO1.get("items");
            JSONObject f= (JSONObject) JA.get(0);
            JSONObject stat=(JSONObject)f.get("statistics");


            subp = (String) stat.get("subscriberCount");


            connection.disconnect();


            url = new URL("https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UCq-Fj5jknLsUf-MWSy4_brA&key=AIzaSyDSv_csliI1_LDdlUYR3RKGOVQwFXAx3mE");

            connection =
                    (HttpURLConnection) url.openConnection();

            inputStream=connection.getInputStream();

            br = new BufferedReader(new InputStreamReader(inputStream));

            connection.setRequestMethod("GET");
            connection.connect();

            data="";

            line="";

            while(line != null){
                line=br.readLine();
                data+=line;

            }



            JO1=new JSONObject(data);
            JA= (JSONArray) JO1.get("items");
            f= (JSONObject) JA.get(0);
            stat=(JSONObject)f.get("statistics");


            subt = (String) stat.get("subscriberCount");


            connection.disconnect();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

        MainActivity.tvSubT.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(subt)));
        MainActivity.tvSubP.setText(NumberFormat.getIntegerInstance().format(Integer.parseInt(subp)));




    }
}
