package ru.netology.taskTodos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {


    @Test
    public void simpleTaskTrueFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("родителям"));
        Assertions.assertFalse(simpleTask.matches("Позвоню"));
        Assertions.assertFalse(simpleTask.matches("позвонить"));
        Assertions.assertFalse(simpleTask.matches("На работу"));
    }

    @Test
    public void EpicTrueFalse() {
        String[]subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("хлеба"));
        Assertions.assertFalse(epic.matches("Яица"));
        Assertions.assertFalse(epic.matches("Молока"));
        Assertions.assertFalse(epic.matches("Конфеты"));

    }

    @Test
    public void MeetingTrueFalse() {
        Meeting meeting = new Meeting(
                555,
                "родителям Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Assertions.assertTrue(meeting.matches("Выкатка"));
        Assertions.assertTrue(meeting.matches("НетоБанка"));
        Assertions.assertFalse(meeting.matches("После"));
        Assertions.assertFalse(meeting.matches("выкатка"));
        Assertions.assertFalse(meeting.matches("Нетобанка"));
        Assertions.assertFalse(meeting.matches("версия"));
        Assertions.assertFalse(meeting.matches("3-й"));
        Assertions.assertFalse(meeting.matches("3и"));
    }
}
