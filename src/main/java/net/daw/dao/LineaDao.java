/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.beanImplementation.LineaBean;
import net.daw.helper.SqlBuilder;

/**
 *
 * @author a044531896d
 */
public class LineaDao {

    Connection oConnection;
    String ob = null;

    public LineaDao(Connection oConnection, String ob) {
        super();
        this.oConnection = oConnection;
        this.ob = ob;
    }

    public LineaBean get(int id, Integer expand) throws Exception {
        String strSQL = "SELECT * FROM " + ob + " WHERE id=?";
        LineaBean oLineaBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                oLineaBean = new LineaBean();
                oLineaBean.fill(oResultSet, oConnection, expand);
            } else {
                oLineaBean = null;
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
        return oLineaBean;
    }

    public int remove(int id) throws Exception {
        int iRes = 0;
        String strSQL = "DELETE FROM " + ob + " WHERE id=?";
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
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

    public int getcount() throws Exception {
        String strSQL = "SELECT COUNT(id) FROM " + ob;
        int res = 0;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                res = oResultSet.getInt(1);
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
        return res;
    }

    public LineaBean create(LineaBean oLineaBean) throws Exception {
        String strSQL = "INSERT INTO " + ob;
        strSQL += "(" + oLineaBean.getColumns() + ")";
        strSQL += " VALUES ";
        strSQL += "(" + oLineaBean.getValues() + ")";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.executeUpdate();
            oResultSet = oPreparedStatement.getGeneratedKeys();
            if (oResultSet.next()) {
                oLineaBean.setId(oResultSet.getInt(1));
            } else {
                oLineaBean.setId(0);
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
        return oLineaBean;
    }

    public int update(LineaBean oLineaBean) throws Exception {
        int iResult = 0;
        String strSQL = "UPDATE " + ob + " SET ";
        strSQL += oLineaBean.getPairs(ob);
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

    public ArrayList<LineaBean> getpage(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand) throws Exception {
        String strSQL = "SELECT * FROM " + ob;
        strSQL += SqlBuilder.buildSqlOrder(hmOrder);
        ArrayList<LineaBean> alLineaBean;
        if (iRpp > 0 && iRpp < 100000 && iPage > 0 && iPage < 100000000) {
            strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
            ResultSet oResultSet = null;
            PreparedStatement oPreparedStatement = null;
            try {
                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oResultSet = oPreparedStatement.executeQuery();
                alLineaBean = new ArrayList<LineaBean>();
                while (oResultSet.next()) {
                    LineaBean oLineaBean = new LineaBean();                    
                    oLineaBean.fill(oResultSet, oConnection, expand);
                    alLineaBean.add(oLineaBean);
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
        } else {
            throw new Exception("Error en Dao getpage de " + ob);
        }
        return alLineaBean;

    }

    public int getcountxlinea(int idFactura) throws Exception {
        String strSQL = "SELECT COUNT(id) FROM " + ob;
        strSQL += " WHERE id_factura=? ";
        int res = 0;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, idFactura);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                res = oResultSet.getInt(1);
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
        return res;
    }

    public ArrayList<LineaBean> getLineaFactura(int iRpp, int iPage, int idFactura, Integer expand) throws Exception {
        String strSQL = "SELECT * FROM " + ob;
        ArrayList<LineaBean> alLineaBean;
        if (iRpp > 0 && iRpp < 100000 && iPage > 0 && iPage < 100000000) {
            strSQL += " WHERE id_factura=? ";
            strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
            ResultSet oResultSet = null;
            PreparedStatement oPreparedStatement = null;
            try {

                oPreparedStatement = oConnection.prepareStatement(strSQL);
                oPreparedStatement.setInt(1, idFactura);
                oResultSet = oPreparedStatement.executeQuery();
                alLineaBean = new ArrayList<LineaBean>();
                while (oResultSet.next()) {
                    LineaBean oLineaBean = new LineaBean();
                    oLineaBean.fill(oResultSet, oConnection, expand);
                    alLineaBean.add(oLineaBean);
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
        } else {
            throw new Exception("Error en Dao getpage de " + ob);
        }
        return alLineaBean;

    }

}
