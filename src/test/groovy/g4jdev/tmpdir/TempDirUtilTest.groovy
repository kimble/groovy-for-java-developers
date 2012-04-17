package g4jdev.tmpdir

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public class TempDirUtilTest {

    @Test
    public void shouldCreateTemporaryDirectory() {
        File createdDirectory = TempDirUtil.doWithTemporaryDirectory(new TempDirectoryTemplate<File>() {

            @Override
            public File withTemporaryDirectory(File temporaryDirectory) {
                assertTrue("Doesn't exist", temporaryDirectory.exists());
                assertTrue("Isn't a directory", temporaryDirectory.isDirectory());

                return temporaryDirectory;
            }

        });

        assertNotNull(createdDirectory);
    }

}
