
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"C:\\Users\\Hp\\git\\repository3\\TricentisSprint_team2\\src\\test\\java\\features"},
        glue = {"stepdefinition"},
        tags = "",
        plugin= {"html:target/cucumber.html",
                 "json:target/cucumber.json"
                }

)
public class testrunner extends AbstractTestNGCucumberTests
{

}

