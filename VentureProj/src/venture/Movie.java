package venture;

public class Movie extends Activity {
	
	public String genre;
	public String trailer;
	public String rating;
	public MinuteTime starttime;
	public MinuteTime endtime;
	
	public Movie(String title, String genre, String rating, String trailer, int starttime, int endtime) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.trailer = trailer;
		this.starttime = new MinuteTime(starttime);
		this.endtime = new MinuteTime(endtime);
	}
}
