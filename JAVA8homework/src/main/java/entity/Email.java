package entity;

import java.util.Objects;

public class Email {

    private String masterNumber;

    private String emailAddress;

    // 新添加
    public String getMasterNumber() {
        return masterNumber;
    }

    public Email(String masterNumber, String emailAddress) {
        this.masterNumber = masterNumber;
        this.emailAddress = emailAddress;
    }

    public void setMasterNumber(String masterNumber) {
        this.masterNumber = masterNumber;
    }

    // 新添加

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(masterNumber, email.masterNumber) &&
                Objects.equals(emailAddress, email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterNumber, emailAddress);
    }
}
