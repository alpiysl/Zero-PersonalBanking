$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PayBills.feature");
formatter.feature({
  "name": "Pay Bills Module",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Checking Pay Bills Module",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@p"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User able to login",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountSummary.user_able_to_login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Pay Bills",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.click_on_Pay_Bills()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the page must have \"Zero - Pay Bills\" title",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.AccountSummary.the_page_must_have_title(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user fills the blanks",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.user_fills_the_blanks()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Amount field should not accept alphabetical or special characters.",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.amount_field_should_not_accept_alphabetical_or_special_characters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Date field should not accept alphabetical characters.",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.date_field_should_not_accept_alphabetical_characters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click On Pay",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.click_On_Pay()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The payment was successfully submitted. displayed",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.the_payment_was_successfully_submitted_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user tries to make a payment without entering the amount or date,",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.user_tries_to_make_a_payment_without_entering_the_amount_or_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Please fill out this field displayed.",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.stepdefinitions.PayBills.please_fill_out_this_field_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});