package com.mycompany.itemcalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.util.List;
import org.json.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class BazaarStats {
    private Iterator<Product> iterator;
    private List<Product> productList;

    public BazaarStats() throws FileNotFoundException, IOException, ConnectException {
        /*
        DOWNLOAD THE FILE
        */
        String urlString = "https://api.hypixel.net/skyblock/bazaar";
        String outputFileName = "output.txt";

        // Open a connection to the URL
        URL url = new URL(urlString);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        // Check for successful response code (HTTP 200)
        if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
            // Read the webpage content
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Prepare to write to a file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = reader.readLine()) != null) {
                // Write each line of the webpage content to the file
                writer.write(line);
                writer.newLine(); // Add a newline for each line in the input stream
            }

            // Clean up
            reader.close();
            writer.close();
            System.out.println("Webpage content saved to " + outputFileName);
        } else {
            throw new ConnectException();
        }

        connection.disconnect();
        
        /*
        CREATE THE JSON
        */
        String content = new String(Files.readAllBytes(Paths.get(outputFileName)));
        JSONObject obj = new JSONObject(content);
        JSONObject products = obj.getJSONObject("products");
        productList = new ArrayList<>();

        for (String key : products.keySet()) {
            JSONObject productJson = products.getJSONObject(key);

            String productId = productJson.getString("product_id");
            JSONArray sellSummaryJson = productJson.getJSONArray("sell_summary");
            JSONArray buySummaryJson = productJson.getJSONArray("buy_summary");
            JSONObject quickStatusJson = productJson.getJSONObject("quick_status");

            List<Summary> sellSummary = parseSummaryList(sellSummaryJson);
            List<Summary> buySummary = parseSummaryList(buySummaryJson);
            QuickStatus quickStatus = parseQuickStatus(quickStatusJson);

            Product product = new Product(productId, sellSummary, buySummary, quickStatus);
            productList.add(product);
        }

        this.iterator = productList.iterator();
    }

    private List<Summary> parseSummaryList(JSONArray summaryJson) throws JSONException {
        List<Summary> summaryList = new ArrayList<>();
        for (int i = 0; i < summaryJson.length(); i++) {
            JSONObject summaryObj = summaryJson.getJSONObject(i);
            Summary summary = new Summary(summaryObj.getInt("amount"),
                                          summaryObj.getDouble("pricePerUnit"),
                                          summaryObj.getInt("orders"));
            summaryList.add(summary);
        }
        return summaryList;
    }

    private QuickStatus parseQuickStatus(JSONObject quickStatusJson) throws JSONException {
        return new QuickStatus(quickStatusJson.getString("productId"),
                               quickStatusJson.getDouble("sellPrice"),
                               quickStatusJson.getInt("sellVolume"),
                               quickStatusJson.getInt("sellMovingWeek"),
                               quickStatusJson.getInt("sellOrders"),
                               quickStatusJson.getDouble("buyPrice"),
                               quickStatusJson.getInt("buyVolume"),
                               quickStatusJson.getInt("buyMovingWeek"),
                               quickStatusJson.getInt("buyOrders"));
    }

    public Product nextProduct() {
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null; // Or handle the end of the list in another way if preferred
    }
    
    public int productAmmount(){
        return productList.size();
    }
    
    public void restartIterator(){
        this.iterator = productList.iterator();
    }
    
    public List<Product> getList(){
        return productList;
    }
}
