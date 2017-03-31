/**
 * CachedConfiguration.java 28/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 28/07/2016
 *
 */
public class CachedConfiguration {

    private static LoadingCache<Set<Ability>, CachedConfiguration> cache = CacheBuilder.newBuilder()
         .build(new CacheLoader<Set<Ability>, CachedConfiguration>() {
             @Override
             public CachedConfiguration load(final Set<Ability> withAbilities) {
                 return new CachedConfiguration(withAbilities);
             }

         });

     Set<Ability> abilities;

     private CachedConfiguration(final Collection<Ability> withAbilities) {
         this.abilities = createAbilitySet(withAbilities);
     }

     public static CachedConfiguration create(final Ability... withAbilities) {
         final Set<Ability> searchedAbilities = createAbilitySet(Arrays.asList(withAbilities));
         try {
             return cache.get(searchedAbilities);
         } catch (final ExecutionException e) {
             Throwables.propagateIfPossible(e);
             throw new IllegalStateException();
         }
     }

     private static Set<Ability> createAbilitySet(final Collection<Ability> fromAbilities) {
         if (fromAbilities.size() == 0) {
             return Collections.emptySet();
         }
        return EnumSet.copyOf(fromAbilities);
     }

     public boolean hasAbility(final Ability ability) {
        return this.abilities.contains(ability);
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
 }