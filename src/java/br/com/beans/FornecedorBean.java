/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beans;

import br.com.Model.Fornecedor;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIForm;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    private int id;
    private String cnpj;
    private String razao;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void get_fornecedor(FornecedorBean fornecedor) throws SQLException, IOException {
        
        FornecedorBean f = new FornecedorBean();
        f.setRazao(fornecedor.getRazao());
        f.setCnpj(fornecedor.getCnpj());
        java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/Mercearia", "root", "root");
        String sql = "INSERT INTO FORNECEDOR(id,razao,cnpj)values(?,?,?);";
        try (PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql)) {
            pst.setInt(1, 103);
            pst.setString(2, f.getRazao().toUpperCase());
            pst.setString(3, f.getCnpj().toUpperCase());
            pst.execute();
        } catch (SQLDataException ex) {
            // UIForm form = form.getFacet("form");
            FacesContext.getCurrentInstance().getExternalContext().redirect("../erro.xhtml");

        }
        FacesMessage fm = new FacesMessage("Inserido");
        // FacesContext.getCurrentInstance().getExternalContext().dispatch(sql);
        FacesContext.getCurrentInstance().addMessage("Inserido", fm);

    }
}
