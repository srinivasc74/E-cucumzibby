$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PayFrequency.feature");
formatter.feature({
  "line": 1,
  "name": "Pay Frequency flows",
  "description": "",
  "id": "pay-frequency-flows",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "",
  "description": "Verify that the payment due date has moved to the next payment array and displays correctly across \nCart, Contract, Customer Portal and LMS when the time difference between lease origination date and the next pay date is less than 5 business days.",
  "id": "pay-frequency-flows;",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PayFrequency"
    },
    {
      "line": 3,
      "name": "@Demo"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "a user with a valid set of credentials username \"\u003cuserName\u003e\" and password \"\u003cpassword\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user sees the welcome page enters customer mobile number.",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user initiates a new application by entering phone number and verification code",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "enter demographic information with first name as \"\u003cfirstName\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "enters last name as \"\u003clastName\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "enters date of birth as \"\u003cdateOfBirth\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "enters SSN or ITIN as \"\u003cSSN_ITIN\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "enters email ID as \"\u003cemailId\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "enters billing address as \"\u003cbillingAddress1\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "enter second address line as \"\u003cbillingAddress2\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "enter city as \"\u003ccity\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "selects state as \"\u003cstate\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "enters zipcode as \"\u003czipCode\u003e\" and clicks continue",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Lands on Pay frequency",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Enters Salary \u003c\"salary\"\u003e for the term  \"\u003cpayTerm\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Enters Pay Frequency as \"\u003cpayFrequency\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "Enters Last Pay date as \"\u003cpayDate\u003e\"",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 25,
      "value": "#(5 or less days from Todays Date)"
    }
  ],
  "line": 26,
  "name": "Enter Next Pay Date \"\u003cnextPayDate\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Selects Direct Deposit as \"\u003cdirectDeposit\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "hits Continue and lands on Preapproval Page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user adds item to cart",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "verify the item is added to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Verify the Payment due date next cycle on the payment array displays as the customer\u0027s due date",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user Navigates to Checkout",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "Verify the lease details as Rental Term and Payment Schedule begin and end dates correspond to the payment due date",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "user processes the lease by making a payment",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "user Navigates to LMS",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "pulls up the lease",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "verify the payment due date on the summary page aligns with contract and cart dates.",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "pay-frequency-flows;;",
  "rows": [
    {
      "cells": [
        "userName",
        "password",
        "firstName",
        "lastName",
        "dateofBirth",
        "SSN_ITIN",
        "emailId",
        "billingAddress1",
        "billingAddress2",
        "city",
        "state",
        "zipCode",
        "salary",
        "payTerm",
        "payFrequency",
        "payDate",
        "nextPayDate",
        "directDeposit"
      ],
      "line": 39,
      "id": "pay-frequency-flows;;;1"
    },
    {
      "cells": [
        "HeyArzie",
        "test",
        "John",
        "Bonham",
        "06/19/1975",
        "694949898",
        "sunil.geddam@cognical.com",
        "12911 Alton Sq",
        "Apt 202",
        "Herndon",
        "VA",
        "20170",
        "45000",
        "Yearly",
        "monthly",
        "6/24/2019",
        "lessThan5",
        "yes"
      ],
      "line": 40,
      "id": "pay-frequency-flows;;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 40,
  "name": "",
  "description": "Verify that the payment due date has moved to the next payment array and displays correctly across \nCart, Contract, Customer Portal and LMS when the time difference between lease origination date and the next pay date is less than 5 business days.",
  "id": "pay-frequency-flows;;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@Demo"
    },
    {
      "line": 3,
      "name": "@PayFrequency"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "a user with a valid set of credentials username \"HeyArzie\" and password \"test\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user sees the welcome page enters customer mobile number.",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user initiates a new application by entering phone number and verification code",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "enter demographic information with first name as \"John\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "enters last name as \"Bonham\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "enters date of birth as \"\u003cdateOfBirth\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "enters SSN or ITIN as \"694949898\"",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "enters email ID as \"sunil.geddam@cognical.com\"",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "enters billing address as \"12911 Alton Sq\"",
  "matchedColumns": [
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "enter second address line as \"Apt 202\"",
  "matchedColumns": [
    8
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "enter city as \"Herndon\"",
  "matchedColumns": [
    9
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "selects state as \"VA\"",
  "matchedColumns": [
    10
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "enters zipcode as \"20170\" and clicks continue",
  "matchedColumns": [
    11
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Lands on Pay frequency",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Enters Salary \u003c\"salary\"\u003e for the term  \"Yearly\"",
  "matchedColumns": [
    13
  ],
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Enters Pay Frequency as \"monthly\"",
  "matchedColumns": [
    14
  ],
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "Enters Last Pay date as \"6/24/2019\"",
  "matchedColumns": [
    15
  ],
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 25,
      "value": "#(5 or less days from Todays Date)"
    }
  ],
  "line": 26,
  "name": "Enter Next Pay Date \"lessThan5\"",
  "matchedColumns": [
    16
  ],
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Selects Direct Deposit as \"yes\"",
  "matchedColumns": [
    17
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "hits Continue and lands on Preapproval Page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user adds item to cart",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "verify the item is added to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Verify the Payment due date next cycle on the payment array displays as the customer\u0027s due date",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "user Navigates to Checkout",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "Verify the lease details as Rental Term and Payment Schedule begin and end dates correspond to the payment due date",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "user processes the lease by making a payment",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "user Navigates to LMS",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "pulls up the lease",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "verify the payment due date on the summary page aligns with contract and cart dates.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});