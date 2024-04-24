package com.mycompany.app.pdv.reports;

import com.mycompany.app.pdv.entities.Venda;
import com.mycompany.app.pdv.util.EntityManagerUtil;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ReportUtils {
    
    
    private static ReportUtils instance = new ReportUtils();

    private static final String RELATORIO = "reports/reportVenda.jasper";
    private static File caminho = new File("temp\\relatorio.pdf");
    
    
    public InputStream getUrlResource(String tp) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(tp);
        if (is == null) {
            JOptionPane.showMessageDialog(null, "Relatório não encontrado", "Erro ao gerar relatório", JOptionPane.ERROR_MESSAGE);
        }
        return is;
    }
    
    public static void relatorioVenda(Venda venda) throws JRException {
        if(!caminho.exists()) {
            new File("temp").mkdirs();
            caminho = new File("temp\\relatorio.pdf");
        }
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("venda_id", venda.getId());
        
        fillPDF(instance.getUrlResource(ReportUtils.RELATORIO), caminho, parametros);
    }
    
    private static void fillPDF(InputStream reportResource, File caminho, Map<String, Object> parametros) throws JRException {
        try{
            //Objeto jasper para construir o relatório irport
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportResource, parametros, EntityManagerUtil.getConexao());

            //Gerenciador do jasper para exportar o jasperPrint em pdf - Se der ruim é pq está aberto no ireport
            try { 
                JasperExportManager.exportReportToPdfFile(jasperPrint, caminho.getAbsolutePath());
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "O arquivo já está sendo usado por outro processo!", "Erro ao gerar relatório", JOptionPane.ERROR_MESSAGE);
            }
            
            //Tentar abrir pelo dll se terminar em .pdf
            if(caminho.toString().endsWith(".pdf")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + caminho);
            }
            //Se não abre pelo windows
            else { 
                Desktop desktop = Desktop.getDesktop();
                desktop.open(caminho);
            }
        } catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Nada deu certo", "Erro ao gerar relatório", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
