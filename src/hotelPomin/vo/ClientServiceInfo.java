package vo;

/**
 * �� ������� �� � ��� ������� �������� ���������� �볺����
 * @author Roman
 *
 */

public class ClientServiceInfo {
	
	private String servName;
	private int servQuantity;
	
	public String getServName() {
		return servName;
	}
	
	public void setServName(String servName) {
		this.servName = servName;
	}
	
	public int getServQuantity() {
		return servQuantity;
	}
	
	public void setServQuantity(int servQuantity) {
		this.servQuantity = servQuantity;
	}
	
	@Override
	public String toString() {
		return servName+" - "+servQuantity;
	}

}
