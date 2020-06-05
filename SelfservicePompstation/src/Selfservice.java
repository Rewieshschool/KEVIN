import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.*;
import java.awt.Button;
import java.awt.Scrollbar;
import java.text.NumberFormat;
import java.util.Scanner;
import java.awt.Choice;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Selfservice {

	private JFrame frame;
	private JTextField textFieldLiters;
	private JTextField txtFieldBedrag;
	private JTextField textkenteken;
	private JButton btnBetaal;
	double unliter;
	double un;
	double test,test2;
	String productPrijs;
	
	DecimalFormat numberFormat = new DecimalFormat("#.##");
	
	//String unliter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selfservice window = new Selfservice();
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
	public Selfservice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10,10, 545, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Unleaded unlead = new Unleaded();
		SuperUnleaded superunlead = new SuperUnleaded();
		Diesel diesel = new Diesel();
		
		JComboBox BoxPomp = new JComboBox();
		
		BoxPomp.addItem("Pomp1");
		BoxPomp.addItem("Pomp2");
		BoxPomp.addItem("Pomp3");
		BoxPomp.addItem("Pomp4");
		BoxPomp.setBounds(136, 8, 96, 21);
		frame.getContentPane().add(BoxPomp);
		
		JComboBox boxStatus = new JComboBox();
		boxStatus.setBounds(406, 218, 47, 21);
		frame.getContentPane().add(boxStatus);
		
		JComboBox BoxProduct = new JComboBox();
		BoxProduct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
                    productPrijs=BoxProduct.getSelectedItem().toString();
                
                    if (productPrijs=="Diesel") {
                    	//pay.getPriceDiesel();
                    	test2=diesel.prijs;
                    	//if(Double.parseDouble(txtFieldBedrag.getText())/Double.parseDouble(productPrijs)) ||
                    	//((Double.parseDouble(textFieldLiters.getText()) * test2);
                    }
                    else if (productPrijs=="Unleaded") {
                    	//txtfld1.setText(Double.toString(unlead.prijs));
                    }
                    else if (productPrijs=="Super Unleaded") {
                    	//txtfld1.setText(Double.toString(superunlead.prijs));
                    	
                    }
			}
			}});
		BoxProduct.addItem("Unleaded");
		BoxProduct.addItem("SuperUnleaded");
		BoxProduct.addItem("Diesel");
		BoxProduct.setBounds(136, 101, 96, 21);
		frame.getContentPane().add(BoxProduct);
		
		JTextArea textAreaDisplay = new JTextArea();
		textAreaDisplay.setBounds(10, 216, 242, 137);
		frame.getContentPane().add(textAreaDisplay);
		
		textFieldLiters = new JTextField();
		textFieldLiters.setBounds(136, 72, 96, 19);
		frame.getContentPane().add(textFieldLiters);
		textFieldLiters.setColumns(10);
		
		txtFieldBedrag = new JTextField();
		txtFieldBedrag.setColumns(10);
		txtFieldBedrag.setBounds(136, 44, 96, 19);
		frame.getContentPane().add(txtFieldBedrag);
		
		JLabel lblBedrag = new JLabel("BEDRAG SRD");
		lblBedrag.setHorizontalAlignment(SwingConstants.LEFT);
		lblBedrag.setBounds(46, 47, 90, 13);
		frame.getContentPane().add(lblBedrag);
		
		JLabel lblAantalLiters = new JLabel("AANTAL LITERS");
		lblAantalLiters.setHorizontalAlignment(SwingConstants.LEFT);
		lblAantalLiters.setBounds(34, 75, 102, 13);
		frame.getContentPane().add(lblAantalLiters);
		
		JLabel lblPomp = new JLabel("POMP");
		lblPomp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomp.setBounds(46, 12, 90, 13);
		frame.getContentPane().add(lblPomp);
		
		JLabel lblkenteken = new JLabel("KENTEKEN");
		lblkenteken.setHorizontalAlignment(SwingConstants.CENTER);
		lblkenteken.setBounds(34, 132, 102, 13);
		frame.getContentPane().add(lblkenteken);
		
		JButton btnDeblokkeer = new JButton("Deblok Pomp");
		btnDeblokkeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxPomp.setEnabled(true);
			}
		});
		btnDeblokkeer.setBounds(372, 10, 132, 21);
		frame.getContentPane().add(btnDeblokkeer);
		
		JButton btnBlokkeerPomp = new JButton("Blok Pomp");
		btnBlokkeerPomp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoxPomp.setEnabled(false);
			}
		});
		btnBlokkeerPomp.setBounds(372, 47, 132, 21);
		frame.getContentPane().add(btnBlokkeerPomp);
		
		
		
		textkenteken = new JTextField();
		textkenteken.setColumns(10);
		textkenteken.setBounds(136, 129, 96, 19);
		frame.getContentPane().add(textkenteken);
		Frame pomp= new Frame();
		Frame soort= new Frame();
		
		
		JLabel lblstatus = new JLabel("POMP STATUS");
		lblstatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblstatus.setBounds(306, 222, 102, 13);
		frame.getContentPane().add(lblstatus);
		
		JLabel lblproduct = new JLabel("PRODUCT");
		lblproduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblproduct.setBounds(34, 101, 102, 13);
		frame.getContentPane().add(lblproduct);
		//Image image = new ImageIcon(this.getClass().getResource("smurf01.png")).getImage();
		
		//
	    // unliter = (txtFieldBedrag.getText());
		
		
		
		btnBetaal = new JButton("PAY");
