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

        final String hostname = hostname();

        model.addAttribute("estatioHref", "https://" + hostname + "/wicket");
        model.addAttribute("swaggerHref", "https://" + hostname + "/swagger-ui/");
        model.addAttribute("restfulHref", "https://" + hostname + "/restful/");
        model.addAttribute("hawtioHref", "https://hawtio." + hostname );
        model.addAttribute("messagebrokerHref", "https://messagebroker." + hostname );
        model.addAttribute("zipkinHref", "https://zipkin." + hostname + "/zipkin");
        model.addAttribute("tocHref", "https://toc." + hostname );

        return "index";
    }

    private String hostname() {
        try {
            final String hostName = InetAddress.getLocalHost().getHostName();
            // strip off 'toc.' prefix
            if(hostName.startsWith("toc.")) {
                return hostName.substring(4);
            }
            return hostName;
        } catch (UnknownHostException uhe) {
            return "estatio-test.int.ecpnv.com";
        }
    }
}