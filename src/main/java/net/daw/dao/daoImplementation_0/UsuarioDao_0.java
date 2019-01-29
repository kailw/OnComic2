package net.daw.dao.daoImplementation_0;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.genericDaoImplementation.GenericDaoImplementation;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.helper.EnviarCorreo;

/**
 *
 * @author Ramón
 */
public class UsuarioDao_0 extends GenericDaoImplementation implements DaoInterface {

    public UsuarioDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, ob, oUsuarioBeanSession);

    }

    @Override
    public BeanInterface get(int id, Integer expand) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public int remove(int id) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public int getcount(int id, String campo) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

//    @Override
//    public BeanInterface create(BeanInterface oBean) throws Exception {
//        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
//    }
//    @Override
//    public int update(BeanInterface oBean) throws Exception {
//        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
//    }

    @Override
    public ArrayList<BeanInterface> getpageX(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand, int idAjena, String campo) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

    public UsuarioBean login(String strUserName, String strPassword) throws Exception {
        String strSQL = "SELECT * FROM " + ob + " WHERE login=? AND pass=? AND validacion=true";
        UsuarioBean oUsuarioBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setString(1, strUserName);
            oPreparedStatement.setString(2, strPassword);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean = new UsuarioBean();
                oUsuarioBean.fill(oResultSet, oConnection, 1, oUsuarioBeanSession);
            } else {
                oUsuarioBean = null;
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao get de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oUsuarioBean;
    }

    @Override
    public BeanInterface create(BeanInterface oBean) throws Exception {
        UsuarioBean oUsuarioBean = (UsuarioBean) super.create(oBean);
        int id = oUsuarioBean.getId();
        String emailDestinatario, nombreUsuario, loginUsuario, passUsuario, token;
        if (id > 0) {
            try {
                oUsuarioBean = (UsuarioBean) super.get(oUsuarioBean.getId(), 1);
                emailDestinatario = oUsuarioBean.getEmail();
                nombreUsuario = oUsuarioBean.getNombre();
                loginUsuario = oUsuarioBean.getLogin();
                passUsuario = oUsuarioBean.getPass();
                token = oUsuarioBean.getToken();
                EnviarCorreo.enviarConGMail(emailDestinatario, nombreUsuario, loginUsuario, passUsuario, token);

            } catch (Exception ex) {
                throw new Exception("Error en Dao create de " + ob + ": " + ex.getMessage(), ex);
            }

            return oUsuarioBean;
        } else {
            throw new Exception("Error en Dao update de " + ob + ": No autorizado");
        }
    }

    public UsuarioBean activar(String strUserName, String strPassword, String strToken) throws Exception {
        String strSQL = "SELECT * FROM " + ob + " token=?";
        UsuarioBean oUsuarioBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
//            oPreparedStatement.setString(1, strUserName);
//            oPreparedStatement.setString(2, strPassword);
            oPreparedStatement.setString(1, strToken);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oUsuarioBean = new UsuarioBean();
                oUsuarioBean.fill(oResultSet, oConnection, 1, oUsuarioBeanSession);
                strSQL_update = "UPDATE " + ob + " SET validacion = 1 WHERE id=" + oUsuarioBean.getId();
                this.update(oUsuarioBean);
            } else {
                oUsuarioBean = null;
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao get de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oUsuarioBean;
    }

    @Override
    public int update(BeanInterface oBean) throws Exception {
        int iResult = 0;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL_update);
            iResult = oPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Error en Dao update de " + ob, e);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iResult;
    }

}
