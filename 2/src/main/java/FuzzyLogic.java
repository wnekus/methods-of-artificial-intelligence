import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyLogic {
    private int carSpeed;
    private int distance;
    private int carAheadSpeed;
    private FuzzyRuleSet fuzzyRuleSet;

    public FuzzyLogic(String fileName, int[] args) {
        FIS fis = FIS.load(fileName, false);
        this.fuzzyRuleSet = fis.getFuzzyRuleSet();
        carSpeed = args[0];
        carAheadSpeed = args[1];
        distance = args[2];
        run();
    }

    private void run(){
        setInputVariables();
        evaluateFuzzyLogic();;
        getEvaluateResult();
    }

    public void setInputVariables(){
        fuzzyRuleSet.setVariable("car_speed", carSpeed);
        fuzzyRuleSet.setVariable("distance", distance);
        fuzzyRuleSet.setVariable("car_ahead_speed", carAheadSpeed);
    }

    public void evaluateFuzzyLogic(){
        fuzzyRuleSet.evaluate();
        fuzzyRuleSet.chart();
        fuzzyRuleSet.getVariable("break_power").chartDefuzzifier(true);
        System.out.println(fuzzyRuleSet);
    }

    public double getEvaluateResult(){
        return fuzzyRuleSet.getVariable("break_power").getLatestDefuzzifiedValue();
    }
}