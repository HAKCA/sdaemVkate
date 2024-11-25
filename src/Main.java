import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> questionsMap = new HashMap<>();
        System.out.println("Выберите тему: \n" +
                "1) Core-1. \n" +
                "2) Core-2.\n" +
                "3) Многопоточность.\n" +
                "4) SQL. \n" +
                "5) Hibernate \n" +
                "6) Spring \n" +
                "7) Паттерны \n" +
                "8) Алгоритмы \n" +
                "9) Final Boss");
        String result = scanner.nextLine();
        if(result.equals("1")) {
            questionsMap = QuizGame.loadQuestions("core-1.txt");
            if (questionsMap.isEmpty()) {
                System.out.println("Не удалось загрузить вопросы.");
                return;
            }
        } else if(result.equals("2")) {
            questionsMap = QuizGame.loadQuestions("core-2.txt");
            if (questionsMap.isEmpty()) {
                System.out.println("Не удалось загрузить вопросы.");
                return;
            }
        } else if(result.equals("3")) {
            questionsMap = QuizGame.loadQuestions("mnogo.txt");
            if (questionsMap.isEmpty()) {
                System.out.println("Не удалось загрузить вопросы.");
                return;
            }
        } else if(result.equals("7")) {
            questionsMap = QuizGame.loadQuestions("patterns.txt");
            if (questionsMap.isEmpty()) {
                System.out.println("Не удалось загрузить вопросы.");
                return;
            }
        } else {
            System.out.println("Не готово ещё");
            return;
        }

        int count = 1;
        int allCount = questionsMap.size();
        // Основной цикл программы
        while (!questionsMap.isEmpty()) {
            String randomQuestion = QuizGame.getRandomQuestion(questionsMap);

            System.out.println("Вопрос №" + count + "/" + allCount + ": " + randomQuestion);
            System.out.println("-----------------------------------");
            scanner.nextLine();  // Ожидание нажатия Enter

            System.out.println("Ответ: " + questionsMap.get(randomQuestion));
            System.out.println("-----------------------------------");
            scanner.nextLine();  // Ожидание нажатия Enter

            questionsMap.remove(randomQuestion);
            count++;
        }

        System.out.println("Все вопросы завершены!");
    }
}