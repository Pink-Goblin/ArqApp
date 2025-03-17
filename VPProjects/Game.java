public class Game {
	private int _iD;
	private String _name;
	private int _year;
	private double _price;
	private String _description;
	private Platform _platform;

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public int getYear() {
		return this._year;
	}

	public void setYear(int aYear) {
		this._year = aYear;
	}

	public double getPrice() {
		return this._price;
	}

	public void setPrice(double aPrice) {
		this._price = aPrice;
	}

	public String getDescription() {
		return this._description;
	}

	public void setDescription(String aDescription) {
		this._description = aDescription;
	}
}