public class Reader {
    public Reader(String firstName, String lastName, int daysLoaned, int bookID, boolean extended, double lateFee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.daysLoaned = daysLoaned;
        this.bookID = bookID;
        this.extended = extended;
        this.lateFee = 0;
    }

    public double findLateFee(int daysLoaned, boolean extended) {
        if (daysLoaned >= 14 && !extended) {
            lateFee = (daysLoaned - 14) * 0.15;
        } else if (daysLoaned >= 14 && extended){
            lateFee = (daysLoaned - 28) * 0.15;
        }
        return lateFee;
    } // findLateFee end

    String firstName; 
    String lastName; 
    int daysLoaned; 
    int bookID; 
    boolean extended; 
    double lateFee;
} // class end