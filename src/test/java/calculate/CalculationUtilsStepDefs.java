package calculate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculationUtilsStepDefs {

     ICalculationUtil calculationUtil = new CalculationUtil();
     String inputLine ="";
     String answer = "";


    @Given("^The user enters a valid line$")
    public void the_user_enters_a_valid_line() throws Throwable {
        inputLine = "1.0 2.0 +";

    }

    @When("^The calculation is requested$")
    public void the_calculation_is_requested() throws Throwable {
       answer = calculationUtil.calculateLineOperationResults(inputLine);


    }

    @Then("^the system will display calculation results$")
    public void the_system_will_display_calculation_results() throws Throwable {
        assert (answer.equals("3.0"));

    }

    @Given("^The user enters an invalid line$")
    public void the_user_enters_an_invalid_line() throws Throwable {
        inputLine = "1.0 + 2.0 +";
    }

    @When("^The invalid line calculation is requested$")
    public void the_invalid_line_calculation_is_requested() throws Throwable {
        answer = calculationUtil.calculateLineOperationResults(inputLine);
    }

    @Then("^The system throws an error$")
    public void the_system_throws_an_error() throws Throwable {
        assert (answer.equals("0.0"));
    }



}
