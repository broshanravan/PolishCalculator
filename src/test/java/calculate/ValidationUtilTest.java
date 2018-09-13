
/**
 * ICalculationUtil
 * Created by Behrooz on 06/09/2018.
 */

package calculate;
import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ValidationUtilTest {


    ValidationUtil validationUtil = new ValidationUtil();

    @Test
    public void testIsNumber() {
        assert (validationUtil.isNumber("12"));
        TestCase.assertFalse(validationUtil.isNumber("1w2"));
    }


    @Test
    public void testIsOperation(){
        assert(validationUtil.isOperation("-"));
        assert(validationUtil.isOperation("+"));
        assert(validationUtil.isOperation("*"));
        assert(validationUtil.isOperation("/"));

        TestCase.assertFalse(validationUtil.isOperation("+-"));
        TestCase.assertFalse(validationUtil.isOperation("+/"));
        TestCase.assertFalse(validationUtil.isOperation("+*"));
        TestCase.assertFalse(validationUtil.isOperation("++"));

        TestCase.assertFalse(validationUtil.isOperation("--"));
        TestCase.assertFalse(validationUtil.isOperation("-/"));
        TestCase.assertFalse(validationUtil.isOperation("-*"));
        TestCase.assertFalse(validationUtil.isOperation("-+"));

        TestCase.assertFalse(validationUtil.isOperation("*-"));
        TestCase.assertFalse(validationUtil.isOperation("*/"));
        TestCase.assertFalse(validationUtil.isOperation("**"));
        TestCase.assertFalse(validationUtil.isOperation("**"));

        TestCase.assertFalse(validationUtil.isOperation("/-"));
        TestCase.assertFalse(validationUtil.isOperation("//"));
        TestCase.assertFalse(validationUtil.isOperation("/*"));
        TestCase.assertFalse(validationUtil.isOperation("/+"));

        TestCase.assertFalse(validationUtil.isOperation("2"));
        TestCase.assertFalse(validationUtil.isOperation("aew"));

        assert(validationUtil.isOperation("avg"));
        assert(validationUtil.isOperation("mod"));

        TestCase.assertFalse(validationUtil.isOperation("divide"));
        TestCase.assertFalse(validationUtil.isOperation("multiply"));

    }


    @Test
    public void testIsFunction(){
        TestCase.assertTrue(validationUtil.isFunction("sqrt"));
        assert(validationUtil.isFunction("sin"));
        assert(validationUtil.isFunction("cos"));

        TestCase.assertFalse(validationUtil.isFunction("/"));
        TestCase.assertFalse(validationUtil.isFunction("+"));
        TestCase.assertFalse(validationUtil.isFunction("-"));
        TestCase.assertFalse(validationUtil.isFunction("*"));
        TestCase.assertFalse(validationUtil.isFunction("divide"));
        TestCase.assertFalse(validationUtil.isFunction("multiply"));
        TestCase.assertFalse(validationUtil.isFunction("another"));

    }

    @Test
    public void testIsStringValid(){
        String inputLine1 = "22 45 + sqrt 2 / 2 *";

        String inputLine2 = "22 - 45 + sqrt 2 / 2 * 2";
        String inputLine3 = "+ 22 45 34 + sqrt 2 / 2 * 2";
        String inputLine4 = "mod 22 45 + sqrt 2 / 2 * 2";
        String inputLine5 = "mod 22 45 - + sqrt 2 / 2 * 2";
        String inputLine6 = "22 45 - + sqrt 2 / 2 * 2 invalid";

        String inputLine7 = "22 45 - sqrt + 2 / 2 * 2-";

        String inputLine8 = "22 45 sqrt  2 / 2 * 2 -";

        assert(validationUtil.isLineStringArrayValid(inputLine1.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine2.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine3.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine4.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine5.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine6.split(" ")));
        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine7.split(" ")));

        TestCase.assertFalse(validationUtil.isLineStringArrayValid(inputLine8.split(" ")));

    }



}
