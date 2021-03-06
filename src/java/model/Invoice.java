package model;

import java.util.Date;

/**
 *
 * @author Niklas Sarup-Lytzen ID: 18036644
 *
 */
public class Invoice {

    private Patient patient;
    private double price;
    private Date dateOfInvoice;
    private boolean paid;
    private boolean insured;
    private int invoiceID;

    public Invoice() {

    }

    protected Invoice(Patient patient, double price, Date dateOfInvoice, boolean paid, boolean insured, int invoiceID) {
        boolean isDatabase = false;

        try {
            if (Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()) == Database.class) {
                isDatabase = true;
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        if (isDatabase) {
            this.patient = patient;
            this.price = price;
            this.dateOfInvoice = dateOfInvoice;
            this.paid = paid;
            this.insured = insured;
            this.invoiceID = invoiceID;
        } else {
            System.out.println("Constructor with ID can only be called by the Database class");
        }
    }

    public Invoice(Patient patient, double price, Date dateOfInvoice, boolean paid, boolean insured) {
        this.patient = patient;
        this.price = price;
        this.dateOfInvoice = dateOfInvoice;
        this.paid = paid;
        this.insured = insured;
        this.invoiceID = -1;
    }

    public int getInvoiceID() {
        return invoiceID;
    }
    
    public int getID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public double getPrice() {
        return price;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(Date dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceID=" + invoiceID + ", patient_id=" + patient.getPatientID() + ", price=" + price + ", dateOfInvoice=" + dateOfInvoice + ", paid=" + paid + ", insured=" + insured + '}';
    }

}
