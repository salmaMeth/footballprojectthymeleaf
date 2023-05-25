package Tournoi.Via.Web.footballteam.matchsetup;


import java.io.Serializable;
import java.util.Arrays;

import Tournoi.Via.Web.Model.Player;

public class MatchDaySquad implements Serializable {

  public static final Integer MATCH_DAY_SQUAD = 11;
  public static final Integer MATCH_DAY_SUBSTITUTIONS = 7;

  private Player[] startingLineup;
  private Player[] substitutions;

  public MatchDaySquad() {

  }

  public MatchDaySquad(Player[] startingLineup, Player[] substitutions     ) {
    this.startingLineup = startingLineup;
    this.substitutions = substitutions;
  }

  public Player[] getStartingLineup() {
    return startingLineup;
  }

  public void setStartingLineup(Player[] startingLineup) {
    this.startingLineup = startingLineup;
  }

  public Player[] getSubstitutions() {
    return substitutions;
  }

  public void setSubstitutions(Player[] substitutions) {
    this.substitutions = substitutions;
  }



  @Override
  public String toString() {
    return "MatchDaySquad{" +
        "startingLineup=" + Arrays.toString(startingLineup) +
        ", substitutions=" + Arrays.toString(substitutions)+
        '}';
  }
}

