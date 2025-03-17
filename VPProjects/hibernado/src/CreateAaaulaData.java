/**
 * Licensee: Paula Marques(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class CreateAaaulaData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = AaaulaPersistentManager.instance().getSession().beginTransaction();
		try {
			User user = UserDAO.createUser();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : games
			UserDAO.save(user);
			Game game = GameDAO.createGame();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : year, platform
			GameDAO.save(game);
			Platform platform = PlatformDAO.createPlatform();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : year
			PlatformDAO.save(platform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateAaaulaData createAaaulaData = new CreateAaaulaData();
			try {
				createAaaulaData.createTestData();
			}
			finally {
				AaaulaPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
