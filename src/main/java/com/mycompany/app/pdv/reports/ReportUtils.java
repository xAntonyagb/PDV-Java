package com.mycompany.app.pdv.reports;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mycompany.app.pdv.entities.ItemVenda;
import com.mycompany.app.pdv.entities.Venda;
import com.mycompany.app.pdv.util.EntityManagerUtil;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
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
        
        try{
            parametros.put("qrcode", gerarQrCode(getConteudoQrCode(venda)));
        } catch(Exception ex) {
            System.out.println("Erro ao gerar qrCode!");
        }
        
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
    
    private static InputStream gerarQrCode(String conteudo) throws Exception {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);

        BitMatrix matrix = new MultiFormatWriter().encode(conteudo, BarcodeFormat.QR_CODE, 800, 800, hints);

        BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
    
    private static String getConteudoQrCode(Venda venda) {
        String conteudo = "Venda ID: "+ venda.getId() +", \n"
                + "Produtos {";
        
        for(ItemVenda item : venda.getItemVenda()) {
            conteudo += "\n    ["+ item.toString() + "],";
        }
        conteudo = conteudo.substring(0, conteudo.length()-1);
        
        conteudo += "\n}, \n" 
            + "Total: " + venda.getValorTotal() + ", \n"
            + "Quantidade itens: " + venda.getQuantidadeItens() + ", \n"
            + "Desconto total: " + venda.getValorDesconto() + ", \n"
            + "Cliente: " + venda.getCliente().getNome() + ", \n"
            + "CPF na nota: " + venda.getCpfNota() + ", \n"
            + "Metodo Pagamento: " + venda.getMetodoPagamento() + ", \n"
            + "Vendedor: " + venda.getVendedor().getNome() + "\n";
        
        return conteudo;
    }
}
