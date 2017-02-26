package hotel.ui.ui_windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import hotel.services.IndividualService;
import hotel.services.LegalEntityService;
import hotel.services.impl.IndividualServiceImpl;
import hotel.services.impl.LegalEntityServiceImpl;


public class NewClient extends JFrame{
    private JCheckBox legalEntity;
    private JCheckBox individual;
    private JLabel firstName;
    private JTextField fName;
    
    private JLabel surName;
    private JTextField sName;
    
    private JLabel patronimic;
    private JTextField patName;
    
    private JLabel phone;
    private JTextField phoneNum;
    
    private JLabel organisationName;
    private JTextField orgName;
    
    private JLabel business;
    private JTextField businessName;
    
    private JLabel sexLabel;    
    private JComboBox<String> sex;
    
    private JPanel panel;
    
    private JButton add;
    private JButton cancel;
    
    private LegalEntityService legalEntityService = new LegalEntityServiceImpl();
    private IndividualService individualService = new IndividualServiceImpl();
    
    
    
    
    public NewClient(){
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	legalEntity = new JCheckBox("����������");
	individual = new JCheckBox("�������� �����");
	firstName = new JLabel("��'�: ");
	fName = new JTextField();
	
	surName = new JLabel("�������: ");
	sName = new JTextField();
	
	patronimic = new JLabel("�� �������: ");
	patName = new JTextField();
	
	phone = new JLabel("�������: ");
	phoneNum = new JTextField();
	
	organisationName = new JLabel("����� ����������: ");
	orgName = new JTextField();
	orgName.setEditable(false);
	
	business = new JLabel("������: ");
	businessName = new JTextField();
	businessName.setEditable(false);
	
	sexLabel = new JLabel("�����: ");    
	sex = new JComboBox<String>();
	
	panel = new JPanel();
	
	add = new JButton("ADD");
	cancel = new JButton("CANCEL");	
	
	individual.setSelected(true);
	legalEntity.setSelected(false);
	
	sex.addItem("������");
	sex.addItem("Ƴ���");
	sex.setSelectedItem(0);
	
	fName.setToolTipText("����");
	sName.setToolTipText("������");
	patName.setToolTipText("��������");
	
	panel.setLayout(new GridLayout(0, 2, 0, 5));
	
	panel.add(firstName);
	panel.add(fName);
	
	panel.add(surName);
	panel.add(sName);
	
	panel.add(patronimic);
	panel.add(patName);
	panel.add(phone);
	panel.add(phoneNum);
	panel.add(organisationName);
	panel.add(orgName);
	panel.add(business);
	panel.add(businessName);
	panel.add(sexLabel);
	panel.add(sex);
	
	panel.add(individual);
	panel.add(legalEntity);
	
	panel.add(add);
	panel.add(cancel);
	
	individual.addActionListener(new ActionListener(){
	    
	    @Override
	    public void actionPerformed(ActionEvent e){
		if(individual.isSelected()){
		    legalEntity.setSelected(false);
		    businessName.setEditable(false);
		    orgName.setEditable(false);
		    sex.setEnabled(true);
		}
		else{
		    legalEntity.setSelected(true);
		    businessName.setEditable(true);
		    orgName.setEditable(true);
		    sex.setEnabled(false);
		}
	    }
	});
	
	legalEntity.addActionListener(new ActionListener(){
	    
	    @Override
	    public void actionPerformed(ActionEvent e){
		if(legalEntity.isSelected()){
		    individual.setSelected(false);
		    sex.setEnabled(false);
		    businessName.setEditable(true);
		    orgName.setEditable(true);
		    
		}
		else{
		    sex.setEnabled(true);
		    individual.setSelected(true);
		    businessName.setEditable(false);
		    orgName.setEditable(false);
		}
	    }
	});
	
	add.addActionListener(new ActionListener(){
	    
	    @Override
	    public void actionPerformed(ActionEvent e){
		if(legalEntity.isSelected()){
		    legalEntityService.add(
			    orgName.getText(),
			    businessName.getText(),
			    fName.getText()+";"+sName.getText()+";"+patName.getText(),			    
			    phoneNum.getText()
			    );
		    JOptionPane.showMessageDialog(null, "���� ���������� ������.");
		}
		else{
		    individualService.add(
			    fName.getText()+";"+sName.getText()+";"+patName.getText(),
			    sex.getSelectedItem().toString(),
			    phoneNum.getText()
			    );
		    JOptionPane.showMessageDialog(null, "���� ������� ����� ������.");
		}
		
		SwingUtilities.getWindowAncestor(add).dispose();		
	    }
	});
	cancel.addActionListener(new ActionListener(){
	    
	    @Override
	    public void actionPerformed(ActionEvent e){
		SwingUtilities.getWindowAncestor(cancel).dispose();
	    }
	});
	
	this.add(panel);
	this.pack();
    }
    
    
    
    public static void main(String[] args){
	NewClient n = new NewClient();
	n.setVisible(true);
    }
    
}
