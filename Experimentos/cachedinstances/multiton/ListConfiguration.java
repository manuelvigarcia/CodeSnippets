/**
 * SetConfiguration.java 29/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 29/07/2016
 *
 */
public class ListConfiguration {

    static List<ListConfiguration > confs = new ArrayList<>();

    private final Set<Ability> abilities;


    private ListConfiguration (final Collection<Ability> abs) {
        this.abilities = createAbilitySet(abs);
    }

    public boolean hasAbility(final Ability ab) {
        return this.abilities.contains(ab);
    }

    public static ListConfiguration getConfiguration(final Ability ... abs) {
        ListConfiguration newOne = new ListConfiguration(Arrays.asList(abs));
        final int indice = ListConfiguration.confs.indexOf(newOne);
        if (indice >= 0) {
            newOne = ListConfiguration.confs.get(indice);
        } else {
            ListConfiguration.confs.add(newOne);
            System.out.print("-");
        }
        return newOne;
    }

    private static Set<Ability> createAbilitySet(final Collection<Ability> fromAbilities) {
        if (fromAbilities.size() == 0) {
            return Collections.emptySet();
        }
       return EnumSet.copyOf(fromAbilities);
    }

    public boolean isAbility(final int abilityIndex) {
        boolean result = false;
        switch (abilityIndex) {
        case 0: result = hasAbility(Ability.Ability1); break;
        case 1: result = hasAbility(Ability.Ability2); break;
        case 2: result = hasAbility(Ability.Ability3); break;
        case 3: result = hasAbility(Ability.Ability4); break;
        default: throw new IllegalArgumentException("Ability " + abilityIndex + " does not exist.");
        }
        return result;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.abilities == null) ? 0 : this.abilities.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ListConfiguration)) {
            return false;
        }
        final ListConfiguration other = (ListConfiguration) obj;
        if (this.abilities == null) {
            if (other.abilities != null) {
                return false;
            }
        } else if (!this.abilities.equals(other.abilities)) {
            return false;
        }
        return true;
    }
}
