package hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class HelloFX extends Application {

    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        ImageView imageView = new ImageView(new Image(HelloFX.class.getResourceAsStream("/hellofx/openduke.png")));
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
double h = Screen.getPrimary().getVisualBounds().getHeight();
double w = Screen.getPrimary().getVisualBounds().getWidth();
System.err.println("HelloFX HEIGHT = "+h+", WIDTH = "+w);


        VBox root = new VBox(30, imageView, label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, w, h);
        scene.getStylesheets().add(HelloFX.class.getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
System.err.println("Main 1 ");
System.err.println("platform = "+System.getProperty("javafx.platform"));
System.err.println("embedded = "+System.getProperty("embedded"));
    System.setProperty("javafx.platform", "android");
      System.setProperty("embedded", "monocle");
System.setProperty("glass.platform", "Monocle");
System.setProperty("javafx.verbose", "true");
System.setProperty("javafx.pulseLogger", "true");
System.setProperty("prism.verbose", "true");


System.err.println("Main 2 ");
System.err.println("platform = "+System.getProperty("javafx.platform"));
System.err.println("embedded = "+System.getProperty("embedded"));
        launch(args);
    }

}
