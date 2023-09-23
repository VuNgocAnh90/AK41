package pages;

import base.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TodoListPage {

    public void open(){
        Browser.visit("https://todomvc.com/examples/vanillajs/");
    }

    public void addNewTodo(String todo){
        Browser.fill(By.className("new-todo"), todo,Keys.RETURN );
    }
    public void deleteTodo(String todo){
        Browser.hover(By.xpath(String.format("//label[.='%s']",todo )));
        Browser.click(By.xpath(String.format("//label[.='%s']/../button",todo)));
    }

    public void markDone(String todo){
        getTodoElementByName(todo).findElement(By.cssSelector("input.toggle")).click();
    }

    public void editTodoName(String currentName, String newName){
        WebElement todoElement = getTodoElementByName(currentName);
        Browser.action.doubleClick(todoElement).perform();
        WebElement todoEditingElement = todoElement.findElement(By.cssSelector("input.edit"));
        Browser.executeScript("arguments[0].value = ''",todoEditingElement);
        todoEditingElement.sendKeys(newName,Keys.RETURN);
    }
    private WebElement getTodoElementByName(String todoName) {
        return Browser.all(By.cssSelector(".todo-list li"))
                .stream()
                .filter(el -> todoName.equals(el.getText()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Test data missing!"));
    }
    public boolean isTodoCompleted(String todo){
        return getTodoElementByName(todo).findElement(By.cssSelector("input.toggle")).isSelected();
    }
    public List<String> getTodoList(){
        List<WebElement> todoListElement = Browser.all(By.cssSelector(".todo-list li label"));
        return todoListElement.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public void selectActiveTab(){
        Browser.click(By.cssSelector("a[href='#/active']"));
    }
    public void selectCompletedTab(){
        Browser.click(By.cssSelector("a[href='#/completed']"));
    }

    public int getActiveTodoLeft(){

        return Integer.parseInt(Browser.getText(By.cssSelector(".todo-count > strong")));
    }

}
