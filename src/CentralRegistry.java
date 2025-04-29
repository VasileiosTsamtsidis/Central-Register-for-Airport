import java.util.ArrayList;


public class CentralRegistry {
	static int directFlightsCounter = 1;
	static int inDirectFlightsCounter = 1;

	private static ArrayList<Airport> allAirport = new ArrayList<Airport>();
	private static ArrayList<Flight> allFlight = new ArrayList<Flight>();
	
	public static ArrayList<Airport> getAllAirport() {
		return allAirport;
	}

	public static ArrayList<Flight> getAllFlight() {
		return allFlight;
	}

	public static void addFlight(Flight aFlight) {
		allFlight.add(aFlight);
		//edw enhmeronoyme tin lista me ta syndemena apeytheias aerodromia 
		//stis dyo parakatw grames
		aFlight.getAirportA().addToConectedAirports(aFlight.getAirportB());
		aFlight.getAirportB().addToConectedAirports(aFlight.getAirportA());
		//edw enhmeronoyme thn lista companyNames meso toy antikeimenoy flight poy epikoinonei 
		//me thn klassi Airports mesw ayths ths methodoy
		aFlight.updateCompanyName();
	}
	
	//methodos poy apla gemizei thn lista me ola ta aerodromia
	public static void addAirport(Airport anAirport) {
		allAirport.add(anAirport);
	}
	
	//methodos poy epistrefei thn pthsh me to megalytero duration
	public static Flight getLongestFlight() {
		int max=0;
		Flight maxFlight=null;
		for(Flight flight: allFlight) {
			//mesa sthn if meso enos antikeimenoy Flight kaloyme
			//thn methodo getDuration kai tsekaroyme an exei megalytero duration apo 
			//mia timh max poy orisame arxika max=0 kai to kanei ayto gia oles tis pthseis
			if(flight.getDuration()>max) {
				max=flight.getDuration();
				maxFlight=flight;
			}
		}
		return maxFlight;
	}
	
	//methodos poy epistrefei to aerodromio me tis perisoteres apeytheias pthseis 
	//einai idias logikis me thn getLongestFlight 
	public static Airport getLargestHub() {	
		//thn metablhth int i thn xreiazomaste wste na pairnoyme kathe fora
		//ena stoixeio apo thn lista allAirport me thn methodo get(i)
		int i = 0;
		Airport largestHub = null;
		int max = 0;
		
		for(Airport airport: allAirport) {
			//mesa sthn if pairxnoyme apo thn lista allAirport kathe aerodromio kai elexoyme 
			//thn lista me ta syndedemena aerodromia an einai megalytero apo to max 
			//poy pali to orisame max =0 
			if(allAirport.get(i).getDirectlyAirports().size() > max) {
				max = allAirport.get(i).getDirectlyAirports().size();
				largestHub = airport;
				i++;
			}else
				i++;
		}
		return largestHub;
	}
	
	//Epistrofh toy aerodromioy poy exei thn poly cityName
	public static Airport getAirport(String cityName) {
		String aCityName;
		Airport anAirport = null;
		for(Airport airport: allAirport)
		{
			aCityName=airport.getCityName();
			if (cityName.equals(aCityName))
			{
				anAirport = airport;
			}
			
		}
		return anAirport;
	}
	
	//Epistrofh alfarithmitikoy me tis apeytheias pthseis poy syndeoyn ta aerodromia a kai b
	public static String getDirectFlightsDetails(Airport a, Airport b) {
		String flightDetails = "";
		for(Flight flights: allFlight) {
			//an h pthsh flights exei departAirport=a kai arriveAirport=b tote ektypwse thn pthsh
			if(flights.getAirportA() == a && flights.getAirportB() == b) {
				flightDetails = flightDetails + "\n" + "[" +(directFlightsCounter++) + "] " + flights.toString();
			}
			
		}
		return flightDetails;
	
	}
	
	//Epistrogh alfarithmitikoy me tis pthseis poy syndeoyn ta aerodromia a kai b mesw enos alloy aerodromioy 
	public static String getInDirectFlightsDetails(Airport a, Airport b) {
		
		String flightDetails = "";
		int i = 1;
		for(Airport airports: allAirport) {
			//edw elegxoyme an to aerodromio a syndeetai me to aerodromio b meso enos alloy aerodromioy
			if(airports.isDirectlyConnectedTo(a) && airports.isDirectlyConnectedTo(b)) {
				flightDetails = flightDetails + "\n" + "[" +(inDirectFlightsCounter++) + "] " + airports.getCityName() + ", " + airports.getCode() + " airport";
			}
		}
		
		return flightDetails;
	}
	
}
