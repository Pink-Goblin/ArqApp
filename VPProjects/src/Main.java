import org.orm.PersistentException;

public class Main {
    public static void main(String[] args) {
        Platform platform = new Platform();
        platform.setYear(2024);
        platform.setName("GandaPlataforma");
        platform.setDescription("A melhor plataforma de todas");
        platform.setManufacturer("GandaCorp");
        try {
            PlatformDAO.save(platform);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        Game game = new Game();
        game.setName("GandaJogo");
        game.setDescription("O melhor jogo de todos");
        game.setPrice(50);
        game.setPlatform(platform);
        game.setYear(2024);
        try {
            GameDAO.save(game);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setName("GandaUser");
        user.setEmail("gandauser@gandaemail.com");
        user.setPassword("gandapassword");
        try {
            UserDAO.save(user);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        // testar

        try {
            User user2 = UserDAO.getUserByORMID(1);
            System.out.println(user2.getName());
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