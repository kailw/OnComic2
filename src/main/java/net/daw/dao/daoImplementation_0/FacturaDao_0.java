package net.daw.dao.daoImplementation_0;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import net.daw.bean.beanImplementation.FacturaBean;
import net.daw.bean.beanImplementation.UsuarioBean;
import net.daw.bean.publicBeanInterface.BeanInterface;
import net.daw.dao.genericDaoImplementation.GenericDaoImplementation;
import net.daw.dao.publicDaoInterface.DaoInterface;

public class FacturaDao_0 extends GenericDaoImplementation implements DaoInterface {

    public FacturaDao_0(Connection oConnection, String ob, UsuarioBean oUsuarioBeanSession) {
        super(oConnection, ob, oUsuarioBeanSession);
    }

    @Override
    public BeanInterface get(int id, Integer expand) throws Exception {
//         if (id == oUsuarioBeanSession.getId()) {
//            FacturaBean oFacturaBean = (FacturaBean) super.get(id, expand);
//            return oFacturaBean;
//        } else {
        throw new Exception("Error en Dao get de " + ob + ": No autorizado");
//        }
    }

//    @Override
//    public ArrayList<BeanInterface> getpage(int iRpp, int iPage, HashMap<String, String> hmOrder, Integer expand, int idAjena, String campo) throws Exception {
//        throw new Exception("Error en Dao getpage de " + ob + ": No autorizado");
//
//    }
//
//    @Override
//    public int remove(int id) throws Exception {
//        throw new Exception("Error en Dao remove de " + ob + ": No autorizado");
//    }

//    @Override
//    public int getcount(int idTabla, String campo)  throws Exception {
//        throw new Exception("Error en Dao create de " + ob + ": No autorizado");
//    }
//
//    @Override
//    public BeanInterface create(BeanInterface oBean) throws Exception {
//        throw new Exception("Error en Dao create de " + ob + ": No autorizado");
//    }

}
