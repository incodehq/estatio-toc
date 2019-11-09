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
            // convert "toc.estatio-dev-dha-toc" to "estatio-dev-dha.int.ecpnv.com"
            // convert "toc.estatio-prod" to "estatio.int.ecpnv.com"

            // strip off "toc." prefix, if any (think this is probably redundant)
            if(hostName.startsWith("toc.")) {
                hostName =  hostName.substring(4);
            }

            // strip off "-toc" suffix
            if(hostName.endsWith("-toc")) {
                hostName = hostName.substring(0, hostName.length()-4);
            }

            // strip off "-prod" suffix ... this is special case handling for
            // "estatio-prod", this goes to "estatio"
            if(hostName.endsWith("-prod")) {
                hostName = hostName.substring(0, hostName.length()-5);
            }

            // append the standard suffix
            if(!hostName.endsWith(".int.ecpnv.com")) {
                hostName = hostName + ".int.ecpnv.com";
            }
            hostName = prefix + hostName;
            return hostName;
        } catch (UnknownHostException uhe) {
            return "estatio-test.int.ecpnv.com";
        }
    }

    String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}