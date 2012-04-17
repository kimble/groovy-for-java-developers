package g4dev.developers

import spock.lang.Specification
import spock.lang.Unroll
import org.junit.Before
import org.junit.BeforeClass

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
class DeveloperSpec extends Specification {

    @BeforeClass
    static void initialize() {
        Collection.metaClass.joinWithComma = {
            join(", ")
        }
    }

    @Unroll
    def "Expecting #expectedProgrammers.joinWithComma() to know #language"() {
        given:
        def glt = [
            new Developer(name: "Kim",      languages: [ "java", "groovy" ]),
            new Developer(name: "Sveinung", languages: [ "java", "objectivec" ]),
            new Developer(name: "Arne",     languages: [ "java", "visualbasic" ])
        ]

        expect:
        glt.findAll { it.languages.contains language }
           .collect { it.name } == expectedProgrammers

        where:
        language           | expectedProgrammers
        "java"             | [ "Kim", "Sveinung", "Arne" ]
        "visualbasic"      | [ "Arne" ]
    }

}
