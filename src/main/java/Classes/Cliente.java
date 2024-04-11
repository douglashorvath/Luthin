/*
 * Desenvolvido por CaffeineDev Softwares e Sites
 * Criado por Douglas Horvath
 */
package Classes;

import Database.Conecta;
import Resources.Formatar;
import Resources.Patterns;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas Horvath
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String rg;
    private String sexo;
    private String estadoCivil;
    private String profissao;
    private String email;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private LocalDate data;
    private LocalTime hora;
    private ArrayList<TelefoneCliente> telefones;
    
    /**
     * Construtor com nome 
     * @param nome  nome a ser setado
     */
    public Cliente(String nome) {
        this.nome = nome;
        
        id = -1;
        cpf = null;
        dataNascimento = null;
        rg = null;
        sexo = null;
        estadoCivil = null;
        profissao = null;
        email = null;
        rua = null;
        numero = -1;
        bairro = null;
        cidade = null;
        estado = null;
        cep = null;
        data = null;
        hora = null;
    }

    /**
     * Construtor com id, resgata o cadastro automáticamente
     * @param id id da cliente
     */
    public Cliente(int id) {
        this.id = id;
    }

    /**
     * Construtor vazio
     */
    public Cliente() {
    }
    
    /**
     * Insere a cliente no banco de dados
     * @return TRUE para inserido ou FALSE para erros
     */
    public boolean insert()
    {
        if(nome == null || "".equals(nome) || Cliente.getCliente(this.cpf) != null)
        {
            return false;
        }
        else
        {
            this.data = LocalDate.now();
            this.hora = LocalTime.now();
            String SQL;
            if(dataNascimento != null)
            {
                SQL = "INSERT INTO CLIENTE (NOME,CPF,DATA_NASCIMENTO,RG,ESTADO_CIVIL,SEXO,PROFISSAO,EMAIL,RUA,NUMERO,BAIRRO,CIDADE,ESTADO,CEP,DATA_CADASTRO,HORA_CADASTRO) "
                        + "VALUES ('"+Formatar.prepareSQL(this.nome.toUpperCase())+"', '"+this.cpf+"', '"+dataNascimento.format(Patterns.YyyyMMdd_dash())+"', '"+this.rg+"', '"+this.estadoCivil+"', '"+this.sexo+"', '"+Formatar.prepareSQL(profissao.toUpperCase())+"', '"+this.email.toLowerCase()+"', '"+Formatar.prepareSQL(this.rua.toUpperCase())+"', "+this.numero+", '"+Formatar.prepareSQL(this.bairro.toUpperCase())+"', '"+Formatar.prepareSQL(this.cidade.toUpperCase())+"', '"+this.estado.toUpperCase()+"', '"+this.cep+"', '"+data.format(Patterns.YyyyMMdd_dash())+"', '"+hora.format(Patterns.HHmm_spots())+"')";
            }
            else
            {
                SQL = "INSERT INTO CLIENTE (NOME,CPF,DATA_NASCIMENTO,RG,ESTADO_CIVIL,SEXO,PROFISSAO,EMAIL,RUA,NUMERO,BAIRRO,CIDADE,ESTADO,CEP,DATA_CADASTRO,HORA_CADASTRO) "
                        + "VALUES ('"+Formatar.prepareSQL(this.nome.toUpperCase())+"', '"+this.cpf+"', '', '"+this.rg.replace(".", "").replace("-", "").trim()+"', '"+this.estadoCivil+"', '"+this.sexo+"', '"+Formatar.prepareSQL(profissao.toUpperCase())+"', '"+this.email.toLowerCase()+"', '"+Formatar.prepareSQL(this.rua.toUpperCase())+"', "+this.numero+", '"+Formatar.prepareSQL(this.bairro.toUpperCase())+"', '"+Formatar.prepareSQL(this.cidade.toUpperCase())+"', '"+this.estado.toUpperCase()+"', '"+this.cep+"', '"+data.format(Patterns.YyyyMMdd_dash())+"', '"+hora.format(Patterns.HHmm_spots())+"')";
            }
            Conecta con = new Conecta();
            if(con.executa(SQL))
            {
                SQL = "SELECT * FROM CLIENTE WHERE NOME LIKE '"+Formatar.prepareSQL(this.nome.toUpperCase())+"' ORDER BY ID DESC FETCH FIRST ROW ONLY";
                ResultSet last = con.consulta(SQL);
                try {
                    if(last.next())
                    {
                        this.id = last.getInt("ID");
                        if(telefones != null)
                        {
                            for(int i=0;i<telefones.size();i++)
                            {
                                telefones.get(i).setIdPaciente(id);
                                telefones.get(i).insert();
                            }
                        }
                        
                        return true;
                    }
                    else
                    {
                        //con.Desconecta();
                        return false;
                    }
                } catch (SQLException ex) {
                    //con.Desconecta();
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            else
            {
                //con.Desconecta();
                return false;
            }
        }
    }
    
    
    
    /**
     * Atualiza a cliente no banco de dados
     * @return TRUE para inserido ou FALSE para erros
     */
    public boolean update()
    {
        if(nome == null || "".equals(nome) || id < 1 || (Cliente.getCliente(cpf) != null && Cliente.getCliente(this.cpf).getId() != this.id))
        {
            return false;
        }
        else
        {
            String sql;
            if(dataNascimento != null)
            {
                sql = "UPDATE CLIENTE SET "
                        + "NOME = '"+Formatar.prepareSQL(this.nome.toUpperCase())+"', "
                        + "CPF = '"+this.cpf.toUpperCase()+"', "
                        + "DATA_NASCIMENTO = '"+this.dataNascimento.format(Patterns.YyyyMMdd_dash())+"', "
                        + "RG = '"+this.rg.toUpperCase()+"', "
                        + "ESTADO_CIVIL = '"+this.estadoCivil+"', "
                        + "SEXO = '"+this.sexo+"', "
                        + "PROFISSAO = '"+this.profissao.toUpperCase()+"', "
                        + "EMAIL = '"+this.email.toLowerCase()+"', "
                        + "RUA = '"+Formatar.prepareSQL(this.rua.toUpperCase())+"', "
                        + "NUMERO = "+this.numero +", "
                        + "BAIRRO = '"+Formatar.prepareSQL(this.bairro.toUpperCase())+"', "
                        + "CIDADE = '"+Formatar.prepareSQL(this.cidade.toUpperCase())+"', "
                        + "ESTADO = '"+this.estado.toUpperCase()+"', "
                        + "CEP = '"+this.cep+"' "
                        + " WHERE ID = "+this.id;
            }
            else{
                sql = "UPDATE CLIENTE SET "
                        + "NOME = '"+Formatar.prepareSQL(this.nome.toUpperCase())+"', "
                        + "CPF = '"+this.cpf.toUpperCase()+"', "
                        + "DATA_NASCIMENTO = '', "
                        + "RG = '"+this.rg.toUpperCase()+"', "
                        + "ESTADO_CIVIL = '"+this.estadoCivil+"', "
                        + "SEXO = '"+this.sexo+"', "
                        + "PROFISSAO = '"+this.profissao.toUpperCase()+"', "
                        + "EMAIL = '"+this.email.toLowerCase()+"', "
                        + "RUA = '"+Formatar.prepareSQL(this.rua.toUpperCase())+"', "
                        + "NUMERO = "+this.numero +", "
                        + "BAIRRO = '"+Formatar.prepareSQL(this.bairro.toUpperCase())+"', "
                        + "CIDADE = '"+Formatar.prepareSQL(this.cidade.toUpperCase())+"', "
                        + "ESTADO = '"+this.estado.toUpperCase()+"', "
                        + "CEP = '"+this.cep+"' "
                        + " WHERE ID = "+this.id;
            }
            Conecta con = new Conecta();
            if(con.executa(sql))
            {
                TelefoneCliente.deleteAll(this.id);
                if(telefones != null)
                {
                    for(int i=0;i<telefones.size();i++)
                    {
                        telefones.get(i).setIdPaciente(id);
                        telefones.get(i).insert();
                    }
                }
                
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
     * Deleta a cliente do banco de dados
     * @return TRUE para deletado ou FALSE para erros
     */
    public boolean delete()
    {
        if(id < 1)
        {
            return false;
        }
        else
        {
            String sql = "DELETE FROM CLIENTE WHERE ID = "+this.id;
            Conecta con = new Conecta();
            if(con.executa(sql))
            {
                sql = "DELETE FROM CLIENTE_TELEFONES WHERE ID_PESSOA = "+this.id;
                con.executa(sql);
                //con.Desconecta();
                //Agendamento.deleteAllPaciente(this.id);
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
     * Resgata um paciente no banco de dados
     * @param id id do pacinte à ser resgatado
     * @return Classe com o paciente resgatado ou null para caso não encontre
     */
    public static final Cliente getCliente(int id)
    {
        if(id < 1)
        {
            return null;
        }
        else
        {
            String sql = "SELECT * FROM CLIENTE WHERE ID = "+id;
            Conecta con = new Conecta();
            ResultSet rs = con.consulta(sql);
            try {
                if(rs.next())
                {
                    
                    Cliente p = new Cliente();
                    p.setId(id);
                    p.setNome(rs.getString("NOME"));
                    p.setCpf(rs.getString("CPF"));
                    if(rs.getString("DATA_NASCIMENTO") != null && !rs.getString("DATA_NASCIMENTO").trim().isEmpty())
                        p.setDataNascimento(LocalDate.parse(rs.getString("DATA_NASCIMENTO"),Patterns.YyyyMMdd_dash()));
                    p.setRg(rs.getString("RG"));
                    p.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                    p.setSexo(rs.getString("SEXO"));
                    p.setProfissao(rs.getString("PROFISSAO"));
                    p.setEmail(rs.getString("EMAIL"));
                    p.setRua(rs.getString("RUA"));
                    p.setNumero(rs.getInt("NUMERO"));
                    p.setBairro(rs.getString("BAIRRO"));
                    p.setCidade(rs.getString("CIDADE"));
                    p.setEstado(rs.getString("ESTADO"));
                    p.setCep(rs.getString("CEP"));
                    p.setData(LocalDate.parse(rs.getString("DATA_CADASTRO"), Patterns.YyyyMMdd_dash()));
                    p.setHora(LocalTime.parse(rs.getString("HORA_CADASTRO"),Patterns.HHmmss_spots()));
                    p.setTelefones(TelefoneCliente.getTelefones(id));
                    //con.Desconecta();
                    return p;
                }
                else
                {
                    //con.Desconecta();
                    return null;
                }
            } catch (SQLException ex) {
                //con.Desconecta();
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
        }
    }
    
    /**
     * Resgata um paciente no banco de dados
     * @param cpf cpf do pacinte à ser resgatado
     * @return Classe com o paciente resgatado ou null para caso não encontre
     */
    public static final Cliente getCliente(String cpf)
    {
        if(cpf == null || cpf.isEmpty())
        {
            return null;
        }
        else
        {
            String sql = "SELECT * FROM CLIENTE WHERE CPF = '"+cpf+"'";
            Conecta con = new Conecta();
            ResultSet rs = con.consulta(sql);
            try {
                if(rs.next())
                {
                    Cliente p = new Cliente();
                    p.setId(rs.getInt("ID"));
                    p.setNome(rs.getString("NOME"));
                    p.setCpf(rs.getString("CPF"));
                    if(rs.getString("DATA_NASCIMENTO") != null && !rs.getString("DATA_NASCIMENTO").trim().isEmpty())
                        p.setDataNascimento(LocalDate.parse(rs.getString("DATA_NASCIMENTO"),Patterns.YyyyMMdd_dash()));
                    p.setRg(rs.getString("RG"));
                    p.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                    p.setSexo(rs.getString("SEXO"));
                    p.setProfissao(rs.getString("PROFISSAO"));
                    p.setEmail(rs.getString("EMAIL"));
                    p.setRua(rs.getString("RUA"));
                    p.setNumero(rs.getInt("NUMERO"));
                    p.setBairro(rs.getString("BAIRRO"));
                    p.setCidade(rs.getString("CIDADE"));
                    p.setEstado(rs.getString("ESTADO"));
                    p.setCep(rs.getString("CEP"));
                    p.setData(LocalDate.parse(rs.getString("DATA_CADASTRO"), Patterns.YyyyMMdd_dash()));
                    p.setHora(LocalTime.parse(rs.getString("HORA_CADASTRO"),Patterns.HHmmss_spots()));
                    p.setTelefones(TelefoneCliente.getTelefones(p.getId()));
                    //con.Desconecta();
                    return p;
                }
                else
                {
                    return null;
                }
            } catch (SQLException ex) {
                //con.Desconecta();
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
   
        /**
     * Resgata uma cliente no banco de dados
     * @param nome nome cliente
     * @param dataNascimento data nascimento
     * @param id id da cliente
     * @return Classe com a cliente resgatado ou null para caso não encontre
     */
    public static final boolean getClienteExistente(String nome, LocalDate dataNascimento, int id)
    {
        if(dataNascimento == null || nome == null || nome.isEmpty())
        {
            return false;
        }
        else
        {
            String sql = "SELECT * FROM CLIENTE WHERE UPPER(NOME) LIKE UPPER('"+nome+"') AND DATA_NASCIMENTO = '"+dataNascimento.format(Patterns.YyyyMMdd_dash())+"'";
            Conecta con = new Conecta();
            ResultSet rs = con.consulta(sql);
            try {
                if(rs.next())
                {
                    Cliente p = new Cliente();
                    p.setId(rs.getInt("ID"));
                    p.setNome(rs.getString("NOME"));
                    p.setCpf(rs.getString("CPF"));
                    if(rs.getString("DATA_NASCIMENTO") != null && !rs.getString("DATA_NASCIMENTO").trim().isEmpty())
                        p.setDataNascimento(LocalDate.parse(rs.getString("DATA_NASCIMENTO"),Patterns.YyyyMMdd_dash()));
                    p.setRg(rs.getString("RG"));
                    p.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                    p.setSexo(rs.getString("SEXO"));
                    p.setProfissao(rs.getString("PROFISSAO"));
                    p.setEmail(rs.getString("EMAIL"));
                    p.setRua(rs.getString("RUA"));
                    p.setNumero(rs.getInt("NUMERO"));
                    p.setBairro(rs.getString("BAIRRO"));
                    p.setCidade(rs.getString("CIDADE"));
                    p.setEstado(rs.getString("ESTADO"));
                    p.setCep(rs.getString("CEP"));
                    p.setData(LocalDate.parse(rs.getString("DATA_CADASTRO"), Patterns.YyyyMMdd_dash()));
                    p.setHora(LocalTime.parse(rs.getString("HORA_CADASTRO"),Patterns.HHmmss_spots()));
                    p.setTelefones(TelefoneCliente.getTelefones(p.getId()));
                    //con.Desconecta();
                    return false;
                }
                else
                {
                    return true;
                }
            } catch (SQLException ex) {
                //con.Desconecta();
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
    
    /**
     * Resgata uma cliente no banco de dados
     * @param nome nome cliente
     * @param dataNascimento data nascimento
     * @return Classe com a cliente resgatado ou null para caso não encontre
     */
    public static final Cliente getCliente(String nome, LocalDate dataNascimento)
    {
        if(dataNascimento == null || nome == null || nome.isEmpty())
        {
            return null;
        }
        else
        {
            String sql = "SELECT * FROM CLIENTE WHERE UPPER(NOME) LIKE UPPER('"+nome+"') AND DATA_NASCIMENTO = '"+dataNascimento.format(Patterns.YyyyMMdd_dash())+"'";
            Conecta con = new Conecta();
            ResultSet rs = con.consulta(sql);
            try {
                if(rs.next())
                {
                    Cliente p = new Cliente();
                    p.setId(rs.getInt("ID"));
                    p.setNome(rs.getString("NOME"));
                    p.setCpf(rs.getString("CPF"));
                    if(rs.getString("DATA_NASCIMENTO") != null && !rs.getString("DATA_NASCIMENTO").trim().isEmpty())
                        p.setDataNascimento(LocalDate.parse(rs.getString("DATA_NASCIMENTO"),Patterns.YyyyMMdd_dash()));
                    p.setRg(rs.getString("RG"));
                    p.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                    p.setSexo(rs.getString("SEXO"));
                    p.setProfissao(rs.getString("PROFISSAO"));
                    p.setEmail(rs.getString("EMAIL"));
                    p.setRua(rs.getString("RUA"));
                    p.setNumero(rs.getInt("NUMERO"));
                    p.setBairro(rs.getString("BAIRRO"));
                    p.setCidade(rs.getString("CIDADE"));
                    p.setEstado(rs.getString("ESTADO"));
                    p.setCep(rs.getString("CEP"));
                    p.setData(LocalDate.parse(rs.getString("DATA_CADASTRO"), Patterns.YyyyMMdd_dash()));
                    p.setHora(LocalTime.parse(rs.getString("HORA_CADASTRO"),Patterns.HHmmss_spots()));
                    p.setTelefones(TelefoneCliente.getTelefones(p.getId()));
                    //con.Desconecta();
                    return p;
                }
                else
                {
                    return null;
                }
            } catch (SQLException ex) {
                //con.Desconecta();
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }
    
    public static final ArrayList<Cliente> getClientes(String busca)
    {
        if(busca == null || busca.isEmpty())
        {
            return null;
        }
        else
        {
            
            ArrayList<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM CLIENTE WHERE UPPER(NOME) LIKE UPPER('%"+busca+"%') OR CPF LIKE '%"+busca+"%' ORDER BY NOME ASC";
            Conecta con = new Conecta();
            ResultSet rs = con.consulta(sql);
            try {
                while(rs.next())
                {
                    Cliente p = new Cliente();
                    p.setId(rs.getInt("ID"));
                    p.setNome(rs.getString("NOME"));
                    p.setCpf(rs.getString("CPF"));
                    System.out.println(rs.getString("DATA_NASCIMENTO"));
                    if(rs.getString("DATA_NASCIMENTO") != null && !rs.getString("DATA_NASCIMENTO").trim().isEmpty())
                        p.setDataNascimento(LocalDate.parse(rs.getString("DATA_NASCIMENTO"),Patterns.YyyyMMdd_dash()));
                    p.setRg(rs.getString("RG"));
                    p.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                    p.setSexo(rs.getString("SEXO"));
                    p.setProfissao(rs.getString("PROFISSAO"));
                    p.setEmail(rs.getString("EMAIL"));
                    p.setRua(rs.getString("RUA"));
                    p.setNumero(rs.getInt("NUMERO"));
                    p.setBairro(rs.getString("BAIRRO"));
                    p.setCidade(rs.getString("CIDADE"));
                    p.setEstado(rs.getString("ESTADO"));
                    p.setCep(rs.getString("CEP"));
                    p.setData(LocalDate.parse(rs.getString("DATA_CADASTRO"), Patterns.YyyyMMdd_dash()));
                    p.setHora(LocalTime.parse(rs.getString("HORA_CADASTRO"),Patterns.HHmmss_spots()));
                    p.setTelefones(TelefoneCliente.getTelefones(p.getId()));
                    clientes.add(p);
                }
            } catch (SQLException ex) {
                //con.Desconecta();
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            if(clientes.isEmpty())
            {
                //con.Desconecta();
                return null;
            }
            else{
                //con.Desconecta();
                return clientes;
            }
        }
    }
    
    /**
     * 
     * @return id da cliente
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id da cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return nome da cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome nome da cliente
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    /**
     *
     * @return CPF da cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     *
     * @param cpf CPF da cliente
     */
    public void setCpf(String cpf) {
        if(cpf == null)
        {
            this.cpf = "";
        }
        else
        {
            this.cpf = cpf.toUpperCase().replace(".", "").replace("-", "").replace(" ", "");;
        }
    }

    /**
     *
     * @return rua da cliente
     */
    public String getRua() {
        return rua;
    }

    /**
     *
     * @param rua rua da cliente
     */
    public void setRua(String rua) {
        this.rua = rua.toUpperCase();
    }

    /**
     *
     * @return numero da rua da cliente
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero da rua da cliente
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return bairro da cliente
     */
    public String getBairro() {
        return bairro;
    }

    /**
     *
     * @param bairro bairro da cliente
     */
    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    /**
     *
     * @return cidade da cliente
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade cidade da cliente
     */
    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    /**
     *
     * @return estado da cliente
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado estado da cliente
     */
    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }

    /**
     *
     * @return CEP da cliente
     */
    public String getCep() {
        return cep;
    }

    /**
     *
     * @param cep CEP da cliente
     */
    public void setCep(String cep) {
        this.cep = cep.toUpperCase();
    }

    /**
     *
     * @return Data do cadastro realizado da cliente
     */
    public LocalDate getData() {
        return data;
    }

    /**
     *
     * @param data data cadastrada
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     *
     * @return Hora do cadastro realizado da cliente
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     *
     * @param hora hora cadastrada
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ArrayList<TelefoneCliente> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<TelefoneCliente> telefones) {
        this.telefones = telefones;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Period getIdade()
    {
        LocalDate hoje = LocalDate.now();
        Period dif = Period.between(getDataNascimento(), hoje); 
        return dif;
    }

    
}
