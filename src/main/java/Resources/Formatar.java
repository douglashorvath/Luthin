/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;
import javax.swing.text.MaskFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

/**
 *
 * @author Douglas
 */
public class Formatar {
    
    /**
     * Formata um objeto de acordo com uma máscara específica
     * @param pattern Padrão (máscara) específica
     * @param value Objeto à ser formatado
     * @return String com o objeto formatado
     */
    public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String prepareSQL(String text)
    {
        if(text == null)
            return null;
        return text.replace("'", "''");
    }
    
    public static String fixBreakLineSQL(String text)
    {
        if(text != null)
            return text.replace("\n", "<br>");
        else
            return "";
    }
    
    public static String unfixBreakLineSQL(String text)
    {
        if(text != null)
            return text.replace("<br>", "\n");
        else
            return "";
    }
        
     /**
     * Formata um número para um padrão com 2 casas decimais
     * @param numero número à ser formatado
     * @return String com o número já formatado
     */
    public static String paraMoeda(float numero)
    {
        String retorno = "";  
        DecimalFormat formatter = new DecimalFormat("#.00");  
        formatter.setRoundingMode(RoundingMode.UP);
        try{  
          retorno = formatter.format(numero);  
            System.out.println(retorno);
          if(",00".equals(retorno))
          {
              retorno = "0,00";
          }
        }catch(Exception ex){  
          System.err.println("Erro ao formatar numero: " + ex);  
        }  
        return retorno;  
    }
    
    /**
     * Formata um número para um padrão de porcentagem
     * @param numero número à ser formatado
     * @return String com o número já formatado
     */
    public static String paraPorcentagem(float numero)
    {
        String retorno = "";  
        DecimalFormat formatter = new DecimalFormat("#.00");  
        formatter.setRoundingMode(RoundingMode.UP);
        try{  
          retorno = formatter.format(numero).replace(".", ",");  
          if(",00".equals(retorno))
          {
              retorno = "0,00";
          }
        }catch(Exception ex){  
          System.err.println("Erro ao formatar numero: " + ex);  
        }  
        return retorno;  
    }
    
    /**
     * Formata um número para um padrão inteiro (ignora frações)
     * @param numero  número à ser formatado
     * @return String com o número já formatado
     */
    public static String paraInteiro(float numero)
    {
        
        String retorno = "";  
        DecimalFormat formatter = new DecimalFormat("#");  
        formatter.setRoundingMode(RoundingMode.UP);
        try{  
          retorno = formatter.format(numero);  
        }catch(Exception ex){  
          System.err.println("Erro ao formatar numero: " + ex);  
        }  
        return retorno;  
//        String retorno = String.valueOf(Math.floor(numero));
//        
//        return retorno;  
    }
    
    /**
     * Formata uma string retirando todos os caracteres acentuados e substituindo-os pelos seus respectivos sem acento
     * @param str string à ser formatada
     * @return string sem caracteres acentuados
     */
    public static String semAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String rtfToHtml(Reader rtf) throws IOException {
        JEditorPane p = new JEditorPane();
        p.setContentType("text/rtf");
        EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
        try {
            kitRtf.read(rtf, p.getDocument(), 0);
            kitRtf = null;
            EditorKit kitHtml = p.getEditorKitForContentType("text/html");
            Writer writer = new StringWriter();
            kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
            return writer.toString();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String html2text(String html) {
        String text = Jsoup.parse(html.replaceAll("</p>", "brtrbr")).text();
        int breakLines = text.split("brtrbr").length;
        System.out.println("HTML@TEXT: "+text);
        while(text.trim().startsWith("brtrbr"))
        {
            text = text.replaceFirst("brtrbr", "");
        }
        for(int i=0;i<breakLines/2;i++)
        {
            text = text.replace("brtrbr brtrbr", "brtrbr");
        }
        while(text.trim().endsWith("brtrbr"))
        {
            text = replaceLast(text, "brtrbr", "");
        }
        System.out.println("HTML@TEXT-DONE: "+text);
        return text.replaceAll("brtrbr", "\n");
    }
    
    public static String br2nl(String html) {
        if(html==null)
            return html;
        Document document = Jsoup.parse(html);
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
        document.select("br").append("\\n");
        document.select("p").prepend("\\n");
        String s = document.html().replaceAll("\\\\n", "\n");
        return Jsoup.clean(s, "", new Safelist(), new Document.OutputSettings().prettyPrint(false));
    }
    
    public static String rtfToText(Reader rtf)
    {
        try {
            String sRtf = rtfToHtml(rtf);
            sRtf = html2text(sRtf);
            return sRtf;
        } catch (IOException ex) {
            Logger.getLogger(Formatar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }
    
    public static String formatCNPJ(String cnpj){
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cnpj);
        } catch (ParseException ex) {
            Logger.getLogger(Patterns.class.getName()).log(Level.SEVERE, null, ex);
            return cnpj;
        }
    }
    
    public static String formatCPF(String cpf){
        try {
            MaskFormatter mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cpf);
        } catch (ParseException ex) {
            Logger.getLogger(Patterns.class.getName()).log(Level.SEVERE, null, ex);
            return cpf;
        }
    }
    
    public static String formatRG(String rg){
        try {
            MaskFormatter mask = new MaskFormatter("##.###.###-#");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(rg);
        } catch (ParseException ex) {
            Logger.getLogger(Patterns.class.getName()).log(Level.SEVERE, null, ex);
            return rg;
        }
    }
}
