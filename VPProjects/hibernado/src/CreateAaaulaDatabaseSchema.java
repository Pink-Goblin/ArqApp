/**
 * Licensee: Paula Marques(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateAaaulaDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(AaaulaPersistentManager.instance());
			AaaulaPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
