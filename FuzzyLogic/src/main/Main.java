package main;

import controller.MainPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.FuzzyLogic;
import model.SceneLogic;
import model.VisualisationCreator;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneLogic sceneLogic = new SceneLogic(primaryStage);

        VisualisationCreator visualisationCreator = new VisualisationCreator(sceneLogic);

        String fileName = System.getProperty("user.dir") + "/resources/FCLconfiguration/configuration.fcl";
        FuzzyLogic fuzzyLogic = new FuzzyLogic(fileName, visualisationCreator);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/view.fxml"));

        Pane rootLayout = loader.load();

        MainPageController mainPageController = loader.getController();
        mainPageController.initialize();
        mainPageController.setFuzzyModel(fuzzyLogic);


        sceneLogic.setScene(rootLayout, 400, 600);
        sceneLogic.show();
    }
}
