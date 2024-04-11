/*
* Realiza a conexão com o banco de dados, e cria as devidas ligações para que se possa trabalhar com o mesmo.
*/


package Database;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class Conexao implements Serializable {
    private Connection conexao;
    private String mensagem;
    private String url;

    //contrutor que recebe a String de conexão, o usuário e senha do banco e realiza a conexão com o banco.
    public Conexao(String url) {
        this.url=url;
        refresh();
    }
    
    public void refresh()
    {
        if(isConnected())
            try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao = null;
        try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                conexao=DriverManager.getConnection(url);
        }
        catch(ClassNotFoundException c)
        { mensagem = "ERRO Diver JDBC: "+c.getMessage(); 
            System.out.println(mensagem);}
        catch (SQLException s)
        { mensagem = "ERRO Sql/Banco: "+s.getMessage();  
            System.out.println(mensagem);}
        catch (Exception e)
        { mensagem = "Outro erro: "+e.getMessage();      
            System.out.println(mensagem);}
    }
    
    
    public boolean isConnected()
    {
        if (conexao==null)
            return false;
        else
        {
            try {
                return conexao.isValid(100);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
    
    //retorna a mensagem de erro, se houver.
    public String getMensagem() {
        return mensagem;
    }
    
    public void Desconectar() throws SQLException
    {
        if(conexao != null)
        {
            conexao.close();
            conexao=null;

            System.out.println("Desconectado.");
        }
    }
    
    //recebe uma String com o SQL e executa esse SQL no banco, retornando true, em caso de sucesso e false em caso de erro.
    //Esse método deve ser usado para INSERT, UPDATE e DELETE.
    public boolean manipular(String sql) {
        mensagem = "";
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            //st.close();
            return true;
        }
        catch (SQLException s)
        { mensagem = "ERRO Sql/Banco: "+s.getMessage();  
            System.out.println(mensagem);}
        catch (Exception e)
        { mensagem = "Outro erro: "+e.getMessage();      
            System.out.println(mensagem);}
        return false;
    }
    
    //recebe uma String com o SQL e executa esse SQL no banco, retornando true, em caso de sucesso e false em caso de erro.
    //Esse método deve ser usado para INSERT, UPDATE e DELETE.
    public boolean manipular(PreparedStatement sql) {
        mensagem = "";
        try {
            sql.execute();
            sql.close();
            return true;
        }
        catch (SQLException s)
        { mensagem = "ERRO Sql/Banco: "+s.getMessage();  
            System.out.println(mensagem);}
        catch (Exception e)
        { mensagem = "Outro erro: "+e.getMessage();      
            System.out.println(mensagem);}
        return false;
    }
    
    public PreparedStatement prepareStatement(String sql)
    {
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //recebe um array de Strings com o SQL e executa todos os SQL do array no banco, retornando true, em caso de sucesso e false em caso de erro.
    //Esse método deve ser usado para INSERT, UPDATE e DELETE.
    public boolean manipular(String[] batch) {
        mensagem = "";
        try {
            Statement st = conexao.createStatement();
            for (String bat : batch) {
                st.addBatch(bat);
            }
            st.executeBatch();
            
            //st.close();
            return true;
        }
        catch (SQLException s)
        { mensagem = "ERRO Sql/Banco: "+s.getMessage();  
            System.out.println(mensagem);
            System.out.println(s.getNextException());
        }
        catch (Exception e)
        { mensagem = "Outro erro: "+e.getMessage();      
            System.out.println(mensagem);}
        return false;
    }
    
    //executa uma consulta no banco recebendo como parâmetro um SQL, retorna um ResultSet contendo os valores encontrados,
    //se nenhum valor for encontrado, retorna um ResultSet vazio. Esse método deve ser usado para SELECT.
    public ResultSet consultar(String sql)
    {   
        ResultSet rs=null;
        try {
           Statement statement = conexao.createStatement(
           ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
           rs = statement.executeQuery( sql );
           //conexao.close();
           //st.close();
           
           
        }
        catch ( SQLException sqlex )
        { 
          
          mensagem="Erro: "+sqlex.toString();
          System.out.println(mensagem);
          return null;
        }
        return rs;
    }
    
    //Recebe o nome da tabela e um campo-chave, e retorna o maior (ou ultimo, caso esse campo-chave seja realmente um primary-key)
    //do campo recebido por parâmetro, na tabela também recebida por parâmetro.
    public int getMaxPK(String tabela,String chave) 
    {   String sql="select max("+chave+") from "+tabela;
        int max=0; ResultSet rs=null;
        try {
             Statement statement = conexao.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             rs = statement.executeQuery( sql );  
             if(rs.next()) max=rs.getInt(1);
             statement.close();
         }
         catch ( SQLException sqlex ) 
         {   mensagem="Erro: "+sqlex.toString();
             System.out.println(mensagem);
             return -1;
         }
         return max;  
    }

    public Connection getConexao() {
        return conexao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public DatabaseMetaData getMetaData() throws SQLException
    {
        return conexao.getMetaData();
    }
    
    
    public PreparedStatement prepareStatement(String sql, String[] idColumn)
    {
        try {
            return conexao.prepareStatement(sql, idColumn);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
