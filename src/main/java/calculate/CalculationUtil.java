/**
 * class CalculationUtil
 * Created by Behrooz on 06/09/2018.
 */

package calculate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CalculationUtil implements ICalculationUtil{

    ValidationUtil validationUtil = new ValidationUtil();

    /**
     * first asks for the fle name in case the name is valid
     * it then will read the String rows
     * from the file and processes them
     * to get the fial calculation outcome or
     * string message for each row
     */

    public void calculateOnallLinesFromFile(){

        IFileContentReader fileContentReader = new FileContentReader();

        List<String> fileContensLines = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter filename : ");
        while(fileContensLines.isEmpty() ) {

            String fileName = scanner.nextLine();
            fileContensLines = fileContentReader.readFileLinesToList(fileName);
        }

        for(String line : fileContensLines){
            //String[] lineContent = line.split("\\s+");
            System.out.print((line )+ " : ");
            System.out.println(calculateLineOperationResults(line));
        }


    }


    /**
     * This function will take
     * a valid array and performs the calculation.
     * the validation would be performed in another method
     * befor the aray is passed to this function.
     * @param lineContent
     * @return
     */
    public String calculateLineOperationResults(String lineContent) {
        double results = 0;

        String[] lineContentArray = lineContent.split("\\s+");
        if (validationUtil.isLineStringArrayValid(lineContentArray)) {
            lineContentArray = organizeArray(lineContentArray);

            double firstNumber = 0;
            for (int i = 0; i < lineContentArray.length ; i++) {

                String operationOrOperation;

                if (i != 0 && i != lineContentArray.length) {
                    operationOrOperation = lineContentArray[i];
                }else{
                    operationOrOperation = lineContentArray[i + 1];
                }

                if (validationUtil.isOperation(operationOrOperation)) {
                    double secondNumber = 0;
                    if (i == 0) {
                        firstNumber = Double.parseDouble(lineContentArray[0]);
                        secondNumber = Double.parseDouble(lineContentArray[2]);;
                        i = 2;
                    } else {
                        firstNumber = results;
                        secondNumber = Double.parseDouble(lineContentArray[i + 1]);
                        i =i+1 ;
                    }
                    results = performOperation(firstNumber, secondNumber, operationOrOperation);

                } else if (validationUtil.isFunction(operationOrOperation)) {
                    String function = lineContentArray[i];
                    results = performFunction(results, function);
                    if ((i + 1) > lineContentArray.length) {
                        break;
                    }
                }

            }

        }else {
            return "Not Reverse Polish Notation try backwards ";
        }

        return String.valueOf(results);

    }


    /**
     * This function will perform the arichmathical operation of
     * the two values passed to it
     * as the value of peration is passed
     * (-, +, 8< /, nod, avg)
     * @param firstNumber
     * @param secondNumber
     * @param operation
     * @return
     */
    public double performOperation(double firstNumber, double secondNumber, String operation){

        double result =0;

        if("+".equals(operation)){
            result = firstNumber + secondNumber;
        }else if("-".equals(operation)){
            result = firstNumber - secondNumber;
        }else if("*".equals(operation)){
            result = firstNumber * secondNumber;
        }else if("/".equals(operation)){
            result = firstNumber / secondNumber;
        }else if("avg".equals(operation)){
            result =(firstNumber + secondNumber)/2;
        }else {
            result = firstNumber % secondNumber;
        }
        return result;
    }

    /**
     * This  will perform the functions
     * calculation on the input values
     * as the value of the function signattu is passed
     * (sine, cos, sqrt)
     * @param valueIn
     * @param functionOrOperation
     * @return
     */
    public double performFunction( double valueIn,  String functionOrOperation){

        double result = 0;

        if("sin".equals(functionOrOperation)){
            result = Math.sin(Math.toRadians(valueIn));
        }else if("cos".equals(functionOrOperation)){
            result = Math.cos(Math.toRadians(valueIn));
        }else{
            result= Math.sqrt(valueIn);
        }

        return result;
    }


    /**
     * This function is to arrange the raw srciot for
     * calculation, by
     * moving each oreration one index back
     * @param lineArray
     * @return
     */

    public String[] organizeArray(String[] lineArray){

        for(int i =0; i<lineArray.length; i++ ){
            if(validationUtil.isOperation(lineArray[i])){
                //swap
                if (validationUtil.isOperation(lineArray[i])) {
                   String temp = lineArray[i];
                    lineArray[i] = lineArray[i -1];
                    lineArray[i -1] = temp;

                }

            }
        }

            return lineArray;
    }

    public static void main(String[] args){

        /* The valid file name is: "InputOperationLines.txt"; */

        ICalculationUtil calculationUtil = new CalculationUtil();
        calculationUtil.calculateOnallLinesFromFile();

    }

}


