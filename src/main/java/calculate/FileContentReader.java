/**
 * class FileContentReader
 * Created by Behrooz on 06/09/2018.
 */

package calculate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;



public class FileContentReader implements IFileContentReader {

    final static Logger logger = LogManager.getLogger(FileContentReader.class);

    /**
     * THis function reads indivitual lines from the file into relevant String
     * and put them in a String array
     * to bee consumed by other functions
     * @param operationsFleNamePath
     * @return

     */

    public List<String>readFileLinesToList(String operationsFleNamePath){


        List<String> fileIndividualLines = new ArrayList();

        java.io.FileReader fileReader ;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader =
                    new java.io.FileReader(operationsFleNamePath);

            bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                fileIndividualLines.add(line);
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(
                    "Unable to open file '" +
                            operationsFleNamePath + "'");
            System.out.print("Please try again : " );
           // logger.error("error file not found", fnf);
        } catch (IOException ioe) {
           // logger.error("error closing connection", ioe);

        } finally {

            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                logger.error("error closing connection", ioe);
            } catch (NullPointerException npe) {
               // logger.error("error Null connection Object", npe);
            }
        }

        return fileIndividualLines;

    }


}
