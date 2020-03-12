warning: LF will be replaced by CRLF in target/test-classes/log4j.xml.
The file will have its original line endings in your working directory
[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex d102d4c..00b1aee 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -191,6 +191,34 @@[m
 		<artifactId>json</artifactId>[m
 		<version>20180130</version>[m
 	</dependency>	 [m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m	[32m<!-- Mockito -->[m
[32m+[m	[32m<dependency>[m
[32m+[m		[32m<groupId>org.mockito</groupId>[m
[32m+[m		[32m<artifactId>mockito-all</artifactId>[m
[32m+[m		[32m<version>1.10.19</version>[m
[32m+[m		[32m<scope>test</scope>[m
[32m+[m	[32m</dependency>[m
[32m+[m[41m	[m
[32m+[m	[32m<!-- Spring Test -->[m
[32m+[m	[32m<dependency>[m
[32m+[m	[32m<groupId>org.springframework</groupId>[m
[32m+[m	[32m<artifactId>spring-test</artifactId>[m
[32m+[m	[32m<version>4.1.4.RELEASE</version>[m
[32m+[m	[32m<scope>test</scope>[m
[32m+[m[32m</dependency>[m
[32m+[m[41m		[m
[32m+[m	[32m<!-- Java x Servlet -->[m
[32m+[m	[32m<dependency>[m
[32m+[m[32m    <groupId>javax.servlet</groupId>[m
[32m+[m[32m    <artifactId>javax.servlet-api</artifactId>[m
[32m+[m[32m    <version>3.1.0</version>[m
[32m+[m[32m    <scope>provided</scope>[m
[32m+[m[32m</dependency>[m
[32m+[m[41m	    [m
[32m+[m[41m		    [m
[32m+[m[41m		    [m
 		    [m
 	</dependencies>[m
     <build>[m
[1mdiff --git a/src/main/java/net/paxcel/bookshelf/controller/SignUpController.java b/src/main/java/net/paxcel/bookshelf/controller/SignUpController.java[m
[1mindex 647c1e6..9ecd4eb 100644[m
[1m--- a/src/main/java/net/paxcel/bookshelf/controller/SignUpController.java[m
[1m+++ b/src/main/java/net/paxcel/bookshelf/controller/SignUpController.java[m
[36m@@ -16,46 +16,43 @@[m [mimport net.paxcel.bookshelf.model.SignUpModel;[m
 import net.paxcel.bookshelf.service.SignUpService;[m
 [m
 @Controller[m
[31m-@RequestMapping(value="/signup")[m
[32m+[m[32m@RequestMapping(value = "/signup")[m
 public class SignUpController {[m
 [m
[32m+[m[32m//	@Autowired[m
[32m+[m[32m//	Logger log; // getting logger[m
[32m+[m
 	@Autowired[m
[31m-	Logger log; // getting logger[m
[31m-	[m
[31m-	@Autowired[m
[31m-	SignUpService signup; //service layer to sign up user[m
[31m-	[m
[31m-	@RequestMapping(method =RequestMethod.GET)[m
[31m-	public String signupPage(Map<String, Object> model )[m
[31m-	{[m
[31m-		SignUpModel user = new SignUpModel();  [m
[31m-        model.put("userForm", user); // making model and adding to view to save results user enters[m
[32m+[m	[32mSignUpService signup; // service layer to sign up user[m
[32m+[m
[32m+[m	[32m@RequestMapping(method = RequestMethod.GET)[m
[32m+[m	[32mpublic String signupPage(Map<String, Object> model) {[m
[32m+[m		[32mSignUpModel user = new SignUpModel();[m
[32m+[m		[32mmodel.put("userForm", user); // making model and adding to view to save results user enters[m
 		return "signup";[m
 	}[m
[31m-	[m
[32m+[m
 	@RequestMapping(method = RequestMethod.POST)[m
[31m-	public String processSignup( @Valid @ModelAttribute("userForm") SignUpModel details,[m
[31m-            BindingResult result, Map<String, Object> model , Model status) [m
[31m-	{[m
[32m+[m	[32mpublic String processSignup(@Valid @ModelAttribute("userForm") SignUpModel details, BindingResult result,[m
[32m+[m			[32mMap<String, Object> model, Model status) {[m
 		/*[m
[31m-		 *  if errors in data entered terminate [m
[31m-		*/[m
[31m-		  if(result.hasErrors())[m
[31m-		  { [m
[31m-			  return "signup";[m
[31m-			  [m
[31m-		  }[m
[31m-		 [m
[32m+[m		[32m * if errors in data entered terminate[m
[32m+[m		[32m */[m
[32m+[m		[32mif (result.hasErrors()) {[m
[32m+[m			[32mreturn "signup";[m
[32m+[m		[32m}[m
[32m+[m
 		/*[m
[31m-		 *  Getting data entered by user[m
[31m-		  */[m
[32m+[m		[32m * Getting data entered by user[m
[32m+[m		[32m */[m
 		String email = details.getEmail();[m
 		String password = details.getPassword();[m
 		String address = details.getAddress();[m
[32m+[m
[32m+[m		[32mSystem.out.print(password);[m
 		[m
[31m-		String message = signup.signup(email, password,address); // signing up user and getting status message[m
[31m-		status.addAttribute("message",message);  // displaying messaging from user[m
[31m-		[m
[32m+[m		[32mString message = signup.signup(email,password,address); // signing up user and getting status message[m
[32m+[m		[32mstatus.addAttribute("message", message); // displaying messaging from user[m
 		return "signup";[m
 	}[m
 }[m
[1mdiff --git a/src/main/java/net/paxcel/bookshelf/dbUtils/test.java b/src/main/java/net/paxcel/bookshelf/dbUtils/test.java[m
[1mindex 1f279bb..f74c445 100644[m
[1m--- a/src/main/java/net/paxcel/bookshelf/dbUtils/test.java[m
[1m+++ b/src/main/java/net/paxcel/bookshelf/dbUtils/test.java[m
[36m@@ -1,38 +1,16 @@[m
 package net.paxcel.bookshelf.dbUtils;[m
 [m
[31m-import java.security.MessageDigest;[m
[31m-import java.security.NoSuchAlgorithmException;[m
[31m-[m
 class test[m
 {[m
[31m-	public static String getHash(String passwordToHash)[m
[31m-	{[m
[31m-        String generatedPassword = null;[m
[31m-        try {[m
[31m-            // Create MessageDigest instance for MD5[m
[31m-            MessageDigest md = MessageDigest.getInstance("MD5");[m
[31m-            //Add password bytes to digest[m
[31m-            md.update(passwordToHash.getBytes());[m
[31m-            //Get the hash's bytes [m
[31m-            byte[] bytes = md.digest();[m
[31m-            //This bytes[] has bytes in decimal format;[m
[31m-            //Convert it to hexadecimal format[m
[31m-            StringBuilder sb = new StringBuilder();[m
[31m-            for(int i=0; i< bytes.length ;i++)[m
[31m-            {[m
[31m-                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));[m
[31m-            }[m
[31m-            //Get complete hashed password in hex format[m
[31m-            generatedPassword = sb.toString();[m
[31m-            return generatedPassword;[m
[31m-        } [m
[31m-        catch (NoSuchAlgorithmException e) [m
[31m-        {[m
[31m-            return "failed";[m
[31m-        }[m
[31m-    }[m
[32m+[m
 	public static void main(String args[])[m
 	{[m
[31m-		System.out.print(getHash("Mridul"));[m
[32m+[m		[32mString s1 =new String("Hello");[m
[32m+[m		[32mString s2 ="Hello";[m
[32m+[m[41m		[m
[32m+[m		[32ms1=new String("Hell");[m
[32m+[m[41m		[m
[32m+[m		[32mSystem.out.println("S1  : "+s1);[m
[32m+[m		[32mSystem.out.println("S2  : "+s1);[m
 	}[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/src/main/java/net/paxcel/bookshelf/model/SignUpModel.java b/src/main/java/net/paxcel/bookshelf/model/SignUpModel.java[m
[1mindex 55fca7d..5d50f50 100644[m
[1m--- a/src/main/java/net/paxcel/bookshelf/model/SignUpModel.java[m
[1m+++ b/src/main/java/net/paxcel/bookshelf/model/SignUpModel.java[m
[36m@@ -49,7 +49,8 @@[m [mpublic class SignUpModel implements java.io.Serializable {[m
 	}[m
 [m
 	public void setPassword(String password) {[m
[31m-		try {[m
[32m+[m		[32mtry[m[41m [m
[32m+[m		[32m{[m
 		hashedPassword =Hasher.getHash(password);[m
 		this.password=password;[m
 		}[m
[1mdiff --git a/src/main/java/net/paxcel/bookshelf/service/SignUpServiceImpl.java b/src/main/java/net/paxcel/bookshelf/service/SignUpServiceImpl.java[m
[1mindex 88b2833..f2ae930 100644[m
[1m--- a/src/main/java/net/paxcel/bookshelf/service/SignUpServiceImpl.java[m
[1m+++ b/src/main/java/net/paxcel/bookshelf/service/SignUpServiceImpl.java[m
[36m@@ -23,7 +23,7 @@[m [mRegisterUserDAO signup; // dao interface for signup[m
 		// giving message based upon status[m
 		if(status == 1) // successful[m
 		{[m
[31m-			return "Sign Up Successful. Please login to continue.";[m
[32m+[m			[32mreturn "Sign up Successful. Login to continue";[m
 		}[m
 		else if(status ==-1)  // duplicate record[m
 		{[m
[1mdiff --git a/target/classes/net/paxcel/bookshelf/controller/SignUpController.class b/target/classes/net/paxcel/bookshelf/controller/SignUpController.class[m
[1mindex d16e685..95a6859 100644[m
Binary files a/target/classes/net/paxcel/bookshelf/controller/SignUpController.class and b/target/classes/net/paxcel/bookshelf/controller/SignUpController.class differ
[1mdiff --git a/target/classes/net/paxcel/bookshelf/dbUtils/test.class b/target/classes/net/paxcel/bookshelf/dbUtils/test.class[m
[1mindex c6b08c2..d460dcc 100644[m
Binary files a/target/classes/net/paxcel/bookshelf/dbUtils/test.class and b/target/classes/net/paxcel/bookshelf/dbUtils/test.class differ
[1mdiff --git a/target/classes/net/paxcel/bookshelf/model/SignUpModel.class b/target/classes/net/paxcel/bookshelf/model/SignUpModel.class[m
[1mindex bf34c6b..c799183 100644[m
Binary files a/target/classes/net/paxcel/bookshelf/model/SignUpModel.class and b/target/classes/net/paxcel/bookshelf/model/SignUpModel.class differ
[1mdiff --git a/target/classes/net/paxcel/bookshelf/service/SignUpServiceImpl.class b/target/classes/net/paxcel/bookshelf/service/SignUpServiceImpl.class[m
[1mindex 24cc76e..0fddd71 100644[m
Binary files a/target/classes/net/paxcel/bookshelf/service/SignUpServiceImpl.class and b/target/classes/net/paxcel/bookshelf/service/SignUpServiceImpl.class differ
[1mdiff --git a/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.properties b/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.properties[m
[1mindex b1d6bc9..9d5bfa2 100644[m
[1m--- a/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.properties[m
[1m+++ b/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.properties[m
[36m@@ -1,5 +1,5 @@[m
 #Generated by Maven Integration for Eclipse[m
[31m-#Sat Feb 29 17:25:40 IST 2020[m
[32m+[m[32m#Thu Mar 05 13:09:53 IST 2020[m
 version=1.0.0-BUILD-SNAPSHOT[m
 groupId=net.paxcel[m
 m2e.projectName=BookShelf[m
[1mdiff --git a/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.xml b/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.xml[m
[1mindex d102d4c..00b1aee 100644[m
[1m--- a/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.xml[m
[1m+++ b/target/m2e-wtp/web-resources/META-INF/maven/net.paxcel/bookshelf/pom.xml[m
[36m@@ -191,6 +191,34 @@[m
 		<artifactId>json</artifactId>[m
 		<version>20180130</version>[m
 	</dependency>	 [m
[32m+[m[41m	[m
[32m+[m[41m	[m
[32m+[m	[32m<!-- Mockito -->[m
[32m+[m	[32m<dependency>[m
[32m+[m		[32m<groupId>org.mockito</groupId>[m
[32m+[m		[32m<artifactId>mockito-all</artifactId>[m
[32m+[m		[32m<version>1.10.19</version>[m
[32m+[m		[32m<scope>test</scope>[m
[32m+[m	[32m</dependency>[m
[32m+[m[41m	[m
[32m+[m	[32m<!-- Spring Test -->[m
[32m+[m	[32m<dependency>[m
[32m+[m	[32m<groupId>org.springframework</groupId>[m
[32m+[m	[32m<artifactId>spring-test</artifactId>[m
[32m+[m	[32m<version>4.1.4.RELEASE</version>[m
[32m+[m	[32m<scope>test</scope>[m
[32m+[m[32m</dependency>[m
[32m+[m[41m		[m
[32m+[m	[32m<!-- Java x Servlet -->[m
[32m+[m	[32m<dependency>[m
[32m+[m[32m    <groupId>javax.servlet</groupId>[m
[32m+[m[32m    <artifactId>javax.servlet-api</artifactId>[m
[32m+[m[32m    <version>3.1.0</version>[m
[32m+[m[32m    <scope>provided</scope>[m
[32m+[m[32m</dependency>[m
[32m+[m[41m	    [m
[32m+[m[41m		    [m
[32m+[m[41m		    [m
 		    [m
 	</dependencies>[m
     <build>[m
