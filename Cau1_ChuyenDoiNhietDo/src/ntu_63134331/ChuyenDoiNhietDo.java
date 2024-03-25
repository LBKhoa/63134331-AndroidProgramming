package ntu_63134331;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChuyenDoiNhietDo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtC;
	private JTextField txtF;
	private JTextField txtK;
	private JTextField txtR;
	private JTextField txtD;
	private JTextField txtN;
	private JRadioButton rdbtnC, rdbtnF, rdbtnK, rdbtnR, rdbtnD, rdbtnN;
	private ButtonGroup buttonGroup;
	

	
	public ChuyenDoiNhietDo() {
		setTitle("Chuyển Đổi Các Đơn Vị Nhiệt Độ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 631);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHUYỂN ĐỔI CÁC ĐƠN VỊ NHIỆT ĐỘ");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(302, 10, 378, 74);
		contentPane.add(lblNewLabel);
		
		txtC = new JTextField();
		txtC.setBounds(263, 105, 209, 37);
		contentPane.add(txtC);
		txtC.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("(°C)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(477, 106, 41, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnCD = new JButton("Chuyển Đổi");
		btnCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kiểm tra xem RadioButton nào đang được chọn
                if (rdbtnC.isSelected()) {
                    chuyenDoiCelsius();
                } else if (rdbtnF.isSelected()) {
                    chuyenDoiFahrenheit();
                } else if (rdbtnK.isSelected()) {
                    chuyenDoiKelvin();
                } else if (rdbtnR.isSelected()) {
                    chuyenDoiRankine();
                } else if (rdbtnD.isSelected()) {
                    chuyenDoiDelisle();
                } else if (rdbtnN.isSelected()) {
                    chuyenDoiNewton();
                }
			}
		});
		btnCD.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCD.setBounds(553, 105, 157, 29);
		contentPane.add(btnCD);
		
		rdbtnC = new JRadioButton("Celcius");
		rdbtnC.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnC.setBounds(111, 105, 103, 37);
		contentPane.add(rdbtnC);
		
		rdbtnF = new JRadioButton("Fahrenheit");
		rdbtnF.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnF.setBounds(111, 171, 133, 37);
		contentPane.add(rdbtnF);
		
		txtF = new JTextField();
		txtF.setColumns(10);
		txtF.setBounds(263, 174, 209, 37);
		contentPane.add(txtF);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("(°F)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(477, 175, 41, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		rdbtnK = new JRadioButton("Kelvin");
		rdbtnK.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnK.setBounds(111, 237, 103, 37);
		contentPane.add(rdbtnK);
		
		txtK = new JTextField();
		txtK.setColumns(10);
		txtK.setBounds(263, 240, 209, 37);
		contentPane.add(txtK);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("(°K)");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(477, 241, 41, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		rdbtnR = new JRadioButton("Rankine");
		rdbtnR.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnR.setBounds(111, 308, 103, 37);
		contentPane.add(rdbtnR);
		
		txtR = new JTextField();
		txtR.setColumns(10);
		txtR.setBounds(263, 311, 209, 37);
		contentPane.add(txtR);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("(°Ra)");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(477, 312, 57, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		rdbtnD = new JRadioButton("Delisle");
		rdbtnD.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnD.setBounds(111, 373, 103, 37);
		contentPane.add(rdbtnD);
		
		txtD = new JTextField();
		txtD.setColumns(10);
		txtD.setBounds(263, 376, 209, 37);
		contentPane.add(txtD);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("(°D)");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(477, 377, 41, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		rdbtnN = new JRadioButton("Newton");
		rdbtnN.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnN.setBounds(111, 452, 103, 37);
		contentPane.add(rdbtnN);
		
		txtN = new JTextField();
		txtN.setColumns(10);
		txtN.setBounds(263, 452, 209, 37);
		contentPane.add(txtN);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("(°N)");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(477, 459, 41, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		// Khởi tạo và thêm các RadioButton vào ButtonGroup
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnC);
        buttonGroup.add(rdbtnF);
        buttonGroup.add(rdbtnK);
        buttonGroup.add(rdbtnR);
        buttonGroup.add(rdbtnD);
        buttonGroup.add(rdbtnN);
		
		// Thêm sự kiện cho các JRadioButton
        rdbtnC.addItemListener(new RadioButtonHandler(txtC));
        rdbtnF.addItemListener(new RadioButtonHandler(txtF));
        rdbtnK.addItemListener(new RadioButtonHandler(txtK));
        rdbtnR.addItemListener(new RadioButtonHandler(txtR));
        rdbtnD.addItemListener(new RadioButtonHandler(txtD));
        rdbtnN.addItemListener(new RadioButtonHandler(txtN));
        
	}
	// Lớp lắng nghe sự kiện cho các JRadioButton
	class RadioButtonHandler implements ItemListener {
	    private JTextField textField;

	    public RadioButtonHandler(JTextField textField) {
	        this.textField = textField;
	    }

	    @Override
	    public void itemStateChanged(ItemEvent e) {
	        // Kiểm tra xem JRadioButton được chọn
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	            // Lấy dữ liệu từ JRadioButton được chọn
	            JRadioButton selectedRadioButton = (JRadioButton) e.getItem();
	            // Kiểm tra và vô hiệu hóa các JTextField không được chọn
	            if (selectedRadioButton == rdbtnC) {
	                txtF.setEditable(false);
	                txtK.setEditable(false);
	                txtR.setEditable(false);
	                txtD.setEditable(false);
	                txtN.setEditable(false);
	            } else if (selectedRadioButton == rdbtnF) {
	                txtC.setEditable(false);
	                txtK.setEditable(false);
	                txtR.setEditable(false);
	                txtD.setEditable(false);
	                txtN.setEditable(false);
	            } else if (selectedRadioButton == rdbtnK) {
	                txtC.setEditable(false);
	                txtF.setEditable(false);
	                txtR.setEditable(false);
	                txtD.setEditable(false);
	                txtN.setEditable(false);
	            } else if (selectedRadioButton == rdbtnR) {
	                txtC.setEditable(false);
	                txtF.setEditable(false);
	                txtK.setEditable(false);
	                txtD.setEditable(false);
	                txtN.setEditable(false);
	            } else if (selectedRadioButton == rdbtnD) {
	                txtC.setEditable(false);
	                txtF.setEditable(false);
	                txtK.setEditable(false);
	                txtR.setEditable(false);
	                txtN.setEditable(false);
	            } else if (selectedRadioButton == rdbtnN) {
	                txtC.setEditable(false);
	                txtF.setEditable(false);
	                txtK.setEditable(false);
	                txtR.setEditable(false);
	                txtD.setEditable(false);
	            }
	            // Đặt lại text của textField
	            textField.setText("");
	            // Bật cờ cho phép sửa
	            textField.setEditable(true);
	         // Xóa bỏ chọn của các JRadioButton khác trong ButtonGroup
	            buttonGroup.getElements().asIterator().forEachRemaining(radioButton -> {
                    if (radioButton != e.getItem()) {
                        radioButton.setSelected(false);
                    }
                });
	        }
	    }
	}
	private void chuyenDoiCelsius() {
        double celsius = Double.parseDouble(txtC.getText());
        double fahrenheit = celsius * 9 / 5 + 32;
        double kelvin = celsius + 273.15;
        double rankine = (celsius + 273.15) * 9 / 5;
        double delisle = (100 - celsius) * 3 / 2;
        double newton = celsius * 33 / 100;
        // Hiển thị kết quả vào các JTextField tương ứng
        txtF.setText(String.format("%.2f", fahrenheit));
        txtK.setText(String.format("%.2f", kelvin));
        txtR.setText(String.format("%.2f", rankine));
        txtD.setText(String.format("%.2f", delisle));
        txtN.setText(String.format("%.2f", newton));
    }
	private void chuyenDoiFahrenheit() {
	    double fahrenheit = Double.parseDouble(txtF.getText());
	    double celsius = (fahrenheit - 32) * 5 / 9;
	    double kelvin = (fahrenheit + 459.67) * 5 / 9;
	    double rankine = fahrenheit + 459.67;
	    double delisle = (212 - fahrenheit) * 5 / 6;
	    double newton = (fahrenheit - 32) * 11 / 60;
	    // Hiển thị kết quả vào các JTextField tương ứng
	    txtC.setText(String.format("%.2f", celsius));
	    txtK.setText(String.format("%.2f", kelvin));
	    txtR.setText(String.format("%.2f", rankine));
	    txtD.setText(String.format("%.2f", delisle));
	    txtN.setText(String.format("%.2f", newton));
	}

	private void chuyenDoiKelvin() {
	    double kelvin = Double.parseDouble(txtK.getText());
	    double celsius = kelvin - 273.15;
	    double fahrenheit = kelvin * 9 / 5 - 459.67;
	    double rankine = kelvin * 9 / 5;
	    double delisle = (373.15 - kelvin) * 3 / 2;
	    double newton = (kelvin - 273.15) * 33 / 100;
	    // Hiển thị kết quả vào các JTextField tương ứng
	    txtC.setText(String.format("%.2f", celsius));
	    txtF.setText(String.format("%.2f", fahrenheit));
	    txtR.setText(String.format("%.2f", rankine));
	    txtD.setText(String.format("%.2f", delisle));
	    txtN.setText(String.format("%.2f", newton));
	}

	private void chuyenDoiRankine() {
	    double rankine = Double.parseDouble(txtR.getText());
	    double celsius = (rankine - 491.67) * 5 / 9;
	    double fahrenheit = rankine - 459.67;
	    double kelvin = rankine * 5 / 9;
	    double delisle = (671.67 - rankine) * 5 / 6;
	    double newton = (rankine - 491.67) * 11 / 60;
	    // Hiển thị kết quả vào các JTextField tương ứng
	    txtC.setText(String.format("%.2f", celsius));
	    txtF.setText(String.format("%.2f", fahrenheit));
	    txtK.setText(String.format("%.2f", kelvin));
	    txtD.setText(String.format("%.2f", delisle));
	    txtN.setText(String.format("%.2f", newton));
	}

	private void chuyenDoiDelisle() {
	    double delisle = Double.parseDouble(txtD.getText());
	    double celsius = 100 - delisle * 2 / 3;
	    double fahrenheit = 212 - delisle * 6 / 5;
	    double kelvin = 373.15 - delisle * 2 / 3;
	    double rankine = 671.67 - delisle * 6 / 5;
	    double newton = (33 - delisle) * 100 / 60;
	    // Hiển thị kết quả vào các JTextField tương ứng
	    txtC.setText(String.format("%.2f", celsius));
	    txtF.setText(String.format("%.2f", fahrenheit));
	    txtK.setText(String.format("%.2f", kelvin));
	    txtR.setText(String.format("%.2f", rankine));
	    txtN.setText(String.format("%.2f", newton));
	}

	private void chuyenDoiNewton() {
	    double newton = Double.parseDouble(txtN.getText());
	    double celsius = newton * 100 / 33;
	    double fahrenheit = newton * 60 / 11 + 32;
	    double kelvin = newton * 100 / 33 + 273.15;
	    double rankine = newton * 60 / 11 + 491.67;
	    double delisle = 33 - newton;
	    // Hiển thị kết quả vào các JTextField tương ứng
	    txtC.setText(String.format("%.2f", celsius));
	    txtF.setText(String.format("%.2f", fahrenheit));
	    txtK.setText(String.format("%.2f", kelvin));
	    txtR.setText(String.format("%.2f", rankine));
	    txtD.setText(String.format("%.2f", delisle));
	}

}
