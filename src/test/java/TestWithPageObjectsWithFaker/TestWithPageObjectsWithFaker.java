package TestWithPageObjectsWithFaker;

public class TestWithPageObjectsWithFaker {
    public static void main (String[] args) {



        InsertDataWithFaker insData = new InsertDataWithFaker();

        insData.openBrowser()
                .setAllData("Male","9876543210","22","June","1941",
                        "Computer Science", "Reading","NCR","Delhi","1.img")
                .submit()
                .validation("Male","9876543210","22","June","1941",
                        "Computer Science", "Reading","NCR","Delhi","1.img");
    }
}
