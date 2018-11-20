package afinal.proyecto.cuatro.grupo.api;

public class ResponsePeopleQuantity {

    private int peopleQuantity;

    public ResponsePeopleQuantity() {

    }

    public ResponsePeopleQuantity(int peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public int getPeopleQuantity() {
        return peopleQuantity;
    }

    public void setPeopleQuantity(int peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }
}
