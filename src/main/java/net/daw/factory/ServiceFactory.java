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
import net.daw.service.serviceImplementation_1.FacturaService_1;
import net.daw.service.serviceImplementation_1.LineaService_1;
import net.daw.service.serviceImplementation_1.ComicService_1;
import net.daw.service.serviceImplementation_1.EditorialService_1;
import net.daw.service.serviceImplementation_1.EspecialidadService_1;
import net.daw.service.serviceImplementation_1.GeneroService_1;
import net.daw.service.serviceImplementation_1.TipousuarioService_1;
import net.daw.service.serviceImplementation_1.UsuarioService_1;
import net.daw.service.serviceImplementation_2.AutorEspecialidadService_2;
import net.daw.service.serviceImplementation_2.AutorService_2;
import net.daw.service.serviceImplementation_2.CarritoService_2;
import net.daw.service.serviceImplementation_2.ColeccionService_2;
import net.daw.service.serviceImplementation_2.ComicEditorialService_2;
import net.daw.service.serviceImplementation_2.ComicGeneroService_2;
import net.daw.service.serviceImplementation_2.FacturaService_2;
import net.daw.service.serviceImplementation_2.LineaService_2;
import net.daw.service.serviceImplementation_2.ComicService_2;
import net.daw.service.serviceImplementation_2.EditorialService_2;
import net.daw.service.serviceImplementation_2.EspecialidadService_2;
import net.daw.service.serviceImplementation_2.GeneroService_2;
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
                        TipousuarioService_1 oTipousuarioService = new TipousuarioService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oTipousuarioService.get();
                                break;
                            case "create":
                                oReplyBean = oTipousuarioService.create();
                                break;
                            case "update":
                                oReplyBean = oTipousuarioService.update();
                                break;
                            case "remove":
                                oReplyBean = oTipousuarioService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oTipousuarioService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oTipousuarioService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "usuario":
                        UsuarioService_1 oUsuarioService = new UsuarioService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oUsuarioService.get();
                                break;
                            case "create":
                                oReplyBean = oUsuarioService.create();
                                break;
                            case "update":
                                oReplyBean = oUsuarioService.update();
                                break;
                            case "remove":
                                oReplyBean = oUsuarioService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oUsuarioService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oUsuarioService.getpage();
                                break;
                            case "fill":
                                oReplyBean = oUsuarioService.cargarUsuarios();
                                break;
                            case "logout":
                                oReplyBean = oUsuarioService.logout();
                                break;
                            case "check":
                                oReplyBean = oUsuarioService.check();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_1 oFacturaService = new FacturaService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oFacturaService.get();
                                break;
                            case "create":
                                oReplyBean = oFacturaService.create();
                                break;
                            case "update":
                                oReplyBean = oFacturaService.update();
                                break;
                            case "remove":
                                oReplyBean = oFacturaService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oFacturaService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oFacturaService.getpage();
                                break;
                            case "getpageusuario":
                                oReplyBean = oFacturaService.getpageusuario();
                                break;
