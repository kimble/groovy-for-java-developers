package g4dev.developers

import spock.lang.Specification

import static g4dev.developers.TeamBuilder.buildTeam

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
class TeamBuilderSpec extends Specification {

    def "Experimenting with a team builder dsl"() {
        when: "We're building a team based on a closure"
        List team = buildTeam {
            kim "java", "groovy"
            arne "java", "visualbasic"
            sveinung "java", "objectivec"
        }

        then: "The team is built"
        team != null

        and: "it contains three developers"
        team.size() == 3

        and: "it contains the expected developers"
        team.collect { it.name } == [ "Kim", "Arne", "Sveinung" ]
    }

}
