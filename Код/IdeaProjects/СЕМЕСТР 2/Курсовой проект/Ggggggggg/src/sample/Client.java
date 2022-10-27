package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty legal_entity_name;
    private final SimpleStringProperty bank_details;

    public Client(int id, String legal_entity_name, String bank_details) {
        this.id = new SimpleIntegerProperty(id);
        this.legal_entity_name = new SimpleStringProperty(legal_entity_name);
        this.bank_details = new SimpleStringProperty(bank_details);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public String getLegalEntityName() {
        return legal_entity_name.get();
    }

    public void setLegalEntityName(String value) {
        legal_entity_name.set(value);
    }

    public String getBankDetails() {
        return bank_details.get();
    }

    public void setBankDetails(String value) {
        bank_details.set(value);
    }
}