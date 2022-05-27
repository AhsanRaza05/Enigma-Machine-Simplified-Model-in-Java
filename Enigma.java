//package CompleteAccurate;
//import com.sun.xml.internal.fastinfoset.util.CharArray;


public class Enigma {
	
	Rotor InnerRotor;
	Rotor middleRotor;
	Rotor outerRotor;
	
	Enigma(int x, int y, int z, String t){
		
		String my = "";
		
		InnerRotor = new Rotor(getValuesCharacter(x),Character.toUpperCase(t.charAt(0)));
		middleRotor = new Rotor(getValuesCharacter(y),Character.toUpperCase(t.charAt(1)));
		outerRotor = new Rotor(getValuesCharacter(z),Character.toUpperCase(t.charAt(2)));
		
		/*System.out.println("Initially");
		System.out.println("Inner Rotor:\n\t " + InnerRotor.getStringValues() + " and " + InnerRotor.getCurrentOrientationCharacter());
		System.out.println("Middle Rotor:\n\t " + middleRotor.getStringValues() + " and " + middleRotor.getCurrentOrientationCharacter());
		System.out.println("Outer Rotor:\n\t " + outerRotor.getStringValues() + " and " + outerRotor.getCurrentOrientationCharacter());
		*/
		
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
		
		/*System.out.println("Actual");
		System.out.println("Inner Rotor:\n\t " + InnerRotor.getStringValues() + " and " + InnerRotor.getCurrentOrientationCharacter());
		System.out.println("Middle Rotor:\n\t " + middleRotor.getStringValues() + " and " + middleRotor.getCurrentOrientationCharacter());
		System.out.println("Outer Rotor:\n\t " + outerRotor.getStringValues() + " and " + outerRotor.getCurrentOrientationCharacter());
		*/
	}
	
	String getValuesCharacter(int u){
		
		if(u == 1){
			
			return ("#GNUAHOVBIPWCJQXDKRYELSZFMT");
		}
		else if(u == 2){
			
			return ("#EJOTYCHMRWAFKPUZDINSXBGLQV");
		}
		else if(u == 3){
			
			return ("#BDFHJLNPRTVXZACEGIKMOQSUWY");
		}
		else if(u == 4){
			
			return ("#NWDKHGXZVRIFJBLMAOPSCYUTQE");
		}
		else if(u == 5){
	
			return ("#TGOWHLIFMCSZYRVXQABUPEJKND");
		}
		else
			return null;
	}
	String encrypt(String s){
		
		s = s.toUpperCase();
		String x = "";
		
		for(int i = 0; i < s.length(); i++){
				
			if((i + 1) % 56 == 0){
				
				outerRotor.rotateOneClickClockWise();
			}
			
			if((i + 1) % 28 == 0){
				
				middleRotor.rotateOneClickClockWise();
			}
			
			int y = InnerRotor.getIndexOfChar(s.charAt(i) + "");
			char d = outerRotor.getCharOfIndex(y);
			y =  middleRotor.getIndexOfChar(d+"");
			d = outerRotor.getCharOfIndex(y);
			x += d;
			InnerRotor.rotateOneClickClockWise();	
		}
		return x;
	}
	
	String decrypt(String s){

		s = s.toUpperCase();
		String x = "";
		
		for(int i = 0; i < s.length(); i++){
			
			if((i + 1) % 56 == 0){
				
				outerRotor.rotateOneClickClockWise();
			}
			
			if((i + 1) % 28 == 0){
				
				middleRotor.rotateOneClickClockWise();
			}
			
			int y = outerRotor.getIndexOfChar(s.charAt(i) + "");
			char d = middleRotor.getCharOfIndex(y);
			y =  outerRotor.getIndexOfChar(d+"");
			d = InnerRotor.getCharOfIndex(y);
			//System.out.print(d);
			x += d;
			InnerRotor.rotateOneClickClockWise();	
		}	
		return x;
	}
}
