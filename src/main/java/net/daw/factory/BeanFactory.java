/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.factory;

import com.google.gson.Gson;
import net.daw.bean.beanImplementation.AutorBean;
import net.daw.bean.beanImplementation.AutorEspecialidadBean;
import net.daw.bean.beanImplementation.ColeccionBean;
import net.daw.bean.beanImplementation.FacturaBean;
import net.daw.bean.beanImplementation.LineaBean;
import net.daw.bean.beanImplementation.ComicBean;
import net.daw.bean.beanImplementation.ComicEditorialBean;
import net.daw.bean.beanImplementation.ComicGeneroBean;
import net.daw.bean.beanImplementation.ComicIdiomaBean;
import net.daw.bean.beanImplementation.EditorialBean;
import net.daw.bean.beanImplementation.EspecialidadBean;
import net.daw.bean.beanImplementation.GeneroBean;
import net.daw.bean.beanImplementation.IdiomaBean;
import net.daw.bean.beanImplementation.TipousuarioBean;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;

/**
 *
 * @author a024465169t
 */
public class BeanFactory {

    public static BeanInterface getBean(String ob) {
        BeanInterface oBean = null;
        switch (ob) {
            case "usuario":
                oBean = new UsuarioBean();
                break;
            case "tipousuario":
                oBean = new TipousuarioBean();
                break;
            case "comic":
                oBean = new ComicBean();
                break;
            case "idioma":
                oBean = new IdiomaBean();
                break;
            case "comicidioma":
                oBean = new ComicIdiomaBean();
                break;
            case "genero":
                oBean = new GeneroBean();
                break;
            case "editorial":
                oBean = new EditorialBean();
                break;
            case "coleccion":
                oBean = new ColeccionBean();
                break;
            case "autor":
                oBean = new AutorBean();
                break;
            case "comicgenero":
                oBean = new ComicGeneroBean();
                break;
            case "comiceditorial":
                oBean = new ComicEditorialBean();
                break;
            case "especialidad":
                oBean = new EspecialidadBean();
                break;
            case "autorespecialidad":
                oBean = new AutorEspecialidadBean();
                break;
            case "factura":
                oBean = new FacturaBean();
                break;
            case "linea":
                oBean = new LineaBean();
                break;
        }
        return oBean;
    }

    public static BeanInterface getBeanFromJson(String ob, Gson oGson, String strJsonFromClient) {
        BeanInterface oBean = null;
        switch (ob) {
            case "usuario":
                oBean = oGson.fromJson(strJsonFromClient, UsuarioBean.class);
                break;
            case "tipousuario":
                oBean = oGson.fromJson(strJsonFromClient, TipousuarioBean.class);
                break;
            case "comic":
                oBean = oGson.fromJson(strJsonFromClient, ComicBean.class);
                break;
            case "idioma":
                oBean = oGson.fromJson(strJsonFromClient, IdiomaBean.class);
                break;
            case "comicidioma":
                oBean = oGson.fromJson(strJsonFromClient, ComicIdiomaBean.class);
                break;
            case "genero":
                oBean = oGson.fromJson(strJsonFromClient, GeneroBean.class);
                break;
            case "editorial":
                oBean = oGson.fromJson(strJsonFromClient, EditorialBean.class);
                break;
            case "coleccion":
                oBean = oGson.fromJson(strJsonFromClient, ColeccionBean.class);
                break;
            case "autor":
                oBean = oGson.fromJson(strJsonFromClient, AutorBean.class);
                break;
            case "comicgenero":
                oBean = oGson.fromJson(strJsonFromClient, ComicGeneroBean.class);
                break;
            case "comiceditorial":
                oBean = oGson.fromJson(strJsonFromClient, ComicEditorialBean.class);
                break;
            case "especialidad":
                oBean = oGson.fromJson(strJsonFromClient, EspecialidadBean.class);
                break;
            case "autorespecialidad":
                oBean = oGson.fromJson(strJsonFromClient, AutorEspecialidadBean.class);
                break;
            case "factura":
                oBean = oGson.fromJson(strJsonFromClient, FacturaBean.class);
                break;
            case "linea":
                oBean = oGson.fromJson(strJsonFromClient, LineaBean.class);
                break;
        }
        return oBean;
    }
}
