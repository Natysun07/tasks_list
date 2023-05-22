package ru.netology.taskTodos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "родителям Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQuerySimpleTask() {
         Task[] expected = {simpleTask};
         Task[] actual = todos.search("Позвонить");
         Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryEpic() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindQueryMeeting() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoItemInStart() {
        Task[] expected = {};
        Task[] actual = todos.search("после");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEmptyNonexistentItem() {
        Task[] expected = {};
        Task[] actual = todos.search("кошка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindItemInFewClasses() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }


}
