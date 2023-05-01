import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    Converter converter = new Converter();
    int goalByStepsPerDay = 0;
    int newGoalByStepsPerDay = 10000;
    int month;
    int day;
    MonthData[] monthToData = new MonthData[12];

    public StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void menuChangeStepGoal() {

        while (true) {

            System.out.println("Текущая цель на день: " + newGoalByStepsPerDay + ".");
            System.out.println("Введите новую цель по количеству шагов за день: ");
            goalByStepsPerDay = scanner.nextInt();

            if (goalByStepsPerDay > 0) {
                newGoalByStepsPerDay = goalByStepsPerDay;
                System.out.println("Новая цель на день: " + newGoalByStepsPerDay + ".");
            } else {
                System.out.println("Необходимо ввести значение больше нуля!");
                ChangeStepGoal();
            }
            return;
        }
    }

    void ChangeStepGoal() {

        menuChangeStepGoal();
    }

    public void addNewNumberStepsPerDay() {

        while (true) {
            System.out.println("Введите номер месяца от 1 до 12 (включительно): ");
            // ввод и проверка номера месяца
            month = scanner.nextInt();

            if (month > 0 && month < 13) {
                System.out.println("Введите номер дня от 1 до 30 (включительно): ");
                // ввод и проверка дня
                day = scanner.nextInt();
                if (day > 0 && day < 31) {
                    System.out.println("Введите количество шагов: ");
                    // ввод и проверка количества шагов
                    int steps = scanner.nextInt();
                    if (steps > 0) {
                        // Сохранение полученных данных
                        monthToData[month - 1].days[day - 1] = steps;
                        if (steps >= newGoalByStepsPerDay) {
                            System.out.println("Сегодня вы прошли " + steps + " шагов! Вы выполнили свою цель!");
                        } else {
                            System.out.println("Сегодня вы прошли " + steps + " шагов! Завтра у вас получится достичь цели!");
                        }

                    } else {
                        System.out.println("Введите положительное число шагов!");
                    }
                    return;
                } else {
                    System.out.println("Неверное значение!");
                }
            } else {
                System.out.println("Неверное значение!");
            }
        }
    }

    void statistic() {

        while (true) {

            month = scanner.nextInt();

            if (month > 0 && month < 13) {

                // получение соответствующего месяца
                MonthData monthData = monthToData[month - 1];

                // вывод общей статистики за выбранный день
                System.out.println("Общая статистика за " + month + " месяц: ");
                System.out.println();

                // вывод общей статистики по дням
                System.out.println("Статистика по дням: ");
                monthData.printDaysAndStepsFromMonth();
                System.out.println();

                // получение суммы шагов за месяц
                System.out.println("Сумма шагов за месяц: ");
                System.out.println(monthData.sumStepsFromMonth());
                System.out.println();

                // вывод максимального пройденного количества шагов за месяц
                System.out.println("Максимально пройденное количество шагов за месяц: ");
                System.out.println(monthData.maxSteps());
                System.out.println();

                // вывод среднего пройденного количества шагов за месяц
                System.out.println("Среднее пройденное количество шагов за месяц: ");
                System.out.println(monthData.sumStepsFromMonth() / 30);
                System.out.println();

                // вывод пройденной за месяц дистанции в км
                System.out.println("Пройденная за месяц дистанция (км): ");
                System.out.println(converter.convertToKm(monthData.sumStepsFromMonth()));
                System.out.println();

                // вывод количества сожжённых килокалорий за месяц
                System.out.println("Количество сожжённых килокалорий за месяц: ");
                System.out.println(converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
                System.out.println();

                // вывод лучшей серии
                System.out.println("Лучшая серия дней: ");
                System.out.println(monthData.bestSeries(newGoalByStepsPerDay));
                System.out.println(); //дополнительный перенос строки
            } else {
                System.out.println("Неверное значение!");
                printStatistic();
            }
            return;
        }
    }

    void printStatistic() {

        // ввод и проверка номера месяца
        System.out.println("Введите номер месяца от 1 до 12 (включительно): ");
        statistic();

    }
}
