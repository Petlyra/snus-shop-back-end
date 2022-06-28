package paley.yuri.util;

import lombok.Getter;

import java.time.format.DateTimeFormatter;

public class Constraints {
  public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Constraints() {}
}
