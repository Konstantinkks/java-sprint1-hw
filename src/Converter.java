public class Converter {

    int oneStep = 75; // Один шаг в см
    int smToKm = 100000;
    int caloriesPerStep = 50;
    int caloriesToKilocalories = 1000;

    int convertToKm(int steps) {

        return steps * oneStep / smToKm;
    }

    int convertStepsToKilocalories(int steps) {

        return steps * caloriesPerStep / caloriesToKilocalories;
    }
}
