/* Добрый вечер! Приятно познакомиться. Спасибо, что проверил работу. Согласен со всеми замечаниями.
В методе StepTracker я создал метод changeStepGoal думая, что метод menuChangeStepGoal не сможет вызвать сам себя))
Оказывается может) Также я удалил метод printStatistic в классе StepTracker. Этот метод я тоже с такой же логикой
создал, думая, что метод не может вызывать сам себя)
*/


import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String endl = System.getProperty("line.separator");

        StepTracker stepTracker = new StepTracker(scan);

        while (true) {
            printMenu(endl);

            int commands = scan.nextInt();
            if (commands == 1) {
                // Ввести количество шагов за определённый месяц и день
                stepTracker.addNewNumberStepsPerDay();
            } else if (commands == 2) {
                // Изменить цель по количеству шагов в день
                stepTracker.menuChangeStepGoal();
            } else if (commands == 3) {
                // Напечатать статистику за определённый месяц
                stepTracker.printStatistic();
            } else if (commands == 0) {
                // Выйти из приложения
                System.out.println("Завершение приложения...");
                scan.close();
                return;
            } else {
                System.out.println("Такой команды нет! Выберете предложенные номера команд." + endl);
            }
        }
    }

    static void printMenu(String endl) {

        System.out.print(endl + "STEP TRACKER" + endl + endl +
                "Выберете нужную команду:" + endl +
                "1-Ввести количество шагов за определённый месяц и день." + endl +
                "2-Изменить цель по количеству шагов в день." + endl +
                "3-Напечатать статистику за определённый месяц." + endl +
                "0-Выйти из приложения."+ endl);
    }
}
