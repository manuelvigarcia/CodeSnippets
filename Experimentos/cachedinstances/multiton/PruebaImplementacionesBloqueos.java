/**
 * PruebaImplementacionesBloqueos.java 19/07/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.java.multiton;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.distribution.BinomialDistribution;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author <a href="mailto:manuelvgr">Manuel Vicente Garcia Rodriguez</a> 19/07/2016
 *
 */
public class PruebaImplementacionesBloqueos {

    private final int MAX_INTENTOS = 500;
    private final int NUM_ITERACIONES = 10;
    private final int NUM_OBJETOS = 600 * (100 + 1750);
    private final int PAUSE_LENGTH = 500;
    private BinomialDistribution booleanoAleatorio;
    private final boolean[][] todasCombinaciones = {
            {false,false,false,false}
            ,{false,false,false,true}
            ,{false,false,true,false}
            ,{false,false,true,true}
            ,{false,true,false,false}
            ,{false,true,false,true}
            ,{false,true,true,false}
            ,{false,true,true,true}
            ,{true,false,false,false}
            ,{true,false,false,true}
            ,{true,false,true,false}
            ,{true,false,true,true}
            ,{true,true,false,false}
            ,{true,true,false,true}
            ,{true,true,true,false}
            ,{true,true,true,true}
    };


    /**
     *
     */
    @Before
    public void setUp() {
        this.booleanoAleatorio = new BinomialDistribution(1, 0.5d);
    }

    private int[] dameBloqueos() {
        final int longitud = this.todasCombinaciones[0].length;
        return this.booleanoAleatorio.sample(longitud);
    }


