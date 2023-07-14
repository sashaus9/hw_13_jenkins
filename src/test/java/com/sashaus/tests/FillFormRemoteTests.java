package com.sashaus.tests;

import com.sashaus.utils.TestDataGenerator;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.qameta.allure.Allure.step;

public class FillFormRemoteTests extends RemoteBaseTest {

    private final Map<String, String> resultValues = new HashMap<>() {{
        put("Student Name", TestDataGenerator.firstName + " " + TestDataGenerator.lastName);
        put("Student Email", TestDataGenerator.userEmail);
        put("Gender", TestDataGenerator.gender);
        put("Mobile", TestDataGenerator.mobilePhone);
        put("Date of Birth", TestDataGenerator.day + " " + TestDataGenerator.month + "," + TestDataGenerator.year);
        put("Subjects", TestDataGenerator.subject);
        put("Hobbies", TestDataGenerator.hobby);
        put("Picture", TestDataGenerator.photo);
        put("Address", TestDataGenerator.currentAddress);
        put("State and City", TestDataGenerator.state + " " + TestDataGenerator.city);
    }};

    @Test
    @Tag("remote")
    @DisplayName("Fill form test")
    void fillFormTest() {
        Allure.step("Open form page", () ->
        automationPracticeFormPage.openPage()
                .removeBannerAndFooter());

        step("Fill form", () ->
                automationPracticeFormPage.setFirstName(TestDataGenerator.firstName)
                        .setLastName(TestDataGenerator.lastName)
                        .setUserEmail(TestDataGenerator.userEmail)
                        .setGender(TestDataGenerator.gender)
                        .setUserNumber(TestDataGenerator.mobilePhone)
                        .setBirthDate(TestDataGenerator.day, TestDataGenerator.month, TestDataGenerator.year)
                        .setSubjects(TestDataGenerator.subject)
                        .setHobbies(TestDataGenerator.hobby)
                        .uploadPicture(TestDataGenerator.photo)
                        .setCurrentAddress(TestDataGenerator.currentAddress)
                        .setState(TestDataGenerator.state)
                        .setCity(TestDataGenerator.city)
                        .clickSubmitButton());

        step("Check submit results", () ->
                automationPracticeFormPage.checkThatRegistrationResultsBlockAppears()
                        .checkResultValues(resultValues)
                        .closeResultModalWindow());
    }
}
