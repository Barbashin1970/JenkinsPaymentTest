import org.junit.Assert;
import org.junit.Test;


public class AccountTest {
    String name;
    @Test
    public void checkNameToEmbossEmptyName() {
        name = "";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }
    @Test
    public void checkNameToEmbossMaxName() {
        name = "123456789 123456789";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossMinName() {
        name = "1 3";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossLongName() {
        name = "123456789 1234567890";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }
    @Test
    public void checkNameToEmbossExtraLongName() {
        name = "1234567891234567890 12345678901234567890";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossShortName() {
        name = "12";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsEmptyInside() {
        name = "123456789 012345678";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsNoEmptyInside() {
        name = "12345678912345678";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsNoEmptyInBegin() {
        name = "123456789 12345678";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsEmptyInBegin() {
        name = " 12345678 12345678";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsNoEmptyEnd() {
        name = "12345678 12345678";
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Test
    public void checkNameToEmbossContainsEmptyEnd() {
        name = " 1234567 12345678 ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }


}