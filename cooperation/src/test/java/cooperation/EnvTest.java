package cooperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnvTest {
	public static void main(String[] args) throws Exception {
		 List<String> commandList = new ArrayList<String>();
		 //String str ="[/usr/bin/java, , -Djava.ext.dirs=/Library/Java/JavaVirtualMachines/jdk1.7.0_80.jdk/Contents/Home/lib:/Library/Java/JavaVirtualMachines/jdk1.7.0_80.jdk/Contents/Home/jre/lib/ext:/Users/shock/Documents/shockspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/bdp-dataworks/WEB-INF/lib, -cp, /Users/shock/Documents/shockspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/bdp-dataworks/WEB-INF/lib/bdp-api-1.0.0.jar, com.ustcinfo.ishare.bdp.api.process.RmiServerMainStarter, 53548]";
		 String str = "[echo, , haha]";
		 commandList =Arrays.asList(str.split(","));
		 /** 构建processBuilder **/
         ProcessBuilder pb = new ProcessBuilder();
         pb.redirectErrorStream(true);
         pb.command(commandList);
         final Process process = pb.start();
         final BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
         System.out.println(br.readLine());
         
	}
}
