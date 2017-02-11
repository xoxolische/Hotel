package object_protytypes;

import java.util.ArrayList;

public class ClientColl {
	
	private ArrayList<Client> clients;
	
	public ClientColl() {
		clients= new ArrayList<Client>();
		
		fillList();
	}
	
	private void fillList() {
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
		clients.add(new Client(150, "Ivanov I. I.", "29.01.2061"));
	}

	public ArrayList<Client> getList() {
		return clients;
	}

}
