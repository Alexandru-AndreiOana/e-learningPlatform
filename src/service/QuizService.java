package service;
import model.*;

import java.text.SimpleDateFormat;

public class QuizService
{

    private static final QuizService SINGLETON = new QuizService(NotificationService.getInstance());
    private QuizService(NotificationService instance){}
    public static QuizService getInstance()
    {
        return SINGLETON;
    }

    public void addQuestion(Quiz quiz, String question)
    {
        int len = quiz.getQuestions().length;
        String [] aux = new String [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = quiz.getQuestions()[i];
        aux[len] = question;
        quiz.setQuestions(aux);
        String message = "add question in quiz";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

    public void addAnswers(Quiz quiz, String answer)
    {
        int len = quiz.getAnswers().length;
        String [] aux = new String [len + 1];
        for (int i = 0; i < len; i++)
            aux[i] = quiz.getAnswers()[i];
        aux[len] = answer;
        quiz.setAnswers(aux);
        String message = "add answer in quiz";
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        NotificationService.getInstance().sendNotification(new Notification(message, timeStamp));
    }

}
