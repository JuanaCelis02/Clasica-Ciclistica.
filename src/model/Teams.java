package model;

public enum Teams {
	
	MOVISTAR_TEAM("MOVISTAR"), MONDIALE("MONDIALE"), ASTANA("ASTANA"), CCC_TEAM("CCC"), TEAM_SKY("SKY"),
	TEAM_DIMENSION("DIMENSION"), TEAM_ARKEA("ARKEA"), TEAM_NOVO("NORDISK"), CAJA_RURAL("RURAL"), BURGOS("BURGOS");
	
	private String teamName;

	private Teams(String name) {
		this.teamName = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setName(String name) {
		this.teamName = name;
	}
}
