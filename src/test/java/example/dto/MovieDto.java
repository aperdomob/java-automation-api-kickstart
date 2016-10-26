package example.dto;

public class MovieDto {
  private int id;
  private String name;
  private Object genre;
  private String releaseDateString;
  private String description;

  public MovieDto() {

  }

  public MovieDto(int id, String name, Object genre, String releaseDateString, String description) {
    this.id = id;
    this.name = name;
    this.genre = genre;
    this.releaseDateString = releaseDateString;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getGenre() {
    return genre;
  }

  public void setGenre(Object genre) {
    this.genre = genre;
  }

  public String getReleaseDateString() {
    return releaseDateString;
  }

  public void setReleaseDateString(String releaseDateString) {
    this.releaseDateString = releaseDateString;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
