package com.arllain.camel.apache_camel_tutorial.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileMoverRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:{{spring.diretorio-entrada}}")
                .id("integracao-arquivo")
                .log("Processando o arquivo: ${file:name}")
//                .setHeader(FileConstants.FILE_NAME, simple("${date:now:ddMMyyyy_HHmmss}_${file:name}"))
                .to("file:{{spring.diretorio-saida}}?fileName=${file:onlyname.noext}-${date:now:ddMMyyyy_HHmmss}.${file:ext}");

    }
}
