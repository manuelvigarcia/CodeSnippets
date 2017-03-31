/**
 * ImmutableCopyOf.java 21/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.immutablecopyof;

import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 21/07/2016
 *
 */
public class ImmutableCopyOf {
    private Map<Integer,Integer>unMapa;

    /**
     *
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        this.unMapa = null;
    }

    @Test
    public void test() {
        final Map<Integer,Integer> copia = ImmutableMap.copyOf(this.unMapa);
        assertNull(copia);
    }

}
