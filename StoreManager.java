public class StoreManager extends Employee {
    private String intercomPhoneNo;
    private String emailAddress;

    public StoreManager(String name, String gender, String id, double salary, String intercomPhoneNo, String emailAddress) {
        super(name, gender, id, salary);
        this.intercomPhoneNo = intercomPhoneNo;
        this.emailAddress = emailAddress;
    }

    public String getIntercomPhoneNo() {
        return intercomPhoneNo;
    }

    public void setIntercomPhoneNo(String intercomPhoneNo) {
        this.intercomPhoneNo = intercomPhoneNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return super.toString() + ", Title: Store Manager,  Phone number: " + intercomPhoneNo +
                ", Email address:" + emailAddress;
    }
}
