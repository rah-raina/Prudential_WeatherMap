# Prudential_WeatherMap Automation Project

Project built to create and execute Automation testcases for web application "https://openweathermap.org/"

-----------------------------------------------------------------

## Framework Feature-

* Build on BDD framework comprising of Selenium, JAVA , Cucumber and Gradle.
* Stories are written in Gherkin language (GWT format) and stored in *.feature file.
* Step Definition class act as glue code for steps written in feature file. Annotation used (@Given, @When, @Then).
* Base Definition class provides Before and After methods.
* Page class provides methods and web elements corresponding to a web page. 
* Base Page provides common selenium methods used across different pages. Ex- clicking an element, get Text of element etc.
* Hooks class provides configuration and webdriver setup. Currently supporting local browser.
* PropertyFileReader and FileReader provides utility methods supporting reading property files.
* TestConfiguration.properties file contains properties used for configuring web driver.
* Reporting is handled through cucumber reports.
* RunCukesTest class acts as runner class.
* build.gradle file contains project dependencies and tasks to execute.

--------------------------------------------------------------------

## Framework 

>PATH=/doc/FrameworkDiagram

![FrameworkDiagram](./FrameworkDiagram.PNG "FrameworkDiagram")
--------------------------------------------------------------------

## Project Structure

>PATH=/doc/ProjectStructure

![ProjectStructure](./ProjectStructure.PNG "ProjectStructure")

--------------------------------------------------------------------

## Gradle Task

>PATH=/doc/GradleTask

![GradleTask](./GradleTask.PNG "GradleTask")

--------------------------------------------------------------------

## Jenkins Job

>PATH=/doc/JenkinsJob

![JenkinsJob](./JenkinsJob.PNG "JenkinsJob")

--------------------------------------------------------------------

## Cucumber Reports

>PATH=/doc/CucumberReportInJenkins

![CucumberReportInJenkins](./CucumberReportInJenkins.PNG "CucumberReportInJenkins")
