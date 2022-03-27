/* by Yiyang Bu */

package review.model;

public class Countries {
	protected Integer CountryId;
	protected String CountryName;

	public Countries(Integer CountryId) {
		this.CountryId = CountryId;
	}

	public Countries(Integer CountryId, String CountryName) {
		this.CountryId = CountryId;
		this.CountryName = CountryName;
	}

	public Integer getCountryId() {
		return CountryId;
	}

	public String getCountryName() {
		return CountryName;
	}


	public void setCountryId(Integer CountryId) {
		this.CountryId = CountryId;
	}

	public void setCountryName(String CountryName) {
		this.CountryName = CountryName;
	}

}