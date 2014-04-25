package sites;
import sites.google.Google;


public class Sites {
    private static Google google;
    static {
       if(google ==null){
           google = new Google();}
    }

    public static Google getGoogle(){
        return google;
    }
}
