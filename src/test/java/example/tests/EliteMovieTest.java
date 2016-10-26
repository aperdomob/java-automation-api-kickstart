package example.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import example.client.EliteMovieClient;
import example.dto.MovieDto;
import example.dto.SeatDto;
import example.dto.SeatParameterDto;
import example.dto.ShowtimeDto;

public class EliteMovieTest {

  private EliteMovieClient client;

  @Before
  public void setup() {
    this.client = new EliteMovieClient();
  }

  @AfterClass
  public static void tearDown() {
    EliteMovieClient client = new EliteMovieClient();
    client.clean();
  }

  @Test
  public void getMoviesService() {
    String[] expectedFilms = new String[] {
      "El Violinista del Diablo",
      "El libro de la vida",
      "Donde se esconde el diablo",
      "Primicia Mortal",
      "Relatos Salvajes",
      "Éxodo, Dioses y Reyes",
      "Pancho, el perro millonario",
      "Petecuy, la película",
      "Stockholm",
      "Los Juegos del Hambre: Sinsajo Parte 1"};

    MovieDto[] movies = this.client.getMovies();

    List<String> filmNames = Arrays.stream(movies).map(movie -> movie.getName()).collect(Collectors.toList());

    assertThat(filmNames, hasItems(expectedFilms));
  }

  @Test
  public void reserve() {
    SeatParameterDto[] seats = new SeatParameterDto[2];

    seats[0] = new SeatParameterDto(0, 8);
    seats[1] = new SeatParameterDto(0, 9);

    this.client.reserve(seats);

    ShowtimeDto showtime = this.client.getShowtime(3);
    List<SeatParameterDto> bookedSeats = getBookedSeats(showtime.getSeats());

    assertThat(bookedSeats, hasItems(seats));
  }

  private List<SeatParameterDto> getBookedSeats(SeatDto[][] seats) {
    List<SeatParameterDto> bookedSeats = new ArrayList<SeatParameterDto>();

    Arrays.stream(seats).forEach(block -> bookedSeats.addAll(
      Arrays
        .stream(block)
        .filter(seat -> seat.isBooked())
        .map(booked -> new SeatParameterDto(booked.getRow(), booked.getColumn()))
        .collect(Collectors.toList())));

    return bookedSeats;
  }
}
