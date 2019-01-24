package net.daw.factory;

import javax.servlet.http.HttpServletRequest;

import net.daw.bean.beanImplementation.ReplyBean;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.service.serviceImplementation_0.ComicService_0;
import net.daw.service.serviceImplementation_0.UsuarioService_0;
import net.daw.service.serviceImplementation_1.AutorEspecialidadService_1;
import net.daw.service.serviceImplementation_1.AutorService_1;
import net.daw.service.serviceImplementation_1.ColeccionService_1;
import net.daw.service.serviceImplementation_1.ComicEditorialService_1;
import net.daw.service.serviceImplementation_1.ComicGeneroService_1;
import net.daw.service.serviceImplementation_1.ComicIdiomaService_1;
import net.daw.service.serviceImplementation_1.FacturaService_1;
import net.daw.service.serviceImplementation_1.LineaService_1;
import net.daw.service.serviceImplementation_1.ComicService_1;
import net.daw.service.serviceImplementation_1.EditorialService_1;
import net.daw.service.serviceImplementation_1.EspecialidadService_1;
import net.daw.service.serviceImplementation_1.GeneroService_1;
import net.daw.service.serviceImplementation_1.IdiomaService_1;
import net.daw.service.serviceImplementation_1.TipousuarioService_1;
import net.daw.service.serviceImplementation_1.UsuarioService_1;
import net.daw.service.serviceImplementation_2.AutorEspecialidadService_2;
import net.daw.service.serviceImplementation_2.AutorService_2;
import net.daw.service.serviceImplementation_2.CarritoService_2;
import net.daw.service.serviceImplementation_2.ColeccionService_2;
import net.daw.service.serviceImplementation_2.ComicEditorialService_2;
import net.daw.service.serviceImplementation_2.ComicGeneroService_2;
import net.daw.service.serviceImplementation_2.ComicIdiomaService_2;
import net.daw.service.serviceImplementation_2.FacturaService_2;
import net.daw.service.serviceImplementation_2.LineaService_2;
import net.daw.service.serviceImplementation_2.ComicService_2;
import net.daw.service.serviceImplementation_2.EditorialService_2;
import net.daw.service.serviceImplementation_2.EspecialidadService_2;
import net.daw.service.serviceImplementation_2.GeneroService_2;
import net.daw.service.serviceImplementation_2.IdiomaService_2;
import net.daw.service.serviceImplementation_2.TipousuarioService_2;
import net.daw.service.serviceImplementation_2.UsuarioService_2;

public class ServiceFactory {

