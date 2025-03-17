/**
 * Licensee: Paula Marques(Universidade do Minho)
 * License Type: Academic
 */
import org.orm.*;
public class DeleteAaaulaData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = AaaulaPersistentManager.instance().getSession().beginTransaction();
		try {
			User user = UserDAO.loadUserByQuery(null, null);
			// Delete the persistent object
			UserDAO.delete(user);
			Game game = GameDAO.loadGameByQuery(null, null);
			// Delete the persistent object
			GameDAO.delete(game);
			Platform platform = PlatformDAO.loadPlatformByQuery(null, null);
			// Delete the persistent object
			PlatformDAO.delete(platform);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteAaaulaData deleteAaaulaData = new DeleteAaaulaData();
			try {
				deleteAaaulaData.deleteTestData();
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
