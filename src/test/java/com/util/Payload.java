package com.util;

public class Payload {
	
	public static String CreateBug() {
		return "{\r\n"
        		+ "  \"fields\": {\r\n"
        		+ "    \"project\": {\r\n"
        		+ "      \"key\": \"CREDD\"\r\n"
        		+ "    },\r\n"
        		+ "    \"summary\": \"RestAssured Automated : Issue Type Bug creation using API with Basic Auth\",\r\n"
        		+ "    \"description\": {\r\n"
        		+ "      \"type\": \"doc\",\r\n"
        		+ "      \"version\": 1,\r\n"
        		+ "      \"content\": [\r\n"
        		+ "        {\r\n"
        		+ "          \"type\": \"paragraph\",\r\n"
        		+ "          \"content\": [\r\n"
        		+ "            {\r\n"
        		+ "              \"type\": \"text\",\r\n"
        		+ "              \"text\": \"This is a test bug created using REST API.\"\r\n"
        		+ "            }\r\n"
        		+ "          ]\r\n"
        		+ "        }\r\n"
        		+ "      ]\r\n"
        		+ "    },\r\n"
        		+ "    \"issuetype\": {\r\n"
        		+ "      \"name\": \"Bug\"\r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "}\r\n"
        		+ "";
	}

}
