package Tournoi.Via.Web.Model;

import java.util.ArrayList;
import java.util.List;

import Tournoi.Via.Web.standings.StandingComparator;

/**
 * Collection of individual standings creating the table of all FootballTeams for a given league.
 *
 * @author Salma
 */
public class LeagueTable {

  List<Standing> table;

  //TODO: Replace calls for the list of standings with the table object holding the list itself

  public LeagueTable() {

  }

  public LeagueTable(List<Standing> table) {
    this.table = table;
    sortTable();
  }

  public void addStandingToTable(Standing standing) {
    if (table == null) {
      table = new ArrayList<Standing>();
    }
    table.add(standing);
    sortTable();
  }

  private void sortTable() {
    StandingComparator.orderTableByPoints(table);
  }

  public List<Standing> getTable() {
    return table;
  }
}
