/**
 * Created by Behrooz on 06/09/2018.
 */

package calculate;
import java.util.Arrays;
import java.util.List;

public class ValidationUtil implements IValidationUtil {




    /**
     *After the line read frm the file
     * this function will evaluate the
     * content and order of values.
     * it performs a combination of other
     * functions predefined in this same class in order to avoid
     * complexity of calling each of the indivitualy
     * @param outputLineArray
     * @return
     */
        public boolean isLineStringArrayValid(String[] outputLineArray) {

        boolean isValid = true;


            String lastMember = outputLineArray[outputLineArray.length -1];

            if (
                    isOperation(outputLineArray[0]) ||
                            isOperation(outputLineArray[1]) ||
                            isFunction(outputLineArray[0])
                    ) {

                return false;
            }

            if(!isOperation(lastMember) && !isFunction((lastMember))){
                return false;
            }

        for (int i=0; i<outputLineArray.length -1 ;i++) {

            isValid = isIndividualInputElementValid(outputLineArray[i]);
            if(!isValid){
                break;
            }

            if (
                    isOperation(outputLineArray[i]) && isOperation(outputLineArray[i + 1])
                    ) {
                isValid = false;
                break;

            }
            if (
                    isFunction(outputLineArray[i]) &&  isNumber(outputLineArray[i + 1]) && !isOperation(outputLineArray[i + 2])
                    ) {
                isValid = false;
                break;
            }

            if (
                    isFunction(outputLineArray[i]) && isOperation(outputLineArray[i + 1])
                    ) {
                isValid = false;
                break;
            }


            if (
                    outputLineArray[i].equals(0) && outputLineArray[i + 1].equals("/")
                    ) {
                isValid = false;
                break;
            }


        }

        return isValid;
    }

    /**
     * this function will check the format of each
     * individual member od an array to make sure
     * it is either an operation or a function of a number
     * @param input
     * @return
     */
    public boolean isIndividualInputElementValid(String input){
        boolean isValid = true;
        if(
                !isOperation(input) &&
                        !isFunction(input) &&
                        !isNumber(input)
                ){
            isValid = false;
        }

        return isValid;

    }


    /**
     * This function will check if
     * an individul member of the array is a
     * valid number
     * @param input
     * @return
     */
    public boolean isNumber(String input){
        boolean isNumber = true;
        try{
            Double.parseDouble(input);
        } catch (Exception e){
            isNumber = false;
        }


        return isNumber ;
    }


    /**
     * This function will check if
     * an individual member of the array is a
     * valid operation
     * @param member
     * @return
     */

    public boolean isOperation(String member){
        boolean isOperation = false;

        List<String> operationsList =  Arrays.asList("-", "+", "*", "/", "avg","mod");
        for(String str: operationsList) {
            if(str.trim().equals(member))
                isOperation = true;
        }

        return isOperation;

    }

    /**
     *This function will check if
     * an individual member of the array is a
     * valid function
     * @param member
     * @return
     */
    public boolean isFunction(String member){
        boolean isFunction = false;

        List<String> operationsList =  Arrays.asList("sqrt", "sin" , "cos" );
        for(String str: operationsList) {
            if(str.trim().equals(member))
                isFunction = true;
        }

        return isFunction;

    }



}
