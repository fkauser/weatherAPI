$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("weatherTestCases.feature");
formatter.feature({
  "line": 1,
  "name": "Call Weather API and Check following conditions for next 2 weeks (14 Days)",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days)",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 2,
      "value": "# As a weather enthusiast I would like to know the number of days in Sydney where the temperature is predicated to be"
    },
    {
      "line": 3,
      "value": "# above 20 degrees in the next 2 weeks (from the current days date)."
    },
    {
      "line": 4,
      "value": "# I would also like to know how many days it is predicted to be sunny."
    }
  ],
  "line": 9,
  "name": "Weather Forecast",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days);weather-forecast",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Activate a URL",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "Pass the City Name, Access and Days for weather forecast",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefination.activateAURL()"
});
formatter.result({
  "duration": 394726500,
  "status": "passed"
});
formatter.match({
  "location": "stepDefination.passTheCityNameAccessAndDaysForWeatherForecast()"
});
formatter.result({
  "duration": 957613100,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Check 2 weeks Weather Forecast",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days);check-2-weeks-weather-forecast",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Validate the Number of days",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.validateTheNumberOfDays()"
});
formatter.result({
  "duration": 1062000,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Check City Name",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days);check-city-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Validate the City Name",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.validateTheCityName()"
});
formatter.result({
  "duration": 80800,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "the number of days in Sydney where the temperature is predicated above 20",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days);the-number-of-days-in-sydney-where-the-temperature-is-predicated-above-20",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "Total Number of Days in the next two weeks",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.totalNumberOfDaysInTheNextTwoWeeks()"
});
formatter.result({
  "duration": 208500,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "how many days it is predicted to be sunny",
  "description": "",
  "id": "call-weather-api-and-check-following-conditions-for-next-2-weeks-(14-days);how-many-days-it-is-predicted-to-be-sunny",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "In Next Two Weeks total Sunny Days",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.inNextTwoWeeksTotalSunnyDays()"
});
formatter.result({
  "duration": 113600,
  "status": "passed"
});
});