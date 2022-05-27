public class Encrypt {
	
	Rotor InnerRotor;
	Rotor middleRotor;
	Rotor outerRotor;
	
	Encrypt(){
		
		String my = "";
		
		InnerRotor = new Rotor("GNUAHOVBIPWCJQXDKRYELSZFMT",'G');
		middleRotor = new Rotor("EJOTYCHMRWAFKPUZDINSXBGLQV",'E');
		outerRotor = new Rotor("BDFHJLNPRTVXZACEGIKMOQSUWY",'B');
		
		int i = InnerRotor.getStringValues().indexOf(InnerRotor.getCurrentOrientationCharacter());
		my = InnerRotor.getStringValues().substring(i);
		my += InnerRotor.getStringValues().substring(0,i);
		
		InnerRotor.setStringValues(my);
	
		i = middleRotor.getStringValues().indexOf(middleRotor.getCurrentOrientationCharacter());
		my = middleRotor.getStringValues().substring(i);
		my += middleRotor.getStringValues().substring(0,i);
	
		middleRotor.setStringValues(my);
		
		i = outerRotor.getStringValues().indexOf(outerRotor.getCurrentOrientationCharacter());
		my = outerRotor.getStringValues().substring(i);
		my += outerRotor.getStringValues().substring(0,i);
	
		outerRotor.setStringValues(my);
	}
	
	String encrypt(String s){
		
		//s = s.toUpperCase();
		String x = "";
		char b ;
		for(int i = 0; i < s.length(); i++){
				
			b = s.charAt(i);
			
			if(Character.isLetter(b)){
				
				if((i + 1) % 55 == 0){ // if((i + 1) % 56 == 0){
				
				outerRotor.rotateOneClickClockWise();
				}
				
				if((i + 1) % 27 == 0){ // if((i + 1) % 28 == 0){
					
					middleRotor.rotateOneClickClockWise();
				}
				
				int y = InnerRotor.getIndexOfChar(Character.toUpperCase(b) + "");
				char d = outerRotor.getCharOfIndex(y);
				y =  middleRotor.getIndexOfChar(d+"");
				d = outerRotor.getCharOfIndex(y);
				
				if(Character.isLowerCase(b)){
					d = Character.toLowerCase(d);
				}
				
				x += d;
				InnerRotor.rotateOneClickClockWise();
			}
			else
				x += b;
		}
		
		return x;
	}
	
	String decrypt(String s){

		//s = s.toUpperCase();
		String x = "";
		
		char b ;
		
		for(int i = 0; i < s.length(); i++){
			
			b = s.charAt(i);
			
			if(Character.isLetter(b)){
			
				if((i + 1) % 55 == 0){
					
					outerRotor.rotateOneClickClockWise();
				}
				
				if((i + 1) % 27 == 0){
					
					middleRotor.rotateOneClickClockWise();
				}
				
				int y = outerRotor.getIndexOfChar(Character.toUpperCase(b) + "");
				char d = middleRotor.getCharOfIndex(y);
				y =  outerRotor.getIndexOfChar(d+"");
				d = InnerRotor.getCharOfIndex(y);
				
				if(Character.isLowerCase(b)){
					d = Character.toLowerCase(d);
				}
				
				x += d;
				InnerRotor.rotateOneClickClockWise();
			}
			else
				x += b;
		}
		
		return x;
	}
}
		