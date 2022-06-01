package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	private JButton btnCalculate;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textEps;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblApproAns;
	private JLabel lblNewLabel_5;
	private JLabel lblIterations;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static double[] test(double number, double error)
	{
		int i = 1;
		double answer = number/2;
		double square= answer*answer;
		double difference = answer/2;
		System.out.println("error = "+error);
		while (Math.abs(number - (square)) > error)		
		{
			if (square>number)
				answer -= difference;
			else 
				answer += difference;
			difference /= 2;
			System.out.println(i);
			System.out.println(answer);
			System.out.println(difference);
			i++;
			square = answer*answer;
		}
		
		double[] answers = {answer,i};
		return answers;
	}
	public MainFrame() {
		setTitle("Square root calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Centrarea form-ului
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)size.getWidth();
		int height = (int)size.getHeight();
		int framewidth = 600;
		int frameheight = 400;
		setBounds(width/2-framewidth/2, height/2-frameheight*3/5, framewidth, frameheight);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textNum = new JTextField();
		textNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNum.setHorizontalAlignment(SwingConstants.RIGHT);
		textNum.setText("13");
		textNum.setBounds(108, 121, 95, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 124, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Epsilon");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(23, 180, 95, 20);
		contentPane.add(lblNewLabel_2);
		
		textEps = new JTextField();
		textEps.setText("0.0001");
		textEps.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textEps.setHorizontalAlignment(SwingConstants.RIGHT);
		textEps.setBounds(108, 180, 95, 20);
		contentPane.add(textEps);
		textEps.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Square root calculator");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Cascadia Code", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(108, 11, 396, 29);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(242, 80, 317, 175);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Answer");
		lblNewLabel_4.setBounds(10, 23, 57, 22);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblApproAns = new JLabel("0");
		lblApproAns.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApproAns.setBounds(126, 27, 181, 14);
		panel.add(lblApproAns);
		lblApproAns.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApproAns.setForeground(new Color(0, 128, 0));
		
		lblNewLabel_5 = new JLabel("Iterations");
		lblNewLabel_5.setBounds(10, 76, 82, 14);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblIterations = new JLabel("0");
		lblIterations.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIterations.setBounds(126, 76, 181, 14);
		panel.add(lblIterations);
		lblIterations.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIterations.setForeground(new Color(0, 128, 0));
		
		
		
		JLabel lblAns = new JLabel("0");
		lblAns.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAns.setForeground(new Color(0, 128, 0));
		lblAns.setBounds(126, 133, 181, 14);
		panel.add(lblAns);
		lblAns.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		lblNewLabel = new JLabel("True answer");
		lblNewLabel.setBounds(10, 133, 106, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(new Color(169, 169, 169));
		btnCalculate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//double ans = Math.sqrt(Double.parseDouble(textNum.getText()));
				double num = Double.parseDouble(textNum.getText());
				double[] ans = test(Double.parseDouble(textNum.getText()),Double.parseDouble(textEps.getText()));
				lblApproAns.setText(String.valueOf(ans[0]));
				lblAns.setText(String.valueOf(Math.sqrt(Double.parseDouble(textNum.getText()))));
				lblIterations.setText(String.valueOf(ans[1]));
			}
		});
		btnCalculate.setBounds(178, 291, 209, 44);
		contentPane.add(btnCalculate);
	}
}
