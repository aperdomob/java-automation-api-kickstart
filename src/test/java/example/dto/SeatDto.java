package example.dto;

public class SeatDto {

  private int row;
  private int column;
  private boolean aisle;
  private boolean booked;
  private int preferencePoints;

  public SeatDto() {
  }

  public SeatDto(int row, int column, boolean aisle, boolean booked, int preferencePoints) {
    this.row = row;
    this.column = column;
    this.aisle = aisle;
    this.booked = booked;
    this.preferencePoints = preferencePoints;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  public boolean isAisle() {
    return aisle;
  }

  public void setAisle(boolean aisle) {
    this.aisle = aisle;
  }

  public boolean isBooked() {
    return booked;
  }

  public void setBooked(boolean booked) {
    this.booked = booked;
  }

  public int getPreferencePoints() {
    return preferencePoints;
  }

  public void setPreferencePoints(int preferencePoints) {
    this.preferencePoints = preferencePoints;
  }
}