package g4dev.developers

import groovy.transform.Immutable
import groovy.transform.Canonical

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
@Canonical
class Developer {

    String name
    Set languages = [] as Set

}
