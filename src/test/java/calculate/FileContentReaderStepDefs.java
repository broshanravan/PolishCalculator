package calculate;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class FileContentReaderStepDefs {

    FileContentReader fileContentReader = new FileContentReader();
    List<String> linesList = null;
    String fileName = "";

    @Given("^The user provides a valid file name path$")
    public void the_user_provides_a_valid_file_name_path() throws Throwable {
        fileName = "InputOperationLines.txt";
    }

    @When("^The valid file name calculation is requested$")
    public void the_valid_file_name_calculation_is_requested() throws Throwable {
        linesList =  fileContentReader.readFileLinesToList(fileName);

    }

    @Then("^the system will attempt to read the file and calculate each line$")
    public void the_system_will_attempt_to_read_the_file_and_calculate_each_line() throws Throwable {
        assert (linesList != null);
        assert (linesList .size() == 5);
        String line_1 = linesList.get(0);
        assert ("1.0 2.0 +".equals("line_1"));


    }

    @Given("^The user provides an invalid name path for the file$")
    public void the_user_provides_an_invalid_name_path_for_the_file() throws Throwable {
        fileName = "InputOperationLinesInvalidName.txt";
    }

    @When("^The invalid file name calculation is requested$")
    public void the_invalid_file_name_calculation_is_requested() throws Throwable {
        linesList =  fileContentReader.readFileLinesToList(fileName);
        linesList.isEmpty();

    }




}
