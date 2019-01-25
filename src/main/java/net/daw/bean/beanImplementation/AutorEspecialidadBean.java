/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean.beanImplementation;

import com.google.gson.annotations.Expose;
import java.sql.Connection;
import java.sql.ResultSet;
import net.daw.bean.genericBeanImplementation.GenericBeanImplementation;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.factory.DaoFactory;

/**
 *
 * @author kevin
 */
public class AutorEspecialidadBean extends GenericBeanImplementation implements BeanInterface {

    @Expose(serialize = false)
    private int id_especialidad;

    @Expose(serialize = false)
    private int id_autor;

    @Expose(serialize = false)
    private int id_comic;

    @Expose(deserialize = false)
    private EspecialidadBean obj_especialidad;

    @Expose(deserialize = false)
    private AutorBean obj_autor;

    @Expose(deserialize = false)
    private ComicBean obj_comic;

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_comic() {
        return id_comic;
    }

    public void setId_comic(int id_comic) {
        this.id_comic = id_comic;
    }

    public EspecialidadBean getObj_especialidad() {
        return obj_especialidad;
    }

    public void setObj_especialidad(EspecialidadBean obj_especialidad) {
        this.obj_especialidad = obj_especialidad;
    }

    public AutorBean getObj_autor() {
        return obj_autor;
    }

    public void setObj_autor(AutorBean obj_autor) {
        this.obj_autor = obj_autor;
    }

    public ComicBean getObj_comic() {
        return obj_comic;
    }

    public void setObj_comic(ComicBean obj_comic) {
        this.obj_comic = obj_comic;
    }

    @Override
    public AutorEspecialidadBean fill(ResultSet oResultSet, Connection oConnection, Integer expand, UsuarioBean oUsuarioBeanSession) throws Exception, Exception {
        this.setId(oResultSet.getInt("id"));

        if (expand > 0) {
            DaoInterface oespecialidadDao = DaoFactory.getDao(oConnection, "especialidad", oUsuarioBeanSession);
            this.setObj_especialidad((EspecialidadBean) oespecialidadDao.get(oResultSet.getInt("id_especialidad"), expand - 1));
        } else {
            this.setId_especialidad(oResultSet.getInt("id_especialidad"));
        }

        if (expand > 0) {
            DaoInterface oautorDao = DaoFactory.getDao(oConnection, "autor", oUsuarioBeanSession);
            this.setObj_autor((AutorBean) oautorDao.get(oResultSet.getInt("id_autor"), expand - 1));
        } else {
            this.setId_autor(oResultSet.getInt("id_autor"));
        }

        if (expand > 0) {
            DaoInterface ocomicDao = DaoFactory.getDao(oConnection, "comic", oUsuarioBeanSession);
            this.setObj_comic((ComicBean) ocomicDao.get(oResultSet.getInt("id_comic"), expand - 1));
        } else {
            this.setId_comic(oResultSet.getInt("id_comic"));
        }

        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "id_especialidad,";
        strColumns += "id_autor,";
        strColumns += "id_comic";

        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += "null,";
        strColumns += id_especialidad + ",";
        strColumns += id_autor + ",";
        strColumns += id_comic;

        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "id_especialidad=" + id_especialidad + ",";
        strPairs += "id_autor=" + id_autor + ",";
        strPairs += "id_comic=" + id_comic;
        strPairs += " WHERE id=" + id;

        return strPairs;
    }

}
