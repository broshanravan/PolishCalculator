/**
 * ICalculationUtil
 * Created by Behrooz on 06/09/2018.
 */
package calculate;

public interface ICalculationUtil {
    public String calculateLineOperationResults(String line);
    public void calculateOnallLinesFromFile();
    public double performOperation(double firstNumber, double secondNumber, String operation);
    public double performFunction( double valueIn,  String functionOrOperation);
    public String[] organizeArray(String[] lineArray);

}
