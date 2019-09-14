Feature: Call Weather API and Check following conditions for next 2 weeks (14 Days)
# As a weather enthusiast I would like to know the number of days in Sydney where the temperature is predicated to be
# above 20 degrees in the next 2 weeks (from the current days date).
# I would also like to know how many days it is predicted to be sunny.




  Scenario: Weather Forecast
    Given Activate a URL
    When Pass the City Name, Access and Days for weather forecast



  Scenario: Check 2 weeks Weather Forecast
    Then Validate the Number of days

  Scenario: Check City Name
    Then Validate the City Name

  Scenario: the number of days in Sydney where the temperature is predicated above 20
    Then Total Number of Days in the next two weeks


  Scenario: how many days it is predicted to be sunny
    Then In Next Two Weeks total Sunny Days
