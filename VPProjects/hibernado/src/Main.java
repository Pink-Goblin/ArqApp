import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) {
        // Save the user first
        User user = new User();
        user.setName("GandaUser");
        user.setEmail("gandauser@gandaemail.com");
        user.setPassword("gandapassword");
        try {
            UserDAO.save(user);
            System.out.println("User saved with ID: " + user.getID());  // Print the actual ID
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        // Create game and platform
        Platform platform = new Platform();
        platform.setYear(2024);
        platform.setName("GandaPlataforma");
        platform.setDescription("A melhor plataforma de todas");
        platform.setManufacturer("GandaCorp");
        try {
            PlatformDAO.save(platform);
            System.out.println("Platform saved with ID: " + platform.getID());
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        Game game = new Game();
        game.setName("GandaJogo");
        game.setDescription("O melhor jogo de todos");
        game.setPrice(50);
        game.setPlatform(platform);
        game.setYear(2024);

        // Add the game to the user's collection
        user.games.add(game);

        try {
            GameDAO.save(game);
            System.out.println("Game saved with ID: " + game.getID());
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        // Test retrieving with the actual ID printed above, not hardcoded as 1
        try {
            int userID = user.getID();  // Use the ID we know was assigned
            User user2 = UserDAO.getUserByORMID(userID);
            if (user2 != null) {
                System.out.println("Retrieved user name: " + user2.getName());
            } else {
                System.out.println("Failed to retrieve user with ID: " + userID);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        try {
            Game game2 = GameDAO.getGameByORMID(1);
            System.out.println(game2.getName());
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        try {
            Platform platform2 = PlatformDAO.getPlatformByORMID(1);
            System.out.println(platform2.getName());
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }
}