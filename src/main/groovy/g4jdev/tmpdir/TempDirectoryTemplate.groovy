package g4jdev.tmpdir

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
public interface TempDirectoryTemplate<T> {

    T withTemporaryDirectory(File temporaryDirectory)

}
