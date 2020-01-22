package com.ssergeev;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientServer {
    public static void main(String[] args) throws Exception {

        ClientServerService csService = new ClientServerService();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Post post = new Post();
        post.setUserId(11);
        post.setId(101);
        post.setTitle("Title");
        post.setBody("Some message");
        System.out.println("Enter request method");
        String userRequestMethod = bufferedReader.readLine();
        String get = "GET";
        String post1 = "POST";
        if (userRequestMethod.equals(get)) {
            System.out.println("Enter id");
            String userEnteredId = bufferedReader.readLine();
            csService.sendGet(userEnteredId);
        } else if (userRequestMethod.equals(post1)) csService.sendPost();
        else System.out.println("Wrong method.");
        bufferedReader.close();
    }
}

