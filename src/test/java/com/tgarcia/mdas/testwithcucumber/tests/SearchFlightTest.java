package com.tgarcia.mdas.testwithcucumber.tests;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/flights",
        glue = "com.tgarcia.mdas.testwithcucumber.stepsdefinitions.searchflight")
public class SearchFlightTest {
}
