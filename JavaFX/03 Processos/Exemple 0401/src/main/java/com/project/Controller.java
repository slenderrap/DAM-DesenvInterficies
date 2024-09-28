package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Controller {

    @FXML
    private ImageView img;

    @FXML
    private Text txt;

    @FXML
    private Button btn;

    @FXML
    private void actionLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        
        Stage stage = (Stage) btn.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                // Read the image file
                BufferedImage bufferedImage = ImageIO.read(selectedFile);

                // Create a ByteArrayOutputStream to store the image bytes
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                // Write the image to the output stream in PNG format
                ImageIO.write(bufferedImage, "png", outputStream);

                // Get the byte array
                byte[] imageBytes = outputStream.toByteArray();

                // Encode to Base64
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                // Set the image in the ImageView
                Image image = new Image(selectedFile.toURI().toString());
                img.setImage(image);

                // Set the Base64 string in the Text component
                txt.setText(base64Image);

                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}