git repo https://github.com/soorajpn/Cucumber-Spring-boot

#step 1: add this dependency to your poms dependencies tag >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> io.cucumber cucumber-junit test

	To Execute Cucumber scripts in Spring Context.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	
	
	
	
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-spring</artifactId>
        <scope>test</scope>
    </dependency>

	To run Cucumber test scenarios as JUnit tests
	
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

#step 2 create an folder with name features inside test

#step 3 create an feature file with name sum.feature ###note the file extention shoud be .feature## #step 4 edit feature file example

	Feature: Sum calculatin feature
		Scenario: to get sum
		Given create controller
		When i give number 1 2
		Then  the result was 3

#step 5 create an package inside test/com/exmaple/appname/cucumber

	create an  CucumberIT.class file 
	
	import org.junit.runner.RunWith;

		import io.cucumber.junit.CucumberOptions;
		import io.cucumber.junit.Cucumber;

		@RunWith(Cucumber.class)
		@CucumberOptions(plugin = "pretty", features = "src/test/features")
		public class CucumberIT  {
			}
			

	now we have an parant class to inherit the @RunWith propertice and @CucumberOptions to set diffent options

Step 6 create an class inside inside test/com/exmaple/appname/cucumber

CucumberContextConfiguration.class

    import com.sooraj.study.Store3App;
    import io.cucumber.java.Before;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.ContextConfiguration;
    import org.springframework.test.context.web.WebAppConfiguration;

    @SpringBootTest(classes = Store3App.class)
    @WebAppConfiguration
    @ContextConfiguration(classes = Store3App.class)
    public class CucumberContextConfiguration {

        @Before
        public void setup_cucumber_spring_context(){
            // Dummy method so cucumber will recognize this class as glue
            // and use its context configuration.
            System.out.println("################ hiii spring context is running #############");
        }

    }

use @Mock from mockito and @Injet from javax while using mock objects
