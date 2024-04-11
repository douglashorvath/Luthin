/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Database.Conecta;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Horvath
 */
public class TelefoneCliente {
    
    private int idPessoa;
    private String tipo; // "FIXO" ou "MOVEL";
    private String telefone;

    /**
     * Construtor Vazio
     */
    public TelefoneCliente() {
    }
    
    /**
     * Insere telefones do paciente
     * @return  true para inserdo e false para erro
     */
    public boolean insert()
    {
        if(idPessoa>-1 && !tipo.isEmpty() && !telefone.isEmpty())
        {
            String sql = "INSERT INTO PESSOAL_TELEFONES (ID_PESSOA,TIPO,TELEFONE) VALUES ("+idPessoa+", '"+tipo+"', '"+telefone+"')";
            Conecta con = new Conecta();
            if(con.executa(sql))
            {
                //con.Desconecta();
                return true;
            }
            else
            {
                //con.Desconecta();
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    
    
    /**
     *
     * @param idPaciente id do paciente
     * @return ArrayList com todos os telefones do paciente
     */
    public static final ArrayList<TelefoneCliente> getTelefones(int idPaciente)
    {
        ArrayList<TelefoneCliente> tel = new ArrayList<>();
        String sql = "SELECT * FROM PESSOAL_TELEFONES WHERE ID_PESSOA = "+idPaciente;
        Conecta con = new Conecta();
        ResultSet rs = con.consulta(sql);
        try {
            TelefoneCliente t;
            while(rs.next())
            {
                t = new TelefoneCliente();
                t.setIdPaciente(rs.getInt("ID_PESSOA"));
                t.setTipo(rs.getString("TIPO"));
                t.setTelefone(rs.getString("TELEFONE"));
                tel.add(t);
            }
            if(tel.isEmpty())
            {
                //con.Desconecta();
                return null;
            }
            else
            {
                //con.Desconecta();
                return tel;
            }
        } catch (SQLException ex) {
            //con.Desconecta();
            Logger.getLogger(TelefoneCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static final boolean deleteAll(int idPaciente)
    {
        if(idPaciente < 1)
        {
            return false;
        }
        else
        {
            String sql = "DELETE FROM PESSOAL_TELEFONES WHERE ID_PESSOA = "+idPaciente;
            Conecta con = new Conecta();
            if(con.executa(sql))
            {
                //con.Desconecta();
                return true;
            }
            else
            {
                //con.Desconecta();
                return false;
            }
        }
    }

    /**
     * Pega o id do Paciente
     * @return id do Paciente
     */
    public int getIdPaciente() {
        return idPessoa;
    }

    /**
     * Seta o id do paciente
     * @param idPaciente id do paciente
     */
    public void setIdPaciente(int idPaciente) {
        this.idPessoa = idPaciente;
    }

    /**
     * Retorna o tipo do telefone
     * @return tipo do telefone ["FIXO" ou "MOVEL"]
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Seta o tipo do telefone, caso o valor seja inválido, seta null
     * @param tipo tipo do telefone ["FIXO" ou "MOVEL"]
     */
    public void setTipo(String tipo) {
        
        if(tipo.equals("FIXO") || tipo.equals("MOVEL"))
            this.tipo = tipo;
        else
            this.tipo = null;
    }

    /**
     * Retorna o número do telefone
     * @return número do telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Seta o número do telefone
     * @param telefone número do telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    

}
