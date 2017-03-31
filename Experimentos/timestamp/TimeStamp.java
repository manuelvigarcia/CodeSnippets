/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timestamp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author ManuelVicente
 */
public class TimeStamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File tsfile = null;
        if (args.length > 0) {
            //There are arguments
            for (String arg : args) {
                tsfile = new File(arg);
            }
        }
        if (tsfile == null) {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
            tsfile = new File("TimeStamp" + df.format(new Date()) +".csv");
        }
        FileWriter tsfileWriter = new FileWriter(tsfile, true);
        
        Instant instante = Instant.now();
        Date fecha = Date.from(instante);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd\tHH:mm:ss");   
        tsfileWriter.write(df.format(fecha) + "\n");
        tsfileWriter.close();
    }
    
}
