package com.oksana.application.port.in;

import javax.servlet.http.HttpServletResponse;

public interface PdfService {

    void exportPdf(HttpServletResponse response);


}
