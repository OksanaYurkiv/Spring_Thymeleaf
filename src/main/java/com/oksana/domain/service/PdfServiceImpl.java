package com.oksana.domain.service;

import com.oksana.application.port.in.PdfService;
import com.oksana.application.port.in.PersonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Service
@Slf4j
public class PdfServiceImpl implements PdfService {

    private final SpringTemplateEngine templateEngine;
    private final PersonaService personaService;

    @Override
    public void exportPdf(HttpServletResponse response) {
        log.info("Init export pdf");

        // get info for PDF
        var personas = personaService.listarPersonas();
        log.info("Personas: {}", personas);

        var saldoTotal = 0D;
        for (var p : personas) {
            saldoTotal += p.getSaldo();
        }
        int totalClients = personas.size();


        // Crear el contexto con los datos
        // dynamic variables
        Context context = new Context();
        context.setVariable("totalClients", totalClients);
        context.setVariable("personas", personas);
        context.setVariable("totalClients_text", "Total clientes: ");


        // Contenido HTML que se convertirá en PDF
        String htmlContent = templateEngine.process("all_client_pdf.html", context);

        // Configurar la respuesta para que sea descargada como PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Todos los clientes.pdf\"");

        // Usar Flying Saucer (iTextRenderer) para generar el PDF
        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();

            // Convertir el PDF en un flujo de bytes para la respuesta
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.createPDF(outputStream);

            // Escribir el PDF en la respuesta
            response.getOutputStream().write(outputStream.toByteArray());
            response.getOutputStream().flush();

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
