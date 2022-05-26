package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    protected static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {

        String[] pathsDir = new String[8];
        pathsDir[0] = "src//main";
        pathsDir[1] = "src//test";
        pathsDir[2] = "/res";
        pathsDir[3] = "res//drawables";
        pathsDir[4] = "res//vectors";
        pathsDir[5] = "res//icons";
        pathsDir[6] = "/savegames";
        pathsDir[7] = "/temp";

        for (String s : pathsDir) {
            createDirInGames(s);
        }

        createFile("src/main", "Main.java");
        createFile("src/main", "Utils.java");
        createFile("temp", "temp.txt");

        txtWriter(builder);

    }

    public static void createDirInGames(String dirPath) {
        File file = new File("/Users/mikhailmachulski/IdeaProjects/Games/" + dirPath);
        boolean bool = file.mkdirs();
        if (bool) {
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
        File file = new File("/Users/mikhailmachulski/IdeaProjects/Games/" + filePath + "//" + fileName);
        try {
            if (file.createNewFile()) {
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
        try (FileWriter writer = new FileWriter("/Users/mikhailmachulski/IdeaProjects/Games/temp//temp.txt", true)) {
            writer.write(text.toString());
            writer.append(text);
            writer.flush();
        } catch (IOException ex) {
            builder.append(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
}
