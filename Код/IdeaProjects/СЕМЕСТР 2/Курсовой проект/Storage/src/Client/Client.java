package Client;

public class Client {
    private int id;
    private String legal_entity_name;
    private String bank_details;

    public Client(int id, String legal_entity_name, String bank_details) {
        this.id = id;
        this.legal_entity_name = legal_entity_name;
        this.bank_details = bank_details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLegal_entity_name() {
        return legal_entity_name;
    }

    public void setLegal_entity_name(String legal_entity_name) {
        this.legal_entity_name = legal_entity_name;
    }

    public String getBank_details() {
        return bank_details;
    }

    public void setBank_details(String bank_details) {
        this.bank_details = bank_details;
    }
}
