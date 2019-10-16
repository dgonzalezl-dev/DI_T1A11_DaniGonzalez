/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Usuario
 */
public class Eventos8 extends Application {
    static double velocidad_bolax=1;
    static double velocidad_bolay=1;
    @Override
    public void start(Stage primaryStage) {
        Pane root=new Pane();
        Circle bola=new Circle(10);
        bola.setTranslateX(300 * 0.5);
        bola.setTranslateY(250 * 0.5);
        root.getChildren().add(bola);
        EventHandler<ActionEvent> eH = e -> {
            if(bola.getTranslateX() < 0 || bola.getTranslateX() > 500) {
                velocidad_bolax *= -1;
            }
            if(bola.getTranslateY() < 0 || bola.getTranslateY() > 500) {
                velocidad_bolay *= -1;
            }
            bola.setTranslateX(bola.getTranslateX() + velocidad_bolax);
            bola.setTranslateY(bola.getTranslateY() + velocidad_bolay);
        };
        
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), eH));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        animation.play();
        
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("bola loca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }  
}
