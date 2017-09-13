import java.awt.EventQueue;

public class main {
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			frame start = new frame();
			start.setVisible(true);
		}
	});
}
}
