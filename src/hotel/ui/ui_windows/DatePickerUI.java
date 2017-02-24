package hotel.ui.ui_windows;

import java.awt.Component;
import java.sql.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import hotel.utils.DateLabelFormatter;

public class DatePickerUI{
    private SqlDateModel model; 
    private Properties p; 
    private JDatePanelImpl datePanel; 
    private JDatePickerImpl datePicker; 
    
    DatePickerUI(){
	this.model = new SqlDateModel();
	this.p = new Properties();
	initProperties();
	this.datePanel = new JDatePanelImpl(model, p);
	this.datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }
    
    private void initProperties(){
	p.put("text.today", "Today");
	p.put("text.month", "Month");
	p.put("text.year", "Year");
    }
    
    public Component getJDatePicker(){
	return this.datePicker;
    }
 
    public SqlDateModel getModel(){
	return (SqlDateModel) datePicker.getModel();
    }
    public Date getDate(){
	return (Date) datePicker.getModel().getValue();
    }
    

}
