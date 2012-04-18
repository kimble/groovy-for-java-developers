package g4jdev.tmpdir

import org.junit.Test

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public class TempDirUtilTest {

    @Test
    public void shouldCreateTemporaryDirectory() {
        File createdDirectory = TempDirUtil.doWithTemporaryDirectory(new TempDirectoryTemplate<File>() {

            @Override
            public File withTemporaryDirectory(File temporaryDirectory) {
                assertThat(temporaryDirectory)
                    .as("Temporary directory handed to template")
                    .isNotNull().exists().isDirectory();

                return temporaryDirectory;
            }

        });

        assertThat(createdDirectory)
            .as("Temporary directory passed from template")
            .doesNotExist();
    }

}
