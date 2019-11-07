package org.incode.estatiotoc.webapp.ui;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.incode.estatiotoc.webapp.config.AppConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final AppConfig appConfig;
    public IndexController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("estatioHref", "https://" + hostname("") + "/wicket");
        model.addAttribute("swaggerHref", "https://" + hostname("") + "/swagger-ui/");
        model.addAttribute("restfulHref", "https://" + hostname("") + "/restful/");
        model.addAttribute("hawtioHref", "https://" + hostname("hawtio.") );
        model.addAttribute("messagebrokerHref", "https://" + hostname("messagebroker.") );
        model.addAttribute("tocHref", "https://" + hostname("toc.") );

        return "index";
    }

    String hostname(String prefix) {
        try {
            String hostName = getHostName();
            // convert "toc.estatio-dev-dha-toc" to <prefix>estatio-dev-dha.int.ecpnv.com
            if(hostName.startsWith("toc.")) {
                hostName =  hostName.substring(4);
            }
            hostName = prefix + hostName;
            if(hostName.endsWith("-toc")) {
                hostName = hostName.substring(0, hostName.length()-4) + ".int.ecpnv.com";
            }
            return hostName;
        } catch (UnknownHostException uhe) {
            return "estatio-test.int.ecpnv.com";
        }
    }

    String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}