/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao.genericDaoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.factory.BeanFactory;
import net.daw.helper.SqlBuilder;

/**
 *
 * @author a024465169t
 */
public class GenericDaoImplementation implements DaoInterface {

    protected Connection oConnection;
    protected String ob = null;
    protected UsuarioBean oUsuarioBeanSession;
    protected int idSessionUser;
    protected int idSessionUserTipe;
    protected String strSQL_get;
    protected String strSQL_remove;
    protected String strSQL_getcount;
    protected String strSQL_create;
    protected String strSQL_update;
    protected String strSQL_getpage;

    public GenericDaoImplementation(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        this.oConnection = oConnection;
        this.ob = ob;
        if (oUsuarioBeanSession != null) {
            this.oUsuarioBeanSession = oUsuarioBeanSession;
            this.idSessionUser = oUsuarioBeanSession.getId();
            this.idSessionUserTipe = oUsuarioBeanSession.getId_tipousuario();
        }

        //Sacadas todas las sentencias SQL de los metodos
        strSQL_get = "SELECT * FROM " + ob + " WHERE id=?";
        strSQL_remove = "DELETE FROM " + ob + " WHERE id=?";
//        strSQL_getcount = "SELECT COUNT(id) FROM " + ob;
        //strSQL_create = "INSERT INTO " + ob;
        //strSQL_update = "UPDATE " + ob + " SET ";
        strSQL_getpage = "SELECT * FROM " + ob;

    }

    @Override
    public BeanInterface get(int id, Integer expand) throws Exception {
//        String strSQL = "SELECT * FROM " + ob + " WHERE id=?";
        BeanInterface oBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL_get);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oBean = BeanFactory.getBean(ob);
                oBean.fill(oResultSet, oConnection, expand, oUsuarioBeanSession);
            } else {
                oBean = null;
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
        return oBean;
    }

    @Override
    public int remove(int id) throws Exception {
        int iRes = 0;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL_remove);
            oPreparedStatement.setInt(1, id);
            iRes = oPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error en Dao remove de " + ob, e);
        } finally {
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return iRes;
    }

    @Override
    public int getcount(int idTabla, String campo) throws Exception {
        int res = 0;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            if (idTabla > 0) {
                strSQL_getcount = "SELECT COUNT(id) FROM " + ob + " WHERE " + campo + "=" + idTabla;
            } else {
                strSQL_getcount = "SELECT COUNT(id) FROM " + ob;
            }
            oPreparedStatement = oConnection.prepareStatement(strSQL_getcount);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                res = oResultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao getcount de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return res;
    }

    @Override
    public BeanInterface create(BeanInterface oBean) throws Exception {
        String strSQL = "INSERT INTO " + ob;
        strSQL += "(" + oBean.getColumns() + ")";
        strSQL += " VALUES ";
        strSQL += "(" + oBean.getValues() + ")";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.executeUpdate();
            oResultSet = oPreparedStatement.getGeneratedKeys();
            if (oResultSet.next()) {
                oBean.setId(oResultSet.getInt(1));
            } else {
                oBean.setId(0);
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao create de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return oBean;
    }

    @Override
    public int update(BeanInterface oBean) throws Exception {
        int iResult = 0;
        String strSQL = "UPDATE " + ob + " SET ";
        strSQL += oBean.getPairs();
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
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

    @Override
    public ArrayList<BeanInterface> getpage(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand, int idAjena, String campo) throws Exception {
        String strSQL = null;
        if (campo.equalsIgnoreCase("todo")) {
            strSQL = "SELECT * FROM " + ob;
            strSQL += SqlBuilder.buildSqlOrder(hmOrder);
        } else {
            strSQL = "SELECT * FROM " + ob;
            strSQL += SqlBuilder.buildSqlOrder(hmOrder);
            if (idAjena > 0) {
                strSQL += " WHERE " + campo + "=" + idAjena;
            } else {
                strSQL += "";
            }
            strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
        }
        ArrayList<BeanInterface> alBean;

        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery();
            alBean = new ArrayList<BeanInterface>();
            while (oResultSet.next()) {
                BeanInterface oBean = BeanFactory.getBean(ob);
                oBean.fill(oResultSet, oConnection, expand, oUsuarioBeanSession);
                alBean.add(oBean);
            }
        } catch (SQLException e) {
            throw new Exception("Error en Dao getpage de " + ob, e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }

        return alBean;
    }
}
