package com.sooraj.study.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/features",glue="com.sooraj.study.cucumber")
public class CucumberIT {
}
