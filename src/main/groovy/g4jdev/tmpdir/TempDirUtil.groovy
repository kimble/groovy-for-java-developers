package g4jdev.tmpdir

import static java.util.UUID.randomUUID
import org.apache.commons.io.FileUtils

/**
 * Creates a temporary directory, passes it to a block of code and
 * deletes the directory with content when the code has executed.
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public class TempDirUtil {

    public static <T> T doWithTemporaryDirectory(TempDirectoryTemplate<T> template) throws IOException {
        File systemTemporaryDirectory = getSystemTmpDirectory();
        File temporaryDirectory = new File(systemTemporaryDirectory, randomUUID().toString());

        try {
            assert temporaryDirectory.mkdir();
            System.out.println("Created temporary directory " + temporaryDirectory);

            return template.withTemporaryDirectory(temporaryDirectory)
        }
        finally {
            FileUtils.deleteDirectory(temporaryDirectory)
        }
    }

    private static File getSystemTmpDirectory() {
        String path = System.getProperty("java.io.tmpdir");
        return new File(path);
    }

}