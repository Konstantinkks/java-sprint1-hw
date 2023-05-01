public class Converter {
    int stepsInCentimeters;
    int oneStep = 75; // Один шаг в см
    int stepsInKilometers;
    int caloriesPerStep = 50;
    int totalCalories;
    int totalKilocalories;

    MonthData monthData = new MonthData();

    int convertToKm(int steps) {

        stepsInCentimeters = steps * oneStep;
        stepsInKilometers = stepsInCentimeters / 100000;

        return stepsInKilometers;
    }

    int convertStepsToKilocalories(int steps) {
        totalCalories = caloriesPerStep * steps;
        totalKilocalories = totalCalories / 1000;

        return totalKilocalories;
    }
}
