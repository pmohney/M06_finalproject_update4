// 11/26/23
// Pierce Mohney
// SDEV200
// Final Project Update 4
// This program contains the JavaFX code for this class's final project. 
// Program will display a JavaFX window that contains three different image paths that a user can switch through in order. 
// *IMPORTANT* change file paths to your own images on your computer for program to work correctly.  

package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class MediaPostFX extends Application {

    private List<String> imagePaths;
    private int currentImagePathIndex;
    private ImageView imageView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Media Post Viewer");

        imagePaths = new ArrayList<>();
        imagePaths.add("c:/Users/example/Desktop/1.jpg");
        imagePaths.add("c:/Users/example/Desktop/2.jpg");
        imagePaths.add("c:/Users/example/Desktop/3.jpg");
//*NOTICE* Change images paths to JPEG images on user device

        currentImagePathIndex = 0;

        Image image = new Image(imagePaths.get(currentImagePathIndex));

        imageView = new ImageView(image);

        Button nextButton = new Button("Next");
        Button lastButton = new Button("Last");

        nextButton.setOnAction(e -> showNextImage());
        lastButton.setOnAction(e -> showLastImage());

        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, nextButton, lastButton);

        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(new StackPane(vbox), 1000, 800);

        StackPane.setAlignment(vbox, javafx.geometry.Pos.CENTER);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
//Creates window with next and last buttons along with image viewer. Sets index to 0

    private void showNextImage() {
        currentImagePathIndex = (currentImagePathIndex + 1) % imagePaths.size();
        updateImageView();
    }

    private void showLastImage() {
        currentImagePathIndex = (currentImagePathIndex - 1 + imagePaths.size()) % imagePaths.size();
        updateImageView();
    }

    private void updateImageView() {
        Image newImage = new Image(imagePaths.get(currentImagePathIndex));
        imageView.setImage(newImage);
    }
//Methods for switching between different images 
}
