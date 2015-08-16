package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ClienteBean
 */
@Stateless
@LocalBean
public class ClienteBean implements ClienteBeanRemote, ClienteBeanLocal {

    /**
     * Default constructor. 
     */
    public ClienteBean() {
        // TODO Auto-generated constructor stub
    }

}
