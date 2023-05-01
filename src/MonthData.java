class MonthData {

    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }

    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // подсчёт суммы элементов массива days[]
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимального элемента
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int newGoalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (days[i] >= newGoalByStepsPerDay) {
                currentSeries ++;
            } else if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
            }
        }
        if (currentSeries > finalSeries) {
            finalSeries = currentSeries;
        }
        return finalSeries;
    }
}