/**
 * Created by Behrooz on 06/09/2018.
 */

package calculate;

import java.util.List;

public interface IFileContentReader {
    public List<String> readFileLinesToList(String operationsFleNamePath);
}
