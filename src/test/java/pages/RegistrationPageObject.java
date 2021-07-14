package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPageObject {
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            mobileNumberInput = $("#userNumber"),
            currentAddress = $("#currentAddress");


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String value) {
        firstNameInput.val(value);
    }

    public void typeLastName(String value) {
        lastNameInput.val(value);
    }

    public void typeEmail(String value) {
        userEmailInput.val(value);
    }

    public void typeGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }


    public void typeMobileNumber(String value) {
        mobileNumberInput.val(value);
    }

    public void typeDateBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();

    }

    public void typeSubject(String value) {
        $("#subjectsInput").val(value).pressEnter();
    }

    public void typeHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
    }

    public void uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("img/" + value);
    }

    public void typeCurrentAddress(String value) {
        currentAddress.val(value);
    }

    public void typeStateAndCity(String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void pressSubmit() {
        $("#submit").click();
    }

    public void checkResults(String firstName,
                             String lastName,
                             String email,
                             String gender,
                             String mobile,
                             String monthOfBirth,
                             String yearOfBirth,
                             String dayOfBirth,
                             String subject1,
                             String hobby1,
                             String picture,
                             String currentAddress,
                             String state1,
                             String city1) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject1));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby1));
        $x("//td[text()='Picture']").parent().shouldHave(text(picture));
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(state1 + " " + city1));
    }
}
