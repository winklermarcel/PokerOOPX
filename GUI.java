package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField tfStrom;
	private JTextField tfWasser;
	
	private boolean wasser;
	private boolean wasserKomma = true;
	private boolean strom;
	private boolean stromKomma = true;
	
	private String wasservb = "http://192.168.0.111:821/consumption?typ=wasser&date=20160329&value=222.99";
	private String stromvb = "http://192.168.0.111:821/consumption?typ=strom&date=20160329&value=222.99";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	JButton buttonNR1 = new JButton("1");
	JButton buttonNR2 = new JButton("2");
	JButton buttonNR3 = new JButton("3");
	JButton buttonNR4 = new JButton("4");
	JButton buttonNR5 = new JButton("5");
	JButton buttonNR6 = new JButton("6");
	JButton buttonNR7 = new JButton("7");
	JButton buttonNR8 = new JButton("8");
	JButton buttonNR9 = new JButton("9");
	JButton buttonNR0 = new JButton("0");
	JButton buttonKomma = new JButton(".");
	
	JButton btnSendenWasser = new JButton("Senden");
	JButton btnSendenStrom = new JButton("Senden");
	
	JLabel lblZST = new JLabel("Z\u00E4hlerstand");



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblZhlerstandStrom = new JLabel("Z\u00E4hlerstand Strom:");
		lblZhlerstandStrom.setBounds(15, 15, 100, 14);
		frame.getContentPane().add(lblZhlerstandStrom);
		
		tfStrom = new JTextField();
		tfStrom.addMouseListener(new TextFieldStromListener());
		
		tfStrom.setBounds(125, 12, 100, 20);
		frame.getContentPane().add(tfStrom);
		tfStrom.setColumns(10);
		
		btnSendenStrom.addActionListener(new SendButtonStromListener());
		
		btnSendenStrom.setBounds(235, 11, 89, 23);
		frame.getContentPane().add(btnSendenStrom);
		
		JLabel lblZhlerstandWasser = new JLabel("Z\u00E4hlerstand Wasser:");
		lblZhlerstandWasser.setBounds(15, 50, 100, 14);
		frame.getContentPane().add(lblZhlerstandWasser);
		
		tfWasser = new JTextField();
		tfWasser.addMouseListener(new TextFieldWasserListener());
		
		tfWasser.setBounds(125, 47, 100, 20);
		frame.getContentPane().add(tfWasser);
		tfWasser.setColumns(10);
		
		btnSendenWasser.addActionListener(new SendButtonWasserListener());
		
		btnSendenWasser.setBounds(235, 46, 89, 23);
		frame.getContentPane().add(btnSendenWasser);
		
		buttonNR1.addActionListener(new ButtonActionListener1());
		
		buttonNR1.setBounds(15, 95, 50, 23);
		frame.getContentPane().add(buttonNR1);

		buttonNR2.addActionListener(new ButtonActionListener2());
		
		buttonNR2.setBounds(65, 95, 50, 23);
		frame.getContentPane().add(buttonNR2);

		buttonNR3.addActionListener(new ButtonActionListener3());

		buttonNR3.setBounds(115, 95, 50, 23);
		frame.getContentPane().add(buttonNR3);

		buttonNR4.addActionListener(new ButtonActionListener4());

		buttonNR4.setBounds(15, 120, 50, 23);
		frame.getContentPane().add(buttonNR4);

		buttonNR5.addActionListener(new ButtonActionListener5());

		buttonNR5.setBounds(65, 120, 50, 23);
		frame.getContentPane().add(buttonNR5);

		buttonNR6.addActionListener(new ButtonActionListener6());

		buttonNR6.setBounds(115, 120, 50, 23);
		frame.getContentPane().add(buttonNR6);

		buttonNR7.addActionListener(new ButtonActionListener7());

		buttonNR7.setBounds(15, 145, 50, 23);
		frame.getContentPane().add(buttonNR7);

		buttonNR8.addActionListener(new ButtonActionListener8());

		buttonNR8.setBounds(65, 145, 50, 23);
		frame.getContentPane().add(buttonNR8);

		buttonNR9.addActionListener(new ButtonActionListener9());

		buttonNR9.setBounds(115, 145, 50, 23);
		frame.getContentPane().add(buttonNR9);
		
		buttonKomma.addActionListener(new KommaBtnActionListener());
		
		buttonKomma.setBounds(15, 168, 50, 23);
		frame.getContentPane().add(buttonKomma);

		buttonNR0.addActionListener(new ButtonActionListener0());

		buttonNR0.setBounds(65, 168, 50, 23);
		frame.getContentPane().add(buttonNR0);
		
		lblZST.setBounds(235, 99, 70, 14);
		frame.getContentPane().add(lblZST);
	}
	
	private class ButtonActionListener1 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR1.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR1.getText());
			}
		}
	}
	
	private class ButtonActionListener2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR2.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR2.getText());
			}
		}
	}
	
	private class ButtonActionListener3 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR3.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR3.getText());
			}
		}
	}
	
	private class ButtonActionListener4 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR4.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR4.getText());
			}
		}
	}
	
	private class ButtonActionListener5 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR5.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR5.getText());
			}
		}
	}
	
	private class ButtonActionListener6 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR6.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR6.getText());
			}
		}
	}
	
	private class ButtonActionListener7 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR7.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR7.getText());
			}
		}
	}
	
	private class ButtonActionListener8 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR8.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR8.getText());
			}
		}
	}
	
	private class ButtonActionListener9 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR9.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR9.getText());
			}
		}
	}
	
	private class ButtonActionListener0 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(wasser){
			tfWasser.setText(tfWasser.getText() + buttonNR0.getText());
			}
			if(strom){
			tfStrom.setText(tfStrom.getText() + buttonNR0.getText());
			}
		}
	}

	private class KommaBtnActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(wasser && wasserKomma){
			tfWasser.setText(tfWasser.getText() + buttonKomma.getText());
			wasserKomma = false;
			}
			else if(wasser && !wasserKomma) {
				tfWasser.setText("Nur 1 Komma moeglich!");
			}
		
			if(strom && stromKomma){
			tfStrom.setText(tfStrom.getText() + buttonKomma.getText());
			stromKomma = false;
			}
			else if(strom && !stromKomma){
				tfStrom.setText("Nur 1 Komma moeglich!");
			}
		}
	}
	
	
	private class TextFieldWasserListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			wasser = true;
			strom = false;
		}
	}
	
	private class TextFieldStromListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			wasser = false;
			strom = true;
		}
	}
	
	private class SendButtonWasserListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			wasservb = "http://192.168.0.111:821/consumption?typ=wasser&date=20160329&value="+tfWasser.getText();
		}
	}
	
	private class SendButtonStromListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			stromvb = "http://192.168.0.111:821/consumption?typ=strom&date=20160329&value="+tfStrom.getText();
		}
	}
	//SwingWorker beginn
	
	 private class AnswerWorker extends SwingWorker<String, String> {
	       protected String doInBackground() throws Exception
	       {
	           // Do a time-consuming task.
	           Thread.sleep(2000);
	           String myAnswer = downloadUrl(wasservb);
	           return myAnswer;
	       }
	 
	       protected void done()
	       {
	           try
	           {
	               lblZST.setText(get());
	           }
	           catch (Exception e)
	           {
	               e.printStackTrace();
	           }
	       }
	        
	        
	       // Given a URL, establishes an HttpUrlConnection and retrieves
	       // the web page content as a InputStream, which it returns as
	       // a string.
	       private String downloadUrl(String myurl) throws IOException {
	           InputStream is = null;
	           // Only display the first 500 characters of the retrieved
	           // web page content.
	           int len = 500;
	 
	           try {
	               URL url = new URL(myurl);
	               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	               conn.setReadTimeout(10000 /* milliseconds */);
	               conn.setConnectTimeout(15000 /* milliseconds */);
	               conn.setRequestMethod("GET");
	               conn.setDoInput(true);
	               // Starts the query
	               conn.connect();
	               int response = conn.getResponseCode();
	               is = conn.getInputStream();
	 
	               // Convert the InputStream into a string
	               //String contentAsString = readIt(is, len);
	               return readIt(is, len);
	               // Makes sure that the InputStream is closed after the app is
	               // finished using it.
	           } finally {
	               if (is != null) {
	                   is.close();
	               }
	           }
	       }
	       // Reads an InputStream and converts it to a String.
	       public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
	           Reader reader = null;
	           reader = new InputStreamReader(stream, "UTF-8");
	           char[] buffer = new char[len];
	           reader.read(buffer);
	           return new String(buffer);
	       }      
	   }
}
