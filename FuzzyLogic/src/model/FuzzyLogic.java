package model;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyLogic {
    private int carSpeed;
    private int distance;
    private int carWeight;
    private FuzzyRuleSet fuzzyRuleSet;
    private VisualisationCreator visualisationCreator;
    private boolean showCharts;

    public FuzzyLogic(String fileName, VisualisationCreator visualisationCreator) {
        FIS fis = FIS.load(fileName, false);
        this.fuzzyRuleSet = fis.getFuzzyRuleSet();
        this.visualisationCreator = visualisationCreator;
        this.showCharts = false;
    }

    public void setInputVariables(){
        fuzzyRuleSet.setVariable("car_speed", carSpeed);
        fuzzyRuleSet.setVariable("distance", distance);
        //fuzzyRuleSet.setVariable("car_weight", carWeight);
    }

    public void evaluateFuzzyLogic(){
        setInputVariables();
        fuzzyRuleSet.evaluate();
        visualisationCreator.show(fuzzyRuleSet.getVariable("break_power").getLatestDefuzzifiedValue());
        if(showCharts){
            fuzzyRuleSet.chart();
            fuzzyRuleSet.getVariable("break_power").chartDefuzzifier(true);
        }
        System.out.println(fuzzyRuleSet);
    }

    public void setCarSpeed(int carSpeed){
        this.carSpeed = carSpeed;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setCarWeight(int carWeight) {
        this.carWeight = carWeight;
    }

    public void setShowCharts(boolean showCharts) {
        this.showCharts = showCharts;
    }
}
