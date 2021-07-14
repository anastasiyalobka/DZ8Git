package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPageObject;

import static io.qameta.allure.Allure.step;

public class PracticeForm extends TestBase {
    Faker faker = new Faker();

    String  firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Female",
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            subject1 = "Chemistry",
            hobby1 = "Reading",
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state1 = "NCR",
            city1 = "Delhi";

    RegistrationPageObject registrationPageObject = new RegistrationPageObject();

    @Owner("anastasiyalobka")
    @Test
    @Story("Проверка отправки формы")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на проверку успешной отправки формы")

    void successFullPracticeForm(){
        step ("Открыть страницу demoqa.com", () -> {
                    registrationPageObject.openPage();
        });
        step ("Ввести основную информацию о клиенте", () -> {
        registrationPageObject.typeFirstName(firstName);
        registrationPageObject.typeLastName(lastName);
        registrationPageObject.typeEmail(email);
        registrationPageObject.typeGender(gender);
        registrationPageObject.typeMobileNumber(mobile);
        registrationPageObject.typeDateBirth(dayOfBirth,monthOfBirth,yearOfBirth);
        });

        step ("Ввести информацию об увлечениях клиента", () -> {
        registrationPageObject.typeSubject(subject1);
        registrationPageObject.typeHobby(hobby1);
        });

        step ("Загрузить файл", () -> {
        registrationPageObject.uploadPicture(picture);
        });

        step ("Ввести информацию о местонахождении клиента", () -> {
        registrationPageObject.typeCurrentAddress(currentAddress);
        registrationPageObject.typeStateAndCity(state1,city1);
        registrationPageObject.pressSubmit();
        });

        step ("Проверить соответствие результата введенным данным", () -> {
        registrationPageObject.checkResults(firstName,
                lastName,
                email,
                gender,
                mobile,
                monthOfBirth,
                yearOfBirth,
                dayOfBirth,
                subject1,
                hobby1,
                picture,
                currentAddress,
                state1,
                city1);
        });
    }
}
