package FuzzyLogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Fuzzy {
    public static void main(String[] args) throws Exception {
        try {
            String fileName = "C:/Users/Kamil/Desktop/Studia/MSI/FuzzyLogic/configuration.fcl";
            int carSpeed = 100;
            int carAheadSpeed = 0;
            int distance = 2;
            FIS fis = FIS.load(fileName,false);

//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("car_speed", carSpeed);
            fuzzyRuleSet.setVariable("car_ahead_speed", carAheadSpeed);
            fuzzyRuleSet.setVariable("distance", distance);
//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("break_power").chartDefuzzifier(true);

System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

