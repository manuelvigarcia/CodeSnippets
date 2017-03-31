/**
 * BLOQUEOS_COMBINADOS.java 19/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 19/07/2016
 *
 */
public enum BLOQUEOS_COMBINADOS {

    /** enumerados con todas las combinaciones de bloqueos */
    OOOO(false,false,false,false),
    OOOI(false,false,false,true),
    OOIO(false,false,true,false),
    OOII(false,false,true,true),
    OIOO(false,true,false,false),
    OIOI(false,true,false,true),
    OIIO(false,true,true,false),
    OIII(false,true,true,true),
    IOOO(true,false,false,false),
    IOOI(true,false,false,true),
    IOIO(true,false,true,false),
    IOII(true,false,true,true),
    IIOO(true,true,false,false),
    IIOI(true,true,false,true),
    IIIO(true,true,true,false),
    IIII(true,true,true,true),
    ;
    // instance fields
    private final boolean firstBoolean;
    private final boolean secondBoolean;
    private final boolean thirdBoolean;
    private final boolean fourthBoolean;

    private BLOQUEOS_COMBINADOS(final boolean firstBoolean, final boolean secondBoolean, final boolean thirdBoolean,
            final boolean fourthBoolean) {
        this.firstBoolean = firstBoolean;
        this.secondBoolean = secondBoolean;
        this.thirdBoolean = thirdBoolean;
        this.fourthBoolean = fourthBoolean;
    }

    /**
     * Chequea si first boolean.
     *
     * @return true, si first boolean
     */
    public boolean isFirstBoolean() {
        return this.firstBoolean;
    }

    /**
     * Chequea si second boolean.
     *
     * @return true, si second boolean
     */
    public boolean isSecondBoolean() {
        return this.secondBoolean;
    }

    /**
     * Chequea si third boolean.
     *
     * @return true, si third boolean
     */
    public boolean isThirdBoolean() {
        return this.thirdBoolean;
    }

    /**
     * Chequea si fourth boolean.
     *
     * @return true, si fourth boolean
     */
    public boolean isFourthBoolean() {
        return this.fourthBoolean;
    }

}
