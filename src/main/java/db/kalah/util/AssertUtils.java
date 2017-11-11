package db.kalah.util;


public class AssertUtils {

    public static void assertTrue(boolean expression) throws Exception {
        if (!expression) {
            throw new Exception();
        }
    }

    public static void assertNotTrue(boolean expression) throws Exception {
        if (expression) {
            throw new Exception();
        }
    }
}
