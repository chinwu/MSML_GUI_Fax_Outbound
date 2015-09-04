import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class GUI 
{
    public static JTextField textXmsAddr;
    public static JTextField textLocalAddr;
    public static JTextField txtXmsUser;
    public static JTextField textLocalUser;     
    public static JTextField textLocalPort;
    public static JTextField textXmsPort;
    public static JTextField txtMomlLocation;
    public static JTextField txtRecord;
    public static JCheckBox chckbxSequential;
    
    public static JButton btnStart;
    private static JTextArea logArea;     
    public static JTextField txtDstUser;
    public static JTextField textDstAddress;
    public static JTextField textDstPort;
    public static JButton btnMakeCall;
    private static JCheckBox chckbxLogging;
    
    
    public static void println(String s)    
    {    	
    	if( !GUI.chckbxLogging.isSelected() ) return;
    	if( GUI.logArea.getLineCount()>500)
    	{
    		try
    		{
    			GUI.logArea.replaceRange(null, GUI.logArea.getLineStartOffset(0), GUI.logArea.getLineEndOffset(0) );
    		}
    		catch( Exception e)
    		{
    			e.printStackTrace();
    		}    		
    	}	    	
    	GUI.logArea.append(s + "\n");  
    	GUI.logArea.setCaretPosition(GUI.logArea.getDocument().getLength());
    }

    public static void main(String[] args) 
    {
        JPanel topPanel = new JPanel();
        topPanel.setToolTipText("");
        topPanel.setPreferredSize(new Dimension(600, 250));
        topPanel.setBackground(Color.WHITE);

        //final JTextArea logArea = new JTextArea();
        logArea = new JTextArea();
        logArea.setFont(new Font("Consolas", Font.PLAIN, 10));
        logArea.setRows(40);
        final JScrollPane scrollPane = new JScrollPane(logArea);

        final JPanel mainPanel = new JPanel(new BorderLayout(5,5));
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        btnStart = new JButton("Start");
        btnStart.setFont(new Font("Consolas", Font.PLAIN, 10));
        btnStart.setToolTipText("Click Start button to start this app, after settings are entered.");
      
        btnStart.setBounds(14, 218, 89, 23);
        btnStart.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{        
        		btnStart.setEnabled(false); 
        		btnMakeCall.setEnabled(true);
        		logArea.append("Starting ...\n");
        		new Controller().init();          		       		
        	}      	
        	
        });
        topPanel.setLayout(null);
        topPanel.add(btnStart);
        
        JLabel lblNewLabel = new JLabel("XMS Addr:");
        lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel.setToolTipText("XMS listening address and port. Ths user part must match to XMS for MSML app. Default is MSML.");
        lblNewLabel.setBounds(10, 45, 68, 14);
        topPanel.add(lblNewLabel);
        
        textXmsAddr = new JTextField();
        textXmsAddr.setHorizontalAlignment(SwingConstants.CENTER);
        textXmsAddr.setFont(new Font("Consolas", Font.PLAIN, 10));
        textXmsAddr.setText("192.219.76.228");
        textXmsAddr.setBounds(128, 39, 100, 20);
        topPanel.add(textXmsAddr);
        textXmsAddr.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Local Addr:");
        lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_2.setToolTipText("App server listening address and port.");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setBounds(10, 17, 68, 14);
        topPanel.add(lblNewLabel_2);
        
        textLocalAddr = new JTextField();
        textLocalAddr.setHorizontalAlignment(SwingConstants.CENTER);
        textLocalAddr.setFont(new Font("Consolas", Font.PLAIN, 10));
        textLocalAddr.setText("192.219.76.109");
        textLocalAddr.setBounds(128, 10, 100, 20);
        topPanel.add(textLocalAddr);
        textLocalAddr.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("@");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_3.setBounds(115, 13, 17, 17);
        topPanel.add(lblNewLabel_3);
        
        txtXmsUser = new JTextField();
        txtXmsUser.setFont(new Font("Consolas", Font.PLAIN, 10));
        txtXmsUser.setHorizontalAlignment(SwingConstants.CENTER);
        txtXmsUser.setText("msml");
        txtXmsUser.setBounds(75, 39, 37, 20);
        topPanel.add(txtXmsUser);
        txtXmsUser.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("@");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_4.setBounds(113, 42, 17, 17);
        topPanel.add(lblNewLabel_4);
        
        textLocalUser = new JTextField();
        textLocalUser.setFont(new Font("Consolas", Font.PLAIN, 10));
        textLocalUser.setHorizontalAlignment(SwingConstants.CENTER);
        textLocalUser.setText("1234");
        textLocalUser.setBounds(75, 11, 37, 20);
        topPanel.add(textLocalUser);
        textLocalUser.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel(":");
        lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_5.setBounds(229, 16, 17, 14);
        topPanel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel(":");
        lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_6.setBounds(229, 45, 15, 14);
        topPanel.add(lblNewLabel_6);
        
        textLocalPort = new JTextField();
        textLocalPort.setHorizontalAlignment(SwingConstants.CENTER);
        textLocalPort.setFont(new Font("Consolas", Font.PLAIN, 10));
        textLocalPort.setText("5060");
        textLocalPort.setBounds(234, 10, 37, 20);
        topPanel.add(textLocalPort);
        textLocalPort.setColumns(10);
        
        textXmsPort = new JTextField();
        textXmsPort.setHorizontalAlignment(SwingConstants.CENTER);
        textXmsPort.setFont(new Font("Consolas", Font.PLAIN, 10));
        textXmsPort.setText("5060");
        textXmsPort.setBounds(234, 39, 37, 20);
        topPanel.add(textXmsPort);
        textXmsPort.setColumns(10);
        
        JButton btnClearLog = new JButton("Clear Log");
        btnClearLog.setFont(new Font("Consolas", Font.PLAIN, 10));
        btnClearLog.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		logArea.setText(null);
        	}
        });
        btnClearLog.setBounds(108, 218, 89, 23);
        topPanel.add(btnClearLog);
        
        JLabel lblNewLabel_7 = new JLabel("MOML Script:");
        lblNewLabel_7.setToolTipText("Location of MOML script, in http server (http://) or in XMS server (file://)");
        lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblNewLabel_7.setBounds(285, 14, 86, 14);
        topPanel.add(lblNewLabel_7);
        
        txtMomlLocation = new JTextField();
        txtMomlLocation.setToolTipText("URI of MOML script. Can be file in XMS server (file://) or file in HTTP server (http://).");
        txtMomlLocation.setFont(new Font("Consolas", Font.PLAIN, 10));
        txtMomlLocation.setText("file:///root/script/");
        txtMomlLocation.setBounds(372, 8, 209, 20);
        topPanel.add(txtMomlLocation);
        txtMomlLocation.setColumns(10);
        
        JLabel lblRecording_1 = new JLabel("Send Fax:");
        lblRecording_1.setToolTipText("This app send this moml script when 1 is detected");
        lblRecording_1.setFont(new Font("Consolas", Font.PLAIN, 10));
        lblRecording_1.setBounds(295, 84, 76, 14);
        topPanel.add(lblRecording_1);
        
        txtRecord = new JTextField();
        txtRecord.setFont(new Font("Consolas", Font.PLAIN, 10));
        txtRecord.setText("Faxsend.moml");
        txtRecord.setColumns(10);
        txtRecord.setBounds(371, 81, 210, 20);
        topPanel.add(txtRecord);
        
        chckbxSequential = new JCheckBox("Sequential execution");
        chckbxSequential.setEnabled(false);
        chckbxSequential.setSelected(true);
        chckbxSequential.setToolTipText("Run scripts from top to bottom");
        chckbxSequential.setFont(new Font("Lucida Console", Font.PLAIN, 11));
        chckbxSequential.setBounds(370, 218, 177, 23);
        topPanel.add(chckbxSequential);
        
        txtDstUser = new JTextField();
        txtDstUser.setText("sr140");
        txtDstUser.setHorizontalAlignment(SwingConstants.CENTER);
        txtDstUser.setFont(new Font("Consolas", Font.PLAIN, 10));
        txtDstUser.setColumns(10);
        txtDstUser.setBounds(75, 70, 37, 20);
        topPanel.add(txtDstUser);
        
        JLabel label = new JLabel("@");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Consolas", Font.PLAIN, 10));
        label.setBounds(113, 73, 17, 17);
        topPanel.add(label);
        
        textDstAddress = new JTextField();
        textDstAddress.setHorizontalAlignment(SwingConstants.CENTER);
        textDstAddress.setText("192.219.76.101");
        textDstAddress.setFont(new Font("Consolas", Font.PLAIN, 10));
        textDstAddress.setColumns(10);
        textDstAddress.setBounds(128, 70, 100, 20);
        topPanel.add(textDstAddress);
        
        JLabel label_1 = new JLabel(":");
        label_1.setFont(new Font("Consolas", Font.PLAIN, 10));
        label_1.setBounds(229, 76, 15, 14);
        topPanel.add(label_1);
        
        textDstPort = new JTextField();
        textDstPort.setHorizontalAlignment(SwingConstants.CENTER);
        textDstPort.setText("5060");
        textDstPort.setFont(new Font("Consolas", Font.PLAIN, 10));
        textDstPort.setColumns(10);
        textDstPort.setBounds(234, 70, 37, 20);
        topPanel.add(textDstPort);
        
        btnMakeCall = new JButton("Call");
        btnMakeCall.setEnabled(false);
        btnMakeCall.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		//new Controller();
				Controller.MakeCall();
        	}
        });
        btnMakeCall.setFont(new Font("Consolas", Font.PLAIN, 10));
        btnMakeCall.setBounds(10, 70, 62, 23);
        topPanel.add(btnMakeCall);
        
        chckbxLogging = new JCheckBox("Logging");
        chckbxLogging.setSelected(true);
        chckbxLogging.setFont(new Font("Consolas", Font.PLAIN, 10));
        chckbxLogging.setBounds(204, 217, 70, 23);
        topPanel.add(chckbxLogging);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        JFrame f = new JFrame("MSML Test");
        f.setVisible(true);
        f.setTitle("MSML Outbound Fax Demo");
        f.setResizable(false);
        f.setFont(new Font("Consolas", Font.PLAIN, 10));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(mainPanel);
        f.pack();
    }
}