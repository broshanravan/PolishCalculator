/**
 * class CalculationUtilTest
 * ICalculationUtil
 * Created by Behrooz on 06/09/2018.
 */

package calculate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationUtilTest {

    CalculationUtil calculationUtil = new CalculationUtil();

    @Test
    public void testCalculateSimpleLine() {
        String collection = "1.0 2.0 +";
        String result = calculationUtil.calculateLineOperationResults(collection);

        //assertEquals(result,"3.0");

    }

    @Test
    public void testWithFunctionAtTheEnd() {
        String collection = "6 3 * 2 - sqrt";
        String result = calculationUtil.calculateLineOperationResults(collection);
       // assertEquals(result,"4.0");

    }

    @Test
    public void testWithOperationAtTheEnd() {
        String collection = "4 2 - 2 - 1000 *";
        String result = calculationUtil.calculateLineOperationResults(collection);

       // assertEquals(result,"0.0");

    }

    @Test
    public void testWithFunctionInTheMiddle(){

        String collection = "9 10 * sin 5 *";
        String result = calculationUtil.calculateLineOperationResults(collection);

        assertEquals(result,"5.0");

    }

    @Test
    public void testWithTwoFunctionsBackToBackInTheMiddle(){
        String collection = "9 10 * sin sqrt 5 *";
        String result = calculationUtil.calculateLineOperationResults(collection);

        assertEquals(result,"5.0");

    }

    @Test
    public void testWithTwoFunctionsBackToBackAtTheEnd(){
        String collection = "9 10 * sin sqrt";
        String result = calculationUtil.calculateLineOperationResults(collection);

        assertEquals(result,"1.0");

    }

    @Test
    public void testModulus(){

        String collection = "100 100 mod cos sqrt";
        String result = calculationUtil.calculateLineOperationResults(collection);
        assertEquals(result,"1.0");

    }

    @Test
    public void testAverage(){

        String collection = "180 100 avg 4 + sqrt";
        String result = calculationUtil.calculateLineOperationResults(collection);
        assertEquals(result,"12.0");

    }
}
