import java.util.ArrayList;

public class Flight {
	private Airport departAirport;
	private Airport arriveAirport;
	private int duration;
	private String companyName;
	
	public Flight(Airport departAirport, Airport arriveAirport, int duration, String companyName) {
		super();
		this.departAirport = departAirport;
		this.arriveAirport = arriveAirport;
		this.duration = duration;
		this.companyName = companyName;
//		departAirport.addToConectedAirports(arriveAirport);
		
	}
	
	//epistrefei apla to onoma ths etairias 
	public String getCompanyName() {
		return companyName;
	}
	
	//epistrefei to aerodromio a1 oysiastika
	public Airport getAirportA() {
		return departAirport;
	}
	
	//epistrefei to aerodromio a2
	public Airport getAirportB() {
		return arriveAirport;
	}
	
	//epistrofi ths diarkeias ths pthshs
	public int getDuration(){
		return duration;
	}
	
	//ftiaxame aythn thn methodo wste otan thn kaloyme apo thn central registry na 
	//enhmeronetai aytomata h lista me ta companyNames poy yparxei sthn klhsh Airports
	public void updateCompanyName() {
		//edw meso twn dyo antikeimenwn departAirport kai arriveAirport kaloyme thn methodo
		//addToCompanyName kai prosthetoyme to String onoma ths etairias mesa sthn lista
		//me ta onomata twn etairiwn
		departAirport.addToCompanyName(companyName);
		arriveAirport.addToCompanyName(companyName);
	}
	
	//Leitoyrgia ayths ths klassis einai na epistrefei to alfarithmitiko poy yparxei parakatw
	@Override
	public String toString() {
		return "Flight operated by " + companyName + ", duration " + duration + " minutes";
	}

}
