import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class InsertData {

    SelenideElement
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            userEmailField = $("#userEmail"),
            userNumberField = $("#userNumber"),
            currentAddressField = $("#currentAddress"),
            genderField = $("#genterWrapper"),
            dateOfBirthField = $("#dateOfBirthInput"),
            monthOfBirthField = $(".react-datepicker__month-select"),
            yearOfBirthField = $(".react-datepicker__year-select"),
            subjectsField = $("#subjectsInput"),
            hobbiesField = $("#hobbiesWrapper"),
            stateField = $("#react-select-3-input"),
            cityField = $("#react-select-4-input"),
            pictureField = $("#uploadPicture");




    public InsertData openBrowser () {
        Configuration.browserSize = "1920x1040";
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public InsertData setAllData (String fName, String lName, String Email,String Gender, String Number, String Address,
                                  String DayOfBirth, String MonthOfBirth, String YearOfBirth, String Subject,
                                  String Hobbies, String State, String City, String Pic) {
        firstNameField.setValue(fName);
        lastNameField.setValue(lName);
        userEmailField.setValue(Email);
        genderField.$(byText(Gender)).click();
        userNumberField.setValue(Number);
        currentAddressField.setValue(Address);
        dateOfBirthField.click();
        monthOfBirthField.selectOption(MonthOfBirth);
        yearOfBirthField.selectOption(YearOfBirth);
        String dayOfBirth = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", DayOfBirth);
        $(dayOfBirth).click();
        subjectsField.setValue(Subject).pressEnter();
        hobbiesField.$(byText(Hobbies)).click();
        stateField.setValue(State).pressEnter();
        cityField.setValue(City).pressEnter();
        pictureField.uploadFile(new File("src/test/resources/" + Pic));
//        $("#uploadPicture").uploadFile(new File("src/test/resources/1.img"));
        return this;
    }


    public InsertData submit () {
        $("#submit").scrollTo().click();
        return this;
    }

    public  InsertData validation (String fName, String lName, String Email,String Gender, String Number, String Address,
                             String DayOfBirth, String MonthOfBirth, String YearOfBirth, String Subject,
                             String Hobbies, String State, String City, String Pic) {
        $$(".modal-content td").shouldHave(containExactTextsCaseSensitive(fName + " " + lName,Email,Gender,
                Number,DayOfBirth + " " + MonthOfBirth + "," + YearOfBirth,Subject,Hobbies,Pic,Address,State + " " + City));
        return this;
    }

}



