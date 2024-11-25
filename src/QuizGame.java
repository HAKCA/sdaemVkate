import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class QuizGame {

    // Метод для загрузки вопросов и ответов из файла в HashMap
    public static HashMap<String, String> loadQuestions(String fileName) {
        HashMap<String, String> questionsMap = new HashMap<>();

        try (InputStream inputStream = QuizGame.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            if (inputStream == null) {
                System.out.println("Файл не найден: " + fileName);
                return questionsMap;
            }

            String line;
            String question = null;
            StringBuilder answer = new StringBuilder();
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {

                if (line.startsWith("№")) {
                    if (question != null) {
                        questionsMap.put(question, answer.toString().trim());
                        answer.setLength(0); // Очищаем StringBuilder для следующего ответа
                    }
                    String[] parts = line.split("\\|", 2);
                    if (parts.length == 2) {
                        question = parts[0].trim();
                        answer.append(parts[1].trim());
                        isFirstLine = false;
                    }
                } else {
                    if (!isFirstLine) {
                        answer.append("\n").append(line.trim());
                    }
                }
            }

            // Обработка последнего вопроса и ответа после завершения цикла
            if (question != null) {
                questionsMap.put(question, answer.toString().trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return questionsMap;
    }

    // Метод для случайного выбора вопроса
    public static String getRandomQuestion(HashMap<String, String> questionsMap) {
        List<String> keys = new ArrayList<>(questionsMap.keySet());
        Random rand = new Random();
        return keys.get(rand.nextInt(keys.size()));
    }
}