package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app.*;

import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mystepdefs2 {
    String name;


    @When("User create FileTask object  and use createFile method with Constructor with String parametr")
    public void userCreateFileTaskObjectAndUseCreateFileMethodWithConstructorWithStringParametr() {
        FileTask fileTask = new FileTask();

        fileTask.createFile(name);
        name += ".txt";
    }

    @Then("File has been created with user name")
    public void fileHasBeenCreatedWithUserName() {
        Path path = Paths.get("E:\\Temp_Program_Directory\\" + name);
        Assert.assertTrue(Files.isRegularFile(path));
    }


    @Given("User want to create file with name {string} in folder")
    public void userWantToCreateFileWithNameInFolder(String arg0) {
        System.out.println(arg0);
        name = arg0;
    }
}
