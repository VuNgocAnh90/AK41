package todoMvc;

import base.Browser;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TodoListPage;

import java.util.List;

public class TodoListTest extends TestBase {
    TodoListPage todoListPage;
    @BeforeClass
    void setup(){
        Browser.openBrowser("chrome");
        todoListPage = new TodoListPage();
    }
    @BeforeMethod
    void open(){
        todoListPage.open();
    }

    @Test
    void createdTodoListSuccessfully() {
        List<String> todoNames = List.of("Create testcase", "execute test", "verify result");
        for (String todo : todoNames) {
            todoListPage.addNewTodo(todo);
        }

        Assert.assertEquals(todoListPage.getTodoList(), todoNames);

        todoListPage.selectActiveTab();
        Assert.assertEquals(todoListPage.getTodoList(), todoNames);

        todoListPage.selectCompletedTab();
        Assert.assertEquals(todoListPage.getTodoList().size(), 0);

        Assert.assertEquals(todoListPage.getActiveTodoLeft(), todoNames.size());
    }

    @Test
    void deletedTodoListSuccessfully() {
        List<String> todoNames = List.of("Create testcase", "execute test", "verify result");
        for (String todo : todoNames) {
            todoListPage.addNewTodo(todo);
        }

        todoListPage.deleteTodo("verify result");
        Assert.assertEquals(todoListPage.getTodoList(), List.of("Create testcase", "execute test"));

        todoListPage.selectActiveTab();
        Assert.assertEquals(todoListPage.getTodoList(), List.of("Create testcase", "execute test"));

        todoListPage.selectCompletedTab();
        Assert.assertEquals(todoListPage.getTodoList().size(), 0);

        Assert.assertEquals(todoListPage.getActiveTodoLeft(), todoNames.size()-1);
    }

    @Test
    void markDoneTodoListSuccessfully() {
        List<String> todoNames = List.of("Create testcase", "execute test", "verify result");
        for (String todo : todoNames) {
            todoListPage.addNewTodo(todo);
        }

        todoListPage.markDone("execute test");
        Assert.assertEquals(todoListPage.getTodoList(), todoNames);
        Assert.assertTrue(todoListPage.isTodoCompleted("execute test"));

        todoListPage.selectActiveTab();
        Assert.assertEquals(todoListPage.getTodoList(), List.of("Create testcase", "verify result"));

        todoListPage.selectCompletedTab();
        Assert.assertEquals(todoListPage.getTodoList(), List.of("execute test"));
        Assert.assertTrue(todoListPage.isTodoCompleted("execute test"));

        Assert.assertEquals(todoListPage.getActiveTodoLeft(), todoNames.size()-1);
    }
    @Test
    void editTodoListSuccessfully() {
        List<String> todoNames = List.of("Create testcase", "execute test", "verify result");
        for (String todo : todoNames) {
            todoListPage.addNewTodo(todo);
        }

        todoListPage.editTodoName("Create testcase","Create testcase and checklist");
        Assert.assertEquals(todoListPage.getTodoList(), List.of("Create testcase and checklist", "execute test", "verify result"));

        todoListPage.selectActiveTab();
        Assert.assertEquals(todoListPage.getTodoList(), List.of("Create testcase and checklist", "execute test", "verify result"));

        todoListPage.selectCompletedTab();
        Assert.assertEquals(todoListPage.getTodoList().size(),0);

        Assert.assertEquals(todoListPage.getActiveTodoLeft(), todoNames.size());
    }
}
