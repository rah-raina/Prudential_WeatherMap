#Author: Rahul
@openWeatherMap
Feature: OpenWeatherMap

@tc101
Scenario Outline: TC101 - verify various details available on openweathermap home page
Given the user is on the OpenWeatherMap home page
Then verify weather map tabs are displayed as '<tabNames>' 

Examples:
|tabNames|
|Weather,Maps,API,Price,Partners,Stations,Widgets,Blog|