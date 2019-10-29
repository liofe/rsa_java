package hoang.rsa.algorithm;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

//import GUI.MainFrame;

public class MainFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	static int bitleg = 256;
	//static BigInteger ciphertext;
	static Algorithm rsa;
	static Data data;
	public MainFrame(){
        creatAndShow();
        textFieldPrivateKey.setEnabled(false);
        textFieldPublicKey.setEnabled(false);
        textFieldN.setEnabled(false);
        textAreaInput.setEnabled(false);
        textAreaOutput.setEnabled(false);
        buttonSign.setEnabled(false);
        buttonCheck.setEnabled(false);
        buttonHash.setEnabled(false);
        buttonDecrypt.setEnabled(false);
        itemSavePublicKey.setEnabled(false);
        itemSavePrivateKey.setEnabled(false);
        itemSaveDataSigned.setEnabled(false);
      
        rsa = new Algorithm();
        rsa.KeyRSA(bitleg);
        data = new Data();
    }

    private void creatAndShow() {

        frame = new JFrame("RSA");
        frame.setSize(890 , 540);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        
       
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.add(menuOption);
        menuBar.add(menuHelp);
        
        
        
        menuOption.add(itemCreatKey);
        menuOption.add(itemInputPublicKey);
        menuOption.add(itemInputPrivateKey);
        
        menuOption.add(itemInputData);
        menuOption.add(itemInputDataSigned);
        menuOption.add(itemSavePublicKey);
        menuOption.add(itemSavePrivateKey);
        
        menuOption.add(itemSaveDataSigned);
        menuOption.add(itemReset);
        menuOption.add(itemExit);
        //bắt sự kiện input
        itemInputData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemInputDataActionPerformed(e);
			}
		});
        //bắt sự kiện creatkey
        itemCreatKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemCreatKeyActionPerformed(e);
			}
		});
        //bắt sự kiện lưu publickey
        itemSavePublicKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSavePublicKeyActionPerformed(e);
			}
		});
        //bắt sự kiện lưu privatekey
        itemSavePrivateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSavePrivateKeyActionPerformed(e);
			}
		});
        itemSaveDataSigned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemSaveDataSignedActionPerformed(e);
			}
		});
        itemInputPublicKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					itemInputPublicKeyActionPerformed(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
        itemInputPrivateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					itemInputPrivateKeyActionPerformed(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
        itemReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemResetActionPerformed(e);
			}
		});
        itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemExitActionPerformed(e);
			}
		});
        itemInputDataSigned.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					itemInputDataSignedActionPerformed(e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
       
        buttonSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSignActionPerformed(e);
			}
		});
        buttonCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCheckActionPerformed(e);
			}
		});
        buttonHash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonHashActionPerformed(e);
			}
		});
        buttonDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonDecryptActionPerformed(e);
			}
		});
        panelTotal.setBackground(Color.cyan);
        panelTotal.setSize(600, 600);
        label3.setFont(new java.awt.Font("Times New Roman", 1, 13));
        label3.setForeground(new java.awt.Color(204,0,0));
        label3.setOpaque(true);
        label3.setBackground(Color.cyan);
        
        //label4 = new JLabel();
        
        icon = new ImageIcon(getClass().getResource("/hoang/rsa/algorithm/logo_soict.png"));
        label4.setIcon(icon);
        label4.setFont(new java.awt.Font("Times New Roman", 1, 18));
        label4.setForeground(new java.awt.Color(204, 0, 0));
        label4.setText("<html><div>HANOI UNIVERSITY OF SCIENCE AND TECHNOLOGY <br> School of Information and Communication Technology<div><html>");
        
        
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(Color.gray);
        panel1.add(textFieldPrivateKey);
        panel1.setBorder(BorderFactory.createTitledBorder(null,"Private Key",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel2.setBackground(Color.gray);
        panel2.setLayout(new FlowLayout());
        panel2.add(textFieldPublicKey);
        panel2.setBorder(BorderFactory.createTitledBorder(null,"Public Key",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel3.setLayout(new FlowLayout());
        panel3.setBackground(Color.gray);
        panel3.add(textFieldN);
        panel3.setBorder(BorderFactory.createTitledBorder(null,"N",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel4.setBorder(BorderFactory.createTitledBorder(null,"Input",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel4.setLayout(new FlowLayout());
        panel4.setBackground(Color.gray);
        panel4.add(textFieldInput);
        panel5.setLayout(new FlowLayout());
        panel5.setBackground(Color.gray);
        panel5.add(textAreaInput);
        panel5.setBorder(BorderFactory.createTitledBorder(null,"Hash Input",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel6.setLayout(new FlowLayout());
        panel6.setBackground(Color.gray);
        panel6.add(textAreaOutput);
        panel6.setBorder(BorderFactory.createTitledBorder(null,"Output",javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tohoma", 0, 14)));
        panel7.setLayout(new FlowLayout());
        panel7.setBackground(Color.gray);
        panel7.add(buttonHash);
        panel7.add(buttonSign);
        panel7.add(buttonDecrypt);
        panel7.add(buttonCheck);
       
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelTotal.setLayout(gridBagLayout);
        GridBagConstraints bagConstraints = new GridBagConstraints();
        
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 0;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridwidth = 2;
        panelTotal.add(label4, bagConstraints);
        
        
       
        
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 1;
        bagConstraints.gridwidth = 1;
        panelTotal.add(panel1, bagConstraints);
        bagConstraints.gridx = 1;
        //bagConstraints.gridy = 1;
        panelTotal.add(panel2, bagConstraints);
        
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 2;
        panelTotal.add(panel3, bagConstraints);
        
        bagConstraints.gridx = 1;
        //bagConstraints.gridy = 2;
        panelTotal.add(panel4, bagConstraints);
        
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 3;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridwidth = 2;
        panelTotal.add(panel5, bagConstraints);
        
        
        bagConstraints.gridy = 4;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        bagConstraints.gridwidth = 2;
        panelTotal.add(panel6, bagConstraints);
        
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 5;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panelTotal.add(panel7, bagConstraints);
        
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 6;
        bagConstraints.fill = GridBagConstraints.HORIZONTAL; 
        panelTotal.add(label3, bagConstraints);
        
        frame.add(panelTotal);
        //frame.pack();
        frame.setVisible(true);
        
    }
    //creatkey
    private void itemCreatKeyActionPerformed(ActionEvent e) {
    	rsa.KeyRSA(bitleg);
    	textFieldPrivateKey.setText(rsa.getD().toString());
    	textFieldPublicKey.setText(rsa.getE().toString());
    	textFieldN.setText(rsa.getN().toString());
    	rsa.setD(new BigInteger(textFieldPrivateKey.getText()));
    	rsa.setE(new BigInteger(textFieldPublicKey.getText()));
    	rsa.setN(new BigInteger(textFieldN.getText()));
    	buttonSign.setEnabled(true);
    	buttonCheck.setEnabled(true);
    	itemSavePublicKey.setEnabled(true);
    	itemSavePrivateKey.setEnabled(true);
    	
    	
    }
    //nhập file đầu vào
    private void itemInputDataActionPerformed(ActionEvent e) {
    	JFileChooser chooser = new JFileChooser();
    	FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "docx", "doc", "exe", "xls", "xlsx", "jpg", "png", "mp3", "mp4", "flv", "ico", "txt");
    	chooser.setFileFilter(filter);
    	int returnVal = chooser.showOpenDialog(null);
    	if(returnVal == JFileChooser.APPROVE_OPTION) {
    		File file = chooser.getSelectedFile();
    		String attach = file.toString();
    		textFieldInput.setText(attach);
    	}
    	buttonHash.setEnabled(true);
    }
    //lưu publickey
    private void itemSavePublicKeyActionPerformed(ActionEvent e) {
    	BigInteger e1 =new BigInteger(textFieldPublicKey.getText());
    	BigInteger n1 = new BigInteger(textFieldN.getText());
    	try {
    		data.OutputWrite(data.getSaveLocation(), e1,n1, "publickey.txt");
    	}catch(FileNotFoundException ex) {
    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
    	}
    }
    //Lưu privatekey
    private void itemSavePrivateKeyActionPerformed(ActionEvent e) {
    	BigInteger d1 =new BigInteger(textFieldPrivateKey.getText());
    	BigInteger n1 = new BigInteger(textFieldN.getText());
    	try {
    		data.OutputWrite(data.getSaveLocation(), d1,n1, "privatekey.txt");
    	}catch(FileNotFoundException ex) {
    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    	}
    }
   
    //Lưu dữ liệu sau khi đã kí
    private void itemSaveDataSignedActionPerformed(ActionEvent e) {
    	BigInteger bigInteger = new BigInteger(textAreaOutput.getText());
        try {
            data.OutputWrite(data.getSaveLocation(), bigInteger,null, "DigitalSignature.txt");
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    //nếu có file public key thì nhập
    private void itemInputPublicKeyActionPerformed(ActionEvent e) throws IOException {
    	FileReader fr = new FileReader(data.getOpenLocation());
    	BufferedReader br = new BufferedReader(fr);
    	String s = null, str;
		while((str = br.readLine())!=null) {
    		s = s + " " + str;
    	}
		String[] st = s.split(" ");
    	br.close();
    	fr.close();
    	textFieldPublicKey.setText(st[1]);
    	textFieldN.setText(st[2]);
    	buttonDecrypt.setEnabled(true);
    }
  //nếu có file private key thì nhập
    private void itemInputPrivateKeyActionPerformed(ActionEvent e) throws IOException {
    	FileReader fr = new FileReader(data.getOpenLocation());
    	BufferedReader br = new BufferedReader(fr);
    	String s = null, str;
		while((str = br.readLine())!=null) {
    		s = s + " " + str;
    	}
		String[] st = s.split(" ");
    	br.close();
    	fr.close();
    	textFieldPrivateKey.setText(st[1]);
    	textFieldN.setText(st[2]);
    	buttonSign.setEnabled(true);
    }
    //reset chương trình
    private void itemResetActionPerformed(ActionEvent e) {
    	textFieldPrivateKey.setText("");
    	textFieldPublicKey.setText("");
    	textFieldN.setText("");
    	textFieldInput.setText("");
    	textAreaInput.setText("");
    	textAreaOutput.setText("");
    	itemSavePublicKey.setEnabled(false);
    	itemSavePrivateKey.setEnabled(false);
    	itemSaveDataSigned.setEnabled(false);
    	buttonCheck.setEnabled(false);
    	buttonSign.setEnabled(false);
    	buttonHash.setEnabled(false);
    }
    // exit
    private void itemExitActionPerformed(ActionEvent e) {
    	frame.dispose();
    }
    private void itemInputDataSignedActionPerformed(ActionEvent e) throws IOException {
    	FileReader fr = new FileReader(data.getOpenLocation());
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		br.close();
		fr.close();
    	textAreaInput.setText(str);
    	buttonDecrypt.setEnabled(true);
    }
    //băm dữ liệu vào
    private void buttonHashActionPerformed(ActionEvent e) {
    	String filename = textFieldInput.getText();
    	filename = filename.replace('\\', '/');
    	if("".equals(filename)) {
    		JOptionPane.showMessageDialog(null, "NO INPUT DATA", "Notification",JOptionPane.ERROR_MESSAGE);
    	}else {
    		SHA sha = new SHA();
    		try {
    			BigInteger sha1 = new BigInteger(sha.md(filename).abs().toString());
    			textAreaInput.setText(sha1.toString());
    		}catch(Exception ex) {
    			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
    		}
    	}
    	buttonCheck.setEnabled(true);
    	buttonSign.setEnabled(true);
    }
    // sign data
    private void buttonSignActionPerformed(ActionEvent e) {
    	rsa.setD(new BigInteger(textFieldPrivateKey.getText()));
    	rsa.setN(new BigInteger(textFieldN.getText()));
    	System.out.println(""+rsa.getD());
    	System.out.println(""+rsa.getN());
    	BigInteger sha2 = new BigInteger(textAreaInput.getText());
    	textAreaOutput.setText(rsa.encrypt(sha2).toString());
    	itemSaveDataSigned.setEnabled(true);
    	JOptionPane.showMessageDialog(null, "You signed up successfully...!");
    }
    //giai ma
    private void buttonDecryptActionPerformed(ActionEvent e) {
    	rsa.setE(new BigInteger(textFieldPublicKey.getText()));
    	rsa.setN(new BigInteger(textFieldN.getText()));
    	System.out.println(""+rsa.getE());
    	System.out.println(""+rsa.getN());
    	BigInteger dsrsa = new BigInteger(textAreaInput.getText().toString(),10);
        textAreaOutput.setText(rsa.decrypt(dsrsa).toString());
    }
    
    // check data
    private void buttonCheckActionPerformed(ActionEvent e) {
    	if (textAreaInput.getText().equals(textAreaOutput.getText())) {
            JOptionPane.showMessageDialog(null, "The data is not changed", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Data has been changed", "Notification", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
    public BufferedReader getBr() {
		return br;
	}
	public void setBr(BufferedReader br) {
		this.br = br;
	}
	JMenu menuOption = new JMenu("Option");
    
    JMenuItem itemCreatKey = new JMenuItem("Creat Key");
    JMenuItem itemSavePublicKey = new JMenuItem("Save Public Key");
    JMenuItem itemSavePrivateKey = new JMenuItem("Save Private Key");
    JMenuItem itemSaveDataSigned = new JMenuItem("Save Data Signed");
    JMenuItem itemInputData = new JMenuItem("Input Data");
    JMenuItem itemInputPublicKey = new JMenuItem("Input Public Key");
    JMenuItem itemInputPrivateKey = new JMenuItem("Input Private Key");
    JMenuItem itemReset = new JMenuItem("Reset");
    JMenuItem itemExit = new JMenuItem("Exit");
    JMenuItem itemInputDataSigned = new JMenuItem("Input Data Signed");
    JMenu menuHelp = new JMenu("Help");
    JButton buttonSign = new JButton("Sign");
    JButton buttonCheck = new JButton("Check");
    JButton buttonHash = new JButton("Hash");
    JButton buttonDecrypt = new JButton("Decypt");
    JLabel label3 = new JLabel("PHI DUC HOANG - 20151562 <====> GVHD:TS.PHAM VAN HAI", JLabel.CENTER);
    JLabel label4 = new JLabel();
    JTextField textFieldPrivateKey = new JTextField(50);
    JTextField textFieldPublicKey = new JTextField(50);
    JTextField textFieldInput = new JTextField(50);
    JTextField textFieldN = new JTextField(50);
    JTextArea textAreaInput = new JTextArea(5,100);  
    JTextArea textAreaOutput = new JTextArea(5,100);
    JPanel panelTotal = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
	private BufferedReader br;
	private ImageIcon icon;
}


