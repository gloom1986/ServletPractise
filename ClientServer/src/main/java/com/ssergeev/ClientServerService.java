package com.ssergeev;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ClientServerService {

    public static final int USERID = 11;
    public static final int ID = 101;
    public static final String TITLE = "Title";
    public static final String BODY = "Body";

    private static final String url = "https://jsonplaceholder.typicode.com/posts/";
    private static final Logger logger = LoggerFactory.getLogger(ClientServerService.class);

    public void sendGet(String id) throws Exception {

        String getUrl = url+id;
        HttpURLConnection httpClient = (HttpURLConnection) new URL(getUrl).openConnection();

        httpClient.setRequestMethod("GET");

        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = httpClient.getResponseCode();
        logger.info("\nSending 'GET' request to URL : " + getUrl);
        logger.info("\nResponse Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            Gson gson = new Gson();
            Post post = gson.fromJson(response.toString(), Post.class);

            logger.info("\nArtical [{}]: User [{}] Title [{}] Message [{}]",post.getUserId(),
                    post.getId(), post.getTitle(), post.getBody());
        }
    }

    public void sendPost() throws Exception {

        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "userId="+USERID+"&id="+ID+"&title="+TITLE+"&body="+BODY;

        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }
        int responseCode = httpClient.getResponseCode();
        logger.info("\nSending 'POST' request to URL : " + url);
        logger.info("\nPost parameters : " + urlParameters);
        logger.info("\nResponse Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            logger.info("\nArtical [{}] has been created: User [{}] Title [{}] Message [{}]", USERID, ID, TITLE, BODY);
        }
    }
}
