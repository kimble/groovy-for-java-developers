package g4jdev.tmpdir

import static java.util.UUID.randomUUID
import org.apache.commons.io.FileUtils

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public class TempDirUtil {

    public static File doWithTemporaryDirectory(TempDirectoryTemplate template) throws IOException {
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
        File directory = new File(path);
        assert directory.exists() && directory.isDirectory();

        return directory;
    }

}
