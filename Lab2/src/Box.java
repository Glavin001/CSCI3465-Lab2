import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class Box extends JComponent implements MouseListener, MouseMotionListener {
	
	public Color defaultColor;
	public Color hoverColor;
	private boolean hovering;
	private boolean dragging;
	private Point dragStartPoint;
	private Point offset;
	private double width;
	private double height;
	

	public void setDefaultColor(Color c)
	{
		defaultColor = c;
	}
	
	public Color getDefaultColor()
	{
		return defaultColor;
	}
	
	public Color getHoverColor()
	{
		return hoverColor;
	}
	
	
	public void setHoverColor(Color c)
	{
		hoverColor = c;
	}
	
	public Color getColor()
	{
		if (hovering)
		{
			return hoverColor;
		}
		else
		{
			return defaultColor;
		}
	}
	
	public Box()
	{
		// 
		defaultColor = Color.LIGHT_GRAY;
		hoverColor = Color.BLACK;
		hovering = false;
		
		//
		offset = new Point((int)this.getBounds().getX(),(int) this.getBounds().getY());
		width = 100;
		height = 100;
		
		//where initialization occurs:
        addMouseListener(this);
        addMouseMotionListener(this);

	}
	
	
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		/*
		int width = getWidth();
		int height = getHeight();
		int x = getX();
		int y = getY();
		*/
		
		//Rectangle2D r = new Rectangle2D.Double((new Double(width))/10, (new Double(height))/10, (new Double(width))*.8, (new Double(height))*.8);
		this.setBounds((int)offset.x,(int)offset.y,(int)width,(int)height);
		Rectangle2D r = new Rectangle2D.Double(0,0,(int)width,(int)height);
		//Rectangle2D r = new Rectangle2D.Double((double)x - (double) ((int)x), (double) y - (double) ((int)y), width, height);
		//g2.setBackground(getBackground());
		g2.setColor(getColor());
		//g2.fill3DRect(r.getX(), r.getY(), width, height, true);
		g2.fill(r);
		//g2.draw(r);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
		hovering = true;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
		hovering = false;
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
		dragging = true;
		dragStartPoint = event.getPoint();
		//dragStartPoint.x += offset.x;
		//dragStartPoint.y += offset.y;
		//repaint();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
		dragging = false;
		dragStartPoint = null;
		repaint();
	}
	
	public void mouseMoved(MouseEvent event) {
		System.out.println("mouseMoved");
		
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("mouseDragged");
		double dX = event.getPoint().x - dragStartPoint.x; 
		double dY = event.getPoint().y - dragStartPoint.y;
		System.out.println("dx: "+dX+", dy: "+dY);
		offset.x += dX;
		offset.y += dY;
		//dragStartPoint = event.getPoint();
		dragging = true;
		repaint();
	}
	
}