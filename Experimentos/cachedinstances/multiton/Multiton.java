/**
 * Multiton.java 29/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 29/07/2016
 *
 */
public class Multiton {

    private static List<Multiton> configurations = new ArrayList<>();

    private long value;

    public static Multiton getInstance(final boolean... configs) {
        Multiton resultado = new Multiton(configs);
        final int check = configurations.indexOf(resultado);
        if (check >= 0) {
            resultado = configurations.get(check);
        } else {
            configurations.add(resultado);
            System.out.print(":");
        }
        return resultado;
    }

    private Multiton(final boolean... configs) {
        this.value = 0L;
        boolean config;
        for (int i = 0; i < configs.length; i++) {
            config = configs[i];
            this.value = this.value | (config ? (1L << i) : 0L);
        }
    }

    public boolean isAbility(final int place) {
        return (this.value & (1L << place)) == (1L << place);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (this.value ^ (this.value >>> 32));
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
        if (!(obj instanceof Multiton)) {
            return false;
        }
        final Multiton other = (Multiton) obj;
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
}