    /**
     * Prueba que todas las implementaciones pueden almacenar todas las combinaciones de bloqueos y que las
     * representaciones son equivalentes.
     *
     */
    @Test
    public void probarTodasCombinaciones() {
        for (final boolean [] combinacion : this.todasCombinaciones) {
            final BloqueosDVL bDVL = new BloqueosDVL(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final BloqueosDVL factoriaDvl = BloqueosFactoriaDVL.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final Configuration conf = creaConfiguracion(combinacion);
            final CachedConfiguration cachedConf = CachedConfiguration.create(creaAbilityArray(combinacion));
            final IntConfiguration intConf = new IntConfiguration(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final Multiton multiConf = Multiton.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final ListConfiguration listConf = ListConfiguration.getConfiguration(creaAbilityArray(combinacion));
            for (int i = 0; i < combinacion.length; i++) {
                assertEquals(combinacion[i], bDVL.isAbility(i));
                assertEquals(combinacion[i], factoriaDvl.isAbility(i));
                assertEquals(combinacion[i], conf.isAbility(i));
                assertEquals(combinacion[i], cachedConf.isAbility(i));
                assertEquals(combinacion[i], intConf.isAbility(i));
                assertEquals(combinacion[i], multiConf.isAbility(i));
                assertEquals(combinacion[i], listConf.isAbility(i));
            }
        }

    }

    /**
     * Prueba que todas las implementaciones funcionan bien a la hora de almacenar cualquier numero de combinaciones.
     */
    @Test
    public void probarAleatorios() {
        for (int i = 0; i<this.MAX_INTENTOS; i++) {
            final int [] intCombinacion = dameBloqueos();
            final boolean [] combinacion = Arrays.copyOf(this.todasCombinaciones[0], this.todasCombinaciones[0].length);
            for (int j = 0; j < this.todasCombinaciones[0].length; j ++) {
                combinacion[j] =  (intCombinacion[j] == 0);
            }

            final BloqueosDVL bDVL = new BloqueosDVL(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final BloqueosDVL factoriaDvl = BloqueosFactoriaDVL.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final Configuration conf = creaConfiguracion(combinacion);
            final CachedConfiguration cachedConf = CachedConfiguration.create(creaAbilityArray(combinacion));
            final IntConfiguration intConf = new IntConfiguration(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final Multiton multiConf = Multiton.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
            final ListConfiguration listConf = ListConfiguration.getConfiguration(creaAbilityArray(combinacion));
            for (int k = 0; k < combinacion.length; k++) {
                assertEquals(combinacion[k], bDVL.isAbility(k));
                assertEquals(combinacion[k], factoriaDvl.isAbility(k));
                assertEquals(combinacion[k], conf.isAbility(k));
                assertEquals(combinacion[k], cachedConf.isAbility(k));
                assertEquals(combinacion[k], intConf.isAbility(k));
                assertEquals(combinacion[k], multiConf.isAbility(k));
                assertEquals(combinacion[k], listConf.isAbility(k));
            }
        }
    }

    /**
     *
     *
     * @param combinacion
     * @return array con sólo los BLOQUEOS activos
     */
    private static Configuration creaConfiguracion(final boolean[] combinacion) {
        if (BLOQUEOS.values().length != combinacion.length) {
             throw new IllegalArgumentException ("Tamaños diferentes del argumento y de la enumeracion BLOQUEOS.");
        }
        final BLOQUEOS[] vacio = {};
        final Configuration resultado;
        final ArrayList<BLOQUEOS> arrayBloqueos = new ArrayList<>();
        int i = 0;
        for (final BLOQUEOS b : BLOQUEOS.values()) {
            if (combinacion[i]) {
                arrayBloqueos.add(b);
            }
            i++;
        }
        resultado = new Configuration(arrayBloqueos.toArray(vacio));
        return resultado;
    }
    /**
    *
    *
    * @param combinacion
    * @return array con sólo las Abilities activas
    */
   private static Ability[] creaAbilityArray(final boolean[] combinacion) {
       if (Ability.values().length != combinacion.length) {
            throw new IllegalArgumentException ("Tamaños diferentes del argumento y de la enumeracion BLOQUEOS.");
       }
       final Ability[] vacio = {};
       final ArrayList<Ability> arrayCachedC = new ArrayList<>();
       int i = 0;
       for (final Ability b : Ability.values()) {
           if (combinacion[i]) {
               arrayCachedC.add(b);
           }
           i++;
       }
       return arrayCachedC.toArray(vacio);
   }

    @Test
    public void comparaMemoriaUsada() {
        final Runtime rt= Runtime.getRuntime();
        final String format = "%,d";

        //generar la lista de combinaciones aleatorias una vez
        final List<boolean[]> lasCombinaciones = dameListaDeCombinaciones(this.NUM_OBJETOS);

        for (int i = 0; i<this.NUM_ITERACIONES; i++) {
            List<BloqueosDVL> listaBloqueos = new ArrayList<>(lasCombinaciones.size());
            List<BloqueosDVL> listaDeFactoria = new ArrayList<>(lasCombinaciones.size());
            List<Configuration> listaConf = new ArrayList<>(lasCombinaciones.size());
            List<CachedConfiguration> listaCachedC = new ArrayList<>(lasCombinaciones.size());
            List<IntConfiguration> listaIntConf = new ArrayList<>(lasCombinaciones.size());
            List<Multiton> listaMultiConf = new ArrayList<>(lasCombinaciones.size());
            List<ListConfiguration> listaListaConf = new ArrayList<>(lasCombinaciones.size());
            for(int k = 0; k<lasCombinaciones.size(); k++) {
                final boolean [] combinacion = lasCombinaciones.get(k);
                final BloqueosDVL bDVL = new BloqueosDVL(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
                listaBloqueos.add(bDVL);
                final BloqueosDVL factoriaDvl = BloqueosFactoriaDVL.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
                listaDeFactoria.add(factoriaDvl);
                final Configuration conf = creaConfiguracion(combinacion);
                listaConf.add(conf);
                final CachedConfiguration cachedConf = CachedConfiguration.create(creaAbilityArray(combinacion));
                listaCachedC.add(cachedConf);
                final IntConfiguration intConf = new IntConfiguration(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
                listaIntConf.add(intConf);
                final Multiton multiConf = Multiton.getInstance(combinacion[0], combinacion[1], combinacion[2], combinacion[3]);
                listaMultiConf.add(multiConf);
                final ListConfiguration listConf = ListConfiguration.getConfiguration(creaAbilityArray(combinacion));
                listaListaConf.add(listConf);
            }
            long previo;
            long posterior;
            rt.gc();
            System.out.println();

            try {

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaMultiConf.clear();
                listaMultiConf = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " Multiton; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaBloqueos.clear();
                listaBloqueos = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " Bloqueos; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaListaConf.clear();
                listaListaConf= null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " ListConf; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaCachedC.clear();
                listaCachedC = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " CachedConf; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaDeFactoria.clear();
                listaDeFactoria = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " Factoria; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaIntConf.clear();
                listaIntConf = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " IntConf; ", posterior - previo);

                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                previo = rt.freeMemory();
                listaConf.clear();
                listaConf = null;
                rt.gc(); Thread.sleep(this.PAUSE_LENGTH); rt.gc();
                posterior = rt.freeMemory();
                System.out.format(format + " EnumSet; ", posterior - previo);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     *
     *
     * @return
     */
    private List<boolean[]> dameListaDeCombinaciones(final int numCombinaciones) {
        final List<boolean[]> listaCombinaciones = new ArrayList<>(numCombinaciones);
        for (int i = 0; i < numCombinaciones; i++) {
            // array de aleatorios enteros
            final int [] intCombinacion = dameBloqueos();

            // crear array de booleanos, de la misma longitud;
            final boolean [] combinacion = Arrays.copyOf(this.todasCombinaciones[0], this.todasCombinaciones[0].length);

            // inicializar el array de booleanos dependiendo de los aleatorios enteros
            for (int j = 0; j < this.todasCombinaciones[0].length; j ++) {
                combinacion[j] =  (intCombinacion[j] == 0);
            }

            // almacenar la nueva combinacion de booleanos
            listaCombinaciones.add(combinacion);
        }
        return listaCombinaciones;
    }
}
