package net.daw.factory;

import net.daw.connection.publicConnectionInterface.ConnectionInterface;
import net.daw.connection.connectionImplementation.DBCPConnectionSpecificImplementation;
import net.daw.connection.connectionImplementation.BoneCPConnectionSpecificImplementation;
import net.daw.connection.connectionImplementation.C3P0ConnectionSpecificImplementation;
import net.daw.connection.connectionImplementation.HikariConnectionSpecificImplementation;
import net.daw.connection.connectionImplementation.ViburConnectionSpecificImplementation;
import net.daw.constant.ConnectionConstants;

public class ConnectionFactory {

    public static ConnectionInterface getConnection(ConnectionConstants.EnumConstans enumConnection) {
        ConnectionInterface oConnectionInterface = null;
        switch (enumConnection) {
            case Hikari:
                oConnectionInterface = new HikariConnectionSpecificImplementation();
                break;
            case DBCP:
                oConnectionInterface = new DBCPConnectionSpecificImplementation();
                break;
            case BoneCP:
                oConnectionInterface = new BoneCPConnectionSpecificImplementation();
                break;
            case C3P0:
                oConnectionInterface = new C3P0ConnectionSpecificImplementation();
                break;
            case Vibur:
                oConnectionInterface = new ViburConnectionSpecificImplementation();
                break;
            default:
                oConnectionInterface = new HikariConnectionSpecificImplementation();
                break;
        }
        return oConnectionInterface;

    }
}
