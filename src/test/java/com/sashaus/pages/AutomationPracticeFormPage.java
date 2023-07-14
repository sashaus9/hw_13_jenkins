package com.sashaus.pages;

import com.codeborne.selenide.SelenideElement;
import com.sashaus.pages.blocks.CalendarBlock;
import com.sashaus.pages.blocks.RegistrationResultsModalWindow;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    CalendarBlock calendarBlock = new CalendarBlock();
    RegistrationResultsModalWindow registrationResultsModalWindow = new RegistrationResultsModalWindow();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWrapper = $("#genterWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("#submit");

    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public AutomationPracticeFormPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public AutomationPracticeFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public AutomationPracticeFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public AutomationPracticeFormPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public AutomationPracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarBlock.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public AutomationPracticeFormPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public AutomationPracticeFormPage setState(String state) {
        stateSelect.click();
        stateSelect.$(byText(state)).click();
        return this;
    }

    public AutomationPracticeFormPage setCity(String city) {
        citySelect.click();
        citySelect.$(byText(city)).click();
        return this;
    }

    public AutomationPracticeFormPage uploadPicture(String classpath) {
        $("#uploadPicture").uploadFromClasspath(classpath);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public AutomationPracticeFormPage checkThatRegistrationResultsBlockAppears() {
        registrationResultsModalWindow.verifyThatRegistrationModalWindowAppears();
        return this;
    }

    public AutomationPracticeFormPage checkResultValues(Map<String, String> valuesMap) {
        registrationResultsModalWindow.verifyResult(valuesMap);
        return this;
    }

    public void closeResultModalWindow() {
        registrationResultsModalWindow.closeRegistrationResultModalWindow();
    }

}