    public static ReplyBean executeService(HttpServletRequest oRequest) throws Exception {

        String ob = oRequest.getParameter("ob");
        String op = oRequest.getParameter("op");

        int idSessionUserTipe;
        UsuarioBean oUsuarioBeanSession = (UsuarioBean) oRequest.getSession().getAttribute("user");
        if (oUsuarioBeanSession != null) {
            idSessionUserTipe = oUsuarioBeanSession.getObj_tipoUsuario().getId();
        } else {
            idSessionUserTipe = 0;
        }

        ReplyBean oReplyBean = null;

        switch (idSessionUserTipe) {
            case 1:
                switch (ob) {
                    case "tipousuario":
                        TipousuarioService_1 oTipousuarioService1 = new TipousuarioService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oTipousuarioService1.get();
                                break;
                            case "create":
                                oReplyBean = oTipousuarioService1.create();
                                break;
                            case "update":
                                oReplyBean = oTipousuarioService1.update();
                                break;
                            case "remove":
                                oReplyBean = oTipousuarioService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oTipousuarioService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oTipousuarioService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oTipousuarioService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "usuario":
                        UsuarioService_1 oUsuarioService1 = new UsuarioService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oUsuarioService1.get();
                                break;
                            case "create":
                                oReplyBean = oUsuarioService1.create();
                                break;
                            case "update":
                                oReplyBean = oUsuarioService1.update();
                                break;
                            case "remove":
                                oReplyBean = oUsuarioService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oUsuarioService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oUsuarioService1.getpage();
                                break;
                            case "fill":
                                oReplyBean = oUsuarioService1.cargarUsuarios();
                                break;
                            case "logout":
                                oReplyBean = oUsuarioService1.logout();
                                break;
                            case "check":
                                oReplyBean = oUsuarioService1.check();
                                break;
                            case "getpagex":
                                oReplyBean = oUsuarioService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_1 oFacturaService1 = new FacturaService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oFacturaService1.get();
                                break;
                            case "create":
                                oReplyBean = oFacturaService1.create();
                                break;
                            case "update":
                                oReplyBean = oFacturaService1.update();
                                break;
                            case "remove":
                                oReplyBean = oFacturaService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oFacturaService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oFacturaService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oFacturaService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "linea":
                        LineaService_1 oLineaService1 = new LineaService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oLineaService1.get();
                                break;
                            case "create":
                                oReplyBean = oLineaService1.create();
                                break;
                            case "update":
                                oReplyBean = oLineaService1.update();
                                break;
                            case "remove":
                                oReplyBean = oLineaService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oLineaService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oLineaService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oLineaService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;

                    case "comic":
                        ComicService_1 oComicService1 = new ComicService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicService1.get();
                                break;
                            case "create":
                                oReplyBean = oComicService1.create();
                                break;
                            case "update":
                                oReplyBean = oComicService1.update();
                                break;
                            case "remove":
                                oReplyBean = oComicService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicService1.getpage();
                                break;
                            case "loaddata":
                                oReplyBean = oComicService1.cargarProductos();
                                break;
                            case "loadimage":
                                oReplyBean = oComicService1.addimage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "genero":
                        GeneroService_1 oGeneroService1 = new GeneroService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oGeneroService1.get();
                                break;
                            case "create":
                                oReplyBean = oGeneroService1.create();
                                break;
                            case "update":
                                oReplyBean = oGeneroService1.update();
                                break;
                            case "remove":
                                oReplyBean = oGeneroService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oGeneroService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oGeneroService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oGeneroService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "editorial":
                        EditorialService_1 oEditorialService1 = new EditorialService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEditorialService1.get();
                                break;
                            case "create":
                                oReplyBean = oEditorialService1.create();
                                break;
                            case "update":
                                oReplyBean = oEditorialService1.update();
                                break;
                            case "remove":
                                oReplyBean = oEditorialService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oEditorialService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEditorialService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oEditorialService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "coleccion":
                        ColeccionService_1 oColeccionService1 = new ColeccionService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oColeccionService1.get();
                                break;
                            case "create":
                                oReplyBean = oColeccionService1.create();
                                break;
                            case "update":
                                oReplyBean = oColeccionService1.update();
                                break;
                            case "remove":
                                oReplyBean = oColeccionService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oColeccionService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oColeccionService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oColeccionService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autor":
                        AutorService_1 oAutorService1 = new AutorService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorService1.get();
                                break;
                            case "create":
                                oReplyBean = oAutorService1.create();
                                break;
                            case "update":
                                oReplyBean = oAutorService1.update();
                                break;
                            case "remove":
                                oReplyBean = oAutorService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oAutorService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oAutorService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicgenero":
                        ComicGeneroService_1 oComicGeneroService1 = new ComicGeneroService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicGeneroService1.get();
                                break;
                            case "create":
                                oReplyBean = oComicGeneroService1.create();
                                break;
                            case "update":
                                oReplyBean = oComicGeneroService1.update();
                                break;
                            case "remove":
                                oReplyBean = oComicGeneroService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicGeneroService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicGeneroService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicGeneroService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comiceditorial":
                        ComicEditorialService_1 oComicEditorialService1 = new ComicEditorialService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicEditorialService1.get();
                                break;
                            case "create":
                                oReplyBean = oComicEditorialService1.create();
                                break;
                            case "update":
                                oReplyBean = oComicEditorialService1.update();
                                break;
                            case "remove":
                                oReplyBean = oComicEditorialService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicEditorialService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicEditorialService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicEditorialService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "especialidad":
                        EspecialidadService_1 oEspecialidadService1 = new EspecialidadService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEspecialidadService1.get();
                                break;
                            case "create":
                                oReplyBean = oEspecialidadService1.create();
                                break;
                            case "update":
                                oReplyBean = oEspecialidadService1.update();
                                break;
                            case "remove":
                                oReplyBean = oEspecialidadService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oEspecialidadService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEspecialidadService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oEspecialidadService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autorespecialidad":
                        AutorEspecialidadService_1 oAutorEspecialidadService1 = new AutorEspecialidadService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorEspecialidadService1.get();
                                break;
                            case "create":
                                oReplyBean = oAutorEspecialidadService1.create();
                                break;
                            case "update":
                                oReplyBean = oAutorEspecialidadService1.update();
                                break;
                            case "remove":
                                oReplyBean = oAutorEspecialidadService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oAutorEspecialidadService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorEspecialidadService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oAutorEspecialidadService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "idioma":
                        IdiomaService_1 oIdiomaService1 = new IdiomaService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oIdiomaService1.get();
                                break;
                            case "create":
                                oReplyBean = oIdiomaService1.create();
                                break;
                            case "update":
                                oReplyBean = oIdiomaService1.update();
                                break;
                            case "remove":
                                oReplyBean = oIdiomaService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oIdiomaService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oIdiomaService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oIdiomaService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicidioma":
                        ComicIdiomaService_1 oComicIdiomaService1 = new ComicIdiomaService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicIdiomaService1.get();
                                break;
                            case "create":
                                oReplyBean = oComicIdiomaService1.create();
                                break;
                            case "update":
                                oReplyBean = oComicIdiomaService1.update();
                                break;
                            case "remove":
                                oReplyBean = oComicIdiomaService1.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicIdiomaService1.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicIdiomaService1.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicIdiomaService1.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Object doesn't exist");
                        break;
                }
                break;
//=========================================================================================================
            case 2:
                switch (ob) {
                    case "tipousuario":
                        TipousuarioService_2 oTipousuarioService2 = new TipousuarioService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oTipousuarioService2.get();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "usuario":
                        UsuarioService_2 oUsuarioService2 = new UsuarioService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oUsuarioService2.get();
                                break;
                            case "update":
                                oReplyBean = oUsuarioService2.update();
                                break;
                            case "logout":
                                oReplyBean = oUsuarioService2.logout();
                                break;
                            case "check":
                                oReplyBean = oUsuarioService2.check();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_2 oFacturaService2 = new FacturaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oFacturaService2.get();
                                break;
                            case "getpagex"://obtengo las facturas del usuario
                                oReplyBean = oFacturaService2.getpageX();
                                break;
                            case "getcount":
                                oReplyBean = oFacturaService2.getcount();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "linea":
                        LineaService_2 oLineaService2 = new LineaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oLineaService2.get();
                                break;
                            case "getpagex"://obtengo las lineas de la factura
                                oReplyBean = oLineaService2.getpageX();
                                break;
                            case "getcount":
                                oReplyBean = oLineaService2.getcount();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comic":
                        ComicService_2 oComicService2 = new ComicService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicService2.get();
                                break;
                            case "getpage":
                                oReplyBean = oComicService2.getpage();
                                break;
                            case "getcount":
                                oReplyBean = oComicService2.getcount();
                                break;
                            case "getpagex":
                                oReplyBean = oComicService2.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "genero":
                        GeneroService_2 oGeneroService2 = new GeneroService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oGeneroService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oGeneroService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oGeneroService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "editorial":
                        EditorialService_2 oEditorialService2 = new EditorialService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEditorialService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oEditorialService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEditorialService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "coleccion":
                        ColeccionService_2 oColeccionService2 = new ColeccionService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oColeccionService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oColeccionService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oColeccionService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autor":
                        AutorService_2 oAutorService2 = new AutorService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oAutorService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicgenero":
                        ComicGeneroService_2 oComicGeneroService2 = new ComicGeneroService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicGeneroService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicGeneroService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicGeneroService2.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicGeneroService2.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comiceditorial":
                        ComicEditorialService_2 oComicEditorialService2 = new ComicEditorialService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicEditorialService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicEditorialService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicEditorialService2.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oComicEditorialService2.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autorespecialidad":
                        AutorEspecialidadService_2 oAutorEspecialidadService2 = new AutorEspecialidadService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorEspecialidadService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oAutorEspecialidadService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorEspecialidadService2.getpage();
                                break;
                            case "getpagex":
                                oReplyBean = oAutorEspecialidadService2.getpageX();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "especialidad":
                        EspecialidadService_2 oEspecialidadService2 = new EspecialidadService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEspecialidadService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oEspecialidadService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEspecialidadService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "carrito":
                        CarritoService_2 oCarritoService = new CarritoService_2(oRequest, ob);
                        switch (op) {
                            case "add":
                                oReplyBean = oCarritoService.add();
                                break;
                            case "empty":
                                oReplyBean = oCarritoService.empty();
                                break;
                            case "reduce":
                                oReplyBean = oCarritoService.reduce();
                                break;
                            case "show":
                                oReplyBean = oCarritoService.show();
                                break;
                            case "buy":
                                oReplyBean = oCarritoService.buy();
                                break;
                            case "size":
                                oReplyBean = oCarritoService.size();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Object doesn't exist");
                        break;
                }
                break;
            /* ======================================================================================*/
            case 0:
                switch (ob) {
                    case "usuario":
                        UsuarioService_0 oUsuarioService = new UsuarioService_0(oRequest, ob);
                        switch (op) {
                            case "login":
                                oReplyBean = oUsuarioService.login();
                                break;
                            case "check":
                                oReplyBean = oUsuarioService.check();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comic":
                        ComicService_0 oComicService0 = new ComicService_0(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicService0.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicService0.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicService0.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "tipousuario":
                        TipousuarioService_2 oTipousuarioService = new TipousuarioService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oTipousuarioService.get();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "genero":
                        GeneroService_2 oGeneroService2 = new GeneroService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oGeneroService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oGeneroService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oGeneroService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "editorial":
                        EditorialService_2 oEditorialService2 = new EditorialService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEditorialService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oEditorialService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEditorialService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "coleccion":
                        ColeccionService_2 oColeccionService2 = new ColeccionService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oColeccionService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oColeccionService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oColeccionService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autor":
                        AutorService_2 oAutorService2 = new AutorService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oAutorService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicgenero":
                        ComicGeneroService_2 oComicGeneroService2 = new ComicGeneroService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicGeneroService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicGeneroService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicGeneroService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comiceditorial":
                        ComicEditorialService_2 oComicEditorialService2 = new ComicEditorialService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicEditorialService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicEditorialService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicEditorialService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autorespecialidad":
                        AutorEspecialidadService_2 oAutorEspecialidadService2 = new AutorEspecialidadService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorEspecialidadService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oAutorEspecialidadService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorEspecialidadService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "especialidad":
                        EspecialidadService_2 oEspecialidadService2 = new EspecialidadService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEspecialidadService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oEspecialidadService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEspecialidadService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "idioma":
                        IdiomaService_2 oIdiomaService2 = new IdiomaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oIdiomaService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oIdiomaService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oIdiomaService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicidioma":
                        ComicIdiomaService_2 oComicIdiomaService2 = new ComicIdiomaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicIdiomaService2.get();
                                break;
                            case "getcount":
                                oReplyBean = oComicIdiomaService2.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicIdiomaService2.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    default:
                        oReplyBean = new ReplyBean(500, "Object doesn't exist");
                        break;
                }
                break;
            default:
                oReplyBean = new ReplyBean(500, "Profile doesn't exist");
                break;
        }
        return oReplyBean;
    }

}
