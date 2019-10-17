package org.incode.estatiotoc.webapp.ui;

import java.net.UnknownHostException;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class IndexController_hostname_Test {

    @Test
    public void xxx() throws Exception {
        final IndexController indexController = new IndexController(null) {
            @Override
            String getHostName() throws UnknownHostException {
                return "toc.estatio-xxx-yyy-toc";
            }
        };
        final String url = indexController.hostname("messagebroker.");
        assertThat(url, is(equalTo("messagebroker.estatio-xxx-yyy.int.ecpnv.com")));
    }
}