//		btnBetaal.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//
//
//				unliter = Double.parseDouble(txtFieldBedrag.getText());
//				un = (unliter/unlead.prijs);
//				//un = Double.parseDouble(lstsoort.getItem(lstsoort.getSelectedIndex()));
//
//				textAreaDisplay.setText((BoxPomp.getItemAt(BoxPomp.getSelectedIndex()))+"  "
//			+(BoxProduct.getItemAt(BoxProduct.getSelectedIndex()))+"   "
//			+(textkenteken.getText())+"\n"+" SRD "+(txtFieldBedrag.getText()));
//					textFieldLiters.setText(numberFormat.format((un)));
//
//
//				System.out.println(numberFormat.format((un)));
//
//			}
//		});

		btnBetaal.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable runnable = new Runnable() {

//					Double unliter = Double.parseDouble(txtFieldBedrag.getText());
//					Double un = (unliter/unlead.prijs);
					Double bedrag = Double.parseDouble((txtFieldBedrag.getText()));
					Double aantalLiters = bedrag/unlead.prijs;
					Double counter = 0.0;
					NumberFormat numberFormat = new DecimalFormat("##.00");

					@Override
					public void run() {
						while (true) {
							while (counter <= aantalLiters /*&& bedrag == 0*/){
								SwingUtilities.invokeLater(new Runnable() {
									@Override
									public void run() {
										textAreaDisplay.setText((String) BoxPomp.getItemAt(BoxPomp.getSelectedIndex())
																+ "\n"
																+ "Bedrag: "
																+ bedrag
//																+ "\n" + aantalLiters
																+ "\n"
																+ "Liters: "
//																+
																+ String.valueOf(numberFormat.format(counter)));

										textFieldLiters.setText(numberFormat.format(aantalLiters));
									}
								});

								counter = counter + 0.01;
//								bedrag = bedrag - bedrag/aantalLiters;
								try {
									Thread.sleep(15);
								}catch (InterruptedException exception){
									System.out.println(exception.toString());
								}
							}
						}
					}
				};
				new Thread(runnable).start();
			}
		});

//		btnBetaal

		btnBetaal.setHorizontalAlignment(SwingConstants.RIGHT);
		btnBetaal.setIcon(new ImageIcon("D:\\bk\\Leerwijzer_en_literatuur\\jaar2\\JAVA\\money.png"));
		btnBetaal.setBounds(136, 159, 95, 47);
		frame.getContentPane().add(btnBetaal);
	}

	public static String nvl(String value, String alternateValue) {
		if (value == null)
			return alternateValue;

		return value;
	}
}
