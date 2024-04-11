/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Caffeine
 */
public class Conecta {
    
    
    private Conexao conexao;

    public Conecta() {
        
        conectaBanco();
    }
    
    
    
    public void Desconecta()
    {
        try {
            conexao.Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean isConected()
    {
        return conexao.isConnected();
    }
    
    public void conectaBanco()
    {
        String conexao;
        
        conexao = "jdbc:derby:LuthinDB;create=true";
        
        this.conexao = new Conexao(conexao);
        if(this.conexao.isConnected())
        {
            System.out.println("Conectado ao banco: "+conexao);
        }
        else
        {
            System.out.println("erro ao conectar-se ao banco");
            //JOptionPane.showMessageDialog(null, "Erro ao conectar-se ao banco de dados. Altere o arquivo location.database");
            //System.exit(0);
        }
    }

    public Conexao getConexao() {
        return conexao;
    }
    
    public ResultSet consulta(String sql)
    {
        
        ResultSet rs = conexao.consultar(sql);
        return rs;
        
    }
    
    public boolean executa(String sql)
    {
        return conexao.manipular(sql);
    }
    
    public boolean executa(PreparedStatement sql)
    {
        return conexao.manipular(sql);
    }
    
    public boolean executa(String[] batch)
    {
        return conexao.manipular(batch);
    }
    
    public int getPK(String tabela, String chave)
    {
        return conexao.getMaxPK(tabela, chave)+1;
    }
    
    
    public PreparedStatement prepareStatement(String sql)
    {
        return conexao.prepareStatement(sql);
    }
     
    /**
     * Retorna se a tabela está vazia.
     * @param tabela Tabela à ser analizada;
     * @return  True para vazia e false para com dados;
     */
    public boolean isEmpty(String tabela)
    {
        ResultSet rs = consulta("SELECT * FROM " + tabela);
        try {
            return !rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public ResultSet getAll(String tabela)
    {
        return consulta("SELECT * FROM " + tabela);
    }
    
    public DatabaseMetaData getMetaData() throws SQLException
    {
        return conexao.getMetaData();
    }
    
    public static final String getMacAddress(){
            InetAddress localHost;
        try {
            localHost = InetAddress.getLocalHost();
            NetworkInterface netInter = NetworkInterface.getByInetAddress( localHost );
            byte[] macAddressBytes = netInter.getHardwareAddress();

            String macAddress =  String.format ( "%1$02x-%2$02x-%3$02x-%4$02x-%5$02x-%6$02x",
            macAddressBytes[0], macAddressBytes[1],
            macAddressBytes[2], macAddressBytes[3],
            macAddressBytes[4], macAddressBytes[5] ).toUpperCase();

            return macAddress;
            
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  }
    
    
    public PreparedStatement prepareStatement(String sql, String[] idColumn)
    {
        return conexao.prepareStatement(sql,idColumn);
    }
}
