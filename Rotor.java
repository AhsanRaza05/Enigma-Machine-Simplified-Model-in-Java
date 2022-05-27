public class Rotor {

	private String stringValues;
	private char currentOrientationCharacter;
	
	Rotor(String a,char b){
		
		stringValues = a;
		currentOrientationCharacter = b;
	}
	
	void rotateOneClickClockWise(){
		
		String my = "";
		
		//my = getStringValues().charAt(26) + getStringValues();

		//my = my.substring(0,27);
		
		my = getStringValues().charAt(25) + getStringValues();

		my = my.substring(0,26);
		
		setStringValues(my);
		currentOrientationCharacter = my.charAt(0);
	}
	
	int getIndexOfChar(String x){
		
		return this.stringValues.indexOf(x);
	}
	
	char getCharOfIndex(int i){
		
		if(i < stringValues.length() && i >= 0)
			return(this.stringValues.charAt(i));
		else {
			
				System.out.println("\nSpecial case INDEX = " + i);
				return '-';
			}
	}

	public String getStringValues() {
		return stringValues;
	}

	public void setStringValues(String stringValues) {
		this.stringValues = stringValues;
	}

	public char getCurrentOrientationCharacter() {
		return currentOrientationCharacter;
	}

	public void setCurrentOrientationCharacter(char currentOrientationCharacter) {
		this.currentOrientationCharacter = currentOrientationCharacter;
	}
}
