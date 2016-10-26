package example.tests;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.client.EliteMovieClient;
import example.dto.SeatDto;
import example.dto.SeatParameterDto;
import example.dto.ShowtimeDto;

public class ReserveSeatsStepDefinitions {

  private EliteMovieClient client;
  private int showtime;

  private SeatParameterDto[] seats;
  private List<SeatParameterDto> bookedSeats;

  public ReserveSeatsStepDefinitions() {
    this.client = new EliteMovieClient();
  }

  @Given("^the showtime (\\d+)$")
  public void theShowtime(int showtime) throws Throwable {
    this.showtime = showtime;
  }

  @Given("^the seats:$")
  public void theSeats(List<SeatParameterDto> seats) throws Throwable {
    this.seats = seats.toArray(new SeatParameterDto[0]);
  }

  @When("^reserve the seats$")
  public void reserveTheSeats() throws Throwable {
    this.client.reserve(seats);
  }

  @When("^obtain the showtime$")
  public void obtainTheShowtime() throws Throwable {
    ShowtimeDto dto = this.client.getShowtime(this.showtime);
    this.bookedSeats = getBookedSeats(dto.getSeats());
  }

  @Then("^the seats should be booked$")
  public void theSeatsShouldBeBooked() throws Throwable {
    assertThat(bookedSeats, hasItems(seats));
  }

  @After
  public void afterScenario() {
    this.client.clean();
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
