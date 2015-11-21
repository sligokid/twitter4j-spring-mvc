package ie.eirwig.spring.entity;

public class CsoCityEntity {

	private String	geoGid;

	private String	geoGtype;

	private String	city;

	private String	lattitude;

	private String	longditude;

	private String	count;

	public String getGeoGid() {
		return geoGid;
	}

	public void setGeoGid(String geoGid) {
		this.geoGid = geoGid;
	}

	public String getGeoGtype() {
		return geoGtype;
	}

	public void setGeoGtype(String geoGtype) {
		this.geoGtype = geoGtype;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongditude() {
		return longditude;
	}

	public void setLongditude(String longditude) {
		this.longditude = longditude;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CsoCityEntity [geoGid=" + geoGid + ", geoGtype=" + geoGtype + ", city=" + city + ", lattitude=" + lattitude + ", longditude=" + longditude + ", count=" + count + "]";
	}

}
