/**
 * Configuration.java 19/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 19/07/2016
 *
 */
public class Configuration {

    Set<BLOQUEOS> losBloqueos;
    /**
     *
     */
    public Configuration(final BLOQUEOS... listaBloqueos) {
        if (listaBloqueos.length == 0) {
            this.losBloqueos = Collections.emptySet();
        } else {
            this.losBloqueos = EnumSet.copyOf(Arrays.asList(listaBloqueos));
        }
    }
    public boolean isBloqueoActivo(final BLOQUEOS unBloqueo){
        return this.losBloqueos.contains(unBloqueo);
    }

    public boolean isAbility(final int abilityIndex) {
        boolean result = false;
        switch (abilityIndex) {
        case 0: result = isBloqueoActivo(BLOQUEOS.firstBoolean); break;
        case 1: result = isBloqueoActivo(BLOQUEOS.secondBoolean); break;
        case 2: result = isBloqueoActivo(BLOQUEOS.thirdBoolean); break;
        case 3: result = isBloqueoActivo(BLOQUEOS.fourthBoolean); break;
        default: throw new IllegalArgumentException("Ability " + abilityIndex + " does not exist.");
        }
        return result;
    }

}
