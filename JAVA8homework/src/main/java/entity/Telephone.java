package entity;

public class Telephone {

  private String masterNumber;
  private String countryCode;

  private String telephoneNumber;

  public Telephone(String masterNumber, String countryCode, String telephoneNumber) {
    this.masterNumber = masterNumber;
    this.countryCode = countryCode;
    this.telephoneNumber = telephoneNumber;
  }

  public void setMasterNumber(String masterNumber) {
    this.masterNumber = masterNumber;
  }
}

