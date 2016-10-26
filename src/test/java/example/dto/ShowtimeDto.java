package example.dto;

public class ShowtimeDto {
  private int id;
  private SeatDto[][] seats;
  private int movieId;
  private long timeInMilliseconds;

  public ShowtimeDto() {

  }

  public ShowtimeDto(int id, SeatDto[][] seats, int movieId, int timeInMilliseconds) {
    this.id = id;
    this.seats = seats;
    this.movieId = movieId;
    this.timeInMilliseconds = timeInMilliseconds;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SeatDto[][] getSeats() {
    return seats;
  }

  public void setSeats(SeatDto[][] seats) {
    this.seats = seats;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public long getTimeInMilliseconds() {
    return timeInMilliseconds;
  }

  public void setTimeInMilliseconds(long timeInMilliseconds) {
    this.timeInMilliseconds = timeInMilliseconds;
  }
}
