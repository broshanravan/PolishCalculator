/**
 * class FileContentReaderTest
 * Created by Behrooz on 06/09/2018.
 */

package calculate;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class FileContentReaderTest {

    IFileContentReader fileContentReader = new FileContentReader();

    @Test
    public void readValidFileLinesToListTest(){

        List<String> contentList = fileContentReader.readFileLinesToList("InputOperationLines.txt");
        String  firstItem = contentList.get(0);
        assertEquals(firstItem,"1.0 2.0 +");
        assert(contentList.size() == 5);
    }
}
