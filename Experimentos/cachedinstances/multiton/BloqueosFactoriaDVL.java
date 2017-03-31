/**
 * BloqueosDVL.java 14/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 14/07/2016
 */
public class BloqueosFactoriaDVL implements Serializable {

    private static final long serialVersionUID = 8430572801144715864L;
    private static List<BloqueosDVL> instancias = new ArrayList<>();

    /**
     * Instancia un nuevo objeto de bloqueos.
     *
     * @param centroDistribucionGlobalOrigenBloqueado Indica si no puede recibir del centro de distribución global
     * @param centroDistribucionGlobalDestinoBloqueado Indica si no puede enviar al centro de distribución global
     * @param centroDistribucionLocalOrigenBloqueado Indica si no puede recibir del centro de distribución local
     * @param centroDistribucionLocalDestinoBloqueado Indica si no puede enviar al centro de distribución local
     */
    private BloqueosFactoriaDVL() { }

    public static BloqueosDVL getInstance(final boolean centroDistribucionGlobalOrigenBloqueado,
            final boolean centroDistribucionGlobalDestinoBloqueado, final boolean centroDistribucionLocalOrigenBloqueado,
            final boolean centroDistribucionLocalDestinoBloqueado) {
        int resultado;
        BloqueosDVL bloqueo = new BloqueosDVL(centroDistribucionGlobalOrigenBloqueado,
                centroDistribucionGlobalDestinoBloqueado, centroDistribucionLocalOrigenBloqueado,
                centroDistribucionLocalDestinoBloqueado);
        resultado = instancias.indexOf(bloqueo);
        if (resultado < 0) {
            instancias.add(bloqueo);
            System.out.print(".");
        } else {
            bloqueo = instancias.get(resultado);
        }
        return bloqueo;
    }
}
