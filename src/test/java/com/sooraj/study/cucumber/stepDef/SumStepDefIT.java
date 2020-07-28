package com.sooraj.study.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SumStepDefIT {

    Integer num1;
    Integer num2;
    Integer sum;

    @Given("create controller")
    public void create_controller() {
        System.out.println("created calc");
    }

    @When("give controller {int} {int} to sum")
    public void give_controller_to_sum(Integer int1, Integer int2) {

        System.out.println("numbers "+int1+"  "+int2);
        num1=int1;
        num2=int2;
        sum=num1+num2;

    }

    @Then("the result shoud be {int}")
    public void the_result_shoud_be(Integer int1) {

        Assert.assertSame(int1,sum);

    }



}
