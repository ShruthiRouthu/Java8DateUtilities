package dateutilities8;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;

/**
 *
 * @author Shruthi Routhu
 */
public class DateTimeUtilities {
    
    public static final String NULL_ARGUMENT_MSG = "Arguments passed to method cannot be null!";
    
    public enum TimeUnit {
      DAYS, HOURS, MINUTES, SECONDS     
    }
    /**
     * 
     * @return returns current time as LocalDate object ie Only Date Information  will be returned 
     */
    public LocalDate dateNow(){
       return LocalDate.now();
    }
    
    /**
     * 
     * @return returns current time as LocalTime object ie Only Time Information  will be returned
     */
    public LocalTime timeNow(){
       return LocalTime.now();
    }
    
    /**
     * 
     * @return returns current time as a LocalDateTime object ie Only Date and Time Information will be returned
     */
    public LocalDateTime dateAndTimeNow(){
        return LocalDateTime.now();
    }
    
//    /**
//     * This method accepts a LocalDateTime object as argument, formats it and
//     * returns a string of type <code> DateTimeFormatter.ISO_LOCAL_DATE_TIME
//     * </code>
//     *
//     * @param dateTime - a <code>LocalDateTime</code> object
//     * @return the dateTime argument as a formatted string of type <code> DateTimeFormatter.ISO_LOCAL_DATE_TIME
//     * </code>
//     * @throws IllegalArgumentException if "dateTime" argument is null
//     * @throws DateTimeException if an error occurs during formating
//     */
//    public final String toString (LocalDateTime dateTime) throws DateTimeException,IllegalArgumentException {
//        if(dateTime == null){
//            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
//        }
//        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);   
//    }
//    
//    
//    /**
//     * This method accepts a LocalDate object as argument, formats it and
//     * returns a string of type <code> DateTimeFormatter.ISO_LOCAL_DATE </code>
//     *
//     * @param date - a <code>LocalDate</code> object
//     * @return the date argument as a formatted string of type <code> DateTimeFormatter.ISO_LOCAL_DATE
//     * </code>
//     * @throws IllegalArgumentException if "date" argument is null
//     * @throws DateTimeException if an error occurs during formating
//     */
//    public final String toString (LocalDate date) throws DateTimeException,IllegalArgumentException {
//        if(date == null){
//            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
//        }
//        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);   
//    }
//    
//    /**
//     * This method accepts a LocalTime object as argument, formats it and
//     * returns a string of type <code> DateTimeFormatter.ISO_LOCAL_TIME </code>
//     *
//     * @param time - a <code>LocalTime</code> object
//     * @return the time argument as a formatted string of type <code> DateTimeFormatter.ISO_LOCAL_TIME
//     * </code>
//     * @throws IllegalArgumentException if "time" argument is null
//     * @throws DateTimeException if an error occurs during formating
//     */
//    public final String toString (LocalTime time) throws DateTimeException, IllegalArgumentException {
//        if(time == null){
//            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
//        }
//        return time.format(DateTimeFormatter.ISO_LOCAL_TIME);   
//    }
    
