
import java.util.*;
//import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priya
 */
public class mail extends javax.swing.JFrame {

    /**
     * Creates new form mail
     */
    private String userName;
    private String password;
    private String sendingHost;
    private int sendingPort;
     private String receivingHost;
     private String from;
     private String to;
     private String subject;
     private String text;
  
     int x;

    public mail() {
        initComponents();
        this.userName="priyadharsinir98@gmail.com";//sender's email can also use as User Name
        this.password="nivethitha10";  
        this.to="rash1997mitha@gmail.com";
  
    }
public void sendGmail(String from,String to,String subject,String text)
{
    this.from=from;
    //this.to=to;
    this.subject=subject;
    this.text=text;
    this.sendingHost="smtp.gmail.com";
    this.sendingPort=465;
    Properties props=new Properties();
                
               // props.put("mail.smtp.starttls.enable","true");
                props.put("mailsmtp.host",this.sendingHost);
                props.put("mail.smtp.port",String.valueOf(this.sendingPort));
                props.put("mail.smtp.user",this.userName);
                props.put("mail.smtp.password",this.password);
                props.put("mail.smtp.auth","true");
                Session session1=Session.getDefaultInstance(props,null);
                
                Message simpleMessage=new MimeMessage(session1);
                InternetAddress fromAddress=null;
                InternetAddress toAddress=null;
                try {
                 fromAddress =new InternetAddress(this.from);
                 toAddress =new InternetAddress(this.to);
                } catch (AddressException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"failed");
        }
                try
                {
                    simpleMessage.setFrom(fromAddress);
                    simpleMessage.setRecipient(RecipientType.TO,toAddress);
                    simpleMessage.setSubject(this.subject);
                    simpleMessage.setText(this.text);
                    Transport transport=session1.getTransport("smtp");
                transport.connect(this.sendingHost,sendingPort,this.userName,this.password);
                transport.sendMessage(simpleMessage,simpleMessage.getAllRecipients());
                transport.close();
                JOptionPane.showMessageDialog(null,"mail sent");
                    
                } catch (MessagingException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"failed");
                }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    /*String[] id=new String[5000];
int[]index=new int[100];
String[] content=new String[5000];
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
      int[] index=jTable1.getSelectedRows();
       for(int j=0;j<index.length;j++)
        { 
            System.out.println(index[j]);  
    }                                    
 DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int j=0;j<index.length;j++)
        {
       id[j]=model.getValueAt(index[j],1).toString();
        System.out.println(id[j]);
         msg=new read();
        msg.sendGmail("priyadharsinir98@gmail.com",id[j],"message read","thank you for contacting us"); 
       content[j]=model.getValueAt(index[j],3).toString();
       JOptionPane.showMessageDialog(null, "Content " + content[j]);
        }
        public static read msg=null;    
     public void readGmail(){

        /*this will print subject of all messages in the inbox of sender@gmail.com*/
 
        /*this.receivingHost="imap.gmail.com";//for imap protocol
 
        Properties props2=System.getProperties();
 
        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here
 
        Session session2=Session.getDefaultInstance(props2, null);

            try {
 
                    Store store=session2.getStore("imaps");
 
                    store.connect(this.receivingHost,this.userName, this.password);
 
                    Folder folder=store.getFolder("INBOX");//get inbox
 
                    folder.open(Folder.READ_ONLY);//open folder only to read
 
                    Message message[]=folder.getMessages();
                    
                      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    for(int i=0;i<message.length;i++){
 
                        //print subjects of all mails in the inbox
              
                        
                       
 Object content = message[i].getContent();
    String contentReturn = null;
    Multipart multipart = (Multipart) content;
        BodyPart part = multipart.getBodyPart(0);
        part.toString();
        contentReturn = part.getContent().toString();
          System.out.println(message[i].getFrom()[0]);
          System.out.println(message[i].getSubject());
          System.out.println(contentReturn);
                    
                    Object[] row = {i,message[i].getFrom()[0],message[i].getSubject(),contentReturn};     
                   model.addRow(row);     
                        
                    }
 
                    //close connections
 
                    folder.close(true);
 
                    store.close();
 
            } catch (Exception e) {
 
                    System.out.println(e.toString());
 
            }

    }*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mail().setVisible(true);
                mail m=new mail();
                String mailFrom=new String("priyadharsinir@gmail.com");
 
        //Sender must be a Gmail Account holder
 
        String mailTo=new String("rash1997mitha@gmail.com");
 
        //but here you can send to any type of mail account
 
        //String senderPassword=new String("1234");
 
        //String senderUserName=new String("sender");
 
        //Mention your email subject and content
 
        String mailSubject=new String("Testing Mail");
 
        String mailText=new String("Have an Nice Day ...........!!!");
 
                m.sendGmail(mailFrom, mailTo, mailSubject, mailText);
                /*try {
                String host="smtp.gmail.com";
                String user="priyadharsinir98@gmail.com";
                String pwd="nivethitha10";
                String to="friendlypriya10@gmail.com";
                String from="Priya Ramesh";
                String subject="mail checking";
                String msgtxt="mail content goes here";
                boolean sessionDebug=false;
                
                Properties props=System.getProperties();
                
                props.put("mail.smtp.starttls.enable","true");
                props.put("mailsmtp.host",host);
                props.put("mail.smtp.port","587");
                props.put("mail.smtp.auth","true");
                props.put("mail.smtp.starttls.required","true");
                
                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                
                Session mailSession=Session.getDefaultInstance(props,null);
                mailSession.setDebug(sessionDebug);
                Message msg=new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                    InternetAddress address = new InternetAddress(to);
                msg.setRecipient(Message.RecipientType.TO,address);
                msg.setSubject(subject);
                msg.setSentDate(new Date());
                msg.setText(msgtxt);
                
                Transport transport=mailSession.getTransport("smtp");
                transport.connect(host,user,pwd);
                transport.sendMessage(msg,msg.getAllRecipients());
                transport.close();
                System.out.println("mail sent");
                
                
                } catch (AddressException ex) {
                    Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(mail.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
