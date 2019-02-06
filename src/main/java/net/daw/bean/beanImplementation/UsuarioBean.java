/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean.beanImplementation;

import net.daw.helper.SecureTokenGenerator;
import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import net.daw.bean.genericBeanImplementation.GenericBeanImplementation;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.factory.DaoFactory;
import net.daw.helper.EncodingHelper;

/**
 *
 * @author kevin
 */
public class UsuarioBean extends GenericBeanImplementation implements BeanInterface {

    @Expose
    private String dni;

    @Expose
    private String nombre;

    @Expose
    private String ape1;

    @Expose
    private String ape2;

    @Expose
    private String login;

    @Expose(serialize = false)
    private String pass;

    @Expose
    private String email;

    @Expose(serialize = false)
    private int id_tipousuario;

    @Expose(deserialize = false)
    private TipousuarioBean obj_tipoUsuario;

    @Expose(serialize = false)
    private String token;

    @Expose
    private Boolean validacion;

    @Expose(deserialize = false)
    private int numFactura;

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getValidacion() {
        return validacion;
    }

    public void setValidacion(Boolean validacion) {
        this.validacion = validacion;
    }

    public TipousuarioBean getObj_tipoUsuario() {
        return obj_tipoUsuario;
    }

    public void setObj_tipoUsuario(TipousuarioBean obj_tipoUsuario) {
        this.obj_tipoUsuario = obj_tipoUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_tipousuario() {
        return id_tipousuario;
    }

    public void setId_tipousuario(int id_tipousuario) {
        this.id_tipousuario = id_tipousuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public UsuarioBean fill(ResultSet oResultSet, Connection oConnection, Integer expand, UsuarioBean oUsuarioBeanSession) throws Exception {

        this.setId(oResultSet.getInt("id"));
        this.setDni(oResultSet.getString("dni"));
        this.setNombre(oResultSet.getString("nombre"));
        this.setApe1(oResultSet.getString("ape1"));
        this.setApe2(oResultSet.getString("ape2"));
        this.setLogin(oResultSet.getString("login"));
        this.setPass(oResultSet.getString("pass"));
        this.setEmail(oResultSet.getString("email"));

        DaoInterface oFacturaDao = DaoFactory.getDao(oConnection, "factura", oUsuarioBeanSession);
        this.setNumFactura(oFacturaDao.getcount(this.id, "id_usuario"));

        if (expand > 0) {
            DaoInterface otipousuarioDao = DaoFactory.getDao(oConnection, "tipousuario", oUsuarioBeanSession);
            this.setObj_tipoUsuario((TipousuarioBean) otipousuarioDao.get(oResultSet.getInt("id_tipousuario"), expand - 1));
        } else {
            this.setId_tipousuario(oResultSet.getInt("id_tipousuario"));
        }

        this.setToken(oResultSet.getString("token"));
        this.setValidacion(oResultSet.getBoolean("validacion"));

        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "dni,";
        strColumns += "nombre,";
        strColumns += "ape1,";
        strColumns += "ape2,";
        strColumns += "login,";
        strColumns += "pass,";
        strColumns += "email,";
        strColumns += "id_tipousuario,";
        strColumns += "token,";
        strColumns += "validacion";
        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += "null,";
        strColumns += EncodingHelper.quotate(dni) + ",";
        strColumns += EncodingHelper.quotate(nombre) + ",";
        strColumns += EncodingHelper.quotate(ape1) + ",";
        strColumns += EncodingHelper.quotate(ape2) + ",";
        strColumns += EncodingHelper.quotate(login) + ",";
        strColumns += EncodingHelper.quotate(pass) + ",";
        strColumns += EncodingHelper.quotate(email) + ",";
        strColumns += id_tipousuario + ",";
        strColumns += EncodingHelper.quotate(SecureTokenGenerator.nextToken()) + ",";
        strColumns += 0;
        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "id =" + id + ",";
        strPairs += "dni =" + EncodingHelper.quotate(dni) + ",";
        strPairs += "nombre =" + EncodingHelper.quotate(nombre) + ",";
        strPairs += "ape1 =" + EncodingHelper.quotate(ape1) + ",";
        strPairs += "ape2 =" + EncodingHelper.quotate(ape2) + ",";
        strPairs += "login =" + EncodingHelper.quotate(login) + ",";
        strPairs += "pass =" + EncodingHelper.quotate(pass) + ",";
        strPairs += "email =" + EncodingHelper.quotate(email) + ",";
        strPairs += "id_tipousuario =" + id_tipousuario + ",";
        strPairs += "validacion =" + validacion;
        strPairs += " WHERE id=" + id;
        return strPairs;

    }
}
