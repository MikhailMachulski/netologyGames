package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
	
	createDirInGames("src//main");
	createFile("src/main", "Main.java");
	createFile("src/main", "Utils.java");
	createDirInGames("src//test");

	createDirInGames("/res");
	createDirInGames("res//drawables");
	createDirInGames("res//vectors");
	createDirInGames("res//icons");

	createDirInGames("/savegames");

	createDirInGames("/temp");
	createFile("temp", "temp.txt");

	txtWriter(builder);

    }

    public static void createDirInGames(String dirPath) {
        File D = new File("/Users/mikhailmachulski/IdeaProjects/Games/" + dirPath);
        boolean D1 = D.mkdirs();
        if (D1) {
            String message = "Folder " + dirPath + " is created successfully";
            System.out.println(message);
            builder.append(message);
            builder.append("\n");
        } else {
            String error = "Error Found!";
            builder.append(error);
            builder.append("\n");
            System.out.println(error);
        }
    }

    public static void createFile(String filePath, String fileName) {
        File F = new File("/Users/mikhailmachulski/IdeaProjects/Games/" + filePath + "//" + fileName);
        try {
            if (F.createNewFile()) {
                String message = "File " + fileName + " created in " + filePath;
                System.out.println(message);
                builder.append(message);
                builder.append("\n");
            }
        } catch (IOException ex) {
            builder.append(ex.getMessage());
            builder.append("\n");
            System.out.println(ex.getMessage());
        }
    }

    public static void txtWriter(StringBuilder text) {
        try (FileWriter writer = new FileWriter("/Users/mikhailmachulski/IdeaProjects/Games/temp//temp.txt", true)){
            writer.write(text.toString());
            writer.append(text);
            writer.flush();
        } catch (IOException ex) {
            builder.append(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
}
