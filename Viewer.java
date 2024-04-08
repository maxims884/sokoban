import javax.swing.JFrame;



public class Viewer {
    private Canvas canvas;
    private JFrame frame;
    Viewer() {
	Controller controller = new Controller(this);
	Model model = controller.getModel();
	canvas = new Canvas(model);

	frame = new JFrame("Sokoban Intern Labs");
	frame.setSize(800, 800);
	frame.setLocation(300, 0);
	frame.add("Center", canvas);
	frame.setVisible(true);
	frame.addKeyListener(controller);
    }

    public void update() {
	canvas.repaint();
    }

    public JFrame getMyFrame() {
	return frame;
    }
}