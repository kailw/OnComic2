/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.factory;

import java.sql.Connection;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.dao.daoImplementation_1.FacturaDao_1;
import net.daw.dao.daoImplementation_1.LineaDao_1;
import net.daw.dao.daoImplementation_1.ComicDao_1;
import net.daw.dao.daoImplementation_1.TipousuarioDao_1;
import net.daw.dao.daoImplementation_1.UsuarioDao_1;
import net.daw.dao.daoImplementation_2.FacturaDao_2;
import net.daw.dao.daoImplementation_2.LineaDao_2;
import net.daw.dao.daoImplementation_2.ComicDao_2;
import net.daw.dao.daoImplementation_2.TipousuarioDao_2;
import net.daw.dao.daoImplementation_2.UsuarioDao_2;
import net.daw.dao.publicDaoInterface.DaoInterface;
import net.daw.dao.daoImplementation_0.*;
import net.daw.dao.daoImplementation_1.AutorDao_1;
import net.daw.dao.daoImplementation_1.AutorEspecialidadDao_1;
import net.daw.dao.daoImplementation_1.ColeccionDao_1;
import net.daw.dao.daoImplementation_1.ComicEditorialDao_1;
import net.daw.dao.daoImplementation_1.ComicGeneroDao_1;
import net.daw.dao.daoImplementation_1.ComicIdiomaDao_1;
import net.daw.dao.daoImplementation_1.EditorialDao_1;
import net.daw.dao.daoImplementation_1.EspecialidadDao_1;
import net.daw.dao.daoImplementation_1.GeneroDao_1;
import net.daw.dao.daoImplementation_1.IdiomaDao_1;
import net.daw.dao.daoImplementation_2.AutorDao_2;
import net.daw.dao.daoImplementation_2.AutorEspecialidadDao_2;
import net.daw.dao.daoImplementation_2.ColeccionDao_2;
import net.daw.dao.daoImplementation_2.ComicEditorialDao_2;
import net.daw.dao.daoImplementation_2.ComicGeneroDao_2;
import net.daw.dao.daoImplementation_2.EditorialDao_2;
import net.daw.dao.daoImplementation_2.EspecialidadDao_2;
import net.daw.dao.daoImplementation_2.GeneroDao_2;

/**
 *
 * @author kevin
 */
public class DaoFactory {

    public static DaoInterface getDao(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) throws Exception {
        DaoInterface oDao = null;
        int idUsuario = 0;
        if (oUsuarioBeanSession != null) {
            idUsuario = oUsuarioBeanSession.getObj_tipoUsuario().getId();
        } else {
            idUsuario = 0;
        }

        switch (idUsuario) {
            case 1:
                switch (ob) {
                    case "usuario":
                        oDao = new UsuarioDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipousuario":
                        oDao = new TipousuarioDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comic":
                        oDao = new ComicDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "idioma":
                        oDao = new IdiomaDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comicidioma":
                        oDao = new ComicIdiomaDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "genero":
                        oDao = new GeneroDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "editorial":
                        oDao = new EditorialDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "coleccion":
                        oDao = new ColeccionDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autor":
                        oDao = new AutorDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comicgenero":
                        oDao = new ComicGeneroDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comiceditorial":
                        oDao = new ComicEditorialDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "especialidad":
                        oDao = new EspecialidadDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autorespecialidad":
                        oDao = new AutorEspecialidadDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "factura":
                        oDao = new FacturaDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "linea":
                        oDao = new LineaDao_1(oConnection, ob, oUsuarioBeanSession);
                        break;
                }
                break;
            case 2:
                switch (ob) {
                    case "usuario":
                        oDao = new UsuarioDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "tipousuario":
                        oDao = new TipousuarioDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comic":
                        oDao = new ComicDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "factura":
                        oDao = new FacturaDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "linea":
                        oDao = new LineaDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "genero":
                        oDao = new GeneroDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "editorial":
                        oDao = new EditorialDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "coleccion":
                        oDao = new ColeccionDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autor":
                        oDao = new AutorDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comicgenero":
                        oDao = new ComicGeneroDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comiceditorial":
                        oDao = new ComicEditorialDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autorespecialidad":
                        oDao = new AutorEspecialidadDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "especialidad":
                        oDao = new EspecialidadDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                }
                break;
            case 0:
                switch (ob) {
                    case "usuario":
                        oDao = new UsuarioDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comic":
                        oDao = new ComicDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "coleccion":
                        oDao = new ColeccionDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "factura":
                        oDao = new FacturaDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "linea":
                        oDao = new LineaDao_0(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "genero":
                        oDao = new GeneroDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "editorial":
                        oDao = new EditorialDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autor":
                        oDao = new AutorDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comicgenero":
                        oDao = new ComicGeneroDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "comiceditorial":
                        oDao = new ComicEditorialDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "autorespecialidad":
                        oDao = new AutorEspecialidadDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                    case "especialidad":
                        oDao = new EspecialidadDao_2(oConnection, ob, oUsuarioBeanSession);
                        break;
                }
                break;
            default:
                throw new Exception("Error en Dao factory de " + ob);
        }

        return oDao;
    }
}
