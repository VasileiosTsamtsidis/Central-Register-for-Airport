import java.util.ArrayList;

public class Airport {
	
	private String name;
	private String code;
	private String city;
	private String country;
	private ArrayList<String> companyName = new ArrayList<>();
	private ArrayList<Airport> directlyAirports = new ArrayList<>();	

	
	public String getCountry() {
		return country;
	}

	public Airport(String name, String code, String city, String country) {
		this.name = name;
		this.code = code;
		this.city = city;
		this.country = country;

	}
	
	//H prwth methodos ths klassis Airport poy zitithike apo thn askhsh 
	public boolean isDirectlyConnectedTo(Airport anAirport) {
		for(Airport airport: directlyAirports) {
			if(anAirport.getName().equals(airport.getName()))
				return true;
		}
		return false;
	}
	
	//H deyterh methodos ths klassis Airport poy zitithike apo thn askhsh	
		public boolean isInDirectlyConnectedTo(Airport anAirport) {
			for(Airport airport: directlyAirports) {
				if(anAirport.isDirectlyConnectedTo(airport))
					return true;
			}
			return false;
		}
		

	
	//H trith methodos ths klassis Airport poy zitithike apo thn askhsh
	public ArrayList<Airport> getCommonConnections(Airport anAirport){
		ArrayList<Airport> commonConnections = new ArrayList<>();
		for(Airport airport: directlyAirports) {
			if(anAirport.isDirectlyConnectedTo(airport)) {
				commonConnections.add(airport);
				
		}
		
	}
		return commonConnections;
	}
	
	//H tetarth methodos ths klassis Airport poy zitithike apo thn askhsh
	public void printCompanies() {
			for(String companyNames: companyName) {
				System.out.println(companyNames);
			}
	}
		
	public ArrayList<String> getCompanyName() {
		return companyName;
	}

	//Mia methodos poy epistrefei apla to onoma toy aerodromioy
	public String getName() {
		return name;
	}
	
	//edw exoyme mia methodo poy apla dexete mia lista kai ena aerodromio kai elegxei an
	//se aythn thn lista yparxei hdh ayto to aerodromio mia paromia lista san thn isDirectlyConnectedTo
	//alla ayth dexetai kai mia lista me voithise sto na gemisw oysiastika thn lista directlyAirports
	public boolean isAlreadyInTheDirectlyAirports(ArrayList<Airport> aList, Airport anAirport) {
		for(Airport airport: aList) {
			if(airport.getName().equals(anAirport.getName())) {
				return true;
			}
		}
		return false;
	}
	
	//se ayth thn methodo gemizoyme thn lista directly airports dhladh ths apeytheias
	//syndedemenes pthseis 
	public void addToConectedAirports(Airport anAirport) {
		if(!anAirport.isAlreadyInTheDirectlyAirports(directlyAirports, anAirport)) {
			directlyAirports.add(anAirport);
		}
		
	}
	
	//mia methodos poy otan kaleitai elegxei an yparxei mia etairia sthn lista
	//me tis etairies kai an den yparxei thn prosthetei
	public void addToCompanyName(String aString) {
		if(!companyName.contains(aString)) {
			companyName.add(aString);
		}
	}

	//mia methodos poy epistrefei thn lista me ta apeytheias syndedemena aerodromia
	public ArrayList<Airport> getDirectlyAirports(){
		return directlyAirports;
	}
	
	public String getCityName() {
		return city;
	}
	
	public String getCode() {
		return code;
	}
	

}
