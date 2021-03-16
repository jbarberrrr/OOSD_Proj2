package JBproj2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import JBproj2.Collection;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class JBproj2PlaylistPanel extends JPanel{
	private int count;

	public JBproj2PlaylistPanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		count = 0;
		setLayout(null);
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.BLACK);
	}
}