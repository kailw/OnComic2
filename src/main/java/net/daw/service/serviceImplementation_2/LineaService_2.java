/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.service.serviceImplementation_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.beanImplementation.LineaBean;
import net.daw.bean.beanImplementation.ReplyBean;
import net.daw.connection.publicConnectionInterface.ConnectionInterface;
import net.daw.constant.ConnectionConstants;
import net.daw.dao.daoImplementation_2.LineaDao_2;
import net.daw.factory.ConnectionFactory;
import net.daw.service.genericServiceImplementation.GenericServiceImplementation;
import net.daw.service.publicServiceInterface.ServiceInterface;

/**
 *
 * @author a044531896d
 */
public class LineaService_2 extends GenericServiceImplementation implements ServiceInterface {

    HttpServletRequest oRequest;
    String ob = null;

    public LineaService_2(HttpServletRequest oRequest, String ob) {
        super(oRequest, ob);
        this.oRequest = oRequest;
        this.ob = ob;

    }

//    public ReplyBean getlineafactura() throws Exception {
//        ReplyBean oReplyBean;
//        ConnectionInterface oConnectionPool = null;
//        Connection oConnection;
//        try {
//            Integer id_factura = Integer.parseInt(oRequest.getParameter("id"));
//            Integer iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
//            Integer iPage = Integer.parseInt(oRequest.getParameter("page"));
//            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
//            oConnection = oConnectionPool.newConnection();
//            LineaDao_2 oLineaDao = new LineaDao_2(oConnection, ob, usuarioSession);
//            ArrayList<LineaBean> alLineaBean = oLineaDao.getlineafactura(iRpp, iPage, id_factura, 3);
//            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
//            oReplyBean = new ReplyBean(200, oGson.toJson(alLineaBean));
//        } catch (Exception ex) {
//            throw new Exception("ERROR: Service level: getLineaFactura method: " + ob + " object" + ex.getMessage(), ex);
//        } finally {
//            oConnectionPool.disposeConnection();
//        }
//        return oReplyBean;
//    }

}
