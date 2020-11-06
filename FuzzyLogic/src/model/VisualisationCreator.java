package model;

import controller.WebViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VisualisationCreator {
    private SceneLogic sceneLogic;
    private WebViewController webViewController;

    public VisualisationCreator(SceneLogic sceneLogic){
        this.sceneLogic = sceneLogic;
    }

    public void show(double breakPower){
        setWebScene();
    }

    public void setWebScene(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/webview.fxml"));

        Pane layout;
        try{
            layout = loader.load();
        } catch(IOException e){
            System.out.println(e);
            return;
        }

        WebViewController webViewController = loader.getController();
        webViewController.initialize();

        sceneLogic.setScene(layout, 400, 600);
        sceneLogic.show();
    }




}
