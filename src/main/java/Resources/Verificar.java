/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import Database.Conexao;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Doug
 */
public class Verificar {
    
    private Conexao conectar;
    private DefaultTableModel modelo;
    private javax.swing.JTable jtDados;

    /**
     * Construtor que pega a conexão com o banco
     * @param conexao Conexão com o banco
     */
    public Verificar(Conexao conexao) {
        conectar = conexao;
    }

    /**
     * Construtor vazio
     */
    public Verificar() {
    }
    
    /**
     * Verifica se um CPF específico existe em uma tabela informada
     * @param cpf cpf para verificação
     * @param tabela tabela desejada
     * @return TRUE para encontrado FALSE para não encontrado ou erros
     */
    public boolean verificaCpfExistente(String cpf, String tabela)
    {
        if(!conectar.isConnected() || conectar == null)
            return false;
        boolean existente=false;
        String sql;
        ResultSet rs;
        sql = "SELECT CPF FROM "+tabela;  
        rs=conectar.consultar(sql);
        String confere;
        try {
            while (rs.next())
            {
                confere=rs.getString("CPF");
                if(confere.equals(cpf))
                    existente=true;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        if(existente)
            return true;
        else
            return false;

    }
    
    /**
     * Verifica se o CPF é válido
     * @param cpf cpf para verificação
     * @return TRUE para válido e FALSE para inválido
     */
    public static final boolean verificaCpf(String cpf)
    {
        char c;
        int aux,soma,resto;
                
        if(cpf.length()!= 11)
        {
                //System.out.print("ERRADO");
                return false;
        }
        else
        {
            soma=0;
            int j=10;
            for(int i=0;i<9;i++)
            {
                    c=cpf.charAt(i);
                    aux=Character.digit(c,10);
                    soma=soma+(aux*j);
                    //System.out.println("SOMA: " +soma);
                    j--;
            }
            resto=soma%11;
            //System.out.println("RESTO: " +resto);
            resto=11-resto;
            if(resto==10 || resto==11)
                    resto=0;
            c=cpf.charAt(9);
            aux=Character.digit(c,10);
            //System.out.println("char 9: " + aux + "resto: " +resto);
            if(aux!=resto)
                    return false;
            else
            {
                    soma=0;
                    j=11;
                    for(int i=0;i<10;i++)
                    {
                            c=cpf.charAt(i);
                            aux=Character.digit(c,10);
                            soma=soma+(aux*j);
                            j--;
                    }
                    resto=soma%11;
                    resto=11-resto;
                    if(resto==10 || resto==11)
                            resto=0;
                    c=cpf.charAt(10);
                    aux=Character.digit(c,10);
                    if(aux==resto)
                            return true;
                    else
                            return false;
            }	
        }
    }
    
    /**
     * Verifica se em uma determinada string só tem letras validando também pontos, espaços e acentuações
     * @param str1 String para verificação
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean soLetras(String str1)           
    {
        char[] str;
        str=str1.toCharArray();
        if(str1.length()==0)
        {
            return false;
        }
        for(int i=0;i<str1.length();i++)
        {
            if(!((str[i]>96 && str[i]<123)|| (str[i]>64 && str[i]<91) || str[i]=='.' || str[i]==' ' || str[i]=='ã' || str[i]=='Ã' || str[i] == 'é' || str[i]=='á' || str[i] == 'Á' || str[i]=='É' || str[i]=='ó' || str[i] == 'Ó' || str[i] =='ú' || str[i]=='Ú' || str[i]=='ç' || str[i]=='Ç' || str[i]=='í' || str[i]=='Í' || str[i]=='õ' || str[i]=='Õ' || str[i]=='â' || str[i]=='Â' || str[i] == 'ê' || str[i] == 'Ê' || str[i]=='ô' || str[i]=='Ô' ))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Verifica se em uma determinada string só tem letras exclusivamente
     * @param str1 String para verificação
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean soLetrasAbs(String str1)
    {
        char[] str;
        str=str1.toCharArray();
        if(str1.length()==0)
        {
            return false;
        }
        for(int i=0;i<str1.length();i++)
        {
            if(!((str[i]>96 && str[i]<123)|| (str[i]>64 && str[i]<91)))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     *Verifica se em uma determinada string só tem números
     * @param str1 String para verificação
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean soNumeros(String str1)
    {
        char[] str;
        str=str1.toCharArray();
        if(str1.length()==0)
        {
            return false;
        }
        else
        {
            for(int i=0;i<str1.length();i++)
            {    
                if((str[i]<48 || str[i]>57) && str[i] != '.' && str[i] != ',')
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     *Verifica se em uma determinada string só tem números inteiros
     * @param str1 String para verificação
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean soInt(String str1)
    {
        char[] str;
        str=str1.toCharArray();
        if(str1.length()==0)
        {
            return false;
        }
        else
        {
            for(int i=0;i<str1.length();i++)
            {    
                if((str[i]<48 || str[i]>57))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Verifica se uma string contém um email válido
     * @param email string contendo um email
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean validEmail(String email) {
    System.out.println("Metodo de validacao de email");
    if(email == null)
        return false;
    else
    {
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
        Matcher m = p.matcher(email); 
        if (m.find()){
          System.out.println("O email "+email+" e valido");
          return true;
        }
        else{
          System.out.println("O E-mail "+email+" é inválido");
          return false;
        }  
    }
    
    
 }
    
    /**
     * Verifica se uma string contém uma hora válida
     * @param hora String contendo uma hora
     * @return TRUE para verificado e FALSE para erros
     */
    public static final boolean validaHora(String hora)
    {
        String[] hms = hora.split(":");   
          
        int horas = Integer.parseInt( hms[0]);  
        int minutos = Integer.parseInt( hms[1]);  
          
        if(horas>23 || horas <0){  
            return false;
        } 
        if(minutos>59 || minutos < 0)
        {
            return false;
        }
        return true;
    }
    

    public static final boolean toSql(String text)
    {
        return !(text.contains("'") || text.contains("\"") || text.contains("\\|"));
    }

}
