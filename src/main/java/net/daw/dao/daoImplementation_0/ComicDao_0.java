/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao.daoImplementation_0;

import net.daw.dao.daoImplementation_2.*;
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
import net.daw.factory.BeanFactory;
import net.daw.helper.ParameterCook;
import net.daw.helper.SqlBuilder;

/**
 *
 * @author a044531896d
 */
public class ComicDao_0 extends GenericDaoImplementation implements DaoInterface {

    public ComicDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, ob, oUsuarioBeanSession);
    }

    @Override
    public int remove(int id) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public BeanInterface create(BeanInterface oBean) throws Exception {
        throw new Exception("Error en Dao create de " + ob + ": No autorizado");
    }

    public ArrayList<BeanInterface> getpagecomicadvanced(int iRpp, int iPage, String campocoleccion, String[] campoeditorial, String[] campoautor, String[] campoespecial, String[] campogenero) throws Exception {
        String strSQL = "";
        strSQL = "SELECT c.id, c.titulo, c.desc, c.isbn, c.fechapublicacion, c.idioma, c.pagina, c.color, c.existencias, c.precio, c.descuento, c.foto, c.id_coleccion ";
        strSQL += "From comic c, genero g, comicgenero cg, comiceditorial ce, editorial ed, coleccion cl, autorespecialidad ae, especialidad es, autor a ";
        strSQL += "WHERE c.id = cg.id_comic AND "
                + "g.id = cg.id_genero AND "
                + "ed.id = ce.id_editorial AND "
                + "c.id = ce.id_comic AND "
                + "cl.id = c.id_coleccion AND "
                + "es.id = ae.id_especialidad AND "
                + "a.id = ae.id_autor AND "
                + "c.id = ce.id_comic AND "
                + "c.id = ae.id_comic ";
        if (campocoleccion != null) {
            strSQL += " AND cl.desc=" + "\"" + campocoleccion + "\"";
        }
        if (campoeditorial != null) {
            String campoEditorialString = "";
            campoEditorialString = ParameterCook.getParams(campoeditorial, campoeditorial.length);
            strSQL += " AND ed.desc in (" + campoEditorialString + ")";
        }
        if (campoautor != null) {
            String campoAutorString = "";
            campoAutorString = ParameterCook.getParams(campoautor, campoautor.length);
            strSQL += " AND a.nombre in (" + campoAutorString + ")";
        }
        if (campoespecial != null) {
            String campoEspecialString = "";
            campoEspecialString = ParameterCook.getParams(campoespecial, campoespecial.length);
            strSQL += " AND es.desc in (" + campoEspecialString + ")" ;
        }
        String campoGeneroString = "";
        if (campogenero != null) {
            campoGeneroString = ParameterCook.getParams(campogenero, campogenero.length);
            strSQL += " AND g.desc in (" + campoGeneroString + ") ";
        }
        strSQL += " GROUP BY c.id";
        ArrayList<BeanInterface> alBean;
        ResultSet oResultSet = null;
        PreparedStatement oPreparedStatement = null;
        try {
            oPreparedStatement = oConnection.prepareStatement(strSQL);
            oResultSet = oPreparedStatement.executeQuery();
            alBean = new ArrayList<BeanInterface>();
            while (oResultSet.next()) {
                BeanInterface oBean = BeanFactory.getBean(ob);
                oBean.fill(oResultSet, oConnection, 1, oUsuarioBeanSession);
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
