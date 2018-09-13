/**
 * Created by Behrooz on 06/09/2018.
 */
package calculate;

public interface IValidationUtil {

    public boolean isOperation(String member);

    public boolean isFunction(String member);

    public boolean isLineStringArrayValid(String[] outputLineArray);

    public boolean isIndividualInputElementValid(String input);

    public boolean isNumber(String input);
}
