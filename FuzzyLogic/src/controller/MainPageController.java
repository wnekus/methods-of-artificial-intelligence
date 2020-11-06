package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import model.FuzzyLogic;

public class MainPageController {
    private FuzzyLogic fuzzyModel;
    @FXML
    private Slider carSpeedSlider;
    @FXML
    private Slider carWeightSlider;
    @FXML
    private Slider distanceSlider;
    @FXML
    private TextField carSpeedField;
    @FXML
    private TextField carWeightField;
    @FXML
    private TextField distanceField;
    @FXML
    private Button submitButton;
    @FXML
    private CheckBox showCharts;

    public void initialize(){
        carSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            carSpeedField.setText(Integer.toString(newValue.intValue()));
        });

        distanceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            distanceField.setText(Integer.toString(newValue.intValue()));
        });

        carWeightSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            carWeightField.setText(Integer.toString(newValue.intValue()));
        });

        submitButton.setOnAction((observable) -> {
            fuzzyModel.setCarSpeed(carSpeedSlider.valueProperty().intValue());
            fuzzyModel.setDistance(distanceSlider.valueProperty().intValue());
            fuzzyModel.setCarWeight(carWeightSlider.valueProperty().intValue());
            fuzzyModel.setShowCharts(showCharts.isSelected());
            fuzzyModel.evaluateFuzzyLogic();
        });
    }

    public void setFuzzyModel(FuzzyLogic fuzzyModel){
        this.fuzzyModel = fuzzyModel;
    };
}
