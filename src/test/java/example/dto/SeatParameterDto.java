package example.dto;

public class SeatParameterDto {

  private int row;
  private int column;

  public SeatParameterDto() {
  }

  public SeatParameterDto(int row, int column) {
    this.row = row;
    this.column = column;
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

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof SeatParameterDto)) {
      return false;
    }


    SeatParameterDto other = (SeatParameterDto) obj;

    return this.getRow() == other.getRow() &&
      this.getColumn() == other.getColumn();
  }
  
  @Override
  public String toString() {
    return this.getRow() + ", " + this.getColumn();
  }
}