package de.buw.fm4se.satsolving.utils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
import java.util.regex.*;

public class FmPlay {
    public static void main(String[] args) {
        String plink = "https://play.formal-methods.net/?check=SAT&p=example-1";
        System.out.println(getcode(plink));
    }

    public static String getcode(String plink) {
      String[] parts = plink.split("\\?");
      String apiurl = parts[0]+"api/permalink/?"+parts[1];
        try {
            // Create URL object
            URL url = new URL(apiurl);

            // Open a connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Set the request method
            con.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(content.toString());
            String codeContent = jsonResponse.getString("code");
            return codeContent;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    public static String removeComments(String formula){
        formula = formula.replaceAll("\"", "");
        String regexPattern = "(%.*|\\/\\/\\/.+|\\n)";
        Pattern pattern = Pattern.compile(regexPattern, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(formula);
        String result = matcher.replaceAll("");
        return result;
    }
}
