package model;

public class DateStage {
    private Date dateInReal;
    private Date dateInValued;
    private Date dateEndReal;
    private Date dateEndValued;

    public DateStage(Date in, Date end){
        this.dateInValued = in;
        this.dateEndValued = end;
    }
    
    public Date getDateInReal() {
        return dateInReal;
    }
    public void setDateInReal(Date dateInReal) {
        this.dateInReal = dateInReal;
    }
    public Date getDateInValued() {
        return dateInValued;
    }
    public void setDateInValued(Date dateInValued) {
        this.dateInValued = dateInValued;
    }
    public Date getDateEndReal() {
        return dateEndReal;
    }
    public void setDateEndReal(Date dateEndReal) {
        this.dateEndReal = dateEndReal;
    }
    public Date getDateEndValued() {
        return dateEndValued;
    }
    public void setDateEndValued(Date dateEndValued) {
        this.dateEndValued = dateEndValued;
    }


}
