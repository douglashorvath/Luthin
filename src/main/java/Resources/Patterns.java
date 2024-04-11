/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 * Classe com padrões utilizáveis
 * @author Douglas Horvath (douglashorvath@icloud.com)
 */
public class Patterns {
    
    /**
     * Formatar um DateTime para um padrão desejado
     * @param pattern padrão desejado
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter format(String pattern)
    {
        Locale local = new Locale("pt", "BR");
        return DateTimeFormatter.ofPattern(pattern);
    }
    
    /**
     * Formatar um DateTime para o padrão yyyy-MM-dd HH:mm:ss
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter toTimestamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
    
    public static final DateTimeFormatter fromTimestamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
    }

    /**
     * Formatar um DateTime para o padrão dd-MM-yyyy
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter DdMMyyyy_dash() {
        return DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    /**
     * Formatar um DateTime para o padrão yyyy-MM-dd
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter YyyyMMdd_dash() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    /**
     * Formatar um DateTime para o padrão dd/mm/yyyy
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter DdMMyyyy_slash() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    /**
     * Formatar um DateTime para o padrão dd/mm/yyyy
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter DdMM_slash() {
        return DateTimeFormatter.ofPattern("dd/MM");
    }

    /**
     * Formatar um DateTime para o padrão yyyy/MM/dd
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter YyyyMMdd_slash() {
        return DateTimeFormatter.ofPattern("yyyy/MM/dd");
    }
    
    /**
     * Formatar um DateTime para uma data por exenso
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter Data_extenso() {
        Locale local = new Locale("pt", "BR");
        return DateTimeFormatter.ofPattern("EEEE',' dd 'de' MMMM 'de' yyyy", local);
        

    }

    
    /**
     * Formatar um DateTime para o padrão HH:mm
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter HHmm_spots() {
        return DateTimeFormatter.ofPattern("HH:mm");
    }
    
    /**
     * Formatar um DateTime para o padrão HH-mm
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter HHmm_dash() {
        return DateTimeFormatter.ofPattern("HH-mm");
    }
    
    /**
     * Formatar um DateTime para o padrão HH:mm:ss
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter HHmmss_spots() {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }
    
    /**
     * Formatar um DateTime para o padrão HH-mm-ss
     * @return Formatter com o padrão específico
     */
    public static final DateTimeFormatter HHmmss_dash() {
        return DateTimeFormatter.ofPattern("HH-mm-ss");
    }
    

    
    
}
