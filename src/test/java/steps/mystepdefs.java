package steps;
import app.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class mystepdefs {

    final String DEFAULT_FILE_NAME = "Temp_File.txt";

    @Given("User want to create default file")
   public void userWantToCreateDefaultFile() {
   }

    @When("User create FileTask object and use createFile method")
    public void userCreateFileTaskObjectAndUseCreateFileMethod() {
        FileTask fileTask;
        fileTask = new FileTask();
        fileTask.createFile();
    }

    @Then("File has been created")
    public void fileHasBeenCreated() {
        Path path = Paths.get("E:\\Temp_Program_Directory\\" + DEFAULT_FILE_NAME);
        Assert.assertTrue(Files.isRegularFile(path));
    }

}
