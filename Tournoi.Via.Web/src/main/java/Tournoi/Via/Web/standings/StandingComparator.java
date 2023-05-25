package Tournoi.Via.Web.standings;

import java.util.Comparator;
import java.util.List;

import Tournoi.Via.Web.Model.Standing;

public class StandingComparator {

  public static List<Standing> orderTableByPoints(List<Standing> table) {
	  
	
	  table.sort( Comparator.comparing(Standing::getPoints)
        .thenComparing(Standing::getGoalDifference)
        .thenComparing(Standing::getFootballTeamId));
          updateTablePositions(table);
    return table;
  }

  private static void updateTablePositions(List<Standing> table) {
    for (int i = 0; i < table.size(); i++) {
      table.get(i).setTablePosition(i + 1);
    }
  }
}
