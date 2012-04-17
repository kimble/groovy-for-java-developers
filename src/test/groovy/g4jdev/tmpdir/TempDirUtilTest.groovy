package g4jdev.tmpdir

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public class TempDirUtilTest {

    @Test
    public void shouldCreateTemporaryDirectory() {
        File createdDirectory = null;
        TempDirUtil.doWithTemporaryDirectory(new TempDirectoryTemplate<File>() {

            @Override
            public File withTemporaryDirectory(File temporaryDirectory) {
                assertTrue(temporaryDirectory.exists());
                assertTrue(temporaryDirectory.isDirectory());

                return temporaryDirectory;
            }

        });

        assertNotNull(createdDirectory)
    }

}
