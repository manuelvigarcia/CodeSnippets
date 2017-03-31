/**
 * BloqueosDVL.java 14/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.io.Serializable;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 14/07/2016
 */
public class BloqueosDVL implements Serializable {

    private static final long serialVersionUID = -5527914913238780609L;


    private final boolean firstBoolean;
    private final boolean secondBoolean;
    private final boolean thirdBoolean;
    private final boolean fourthBoolean;

    /**
     * Instancia un nuevo objeto de bloqueos.
     *
     * @param firstBoolean Indica si no puede recibir del centro de distribución global
     * @param secondBoolean Indica si no puede enviar al centro de distribución global
     * @param thirdBoolean Indica si no puede recibir del centro de distribución local
     * @param fourthBoolean Indica si no puede enviar al centro de distribución local
     */
    public BloqueosDVL(final boolean firstBoolean,
            final boolean secondBoolean, final boolean thirdBoolean,
            final boolean fourthBoolean) {
        this.firstBoolean = firstBoolean;
        this.secondBoolean = secondBoolean;
        this.thirdBoolean = thirdBoolean;
        this.fourthBoolean = fourthBoolean;
    }

    public BloqueosDVL(final boolean centroDistribucionOrigenBloqueado,
            final boolean centroDistribucionDestinoBloqueado) {
        this(centroDistribucionOrigenBloqueado, centroDistribucionDestinoBloqueado,centroDistribucionOrigenBloqueado,
                centroDistribucionDestinoBloqueado);
    }

    public boolean isAbility(final int abilityIndex) {
        boolean result = false;
        switch (abilityIndex) {
        case 0: result = isfirstBoolean(); break;
        case 1: result = issecondBoolean(); break;
        case 2: result = isthirdBoolean(); break;
        case 3: result = isfourthBoolean(); break;
        default: throw new IllegalArgumentException("Ability " + abilityIndex + " does not exist.");
        }
        return result;
    }
    /**
     * Chequea el bloqueo de recepción del centro de distribución global.
     *
     * @return true si no puede recibir del centro de distribución global.
     */
    public boolean isfirstBoolean() {
        return this.firstBoolean;
    }

    /**
     * Chequea el bloqueo de envío del centro de distribución global.
     *
     * @return true sin no no puede enviar al centro de distribución global
     */
    public boolean issecondBoolean() {
        return this.secondBoolean;
    }

    /**
     * Chequea el bloqueo de recepción del centro de distribución local.
     *
     * @return true si no puede recibir del centro de distribución local
     */
    public boolean isthirdBoolean() {
        return this.thirdBoolean;
    }

    /**
     * Chequea el bloqueo de envío del centro de distribución local.
     *
     * @return true sin no no puede enviar al centro de distribución local
     */
    public boolean isfourthBoolean() {
        return this.fourthBoolean;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (this.secondBoolean ? 1231 : 1237);
        result = (prime * result) + (this.firstBoolean ? 1231 : 1237);
        result = (prime * result) + (this.fourthBoolean ? 1231 : 1237);
        result = (prime * result) + (this.thirdBoolean ? 1231 : 1237);
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
        if (!(obj instanceof BloqueosDVL)) {
            return false;
        }
        final BloqueosDVL other = (BloqueosDVL) obj;
        if (this.secondBoolean != other.secondBoolean) {
            return false;
        }
        if (this.firstBoolean != other.firstBoolean) {
            return false;
        }
        if (this.fourthBoolean != other.fourthBoolean) {
            return false;
        }
        if (this.thirdBoolean != other.thirdBoolean) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BloqueosDVL [firstBoolean=")
                .append(this.firstBoolean).append(", secondBoolean=")
                .append(this.secondBoolean).append(", thirdBoolean=")
                .append(this.thirdBoolean).append(", fourthBoolean=")
                .append(this.fourthBoolean).append("]");
        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    public Object deepCopy() {
        return new BloqueosDVL(this.firstBoolean,
                this.secondBoolean, this.thirdBoolean,
                this.fourthBoolean);
    }

}
