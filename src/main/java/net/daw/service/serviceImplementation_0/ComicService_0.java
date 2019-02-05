/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.service.serviceImplementation_0;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import net.daw.bean.beanImplementation.ReplyBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.connection.publicConnectionInterface.ConnectionInterface;
import net.daw.constant.ConnectionConstants;
import net.daw.dao.daoImplementation_0.ComicDao_0;
import net.daw.factory.ConnectionFactory;
import net.daw.helper.ParameterCook;
import net.daw.service.genericServiceImplementation.GenericServiceImplementation;
import net.daw.service.publicServiceInterface.ServiceInterface;

/**
 *
 * @author kevin
 */
public class ComicService_0 extends GenericServiceImplementation implements ServiceInterface {

    HttpServletRequest oRequest;
    String ob = null;

    public ComicService_0(HttpServletRequest oRequest, String ob) {
        super(oRequest, ob);
        this.oRequest = oRequest;
        this.ob = ob;
    }

    public ReplyBean getpagecomicadvanced() throws Exception {
        ReplyBean oReplyBean;
        ConnectionInterface oConnectionPool = null;
        Connection oConnection;
        int iRpp, iPage;
        try {
            iRpp = Integer.parseInt(oRequest.getParameter("rpp"));
            iPage = Integer.parseInt(oRequest.getParameter("page"));

            String campocoleccion = oRequest.getParameter("campocoleccion");            

            String campoeditorialString = oRequest.getParameter("campoeditorial");
            String[] campoeditorial = campoeditorialString.split(",");

            String campoautorString = oRequest.getParameter("campoautor");
            String[] campoautor = campoautorString.split(",");

            String campoespecialString = oRequest.getParameter("campoespecial");
            String[] campoespecial = campoespecialString.split(",");

//          HashMap<String, String> campogenero = ParameterCook.getParams(oRequest.getParameter("campogenero"));            
            String campogeneroString = oRequest.getParameter("campogenero");
            String[] campogenero = campogeneroString.split(",");
            
            oConnectionPool = ConnectionFactory.getConnection(ConnectionConstants.connectionPool);
            oConnection = oConnectionPool.newConnection();
            ComicDao_0 oDao = new ComicDao_0(oConnection, ob, usuarioSession);
            ArrayList<BeanInterface> alBean = oDao.getpagecomicadvanced(iRpp, iPage, campocoleccion, campoeditorial, campoautor, campoespecial, campogenero);
            Gson oGson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
            oReplyBean = new ReplyBean(200, oGson.toJson(alBean));
        } catch (Exception ex) {
            throw new Exception("ERROR: Service level: getpage method: " + ob + " object", ex);
        } finally {
            oConnectionPool.disposeConnection();
        }
        return oReplyBean;
    }

}
