import java.util.Vector;

public class User {
	private int _iD;
	private String _name;
	private String _email;
	private String _password;
	private Vector<Game> _games = new Vector<Game>();

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public String getEmail() {
		return this._email;
	}

	public void setEmail(String aEmail) {
		this._email = aEmail;
	}

	public String getPassword() {
		return this._password;
	}

	public void setPassword(String aPassword) {
		this._password = aPassword;
	}
}