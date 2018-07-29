/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.Model.Fornecedor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author gustavoscipiao
 */
@ManagedBean(name = "FornecedorBean")
@SessionScoped
public class FornecedorBean {
    private Fornecedor fornecedor;
    /**
     * Creates a new instance of FornecedorBean
     */
    public FornecedorBean() {
        
        
        
        
    }
   

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    public void get_fornecedor(Fornecedor fornecedor)throws SQLException{
        java.sql.Connection con = DriverManager.getConnection("jdbc://mysql://localhost:8889/Mercearia", "root", "root");
        String sql = "INSERT INTO FORNECEDOR(id,razao,cnpj)values(?,?);";
        PreparedStatement pst = (PreparedStatement)con.prepareStatement(sql);
        pst.setString(2,fornecedor.getRazao().toUpperCase());
        pst.setString(3, fornecedor.getCnpj().toUpperCase());
        pst.execute();
        
        FacesMessage fm = new FacesMessage("Inserido");
        FacesContext.getCurrentInstance().addMessage("Inserido", fm);
        
    }
}
