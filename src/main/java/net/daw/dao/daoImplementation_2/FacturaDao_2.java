package net.daw.dao.daoImplementation_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.beanImplementation.FacturaBean;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.genericDaoImplementation.GenericDaoImplementation;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.helper.SqlBuilder;

public class FacturaDao_2 extends GenericDaoImplementation implements DaoInterface {

    public FacturaDao_2(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, ob, oUsuarioBeanSession);
    }

    @Override
    public BeanInterface get(int id, Integer expand) throws Exception {
        FacturaBean oFacturaBean = (FacturaBean) super.get(id, expand + 1);
        if (oFacturaBean != null) {
            if (oFacturaBean.getObj_Usuario().getId() == oUsuarioBeanSession.getId()) {
                return oFacturaBean;
            } else {
                throw new Exception("Error en Dao get de " + ob + ": No autorizado");
            }
        } else {
            throw new Exception("No existe " + ob);
        }
    }
    

    public int getIdusu(int id, Integer expand) throws Exception {
        String strSQL = "SELECT id_usuario FROM " + ob + " WHERE id=?";
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        int idUsu;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oPreparedStatement.setInt(1, id);
            oResultSet = oPreparedStatement.executeQuery();
            if (oResultSet.next()) {
                idUsu = oResultSet.getInt("id_usuario");
            } else {
                idUsu = 0;
            }
        }catch (SQLException e) {
            throw new Exception("Error en Dao getIdusu de facturaDao_2", e);
        } finally {
            if (oResultSet != null) {
                oResultSet.close();
            }
            if (oPreparedStatement != null) {
                oPreparedStatement.close();
            }
        }
        return idUsu;
    }

    @Override
    public int getcount(int idTabla, String campo) throws Exception {
        if (idTabla == oUsuarioBeanSession.getId()) {
            return super.getcount(idTabla, campo);
        } else {
            throw new Exception("Error en Dao getcount de " + ob + ": No autorizado");
        }
    }

//    public ArrayList<FacturaBean> getpageusuario(int iRpp, int iPage, HashMap<String, String> hmOrder, int idUsuario, Integer expand) throws Exception {
//        if (idUsuario == oUsuarioBeanSession.getId()) {
//            String strSQL = "SELECT * FROM " + ob;
//            strSQL += SqlBuilder.buildSqlOrder(hmOrder);
//            ArrayList<FacturaBean> alFacturaBean;
//            if (iRpp > 0 && iRpp < 100000 && iPage > 0 && iPage < 100000000) {
//                strSQL += " WHERE id_usuario=? ";
//                strSQL += " LIMIT " + (iPage - 1) * iRpp + ", " + iRpp;
//                ResultSet oResultSet = null;
//                PreparedStatement oPreparedStatement = null;
//                try {
//                    oPreparedStatement = oConnection.prepareStatement(strSQL);
//                    oPreparedStatement.setInt(1, idUsuario);
//                    oResultSet = oPreparedStatement.executeQuery();
//                    alFacturaBean = new ArrayList<FacturaBean>();
//
//                    while (oResultSet.next()) {
//                        FacturaBean oFacturaBean = new FacturaBean();
//                        oFacturaBean.fill(oResultSet, oConnection, expand, oUsuarioBeanSession);
//                        alFacturaBean.add(oFacturaBean);
//                    }
//                } catch (SQLException e) {
//                    throw new Exception("Error en Dao getpageXusuario de " + ob, e);
//                } finally {
//                    if (oResultSet != null) {
//                        oResultSet.close();
//                    }
//                    if (oPreparedStatement != null) {
//                        oPreparedStatement.close();
//                    }
//                }
//            } else {
//                throw new Exception("Error en Dao getpageXusuario de " + ob);
//            }
//            return alFacturaBean;
//        } else {
//            throw new Exception("Error en Dao getpageXusuario de " + ob + ": No autorizado");
//        }
//    }
//    @Override
//    public int update(BeanInterface oBean) throws Exception {
//        throw new Exception("Error en Dao update de " + ob + ": No autorizado");
//    }
    @Override
    public ArrayList<BeanInterface> getpage(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand, int idAjena, String campo) throws Exception {
        if (idAjena == oUsuarioBeanSession.getId()) {
            return super.getpage(iRpp, iPage, hmOrder, expand, idAjena, campo);
        } else {
            throw new Exception("Error en Dao getpageXusuario de " + ob + ": No autorizado");
        }
    }

    @Override
    public int remove(int id) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

//    @Override
//    public BeanInterface create(BeanInterface oBean) throws Exception {
//        throw new Exception("Error en Dao create de " + ob + ": No autorizado");
//    }
}
