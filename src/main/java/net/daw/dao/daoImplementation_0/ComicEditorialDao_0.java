/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao.daoImplementation_0;

import net.daw.dao.daoImplementation_2.*;
import java.sql.Connection;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.genericDaoImplementation.GenericDaoImplementation;
import net.daw.dao.publicDaoInterface.DaoInterface;

/**
 *
 * @author a044531896d
 */
public class ComicEditorialDao_0 extends GenericDaoImplementation implements DaoInterface {

    public ComicEditorialDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
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

}