//                            case "getcountusuario":
//                                oReplyBean = oFacturaService.getcountusuario();
//                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "linea":
                        LineaService_1 oLineaService = new LineaService_1(oRequest, ob);                        
                        switch (op) {
                            case "get":
                                oReplyBean = oLineaService.get();
                                break;
                            case "create":
                                oReplyBean = oLineaService.create();
                                break;
                            case "update":
                                oReplyBean = oLineaService.update();
                                break;
                            case "remove":
                                oReplyBean = oLineaService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oLineaService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oLineaService.getpage();
                                break;
                            case "getlineafactura":
                                oReplyBean = oLineaService.getlineafactura();
                                break;
//                            case "getcountlinea":
//                                oReplyBean = oLineaService.getcountlinea();
//                                break;
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
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "genero":
                        GeneroService_1 oGeneroService = new GeneroService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oGeneroService.get();
                                break;
                            case "create":
                                oReplyBean = oGeneroService.create();
                                break;
                            case "update":
                                oReplyBean = oGeneroService.update();
                                break;
                            case "remove":
                                oReplyBean = oGeneroService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oGeneroService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oGeneroService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "editorial":
                        EditorialService_1 oEditorialService = new EditorialService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEditorialService.get();
                                break;
                            case "create":
                                oReplyBean = oEditorialService.create();
                                break;
                            case "update":
                                oReplyBean = oEditorialService.update();
                                break;
                            case "remove":
                                oReplyBean = oEditorialService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oEditorialService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEditorialService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "coleccion":
                        ColeccionService_1 oColeccionService = new ColeccionService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oColeccionService.get();
                                break;
                            case "create":
                                oReplyBean = oColeccionService.create();
                                break;
                            case "update":
                                oReplyBean = oColeccionService.update();
                                break;
                            case "remove":
                                oReplyBean = oColeccionService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oColeccionService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oColeccionService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autor":
                        AutorService_1 oAutorService = new AutorService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorService.get();
                                break;
                            case "create":
                                oReplyBean = oAutorService.create();
                                break;
                            case "update":
                                oReplyBean = oAutorService.update();
                                break;
                            case "remove":
                                oReplyBean = oAutorService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oAutorService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comicgenero":
                        ComicGeneroService_1 oComicGeneroService = new ComicGeneroService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicGeneroService.get();
                                break;
                            case "create":
                                oReplyBean = oComicGeneroService.create();
                                break;
                            case "update":
                                oReplyBean = oComicGeneroService.update();
                                break;
                            case "remove":
                                oReplyBean = oComicGeneroService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicGeneroService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicGeneroService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comiceditorial":
                        ComicEditorialService_1 oComicEditorialService = new ComicEditorialService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oComicEditorialService.get();
                                break;
                            case "create":
                                oReplyBean = oComicEditorialService.create();
                                break;
                            case "update":
                                oReplyBean = oComicEditorialService.update();
                                break;
                            case "remove":
                                oReplyBean = oComicEditorialService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oComicEditorialService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oComicEditorialService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "especialidad":
                        EspecialidadService_1 oEspecialidadService = new EspecialidadService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oEspecialidadService.get();
                                break;
                            case "create":
                                oReplyBean = oEspecialidadService.create();
                                break;
                            case "update":
                                oReplyBean = oEspecialidadService.update();
                                break;
                            case "remove":
                                oReplyBean = oEspecialidadService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oEspecialidadService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oEspecialidadService.getpage();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "autorespecialidad":
                        AutorEspecialidadService_1 oAutorEspecialidadService = new AutorEspecialidadService_1(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oAutorEspecialidadService.get();
                                break;
                            case "create":
                                oReplyBean = oAutorEspecialidadService.create();
                                break;
                            case "update":
                                oReplyBean = oAutorEspecialidadService.update();
                                break;
                            case "remove":
                                oReplyBean = oAutorEspecialidadService.remove();
                                break;
                            case "getcount":
                                oReplyBean = oAutorEspecialidadService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oAutorEspecialidadService.getpage();
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
                    case "usuario":
                        UsuarioService_2 oUsuarioService = new UsuarioService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oUsuarioService.get();
                                break;
                            case "update":
                                oReplyBean = oUsuarioService.update();
                                break;
                            case "logout":
                                oReplyBean = oUsuarioService.logout();
                                break;
                            case "check":
                                oReplyBean = oUsuarioService.check();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "factura":
                        FacturaService_2 oFacturaService = new FacturaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oFacturaService.get();
                                break;
                            case "getpageusuario"://obtengo las facturas del usuario
                                oReplyBean = oFacturaService.getpageusuario();
                                break;
                            case "getcount":
                                oReplyBean = oFacturaService.getcount();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "linea":
                        LineaService_2 oLineaService = new LineaService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oLineaService.get();
                                break;
                            case "getlineafactura"://obtengo las lineas de la factura
                                oReplyBean = oLineaService.getlineafactura();
                                break;
                            case "getcountlinea":
                                oReplyBean = oLineaService.getcountlinea();
                                break;
                            default:
                                oReplyBean = new ReplyBean(500, "Operation doesn't exist");
                                break;
                        }
                        break;
                    case "comic":
                        ComicService_2 oProductoService = new ComicService_2(oRequest, ob);
                        switch (op) {
                            case "get":
                                oReplyBean = oProductoService.get();
                                break;
                            case "getcount":
                                oReplyBean = oProductoService.getcount();
                                break;
                            case "getpage":
                                oReplyBean = oProductoService.getpage();
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

