/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.service.serviceImplementation_0;

import net.daw.dao.daoImplementation_2.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.beanImplementation.FacturaBean;
import net.daw.bean.beanImplementation.LineaBean;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.genericDaoImplementation.GenericDaoImplementation;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.factory.DaoFactory;

/**
 *
 * @author a044531896d
 */
public class LineaDao_0 extends GenericDaoImplementation implements DaoInterface {

    public LineaDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, ob, oUsuarioBeanSession);
    }

    @Override
    public BeanInterface get(int id, Integer expand) throws Exception {
        LineaBean oLineaBean = (LineaBean) super.get(id, expand);
        if (oLineaBean != null) {
            if (oLineaBean.getObj_Factura().getObj_Usuario().getId() == oUsuarioBeanSession.getId()) {
                return oLineaBean;
            } else {
                throw new Exception("Error en Dao get de " + ob + ": No autorizado");
            }
        } else {
            throw new Exception("No existe " + ob);
        }
    }

    @Override
    public int remove(int id) throws Exception {
        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
    }

    @Override
    public int getcount(int id, String campo) throws Exception {
        if (campo.equalsIgnoreCase("id_comic")) {                        
            return super.getcount(id, campo);
        } else {
            throw new Exception("Error en Dao getcount de " + ob + ": No autorizado");
        }

    }

    @Override
    public int update(BeanInterface oBean) throws Exception {
        throw new Exception("Error en Dao update de " + ob + ": No autorizado");
    }

//    @Override
//    public ArrayList<BeanInterface> getpage(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand) throws Exception {
//        throw new Exception("Error en Dao getpage de " + ob + ": No autorizado");
//    }
}
