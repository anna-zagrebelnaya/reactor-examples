package com.anka;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;

public class MongoTest {

    public static void main(String... args) {
        MongoClient mongoClient = MongoClients.create("mongodb://192.168.99.100");
        System.out.println("Connection opened");
        try{
            MongoDatabase database = mongoClient.getDatabase("mydb");
            System.out.println(database.getName());
        } finally {
            mongoClient.close();
            System.out.println("Connection closed");
        }
    }

}
