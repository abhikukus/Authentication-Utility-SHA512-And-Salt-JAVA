
public class authentication {

	public static void main(String[] args) {

		System.out.println("Authentication utility using SHA-512 and salt. \n");

		addUser adduser = new addUser();
		verifyUser verifyuser = new verifyUser();
		
		String[][] addUsers = new String[][] { { "abhi", "abhi123" }, { "amit", "amit123" }, { "bijesh", "bijesh" } };
		
		
		for (int i = 0; i < addUsers.length; i++) {
			if (adduser.adduser(addUsers[i][0], addUsers[i][1]))
				System.out.println(
						"User :" + addUsers[i][0] + "\nPassword :" + addUsers[i][1] + "\nUser added successfully. \n");
			else
				System.out.println(
						"User :" + addUsers[i][0] + "\nPassword :" + addUsers[i][1] + "\nFailed to add user. \n");
		} 

		String[][] checkUsers = new String[][] { { "abhi", "abhi123" }, { "abhi", "abhi1243" }, { "amit", "amit123" },
				{ "arbab", "123arbab" }, { "bijesh", "bijesh" } };

		for (int i = 0; i < checkUsers.length; i++) {
			if (verifyuser.verify(checkUsers[i][0], checkUsers[i][1]))
				System.out.println(
						"User :" + checkUsers[i][0] + "\nPassword :" + checkUsers[i][1] + "\nLogin successfull. \n");
			else
				System.out.println(
						"User :" + checkUsers[i][0] + "\nPassword :" + checkUsers[i][1] + "\nLogin failed. \n");
		}
		 
		System.out.println("JAVA version : "+System.getProperty("java.version"));
	}

}
