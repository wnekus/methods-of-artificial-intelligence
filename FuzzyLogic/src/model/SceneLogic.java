package model;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneLogic {
    private final Stage stage;

    public SceneLogic(Stage stage){
        this.stage = stage;
    }
    public void setScene(Pane layout, int height, int width){
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Car break power simulator");
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
        stage.setMaximized(false);
    }

    public void show(){
        stage.show();
    }
}
