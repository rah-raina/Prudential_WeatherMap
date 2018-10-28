#Author: Rahul
@openWeatherMap
Feature: OpenWeatherMap

@tc101 @weatherMap
Scenario Outline: TC101 - verify various details available on openweathermap home page
Given the user is on the OpenWeatherMap home page
Then verify OpenWeatherMap home page image is displayed
And verify weather map tabs are displayed as '<tabNames>'
And verify weather report can be viewed as '<weatherReport>'

Examples:
|tabNames												|weatherReport				|
|Weather,Maps,API,Price,Partners,Stations,Widgets,Blog	|Main,Daily,Hourly,Chart,Map|

@tc102 @weatherMap
Scenario Outline: TC102 - verify error message displayed for invalid city
Given the user is on the OpenWeatherMap home page
When user searches for city '<invalidCity>'
Then verify error message displayed as '<errorMessage>'
Examples:
|invalidCity	|errorMessage	|
|XYZ			|Not found		| 

@tc103 @weatherMap
Scenario Outline: TC103 - verify weather information is displayed for valid city
Given the user is on the OpenWeatherMap home page
When user searches for city '<validCity>'
And user selects '<city>' for more information
Then verify weather information is displayed for '<city>'
Examples:
|validCity	|errorMessage	|city		|
|Mumbai		|Not found		|Mumbai, IN	| 


@tc104 @weatherMap
Scenario Outline: TC104 - verify date and time is displayed correctly
Given the user is on the OpenWeatherMap home page
When user searches for city '<validCity>'
And user selects '<city>' for more information
Then verify date and time displayed is correct
Examples:
|validCity	|errorMessage	|city		|
|Mumbai		|Not found		|Mumbai, IN	| 

@tc105 @weatherMap
Scenario Outline: TC105 - verify temperature displayed in Fahrenheit is correct
Given the user is on the OpenWeatherMap home page
When user searches for city '<validCity>'
And user selects '<city>' for more information
Then verify 'Fahrenheit' temperature displayed is correct
Then verify 'Celsius' temperature displayed is correct
Examples:
|validCity	|errorMessage	|city		|
|Mumbai		|Not found		|Mumbai, IN	|

@tc106 @weatherMap1
Scenario Outline: TC106 - verify weather forcast is displayed for next 13 days
Given the user is on the OpenWeatherMap home page
When user searches for city '<validCity>'
And user selects '<city>' for more information
Then verify weather forcast is displayed for as mentioned days
Examples:
|validCity	|errorMessage	|city		|
|Mumbai		|Not found		|Mumbai, IN	|