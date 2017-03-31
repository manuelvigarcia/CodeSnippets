/**
 * IntConfiguration.java 28/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 28/07/2016
 *
 */
public class IntConfiguration {
    private final int configuration;

    public IntConfiguration (final boolean abilityOne, final boolean abilityTwo,
                          final boolean abilityThree, final boolean abilityFour) {
        this.configuration = ((1 * (abilityOne ? 1 : 0)) +
                (2 * (abilityTwo ? 1 : 0)) +
                (4 * (abilityThree ? 1 : 0)) +
                (8 * (abilityFour ? 1 : 0)));
     }

    public boolean isAbilityOne() {
        return((1 & this.configuration) > 0);
    }

    public boolean isAbilityTwo() {
        return((2 & this.configuration) > 0);
    }

    public boolean isAbilityThree() {
        return((4 & this.configuration) > 0);
    }

    public boolean isAbilityFour() {
        return((8 & this.configuration) > 0);
    }
    public boolean isAbility(final int abilityIndex) {
        boolean result = false;
        switch (abilityIndex) {
        case 0: result = isAbilityOne(); break;
        case 1: result = isAbilityTwo(); break;
        case 2: result = isAbilityThree(); break;
        case 3: result = isAbilityFour(); break;
        default: throw new IllegalArgumentException("Ability " + abilityIndex + " does not exist.");
        }
        return result;
    }
}
