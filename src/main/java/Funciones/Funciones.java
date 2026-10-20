package Funciones;

public class Funciones {
	
	public Boolean validarNumeros(String texto) {
		try {
			for (char c : texto.trim().toCharArray()) {
				if(!Character.isDigit(c) && !Character.isWhitespace(c)) {
					return false; 
				}
			}
			return true; 
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean validarLetras(String texto) {
		try {
			for (char c : texto.trim().toCharArray()) {
				if(!Character.isLetter(c)) {
					return false; 
				}
			}
			return true; 
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return false; 
		}
	}
	
	public Boolean validarLetrasConEspacio(String texto) {
		try {
		for (char c : texto.trim().toCharArray()) {
			if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
				return false; 
			}
		}
		return true; 
		}
		catch(NullPointerException e) {
			e.printStackTrace();
			return false; 
		}
	}

}
