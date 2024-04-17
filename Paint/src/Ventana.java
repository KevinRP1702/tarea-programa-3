import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class Ventana extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    int x = 290, y = 190;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana window = new Ventana();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ventana() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Paint");
        frame.setBounds(100, 100, 638, 470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JPanel pnlLienzo = new JPanel(){
			@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D pinta = (Graphics2D)g;	
				pinta.setColor(Color.blue);
				pinta.fillRect(x,y,50,50);
			}
		};
        pnlLienzo.setBackground(new Color(128, 128, 192));
		frame.getContentPane().add(pnlLienzo);
		pnlLienzo.setBounds(0, 0, 622, 369);
		
		JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 128));
        panel.setBounds(0, 368, 622, 63);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnReinicio = new JButton("Reiniciar");
        btnReinicio.setBackground(new Color(255, 255, 255));
        btnReinicio.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReinicio.setBounds(248, 11, 132, 41);
        btnReinicio.setFocusable(false);
        panel.add(btnReinicio);

       frame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        
        switch(e.getKeyCode()) {
        case 87:
        	y -= 10;
        	break;
        	
        case 83:
        	y += 10;
        	break;
        	
        case 68:
        	x += 10;
        	break;
        	
        case 65:
        	x -=10;
        	break;
        	
        default:
       		break;
        }
        
        frame.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
     
    }
}
