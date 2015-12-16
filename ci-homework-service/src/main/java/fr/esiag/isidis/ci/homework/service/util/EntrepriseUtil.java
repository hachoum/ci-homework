package fr.esiag.isidis.ci.homework.service.util;

public final class EntrepriseUtil {

	public static boolean isValidSiren(Integer siren) {
		int sum  = 0;
		int digit = 0 ;
		if(siren != null) {
			String sirenStr = siren.toString();
			for (int i = 0; i < sirenStr.length(); i++) {
				if ((i % 2) == 1) {
					digit = Integer.parseInt(String.valueOf(sirenStr.charAt(i))) * 2;
					if (digit > 9)
						digit -= 9;
				} else
					digit = Integer.parseInt(String.valueOf(sirenStr.charAt(i)));
				sum += digit;
			}
			if ((sum % 10) == 0)
				return true;
			return false;
		}
		return false;
		
	}
}