    /**
     * This method accepts LocalDateTime object and formats it according to the
     * pattern specified
     *
     * @param dateTime - a <code>LocalDateTime</code> object
     * @param pattern - a <code>DateTimeFormatter</code> date/time pattern
     * @return the dateTime argument as a formatted string
     * @throws IllegalArgumentException if argument are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeException if an error occurs during formating
     */
    public final String toString(LocalDateTime dateTime, String pattern ) 
            throws DateTimeException, IllegalArgumentException{
        
        if((dateTime == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
    
    /**
     * This method accepts LocalDate object and formats it according to the
     * pattern specified
     *
     * @param date - a <code>LocalDate</code> object
     * @param pattern - a <code>DateTimeFormatter</code> date pattern
     * @return the date argument as a formatted string
     * @throws IllegalArgumentException if argument are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeException if an error occurs during formating
     */
    public final String toString(LocalDate date, String pattern )
        throws DateTimeException, IllegalArgumentException{
     
        if((date == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
        
     }
    
    /**
     * This method accepts LocalTime object and formats it according to the
     * pattern specified
     *
     * @param time - a <code>LocalTime</code> object
     * @param pattern - a <code>DateTimeFormatter</code> time pattern
     * @return the time argument as a formatted string
     * @throws IllegalArgumentException if argument are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeException if an error occurs during formating
     */
    public final String toString(LocalTime time, String pattern )
        throws DateTimeException, IllegalArgumentException {
        
        if((time == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return time.format(formatter);
    }    
    
    /**
     * This method accepts  a <code>String</code> representation of a date and time and formats it according to the
     * pattern specified
     *
     * @param dateTimeString - a <code>String</code> representation of a date and time
     * @param pattern - a <code>DateTimeFormatter</code> date/time pattern
     * pattern should be exactly as specified in DateTimeFormatter else exception will be thrown 
     * @return the dateTimeString argument as a formatted string
     * @throws IllegalArgumentException if arguments are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeParseException if an error occurs during parsing
     */
    public final LocalDateTime getDateTime(String dateTimeString, String pattern) throws 
            DateTimeParseException,IllegalArgumentException {
        
        if((dateTimeString == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeString, formatter);
        
    }
    
    /**
     * This method accepts a <code>String</code> representation of a date  and formats it according to the
     * pattern specified
     *
     * @param dateString - a <code>String</code> representation of a date 
     * @param pattern - a <code>DateTimeFormatter</code> date  pattern
     * pattern should be exactly as specified in DateTimeFormatter else exception will be thrown 
     * @return the dateString argument as a formatted string
     * @throws IllegalArgumentException if arguments are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeParseException if an error occurs during parsing
     */
    public final LocalDate getDate(String dateString, String pattern)
        throws  DateTimeParseException,IllegalArgumentException {
        
        if((dateString == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }
    
    /**
     * This method accepts a <code>String</code> representation of time string formats it according to the
     * pattern specified
     *
     * @param timeString - a <code>String</code> representation of a date 
     * @param pattern - a <code>DateTimeFormatter</code> time pattern . 
     * pattern should be exactly as specified in DateTimeFormatter else exception will be thrown  
     * @return the timeString argument as a formatted string
     * @throws IllegalArgumentException if arguments are null or if pattern is
     * not recognized by <code>DateTimeFormatter</code>
     * @throws DateTimeParseException if an error occurs during parsing
     */
    public final LocalTime getTime(String timeString, String pattern) 
            throws  DateTimeParseException,IllegalArgumentException {
        
        if((timeString == null)|| (pattern == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalTime.parse(timeString, formatter);
    }
    
    /**
     * Calculates the difference, in TimeUnit field units, for any two
     * <code>LocalDateTime</code> objects
     *
     * @param TimeUnit - an enum representing a unit of measure (e.g., DAYS,
     * HOURS, MINUTES, SECONDS)
     * @param firstDateTime - a <code>LocalDateTime</code> object
     * @param secondDateTime - a <code>LocalDateTime</code> object
     * @return the difference in units specified as a positive whole number
     * @throws IllegalArgumentException if any argument is invalid
     * @throws DateTimeException - if the seconds between the LocalDateTime
     * objects cannot be obtained
     * @throws ArithmeticException - if the calculation exceeds the capacity of
     * Duration
     */
    public final long dateDiff(LocalDateTime firstDateTime, LocalDateTime secondDateTime, TimeUnit returnAs)
        throws DateTimeException, ArithmeticException, IllegalArgumentException {
        
        if((firstDateTime == null) || (secondDateTime == null)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG); 
        }
        
        Duration diff = Duration.between(firstDateTime, secondDateTime).abs();
        long result = 0 ;
        
        switch(returnAs){
            case DAYS :
                result = diff.toDays();
                break;
            
            case HOURS:
                result = diff.toHours();
                break;
            
            case MINUTES:
                result = diff.toMinutes();
                break;
                
            case SECONDS:
                result = diff.getSeconds();
                break;    
        }
        
        return result;
        
        
    }
    
    /**
     * This method returns a LocalDateTime, with the amount in terms of the unit
     * added, to subtract add negative amount
     *
     * @param DateTime - a <code>LocalDateTime</code> object
     * @param valueToAdd - amount to be added in long data type
     * @param TimeUnit - an enum representing a unit of measure ( DAYS, HOURS,
     * MINUTES, SECONDS ) specifies the units of "valueToAdd" argument
     * @return the "dateTime" with the amount in terms of the unit added
     * @throws IllegalArgumentException if any argument is invalid
     * @throws DateTimeException - if the addition cannot be made
     * @throws ArithmeticException - if numeric overflow occurs
     */
    public final LocalDateTime Add(LocalDateTime dateTime, long valueToAdd, TimeUnit unit)
        throws DateTimeException,ArithmeticException,IllegalArgumentException {
      
        if((dateTime == null)|| (valueToAdd == 0)){
            throw new IllegalArgumentException(NULL_ARGUMENT_MSG);
        }
        
        LocalDateTime result = null ;
         switch(unit){
            case DAYS :
                result = dateTime.plus(valueToAdd, ChronoUnit.DAYS);
                break;
            
            case HOURS:
                result = dateTime.plus(valueToAdd, ChronoUnit.HOURS);
                break;
            
            case MINUTES:
                result = dateTime.plus(valueToAdd,ChronoUnit.MINUTES );
                break;
                
            case SECONDS:
                result = dateTime.plus(valueToAdd , ChronoUnit.SECONDS);
                break;    
        }
        
        return result ; 
    }
    
    public static void main(String[] args) {
        DateTimeUtilities dtu = new  DateTimeUtilities();
        System.out.println(dtu.dateAndTimeNow());
        System.out.println(dtu.dateNow());
        System.out.println(dtu.timeNow());
        
        System.out.println(dtu.toString(dtu.dateAndTimeNow(), "yyyy-MMM-dd hh:mm:ss a"));
        System.out.println(dtu.toString(dtu.dateNow(),"yyyy-MMM-dd"));
        System.out.println(dtu.toString(dtu.timeNow(),"hh:mm:ss a" ));
        
        System.out.println(dtu.getDateTime( "2014-04-27 10:33:00 AM", "yyyy-MM-dd hh:mm:ss a"));
        System.out.println(dtu.getDate("2014-Oct-04","yyyy-MMM-dd"));
        System.out.println(dtu.getTime("10:33:00 AM","hh:mm:ss a" ));
        
        System.out.println(dtu.dateDiff(LocalDateTime.of(2015,9,27,10,30,0,0), LocalDateTime.of(2015,9,27,11,40,0,0), TimeUnit.MINUTES));
        System.out.println(dtu.Add(LocalDateTime.of(2015,9,27,10,30,0,0), 2 , DateTimeUtilities.TimeUnit.HOURS));
    
    }
 
}
