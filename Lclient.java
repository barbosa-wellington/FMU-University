public class Lclient {


	public static void main (String [] args){



		Integer idClient;
		String nameCli = "";
		long id_cpf;
		String address = "";
		long phone;

		boolean confirmationCli(String nameC) {

			if(nameCli.equals(nameC)) {

				return true;
			} else {

				return false;
			}
		}

		boolean confirmationAddress(String client){

			if(address.equals(client)){
				return true;
			} else {
				return false;
			}
		}


	}

}