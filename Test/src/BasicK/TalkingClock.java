package basick;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TalkingClock {
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep){
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start(){
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval,listener);
		t.start();
		
	}
	// inner class :even if inner class TimerPrinter is in class TalkClock,but it not means that every instance
	//of class TalkClock has a instance of inner class.
	public class TimePrinter implements ActionListener {
		public boolean beep=false;
        @Override
		public void actionPerformed(ActionEvent e) {
			Date now=new Date();
			System.out.println("At the tone,the time is "+now);
			if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
			//if(this.beep) Toolkit.getDefaultToolkit().beep();
			//if inner class also has beep property,we can use TalkingClock.this.beep 
			// inner class: beep or this.beep ; outer class : OuterClassName.this.propertyName
			
		}}
	
	public static void main(String[] args){
		TalkingClock clock=new TalkingClock(1000,true);
		clock.start();
		JOptionPane.showMessageDialog(null, "quit program");//
		System.out.println("if press the button, the program will stop!");
		
		TimePrinter time=clock.new TimePrinter();
		String s="OK";
		String s1=new String("OK");
		if(s.equals(s1)) System.out.println(s.hashCode()+"||"+s1.hashCode());
		System.exit(0);
	}
	
}

