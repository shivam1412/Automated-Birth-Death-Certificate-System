package hospital;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;
import java.util.*;



public class SMS {
    String num;   
    SMS(String mob)
    {
        num=mob;
        sms();
    
    }
    
    public void sms()
    {
            try {
			// Construct data
			String apiKey = "262184AQI18hyfpnp5c600fee";
			String message = "Congratulations for the new borned baby !";
			String sender = "TESTIN";
			String numbers = num;
                        String a="http://api.msg91.com/api/sendhttp.php?country=91&sender="+ sender +"&route=4&mobiles=" + numbers +"&authkey=262184AQI18hyfpnp5c600fee&message="+message+" ";
                       System.out.println(a);
                        // Send data
			HttpURLConnection conn = (HttpURLConnection) new URL(a).openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				//stringBuffer.append(line);
                            JOptionPane.showMessageDialog(null, "message"+line);
			}
			rd.close();
			
			//return stringBuffer.toString();
		} catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
			
		}
    
    
    
    }
    
}
