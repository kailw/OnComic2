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
public class ComicIdiomaBean extends GenericBeanImplementation implements BeanInterface {

    @Expose(serialize = false)
    private int id_idioma;
    @Expose(serialize = false)
    private int id_comic;

    @Expose(deserialize = false)
    private IdiomaBean obj_idioma;

    @Expose(deserialize = false)
    private ComicBean obj_comic;

    public int getId_genero() {
        return id_idioma;
    }

    public void setId_genero(int id_genero) {
        this.id_idioma = id_genero;
    }

    public int getId_comic() {
        return id_comic;
    }

    public void setId_comic(int id_comic) {
        this.id_comic = id_comic;
    }

    public IdiomaBean getObj_idioma() {
        return obj_idioma;
    }

    public void setObj_idioma(IdiomaBean obj_idioma) {
        this.obj_idioma = obj_idioma;
    }

    public ComicBean getObj_comic() {
        return obj_comic;
    }

    public void setObj_comic(ComicBean obj_comic) {
        this.obj_comic = obj_comic;
    }

    @Override
    public ComicIdiomaBean fill(ResultSet oResultSet, Connection oConnection, Integer expand, UsuarioBean oUsuarioBeanSession) throws Exception, Exception {
        this.setId(oResultSet.getInt("id"));

        if (expand > 0) {
            DaoInterface ocomicDao = DaoFactory.getDao(oConnection, "comic", oUsuarioBeanSession);
            this.setObj_comic((ComicBean) ocomicDao.get(oResultSet.getInt("id_comic"), expand - 1));
        } else {
            this.setId_comic(oResultSet.getInt("id_comic"));
        }

        if (expand > 0) {
            DaoInterface oidiomaDao = DaoFactory.getDao(oConnection, "idioma", oUsuarioBeanSession);
            this.setObj_idioma((IdiomaBean) oidiomaDao.get(oResultSet.getInt("id_idioma"), expand - 1));
        } else {
            this.setId_genero(oResultSet.getInt("id_idioma"));
        }

        return this;
    }

    @Override
    public String getColumns() {
        String strColumns = "";
        strColumns += "id,";
        strColumns += "id_idioma,";
        strColumns += "id_comic";

        return strColumns;
    }

    @Override
    public String getValues() {
        String strColumns = "";
        strColumns += "null,";
        strColumns += id_idioma + ",";
        strColumns += id_comic;

        return strColumns;
    }

    @Override
    public String getPairs() {
        String strPairs = "";
        strPairs += "id=" + id + ",";
        strPairs += "id_idioma=" + id_idioma + ",";
        strPairs += "id_comic=" + id_comic;
        strPairs += " WHERE id=" + id;

        return strPairs;
    }

}
