package SeleniumFunctionalTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import utils.FunctionalTest;

//A page object should not have any assertions
//A page object should represent meaningful elements of a page and not necessarily a complete page
//When you navigate you should return the a page object for the next page

public class SignUpFormTest extends FunctionalTest {

    @Test
    public void signUp() throws InterruptedException{

        driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInitialized());
        signUpPage.enterName("First", "Last");
        signUpPage.enterAddress("123 Street", "12345");
        //  Thread.sleep(2000);
        ReceiptPage receiptPage = signUpPage.submit();
        assertTrue(receiptPage.isInitialized());
        assertEquals("Thank you!", receiptPage.confirmationHeader());
    }
}
