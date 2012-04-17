package g4dev.developers

import static groovy.lang.Closure.DELEGATE_FIRST

/**
 *  
 * @author Kim A. Betti <kim.betti@gmail.com>
 */
class TeamBuilder {

    protected Closure developers
    protected List team = []

    static List buildTeam(Closure developers) {
        def builder = new TeamBuilder(developers: developers)
        builder.makeItHappen()
    }

    List makeItHappen() {
        developers.delegate = this
        developers.resolveStrategy = DELEGATE_FIRST

        developers();
        return team
    }

    def methodMissing(String name, def languages) {
        team << new Developer(name: name.capitalize(), languages: languages)
    }

}
